package dataAccess;

import dataAccess.Cars;
import dataAccess.Client;
import dataAccess.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-01T11:34:09")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Float> totalValue;
    public static volatile SingularAttribute<Sales, Profile> idUser;
    public static volatile SingularAttribute<Sales, Integer> idSales;
    public static volatile CollectionAttribute<Sales, Cars> carsCollection;
    public static volatile SingularAttribute<Sales, Client> idClient;
    public static volatile SingularAttribute<Sales, String> saleType;
    public static volatile SingularAttribute<Sales, Date> saleDate;

}