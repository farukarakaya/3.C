package dao;

        import java.util.Iterator;
        import java.util.List;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.TypedQuery;

        import model.*;

        import org.hibernate.Criteria;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;
        import org.hibernate.criterion.Restrictions;

public class DatabaseManager {

    @PersistenceContext
    protected EntityManager entityManager;
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

   /* public DatabaseManager() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }*/

    // gets the user as a parameter and stores it in database
    public static boolean createUser(User user) {
        try {
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                session.save(user);
                session.getTransaction().commit();
                session.close();
                return true;
        } catch (Exception e) {
            return false;
        }
    }

    // finds the user and changes his/her password
    public static boolean setUserPassword(int userId, String newPassword) {
        try {
            User user = getUser(userId);

            user.setPassword(newPassword);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // private function for checking if the user with this email exists
    // traverses the database and compares the emails
    public static boolean userExists(String email) {
            try {
                Session session = sessionFactory.openSession();
                session.beginTransaction();

                Criteria criteria = session.createCriteria(User.class);
                User user = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
                session.getTransaction().commit();
                session.close();

                return (user != null);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
    }
    // deletes the user from db
    // 1. delete all announcements of the user
    // 2. delete the user
    public static boolean deleteUser(int userId) {
        try {
            User userToDelete = new User();
            userToDelete.setId(userId);

            // 1. delete all announcements of the user
            deleteAnnouncements(getAnnouncements(userId));

            // 2. delete the user
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(userToDelete);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // returns the user by its id
    public static User getUser(int userId) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            User user = session.get(User.class, userId);
            session.getTransaction().commit();
            session.close();

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    // returns the user according to email and password
    public static User getUser(String email, String password) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(User.class);
            User user = (User) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).uniqueResult();
            session.getTransaction().commit();
            session.close();

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    // returns all users
    public static List<User> getUsers() {
        try {
            Session session = sessionFactory.openSession();
            TypedQuery<User> query = session.createQuery("FROM User");
            List<User> result = query.getResultList();
            session.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    // saves the announcement in db
    public static boolean createAnnouncement(Announcement announcement) {
        try {
            Session session = sessionFactory.openSession();

            // save the announcement
            session.beginTransaction();
            session.save(announcement);
            session.getTransaction().commit();

            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // deletes an announcement by its id
    public static boolean deleteAnnouncements(List<Announcement> announcementsToDelete) {
        try {

            Session session = sessionFactory.openSession();
            for (Announcement announcementToDelete : announcementsToDelete) {
                session.beginTransaction();
                session.delete(announcementToDelete);
                session.getTransaction().commit();
            }
            session.close();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // deletes an announcement by its id
    public static boolean deleteAnnouncement(int announcementId) {
        try {
            Announcement announcementToDelete;

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            announcementToDelete = session.load(Announcement.class, announcementId);
            session.delete(announcementToDelete);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // returns all announcements
    public static List<Announcement> getAnnouncements() {
        try {
            Session session = sessionFactory.openSession();
            TypedQuery<Announcement> query = session.createQuery("FROM Announcement");
            List<Announcement> result = query.getResultList();
            session.close();
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    // returns the list of announcements related to the userid
    public static List<Announcement> getAnnouncements(int userId) {
        try {
            Session session = sessionFactory.openSession();
            TypedQuery<Announcement> query = session.createQuery("FROM Announcement");
            List<Announcement> announcements = query.getResultList();
            session.close();

            for (Iterator<Announcement> iterator = announcements.iterator(); iterator.hasNext(); ) {
                if (iterator.next().getUserId() != userId) {
                    iterator.remove();
                }
            }
            return announcements;
        } catch (Exception e) {
            return null;
        }
    }

    // returns the announcement from db object by its id
    public static Announcement getAnnouncementDetails(int announcementId) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Announcement announcement = session.get(Announcement.class, announcementId);
            session.getTransaction().commit();
            session.close();

            return announcement;
        } catch (Exception e) {
            return null;
        }
    }
}
