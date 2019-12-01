/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: UserBean.java
 * Course materials (19F) CST 8277
 * @author Vi Pham
 *
 * @date 2019 11
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

    // TODO - methods to handle CRUD for User entity
    public List<User> getUsersFor(int userId) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :tempID").setParameter("tempID", userId);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public List<User> getUsersByName(String name) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.name = :name").setParameter("name", name);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public User addUser(User newUser) {
        em.persist(newUser);
        return newUser;
    }

    public User deleteUser(int deletedID) {
        User delete = em.find(User.class, deletedID);
        em.remove(delete);
        return delete;
    }

    public User updateUser(int id, User userUpdated) {
        em.merge(userUpdated);
        return userUpdated;
    }
}