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

    public List<AccountBase> getBankAccountsByBalance(double b) {
        Query query = em.createQuery("SELECT u FROM AccountBase u WHERE u.balance = :b").setParameter("b", b);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public AccountBase addBankAccount(AccountBase newAccount) {
        em.persist(newAccount);
        return newAccount;
    }

    public AccountBase deleteBankAccount(int deletedAccountID) {
        AccountBase deleteAccount = em.find(AccountBase.class, deletedAccountID);
        em.remove(deleteAccount);
        return deleteAccount;
    }

    public AccountBase updateBankAccount(int id, AccountBase accountUpdated) {
        // AccountBase ab = em.find(AccountBase.class, id);
        em.merge(accountUpdated);
//        // List<AccountBase> accountList = getBankAccountsFor(id);
//        // accountList.get(0).setVersion(accountUpdated.getVersion());
////        accountList.get(0).setBalance(accountUpdated.getBalance());
////        accountList.get(0).setCreateDate(accountUpdated.getCreateDate());
////        accountList.get(0).setUpdateDate(accountUpdated.getUpdateDate());
////        accountList.get(0).setOwners(accountUpdated.getOwners());
//        boolean success = false;
//        while (!success) {
//            try {
//                // start transaction, read entity, update it and commit
//                ab.setVersion(accountUpdated.getVersion());
////                ab.setBalance(accountUpdated.getBalance());
////                ab.setCreateDate(accountUpdated.getCreateDate());
////                ab.setUpdateDate(accountUpdated.getUpdateDate());
////                ab.setOwners(accountUpdated.getOwners());
////                em.merge(ab);
//                success = true;
//            } catch (OptimisticLockException ex) {
//                // log your error
//            }
//        }

        return accountUpdated;
    }
}