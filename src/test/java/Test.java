import  model.*;
import dao.*;
import java.util.List;
import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        db.setUserPassword(1, "password1");
    }
}