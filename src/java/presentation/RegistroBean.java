/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.ejb.EJB;
import businessLogic.ProfileFacadeLocal;
import businessLogic.AuthenticationFacadeLocal;
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
public class RegistroBean {
    
    private String name;
    private String lastName;
    private String idCard;
    private String phone;
    private String city;
    private String address;
    private String email;
    private String username;
    private String password;
    private String role;
    
   
    
    @EJB 
    private ProfileFacadeLocal ejb;
    
    @EJB
    private AuthenticationFacadeLocal ejbauth;
    
    
    @EJB
    private RolesFacadeLocal ejbRoles;
            
    public RegistroBean()
    {} 
    
    //getters & setters methods
    
    public void setName(String theName){
        name = theName;
    }
    
    public String getName() {
        return name;
    }
    
    public void setLastName(String theLastName){
        lastName = theLastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getIdCard() {
        return idCard;
    }
    
    public void setIdCard (String theIdCard) {
        idCard = theIdCard;
    }
    
    public void setPhone(String thePhone){
        phone = thePhone;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setCity(String theCity){
        city = theCity;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setAddress(String theAddress){
        address = theAddress;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setEmail(String theEmail){
        email = theEmail;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setUsername(String theUsername){
        username = theUsername;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String thePassword){
        password = thePassword;
    }
    
    public String getPassword() {
        return password;
    }
 
     public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String createUser()
    {
        System.out.println(role);
        Integer theId = createProfile();
        String theEmail = createAuthReg(theId);
        //System.out.println("Bienvenido " + theEmail);
        
        Profile myProf = ejb.findById(theId);
        System.out.println("aqui en el bean: " + myProf.getLastName());
        
        String theRole = createTheRole(theId, myProf);
        System.out.println("Bienvenido " + theEmail +" "+  theRole);
        return "admin";
    }
    
      public Integer createProfile()
    {
        
        Integer theId = ejb.createProfile(name, lastName, idCard, phone, city, address, email);
        //System.out.println("bienvenido " + theId);
        System.out.println("el id  " + theId + "HEY HEY HEY HEY HEY");
        return theId;
        
    }
      
    public String createAuthReg(Integer theId)
    {
        String theEmail = ejbauth.createAuth(email, username, password, theId);
        return theEmail;
    }
    
    public String createTheRole(Integer theId, Profile theProf)
    {
        String theRole = ejbRoles.createRole(theId, role, theProf);
        return theRole;
    }
    
  
}
