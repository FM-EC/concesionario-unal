/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.CarsFacadeLocal;
import businessLogic.ProfileFacadeLocal;
import businessLogic.SalesFacadeLocal;
import businessLogic.sessionManagement.SessionUtils;
import dataAccess.Cars;
import dataAccess.Profile;
import dataAccess.Sales;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author FABIAN
 */
@ManagedBean
@ViewScoped
public class salesRegisterBean {
    
    private Date date;
    @EJB
    private CarsFacadeLocal ejb;
    @EJB
    private SalesFacadeLocal sales;
    @EJB
    private ProfileFacadeLocal user;
    private List<Cars> cars;
    private List<Cars> selectedCars;
    private Cliente cliente;
    private List<Cliente> clientes;
    private float valorTotal;
    private String PaymentType;
    

    /**
     * Creates a new instance of salesRegisterBean
     */
    public salesRegisterBean() {
    }
    
    @ManagedProperty("#{clientService}")
    private ClientService service;
    
    @PostConstruct
    public void init() {
        clientes = service.getClients();
        date = new Date();
    }

    public ClientService getService() {
        return service;
    }

    public void setService(ClientService service) {
        this.service = service;
    }
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Cars> getCars() {
        cars = new ArrayList<>();
        ejb.findAll().forEach((it)->{
            if(!it.getSold()){
                cars.add(it);
            }
        });
        return cars;
    }
    
    public List<Cars> getSelectedCars(){
        selectedCars = new ArrayList<Cars>();
        cars.forEach((it)->{
            if(it.getSold() == true){
                selectedCars.add(it);
            }
        });
        
        return selectedCars;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getPaymentType() {
        return PaymentType;
    }

    public void setPaymentType(String PaymentType) {
        this.PaymentType = PaymentType;
    }
    
    public float calcularValorTotal(){
        cars.forEach((it) ->{
            if(it.getSold() == true){
                valorTotal += it.getSalesPrice();
            }
        });
        return valorTotal;
    }
    
    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
    
    public String registrarCarro() {
        Sales persistSale = new Sales();
        Cars PersistCar = new Cars(); 
        //FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
        persistSale.setSaleDate(date);
        persistSale.setTotalValue(valorTotal);
        persistSale.setSaleType(PaymentType);
        persistSale.setIdClient(cliente.getIdcliente());
        
        HttpSession session = SessionUtils.getSession();
        int theUserId = (int)  session.getAttribute("idUser");
         
        Profile idUser = user.findById(theUserId);
        persistSale.setIdUser(idUser);
        
        //persistSale.setCarsCollection(selectedCars);
        
        Sales sale = sales.createSale(persistSale);
        
        selectedCars.forEach((it)->{
            it.setIdVenta(sale);
            it.setSold(true);
        });
        
        if(ejb.createCars(selectedCars)){
          return "seller";
        }else{
          return null;
        }
            
        
            
        
        
    }
    
    
}
