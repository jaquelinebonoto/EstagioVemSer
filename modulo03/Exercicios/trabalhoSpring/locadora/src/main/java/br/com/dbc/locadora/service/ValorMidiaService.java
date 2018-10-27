
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class ValorMidiaService extends AbstractCRUDService<ValorMidia>{
    @Autowired
    private ValorMidiaRepository valorMidiaRepository;

    @Override
    protected JpaRepository<ValorMidia, Long> getRepository() {
        return valorMidiaRepository;
    }
    
}
