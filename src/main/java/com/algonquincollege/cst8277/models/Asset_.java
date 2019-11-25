package com.algonquincollege.cst8277.models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-11-25T17:30:38.059-0500")
@StaticMetamodel(Asset.class)
public class Asset_ extends ModelBase_ {
	public static volatile SingularAttribute<Asset, Integer> id;
	public static volatile SingularAttribute<Asset, Double> balance;
	public static volatile SingularAttribute<Asset, String> name;
	public static volatile SingularAttribute<Asset, Integer> units;
	public static volatile SingularAttribute<Asset, Double> price;
	public static volatile SingularAttribute<Asset, Portfolio> owner;
}
