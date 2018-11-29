/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author student
 */
@Entity
@Table(name = "KLANTEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klanten.findAll", query = "SELECT k FROM Klanten k")
    , @NamedQuery(name = "Klanten.findByKnr", query = "SELECT k FROM Klanten k WHERE k.knr = :knr")
    , @NamedQuery(name = "Klanten.findByAdres", query = "SELECT k FROM Klanten k WHERE k.adres = :adres")
    , @NamedQuery(name = "Klanten.findByKnaam", query = "SELECT k FROM Klanten k WHERE k.knaam = :knaam")
    , @NamedQuery(name = "Klanten.findByGemeente", query = "SELECT k FROM Klanten k WHERE k.gemeente = :gemeente")
    , @NamedQuery(name = "Klanten.findByPostcode", query = "SELECT k FROM Klanten k WHERE k.postcode = :postcode")
    , @NamedQuery(name = "Klanten.laatste", query = "SELECT max(k.knr) FROM Klanten k ")})
public class Klanten implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KNR")
    private BigDecimal knr;
    @Size(max = 50)
    @Column(name = "ADRES")
    private String adres;
    @Size(max = 50)
    @Column(name = "KNAAM")
    private String knaam;
    @Size(max = 50)
    @Column(name = "GEMEENTE")
    private String gemeente;
    @Column(name = "POSTCODE")
    private BigInteger postcode;
    @OneToMany(mappedBy = "knr")
    private Collection<Reservaties> reservatiesCollection;

    public Klanten(){        
    }
    
    public Klanten(int knr,int postcode,String knaam,String adres,String gemeente) {
        this.setKnr(new BigDecimal(knr));
        this.setPostcode(BigInteger.valueOf(postcode));
        this.setKnaam(knaam);
        this.setGemeente(gemeente);
        this.setAdres(adres);               
    }

    public Klanten(BigDecimal knr) {
        this.knr = knr;
    }

    public BigDecimal getKnr() {
        return knr;
    }

    public void setKnr(BigDecimal knr) {
        this.knr = knr;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKnaam() {
        return knaam;
    }

    public void setKnaam(String knaam) {
        this.knaam = knaam;
    }

    public String getGemeente() {
        return gemeente;
    }

    public void setGemeente(String gemeente) {
        this.gemeente = gemeente;
    }

    public BigInteger getPostcode() {
        return postcode;
    }

    public void setPostcode(BigInteger postcode) {
        this.postcode = postcode;
    }

    @XmlTransient
    public Collection<Reservaties> getReservatiesCollection() {
        return reservatiesCollection;
    }

    public void setReservatiesCollection(Collection<Reservaties> reservatiesCollection) {
        this.reservatiesCollection = reservatiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (knr != null ? knr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klanten)) {
            return false;
        }
        Klanten other = (Klanten) object;
        if ((this.knr == null && other.knr != null) || (this.knr != null && !this.knr.equals(other.knr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Klanten[ knr=" + knr + " ]";
    }
    
}
