/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: BankingBean.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.ejbs;

import static com.algonquincollege.cst8277.util.MyConstants.PU_NAME;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.algonquincollege.cst8277.models.AccountBase;

@Stateless
public class BankingBean {

    @PersistenceContext(unitName = PU_NAME)
    protected EntityManager em;

    // TODO - methods to handle CRUD for Banking entities
    public List<AccountBase> getBankAccountsFor(int accountId) {
        Query query = em.createQuery("SELECT a FROM AccountBase a where a.id LIKE : aID").setParameter("aID",
                accountId);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public void addBankAccount() {
    }
}