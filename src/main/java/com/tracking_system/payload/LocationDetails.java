package com.tracking_system.payload;

public class LocationDetails {

    private Integer locId;
    private Double Latitude;
    private Double Longitude;
    private Integer rootid;

    public LocationDetails() {
    }

    public LocationDetails(Integer locId, Double latitude, Double longitude, Integer rootid) {
        this.locId = locId;
        this.Latitude = latitude;
        this.Longitude = longitude;
        this.rootid = rootid;
    }

    public Integer getLocId() {
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Double getLatitude() {
        return Latitude;
    }

    public void setLatitude(Double latitude) {
        Latitude = latitude;
    }

    public Double getLongitude() {
        return Longitude;
    }

    public void setLongitude(Double longitude) {
        Longitude = longitude;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
        this.rootid = rootid;
    }
}
