package com.tracking_system.model;

import javax.persistence.*;


@Entity
@Table(name = "roots")
public class Root extends Audit{

    @Id
    @Column (name = "root_id")
    private Integer rootId;
    @Column (name = "root_from")
    private String rootFrom;
    @Column (name = "root_to")
    private String rootTo;
    @Column (name = "institution_id")
    private Integer rootinstitutionId;
    @Column (name = "bus_no")
    private Integer busno;
    @Column (name = "driver_license_no")
    private String driverLicenseNo;
    @Column (name = "driver_name")
    private String driverName;
    @Column (name = "driver_phone_no")
    private Long driverPhoneNo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", insertable = false, updatable = false)
    private Institution institution;

    public Institution getInstitution() {
        return institution;
    }
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Root() {}

    public Root(Integer rootId, String rootFrom, String rootTo, Integer rootinstitutionId, Integer busno, String driverLicenseNo, String driverName, Long driverPhoneNo) {
        this.rootId = rootId;
        this.rootFrom = rootFrom;
        this.rootTo = rootTo;
        this.rootinstitutionId = rootinstitutionId;
        this.busno = busno;
        this.driverLicenseNo = driverLicenseNo;
        this.driverName = driverName;
        this.driverPhoneNo = driverPhoneNo;
    }

    public Integer getRootId() {
        return rootId;
    }

    public void setRootId(Integer rootId) {
        this.rootId = rootId;
    }

    public String getRootFrom() {
        return rootFrom;
    }

    public void setRootFrom(String rootFrom) {
        this.rootFrom = rootFrom;
    }

    public String getRootTo() {
        return rootTo;
    }

    public void setRootTo(String rootTo) {
        this.rootTo = rootTo;
    }

    public Integer getRootinstitutionId() {
        return rootinstitutionId;
    }

    public void setRootinstitutionId(Integer rootinstitutionId) {
        this.rootinstitutionId = rootinstitutionId;
    }



    public Integer getBusno() {
        return busno;
    }

    public void setBusno(Integer busno) {
        this.busno = busno;
    }

    public String getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(String driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getDriverPhoneNo() {
        return driverPhoneNo;
    }

    public void setDriverPhoneNo(Long driverPhoneNo) {
        this.driverPhoneNo = driverPhoneNo;
    }
}
