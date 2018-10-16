
package br.com.dbc.petshophibernate.service;

import br.com.dbc.petshophibernate.dao.ClienteDAO;
import br.com.dbc.petshophibernate.entity.Cliente;


/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteService extends AbstractService< Cliente, Long, ClienteDAO > {
    private static ClienteService instance;
    
    static {
        instance = new ClienteService();
    }
    
    public static ClienteService getInstance(){
        return instance;
    }
    
    
    private ClienteService () {}
    

    @Override
    protected ClienteDAO getDao() {
        return ClienteDAO.getInstance();
    }
 }
