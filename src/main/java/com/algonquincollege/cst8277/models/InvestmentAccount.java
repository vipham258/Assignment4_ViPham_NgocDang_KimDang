/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: InvestmentAccount.java
 * Course materials (19F) CST 8277
 * @author Mike Norman
 *
 * @date 2019 10
 */
package com.algonquincollege.cst8277.models;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * The persistent class for the ACCOUNT database table.
 * @author Vi Pham, Ngoc Dang, Ngan Dang
 * @date Nov 2019
 */
@Entity
@DiscriminatorValue(value = "I")
public class InvestmentAccount extends AccountBase implements Serializable {
    /** explicit set serialVersionUID */
    private static final long serialVersionUID = 1L;
    /**portfolio*/
    private Portfolio portfolio;

    public InvestmentAccount() {
    }
    /**
     * get portfolio
     * @return portfolio
     */

    // uni-directional one-to-one association to Portfolio
    // TODO - finish the @OneToOne mapping
    @OneToOne
    @JoinColumn(name = "PORTFOLIO_ID")
    public Portfolio getPortfolio() {
        return this.portfolio;
    }
    /**
     * set portfolio
     * @param portfolio
     */
    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

}