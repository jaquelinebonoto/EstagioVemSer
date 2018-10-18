
package br.com.dbc.petshopjpa.dao.service;

import br.com.dbc.petshopjpa.dao.ClienteDAO;
import br.com.dbc.petshopjpa.entity.Cliente;
import java.util.List;

/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteService {
    
    private ClienteDAO clienteDAO;
    
    {
        clienteDAO = new ClienteDAO();
    }
    
    public ClienteDAO getDAO(){
        return clienteDAO;
    }
    public List<Cliente> findAll(){
        return getDAO().findAll();
    }
    
    public Cliente findOne(Long id) {
        return getDAO().findOne(id);
    }
    
    public void create(Cliente cliente){
        getDAO().create(cliente);
    }
    
    public void update(Cliente cliente){
        getDAO().update(cliente);
    }
    
    public void delete(Long id) {
       getDAO().delete(id);
    }
    
}
