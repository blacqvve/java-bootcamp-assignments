package com.hrms.hrms.business.validators;

import java.util.regex.Pattern;

import com.hrms.hrms.core.utilities.validators.EmailRegexValidator;
import com.hrms.hrms.core.utilities.validators.abstracts.Validator;

import org.springframework.stereotype.Component;


import java.util.regex.Matcher;

@Component("emailValidator")
public class EmailValidator implements Validator<String> {

    @Override
    public boolean validate(String emailAdress) {

        return EmailRegexValidator.validateEmail(emailAdress);
    }

}
