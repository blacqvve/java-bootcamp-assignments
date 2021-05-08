package business.adapters;

import business.abstracts.LoginServiceProvider;
import core.LoggerService;
import entities.concretes.User;

public class GoogleAuthAdapter implements LoginServiceProvider{

    private LoggerService logger;

    public GoogleAuthAdapter(LoggerService logger) {
        this.logger = logger;
    }

    @Override
    public boolean login(User user) {
        
        logger.log("Google auth successfull");
        return true;
    }
    
}
