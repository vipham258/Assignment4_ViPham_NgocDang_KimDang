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

import com.algonquincollege.cst8277.models.Asset;

@Stateless
public class AssetBean {

    @PersistenceContext(unitName = PU_NAME)
    protected EntityManager em;

    // TODO - methods to handle CRUD for User entity
    public List<Asset> getAsset(int id) {
        Query query = em.createQuery("SELECT u FROM Asset u WHERE u.id = :tempID").setParameter("tempID", id);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public Asset addAsset(Asset newAsset) {
        em.persist(newAsset);
        return newAsset;
    }

    public Asset deleteAsset(int deletedID) {
        Asset delete = em.find(Asset.class, deletedID);
        em.remove(delete);
        return delete;
    }

    public Asset updateAsset(int id, Asset assetUpdated) {
        em.merge(assetUpdated);
        return assetUpdated;
    }
}