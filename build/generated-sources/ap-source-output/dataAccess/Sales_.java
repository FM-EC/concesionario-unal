package dataAccess;

import dataAccess.Client;
import dataAccess.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-02T13:10:18")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Float> totalValue;
    public static volatile SingularAttribute<Sales, Profile> idUser;
    public static volatile SingularAttribute<Sales, Integer> idSales;
    public static volatile SingularAttribute<Sales, Client> idClient;
    public static volatile SingularAttribute<Sales, String> saleType;
    public static volatile SingularAttribute<Sales, Date> saleDate;

}