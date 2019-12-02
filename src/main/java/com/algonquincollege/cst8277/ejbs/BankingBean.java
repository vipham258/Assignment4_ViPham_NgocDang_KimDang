package com.algonquincollege.cst8277.ejbs;

/***********************
 * File: BankingBean.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @author Vi Pham, Kim Ngan Dang, Nhu Ngoc Dang
 *
 * @date 2019 11 30
 */
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

    /**
     * Description: a list of all accounts from AccountBase table
     * 
     * @param accountId
     * @return a list of bank account
     */
    public List<AccountBase> getBankAccountsFor(int accountId) {
        Query query = em.createQuery("SELECT u FROM AccountBase u WHERE u.id = :accountID").setParameter("accountID",
                accountId);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: a list of all accounts from AccountBase table
     * 
     * @param b
     * @return a list of bank account
     */
    public List<AccountBase> getBankAccountsByBalance(double b) {
        Query query = em.createQuery("SELECT u FROM AccountBase u WHERE u.balance = :b").setParameter("b", b);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: Add a new bank account
     * 
     * @param newAccount
     * @return newAccount
     */

    public AccountBase addBankAccount(AccountBase newAccount) {
        em.persist(newAccount);
        return newAccount;
    }

    /**
     * Description: Delete a bank account by Id
     * 
     * @param deletedAccountID
     * @return deleteAcccount
     */
    public AccountBase deleteBankAccount(int deletedAccountID) {

        AccountBase deleteAccount = em.find(AccountBase.class, deletedAccountID);
        em.remove(deleteAccount);
        return deleteAccount;
    }

    /**
     * Description: Update a bank account by Id
     * 
     * @param id, accountUpdated
     */
    public void updateBankAccount(int id, AccountBase accountUpdated) {
        AccountBase ab = getBankAccountsFor(id).get(0);
        ab.setBalance(accountUpdated.getBalance());
    }
}