package com.cts.mom.assign;
import com.cts.mom.assign.controller.ServiceController;

public class Main {

	private final static String[] MTHS = {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};

    public static void main(String[] args) {
    	
         try {
			new ServiceController().execute(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    

}
