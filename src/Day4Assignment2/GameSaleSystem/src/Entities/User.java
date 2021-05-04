package Entities;

import Interfaces.ApplicationUser;

public class User implements ApplicationUser{
    private int id;

    private String email;

    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getUserId() {
        return this.id;
    }
    
}
