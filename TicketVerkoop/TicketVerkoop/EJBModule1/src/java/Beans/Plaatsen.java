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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jarrit
 */
@Entity
@Table(name = "PLAATSEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plaatsen.findAll", query = "SELECT p FROM Plaatsen p")
    , @NamedQuery(name = "Plaatsen.findByPlaatsid", query = "SELECT p FROM Plaatsen p WHERE p.plaatsid = :plaatsid")
    , @NamedQuery(name = "Plaatsen.findByPrijs", query = "SELECT p FROM Plaatsen p WHERE p.prijs = :prijs")
    , @NamedQuery(name = "Plaatsen.findByRij", query = "SELECT p FROM Plaatsen p WHERE p.rij = :rij")
    , @NamedQuery(name = "Plaatsen.findByKolom", query = "SELECT p FROM Plaatsen p WHERE p.kolom = :kolom")})
public class Plaatsen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLAATSID")
    private BigDecimal plaatsid;
    @Column(name = "PRIJS")
    private BigInteger prijs;
    @Column(name = "RIJ")
    private BigInteger rij;
    @Column(name = "KOLOM")
    private BigInteger kolom;
    @OneToMany(mappedBy = "plaatsid")
    private Collection<Reservaties> reservatiesCollection;

    public Plaatsen() {
    }

    public Plaatsen(BigDecimal plaatsid) {
        this.plaatsid = plaatsid;
    }

    public BigDecimal getPlaatsid() {
        return plaatsid;
    }

    public void setPlaatsid(BigDecimal plaatsid) {
        this.plaatsid = plaatsid;
    }

    public BigInteger getPrijs() {
        return prijs;
    }

    public void setPrijs(BigInteger prijs) {
        this.prijs = prijs;
    }

    public BigInteger getRij() {
        return rij;
    }

    public void setRij(BigInteger rij) {
        this.rij = rij;
    }

    public BigInteger getKolom() {
        return kolom;
    }

    public void setKolom(BigInteger kolom) {
        this.kolom = kolom;
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
        hash += (plaatsid != null ? plaatsid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plaatsen)) {
            return false;
        }
        Plaatsen other = (Plaatsen) object;
        if ((this.plaatsid == null && other.plaatsid != null) || (this.plaatsid != null && !this.plaatsid.equals(other.plaatsid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Plaatsen[ plaatsid=" + plaatsid + " ]";
    }
    
}
