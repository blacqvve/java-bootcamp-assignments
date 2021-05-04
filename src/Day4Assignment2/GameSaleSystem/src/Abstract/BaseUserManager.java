package Abstract;
import Interfaces.ApplicationUser;
import Interfaces.UserService;

public abstract class BaseUserManager<T extends ApplicationUser> implements UserService<T> {

    public void add(T user){
        System.out.println("New user added. UserID: "+ user.getUserId());
    }

    public void add(T[] users){
        for(T user:users){
            add(user);
        }
    }
    public void update(T user){
        System.out.println("User updated. UserID: " + user.getUserId());
    }
    
    public void delete(T user){
        System.out.println("User deleted. UserID: " + user.getUserId());
    }
}
