package com.cts.mom.assign.model;

public class DepositRates {
    private String end_of_month;
    private double prime_lending_rate;
    private double banks_fixed_deposits_3m;
    private double banks_fixed_deposits_6m;
    private double banks_fixed_deposits_12m;
    private double banks_savings_deposits;
    private double fc_hire_purchase_motor_3y;
    private double fc_housing_loans_15y;
    private double fc_fixed_deposits_3m;
    private double fc_fixed_deposits_6m;
    private double fc_fixed_deposits_12m;
    private double fc_savings_deposits;
    private String timestamp;

    public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public double getBanks_fixed_deposits_6m() {
        return banks_fixed_deposits_6m;
    }

    public void setBanks_fixed_deposits_6m(double banks_fixed_deposits_6m) {
        this.banks_fixed_deposits_6m = banks_fixed_deposits_6m;
    }

    public double getBanks_fixed_deposits_12m() {
        return banks_fixed_deposits_12m;
    }

    public void setBanks_fixed_deposits_12m(double banks_fixed_deposits_12m) {
        this.banks_fixed_deposits_12m = banks_fixed_deposits_12m;
    }

    public double getBanks_savings_deposits() {
        return banks_savings_deposits;
    }

    public void setBanks_savings_deposits(double banks_savings_deposits) {
        this.banks_savings_deposits = banks_savings_deposits;
    }

    public double getFc_hire_purchase_motor_3y() {
        return fc_hire_purchase_motor_3y;
    }

    public void setFc_hire_purchase_motor_3y(double fc_hire_purchase_motor_3y) {
        this.fc_hire_purchase_motor_3y = fc_hire_purchase_motor_3y;
    }

    public double getFc_housing_loans_15y() {
        return fc_housing_loans_15y;
    }

    public void setFc_housing_loans_15y(double fc_housing_loans_15y) {
        this.fc_housing_loans_15y = fc_housing_loans_15y;
    }

    public double getFc_fixed_deposits_3m() {
        return fc_fixed_deposits_3m;
    }

    public void setFc_fixed_deposits_3m(double fc_fixed_deposits_3m) {
        this.fc_fixed_deposits_3m = fc_fixed_deposits_3m;
    }

    public double getFc_fixed_deposits_6m() {
        return fc_fixed_deposits_6m;
    }

    public void setFc_fixed_deposits_6m(double fc_fixed_deposits_6m) {
        this.fc_fixed_deposits_6m = fc_fixed_deposits_6m;
    }

    public double getFc_fixed_deposits_12m() {
        return fc_fixed_deposits_12m;
    }

    public void setFc_fixed_deposits_12m(double fc_fixed_deposits_12m) {
        this.fc_fixed_deposits_12m = fc_fixed_deposits_12m;
    }

    public double getFc_savings_deposits() {
        return fc_savings_deposits;
    }

    public void setFc_savings_deposits(double fc_savings_deposits) {
        this.fc_savings_deposits = fc_savings_deposits;
    }

    public String getEnd_of_month() {
        return end_of_month;
    }

    public void setEnd_of_month(String end_of_month) {
        this.end_of_month = end_of_month;
    }

    public double getPrime_lending_rate() {
        return prime_lending_rate;
    }

    public void setPrime_lending_rate(double prime_lending_rate) {
        this.prime_lending_rate = prime_lending_rate;
    }

    public double getBanks_fixed_deposits_3m() {
        return banks_fixed_deposits_3m;
    }

    public void setBanks_fixed_deposits_3m(double banks_fixed_deposits_3m) {
        this.banks_fixed_deposits_3m = banks_fixed_deposits_3m;
    }
}
