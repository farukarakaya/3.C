/**
 * Created by ofk on 10/24/17.
 */
import model.AnnouncementManager;
import views.*;
public class Debug {
    static AnnouncementManager am = new AnnouncementManager();
    public static void main(String []args){
        System.out.print(am.getAnnouncementsMap());    }
}
