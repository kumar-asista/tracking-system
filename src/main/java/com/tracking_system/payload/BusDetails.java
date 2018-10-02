package com.tracking_system.payload;


public class BusDetails {

    private  Long busNo;
    private Integer businstitutionId;
    private Integer rootid;


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
