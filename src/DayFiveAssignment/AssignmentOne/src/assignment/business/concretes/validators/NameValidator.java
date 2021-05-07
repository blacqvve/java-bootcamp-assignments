package business.concretes.validators;

import business.abstracts.Validator;

public class NameValidator implements Validator<String> {

    private static final int MIN_LETTER_COUNT = 2;

    @Override
    public boolean validate(String object) {

        int letterCount = 0;

        for (char chr : object.toCharArray()) {
            if (Character.isLetter(chr))
                letterCount++;
        }

        boolean valid = letterCount > MIN_LETTER_COUNT;
        
        System.out.println(object +" is a valid name or surname" + valid);
        return valid;
    }

}
