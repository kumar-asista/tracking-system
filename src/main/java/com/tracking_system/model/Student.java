package com.tracking_system.model;

import javax.persistence.*;

@Entity
@Table (name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "first_name" )
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "class")
    private String classname;
    @Column(name = "section")
    private String section;
    @Column(name = "parents_name")
    private String parentname;
    @Column(name = "phone_no")
    private Long phoneno;
    @Column(name = "address")
    private String address;
    @Column(name = "root_id")
    private Integer rootid;
    @Column(name = "is_enable")
    private Boolean isenable;
    @Column(name = "register_no")
    private String registerno;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "root_id" ,referencedColumnName = "root_id", insertable = false, updatable = false)
    private Root root;

    public Root getRoot() {
        return root;
    }

    public void setRoot(Root root) {
        this.root = root;
    }

    public Student() {
    }

    public Student(Integer studentId, String firstname, String lastname, String classname, String section, String parentname, Long phoneno, String address, Integer rootid, Boolean isenable, String registerno) {
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
