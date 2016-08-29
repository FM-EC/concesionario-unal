/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.CarsFacadeLocal;
import dataAccess.Cars;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


/**
 *
 * @author FABIAN
 */
@ManagedBean
@RequestScoped
public class carRegisterBean {

    private Proveedor provider;
    private List<Proveedor> providers;
    private String marca;
    private String modelo;
    private String color;
    private String carriagePlate;
    private String transmissionType;
    private String chasisNumber;
    private String engineNumber;
    private String salesPrice;
    private String purchasePrice;
    
    @EJB
    private CarsFacadeLocal car;
    /**
     * Creates a new instance of carRegisterBean
     */
    public carRegisterBean() {
    }
    
    @ManagedProperty("#{providerService}")
    private ProviderService service;

    @PostConstruct
    public void init() {
        providers = service.getProviders();
    }

    public Proveedor getProvider() {
        return provider;
    }

    public void setProvider(Proveedor provider) {
        this.provider = provider;
    }

    public List<Proveedor> getProviders() {
        return providers;
    }

    public void setService(ProviderService service) {
        this.service = service;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public String registrarCarro(){
        Cars persistCar = new Cars();
        persistCar.setBrand(marca);
        persistCar.setCarriagePlate(carriagePlate);
        persistCar.setChasisNumber(chasisNumber);
        persistCar.setColor(color);
        persistCar.setEngineNumber(engineNumber);
        persistCar.setIdProvider(provider.getIdProveedor());
        persistCar.setModel(modelo);
        persistCar.setPurchasePrice(Float.parseFloat(purchasePrice));
        persistCar.setSalesPrice(Float.parseFloat(salesPrice));
        persistCar.setTransmissionType(transmissionType);
        
        if(car.createCar(persistCar)){
            return "welcome";
        }
        
        return null;
    }
    
    
}
