package model;

import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ofk on 10/18/17.
 */
public class AnnouncementManager {
    List<Announcement> announcements;
    public AnnouncementManager(){
        announcements = generateDummyAnnouncements(500);
    }

    public  List<Announcement> getAnnouncementsScroller(){
        return announcements;
    }
    public List<Announcement> getAnnouncementsMap(){
        return announcements;
    }
    public Announcement getAnnouncementByID(int id) {return announcements.get(id);}
    public List<Announcement> generateDummyAnnouncements(int size){
        announcements = new ArrayList<>();
        for (int i = 0; i < size; i++){
            announcements.add(new Announcement(i,"Announcement"+i,"City"+i,"District"+i,
                    "Category"+i, "Announcement"+i +"Detail","Announcement"+i +"ContactInfo" ,true,36+ Math.random()*6,26+ Math.random()*19,i));
        }
        return announcements;
    }
}
