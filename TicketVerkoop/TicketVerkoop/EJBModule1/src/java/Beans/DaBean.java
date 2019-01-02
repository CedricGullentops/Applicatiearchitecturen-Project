/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;
import java.math.*;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author student
 */

@Stateless
public class DaBean implements DaBeanLocal {

@PersistenceContext private EntityManager em;


public List getShows(){
        return em.createNamedQuery("Shows.findAllShows").getResultList();       
    }
/*    

    
    public int addKlant(int postcode, String naam, String adres, String gemeente){
        BigDecimal kn = (BigDecimal)em.createNamedQuery("Klanten.laatste").getSingleResult();
        int knr = kn.intValueExact() + 1;
        Klanten klant = new Klanten(knr,postcode, naam, adres, gemeente);
        em.persist(klant);
        return knr;
    }
    
    public boolean getKlant(int klantnr)
    {
        BigDecimal knr = new BigDecimal(klantnr);
        List<Klanten> klantentries = em.createNamedQuery("Klanten.findByKnr").setParameter("knr",knr).getResultList();
        if (klantentries.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    */
    public int addReservatie(char locked, String email, int pid, int sid)
    {
        Reservaties reservatie = new Reservaties();
        BigDecimal code = (BigDecimal)em.createNamedQuery("Reservaties.LaatsteReservatie").getSingleResult();
        int newcode = code.intValueExact() + 1;
        BigDecimal BDcode = new BigDecimal(newcode);
        BigDecimal BDpid = BigDecimal.valueOf(pid);
        BigDecimal BDsid = BigDecimal.valueOf(sid);
        
        reservatie.setCode(BDcode);
        reservatie.setLocked(locked);
        reservatie.setEmail(email);
        reservatie.setPlaatsid(BDpid);
        reservatie.setShowid(BDsid);
        
        em.persist(reservatie);
        return newcode;
    }

    /*
    public void getOvezicht(int klantnr)
    {
        BigDecimal knr = new BigDecimal(klantnr);
        List<Reservaties> reservatielist = em.createNamedQuery("Reservaties.findByKnr").setParameter("knr",knr).getResultList();
    }
         
    public void verwijderRes(int resnr)
    {
        
    }
    

            
*/   
}
