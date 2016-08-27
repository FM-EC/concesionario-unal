/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FABIAN
 */
@Entity
@Table(name = "purchases")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchases.findAll", query = "SELECT p FROM Purchases p"),
    @NamedQuery(name = "Purchases.findByIdPurchase", query = "SELECT p FROM Purchases p WHERE p.idPurchase = :idPurchase"),
    @NamedQuery(name = "Purchases.findByPurchaseDate", query = "SELECT p FROM Purchases p WHERE p.purchaseDate = :purchaseDate"),
    @NamedQuery(name = "Purchases.findByQty", query = "SELECT p FROM Purchases p WHERE p.qty = :qty")})
public class Purchases implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPurchase")
    private Integer idPurchase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchaseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @JoinColumn(name = "idCar", referencedColumnName = "idCar")
    @ManyToOne(optional = false)
    private Cars idCar;
    @JoinColumn(name = "idProvider", referencedColumnName = "idProvider")
    @ManyToOne(optional = false)
    private Provider idProvider;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private Profile idUser;

    public Purchases() {
    }

    public Purchases(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Purchases(Integer idPurchase, Date purchaseDate, int qty) {
        this.idPurchase = idPurchase;
        this.purchaseDate = purchaseDate;
        this.qty = qty;
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Cars getIdCar() {
        return idCar;
    }

    public void setIdCar(Cars idCar) {
        this.idCar = idCar;
    }

    public Provider getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Provider idProvider) {
        this.idProvider = idProvider;
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
        hash += (idPurchase != null ? idPurchase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchases)) {
            return false;
        }
        Purchases other = (Purchases) object;
        if ((this.idPurchase == null && other.idPurchase != null) || (this.idPurchase != null && !this.idPurchase.equals(other.idPurchase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.Purchases[ idPurchase=" + idPurchase + " ]";
    }
    
}
