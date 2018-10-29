package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.repository.AluguelRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class AluguelService extends AbstractCRUDService<Aluguel>{
    @Autowired
    private AluguelRepository aluguelRepository;
    
    @Autowired
    private MidiaService midiaService;
    
    @Autowired
    FilmeService filmeService;
    @Autowired
    private ClienteService clienteService;
    

    @Override
    protected JpaRepository<Aluguel, Long> getRepository() {
        return aluguelRepository;
    }
    
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Aluguel cadastrarRetirada (@RequestBody AluguelDTO dto){ //
        Aluguel aluguel = getRepository().save(DtotoAluguel(dto));
            for (Long midia : dto.getMidias()) {
                if (midiaService.findById(midia).get().getAluguel() == null)
                midiaService.findById(midia).get().setAluguel(aluguel);
            }
        return aluguel;
    }
    
    public Aluguel DtotoAluguel(AluguelDTO dto){     
        return Aluguel.builder()
            .retirada(LocalDate.now())
            .previsao(LocalDate.now().plusDays(dto.getMidias().size()))
            .cliente((Cliente)clienteService.findById(dto.getIdCliente()).get())
            .build();
    }
    
public Page<Filme> findByAluguelPrevisao(
                Pageable pageable,
                LocalDate previsao){
    return filmeService.findByAluguelPrevisao(pageable, previsao);
}
    
    
}
