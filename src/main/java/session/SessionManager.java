package session;
import java.util.*;
import services.*;
import model.*;
import dao.*;

public class SessionManager {
    //Attributes
    private String verificationCode;
    private UserDetails user = null;
    private UserManager userManager;
    private DatabaseManager dbManager;
    private EmailService email;
    //Constructor
    public SessionManager(){
        dbManager = new DatabaseManager();
    }

    //Methods
    public UserDetails getUser(){
        return user;
    }

    public String createVCode(){
        Random object = new Random();
        int n = object.nextInt(9999999) + 1;
        verificationCode = Integer.toString(n); //Convert random int value to String
        return verificationCode;
    }

    public boolean sendVmail(String verificationCode) {
        email = new EmailService();
        return email.sendVerificationEmail(user.getFullName(), user.getEmail(),verificationCode);
    }

    public void signUp(UserDetails userTemp){
        String verifyCode = createVCode();
        sendVmail(verifyCode);
    }

    public boolean signIn(String email, String password){
        try {
            user = dbManager.getUser( email, password);
        }catch (Exception e){
            return false;
        }
        System.out.println("Log In Succesfull");
        return true;
    }
    public boolean logOut(){
        if(true) {
            user = null;
            return true;
        }
        else
            return false;
    }
    public boolean isAdmin(){
        return user.isAdmin();
    }

    public boolean verify(String vCode){
        return this.verificationCode.equals(vCode);
    }
}
