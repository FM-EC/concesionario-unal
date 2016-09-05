/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * @author FABIAN
 */
@Entity
@Table(name = "sales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sales.findAll", query = "SELECT s FROM Sales s"),
    @NamedQuery(name = "Sales.findByIdSales", query = "SELECT s FROM Sales s WHERE s.idSales = :idSales"),
    @NamedQuery(name = "Sales.findByTotalValue", query = "SELECT s FROM Sales s WHERE s.totalValue = :totalValue"),
    @NamedQuery(name = "Sales.findBySaleType", query = "SELECT s FROM Sales s WHERE s.saleType = :saleType"),
    @NamedQuery(name = "Sales.findBySaleDate", query = "SELECT s FROM Sales s WHERE s.saleDate = :saleDate"),
    @NamedQuery(name = "Sales.findByIdUser", query = "SELECT s FROM Sales s WHERE s.idUser = :idUser")})
public class Sales implements Serializable {

    @OneToMany(mappedBy = "idVenta")
    private Collection<Cars> carsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSales")
    private Integer idSales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalValue")
    private float totalValue;
    @Size(max = 45)
    @Column(name = "saleType")
    private String saleType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "saleDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date saleDate;
    @JoinColumn(name = "idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client idClient;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Profile idUser;

    public Sales() {
    }

    public Sales(Integer idSales) {
        this.idSales = idSales;
    }

    public Sales(Integer idSales, float totalValue, Date saleDate) {
        this.idSales = idSales;
        this.totalValue = totalValue;
        this.saleDate = saleDate;
    }

    public Integer getIdSales() {
        return idSales;
    }

    public void setIdSales(Integer idSales) {
        this.idSales = idSales;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Client getIdClient() {
        return idClient;
    }

    public void setIdClient(Client idClient) {
        this.idClient = idClient;
    }

    public Profile getIdUser() {
        return idUser;
    }

    public void setIdUser(Profile idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSales != null ? idSales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sales)) {
            return false;
        }
        Sales other = (Sales) object;
        if ((this.idSales == null && other.idSales != null) || (this.idSales != null && !this.idSales.equals(other.idSales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.Sales[ idSales=" + idSales + " ]";
    }

    @XmlTransient
    public Collection<Cars> getCarsCollection() {
        return carsCollection;
    }

    public void setCarsCollection(Collection<Cars> carsCollection) {
        this.carsCollection = carsCollection;
    }
    
}
