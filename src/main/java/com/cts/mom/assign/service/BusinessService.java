package com.cts.mom.assign.service;

import java.util.List;

import com.cts.mom.assign.model.Report;
import com.cts.mom.assign.model.DepositRates;
import com.cts.mom.assign.model.Response;

/**
 * Adapter interface for HTTP Calls
 * 
 * @author Tan Lee Chiang
 *
 */
public interface BusinessService {
	
	public Response getRatesBetween(String from, String to, int limit)throws Exception;
	public Report getReport(Response resp)throws Exception;
	

}
