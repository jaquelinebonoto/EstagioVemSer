
package br.com.dbc.seguradora.service;

import br.com.dbc.seguradora.entity.Apolice;
import br.com.dbc.seguradora.repository.ApoliceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;



/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class ApoliceService extends AbstractCRUDService<Apolice>{
    @Autowired
    private ApoliceRepository apoliceRepository;

    @Override
    protected JpaRepository<Apolice, Long> getRepository() {
        return apoliceRepository;
    }

   
    
}
