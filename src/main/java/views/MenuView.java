package views;

import session.SessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * Created by ofk on 10/19/17.
 */
@ManagedBean
public class MenuView {
    private String email;
    private String password;
    public void dummy(){}
    SessionManager sessionManager;
    @PostConstruct
    public void init() {
        sessionManager= new SessionManager();
    }

    public void setEmail(String email){this.email=email;};

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void logIn(){
        System.out.println(email +" ");
        sessionManager.signIn(email,password);
    }
}
