package Beans;

import Beans.Reservaties;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-21T16:14:08")
@StaticMetamodel(Shows.class)
public class Shows_ { 

    public static volatile SingularAttribute<Shows, BigDecimal> showid;
    public static volatile CollectionAttribute<Shows, Reservaties> reservatiesCollection;
    public static volatile SingularAttribute<Shows, Date> dag;
    public static volatile SingularAttribute<Shows, String> naam;

}