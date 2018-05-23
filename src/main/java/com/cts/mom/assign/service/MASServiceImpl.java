package com.cts.mom.assign.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.cts.mom.assign.model.Report;
import com.cts.mom.assign.Constants;
import com.cts.mom.assign.model.DepositRates;
import com.cts.mom.assign.model.Response;
import com.cts.mom.assign.util.PropertiesUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MASServiceImpl implements BusinessService {
	
	private static MASServiceImpl instance = null;
	private HttpClient client=null;
	private String baseUrl="";
	private String resourceId="";
	private String userAgent="";


	private MASServiceImpl() {
		try {
	    	client = HttpClientBuilder.create().build();
	        // add request header
			Properties prop = new PropertiesUtil().getProperty();
			userAgent = prop.getProperty(Constants.USER_AGENT);
			baseUrl = prop.getProperty(Constants.MAS_BASE_URL);
			resourceId = prop.getProperty(Constants.MAS_RESOURCE_ID);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static MASServiceImpl getInstance() {
		if(instance==null) {
			instance = new MASServiceImpl();
		}
		return instance;
		
	}
	@Override
	public Response getRatesBetween(String from, String to, int limit) throws Exception {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		String url = sb.append(baseUrl).append("?resource_id=").append(resourceId).append("&limit=").append(limit).append("&between[end_of_month]=").append(from).append(",").append(to).toString();
        HttpGet request = new HttpGet(url);
        request.addHeader("User-Agent", userAgent);
        HttpResponse response = client.execute(request);
        //System.out.println("Response Code : "
        //        + response.getStatusLine().getStatusCode());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);//.append("\n");
        }
        //System.out.println(result);
   	    ObjectMapper mapper = new ObjectMapper();
        Response resp = mapper.readValue(result.toString(),Response.class);

        String periodStr = from + " - " + to;
        resp.setPeriodStr(periodStr);
		return resp;
	}
	@Override
	public Report getReport(Response resp) throws Exception {
		// TODO Auto-generated method stub
		int total = resp.getResult().getTotal();
		List<DepositRates> resList = resp.getResult().getRecords();
		List<DepositRates> list = new ArrayList<DepositRates>();
		Report rept = new Report();
		rept.setAllList(resList);
		double meanBank3m, totalBank3m = 0.0;
		double meanFC3m, totalFC3m  = 0.0;
		
		double meanBank6m, totalBank6m = 0.0;
		double meanFC6m, totalFC6m = 0.0;

		double meanBank12m, totalBank12m = 0.0;
		double meanFC12m, totalFC12m = 0.0;
		double initLendingRates=0.0, lastLendingRates=0.0;
		
		for(int i=0;i<total;i++) {
			DepositRates dr = (DepositRates)resList.get(i);
			totalBank3m = totalBank3m + dr.getBanks_fixed_deposits_3m();
			totalFC3m = totalFC3m + dr.getFc_fixed_deposits_3m();
			
			totalBank6m = totalBank6m + dr.getBanks_fixed_deposits_6m();
			totalFC6m = totalFC6m + dr.getFc_fixed_deposits_6m();
			
			totalBank12m = totalBank12m + dr.getBanks_fixed_deposits_12m();
			totalFC12m = totalFC12m + dr.getFc_fixed_deposits_12m();
			//initial
			if(i==0) {
				initLendingRates = dr.getPrime_lending_rate();
				
			}
			//lastLendingRates
			if(i==total-1) {
				lastLendingRates=dr.getPrime_lending_rate();
			}
			
			//add those that FC saving deposit greater than Bank.
			if(dr.getFc_savings_deposits()>dr.getBanks_savings_deposits()) {
				list.add(dr);
			}
			
		}
		meanBank3m = totalBank3m/total;
		meanBank6m = totalBank6m/total;
		meanBank12m = totalBank12m/total;
		
		meanFC3m = totalFC3m/total;
		meanFC6m = totalFC6m/total;
		meanFC12m = totalFC12m/total;
		
		rept.setMean_Bank_fd_3m(meanBank3m);
		rept.setMean_Bank_fd_6m(meanBank6m);
		rept.setMean_Bank_fd_12m(meanBank12m);
		
		rept.setMean_FC_fd_3m(meanFC3m);
		rept.setMean_FC_fd_6m(meanFC6m);
		rept.setMean_FC_fd_12m(meanFC12m);
		
		rept.setFcHigherBankList(list);
		
		if(initLendingRates<lastLendingRates) {
			//uptrend
			rept.setLendRatesTrend(Constants.UP);
		}else if (initLendingRates>lastLendingRates) {
			//down trend
			rept.setLendRatesTrend(Constants.DOWN);
		}else {
			rept.setLendRatesTrend(Constants.NO);
		}
		
		rept.setPeriod(resp.getPeriodStr());
		
		return rept;
	}
	
	

	
}
