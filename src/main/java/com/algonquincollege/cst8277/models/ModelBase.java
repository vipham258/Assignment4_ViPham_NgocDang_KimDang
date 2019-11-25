/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: ModelBase.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.models;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 * Abstract class that is base for all com.algonquincollege.cst8277.assignment3 @Entity classes
 */
@MappedSuperclass
public abstract class ModelBase {

    protected int id;
    protected int version;

    //TODO - add createdDate, updatedDate

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