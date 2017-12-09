package views;

import javax.faces.bean.ManagedBean;

/**
 * Created by ofk on 10/19/17.
 */
@ManagedBean
public class SessionView {
    public boolean isAdmin(){return false;}
    public boolean isUser(){return false;}
    public boolean isGuest(){return true;}
}
