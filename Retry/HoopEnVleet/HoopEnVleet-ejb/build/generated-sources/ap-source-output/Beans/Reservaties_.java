package Beans;

import Beans.Klanten;
import Beans.Plaatsen;
import Beans.Shows;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-01-07T15:49:41")
@StaticMetamodel(Reservaties.class)
public class Reservaties_ { 

    public static volatile SingularAttribute<Reservaties, BigDecimal> code;
    public static volatile SingularAttribute<Reservaties, Shows> showid;
    public static volatile SingularAttribute<Reservaties, Character> locked;
    public static volatile SingularAttribute<Reservaties, Klanten> email;
    public static volatile SingularAttribute<Reservaties, Plaatsen> plaatsid;

}