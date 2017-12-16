package model;
import dao.*;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    //Attributes
    private List<User> users;
    private DatabaseManager dbManager;

    //Constructor
    public UserManager(){
        users = new ArrayList<User>();
    }
    public static void createUser( String fullName, String email, String password, boolean isAdmin){
        User user = new User(fullName,email,password,isAdmin);
        DatabaseManager.createUser(user);
    }

    //Methods
    public boolean deleteUser(int targetUserID) {
        if(dbManager.deleteUser(targetUserID))
            return true;
        else
            return false;
    }
   /*       public boolean changePassword(){
       if(dbManager.createUser(user))
            return true;
        else
            return false;
    }*/
    public boolean editUserInfo(User user){ //user => will it be dynamic?
        if(dbManager.createUser(user))
            return true;
        else
            return false;
    }
    //public List getUsers(){return dbManager.getUser()}
    public static void main(String []args) {
        User user = new User("Omer","farukarakaya@gmail.com","12345",true);
        DatabaseManager.createUser(user);
    }
}
