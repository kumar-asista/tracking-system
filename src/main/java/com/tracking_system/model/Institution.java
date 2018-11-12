package com.tracking_system.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "institutions")
public class Institution extends Audit{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "institution_id")
    private Integer institutionId;
    @Column(name = "institution_name")
    private String institutionName;
    @Column(name = "institution_address")
    private String institutionAddress;
    @Column(name = "enable")
    private Boolean enableInstitution;

    public Institution() {}

    public Institution(Integer institutionId, String institutionName, String institutionAddress, Boolean enableInstitution) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.institutionAddress = institutionAddress;
        this.enableInstitution = enableInstitution;

    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "institutions")
    private Set<User> user = new HashSet<>();

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public Integer getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getInstitutionAddress() {
        return institutionAddress;
    }

    public void setInstitutionAddress(String institutionAddress) {
        this.institutionAddress = institutionAddress;
    }

    public Boolean getEnableInstitution() {
        return enableInstitution;
    }

    public void setEnableInstitution(Boolean enableInstitution) {
        this.enableInstitution = enableInstitution;
    }

}

