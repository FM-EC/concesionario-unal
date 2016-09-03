/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic;

import dataAccess.Profile;
import dataAccess.Roles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FABIAN
 */
@Stateless
public class RolesFacade extends AbstractFacade<Roles> implements RolesFacadeLocal {

    @PersistenceContext(unitName = "concesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }

    @Override
    public Roles findByUserId(Profile prof) {
        try {
            Roles rol = new Roles();
            rol = em.createNamedQuery("Roles.findByUserId",Roles.class).setParameter("idUser", prof).getSingleResult();
            return rol;
        } catch (Exception e) {
            em.close();
        }
        return null;
    }

}
