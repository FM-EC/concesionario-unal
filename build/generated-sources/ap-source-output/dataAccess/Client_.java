package dataAccess;

import dataAccess.Sales;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-01T11:34:09")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile CollectionAttribute<Client, Sales> salesCollection;
    public static volatile SingularAttribute<Client, String> lastName;
    public static volatile SingularAttribute<Client, String> address;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile SingularAttribute<Client, String> email;

}