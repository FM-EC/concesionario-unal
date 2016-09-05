/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
import dataAccess.Sales;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author FABIAN
 */
@Stateless
public class SalesFacade extends AbstractFacade<Sales> implements SalesFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public List<Sales> findAll() {
        List<Sales> sales = new ArrayList<>();
        try {
            sales = em.createNamedQuery("Sales.findAll").getResultList();
        } catch (Exception e) {
            em.close();
        } finally {
            em.close();
        }
        return sales;
    }

    @Override
    public Sales createSale(Sales entity) {
        try {
            em.persist(entity);
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Sales> findByIdUser(Profile id) {
        List<Sales> sales = new ArrayList<>();
        try {
            sales = em.createNamedQuery("Sales.findByIdUser")
                    .setParameter("idUser", id)
                    .getResultList();
            return sales;
        } catch (Exception e) {
            System.out.println(e);
            em.close();
            return null;
        }

    }

    public Sales findByIdSales(int theId) {
        Sales theSale = new Sales();
        try {
            theSale = em.createNamedQuery("Sales.findByIdSales", Sales.class).setParameter("idSales", theId).getSingleResult();
        } catch (Exception e) {
            System.out.println(e);
        }
        return theSale;
    }

    @Override
    public SellerOfMonth sellerOfMonth() {
        try {
            Query q = em.createNativeQuery("SELECT IDSALES,idUser,sum(totalValue) "
                    + "FROM sales WHERE month(saleDate) = MONTH( NOW())-1 "
                    + "GROUP BY idUser HAVING Count(idUser) ORDER BY Count(idUser) DESC");
            Object[] seller = (Object[]) q.getSingleResult();

            return new SellerOfMonth(seller);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<SellerOfMonth> totalSales() {
        try {
            Query q = em.createNativeQuery("SELECT IDSALES,idUser,sum(totalValue) "
                    + "FROM sales "
                    + "GROUP BY idUser HAVING Count(idUser) ORDER BY Count(idUser) DESC");
            List<Object[]> seller = q.getResultList();
            List<SellerOfMonth> sellers = new ArrayList<>();
            for (Object[] obj : seller) {
                sellers.add(new SellerOfMonth(obj));
            }
            return sellers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public float getCommission(int theId) {
        Sales mySale = new Sales();
        mySale = findByIdSales(theId);

        float theTotalValue = mySale.getTotalValue();
        return (float) (theTotalValue * 0.1);

    }
    
    public float getComissionPerDay(List <Sales> theSales)
    {
        float theTotalSum = 0;
        for (Sales  s: theSales)
        {
            theTotalSum += s.getTotalValue();
        }
         
        return (float) (theTotalSum*0.1);
    }
    public SalesFacade() {
        super(Sales.class);
    }

    public class SellerOfMonth {

        public SellerOfMonth(Object[] list) {
            this.idSale = (Integer) list[0];
            this.seller = (Integer) list[1];
            this.total = (Double) list[2];
        }

        Integer idSale;
        Integer seller;
        Double total;
        Profile profile;

        public Integer getSeller() {
            return seller;
        }

        public void setSeller(Integer seller) {
            this.seller = seller;
        }

        public Integer getIdSale() {
            return idSale;
        }

        public void setIdSale(Integer idSale) {
            this.idSale = idSale;
        }

        public Double getTotal() {
            return total;
        }

        public void setTotal(Double total) {
            this.total = total;
        }

        public Profile getProfile() {
            return profile;
        }

        public void setProfile(Profile profile) {
            this.profile = profile;
        }

    }

}
