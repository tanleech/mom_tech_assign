package com.cts.mom.assign.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {

    public void setResource_Id(String[] resource_Id) {
        this.resource_Id = resource_Id;
    }

    @JsonProperty("resource_id")
    private String[] resource_Id;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("total")
    private int total;
    @JsonProperty("records")
    private List<DepositRates> records;


    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DepositRates> getRecords() {
        return records;
    }

    public void setRecords(List<DepositRates> records) {
        this.records = records;
    }

}
