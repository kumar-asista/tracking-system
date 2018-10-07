package com.tracking_system.payload;

import javax.validation.constraints.*;

public class SignUpRequest {

    private Long phoneNo;
    private String firstname;
    private String lastname;
    private Boolean isEnable;
    private Long roleId;

    public SignUpRequest() {
    }

    public SignUpRequest(Long phoneNo, String firstname, String lastname, Boolean isEnable, Long roleId) {
        this.phoneNo = phoneNo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.isEnable = isEnable;
        this.roleId = roleId;
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
