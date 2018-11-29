package Beans;

import Beans.Reservaties;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-07T15:47:53")
@StaticMetamodel(Locaties.class)
public class Locaties_ { 

    public static volatile SingularAttribute<Locaties, BigDecimal> lnr;
    public static volatile CollectionAttribute<Locaties, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Locaties, String> lnaam;
    public static volatile CollectionAttribute<Locaties, Reservaties> reservatiesCollection1;

}