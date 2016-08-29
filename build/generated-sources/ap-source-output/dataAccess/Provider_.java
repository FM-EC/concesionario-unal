package dataAccess;

import dataAccess.Cars;
import dataAccess.Purchases;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-28T17:43:59")
@StaticMetamodel(Provider.class)
public class Provider_ { 

    public static volatile SingularAttribute<Provider, String> address;
    public static volatile CollectionAttribute<Provider, Cars> carsCollection;
    public static volatile SingularAttribute<Provider, Integer> idProvider;
    public static volatile SingularAttribute<Provider, String> phone;
    public static volatile SingularAttribute<Provider, String> companyName;
    public static volatile CollectionAttribute<Provider, Purchases> purchasesCollection;
    public static volatile SingularAttribute<Provider, String> email;

}