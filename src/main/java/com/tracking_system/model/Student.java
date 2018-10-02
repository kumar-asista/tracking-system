package com.tracking_system.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "student")
public class Student  {

    @Id
    @Column(name = "register_no")
    private Integer registerno;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "class")
    private String classname;
    @Column(name = "section")
    private String sec;
    @Column(name = "parents_name")
    private String parentname;
    @Column(name = "phone_no")
    private Long phoneno;
    @Column(name = "address")
    private String addrs;
    @Column(name = "root_id")
    private Integer rootid;

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

    public Student(Integer registerno, String firstname, String lastname, String classname, String sec, String parentname, Long phoneno, String addrs, Integer rootid) {
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
