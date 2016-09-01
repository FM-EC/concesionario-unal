/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dataAccess.Client;

/**
 *
 * @author FABIAN
 */
public class Cliente {
    private int id;    
    private String displayName; 
    private String name;
    private Client idcliente; 
     
    public Cliente() {}
 
    public Cliente(int id, String displayName, String name, Client idCliente) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
        this.idcliente = idCliente;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getDisplayName() {
        return displayName;
    }
 
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public Client getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Client idcliente) {
        this.idcliente = idcliente;
    }
     
        
    @Override
    public String toString() {
        return name;
    }
}
