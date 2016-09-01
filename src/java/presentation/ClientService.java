/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.ClientFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author FABIAN
 */
@ManagedBean(name="clientService", eager = true)
@ApplicationScoped
public class ClientService {
     
    private List<Cliente> clients;
    @EJB
    private ClientFacadeLocal lista;
    int index = 0;
    @PostConstruct
    public void init() {
        clients = new ArrayList<Cliente>();
        
        lista.findAll().forEach((it) ->{
            clients.add(new Cliente(index++, it.getEmail(), it.getEmail(), it));
        });
        index = 0;
    }
     
    public List<Cliente> getClients() {
        return clients;
    } 
}
