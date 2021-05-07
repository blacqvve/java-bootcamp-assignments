package business.abstracts;

import entities.concretes.User;

public interface LoginServiceProvider {
    boolean login(User user);
}
