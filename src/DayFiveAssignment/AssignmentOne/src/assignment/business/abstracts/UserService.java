package business.abstracts;

import entities.concretes.User;

public interface UserService {
    
    void register(User user);

    void login(User user);
}
