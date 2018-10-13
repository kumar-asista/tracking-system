package com.tracking_system.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "locations")
public class Locations extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loc_id")
    private Integer locationid;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "root_id")
    private Integer rootid;


    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "root_id", referencedColumnName = "root_id", insertable = false, updatable = false)
    private Root root;
    public Root getRoot() {
        return root;
    }
    public void setRoot(Root root) {
        this.root = root;
    }*/

    public Locations() {
    }
    public Locations(Integer locationid, Double latitude, Double longitude, Integer rootid) {
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
