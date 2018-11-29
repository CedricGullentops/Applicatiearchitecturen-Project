package Beans;

import Beans.Reservaties;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-07T15:47:53")
@StaticMetamodel(Wagens.class)
public class Wagens_ { 

    public static volatile CollectionAttribute<Wagens, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Wagens, String> wnaam;
    public static volatile SingularAttribute<Wagens, BigDecimal> wnr;
    public static volatile SingularAttribute<Wagens, BigInteger> prijs;

}