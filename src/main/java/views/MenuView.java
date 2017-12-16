package views;

import dao.DatabaseManager;
import model.User;
import org.primefaces.context.RequestContext;
import services.EmailService;
import session.SessionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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
    private String cPassword1;
    private String cPassword2;
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

    public String getcPassword1() {
        return cPassword1;
    }

    public String getcPassword2() {
        return cPassword2;
    }

    public void setcPassword1(String cPassword1) {
        this.cPassword1 = cPassword1;
    }

    public void setcPassword2(String cPassword2) {
        this.cPassword2 = cPassword2;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // sign up if there is no user with this email in the database
    public void singUp(){
        if ( !DatabaseManager.userExists(email)) {
            sigIn = false;
            int rand = (int) (Math.random() * 99999);
            vcodeCreated = "" + rand;
            EmailService emailService = new EmailService();
            emailService.sendVerificationEmail(fullName, email, vcodeCreated);
        } else {
            // todo if there is a user with this email prompt the user
            System.out.println("THIS EMAIL HAS BEEN USED BEFORE");
        }
    }
    public boolean isSignedIn1(){
        return sigIn;
    }
    public boolean isSignedIn2(){
        return !sigIn;
    }
    public void validate() {
        if (vcodeCreated.equals(vcode)) {
            User user = new User(fullName, email, password, false);
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
        cPassword1="";
        cPassword2="";
        sigIn = true;
        vcode = null;
        vcodeCreated = null;
    }
    public void changePassword(){
        HttpSession session = SessionUtils.getSession();
        int userid = (Integer) session.getAttribute("username");
        if(DatabaseManager.getUser(userid).getPassword().equals(cPassword)) {
            DatabaseManager.setUserPassword(userid, cPassword1);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('chamgePassPopup').hide();");
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Wrong Password."));
        }
        clean();
    }
}

