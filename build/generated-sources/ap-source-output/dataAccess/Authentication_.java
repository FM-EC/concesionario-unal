package dataAccess;

import dataAccess.Profile;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-02T12:41:28")
@StaticMetamodel(Authentication.class)
public class Authentication_ { 

    public static volatile SingularAttribute<Authentication, Integer> idUser;
    public static volatile SingularAttribute<Authentication, String> password;
    public static volatile SingularAttribute<Authentication, Profile> profile;
    public static volatile SingularAttribute<Authentication, Date> lastAccess;
    public static volatile SingularAttribute<Authentication, String> email;
    public static volatile SingularAttribute<Authentication, String> username;

}