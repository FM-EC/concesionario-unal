/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dataAccess.Provider;

/**
 *
 * @author FABIAN
 */
public class Proveedor {
 
    private int id;    
    private String displayName; 
    private String name;
    private Provider idProveedor; 
     
    public Proveedor() {}
 
    public Proveedor(int id, String displayName, String name, Provider idProveedor) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
        this.idProveedor = idProveedor;
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
     
    public Provider getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Provider idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
