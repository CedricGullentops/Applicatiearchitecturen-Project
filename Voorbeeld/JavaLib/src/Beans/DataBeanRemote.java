/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author student
 */
@Remote
public interface DataBeanRemote {

    public List getLocaties();

    public List getWagens();

    public int addKlant(int postcode, String naam, String adres, String gemeente);
    
}
