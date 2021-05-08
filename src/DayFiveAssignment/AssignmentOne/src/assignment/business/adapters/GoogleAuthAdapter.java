package business.adapters;

import business.abstracts.LoginServiceProvider;
import business.abstracts.RegisterServiceProvider;
import core.LoggerService;
import entities.concretes.User;

public class GoogleAuthAdapter implements LoginServiceProvider,RegisterServiceProvider{

    private LoggerService logger;

    public GoogleAuthAdapter(LoggerService logger) {
        this.logger = logger;
    }

    @Override
    public boolean login(User user) {
        
        logger.log("Google auth successfull");
        return true;
    }

    @Override
    public void register(User user) {
        logger.log("Google register succesfull");        
    }
    
}
