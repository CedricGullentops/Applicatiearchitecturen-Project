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
public class DataBean implements DataBeanLocal {

@PersistenceContext private EntityManager em;


@Override
public List getShowNames(){
        return em.createNamedQuery("Shows.findNames").getResultList();       
    }
    @Override
    public List getShowDates() {
        return em.createNamedQuery("Shows.findDates").getResultList();
    }
@Override
    public List getOpenSeats(int id){        
        Query query = em.createNamedQuery("Shows.findByShowid");
        query.setParameter("showid", new BigDecimal(id));
        Shows S = (Shows) query.getSingleResult();
        query = em.createNamedQuery("Plaatsen.findFreeByShowid");
        query.setParameter("showid", (Shows) S);
        return query.getResultList(); 
    }
@Override
    public int getShowid(String name){
        Query query = em.createNamedQuery("Shows.findIdByNaam");
        query.setParameter("naam", name);
        BigDecimal x = (BigDecimal)query.getSingleResult();        
        return x.intValueExact();
    }
 

    
@Override
    public void addKlant(String email, String naam, String paswoord){
        Klanten klant = new Klanten();
        klant.setEmail(email);
        klant.setNaam(naam);
        klant.setPaswoord(paswoord);
        em.persist(klant);
    }
/*       
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
@Override
    public BigDecimal addReservatie(String email, BigDecimal pid, int sid)
    {
        BigDecimal rcode;
        Query query = em.createNamedQuery("Shows.findByShowid");
        query.setParameter("showid", new BigDecimal(sid));
        Shows S = (Shows) query.getSingleResult();
        query = em.createNamedQuery("Plaatsen.findByPlaatsid");
        query.setParameter("plaatsid", pid);
        Plaatsen P = (Plaatsen) query.getSingleResult();
        query = em.createNamedQuery("Klanten.findByEmail");
        query.setParameter("email",email);
        Klanten K = (Klanten) query.getSingleResult();
        Reservaties reservatie = new Reservaties();
        List results = em.createNamedQuery("Reservaties.LaatsteReservatie").getResultList();
        if(results.get(0) == null){
            rcode =  new BigDecimal(0);
        }
        else{
            rcode = (BigDecimal) results.get(0); 
        }

        rcode = new BigDecimal(rcode.intValueExact() + 1);        
        reservatie.setCode(rcode);
        reservatie.setLocked('0');
        reservatie.setEmail(K);
        reservatie.setPlaatsid(P);
        reservatie.setShowid(S);
        
        em.persist(reservatie);
        query = em.createNamedQuery("Plaatsen.removePlaats");
        query.setParameter("plaatsid", pid);
        query.executeUpdate();
        return rcode;
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
