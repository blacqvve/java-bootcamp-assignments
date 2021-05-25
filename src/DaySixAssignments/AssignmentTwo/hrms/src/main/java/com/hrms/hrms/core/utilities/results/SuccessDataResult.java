package com.hrms.hrms.core.utilities.results;

public class SuccessDataResult<DataType> extends DataResult<DataType>{

    public SuccessDataResult(DataType data)
    {
        super(data,true);
    }
    
    public SuccessDataResult(DataType data, String message){
        super(data, true, message);
    }
}
