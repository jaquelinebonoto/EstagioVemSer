package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class AluguelService extends AbstractCRUDService<Aluguel>{
    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    protected JpaRepository<Aluguel, Long> getRepository() {
        return aluguelRepository;
    }
    
}
