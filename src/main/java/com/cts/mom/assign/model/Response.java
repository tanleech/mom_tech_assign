package com.cts.mom.assign.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("success")
    private String success;
    @JsonProperty("result")
    private Result result;

    private String periodStr;
    
    public String getPeriodStr() {
		return periodStr;
	}

	public void setPeriodStr(String periodStr) {
		this.periodStr = periodStr;
	}

	public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }


    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
