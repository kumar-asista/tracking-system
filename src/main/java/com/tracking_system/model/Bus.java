package com.tracking_system.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/*TODO Map bus institution*/

@Entity
@Table (name = "bus")
public class Bus {

    @Id
    @Column (name = "bus_no")
    private  Long busNo;
    @Column (name = "institution_id")
    private Integer businstitutionId;
    @Column (name = "rootid")
    private Integer rootid;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", updatable = false, insertable = false)
    private Institution  institution;

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rootid", referencedColumnName = "root_id", updatable = false, insertable = false)
    private Root root;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Bus() {
    }

    public Bus(Long busNo, Integer businstitutionId, Integer rootid) {
        this.busNo = busNo;
        this.businstitutionId = businstitutionId;
        this.rootid = rootid;
    }

    public Long getBusNo() {
        return busNo;
    }

    public void setBusNo(Long busNo) {
        this.busNo = busNo;
    }

    public Integer getBusinstitutionId() {
        return businstitutionId;
    }

    public void setBusinstitutionId(Integer businstitutionId) {
        this.businstitutionId = businstitutionId;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
        this.rootid = rootid;
    }

}
