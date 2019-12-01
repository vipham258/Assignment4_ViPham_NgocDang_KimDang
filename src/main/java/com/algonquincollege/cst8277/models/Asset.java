
/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: Asset.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * 
 * @date 2019 12 1
 */

package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the ASSET database table.
 * @author Vi Pham, Ngoc Dang, Ngan Dang
 */
@Entity
public class Asset extends ModelBase implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    // added some more member fields: name, units, price

    /**current value*/
    protected double currentValue;
    /**name of asset*/
    protected String name;
    /**owner*/
    protected Portfolio owner;
    /**units*/
    protected int units;
    /**price*/
    protected double price;

    public Asset() {
        super();
    }
    /**
     * get id
     * @return id
     */
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSET_ID")
    public int getId() {
        return this.id;
    }

    /**
     * get name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get units
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * set units
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * get price
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * set price
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    // balance and currentValue are same thing for an asset
    @Column(name = "CURRENT_VALUE")
    public double getBalance() {
        return this.currentValue;
    }
    /**
     * set balance
     * @param currentValue
     */
    public void setBalance(double currentValue) {
        this.currentValue = currentValue;
    }
    /**
     * current value
     * @return current value
     */
    public double currentValue() {
        return currentValue;
    }
    /**
     * persist current value
     * make sure asset's currentValue is up-to-date in Db
     * executed before the EntityManager persist operation is actully executed
     */
    
    @PrePersist
    public void onPersist() {
        calculateCurrentValue();
    }

    /**
     * update current value
     * executed before the UPDATE sql is executed 
     */
    @PreUpdate
    public void onUpdate() {
        calculateCurrentValue();
    }
    /**
     * calculate the current value price * units
     */
    protected void calculateCurrentValue() {
        setBalance(price * units);
    }

    /**
     * get owner
     * @return owner
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID")
    public Portfolio getOwner() {
        return owner;
    }
    /**
     * set owner
     * @param owner
     */
    public void setOwner(Portfolio owner) {
        this.owner = owner;
    }

=======
/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: Asset.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * The persistent class for the ASSET database table.
 * 
 */
@Entity
public class Asset extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    // added some more member fields: name, units, price

    protected double currentValue;
    protected String name;
    protected Portfolio owner;
    protected int units;
    protected double price;

    public Asset() {
        super();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSET_ID")
    public int getId() {
        return this.id;
    }

    /**
     * @return the name
     */
    @Column(name = "ASSET_NAME")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the units
     */
    public int getUnits() {
        return units;
    }

    /**
     * @param units the units to set
     */
    public void setUnits(int units) {
        this.units = units;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    // balance and currentValue are same thing for an asset
    @Column(name = "CURRENT_VALUE")
    public double getBalance() {
        return this.currentValue;
    }

    public void setBalance(double currentValue) {
        this.currentValue = currentValue;
    }

    public double currentValue() {
        return currentValue;
    }

    // make sure asset's currentValue is up-to-date in Db
    @PrePersist
    public void onPersist() {
        calculateCurrentValue();
    }

    @PreUpdate
    public void onUpdate() {
        calculateCurrentValue();
    }

    protected void calculateCurrentValue() {
        setBalance(price * units);
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "PORTFOLIO_ID")
    public Portfolio getOwner() {
        return owner;
    }

    public void setOwner(Portfolio owner) {
        this.owner = owner;
    }
}