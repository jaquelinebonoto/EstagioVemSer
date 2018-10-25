
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.repository.MidiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class MidiaService extends AbstractCRUDService<Midia>{
    @Autowired
    private MidiaRepository midiaRepository;

    @Override
    protected JpaRepository<Midia, Long> getRepository() {
        return midiaRepository;
    }
    
}
