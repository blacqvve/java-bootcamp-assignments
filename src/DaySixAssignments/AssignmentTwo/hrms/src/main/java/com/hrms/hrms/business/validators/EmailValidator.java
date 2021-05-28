package com.hrms.hrms.business.validators;

import java.util.regex.Pattern;

import com.hrms.hrms.core.utilities.validators.abstracts.Validator;

import org.springframework.stereotype.Component;


import java.util.regex.Matcher;

@Component("emailValidator")
public class EmailValidator implements Validator<String> {

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            Pattern.CASE_INSENSITIVE);

    @Override
    public boolean validate(String object) {

        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(object);

        boolean matchFound = matcher.find();

        String validationText = matchFound ? "valid" : "invalid";

        System.out.println(object + " is a " + validationText + " mail account");

        return matchFound;
    }

}
