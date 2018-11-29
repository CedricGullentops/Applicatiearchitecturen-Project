package Beans;

import Beans.Klanten;
import Beans.Locaties;
import Beans.Wagens;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-11-07T15:47:53")
@StaticMetamodel(Reservaties.class)
public class Reservaties_ { 

    public static volatile SingularAttribute<Reservaties, Locaties> lnrv;
    public static volatile SingularAttribute<Reservaties, BigDecimal> rnr;
    public static volatile SingularAttribute<Reservaties, Date> datumres;
    public static volatile SingularAttribute<Reservaties, Wagens> wnr;
    public static volatile SingularAttribute<Reservaties, Date> datumvan;
    public static volatile SingularAttribute<Reservaties, Locaties> lnrn;
    public static volatile SingularAttribute<Reservaties, BigInteger> dagen;
    public static volatile SingularAttribute<Reservaties, Klanten> knr;

}