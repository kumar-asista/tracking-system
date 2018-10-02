package com.tracking_system.model;


import javax.persistence.*;


@Entity
@Table(name = "driver")
public class Drivers {

    @Id
    private Long driverLicenseNo;
    @Column (name = "driver_name")
    private String driver_name;
    @Column(name = "institution_id")
    private Integer driverinstitutionId;
    @Column (name = "busno")
    private Long driverbusNo;

    public Drivers() {
    }

    public Drivers(Long driverLicenseNo, String driver_name, Integer driverinstitutionId, Long driverbusNo) {
        this.driverLicenseNo = driverLicenseNo;
        this.driver_name = driver_name;
        this.driverinstitutionId = driverinstitutionId;
        this.driverbusNo = driverbusNo;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "busno", referencedColumnName = "bus_no" ,nullable = false, insertable = false, updatable = false)
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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

    public Integer getDriverinstitutionId() {  return driverinstitutionId;
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
