package views;

import dao.DatabaseManager;
import model.UserDetails;
import session.SessionManager;
import session.SessionUtils;

import javax.annotation.PostConstruct;
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
public class SessionView {
    HttpSession session = null;
    SessionUtils sessionUtils;
    private String email;
    private String password;
    @PostConstruct
    public void init() {

        sessionUtils = new SessionUtils();
    }
    public boolean isAdmin(){
        if(session != null) {
            System.out.println(session.getAttribute("isAdmin"));
            return session.getAttribute("isAdmin").equals("true");
        }
        return false;
    }
    public boolean isUser(){
        if(session != null)
            return !isAdmin();
        return false;
    }
    public boolean isGuest(){
        if(session == null)
            return true;
        else
            return false;
    }
    public boolean logIn(){
        //UserDetails user = DatabaseManager.getUser(email,password);
        UserDetails user = new UserDetails(3,"Omer","farukarakaya@gmail.com","12345",true);
        System.out.println(email+" "+ password);
        if(user != null) {
            System.out.println("Log In Succesfull");
            session = SessionUtils.getSession();
            session.setAttribute("username", user.getId());
            if(user.isAdmin()) session.setAttribute("isAdmin", "true");
            else session.setAttribute("isAdmin", "false");
            return true;
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return false;
        }
    }
    public void logOut(){
        session.invalidate();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public static void main(String []args){
        UserDetails u = DatabaseManager.getUser("farukarakaya@gmail.com","12345");
        System.out.println(u);
    }
}
