package com.cts.mom.assign.controller;

import com.cts.mom.assign.Constants;
import com.cts.mom.assign.model.Report;
import com.cts.mom.assign.model.Response;
import com.cts.mom.assign.service.BusinessService;
import com.cts.mom.assign.util.Util;
import com.cts.mom.assign.view.ReportView;

public class ServiceController {
	
	public void execute(String[] args) throws Exception{
		
        try {

        	//validate for empty
    		if(!Util.validateEmpty(args).isEmpty()) {
    			System.out.println("Error : "+Util.validateEmpty(args));    	
    			return;
    		}
    		//check whether the dates format are correct
    		if(!Util.validateDateFormat(args[0]).isEmpty()) {
    			System.out.println(String.format("Error : %s is %s",args[0],Util.validateDateFormat(args[0])));
    			
        		if(!Util.validateDateFormat(args[1]).isEmpty()) {
        			System.out.println(String.format("Error : %s is %s",args[1],Util.validateDateFormat(args[1])));
        		}
    			return;
    		}
        	
        	StringBuffer sb = new StringBuffer();
    		String fromYr = args[0].split("-")[1];
    		String fromMth = Util.convertToNumMth(args[0].split("-")[0]);
    		
    		String fromStr = sb.append(fromYr).append("-").append(fromMth).toString();
    		
    		String toYr = args[1].split("-")[1];
    		String toMth = Util.convertToNumMth(args[1].split("-")[0]);
    		
    		//clear the stringbuffer
    		sb.delete(0, sb.length());
    		String toStr = sb.append(toYr).append("-").append(toMth).toString();
    		
    		
    		//check for DateRange
    		if(!Util.validateRange(fromStr, toStr).isEmpty()) {
        		System.out.println("Error: "+Util.validateRange(fromStr, toStr));
    			return;
    		}

    		
    		
        	BusinessService bs =  new ServiceFactory().createBusiness(Constants.MAS);
           	int limit = 100;
           	Response resp = bs.getRatesBetween(fromStr, toStr,limit);
           	int total = resp.getResult().getTotal();
           	if(total>limit) {
           		resp = bs.getRatesBetween(fromStr, toStr,total);
           	}
            Report rept = bs.getReport(resp);
            ReportView view = new ReportView();
            view.setRept(rept);
            System.out.println(view.display());
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	}

}
