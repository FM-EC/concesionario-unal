/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.CarsFacadeLocal;
import dataAccess.Cars;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author monica
 */
//@Named(value = "searchCars")
@ManagedBean
@ViewScoped
public class SearchCars implements Serializable {

    @EJB
    private CarsFacadeLocal ejb;
    private List<Cars> cars;
    private List<Cars> filteredCars;

    @PostConstruct
    public void init() {
        cars = ejb.findAll();
    }

    /**
     * Creates a new instance of SearchCars
     *
     * public SearchCars() { }
     */
    /*
    public List<Cars> findAll() {
        cars = ejb.findAll();
        return cars;
    }
     */
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Proveedor Seleccionado", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public List<String> getBrands() {
        List<String> brands = new ArrayList<>();
        brands.add("Alfa Romeo");
        brands.add("Audi");
        brands.add("Cadillac");
        brands.add("Chrysler");
        brands.add("Citroen");
        brands.add("Ferrari");
        brands.add("Fiat");
        brands.add("Ford");
        brands.add("Honda");
        brands.add("Hyundai");
        brands.add("Jeep");
        brands.add("Kia");
        brands.add("Lamborghini");
        brands.add("Mazda");
        brands.add("Renault");
        brands.add("Toyota");

        return brands;
    }

    public void deleteCar(Cars carro) {
        ejb.remove(carro);
        cars.remove(carro);
        addMessage("Eliminado Vehiculo", carro.toString());
    }

    public List<Cars> getCars() {
        return cars;
    }

    public List<Cars> getFilteredCars() {
        return filteredCars;
    }

    public void setFilteredCars(List<Cars> filteredCars) {
        this.filteredCars = filteredCars;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
