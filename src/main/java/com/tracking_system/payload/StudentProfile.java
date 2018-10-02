package com.tracking_system.payload;

public class StudentProfile {

    private Integer registerno;
    private String firstname;
    private String lastname;
    private String classname;
    private String sec;
    private String parentname;
    private Long phoneno;
    private String addrs;
    private Integer rootid;

    public StudentProfile() {
    }

    public StudentProfile(Integer registerno, String firstname, String lastname, String classname, String sec, String parentname, Long phoneno, String addrs, Integer rootid) {
        this.registerno = registerno;
        this.firstname = firstname;
        this.lastname = lastname;
        this.classname = classname;
        this.sec = sec;
        this.parentname = parentname;
        this.phoneno = phoneno;
        this.addrs = addrs;
        this.rootid = rootid;
    }

    public Integer getRegisterno() {
        return registerno;
    }

    public void setRegisterno(Integer registerno) {
        this.registerno = registerno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public Long getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(Long phoneno) {
        this.phoneno = phoneno;
    }

    public String getAddrs() {
        return addrs;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
        this.rootid = rootid;
    }
}
