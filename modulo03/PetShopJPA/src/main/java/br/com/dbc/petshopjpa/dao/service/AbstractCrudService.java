
package br.com.dbc.petshopjpa.dao.service;

import br.com.dbc.petshopjpa.dao.AbstractDAO;
import java.util.List;

/**
 *
 * @author jaqueline.bonoto
 */
public abstract class AbstractCrudService <E, ID, DAO extends AbstractDAO<E, ID>> {
    public abstract DAO getDAO();
    
    public List<E> findAll(){
        return getDAO().findAll();
    }
    
    public void findOne(ID id) {
       getDAO().findOne(id);
    }
    
    public void create(E e){
        getDAO().create(e);
    }
    
    public void update(E e){
        getDAO().update(e);
    }
    
    public void delete(ID id) {
       getDAO().delete(id);
    }
}
