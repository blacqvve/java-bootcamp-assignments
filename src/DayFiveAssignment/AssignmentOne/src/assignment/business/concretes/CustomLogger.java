package business.concretes;

import core.LoggerService;

public class CustomLogger implements LoggerService {

    @Override
    public void log(String message) {

        System.out.println("Custom Logger : " + message);
        
    }
    
}
