package business.concretes.validators;

import business.abstracts.Validator;

public class PasswordValidator implements Validator<String> {

    private static final int MIN_PASSWORD_LENGHT = 6;

    @Override
    public boolean validate(String object) {
        
        boolean valid = object.length() > MIN_PASSWORD_LENGHT;

        System.out.println(object + "is valid password " + valid );
        return valid;
    }
    
}
