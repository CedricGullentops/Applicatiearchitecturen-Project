package Beans;

import Beans.Reservaties;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-02T20:03:48")
@StaticMetamodel(Klanten.class)
public class Klanten_ { 

    public static volatile CollectionAttribute<Klanten, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Klanten, String> paswoord;
    public static volatile SingularAttribute<Klanten, String> naam;
    public static volatile SingularAttribute<Klanten, String> email;

}