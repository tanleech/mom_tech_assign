package com.cts.mom.assign.view;

import java.util.List;

import com.cts.mom.assign.model.DepositRates;
import com.cts.mom.assign.model.Report;

public class ReportView {
	
	private Report rept;

	public Report getRept() {
		return rept;
	}

	public void setRept(Report rept) {
		this.rept = rept;
	}
	
	public String display() {
		StringBuffer sb = new StringBuffer();
		List<DepositRates>fcHigherList = rept.getFcHigherBankList();
		if(rept!=null) {
			//display the data
			sb.append("*********** REPORT **********\n");
			sb.append("For period: ").append(rept.getPeriod());
			sb.append("\n\nFollowing months which Financial Companies having higher saving rates:");
			for(int i=0;i<fcHigherList.size();i++) {
				sb.append("\n");
				sb.append(fcHigherList.get(i).getEnd_of_month());
				sb.append(String.format(" FC Saving Rates: %.2f Bank Saving Rates: %.2f", fcHigherList.get(i).getFc_savings_deposits(),fcHigherList.get(i).getBanks_savings_deposits()));
			}
			sb.append("\n\n");
			sb.append("Average Rates FC Vs Bank\n");
			sb.append("************************");
			sb.append(String.format("\nFC Average 3m FD: %.2f",rept.getMean_FC_fd_3m()));
			sb.append(String.format("\nBank Average 3m FD: %.2f",rept.getMean_Bank_fd_3m()));
			
			sb.append(String.format("\n\nFC Average 6m FD: %.2f",rept.getMean_FC_fd_6m()));
			sb.append(String.format("\nBank Average 6m FD: %.2f",rept.getMean_Bank_fd_6m()));
			
			sb.append(String.format("\n\nFC Average 12m FD: %.2f",rept.getMean_FC_fd_12m()));
			sb.append(String.format("\nBank Average 12m FD: %.2f",rept.getMean_Bank_fd_12m()));
			sb.append("\n\n");
			
			sb.append("Interest rate trend for the period: ").append(rept.getLendRatesTrend());
			sb.append("\n********* END **********\n");
			

			

			
		}
		
		
		return sb.toString();
	}

}
