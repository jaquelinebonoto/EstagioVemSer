
package br.com.dbc.petshophibernate.dao;

import br.com.dbc.petshophibernate.entity.Cliente;

public class ClienteDAO extends AbstractDAO<Cliente, Long>{
    private static final ClienteDAO instance;
    
    static {
        instance = new ClienteDAO();
    }
    
    public static ClienteDAO getInstance() {
        return instance;
    }

    private ClienteDAO() { }
    
    
    @Override
    protected Class<Cliente> getEntityClass() {
        return Cliente.class;
    }

    @Override
    protected String getIdProperty() {
        return "id";
    }    
    
}
