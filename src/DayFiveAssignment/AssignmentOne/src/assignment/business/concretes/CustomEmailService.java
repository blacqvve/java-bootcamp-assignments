package business.concretes;

import java.util.UUID;

import core.EmailService;
import core.LoggerService;

public class CustomEmailService implements EmailService {

    private LoggerService logger;

    public CustomEmailService(LoggerService logger)
    {
        this.logger = logger;
    }

    @Override
    public String sendConfirmationEmail(String to) {
        String emailToken = UUID.randomUUID().toString();

        logger.log("Confirmation email sent to " + to + " with " + emailToken +" token");

        return emailToken;
    }
    
}
