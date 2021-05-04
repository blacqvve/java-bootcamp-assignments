package Concerete;

import Entities.User;
import Interfaces.PersonValidityService;

public class UserValidationManager implements PersonValidityService<User> {

    @Override
    public boolean checkPersonValidity(User user) {

        System.out.println("User validated. User: " + user.getUserId());
        return true;
    }
    
}
