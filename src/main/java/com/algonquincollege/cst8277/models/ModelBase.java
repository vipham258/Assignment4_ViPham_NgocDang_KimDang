/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: ModelBase.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Abstract class that is base for all
 * com.algonquincollege.cst8277.assignment3 @Entity classes
 */
@MappedSuperclass
public abstract class ModelBase {

    protected int id;
    protected int version;
    protected LocalDateTime createDate;
    protected LocalDateTime updateDate;

    @Column(name = "CREATED_DATE")
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Column(name = "UPDATED_DATE")
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    @PrePersist
    public void onPersist() {
        setCreateDate(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        setUpdateDate(LocalDateTime.now());
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public ModelBase() {
    }

    @Transient
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

}