package model;

import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;
import dao.*;
/**
 * Created by ofk on 10/18/17.
 */
public class AnnouncementManager {
    private List<Announcement> announcements;
    private static int id = 0;
    public AnnouncementManager(){
        announcements = DatabaseManager.getAnnouncements();
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
    public Announcement getAnnouncementByID(int id) {return DatabaseManager.getAnnouncementDetails(id);}
    public static void createAnnouncement(String title, String city, String district, String category, String detail, String contactInfo,boolean needOrDonation, double lat, double lng, int userId){
        id++;
        DatabaseManager.createAnnouncement( new Announcement(id,title,city,district,category,detail,contactInfo,needOrDonation,lat,lng,userId));
    }
    public static void main(String []args){
        for (int i = 1; i < 500; i++){
            DatabaseManager.createAnnouncement(new Announcement(i,"Announcement"+i,"City"+i,"District"+i,
                    "Category"+i, "Announcement"+i +"Detail","Announcement"+i +"ContactInfo" ,true,36+ Math.random()*6,26+ Math.random()*19,i));
            //databaseManager.deleteAnnouncement(i);
        }
    }
    public int getId(){
        return id + 1;
    }
}
