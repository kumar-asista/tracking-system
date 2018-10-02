package com.tracking_system.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "root")
public class Root {

    @Id
    @Column (name = "root_id")
    private Integer rootId;
    @Column (name = "root_from")
    private String rootFrom;
    @Column (name = "root_to")
    private String rootTo;
    @Column (name = "institution_id")
    private Integer rootinstitutionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "institution_id", referencedColumnName = "institution_id", insertable = false, updatable = false)
    private Institution institution;


    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public Root() {
    }

    public Root(Integer rootId, String rootFrom, String rootTo, Integer rootinstitutionId) {
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
