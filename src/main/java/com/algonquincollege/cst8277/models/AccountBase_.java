package com.algonquincollege.cst8277.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-12-01T00:48:15.372-0500")
@StaticMetamodel(AccountBase.class)
public class AccountBase_ extends ModelBase_ {
	public static volatile ListAttribute<AccountBase, User> owners;
	public static volatile SingularAttribute<AccountBase, Double> balance;
	public static volatile SingularAttribute<AccountBase, Integer> id;
}
