package Beans;

import Beans.Reservaties;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-07T15:47:53")
@StaticMetamodel(Klanten.class)
public class Klanten_ { 

    public static volatile CollectionAttribute<Klanten, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Klanten, BigInteger> postcode;
    public static volatile SingularAttribute<Klanten, String> adres;
    public static volatile SingularAttribute<Klanten, String> knaam;
    public static volatile SingularAttribute<Klanten, String> gemeente;
    public static volatile SingularAttribute<Klanten, BigDecimal> knr;

}