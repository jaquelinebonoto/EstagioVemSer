
package br.com.dbc.petshopjpa.dao.service;

import br.com.dbc.petshopjpa.dao.ClienteDAO;
import br.com.dbc.petshopjpa.entity.Cliente;

/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteService extends AbstractCrudService <Cliente, Long, ClienteDAO>{
    
    private final ClienteDAO clienteDAO;
    
    {
        clienteDAO = new ClienteDAO();
    }
    
    @Override
    public ClienteDAO getDAO(){
        return clienteDAO;
    }    
}
