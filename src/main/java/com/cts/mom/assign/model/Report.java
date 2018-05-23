package com.cts.mom.assign.model;

import java.util.List;

public class Report{
	
    private double mean_Bank_fd_3m;
    private double mean_Bank_fd_6m;
    private double mean_Bank_fd_12m;
    
    private double mean_FC_fd_3m;
    private double mean_FC_fd_6m;
    private double mean_FC_fd_12m;
    
    private String lendRatesTrend;
    
    private List<DepositRates> fcHigherBankList;
    
    private List<DepositRates> allList;
    
    private String period;
    
    
    
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public List<DepositRates> getAllList() {
		return allList;
	}
	public void setAllList(List<DepositRates> allList) {
		this.allList = allList;
	}
	public List<DepositRates> getFcHigherBankList() {
		return fcHigherBankList;
	}
	public void setFcHigherBankList(List<DepositRates> fcHigherBankList) {
		this.fcHigherBankList = fcHigherBankList;
	}
	public String getLendRatesTrend() {
		return lendRatesTrend;
	}
	public void setLendRatesTrend(String lendRatesTrend) {
		this.lendRatesTrend = lendRatesTrend;
	}
	public double getMean_Bank_fd_3m() {
		return mean_Bank_fd_3m;
	}
	public void setMean_Bank_fd_3m(double mean_Bank_fd_3m) {
		this.mean_Bank_fd_3m = mean_Bank_fd_3m;
	}
	public double getMean_Bank_fd_6m() {
		return mean_Bank_fd_6m;
	}
	public void setMean_Bank_fd_6m(double mean_Bank_fd_6m) {
		this.mean_Bank_fd_6m = mean_Bank_fd_6m;
	}
	public double getMean_Bank_fd_12m() {
		return mean_Bank_fd_12m;
	}
	public void setMean_Bank_fd_12m(double mean_Bank_fd_12m) {
		this.mean_Bank_fd_12m = mean_Bank_fd_12m;
	}
	public double getMean_FC_fd_3m() {
		return mean_FC_fd_3m;
	}
	public void setMean_FC_fd_3m(double mean_FC_fd_3m) {
		this.mean_FC_fd_3m = mean_FC_fd_3m;
	}
	public double getMean_FC_fd_6m() {
		return mean_FC_fd_6m;
	}
	public void setMean_FC_fd_6m(double mean_FC_fd_6m) {
		this.mean_FC_fd_6m = mean_FC_fd_6m;
	}
	public double getMean_FC_fd_12m() {
		return mean_FC_fd_12m;
	}
	public void setMean_FC_fd_12m(double mean_FC_fd_12m) {
		this.mean_FC_fd_12m = mean_FC_fd_12m;
	}
    
    

}
