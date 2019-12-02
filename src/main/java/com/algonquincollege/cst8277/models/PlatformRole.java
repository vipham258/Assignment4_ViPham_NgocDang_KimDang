/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: PlatformRole.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;
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
 * Role class used for (JSR-375) Java EE Security authorization/authentication
 */

@Entity
@Table(name = "PLATFORM_ROLE")
public class PlatformRole extends ModelBase implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;

    protected String roleName;
    protected List<PlatformUser> platformUsers;

    public PlatformRole() {
        super();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ROLE_NAME")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Description: get a list of platformUser
     * 
     * @return list of platformUsers
     */
    @ManyToMany(mappedBy = "platformRoles", cascade = CascadeType.PERSIST)
    public List<PlatformUser> getPlatformUsers() {
        return platformUsers;
    }

    /**
     * Description: set a list of platformUser
     * 
     * @param platformUsers
     */
    public void setPlatformUsers(List<PlatformUser> platformUsers) {
        this.platformUsers = platformUsers;
    }

    /**
     * Description: add a platformUser
     * 
     * @param user
     */
    public void addPlatformUser(PlatformUser user) {
        getPlatformUsers().add(user);
    }

}