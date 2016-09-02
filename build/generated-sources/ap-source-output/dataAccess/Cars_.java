package dataAccess;

import dataAccess.Provider;
import dataAccess.Purchases;
import dataAccess.Sales;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-02T12:41:28")
@StaticMetamodel(Cars.class)
public class Cars_ { 

    public static volatile SingularAttribute<Cars, Boolean> sold;
    public static volatile SingularAttribute<Cars, String> color;
    public static volatile SingularAttribute<Cars, String> engineNumber;
    public static volatile SingularAttribute<Cars, Float> salesPrice;
    public static volatile SingularAttribute<Cars, Float> purchasePrice;
    public static volatile SingularAttribute<Cars, Integer> idCar;
    public static volatile SingularAttribute<Cars, Sales> idVenta;
    public static volatile SingularAttribute<Cars, Provider> idProvider;
    public static volatile CollectionAttribute<Cars, Purchases> purchasesCollection;
    public static volatile SingularAttribute<Cars, String> chasisNumber;
    public static volatile SingularAttribute<Cars, String> model;
    public static volatile SingularAttribute<Cars, String> transmissionType;
    public static volatile SingularAttribute<Cars, String> brand;
    public static volatile SingularAttribute<Cars, String> carriagePlate;

}