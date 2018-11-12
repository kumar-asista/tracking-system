package com.tracking_system.payload;

public class LocationDetails {

    private Integer locationid;
    private Double latitude;
    private Double longitude;
    private Integer rootid;

    public LocationDetails() {
    }

    public LocationDetails(Integer locationid, Double latitude, Double longitude, Integer rootid) {
        this.locationid = locationid;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rootid = rootid;
    }

    public Integer getLocationid() {
        return locationid;
    }

    public void setLocationid(Integer locationid) {
        this.locationid = locationid;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
        this.rootid = rootid;
    }
}
