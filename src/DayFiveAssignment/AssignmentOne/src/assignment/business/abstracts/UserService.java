package business.abstracts;

import entities.concretes.User;

public interface UserService extends RegisterServiceProvider {
    
    void register(User user);

    void update(User user);
    
    User getUser(int id);

    User getUser(String email);
}
