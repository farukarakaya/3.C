package model;

/**
 * Created by ofk on 10/18/17.
 */
public class Announcement {
    private String title;
    private String contactInfo;
    private String city;
    private String district;
    private String category;
    private boolean needOrDonation;
    private int id;
    private Position pos;
    private String detail;

    public Announcement(String title,int id){
        this.title = title;
        this.id = id;
    }
    public Announcement(int id,double lat,double lng){
        this.id = id;
        this.pos = new Position(lng,lat);
    }
    public Announcement(int id, String title, String city, String district, String category, String detail, String contactInfo,boolean needOrDonation, double lat, double lng){
        this.id = id;
        this.title = title;
        this.city = city;
        this.district = district;
        this.category = category;
        this.needOrDonation = needOrDonation;
        this.pos = new Position(lng,lat);
        this.detail = detail;
        this.contactInfo = contactInfo;
    }
    public int getId(){ return id;}
    public String getTitle (){return title;}
    public String getDetail(){return detail;}
    public String getContactInfo(){return contactInfo;}
    public void setDetail(){

    }
    public class Position{
        private double lat,lng;

        public Position(double lng, double lat){
            this.lat= lat;
            this.lng=lng;
        }
    }
}
