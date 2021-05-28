package com.hrms.hrms.business.validators;

import com.hrms.hrms.core.utilities.BasicTuple;
import com.hrms.hrms.core.utilities.validators.EmailRegexValidator;
import com.hrms.hrms.core.utilities.validators.abstracts.Validator;

import org.springframework.stereotype.Component;

@Component("domainEmailValidator")
public class EmailDomainValidator implements Validator<BasicTuple<String,String>> {

    @Override
    public boolean validate(BasicTuple<String, String> object) {
        if(!EmailRegexValidator.validateEmail(object.getItem1())){
            return false;
        }

        String[] splitedMail = object.getItem2().split("@");

        String domainPart = splitedMail[splitedMail.length-1];

        return object.getItem2().contains(domainPart);
    }
    
}
