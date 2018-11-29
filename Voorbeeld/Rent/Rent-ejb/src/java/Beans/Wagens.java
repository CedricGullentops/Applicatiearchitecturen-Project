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
@Table(name = "WAGENS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wagens.findAll", query = "SELECT w FROM Wagens w")
    , @NamedQuery(name = "Wagens.findByWnr", query = "SELECT w FROM Wagens w WHERE w.wnr = :wnr")
    , @NamedQuery(name = "Wagens.findAllWag", query = "SELECT w.wnaam FROM Wagens w")
    , @NamedQuery(name = "Wagens.findByWnaam", query = "SELECT w FROM Wagens w WHERE w.wnaam = :wnaam")
    , @NamedQuery(name = "Wagens.findByPrijs", query = "SELECT w FROM Wagens w WHERE w.prijs = :prijs")})
public class Wagens implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "WNR")
    private BigDecimal wnr;
    @Size(max = 20)
    @Column(name = "WNAAM")
    private String wnaam;
    @Column(name = "PRIJS")
    private BigInteger prijs;
    @OneToMany(mappedBy = "wnr")
    private Collection<Reservaties> reservatiesCollection;

    public Wagens() {
    }

    public Wagens(BigDecimal wnr) {
        this.wnr = wnr;
    }

    public BigDecimal getWnr() {
        return wnr;
    }

    public void setWnr(BigDecimal wnr) {
        this.wnr = wnr;
    }

    public String getWnaam() {
        return wnaam;
    }

    public void setWnaam(String wnaam) {
        this.wnaam = wnaam;
    }

    public BigInteger getPrijs() {
        return prijs;
    }

    public void setPrijs(BigInteger prijs) {
        this.prijs = prijs;
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
        hash += (wnr != null ? wnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wagens)) {
            return false;
        }
        Wagens other = (Wagens) object;
        if ((this.wnr == null && other.wnr != null) || (this.wnr != null && !this.wnr.equals(other.wnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Wagens[ wnr=" + wnr + " ]";
    }
    
}
