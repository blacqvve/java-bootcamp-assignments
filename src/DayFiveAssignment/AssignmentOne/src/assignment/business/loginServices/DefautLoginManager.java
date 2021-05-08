package business.loginServices;

import business.abstracts.LoginServiceProvider;
import business.abstracts.UserService;
import core.LoggerService;
import entities.concretes.User;

public class DefautLoginManager implements LoginServiceProvider {

    private UserService userService;

    private LoggerService logger;

    public DefautLoginManager(UserService userService, LoggerService logger) {
        this.userService = userService;
        this.logger = logger;
    }

    @Override
    public boolean login(User user) {
        User matchingUser = userService.getUser(user.getEmail());

        if (matchingUser == null) {
            logger.log("Invalid email address");
            return false;
        }
        if(isEmailAndPasswordMatch(user, matchingUser)){
            logger.log("Login successfull");
            return true;
        }

        logger.log("Invalid password");
        return false;
    }

    boolean isEmailAndPasswordMatch(User requestInfo, User matchingUser) {

        return requestInfo.getEmail().toLowerCase() == matchingUser.getEmail().toLowerCase()
                && requestInfo.getPassword() == matchingUser.getPassword();
    }

}
