package business.concretes.validators;

import business.abstracts.Validator;

public class PasswordValidator implements Validator<String> {

    private static final int MIN_PASSWORD_LENGHT = 6;

    @Override
    public boolean validate(String object) {
        
        return object.length() > MIN_PASSWORD_LENGHT;
    }
    
}
