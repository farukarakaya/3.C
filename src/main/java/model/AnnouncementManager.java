package model;

import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;
import dao.*;
/**
 * Created by ofk on 10/18/17.
 */
public class AnnouncementManager {
    public static List<Announcement> getAnnouncements(){
        return DatabaseManager.getAnnouncements();
    }
    public  List<Announcement> getAnnouncementsScroller(){
        return getAnnouncements();
    }
    public List<Announcement> getAnnouncementsMap(){
        return getAnnouncements();
    }
    public static Announcement getAnnouncementByID(int id) {return DatabaseManager.getAnnouncementDetails(id);}
    public static void createAnnouncement(String title, String city, String district, String category, String detail, String contactInfo,boolean needOrDonation, double lat, double lng, int userId){
        DatabaseManager.createAnnouncement( new Announcement(title,city,district,category,detail,contactInfo,needOrDonation,lat,lng,userId));
    }
    public static void main(String []args){
        for (int i = 1; i < 500; i++){
            DatabaseManager.createAnnouncement(new Announcement("Announcement"+i,"City"+i,"District"+i,
                    "Category"+i, "Announcement"+i +"Detail","Announcement"+i +"ContactInfo" ,true,36+ Math.random()*6,26+ Math.random()*19,i));
            //databaseManager.deleteAnnouncement(i);
        }
    }
  }
