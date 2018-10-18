package br.com.dbc.petshopjpa.dao;

import br.com.dbc.petshopjpa.entity.Cliente;


/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteDAO extends AbstractDAO<Cliente, Long>{
    @Override
    protected Class getEntityClass() {
        return Cliente.class;
    }
   
}
