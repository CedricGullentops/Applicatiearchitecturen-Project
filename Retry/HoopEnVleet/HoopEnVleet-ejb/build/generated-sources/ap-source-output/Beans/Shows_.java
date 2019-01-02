package Beans;

import Beans.Plaatsen;
import Beans.Reservaties;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-02T20:03:48")
@StaticMetamodel(Shows.class)
public class Shows_ { 

    public static volatile CollectionAttribute<Shows, Plaatsen> plaatsenCollection;
    public static volatile SingularAttribute<Shows, BigDecimal> showid;
    public static volatile CollectionAttribute<Shows, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Shows, Date> dag;
    public static volatile SingularAttribute<Shows, String> naam;

}