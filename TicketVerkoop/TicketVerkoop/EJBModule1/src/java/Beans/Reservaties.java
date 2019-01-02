/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jarrit
 */
@Entity
@Table(name = "RESERVATIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reservaties.findAll", query = "SELECT r FROM Reservaties r")
    , @NamedQuery(name = "Reservaties.findByCode", query = "SELECT r FROM Reservaties r WHERE r.code = :code")
    , @NamedQuery(name = "Reservaties.findByLocked", query = "SELECT r FROM Reservaties r WHERE r.locked = :locked")
    ,@NamedQuery(name="LaatsteReservatie",query="SELECT max(r.code) FROM Reservaties r ")})
public class Reservaties implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE")
    private BigDecimal code;
    @Column(name = "LOCKED")
    private Character locked;
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL")
    @ManyToOne
    private String email;
    @JoinColumn(name = "PLAATSID", referencedColumnName = "PLAATSID")
    @ManyToOne
    private BigDecimal plaatsid;
    @JoinColumn(name = "SHOWID", referencedColumnName = "SHOWID")
    @ManyToOne
    private BigDecimal showid;

    public Reservaties() {
    }

    public Reservaties(BigDecimal code) {
        this.code = code;
    }

    public BigDecimal getCode() {
        return code;
    }

    public void setCode(BigDecimal code) {
        this.code = code;
    }

    public Character getLocked() {
        return locked;
    }

    public void setLocked(Character locked) {
        this.locked = locked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPlaatsid() {
        return plaatsid;
    }

    public void setPlaatsid(BigDecimal plaatsid) {
        this.plaatsid = plaatsid;
    }

    public BigDecimal getShowid() {
        return showid;
    }

    public void setShowid(BigDecimal showid) {
        this.showid = showid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservaties)) {
            return false;
        }
        Reservaties other = (Reservaties) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Reservaties[ code=" + code + " ]";
    }
    
}
