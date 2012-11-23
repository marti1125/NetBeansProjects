/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mypackage;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author willy
 */
@Entity
@Table(name = "CD")
@NamedQueries({
    @NamedQuery(name = "Cd.findAll", query = "SELECT c FROM Cd c"),
    @NamedQuery(name = "Cd.findByCdId", query = "SELECT c FROM Cd c WHERE c.cdId = :cdId"),
    @NamedQuery(name = "Cd.findByTitle", query = "SELECT c FROM Cd c WHERE c.title = :title"),
    @NamedQuery(name = "Cd.findByAuthor", query = "SELECT c FROM Cd c WHERE c.author = :author"),
    @NamedQuery(name = "Cd.findByYearCreated", query = "SELECT c FROM Cd c WHERE c.yearCreated = :yearCreated"),
    @NamedQuery(name = "Cd.findByLocation", query = "SELECT c FROM Cd c WHERE c.location = :location"),
    @NamedQuery(name = "Cd.findByRating", query = "SELECT c FROM Cd c WHERE c.rating = :rating")})
public class Cd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_ID")
    private Integer cdId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "AUTHOR")
    private String author;
    @Column(name = "YEAR_CREATED")
    private Integer yearCreated;
    @Column(name = "LOCATION")
    private Integer location;
    @Column(name = "RATING")
    private Integer rating;

    public Cd() {
    }

    public Cd(Integer cdId) {
        this.cdId = cdId;
    }

    public Integer getCdId() {
        return cdId;
    }

    public void setCdId(Integer cdId) {
        this.cdId = cdId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(Integer yearCreated) {
        this.yearCreated = yearCreated;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdId != null ? cdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cd)) {
            return false;
        }
        Cd other = (Cd) object;
        if ((this.cdId == null && other.cdId != null) || (this.cdId != null && !this.cdId.equals(other.cdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mypackage.Cd[cdId=" + cdId + "]";
    }

}
