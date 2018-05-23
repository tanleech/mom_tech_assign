package com.cts.mom.assign.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import com.cts.mom.assign.Constants;

public class Util {
	
	public static String validateEmpty(String[] args){
		StringBuffer sb = new StringBuffer();
		Properties prop = new PropertiesUtil().getProperty();
		if(args==null||args.length==0) {
			sb.append(prop.getProperty(Constants.FROM_DT_EMPTY_ERR));
			sb.append(prop.getProperty(Constants.TO_DT_EMPTY_ERR));
			return sb.toString();
		}
		if(args[0]==null) {
			sb.append(prop.getProperty(Constants.FROM_DT_EMPTY_ERR));
		}	
		else if(args[1]==null) {
				sb.append(prop.getProperty(Constants.TO_DT_EMPTY_ERR));
		}
		return sb.toString();
	}
	
	public static String validateRange(String from, String to) {
		String err="";
		String[] fromArr = from.split("-");
		String[] toArr = to.split("-");
		Properties prop = new PropertiesUtil().getProperty();
		int fromInt = Integer.parseInt(fromArr[0]+fromArr[1]);
		int toInt = Integer.parseInt(toArr[0]+toArr[1]);
		if(toInt<fromInt) {
			err=prop.getProperty(Constants.DT_RANGE_ERR);			
		}
		return err;
	}
	
	public static String validateDateFormat(String dateStr) {
		String err="";
		DateFormat df = new SimpleDateFormat("MMM-yyyy");
		Properties prop = new PropertiesUtil().getProperty();
		
	    try{
	        df.parse(dateStr);
	    }
	    catch ( Exception ex ){
	    	err = prop.getProperty(Constants.DT_FORMAT_ERR);
	    }
	    return err;
	}
	
    public static String convertToNumMth(String mth) throws Exception {
    	boolean isFound = false;
    	int counter = 0;
    	String result="";
    	while(counter<Constants.MTHS.length&&!isFound) {
    		
    		if(mth.equalsIgnoreCase(Constants.MTHS[counter])) {
    			isFound=true;
    		}
    		else {
    			counter++;
    		}
    		
    	}
    	if (!isFound) {
    		throw new Exception();
    	}
    	
    	result = new Integer(counter+1).toString();
    	if(counter<10) {
    		result = "0"+result;
    	}
    	return result;
    }

}
