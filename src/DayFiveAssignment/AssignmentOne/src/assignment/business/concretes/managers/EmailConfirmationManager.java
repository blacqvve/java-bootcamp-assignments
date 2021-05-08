package business.concretes.managers;

import business.abstracts.EmailConfirmationService;
import business.abstracts.UserService;
import core.LoggerService;
import entities.concretes.User;

public class EmailConfirmationManager implements EmailConfirmationService{

    private LoggerService logger;
    private UserService userService;

    public EmailConfirmationManager(LoggerService logger, UserService userService) {
        this.logger = logger;
        this.userService = userService;
        
    }

    @Override
    public boolean confirmEmail(String token, User user) {
        if (token == user.getConfirmationToken() && !user.isEmailConfirmed()){
            user.setEmailConfirmed(true);
            userService.update(user);
            logger.log("Email confirmed succesfully " + user.getId());
            return true;
        }

        logger.log("Invalid token");

        return false;
    }
    
}
