package br.com.dbc.petshopjpa.dao;

import br.com.dbc.petshopjpa.entity.Animal;

/**
 *
 * @author jaqueline.bonoto
 */
public class AnimalDAO extends AbstractDAO<Animal, Long>{

    @Override
    protected Class<Animal> getEntityClass() {
        return Animal.Class;
    }
    
}
