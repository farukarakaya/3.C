package model;

import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;
import dao.*;
/**
 * Created by ofk on 10/18/17.
 */
public class AnnouncementManager {
    List<Announcement> announcements;
    DatabaseManager db;
    public AnnouncementManager(){
        db = new DatabaseManager();
        announcements = db.getAnnouncements();
    }
    public List<Announcement> getAnnouncements(){
        return announcements;
    }
    public  List<Announcement> getAnnouncementsScroller(){
        return getAnnouncements();
    }
    public List<Announcement> getAnnouncementsMap(){
        return getAnnouncements();
    }
    public Announcement getAnnouncementByID(int id) {return db.getAnnouncementDetails(id);}

    public static void main(String []args){
        DatabaseManager databaseManager = new DatabaseManager();

        for (int i = 0; i < 500; i++){
            databaseManager.createAnnouncement(new Announcement(i,"Announcement"+i,"City"+i,"District"+i,
                    "Category"+i, "Announcement"+i +"Detail","Announcement"+i +"ContactInfo" ,true,36+ Math.random()*6,26+ Math.random()*19,i));
        }
    }
}
