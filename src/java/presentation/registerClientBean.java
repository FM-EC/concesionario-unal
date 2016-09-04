/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.ejb.EJB;
import businessLogic.ProfileFacadeLocal;
import businessLogic.AuthenticationFacadeLocal;
import businessLogic.ClientFacadeLocal;
import businessLogic.RolesFacadeLocal;
import dataAccess.Profile;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Alvaro
 */

@ManagedBean
@Dependent        
@SessionScoped

public class registerClientBean {
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    
    @EJB 
    private ClientFacadeLocal ejb;
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public registerClientBean()
    {}
    
    public String createClient()
    {
        Integer theId = ejb.createClient(name, lastName, email, phone, address);
        System.out.println("Creado cliente: " + theId);
        return "seller";
    }
}
