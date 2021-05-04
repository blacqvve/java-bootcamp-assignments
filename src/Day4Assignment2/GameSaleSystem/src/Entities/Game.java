package Entities;

public class Game {
    private int id;

    private String title;

    private User publisher;

    private User developer;

    private double price;

    private String category;

    public Game(Game game) {
        this(game.getId(), game.getTitle(), game.getPublisher(), game.getDeveloper(), game.getPrice(),
                game.getCategory());
    }

    public Game(int id, String title, User publisher, User developer, double price, String category) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.developer = developer;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getPublisher() {
        return this.publisher;
    }

    public void setPublisher(User publisher) {
        this.publisher = publisher;
    }

    public User getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(User developer) {
        this.developer = developer;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
