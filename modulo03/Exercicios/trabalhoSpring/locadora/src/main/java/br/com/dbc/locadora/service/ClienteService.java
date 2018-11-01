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
    
    /*
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Cliente salvarComEndereco (ClienteDTO dto) { 
        Cliente c = getRepository().save(DtotoCliente(dto));
        /*Filme filme = getRepository().save(dto.DtotoFilme());
        for (MidiaDTO midiaDTO : dto.getMidia()) {
            midiaService.salvarMidiaDTO(midiaDTO, filme);            
        }
        return c;
    }
    */
    
    
    /*
    public Cliente DtotoCliente(ClienteDTO dto){
        ResponseEntity<?> endereco = clienteRestController.cep(dto.getCep());
        return Cliente.builder()
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .endereco(Endereco.builder()
                        .rua(endereco.get)
                        .rua(dto.con)
                
                .titulo(this.titulo)
                .lancamento(lancamento)
                .categoria(this.categoria)
                .build();
    }
    
    public Endereco cep()(
         return clienteRestController
    }*/
}
