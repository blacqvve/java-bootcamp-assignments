package business.concretes.validators;

import business.abstracts.Validator;
import entities.concretes.User;

public class UserValidator implements Validator<User>{

    private Validator<String> emailValidator;

    private Validator<String> nameValidator;

    private Validator<String> passwordValidator;

    public UserValidator(Validator<String> emailValidator, Validator<String> nameValidator, Validator<String> passwordValidator) {
        this.emailValidator = emailValidator;
        this.nameValidator = nameValidator;
        this.passwordValidator = passwordValidator;
    }


    @Override
    public boolean validate(User user) {

        boolean nameValidated = nameValidator.validate(user.getName()) && nameValidator.validate(user.getSurname());

        boolean emailValidated = emailValidator.validate(user.getEmail());

        boolean passwordValidated = passwordValidator.validate(user.getPassword());

        return nameValidated && emailValidated && passwordValidated;
    }
    
}
