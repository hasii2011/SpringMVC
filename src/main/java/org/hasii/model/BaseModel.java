package org.hasii.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {

    @Id
    @Column(name="ID")
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }
    public void setId(Integer theId) {
        id = theId;
    }

}