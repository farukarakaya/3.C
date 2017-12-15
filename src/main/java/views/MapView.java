package views;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.DatabaseManager;
import model.Announcement;
import model.AnnouncementManager;
import model.Cities;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.webapp.FacesServlet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ofk on 10/24/17.
 */
@ManagedBean
@SessionScoped
public class MapView {
    AnnouncementManager dataSource;
    Gson gson = new Gson();
    int announcementToShow;
    private String city = null;
    private String typeSelected = null;
    private String district = null;
    private boolean need =true;
    private boolean donation = true;
    private Cities cities;
    private boolean filter = false;
    List<Announcement> announcements ;
    @PostConstruct
    public void init() {
        cities = new Cities();
    }

    public JsonElement getAnnouncementsMap(){
        filter();
        return gson.toJsonTree(announcements);
    }
    public void setAnnouncementToShow(){
        announcementToShow = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID"));
        System.out.print(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("ID"));
    }
    public int getAnnouncementToShow(){return announcementToShow; }
    public Announcement getAnnouncememtByID(){
        return AnnouncementManager.getAnnouncementByID(announcementToShow);
    }

    public String getCity(){return city;}
    public void setCity(){
        city = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("SelectedCity");
    }
    public void setCity(String city){this.city=city;}
    public List<String> getCities(){
        return cities.getCities();
    }
    public boolean isCitySelected(){
        //System.out.println(city);
        return city ==null;
    }
    public String getDistrict(){return district;}
    public void setDistrict(){
        district = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("SelectedDistrict");
        System.out.println("asad  "+ district);
    }
    public void setDistrict(String district){this.district=district;}
    public List<String> getDistricts(){
        return  cities.getDistrict(city);
    }
    public List<String> getTypes(){
        List<String> types = new ArrayList<String>();
        types.add("Education");
        types.add("Food");
        types.add("Clothes");
        return  types;
    }
    public void setType(){
        this.typeSelected = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("SelectedType");}
    public String getTypeSelected(){return typeSelected;}
    public void setTypeSelected(String typeSelected) {
        this.typeSelected = typeSelected;
    }

    public boolean isDonation() {
        return donation;
    }

    public boolean isNeed() {
        return need;
    }

    public void setDonation(boolean donation) {
        this.donation = donation;
    }

    public void setNeed(boolean need) {
        this.need = need;
    }

    public void filter(){
        announcements = DatabaseManager.getAnnouncements();
        List<Announcement> filteredannouncemnets = new ArrayList<Announcement>();
        for (int i= 0; i < announcements.size(); i++){
            if(city == null || announcements.get(i).getCity().equals(city))
                if(district == null || announcements.get(i).getDistrict().equals(district))
                    if(typeSelected == null || announcements.get(i).getCategory().equals(typeSelected))
                        if(need && announcements.get(i).isNeedOrDonation())
                            filteredannouncemnets.add(announcements.get(i));
                        else if(donation && !announcements.get(i).isNeedOrDonation())
                            filteredannouncemnets.add(announcements.get(i));
        }
       // announcements = filteredannouncemnets;
    }
    public void makeFilter(){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }catch (Exception e){}
    }
}