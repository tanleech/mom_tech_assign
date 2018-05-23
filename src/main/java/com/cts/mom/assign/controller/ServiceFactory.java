package com.cts.mom.assign.controller;

import com.cts.mom.assign.Constants;
import com.cts.mom.assign.service.BusinessService;
import com.cts.mom.assign.service.MASServiceImpl;

public class ServiceFactory {
	
	public BusinessService createBusiness(String type) {
		BusinessService service = null;
		if(type!=null&&type.equals(Constants.MAS)) {
			service = MASServiceImpl.getInstance();
		}
		return service;
	}

}
