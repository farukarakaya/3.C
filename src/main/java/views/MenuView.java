package views;

import dao.DatabaseManager;
import model.UserDetails;
import session.SessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by ofk on 10/19/17.
 */
@ManagedBean
@SessionScoped
public class MenuView {
    private String fullName;
    private String email;
    private String password;
    private String cPassword;
    private boolean sigIn = true;
    public void dummy(){}

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getcPassword() {
        return cPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void singIn(){
        System.out.println(fullName +" " + email);
        UserDetails user = new UserDetails(fullName,email,password,false);
        DatabaseManager.createUser(user);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        }catch (Exception e){}
        sigIn = false;
    }
    public boolean isSignedIn1(){
        return sigIn;
    }
    public boolean isSignedIn2(){
        return !sigIn;
    }

}

