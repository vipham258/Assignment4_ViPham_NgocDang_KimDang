/**************************
 * File: User.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The persistent class for the USER_ACCOUNT database table.
 * 
 */
@Entity(name = "User")
@Table(name = "USER_ACCOUNT")
public class User extends ModelBase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String name;
    protected List<AccountBase> accounts = new ArrayList<>();

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    /**
    * Description: get a list of banking accounts
    * 
    * @return a list of banking accounts
    */
    // TODO - finish the @ManyToMany mapping
    @ManyToMany(mappedBy = "owners", cascade = CascadeType.PERSIST)
    public List<AccountBase> getAccounts() {
        return accounts;
    }

    /**
    * Description: set a banking account
    * 
    * @param a list account of Account Base
    */
    public void setAccounts(List<AccountBase> accounts) {
        this.accounts = accounts;
    }

    /**
    * Description: add a banking account
    * 
    * @param an account
    */
    public void addAccount(AccountBase a) {
        getAccounts().add(a);
    }
}