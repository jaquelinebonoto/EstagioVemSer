
package br.com.dbc.petshophibernate.service;

import br.com.dbc.petshophibernate.dao.AnimalDAO;
import br.com.dbc.petshophibernate.entity.Animal;

/**
 *
 * @author jaqueline.bonoto
 */
public class AnimalService extends AbstractService< Animal, Long, AnimalDAO >{
    private static final AnimalService instance;
    
    static {
        instance = new AnimalService();
    }
    
    public static AnimalService getInstance(){
        return instance;
    }
       

    @Override
    protected AnimalDAO getDao() {
        return AnimalDAO.getInstance();
    }
}
