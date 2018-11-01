package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.AluguelRepository;
import java.time.LocalDate;
import java.util.List;
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
public class AluguelService extends AbstractCRUDService<Aluguel> {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private MidiaService midiaService;

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ValorMidiaService valorMidiaService;

    @Override
    protected JpaRepository<Aluguel, Long> getRepository() {
        return aluguelRepository;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Aluguel cadastrarRetirada(@RequestBody AluguelDTO dto) { //
        Aluguel aluguel = getRepository().save(DtotoAluguel(dto));
        for (Long midia : dto.getMidias()) {
            if (midiaService.findById(midia).get().getAluguel() == null) {
                midiaService.findById(midia).get().setAluguel(aluguel);
            }
        }
        return aluguel;
    }

    public Aluguel DtotoAluguel(AluguelDTO dto) {
        return Aluguel.builder()
                .retirada(LocalDate.now())
                .previsao(LocalDate.now().plusDays(dto.getMidias().size()))
                .cliente((Cliente) clienteService.findById(dto.getIdCliente()).get())
                .build();
    }

    public Page<Filme> findByAluguelPrevisao(
            Pageable pageable,
            LocalDate previsao) {
        return filmeService.findByAluguelPrevisao(pageable, previsao);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public AluguelDTO cadastrarDevolucao(AluguelDTO dto) {
        
        List<Midia> midias = midiaService.findByIdIn(dto.getMidias()); //pegando todas as mídias que estão dentro do dto
        Aluguel aluguel = midias.get(0).getAluguel(); //estou pegando o objeto aluguel antes de setar null
        List<ValorMidia> valores = valorMidiaService.findByMidiaIdIn(dto.getMidias(), aluguel.getRetirada()); 
        //lista com os valores das midias que estão naquele aluguel. a vigencia do preço foi considerada
        Double valor = valores.stream().mapToDouble(ValorMidia::getValor).sum(); //valor do aluguel
        midiaService.updateAluguelToNullByIdMidias(dto.getMidias()); //atualizando para null
        

        aluguel.setDevolucao(LocalDate.now());
        Double multa = 0d;
        if (LocalDate.now().isAfter(aluguel.getPrevisao())) {
            multa += valor;
        }
        aluguel.setMulta(multa);
        save(aluguel);
        dto.setId(aluguel.getId());
        dto.setMulta(multa);
        dto.setValor(valor + multa);
        dto.setMidias(dto.getMidias());

        return dto;
    }

}
