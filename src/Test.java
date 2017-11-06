import  model.*;
import dao.*;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        System.out.println("Hello world");

        UserDetails user1 = new UserDetails();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        //list1.add(1);
        //list1.add(2);
        user1.setAnnouncementIdList(list1);
        //user1.setId(3);
        user1.setEmail("email1");
        user1.setPassword("password1");


        UserDetails user2 = new UserDetails();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        //list2.add(3);
        //list2.add(4);
        user2.setAnnouncementIdList(list2);
        //user2.setId(4);
        user2.setEmail("email2");
        user2.setPassword("password2");

        //Announcement announcement1 = new Announcement(5, "title", "city", "district", "category", "detail", "contactInfo", true, 4.4, 5.2, 1);
        //Announcement announcement2 = new Announcement(6, "title2", "cit2y", "dis2trict", "cate2gory", "deta2il", "conta2ctInfo", false, 4.4, 5.2, 2);


        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.createUser(user1);
        databaseManager.createUser(user2);

        //	databaseManager.createAnnouncement(announcement1);
        //	databaseManager.createAnnouncement(announcement2);

        //	announcement1.setId(14);
        //	databaseManager.createAnnouncement(announcement1);

        System.out.println("this is concise list: " + databaseManager.getAnnouncements().toString());
        for (Announcement element : databaseManager.getAnnouncements()) {
            System.out.println(element.getId());
        }

        System.out.println("--------------------\n" + databaseManager.getAnnouncements(1));
        for (Announcement element : databaseManager.getAnnouncements(1)) {
            System.out.println(element.getId());
        }

        System.out.println("===================");
        System.out.println(databaseManager.getAnnouncementDetails(5));


        //SessionFactory sessionFactory =
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(user);
//		session.getTransaction().commit();
    }
}