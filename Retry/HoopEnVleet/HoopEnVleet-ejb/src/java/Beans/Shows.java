/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jarrit
 */
@Entity
@Table(name = "SHOWS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shows.findAll", query = "SELECT s FROM Shows s")
    , @NamedQuery(name = "Shows.findByShowid", query = "SELECT s FROM Shows s WHERE s.showid = :showid")
    , @NamedQuery(name = "Shows.findByNaam", query = "SELECT s FROM Shows s WHERE s.naam = :naam")
    , @NamedQuery(name = "Shows.findByDag", query = "SELECT s FROM Shows s WHERE s.dag = :dag")
    ,@NamedQuery(name = "Shows.findNames", query = "SELECT s.naam FROM Shows s order by s.showid")
    ,@NamedQuery(name = "Shows.findIds", query = "SELECT s.showid FROM Shows s")
    ,@NamedQuery(name = "Shows.findIdByNaam", query = "SELECT s.showid FROM Shows s WHERE s.naam = :naam")
    ,@NamedQuery(name = "Shows.findDates", query = "SELECT s.dag FROM Shows s")})
public class Shows implements Serializable {

    @OneToMany(mappedBy = "showid")
    private Collection<Plaatsen> plaatsenCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SHOWID")
    private BigDecimal showid;
    @Size(max = 20)
    @Column(name = "NAAM")
    private String naam;
    @Column(name = "DAG")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dag;
    @OneToMany(mappedBy = "showid")
    private Collection<Reservaties> reservatiesCollection;

    public Shows() {
    }

    public Shows(BigDecimal showid) {
        this.showid = showid;
    }

    public BigDecimal getShowid() {
        return showid;
    }

    public void setShowid(BigDecimal showid) {
        this.showid = showid;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Date getDag() {
        return dag;
    }

    public void setDag(Date dag) {
        this.dag = dag;
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
        hash += (showid != null ? showid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shows)) {
            return false;
        }
        Shows other = (Shows) object;
        if ((this.showid == null && other.showid != null) || (this.showid != null && !this.showid.equals(other.showid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Shows[ showid=" + showid + " ]";
    }

    @XmlTransient
    public Collection<Plaatsen> getPlaatsenCollection() {
        return plaatsenCollection;
    }

    public void setPlaatsenCollection(Collection<Plaatsen> plaatsenCollection) {
        this.plaatsenCollection = plaatsenCollection;
    }
    
}
