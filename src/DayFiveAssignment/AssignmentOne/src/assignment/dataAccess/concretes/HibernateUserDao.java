package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import core.LoggerService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

    List<User> users = new ArrayList<User>();

    private LoggerService logger;

    public HibernateUserDao(LoggerService logger){
        this.logger = logger;
    }

    @Override
    public void add(User user) {
        users.add(user);
        logger.log("User added " + user.getId());

    }

    @Override
    public void update(User user) {
        var existingUser = users.stream().filter(x -> x.getId() == user.getId()).findAny().orElse(null);

        if (existingUser == null)
        {
            logger.log("User not found " + user.getId());
            return;
        }
        existingUser = user;

        logger.log("User updated " + user.getId());

    }

    @Override
    public void delete(User user) {

        if (users.contains(user)){
            users.remove(user);
            logger.log("User deleted "+ user.getId());
        }

    }

    @Override
    public User get(int id) {
    
        return users.stream().filter(x -> x.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(users);
    }

}
