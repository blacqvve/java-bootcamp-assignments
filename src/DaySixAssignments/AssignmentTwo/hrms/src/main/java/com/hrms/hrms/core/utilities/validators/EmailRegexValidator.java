package com.hrms.hrms.core.utilities.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class EmailRegexValidator {
    
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile(
            "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            Pattern.CASE_INSENSITIVE);

            
    public static boolean validateEmail(String email){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);

        boolean matchFound = matcher.find();

        String validationText = matchFound ? "valid" : "invalid";

        System.out.println(email + " is a " + validationText + " mail account");

        return matchFound;
    }
}
