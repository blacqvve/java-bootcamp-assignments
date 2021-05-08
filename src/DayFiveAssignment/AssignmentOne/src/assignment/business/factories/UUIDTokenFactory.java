package business.factories;

import java.util.UUID;

import business.abstracts.TokenFactory;
import core.LoggerService;

public class UUIDTokenFactory implements TokenFactory {

    private LoggerService logger;

    public UUIDTokenFactory(LoggerService logger){
        this.logger = logger;
    }
    @Override
    public String generateConfirmationToken() {
        String uuid = UUID.randomUUID().toString();
        logger.log("New token generated "+ uuid);
        return uuid;
    }
    
}
