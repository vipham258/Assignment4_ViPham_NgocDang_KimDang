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
        Query query = em.createQuery("SELECT u FROM AccountBase u WHERE u.id = :accountID").setParameter("accountID",
                accountId);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public AccountBase addBankAccount(AccountBase newAccount) {
        em.persist(newAccount);
        return newAccount;
    }

    public void deleteBankAccount(int deletedAccountID) {
        AccountBase deleteAccount = em.find(AccountBase.class, deletedAccountID);
        em.remove(deleteAccount);
    }
}