/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author FABIAN
 */
@Entity
@Table(name = "cars")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findByIdCar", query = "SELECT c FROM Cars c WHERE c.idCar = :idCar"),
    @NamedQuery(name = "Cars.findByBrand", query = "SELECT c FROM Cars c WHERE c.brand = :brand"),
    @NamedQuery(name = "Cars.findBySalesPrice", query = "SELECT c FROM Cars c WHERE c.salesPrice = :salesPrice"),
    @NamedQuery(name = "Cars.findByPurchasePrice", query = "SELECT c FROM Cars c WHERE c.purchasePrice = :purchasePrice"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByColor", query = "SELECT c FROM Cars c WHERE c.color = :color"),
    @NamedQuery(name = "Cars.findByCarriagePlate", query = "SELECT c FROM Cars c WHERE c.carriagePlate = :carriagePlate"),
    @NamedQuery(name = "Cars.findByTransmissionType", query = "SELECT c FROM Cars c WHERE c.transmissionType = :transmissionType"),
    @NamedQuery(name = "Cars.findByChasisNumber", query = "SELECT c FROM Cars c WHERE c.chasisNumber = :chasisNumber"),
    @NamedQuery(name = "Cars.findByEngineNumber", query = "SELECT c FROM Cars c WHERE c.engineNumber = :engineNumber"),
    @NamedQuery(name = "Cars.findBySold", query = "SELECT c FROM Cars c WHERE c.sold = :sold")})
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCar")
    private Integer idCar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salesPrice")
    private float salesPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchasePrice")
    private float purchasePrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "color")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "carriagePlate")
    private String carriagePlate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "transmissionType")
    private String transmissionType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "chasisNumber")
    private String chasisNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "engineNumber")
    private String engineNumber;
    @Column(name = "sold")
    private Boolean sold;
    @JoinColumn(name = "idProvider", referencedColumnName = "idProvider")
    @ManyToOne(optional = false)
    private Provider idProvider;
    @JoinColumn(name = "idVenta", referencedColumnName = "idSales")
    @ManyToOne
    private Sales idVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCar")
    private Collection<Purchases> purchasesCollection;

    public Cars() {
    }

    public Cars(Integer idCar) {
        this.idCar = idCar;
    }

    public Cars(Integer idCar, String brand, float salesPrice, float purchasePrice, String model, String color, String carriagePlate, String transmissionType, String chasisNumber, String engineNumber) {
        this.idCar = idCar;
        this.brand = brand;
        this.salesPrice = salesPrice;
        this.purchasePrice = purchasePrice;
        this.model = model;
        this.color = color;
        this.carriagePlate = carriagePlate;
        this.transmissionType = transmissionType;
        this.chasisNumber = chasisNumber;
        this.engineNumber = engineNumber;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(float salesPrice) {
        this.salesPrice = salesPrice;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarriagePlate() {
        return carriagePlate;
    }

    public void setCarriagePlate(String carriagePlate) {
        this.carriagePlate = carriagePlate;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getChasisNumber() {
        return chasisNumber;
    }

    public void setChasisNumber(String chasisNumber) {
        this.chasisNumber = chasisNumber;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public Provider getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Provider idProvider) {
        this.idProvider = idProvider;
    }

    public Sales getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Sales idVenta) {
        this.idVenta = idVenta;
    }

    @XmlTransient
    public Collection<Purchases> getPurchasesCollection() {
        return purchasesCollection;
    }

    public void setPurchasesCollection(Collection<Purchases> purchasesCollection) {
        this.purchasesCollection = purchasesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCar != null ? idCar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.idCar == null && other.idCar != null) || (this.idCar != null && !this.idCar.equals(other.idCar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dataAccess.Cars[ idCar=" + idCar + " ]";
    }
    
}
