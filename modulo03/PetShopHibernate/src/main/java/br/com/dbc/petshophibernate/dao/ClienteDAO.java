
package br.com.dbc.petshophibernate.dao;

import br.com.dbc.petshophibernate.entity.Cliente;
import org.hibernate.criterion.Restrictions;

public class ClienteDAO {
    private static final ClienteDAO instance;
    
    static {
        instance = new ClienteDAO();
    }
    
    public static ClienteDAO getInstance() {
        return instance;
    }
    
    private ClienteDAO (){ }
    
    public Cliente findById(Long id){
        return (Cliente) HibernateUtil.getSessionFactory()
                .openSession()
                .createCriteria(Cliente.class)
                .add(Restrictions.eq("id", id))
                .uniqueResult();
    }
    
}
