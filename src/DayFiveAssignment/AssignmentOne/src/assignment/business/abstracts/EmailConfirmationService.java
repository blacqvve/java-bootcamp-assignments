package business.abstracts;

import entities.concretes.User;

public interface EmailConfirmationService {
    boolean confirmEmail(String token, User user);
}
