
package br.com.dbc.petshopjpa.dao.service;

import br.com.dbc.petshopjpa.dao.AbstractDAO;
import br.com.dbc.petshopjpa.dao.AnimalDAO;
import br.com.dbc.petshopjpa.entity.Animal;

/**
 *
 * @author jaqueline.bonoto
 */
public class AnimalService extends AbstractCrudService <Animal, Long, AnimalDAO>{

    private final AnimalDAO animalDAO;
    
    {
        animalDAO = new AnimalDAO();
    }

    @Override
    public AnimalDAO getDAO(){
        return animalDAO;
    }
    
    
}
