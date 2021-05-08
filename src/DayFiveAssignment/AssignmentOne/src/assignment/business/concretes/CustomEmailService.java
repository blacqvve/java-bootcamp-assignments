package business.concretes;

import business.abstracts.TokenFactory;
import core.EmailService;
import core.LoggerService;

public class CustomEmailService implements EmailService {

    private LoggerService logger;

    private TokenFactory tokenFactory;

    public CustomEmailService(LoggerService logger)
    {
        this.logger = logger;
    }
    public CustomEmailService(LoggerService logger,TokenFactory tokenFactory){
        this(logger);
        this.tokenFactory = tokenFactory;
    }

    @Override
    public void sendConfirmationEmail(String to) {
        logger.log("Confirmation email sent to " + to);
    }

    @Override
    public String sendConfirmationEmailWithToken(String to) {

        String emailToken = tokenFactory.generateConfirmationToken();
        logger.log("Confirmation email sent to " + to + " with " + emailToken +" token");
        
        return emailToken;
        
    }
    
}
