/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: UserBean.java
 * Course materials (19F) CST 8277
 * @author Vi Pham
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

import com.algonquincollege.cst8277.models.Portfolio;

@Stateless
public class PortfolioBean {

    @PersistenceContext(unitName = PU_NAME)
    protected EntityManager em;

    /**
     * Description: a list of Portfolio from Portfolio table
     * 
     * @param Portfolio Id
     * @return a list of Portfolio
     */
    // TODO - methods to handle CRUD for User entity
    public List<Portfolio> getPortfolio(int id) {
        Query query = em.createQuery("SELECT u FROM Portfolio u WHERE u.id = :tempID").setParameter("tempID", id);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public List<Portfolio> getPortfolioByBalance(double b) {
        Query query = em.createQuery("SELECT u FROM Portfolio u WHERE u.balance = :b").setParameter("b", b);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: Add a new Portfolio
     * 
     * @param a new Portfolio
     * @return a new Portfolio
     */

    public Portfolio addPortfolio(Portfolio newPortfolio) {
        em.persist(newPortfolio);
        return newPortfolio;
    }

    /**
     * Description: Delete a Portfolio by Id
     * 
     * @param Portfolio Id
     * @return deleted Portfolio
     */
    public Portfolio deletePortfolio(int deletedID) {
        Portfolio delete = em.find(Portfolio.class, deletedID);
        em.remove(delete);
        return delete;
    }

    /**
     * Description: Delete a Portfolio by Id
     * 
     * @param Portfolio Id
     * @return deleted Portfolio
     */
    public void updatePortfolio(int id, Portfolio portfolioUpdated) {
        Portfolio ab = getPortfolio(id).get(0);
        ab.setBalance(portfolioUpdated.getBalance());
    }
}