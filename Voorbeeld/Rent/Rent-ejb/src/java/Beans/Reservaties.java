/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author student
 */
@Entity
@Table(name = "RESERVATIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaties.findAll", query = "SELECT r FROM Reservaties r")
    , @NamedQuery(name = "Reservaties.findByRnr", query = "SELECT r FROM Reservaties r WHERE r.rnr = :rnr")
    , @NamedQuery(name = "Reservaties.findByDatumres", query = "SELECT r FROM Reservaties r WHERE r.datumres = :datumres")
    , @NamedQuery(name = "Reservaties.findByDatumvan", query = "SELECT r FROM Reservaties r WHERE r.datumvan = :datumvan")
    , @NamedQuery(name = "Reservaties.findByDagen", query = "SELECT r FROM Reservaties r WHERE r.dagen = :dagen")
    , @NamedQuery(name = "Reservaties.laatste", query = "SELECT max(r.rnr) FROM Reservaties r ")})
public class Reservaties implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "RNR")
    private BigDecimal rnr;
    @Column(name = "DATUMRES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumres;
    @Column(name = "DATUMVAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datumvan;
    @Column(name = "DAGEN")
    private BigInteger dagen;
    @JoinColumn(name = "KNR", referencedColumnName = "KNR")
    @ManyToOne
    private Klanten knr;
    @JoinColumn(name = "LNRN", referencedColumnName = "LNR")
    @ManyToOne
    private Locaties lnrn;
    @JoinColumn(name = "LNRV", referencedColumnName = "LNR")
    @ManyToOne
    private Locaties lnrv;
    @JoinColumn(name = "WNR", referencedColumnName = "WNR")
    @ManyToOne
    private Wagens wnr;

    public Reservaties() {
    }

    public Reservaties(BigDecimal rnr) {
        this.rnr = rnr;
    }

    public BigDecimal getRnr() {
        return rnr;
    }

    public void setRnr(BigDecimal rnr) {
        this.rnr = rnr;
    }

    public Date getDatumres() {
        return datumres;
    }

    public void setDatumres(Date datumres) {
        this.datumres = datumres;
    }

    public Date getDatumvan() {
        return datumvan;
    }

    public void setDatumvan(Date datumvan) {
        this.datumvan = datumvan;
    }

    public BigInteger getDagen() {
        return dagen;
    }

    public void setDagen(BigInteger dagen) {
        this.dagen = dagen;
    }

    public Klanten getKnr() {
        return knr;
    }

    public void setKnr(Klanten knr) {
        this.knr = knr;
    }

    public Locaties getLnrn() {
        return lnrn;
    }

    public void setLnrn(Locaties lnrn) {
        this.lnrn = lnrn;
    }

    public Locaties getLnrv() {
        return lnrv;
    }

    public void setLnrv(Locaties lnrv) {
        this.lnrv = lnrv;
    }

    public Wagens getWnr() {
        return wnr;
    }

    public void setWnr(Wagens wnr) {
        this.wnr = wnr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rnr != null ? rnr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaties)) {
            return false;
        }
        Reservaties other = (Reservaties) object;
        if ((this.rnr == null && other.rnr != null) || (this.rnr != null && !this.rnr.equals(other.rnr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Reservaties[ rnr=" + rnr + " ]";
    }
    
}
