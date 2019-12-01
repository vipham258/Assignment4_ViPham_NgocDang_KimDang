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
 * @author Vi Pham, Ngoc Dang, Ngan Dang
 * @date Nov 2019
 */
@MappedSuperclass
public abstract class ModelBase {
    /**id*/
    protected int id;
    /**version*/
    protected int version;
    /**date is created*/
    protected LocalDateTime createDate;
    /**date is updated*/
    protected LocalDateTime updateDate;

    /**
     * get date created
     * @return createdDate
     */
    @Column(name = "CREATED_DATE")
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    /**
     * set date created
     * @param createDate
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    /**
     * get date updated
     * @return updateDate
     */

    @Column(name = "UPDATED_DATE")
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    /**
     * set current time
     * make sure asset's currentValue is up-to-date in Db
     * executed before the EntityManager persist operation is actully executed
     */
    @PrePersist
    public void onPersist() {
        setCreateDate(LocalDateTime.now());
    }
    /**
     * update current time
     * executed before the UPDATE sql is executed 
     */
    @PreUpdate
    public void onUpdate() {
        setUpdateDate(LocalDateTime.now());
    }

    /**
     * set date updated
     * @param updateDate
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public ModelBase() {
    }
    /**
     * get id
     * @return id
     */
        
    @Transient
    public int getId() {
        return this.id;
    }
    /**
     * set id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * get version
     * @return version
     */
    @Version
    public int getVersion() {
        return version;
    }
    /**
     * set version
     * @param version
     */
    public void setVersion(int version) {
        this.version = version;
    }

}