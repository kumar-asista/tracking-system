package com.tracking_system.payload;

public class DriverDetails {


    private Long driverLicenseNo;
    private String driver_name;
    private Integer driverinstitutionId;
    private Long driverbusNo;

    public DriverDetails() {
    }

    public DriverDetails(Long driverLicenseNo, String driver_name, Integer driverinstitutionId, Long driverbusNo) {
        this.driverLicenseNo = driverLicenseNo;
        this.driver_name = driver_name;
        this.driverinstitutionId = driverinstitutionId;
        this.driverbusNo = driverbusNo;
    }

    public Long getDriverLicenseNo() {
        return driverLicenseNo;
    }

    public void setDriverLicenseNo(Long driverLicenseNo) {
        this.driverLicenseNo = driverLicenseNo;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public Integer getDriverinstitutionId() {
        return driverinstitutionId;
    }

    public void setDriverinstitutionId(Integer driverinstitutionId) {
        this.driverinstitutionId = driverinstitutionId;
    }

    public Long getDriverbusNo() {
        return driverbusNo;
    }

    public void setDriverbusNo(Long driverbusNo) {
        this.driverbusNo = driverbusNo;
    }
}
