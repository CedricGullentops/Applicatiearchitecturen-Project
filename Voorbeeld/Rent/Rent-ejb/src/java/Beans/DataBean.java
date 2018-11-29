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
public class DataBean implements DataBeanRemote {

@PersistenceContext private EntityManager em;
    public List getWagens(){
        return em.createNamedQuery("Wagens.findAllWag").getResultList();       
    }
    
    public List getLocaties(){
        return em.createNamedQuery("Locaties.findAllLoc").getResultList();
    }
    
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
    
    public void addReservatie(Klanten knr, int dagen, int wnr, Locaties lnrv, Locaties lnrn, String datumvan)
    {
        Reservaties reservatie = new Reservaties();
        BigDecimal rnr = (BigDecimal)em.createNamedQuery("Reservaties.laatste").getSingleResult();
        int rn = rnr.intValueExact() + 1;
        BigDecimal BDrnr = new BigDecimal(rn);
        BigInteger BDdagen = BigInteger.valueOf(dagen);
        
        String[] parts = datumvan.split("-");
        Date BDdatumvan = new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2]));
        Date BDdatumres = BDdatumvan;
        
        reservatie.setRnr(BDrnr);
        reservatie.setDagen(BDdagen);
        reservatie.setDatumvan(BDdatumvan);
        reservatie.setDatumres(BDdatumres);
        reservatie.setLnrv(lnrv);
        reservatie.setLnrn(lnrn);
        
        em.persist(reservatie);
    }
    
    public void getOvezicht(int klantnr)
    {
        BigDecimal knr = new BigDecimal(klantnr);
        List<Reservaties> reservatielist = em.createNamedQuery("Reservaties.findByKnr").setParameter("knr",knr).getResultList();
    }
         
    public void verwijderRes(int resnr)
    {
        
    }
    

            
   
}
