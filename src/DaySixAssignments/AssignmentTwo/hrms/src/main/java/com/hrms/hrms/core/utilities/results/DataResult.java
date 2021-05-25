package com.hrms.hrms.core.utilities.results;

public class DataResult<T> extends Result {

    private T data;

    public DataResult(T data, boolean isSuccess) {
        super(isSuccess);
        setData(data);
    }

    public DataResult(T data, boolean isSuccess, String message) {
        super(isSuccess, message);
        setData(data);
    }

    
    private void setData(T data)
    {
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
}
