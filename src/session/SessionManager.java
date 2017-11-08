package session;
import java.util.*;
import services.*;
import model.*;
import dao.*;

public class SessionManager {
    //Attributes
    private String verificationCode;
    private UserDetails userTemp;
    private UserManager userManager;
    private DatabaseManager dbManager;
    private EmailService email;
    //Constructor
    public SessionManager(){
        userTemp = new UserDetails();
        dbManager = new DatabaseManager();
    }

    //Methods
    public UserDetails getUserDetails(int userID){
        userTemp = dbManager.getUser(userID);
        if (userTemp == null)
            return null;
        else
            return userTemp;
    }

    public String createVCode(){
        Random object = new Random();
        int n = object.nextInt(9999999) + 1;
        verificationCode = Integer.toString(n); //Convert random int value to String
        return verificationCode;
    }

    public boolean sendVmail(String verificationCode) {
        email = new EmailService();
        return email.sendVerificationEmail(userTemp.getFullName(),userTemp.getEmail(),verificationCode);
    }

    public boolean signUp(UserDetails userTemp){
        this.userTemp = userTemp;
        String verifyCode = createVCode();
        return sendVmail(verifyCode);
    }

    public boolean signIn(String fullName, String password){
        UserDetails check = dbManager.getUser(userTemp.getEmail(), userTemp.getPassword());
        if(check == null) {
            return false;
        }
        else {
            userTemp = check;
            return true;
        }
    }

    public boolean verify(String vCode){
        return this.verificationCode.equals(vCode);
    }
}
