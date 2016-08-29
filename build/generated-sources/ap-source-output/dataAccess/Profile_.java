package dataAccess;

import dataAccess.Authentication;
import dataAccess.Purchases;
import dataAccess.Roles;
import dataAccess.Sales;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-28T17:43:59")
@StaticMetamodel(Profile.class)
public class Profile_ { 

    public static volatile SingularAttribute<Profile, Integer> idUser;
    public static volatile CollectionAttribute<Profile, Sales> salesCollection;
    public static volatile SingularAttribute<Profile, String> lastName;
    public static volatile SingularAttribute<Profile, String> address;
    public static volatile SingularAttribute<Profile, String> phone;
    public static volatile SingularAttribute<Profile, String> city;
    public static volatile CollectionAttribute<Profile, Purchases> purchasesCollection;
    public static volatile SingularAttribute<Profile, String> name;
    public static volatile CollectionAttribute<Profile, Roles> rolesCollection;
    public static volatile SingularAttribute<Profile, Authentication> authentication;

}