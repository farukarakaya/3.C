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
        Configuration cfg = new Configuration();
        sessionFactory = cfg.configure("hibernate.cfg.xml").buildSessionFactory();
    }

    // gets the user as a parameter and stores it in database
    public boolean createUser(UserDetails user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean deleteUser(int userId) {
        UserDetails userToDelete = new UserDetails();
        userToDelete.setId(userId);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(userToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public UserDetails getUser(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails user = session.get(UserDetails.class, userId);
        session.getTransaction().commit();
        session.close();

        return user;
    }

    public UserDetails getUser(String email, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(UserDetails.class);
        UserDetails user = (UserDetails) criteria.add(Restrictions.eq("email", email)).add(Restrictions.eq("password", password)).uniqueResult();
        session.getTransaction().commit();
        session.close();

        return user;
    }

    public boolean createAnnouncement(Announcement announcement) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(announcement);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public boolean deleteAnnouncement(int announcementId) {
        Announcement announcementToDelete = new Announcement();
        announcementToDelete.setId(announcementId);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(announcementToDelete);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    public List<Announcement> getAnnouncements() {
        Session session = sessionFactory.openSession();
        TypedQuery<Announcement> query =    session.createQuery("FROM Announcement");
        List<Announcement> result = query.getResultList();
        session.close();
        return result;
    }

    public List<Announcement> getAnnouncements(int userId) {
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
    }

    public Announcement getAnnouncementDetails(int announcementId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Announcement announcement = session.get(Announcement.class, announcementId);
        session.getTransaction().commit();
        session.close();

        return announcement;
    }


}