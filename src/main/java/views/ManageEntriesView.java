package views;

import dao.DatabaseManager;
import model.Announcement;
import model.AnnouncementManager;
import session.SessionUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ManageEntriesView {
    ///private List<Announcement> announcements;
    HttpSession session;
    int userId;

    public List<Announcement> getAnnouncements() {
        List<Announcement> announcements = DatabaseManager.getAnnouncements();
        List<Announcement> usersAnnouncements = new ArrayList<Announcement>();
        session = SessionUtils.getSession();
        if(session.getAttribute("username") != null) {
            userId = (Integer) session.getAttribute("username");
            System.out.println(userId);
            for (int i = 0; i < announcements.size(); i++) {
                if (announcements.get(i).getUserId() == userId)
                    usersAnnouncements.add(announcements.get(i));
            }
            System.out.println(usersAnnouncements.size());
            return usersAnnouncements;
        }
        return null;
    }
    public boolean isRenderDialog(){
        session = SessionUtils.getSession();
        return session.getAttribute("username") != null;
    }

    public void deleteAnnouncemnet(int id){
        DatabaseManager.deleteAnnouncement(id);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {}
    }
}
