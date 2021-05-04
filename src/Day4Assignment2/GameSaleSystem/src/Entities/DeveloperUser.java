package Entities;

public class DeveloperUser extends User {

    private String name;

    private Game[] games;

    public DeveloperUser (int id, String email, String name){
        super(id, email);
        this.name = name;
    }

    public DeveloperUser(int id, String email, String name, Game[] games) {
        this(id, email, name);
        this.games = games;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game[] getGames() {
        return this.games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }

}
