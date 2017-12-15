package model;

        import javax.persistence.Embeddable;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.GenerationType;
        import javax.persistence.Id;
        import javax.persistence.Table;

@Entity
@Table(name = "ANNOUNCEMENTS_TABLE")
public class Announcement {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String title;
    private String contactInfo;
    private String city;
    private String district;
    private String category;
    private boolean needOrDonation;
    private Position pos;
    private String detail;
    private int userId;

    public Announcement() {

    }
    public Announcement(String title,int id){
        this.title = title;
        this.id = id;
    }
    public Announcement(int id,double lat,double lng){
        this.id = id;
        this.pos = new Position(lng,lat);
    }
    public Announcement(String title, String city, String district, String category, String detail, String contactInfo,boolean needOrDonation, double lat, double lng, int userId){
        this.title = title;
        this.city = city;
        this.district = district;
        this.category = category;
        this.needOrDonation = needOrDonation;
        this.pos = new Position(lat,lng);
        this.detail = detail;
        this.contactInfo = contactInfo;
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isNeedOrDonation() {
        return needOrDonation;
    }
    public void setNeedOrDonation(boolean needOrDonation) {
        this.needOrDonation = needOrDonation;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Position getPos() {
        return pos;
    }
    public void setPos(Position pos) {
        this.pos = pos;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
}