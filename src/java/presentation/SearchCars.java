/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import businessLogic.CarsFacade;
import dataAccess.Cars;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author monica
 */
@Named(value = "searchCars")
@Dependent
public class SearchCars {
    @EJB 
    private CarsFacadeLocal ejb;
    /**
     * Creates a new instance of SearchCars
     */
    public SearchCars() {
    }
    
    public List <Cars> findAll(){
        List <Cars> cars= new ArrayList<>();
        cars= ejb.findAll();
        for (Cars  c: cars){
            System.out.println(c.toString());
        }
        return cars;
    }
}
