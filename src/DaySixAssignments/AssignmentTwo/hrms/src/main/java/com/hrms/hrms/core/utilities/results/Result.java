package com.hrms.hrms.core.utilities.results;

public class Result {
    private boolean isSuccess;
    
    private String resultMessage;

    public Result(boolean isSuccess)
    {
        this.isSuccess = isSuccess;
    }

    public Result(boolean isSuccess, String message){
        this(isSuccess);
        this.resultMessage = message;
    }

    public boolean isSuccess()
    {
        return this.isSuccess;
    }
    public String getResultMessage(){
        return this.resultMessage;
    }
}
