package br.com.dbc.petshopjpa.dao;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author jaqueline.bonoto
 */
public class PersistenceUtils {
    
    private static final EntityManager em;
    
    static {
        em = Persistence
                .createEntityManagerFactory("petshop")
                .createEntityManager();
    }
    
    public static EntityManager getEntityManager(){
        return em;
    }
}
