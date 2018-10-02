package com.tracking_system.payload;

import javax.validation.constraints.*;

public class SignUpRequest {

    @NotBlank
    @Size(min = 4, max =29)
    private String username;
    @Size(min = 4,max = 30)
    private String firstname;
    @Size(min = 4,max = 30)
    private String lastname;
    private Long phoneNo;
    private Boolean enable;
    private Long roleId;
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

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Long getRoleId() { return roleId; }

    public void setRoleId(Long roleId) { this.roleId = roleId; }
}
