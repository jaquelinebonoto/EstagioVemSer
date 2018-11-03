
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.ValorMidiaRepository;
import java.time.LocalDate;
import java.util.List;
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

    public void deleteByIdMidia(Midia midia) {
        valorMidiaRepository.deleteByMidiaId(midia.getId());
    }

    public void updateByIdMidia(Midia midia, double valor) {
        
        ValorMidia val = valorMidiaRepository.findByMidiaIdAndFimVigenciaIsNull(midia.getId())
                .orElseGet(()->valorMidiaRepository.save(ValorMidia.builder().inicioVigencia(LocalDate.now()).midia(midia).valor(valor).build()));
              
            if(val.getValor() == valor) return;
            val.setFimVigencia(LocalDate.now());
            valorMidiaRepository.save(val);
    
        valorMidiaRepository.save(ValorMidia.builder()
                                                .valor(valor)
                                                .inicioVigencia(LocalDate.now())
                                                .fimVigencia(null)
                                                .midia(midia)
                                            .build()
                                    );
    }


    List<ValorMidia> findByMidiaIdIn(List<Long> midias, LocalDate retirada) {
        return valorMidiaRepository.findByMidiaIdIn(midias, retirada);
    }

    public List<ValorMidia> findByMidiaId(Long id) {
        return valorMidiaRepository.findByMidiaId(id);
    }
}
