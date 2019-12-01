/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: SavingsAccount.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


/**
 * The persistent class for the ACCOUNT database table.
 * 
 */
@Entity
@DiscriminatorValue(value = "S")
public class SavingsAccount extends AccountBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double savingRate;
	
    /**
    * Description: get saving rate
    * 
    * @return saving rate
    */
	@Column(name = "RATE")
    public double getSavingRate() {
        return savingRate;
    }
	
    /**
    * Description: set saving rate
    * 
    * @param savingRate
    */
    public void setSavingRate(double savingRate) {
        this.savingRate = savingRate;
    }
	
}