/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jarrit
 */
@Entity
@Table(name = "GROEPEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Groepen.findAll", query = "SELECT g FROM Groepen g")
    , @NamedQuery(name = "Groepen.findByEmail", query = "SELECT g FROM Groepen g WHERE g.email = :email")
    , @NamedQuery(name = "Groepen.findByGroep", query = "SELECT g FROM Groepen g WHERE g.groep = :groep")})
public class Groepen implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "GROEP")
    private String groep;
    @JoinColumn(name = "EMAIL", referencedColumnName = "EMAIL", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Klanten klanten;

    public Groepen() {
    }

    public Groepen(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGroep() {
        return groep;
    }

    public void setGroep(String groep) {
        this.groep = groep;
    }

    public Klanten getKlanten() {
        return klanten;
    }

    public void setKlanten(Klanten klanten) {
        this.klanten = klanten;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (email != null ? email.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groepen)) {
            return false;
        }
        Groepen other = (Groepen) object;
        if ((this.email == null && other.email != null) || (this.email != null && !this.email.equals(other.email))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Groepen[ email=" + email + " ]";
    }
    
}
