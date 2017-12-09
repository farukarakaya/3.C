package session;
import model.*;
import dao.*;
public class UserManager {
    //Attributes
    private UserDetails user;
    private DatabaseManager dbManager;

    //Constructor
    public UserManager(){
        //Default constructor
        user = new UserDetails();
        dbManager = new DatabaseManager();
    }

    //Methods
    public boolean deleteUser(int targetUserID) {
        if(dbManager.deleteUser(targetUserID))
            return true;
        else
            return false;
    }

    public boolean createAnnouncement(Announcement announcement){//Will announcement object be dynamic?
        if(dbManager.createAnnouncement(announcement))
            return true;
        else
            return false;
    }

    public boolean deleteAnnouncement(int announcementID){
        if(dbManager.deleteAnnouncement(announcementID))
            return true;
        else
            return false;
    }

    public void setUser(UserDetails user){
        this.user = user;
    }

    public UserDetails getUser(){
        return user;
    }

    public boolean deleteAccount(){
        return dbManager.deleteUser(user.getId());
    }

    public boolean changePassword(){
        if(dbManager.createUser(user))
            return true;
        else
            return false;
    }

    public boolean logOut(){
        if(true) {
            user = null;
            return true;
        }
        else
            return false;
    }

    public boolean editAnnouncement(Announcement announcement){ //dynamic announcement object?
        if( dbManager.createAnnouncement(announcement))
            return true;
        else
            return false;
    }

    public boolean editUserInfo(UserDetails user){ //user => will it be dynamic?
        if(dbManager.createUser(user))
            return true;
        else
            return false;
    }

    public void setDBManager(DatabaseManager dbManager){    //Will dbManager object be dynamic?
        //Sets a reference to the dataBaseManager of the sessionManager’s dbManager object.
        this.dbManager = dbManager;
    }
}
