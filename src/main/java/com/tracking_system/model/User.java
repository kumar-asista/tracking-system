package com.tracking_system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table (name = "users")
public class User{


    @Id
    @Column(name = "phone_no")
    private Long phoneNo;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "is_enable")
    private Boolean isEnable;
    @Column(name = "role_id")
    private Long roleId;

    public User() {
    }

    public User(Long phoneNo, String firstname, String lastname, Boolean isEnable, Long roleId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNo = phoneNo;
        this.isEnable = isEnable;
        this.roleId = roleId;
    }
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "user_institution",
            joinColumns = {@JoinColumn(name = "phone_no")},
            inverseJoinColumns = {@JoinColumn(name = "institution_id")})
    private Set<Institution> institutions = new HashSet<>();

    public Set<Institution> getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Set<Institution> institutions) {
        this.institutions = institutions;
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

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}