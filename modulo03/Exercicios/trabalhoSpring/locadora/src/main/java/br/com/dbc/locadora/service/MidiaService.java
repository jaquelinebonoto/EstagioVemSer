
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.MidiaDTO;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.MidiaRepository;
import java.time.LocalDate;
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
    
    @Autowired
    private ValorMidiaService valorMidiaService;

    @Override
    protected JpaRepository<Midia, Long> getRepository() {
        return midiaRepository;
    }

    public void salvarMidiaDTO(MidiaDTO dto, Filme filme){
        for(int i = 0; i < dto.getQuantidade(); i++){
            Midia midia = midiaRepository.save(dto.DtotoMidia(filme));
            
            ValorMidia valor = ValorMidia.builder().valor(dto.getValor()).midia(midia).inicioVigencia(LocalDate.now()).build();
            valorMidiaService.save(valor); 
        }
    }
}
