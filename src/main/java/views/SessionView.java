package views;

import session.SessionManager;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 * Created by ofk on 10/19/17.
 */
@ManagedBean
public class SessionView {
    private SessionManager sessionManager;
    @PostConstruct
    public void init() {
        sessionManager = new SessionManager();
    }
    public boolean isAdmin(){
        if(sessionManager.getUser() != null)
            return sessionManager.getUser().isAdmin();
        else
            return false;
    }
    public boolean isUser(){
        if(sessionManager.getUser() != null)
            return !sessionManager.getUser().isAdmin();
        else
            return false;
    }
    public boolean isGuest(){
        if(sessionManager.getUser() == null)
            return true;
        else
            return false;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }
}
