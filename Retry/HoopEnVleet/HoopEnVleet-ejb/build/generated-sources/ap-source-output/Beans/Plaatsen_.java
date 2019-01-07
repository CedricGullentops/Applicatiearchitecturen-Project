package Beans;

import Beans.Reservaties;
import Beans.Shows;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-07T15:49:41")
@StaticMetamodel(Plaatsen.class)
public class Plaatsen_ { 

    public static volatile SingularAttribute<Plaatsen, BigInteger> kolom;
    public static volatile SingularAttribute<Plaatsen, BigInteger> rij;
    public static volatile CollectionAttribute<Plaatsen, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Plaatsen, Shows> showid;
    public static volatile SingularAttribute<Plaatsen, Character> vrij;
    public static volatile SingularAttribute<Plaatsen, BigDecimal> plaatsid;
    public static volatile SingularAttribute<Plaatsen, BigInteger> prijs;

}