/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.AuthenticationFacadeLocal;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author FABIAN
 */
@ManagedBean
@Dependent        
@SessionScoped
public class loginBean {
    
    private String email;
    private String password;
    @EJB
    private AuthenticationFacadeLocal ejb;
    
    /**
     * Creates a new instance of loginBean
     */
    
    public loginBean() {}
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
    public String processLogin(){
        if (ejb.authenticate(email, password)){
            return "welcome";
        }else{
            FacesMessage ms = new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario o contraseña invalida","");
            FacesContext.getCurrentInstance().addMessage(null, ms);
            return null;
        }   
    }
       
}
