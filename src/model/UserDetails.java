package model;

import java.util.Collection;
import java.util.ArrayList;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_TABLE")
public class UserDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String fullName;
    private String email;
    @ElementCollection
    private Collection<Integer> announcementIdList = new ArrayList<Integer>();
    private String password;
    private boolean isAdmin;

    public UserDetails() {}

    public UserDetails(int id, String fullName, String email, Collection<Integer> announcementIdList, String password, boolean isAdmin) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.announcementIdList = announcementIdList;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Collection<Integer> getAnnouncementIdList() {
        return announcementIdList;
    }
    public void setAnnouncementIdList(Collection<Integer> announcementIdList) {
        this.announcementIdList = announcementIdList;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


}
