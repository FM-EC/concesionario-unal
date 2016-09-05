/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.ProfileFacadeLocal;
import businessLogic.SalesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

import businessLogic.SalesFacade.SellerOfMonth;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author monica
 */
@ManagedBean
@SessionScoped
public class VendedorMes implements Serializable {

    private SellerOfMonth seller;

    @EJB
    private SalesFacadeLocal sales;
    @EJB
    private ProfileFacadeLocal profile;

    /**
     * Creates a new instance of VendedorMes
     */
    public VendedorMes() {  
    }
    
    @PostConstruct
    public void init(){
        bestSeller();
    }
    

    public void bestSeller() {
        seller = (SellerOfMonth) sales.sellerOfMonth();
        seller.setProfile(profile.findById(seller.getSeller()));

    }

    public SellerOfMonth getSeller() {
        return seller;
    }

    public void setSeller(SellerOfMonth seller) {
        this.seller = seller;
    }

}
