package views;

import dao.DatabaseManager;
import model.UserDetails;
import services.EmailService;
import session.SessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Random;

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
    private String vcode;
    private String vcodeCreated;
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

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void singIn(){
        sigIn = false;
        int rand = (int)(Math.random()*99999);
        vcodeCreated = ""+ rand;
        EmailService emailService = new EmailService();
        emailService.sendVerificationEmail(fullName,email,vcodeCreated);
    }
    public boolean isSignedIn1(){
        return sigIn;
    }
    public boolean isSignedIn2(){
        return !sigIn;
    }
    public void validate() {
        if (vcodeCreated.equals(vcode)) {
            UserDetails user = new UserDetails(fullName, email, password, false);
            DatabaseManager.createUser(user);
            clean();
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            } catch (Exception e) {
            }
        }
    }
    public void clean(){
        fullName ="";
        email ="";
        password ="";
        cPassword ="";
        sigIn = true;
        vcode = null;
        vcodeCreated = null;
    }
}

