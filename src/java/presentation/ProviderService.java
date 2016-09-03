/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.ProviderFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author FABIAN
 */
@Named(value="providerService")
@ApplicationScoped
public class ProviderService {
     
    private List<Proveedor> providers;
    @EJB
    private ProviderFacadeLocal lista;
    int index = 0;
    @PostConstruct
    public void init() {
        providers = new ArrayList<Proveedor>();
        
        lista.findAll().forEach((it) ->{
            providers.add(new Proveedor(index++, it.getCompanyName(), it.getCompanyName(),it));
        });
        index = 0;
    }
     
    public List<Proveedor> getProviders() {
        return providers;
    } 
}
