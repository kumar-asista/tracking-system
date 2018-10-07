package com.tracking_system.payload;

public class RootDetails {

    private Integer rootId;
    private String rootFrom;
    private String rootTo;
    private Integer rootinstitutionId;
    private Integer busno;
    private String driverLicenseNo;
    private String driverName;
    private Long driverPhoneNo;

    public RootDetails() {
    }

    public RootDetails(Integer rootId, String rootFrom, String rootTo, Integer rootinstitutionId,  Integer busno, String driverLicenseNo, String driverName, Long driverPhoneNo) {
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
