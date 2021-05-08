package business.concretes.managers;

import java.util.List;

import business.abstracts.UserService;
import business.abstracts.Validator;
import core.EmailService;
import core.LoggerService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

    private UserDao userDao;
    
    private Validator<User> userValidator;

    private LoggerService logger;

    private EmailService emailService;
    

    public UserManager(UserDao userDao,Validator<User> uValidator,LoggerService logger, EmailService emailService){
        this.userDao = userDao;
        this.userValidator = uValidator;
        this.logger = logger;
        this.emailService = emailService;
    }

    @Override
    public void register(User user) {
        
        if(checkIsDuplicateEmailAddress(user.getEmail()))
        {
           logger.log(user.getEmail() + " is already in use");
            return;
        }

       if (userValidator.validate(user))
       {
           user.setConfirmationToken(emailService.sendConfirmationEmailWithToken(user.getEmail()));
           userDao.add(user);
           logger.log("Register successfull " + user.getId());
       }
    }

    @Override
    public void update(User user) {
        if(user == null) {
            logger.log("user sent for update is null");

            return;
        }
        userDao.update(user);
    }
    
    @Override
    public User getUser(int id){
        return null;
    }

    
    @Override
    public User getUser(String email) {
        List<User> users = userDao.getAll();
        
        User requestedUser = users.stream().filter(x -> x.getEmail().toLowerCase() == email.toLowerCase()).findAny().orElse(null);

        return requestedUser;
    }
    private boolean checkIsDuplicateEmailAddress(String email){

        List<User> users = userDao.getAll();

        var possibleDuplicate = users.stream().filter(x -> x.getEmail().toLowerCase() == email.toLowerCase()).findAny().orElse(null);

        return possibleDuplicate != null;
    }



}
