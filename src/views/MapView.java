package views;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Announcement;
import model.AnnouncementManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ofk on 10/24/17.
 */
@ManagedBean
@ViewScoped
public class MapView {
    AnnouncementManager dataSource;
    Gson gson = new Gson();
    int announcementToShow = 3;
    @PostConstruct
    public void init() {
        dataSource = new AnnouncementManager();
    }

    public JsonElement getAnnouncementsMap(){
        List<Announcement> announcements = dataSource.getAnnouncementsMap();
        return gson.toJsonTree(announcements);
    }
    public void setAnnouncementToShow(){
        announcementToShow = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID"));
        //System.out.print(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID"));
    }
    public int getAnnouncementToShow(){return announcementToShow;   }
    public Announcement getAnnouncememtByID(){
        return dataSource.getAnnouncementByID(announcementToShow);
    }

}