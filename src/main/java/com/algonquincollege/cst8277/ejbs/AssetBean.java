/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: UserBean.java
 * Course materials (19F) CST 8277
 * @author Vi Pham
 *
 * @date 2019 11 30
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

    /**
     * Description: a list of asset from Asset table
     * 
     * @param Asset Id
     * @return a list of asset
     */
    // TODO - methods to handle CRUD for User entity
    public List<Asset> getAsset(int id) {
        Query query = em.createQuery("SELECT u FROM Asset u WHERE u.id = :tempID").setParameter("tempID", id);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    public List<Asset> getAssetByName(String name) {
        Query query = em.createQuery("SELECT u FROM Asset u WHERE u.name = :name").setParameter("name", name);
        System.out.print(query.getFirstResult());
        return query.getResultList();
    }

    /**
     * Description: Add a new Asset
     * 
     * @param a new Asset
     * @return a new Asset
     */
    public Asset addAsset(Asset newAsset) {
        em.persist(newAsset);
        return newAsset;
    }

    /**
     * Description: Delete a Asset by Id
     * 
     * @param Asset Id
     * @return deleted Asset
     */
    public Asset deleteAsset(int deletedID) {
        Asset delete = em.find(Asset.class, deletedID);
        em.remove(delete);
        return delete;
    }

    /**
     * Description: Update a Asset by Id
     * 
     * @param Asset Id, asset to be updated
     */
    public void updateAsset(int id, Asset assetUpdated) {
        Asset ab = getAsset(id).get(0);
        ab.setUnits(assetUpdated.getUnits());
        ab.setPrice(assetUpdated.getPrice());
    }
}