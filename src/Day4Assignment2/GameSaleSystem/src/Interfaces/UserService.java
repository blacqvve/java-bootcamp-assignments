package Interfaces;

public interface UserService<T extends ApplicationUser> {

     void  add(T user);

     void add(T[] users);

     void  update(T user);

     void  delete(T user);
}
