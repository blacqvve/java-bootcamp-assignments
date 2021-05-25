package com.hrms.hrms.core.utilities.results;

public class ErrorDataResult<DataType> extends DataResult<DataType>{

    public ErrorDataResult(DataType data)
    {
        super(data,false);
    }
    
    public ErrorDataResult(DataType data, String message){
        super(data, false, message);
    }
    
    public ErrorDataResult(String message){
        super(null,false,message);
    }

    public ErrorDataResult(){
        super(null,false);
    }
}
