/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import businessLogic.ProfileFacadeLocal;
import businessLogic.SalesFacadeLocal;
import dataAccess.Profile;
import dataAccess.Sales;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;


/**
 *
 * @author FABIAN
 */
@ManagedBean
@SessionScoped
public class estadisticasBean {

    @EJB 
    private ProfileFacadeLocal users;
    private LineChartModel areaModel;
    private Profile currentUser;
    @EJB
    private SalesFacadeLocal sales;
       
    public LineChartModel getAreaModel() {
        return areaModel;
    }
    /**
     * Creates a new instance of estadisticasBean
     */
    public estadisticasBean() {
    }
    
    public List<Profile> getUsers(){
        return users.findAll();
    }
    
    public void statsByMonth(Profile user){
        calcularVentas(sales.findByIdUser(user));
    }
    
    void calcularVentas(List<Sales> sales){
        HashMap<String, Integer> meses = new HashMap<String, Integer>();
        meses.put("enero", 0);
        meses.put("febrero", 0);
        meses.put("marzo", 0);
        meses.put("abril", 0);
        meses.put("mayo", 0);
        meses.put("junio", 0);
        meses.put("julio", 0);
        meses.put("agosto", 0);
        meses.put("septiembre", 0);
        meses.put("octubre", 0);
        meses.put("noviembre", 0);
        meses.put("diciembre", 0);
        System.out.println("tamaño sales: " + sales.size());
        Calendar cal = Calendar.getInstance();
        sales.forEach((it)->{
            cal.setTime(it.getSaleDate());
            System.out.println(cal.get(Calendar.MONTH) + 1);
            switch (cal.get(Calendar.MONTH) +1) {
                case 1:  meses.put("enero", meses.get("enero") + 1);
                         break;
                case 2:  meses.put("febrero", meses.get("febrero") + 1);
                         break;
                case 3:  meses.put("marzo", meses.get("marzo") + 1);
                         break;
                case 4:  meses.put("abril", meses.get("abril") + 1);
                         break;
                case 5:  meses.put("mayo", meses.get("mayo") + 1);
                         break;
                case 6:  meses.put("junio", meses.get("junio") + 1);
                         break;
                case 7:  meses.put("julio", meses.get("julio") + 1);
                         break;
                case 8:  meses.put("agosto", meses.get("agosto") + 1);
                         break;
                case 9:  meses.put("septiembre", meses.get("septiembre") + 1);
                         break;
                case 10: meses.put("octubre", meses.get("octubre") + 1);
                         break;
                case 11: meses.put("noviembre", meses.get("noviembre") + 1);
                         break;
                case 12: meses.put("diciembre", meses.get("diciembre") + 1);
                         break;
                default: System.out.println("pailas");
                         break;
        }
        });
        
        createAreaModel(meses);
    }
    
    private void createAreaModel(HashMap<String, Integer> map) {
        HashMap<String, Integer> mes = map;
        areaModel = new LineChartModel();
        
        mes.values().stream().forEach((key) -> {
            System.out.println(key);
        });
        LineChartSeries ventas = new LineChartSeries();
        ventas.setFill(true);
        ventas.setLabel("Ventas");
        ventas.set("Enero", mes.get("enero"));
        ventas.set("Febrero", mes.get("febrero"));
        ventas.set("Marzo", mes.get("marzo"));
        ventas.set("Abril", mes.get("abril"));
        ventas.set("Mayo", mes.get("mayo"));
        ventas.set("Junio", mes.get("junio"));
        ventas.set("Julio", mes.get("julio"));
        ventas.set("Agosto", mes.get("agosto"));
        ventas.set("Septiembre", mes.get("septiembre"));
        ventas.set("Octubre", mes.get("octubre"));
        ventas.set("Noviembre", mes.get("noviembre"));
        ventas.set("Diciembre", mes.get("diciembre"));
        
        areaModel.addSeries(ventas);
        

        areaModel.setTitle("Ventas por mes");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Meses");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Ventas totales");
        yAxis.setMin(0);
        yAxis.setMax(30);
        
    }
    
   
    public String redirect(Profile user){
        setCurrentUser(user);
        statsByMonth(user);
        return "graficasPorMes";
    }

    public Profile getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Profile currentUser) {
        this.currentUser = currentUser;
    }
    
    
}
