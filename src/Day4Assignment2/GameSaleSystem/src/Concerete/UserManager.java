package Concerete;

import Abstract.BaseUserManager;
import Entities.User;

public class UserManager extends BaseUserManager<User> {
    
    @Override
    public void update(User user) {
        System.out.println("User updated. New information is: "+ user.getEmail());
        super.update(user);
    }
}
