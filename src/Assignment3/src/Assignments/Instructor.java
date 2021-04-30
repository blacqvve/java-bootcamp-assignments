package Assignments;

public class Instructor extends User {

    private String shortBio;

    public Instructor(int userId, String name, String surname, String shortBio) {
        super(userId, name, surname);
        this.shortBio = shortBio;
    }

    public Instructor(int userId, String name, String surname) {
        super(userId, name, surname);
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }
}
