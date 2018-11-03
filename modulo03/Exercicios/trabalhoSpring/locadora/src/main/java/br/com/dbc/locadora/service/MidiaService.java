
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.MidiaDTO;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.MidiaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public List<Midia> salvarMidiaDTO(MidiaDTO dto, Filme filme){
        List<Midia> midia = new ArrayList<>();
        for(int i = 0; i < dto.getQuantidade(); i++){
            Midia midiaList = midiaRepository.save(dto.DtotoMidia(filme));
            
            ValorMidia valor = ValorMidia.builder()
                    .valor(dto.getValor())
                    .midia(midiaList)
                    .inicioVigencia(LocalDate.now())
                    .fimVigencia(null)
                    .build();
            valorMidiaService.save(valor); 
        }
        return midia;
    }
    
    public Long countByTipo(Tipo tipo){
        return midiaRepository.countByTipo(tipo);
    }
    
    public Page<Midia> findByAluguelPrevisao(
                Pageable pageable,
                LocalDate previsao){
       return midiaRepository.findByAluguelPrevisao(pageable, previsao);
   }

    public void updateMidiaDTO(MidiaDTO dto, Filme filme){  
        List<Midia> midiaSistema = pegarMidiasDoFilme(filme, dto.getTipo());
            if(midiaSistema.size() < dto.getQuantidade()){ //se temos menos no sistema do que a atualização
                dto.setQuantidade(dto.getQuantidade() - midiaSistema.size());
                salvarMidiaDTO(dto, filme);
            }
            if(midiaSistema.size() > dto.getQuantidade()){ //se queremos retirar mídias
                deletarMidias(midiaSistema.size() - dto.getQuantidade(), midiaSistema);
            }
            for(Midia m : midiaSistema){
            valorMidiaService.updateByIdMidia(m, dto.getValor());
        }
 
    }
    
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public List<Midia> deletarMidias (int excesso, List<Midia> midias){
        for(int i = 0; i <excesso; i++){
            valorMidiaService.deleteByIdMidia(midias.get(i));
            delete(midias.get(i).getId());
        }
        return midias;
    }
    
    public List<Midia> pegarMidiasDoFilme (Filme filme, Tipo tipo){
        List<Midia> midiaSistema= new ArrayList<>();
            Long i = filme.getId();
            midiaSistema = midiaRepository.findByFilmeIdAndTipo(i, tipo);
            return midiaSistema;
    }

    public List<Midia> findByFilmeId (Long id){
        List<Midia> midiasDoFilme = new ArrayList<>();
        midiasDoFilme = midiaRepository.findByFilmeId(id);
        return midiasDoFilme;
    }
    
    public List<Midia> findByIdIn(List<Long> midias) {
        return midiaRepository.findByIdIn(midias);
    }

    public void updateAluguelToNullByIdMidias(List<Long> midias) {
        midiaRepository.updateAluguelToNullByIdMidias(midias);
    }

 

}
