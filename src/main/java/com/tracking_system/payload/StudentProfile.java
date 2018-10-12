package com.tracking_system.payload;

public class StudentProfile {

    private Integer studentId;
    private String firstname;
    private String lastname;
    private String classname;
    private String section;
    private String parentname;
    private Long phoneno;
    private String address;
    private Integer rootid;
    private Boolean isenable;
    private String registerno;

    public StudentProfile() {
    }

    public StudentProfile(Integer studentId, String firstname, String lastname, String classname, String section, String parentname, Long phoneno, String address, Integer rootid, Boolean isenable, String registerno) {
        this.studentId = studentId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.classname = classname;
        this.section = section;
        this.parentname = parentname;
        this.phoneno = phoneno;
        this.address = address;
        this.rootid = rootid;
        this.isenable = isenable;
        this.registerno = registerno;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
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

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRootid() {
        return rootid;
    }

    public void setRootid(Integer rootid) {
        this.rootid = rootid;
    }

    public Boolean getIsenable() {
        return isenable;
    }

    public void setIsenable(Boolean isenable) {
        this.isenable = isenable;
    }

    public String getRegisterno() {
        return registerno;
    }

    public void setRegisterno(String registerno) {
        this.registerno = registerno;
    }
}
