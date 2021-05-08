package core;

public interface EmailService {
    void sendConfirmationEmail(String to);

    String sendConfirmationEmailWithToken(String to);
}
