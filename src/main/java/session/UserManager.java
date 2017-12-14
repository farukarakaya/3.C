package session;
import model.*;
import dao.*;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    //Attributes
    private List<UserDetails> users;
    private DatabaseManager dbManager;

    //Constructor
    public UserManager(){
        users = new ArrayList<>();
        dbManager = new DatabaseManager();
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
    public boolean editUserInfo(UserDetails user){ //user => will it be dynamic?
        if(dbManager.createUser(user))
            return true;
        else
            return false;
    }
    //public List getUsers(){return dbManager.getUser()}
    public static void main(String []args) {
        DatabaseManager databaseManager = new DatabaseManager();
        UserDetails user = new UserDetails(1,"Omer","farukarakaya@gmail.com","12345",true);
        databaseManager.createUser(user);
    }
}
