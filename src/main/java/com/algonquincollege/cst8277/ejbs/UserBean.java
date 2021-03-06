/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: UserBean.java
 * Course materials (19F) CST 8277
 * @author Vi Pham, Ngoc Dang, Kim Dang
 *
 * @date 2019 12 01
 */
package com.algonquincollege.cst8277.ejbs;

import static com.algonquincollege.cst8277.util.MyConstants.PU_NAME;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.algonquincollege.cst8277.models.User;

@Stateless
public class UserBean {

    @PersistenceContext(unitName = PU_NAME)
    protected EntityManager em;

    /**
     * Description: a list of User from User table
     * 
     * @param userId
     * @return a list of User
     */
    public List<User> getUsersFor(int userId) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :tempID").setParameter("tempID", userId);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: a list of User from User table
     * 
     * @param name
     * @return a list of User
     */
    public List<User> getUsersByName(String name) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.name = :name").setParameter("name", name);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: Add a new user
     * 
     * @param newUser
     * @return newUser
     */

    public User addUser(User newUser) {
        em.persist(newUser);
        return newUser;
    }

    /**
     * Description: Delete a User by Id
     * 
     * @param deletedID
     * @return delete
     */
    public User deleteUser(int deletedID) {
        User delete = em.find(User.class, deletedID);
        em.remove(delete);
        return delete;
    }

    /**
     * Description: Update a User by Id
     * 
     * @param id, userUpdated
     */
    public void updateUser(int id, User userUpdated) {
        User ab = getUsersFor(id).get(0);
        ab.setName(userUpdated.getName());
    }
}