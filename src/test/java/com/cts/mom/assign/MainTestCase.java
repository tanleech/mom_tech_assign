package com.cts.mom.assign;

import org.junit.jupiter.api.Test;

import com.cts.mom.assign.controller.ServiceController;

class MainTestCase {

	@Test
    void testForEmptyDates() {
		ServiceController controller = new ServiceController();
		String[] args= new String[2];
		try {
			controller.execute(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	@Test
    void testForWrongDateFormat() {
		ServiceController controller = new ServiceController();
		String[] args= new String[2];
		args[0]="JEN-2000";
		args[1]="DEN-2000";
		try {
			controller.execute(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	@Test
    void testForWrongDateRange() {
		ServiceController controller = new ServiceController();
		String[] args= new String[2];
		args[0]="JAN-2017";
		args[1]="DEC-2000";
		try {
			controller.execute(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
	@Test
    void testForHappyFlow() {
		ServiceController controller = new ServiceController();
		String[] args= new String[2];
		args[0]="JAN-2000";
		args[1]="DEC-2017";
		try {
			controller.execute(args);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	

}
