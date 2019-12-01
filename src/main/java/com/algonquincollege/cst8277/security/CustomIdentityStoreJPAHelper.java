/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: CustomIdentityStoreJPAHelper.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 * @date 2019 10
 */
package com.algonquincollege.cst8277.security;

import static com.algonquincollege.cst8277.util.MyConstants.FIND_PLATFORM_USER_BY_NAME_JPQL;
import static com.algonquincollege.cst8277.util.MyConstants.NAME_PARAM;
import static com.algonquincollege.cst8277.util.MyConstants.PU_NAME;
import static java.util.Collections.emptySet;

import java.util.Set;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import com.algonquincollege.cst8277.models.PlatformRole;
import com.algonquincollege.cst8277.models.PlatformUser;
/**
 * @author Vi Pham, Ngoc Dang, Ngan Dang
 * @date Nov 2019
 */
@Singleton
public class CustomIdentityStoreJPAHelper {

    @PersistenceContext(name = PU_NAME)
    protected EntityManager em;

    @Inject
    protected Pbkdf2PasswordHash pbAndjPasswordHash;

    /**
     * find users by name
     * @param username
     * @return platformUser
     */
    public PlatformUser findUserByName(String username) {
        PlatformUser platformUser = null;
        try {
            TypedQuery<PlatformUser> q = em.createQuery(FIND_PLATFORM_USER_BY_NAME_JPQL, PlatformUser.class);
            q.setParameter(NAME_PARAM, username);
            platformUser = q.getSingleResult();
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return platformUser;
    }

//    public PlatformUser findUserByPassword(String callerName, String password) {
//        // the nickname of this Hash algorithm is 'PBandJ' (Peanut-Butter-And-Jam, like
//        // the sandwich!)
//        Map<String, String> pbAndjProperties = new HashMap<>();
//        pbAndjProperties.put(PROPERTY_ALGORITHM, DEFAULT_PROPERTY_ALGORITHM);
//        pbAndjProperties.put(PROPERTY_ITERATIONS, DEFAULT_PROPERTY_ITERATIONS);
//        pbAndjProperties.put(PROPERTY_SALTSIZE, DEFAULT_SALT_SIZE);
//        pbAndjProperties.put(PROPERTY_KEYSIZE, DEFAULT_KEY_SIZE);
//        pbAndjPasswordHash.initialize(pbAndjProperties);
//        PlatformUser platformUser = new PlatformUser();
////        if (USER_CALLER.equalsIgnoreCase(callerName)) {
////            platformUser.setUsername(USER_CALLER);
////            String pwHash = pbAndjPasswordHash.generate(USER_PASSWD.toCharArray());
////            platformUser.setPwHash(pwHash);
////        }
//        if (DEFAULT_ADMIN_USER.equalsIgnoreCase(callerName)) {
//            platformUser.setUsername(DEFAULT_ADMIN_USER);
//            String pwHash = pbAndjPasswordHash.generate(ADMIN_USER_PASSWORD.toCharArray());
//            platformUser.setPwHash(pwHash);
//
//        }
//        return platformUser;
//    }
    /**
     * find roles for user
     * @param username
     * @return roles is found
     */
    public Set<PlatformRole> findRolesForUser(String username) {
        Set<PlatformRole> foundRoles = emptySet();
        PlatformUser platformUser = findUserByName(username);
        if (platformUser != null) {
            foundRoles = platformUser.getPlatformRoles();
        }
        return foundRoles;
    }
    /**
     * save platform user
     * @param platformUser
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void savePlatformUser(PlatformUser platformUser) {
        em.persist(platformUser);
    }
    /**
     * save platform role
     * @param platformRole
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void savePlatformRole(PlatformRole platformRole) {
        em.persist(platformRole);
    }

}