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
        return letterCount > MIN_LETTER_COUNT;
    }

}
