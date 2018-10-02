package com.tracking_system.payload;


public class UserProfile {

    private String username;
    private Long phoneNo;
    private Boolean enable;
    private String firstname;
    private String lastname;
    private Long roleId;

    public UserProfile() {
    }

    public UserProfile(String username, Long phoneNo, Boolean enable, String firstname, String lastname, Long roleId) {
        this.username = username;
        this.phoneNo = phoneNo;
        this.enable = enable;
        this.firstname = firstname;
        this.lastname = lastname;
        this.roleId = roleId;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
