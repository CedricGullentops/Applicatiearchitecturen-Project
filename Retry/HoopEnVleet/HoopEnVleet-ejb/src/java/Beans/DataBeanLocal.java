/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Jarrit
 */
@Local
public interface DataBeanLocal {

    public List getShowNames();

    public List getShowDates();

    public int getShowid(String name);

    public List getOpenSeats(int showid);

    public BigDecimal addReservatie(String email, BigDecimal pid, int sid);

    public void addKlant(String email, String naam, String pwd);

    public boolean getKlant(String email);
    
}
