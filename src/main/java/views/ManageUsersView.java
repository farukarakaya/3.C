package views;

import dao.DatabaseManager;
import model.User;
import model.User;
import session.SessionUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ManageUsersView {
    ///private List<User> Users;
    HttpSession session;
    int userId;

    public List<User> getUsers() {
        return DatabaseManager.getUsers();
    }
    public boolean isRenderDialog(){
        session = SessionUtils.getSession();
        return session.getAttribute("username") != null;
    }

    public void deleteUser(int id){
        DatabaseManager.deleteUser(id);
        session = SessionUtils.getSession();

        if ( (Integer) session.getAttribute("username") == id) {
            session.invalidate();
        }

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {}

    }

}
