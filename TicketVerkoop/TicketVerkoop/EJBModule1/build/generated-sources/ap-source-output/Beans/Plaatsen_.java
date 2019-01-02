package Beans;

import Beans.Reservaties;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T16:14:08")
@StaticMetamodel(Plaatsen.class)
public class Plaatsen_ { 

    public static volatile SingularAttribute<Plaatsen, BigInteger> kolom;
    public static volatile SingularAttribute<Plaatsen, BigInteger> rij;
    public static volatile CollectionAttribute<Plaatsen, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Plaatsen, BigDecimal> plaatsid;
    public static volatile SingularAttribute<Plaatsen, BigInteger> prijs;

}