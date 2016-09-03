package dataAccess;

import dataAccess.Cars;
import dataAccess.Profile;
import dataAccess.Provider;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-02T13:10:18")
@StaticMetamodel(Purchases.class)
public class Purchases_ { 

    public static volatile SingularAttribute<Purchases, Profile> idUser;
    public static volatile SingularAttribute<Purchases, Integer> idPurchase;
    public static volatile SingularAttribute<Purchases, Date> purchaseDate;
    public static volatile SingularAttribute<Purchases, Provider> idProvider;
    public static volatile SingularAttribute<Purchases, Integer> qty;
    public static volatile SingularAttribute<Purchases, Cars> idCar;

}