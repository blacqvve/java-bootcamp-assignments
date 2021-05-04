package Entities;

public class PublisherUser extends User{

    private String publisherName;


    public PublisherUser(int id,String email,String publisherName) {
        super(id,email);
        this.publisherName = publisherName;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

}
