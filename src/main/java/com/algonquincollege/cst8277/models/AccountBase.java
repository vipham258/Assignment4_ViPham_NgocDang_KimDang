/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: AccountBase.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
/**
 * @author Vi Pham, Ngoc Dang, Ngan Dang
 * @date: Nov 2019
 * Description: AccountBase class extends ModelBase class which is super class of SavingAccount, Investment, Chequing classes
 * 
 * */
package com.algonquincollege.cst8277.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = ChequingAccount.class, name = "C"), @Type(value = InvestmentAccount.class, name = "I"),
        @Type(value = SavingsAccount.class, name = "S")

})
@Entity(name = "AccountBase")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "ACCOUNT")
@DiscriminatorColumn(name = "ACCOUNT_TYPE", length = 1)
public abstract class AccountBase extends ModelBase {

    // I moved balance from ModelBase to here
    /**An account balance*/
    protected double balance;
    
    /**A List of owners*/
    // protected int id;
    protected List<User> owners;

    /**
     * Description: getBalance
     * @return balance
     */
    public double getBalance() {
        return balance;
    }
    /**
     * Description: setBalance
     * @param: balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    /**
     * Description: getId
     * @return id
     */
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Description: getOwners
     * @return list of owners
     */
    // TODO - finish the @ManyToMany mapping
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "USER_ACCOUNT_ACCOUNT", joinColumns = { @JoinColumn(name = "ACCOUNT_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "USER_ID") })
    public List<User> getOwners() {
        return owners;
    }
    /**
     * Description: setOwners
     * @param owners
     */
    public void setOwners(List<User> owners) {
        this.owners = owners;
    }
    /**
     * Description: get owners and add new owners
     * @param owners
     */
    public void addOwner(User owner) {
        getOwners().add(owner);
    }
}