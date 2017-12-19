package views;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.DatabaseManager;
import model.Announcement;
import model.AnnouncementManager;
import model.Cities;
import org.primefaces.context.RequestContext;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.event.map.ReverseGeocodeEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import session.SessionUtils;

/**
 * Created by ofk on 10/26/17.
 */
@ManagedBean
@SessionScoped
public class createAnnouncementView {private MapModel geoModel;
    private String centerGeoMap = "39.9334, 32.8597";
    private String title="";
    private String city ;
    private String typeSelected;
    private String district;
    private Cities cities;
    private String address = "";
    private String needDonation =null;
    private LatLng coordinates= new LatLng(39.9334, 32.8597);
    private String desciription;
    private String contactInfo;
    private UploadedFile file;
    //AnnouncementManager announcementManager ;
    @PostConstruct
    public void init() {
        geoModel = new DefaultMapModel();
        cities = new Cities();
    }
    public void onGeocode(GeocodeEvent event) {
        geoModel = new DefaultMapModel();
        List<GeocodeResult> results = event.getResults();
        //geoModel.getMarkers().remove(0);
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            coordinates = center;
        }
        Marker marker = new Marker(coordinates,"Your Location");
        marker.setDraggable(true);
        geoModel.addOverlay(marker);
    }
    public void onMarkerDrag(MarkerDragEvent event) {
        coordinates = event.getMarker().getLatlng();
    }

    public MapModel getGeoModel() {
        return geoModel;
    }

    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    public String getTitle(){return title;}

    public void setTitle(String title){this.title = title;}
    public void setTitle(){this.title = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("Title");}

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
    public boolean isDistrictSelected(){
        return district == null;
    }
    public boolean isButton1Active(){
        return address.equals("") || needDonation== null || title.equals("");
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
        types.add("Health");
        types.add("Technology");
        types.add("Clothing");
        types.add("Sports");
        types.add("Handicapped");
        types.add("Other");
        return  types;
    }
    public void setType(){
        this.typeSelected = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("SelectedType");}

    public String getTypeSelected(){return typeSelected;}

    public void setTypeSelected(String typeSelected) {
        this.typeSelected = typeSelected;
    }

    public String getAddress(){return address;}

    public void setAddress(String adress){this.address = adress;}
    public void setAddress(){this.address = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("Address");}

    public String getCity(){return city;}

    public String getNeedDonation(){ return needDonation;}
    public void setNeedDonation(String needDonation){ this.needDonation = needDonation;}
    public void setNeedDonation(){
        this.needDonation = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("NeedDonation");
        System.out.println(address);
        System.out.println(needDonation);
        System.out.println(title);
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getDesciription() {
        return desciription;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setDesciription(String desciription) {
        this.desciription = desciription;
    }
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        //if(file != null) {
            HttpSession session = SessionUtils.getSession();
            int userid = (Integer) session.getAttribute("username");
            System.out.println(userid);
            boolean nd = needDonation.equals("Need");
            AnnouncementManager.createAnnouncement(title,city,district,typeSelected,desciription,contactInfo,nd,coordinates.getLat(),coordinates.getLng(),userid);
            RequestContext.getCurrentInstance().update("center");
            clean();
            try{
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }catch (Exception e){}
    }
    private void clean(){
        centerGeoMap = "39.9334, 32.8597";
        title="";
        city ="";
        typeSelected= "";
        district= "";
        address = "";
        needDonation =null;
        coordinates= new LatLng(39.9334, 32.8597);
        desciription= "";
        contactInfo = "";
        file =null;
    }
}

