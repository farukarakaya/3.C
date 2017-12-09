package views;

import model.Cities;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.*;

/**
 * Created by ofk on 10/27/17.
 */
@ManagedBean
@SessionScoped
public class FilterView {
    private String city ;
    private String typeSelected;
    private String district;
    private String[] needDonation = {"Donation","Need"};
    private Cities cities;
    @PostConstruct
    public void init() {
        cities = new Cities();
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
    public String[] getNeedDonation(){ return needDonation;}
    public void setNeedDonation(String[] needDonation){ this.needDonation = needDonation;}
}
