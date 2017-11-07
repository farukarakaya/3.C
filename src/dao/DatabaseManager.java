package dao;

        import java.util.Iterator;
        import java.util.List;
        import java.util.Map;

        import javax.persistence.EntityManager;
        import javax.persistence.PersistenceContext;
        import javax.persistence.TypedQuery;
        import javax.persistence.criteria.CriteriaBuilder;
        import javax.persistence.criteria.CriteriaQuery;
        import javax.persistence.criteria.Root;

        import model.*;

        import org.hibernate.Criteria;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;
        import org.hibernate.criterion.ProjectionList;
        import org.hibernate.criterion.Projections;
        import org.hibernate.criterion.Restrictions;
        import org.hibernate.query.Query;

public class DatabaseManager {

    @PersistenceContext
    protected EntityManager entityManager;
    private SessionFactory sessionFactory;

    public DatabaseManager() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    // gets the user as a parameter and stores it in database
    public boolean createUser(UserDetails user) {
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

    // deletes the user from db
    public boolean deleteUser(int userId) {
        try {
            UserDetails userToDelete = new UserDetails();
            userToDelete.setId(userId);

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
    public UserDetails getUser(int userId) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            UserDetails user = session.get(UserDetails.class, userId);
            session.getTransaction().commit();
            session.close();

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    // returns the user according to email and password
    public UserDetails getUser(String email, String password) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            Criteria criteria = session.createCriteria(UserDetails.class);
            UserDetails user = (UserDetails) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).uniqueResult();
            session.getTransaction().commit();
            session.close();

            return user;
        } catch (Exception e) {
            return null;
        }
    }

    // saves the announcement in db
    public boolean createAnnouncement(Announcement announcement) {
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
    public boolean deleteAnnouncement(int announcementId) {
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
    public List<Announcement> getAnnouncements() {
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
    public List<Announcement> getAnnouncements(int userId) {
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
    public Announcement getAnnouncementDetails(int announcementId) {
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
