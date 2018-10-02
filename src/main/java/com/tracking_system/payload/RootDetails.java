package com.tracking_system.payload;

public class RootDetails {

    private Integer rootId;
    private String rootFrom;
    private String rootTo;
    private Integer rootinstitutionId;

    public RootDetails() {
    }

    public RootDetails(Integer rootId, String rootFrom, String rootTo, Integer rootinstitutionId) {
        this.rootId = rootId;
        this.rootFrom = rootFrom;
        this.rootTo = rootTo;
        this.rootinstitutionId = rootinstitutionId;
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
}
