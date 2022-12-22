package service;

import model.User2;

public class EmailService {
    public void sendPlayWithFriendsEmail(User2 user){
        user.getEmailAddress().ifPresent(email -> System.out.println("Sending 'Play with Friends' email to " + email));
    }

    public void sendMakeMoreFriendsEmail(User2 user){
        user.getEmailAddress().ifPresent(email ->
                System.out.println("Sending 'Make More Friends' email to " + email));
    }

    public void sendVerifyYourEmail(User2 user){
        user.getEmailAddress().ifPresent(email ->
                System.out.println("Sending 'Verify Your Email' email to " + email));
    }
}
