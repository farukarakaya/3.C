/**
 * Created by ofk on 10/24/17.
 */
import model.AnnouncementManager;
import views.*;
public class Debug {
    //static AnnouncementManager am = new AnnouncementManager();
    static FilterView fw = new FilterView();
    public static void main(String []args){
        //System.out.print(am.getAnnouncementsMap());
        for (int i = 0; i< 81; i++)
        System.out.println(fw.getCities().get(1));
    }
}
