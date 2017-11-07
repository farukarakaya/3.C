package model;

import javax.persistence.Embeddable;

@Embeddable
public class Position{
    private double lat,lng;

    public double getLat() {
        return lat;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }
    public double getLng() {
        return lng;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }
    public Position() {
        lat = 0;
        lng = 0;
    }
    public Position(double lat, double lng){
        this.lat= lat;
        this.lng=lng;
    }
}