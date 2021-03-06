package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.repository.ClienteRepository;
import br.com.dbc.locadora.rest.ClienteRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class ClienteService extends AbstractCRUDService<Cliente>{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteRestController clienteRestController;
    
    @Override
    protected JpaRepository<Cliente, Long> getRepository() {
        return clienteRepository;
    }
     

}