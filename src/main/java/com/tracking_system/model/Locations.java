package com.tracking_system.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Locations {

    @Id
    @Column(name = "loc_id")
    private Integer locId;
    @Column(name = "latitude")
    private Double Latitude;
    @Column(name = "longitude")
    private Double Longitude;
    @Column (name = "rootid")
    private Integer rootid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootid", referencedColumnName = "root_id", insertable = false, updatable = false)
    private Root root;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Locations() {
    }

    public Locations(Integer locId, Double latitude, Double longitude, Integer rootid) {
        this.locId = locId;
        Latitude = latitude;
        Longitude = longitude;
        this.rootid = rootid;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
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

}
