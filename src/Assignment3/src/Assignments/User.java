package Assignments;

public class User {
    private int id;
    private String name;
    private String surname;

    public User(int userId, String name, String surname) {
        this.id = userId;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getFullName(){
        return name + " " + surname;
    }

}
