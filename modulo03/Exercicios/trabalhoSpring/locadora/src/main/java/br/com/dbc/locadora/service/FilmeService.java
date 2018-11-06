/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.dto.CatalogoDTO;
import br.com.dbc.locadora.entity.Categoria;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.dto.FilmeDTO;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.dto.MidiaDTO;
import br.com.dbc.locadora.dto.MidiaDTOCatalogo;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.entity.ValorMidia;
import br.com.dbc.locadora.repository.FilmeRepository;
import br.com.dbc.locadora.repository.MidiaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
public class FilmeService extends AbstractCRUDService<Filme> {

    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private MidiaService midiaService;
    
        @Autowired
    private MidiaRepository midiaRepository;
    
    @Autowired
    private ValorMidiaService valorMidiaService;
    
    @Override
    protected JpaRepository<Filme, Long> getRepository() {
        return filmeRepository;
    }
    
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Filme salvarComMidia(@RequestBody FilmeDTO dto) { //
        Filme filme = getRepository().save(dto.DtotoFilme());
        for (MidiaDTO midiaDTO : dto.getMidia()) {
            midiaService.salvarMidiaDTO(midiaDTO, filme);            
        }
        return filme;
    }
    
    public Page<Filme> findByTituloContainingIgnoreCaseOrCategoriaOrLancamentoBetween(
            Pageable pageable, 
            String titulo, 
            Categoria categoria, 
            LocalDate lancamentoIni, 
            LocalDate lancamentoFim) {
        return filmeRepository.findByTituloContainingIgnoreCaseOrCategoriaOrLancamentoBetween(pageable, titulo, categoria, lancamentoIni, lancamentoFim);
    }
        
    public Page<Filme> findByAluguelPrevisao(
            Pageable pageable,
            LocalDate previsao) {
        Page<Midia> midias = midiaService.findByAluguelPrevisao(pageable, previsao);

       List<Filme> filmes = new ArrayList<>();
       midias.getContent().forEach(m -> {
           filmes.add(m.getFilme());
       });
       Page<Filme> page = new PageImpl<>(filmes, pageable,midias.getTotalElements());
       return page;
    }
    
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Filme updateFilme(Long id, FilmeDTO dto) {
        Filme filme = filmeRepository.findById(id).get();
        filme.setTitulo(dto.getTitulo());
        filme.setCategoria(dto.getCategoria());
        filme.setLancamento(dto.getLancamento());
        filmeRepository.save(filme);

        //List<Midia> midiaSistema = midiaService.pegarMidiasDoFilme(id);
        for (MidiaDTO midiaDTO : dto.getMidia()) {
            midiaService.updateMidiaDTO(midiaDTO, filme);
        }
        return filme;//        return Filme.builder().build();        
    }
    
    public List<ValorMidia> valoresByFilme (Long id){
        List<Midia> midias = midiaService.findByFilmeId(id);
        
        List<ValorMidia> valoresDoFilme = new ArrayList<>(); //para receber todos os valores que foram cadastrados
        List<ValorMidia> valoresValidos = new ArrayList<>(); //para receber os vigentes
        
        for(int i = 0; i < midias.size(); i++) {
            valoresDoFilme = valorMidiaService.findByMidiaId(midias.get(i).getId());    
            for(int k = 0; k < valoresDoFilme.size(); k++) {
                if (valoresDoFilme.get(k).getFimVigencia() == null){
                    valoresValidos.add(valoresDoFilme.get(k));
                } 
            }
        }
        return valoresValidos;
    }

    public Page<CatalogoDTO> createCatalogo(Pageable pageable, @RequestBody String titulo){
        System.out.println(titulo);
        Page<Filme> filme = (filmeRepository.findByTituloContainingAllIgnoreCase(
                pageable, 
                titulo
                ));
        
        List<CatalogoDTO> catalogo = new ArrayList<>();
        for (int i=0; i<filme.getTotalElements() ; i++){
            List<MidiaDTOCatalogo> midiasDisponiveis = new ArrayList<>();
            Midia midVHS = midiaRepository.findFirstByFilmeIdAndTipoAndAluguelIsNull(filme.getContent().get(0).getId(), Tipo.VHS);
            Midia midDVD = midiaRepository.findFirstByFilmeIdAndTipoAndAluguelIsNull(filme.getContent().get(0).getId(), Tipo.DVD);
            Midia midBR = midiaRepository.findFirstByFilmeIdAndTipoAndAluguelIsNull(filme.getContent().get(0).getId(), Tipo.BLUE_RAY);
            
            if(midVHS == null){ midiasDisponiveis.add(midiaService.midiaToCatalogoIndisponivel(midVHS));}
            else midiasDisponiveis.add(midiaService.midiaToCatalogo(midVHS));
            if(midDVD == null){ midiasDisponiveis.add(midiaService.midiaToCatalogoIndisponivel(midDVD));}
            midiasDisponiveis.add(midiaService.midiaToCatalogo(midDVD));
            if(midBR == null){ midiasDisponiveis.add(midiaService.midiaToCatalogoIndisponivel(midBR));}
            midiasDisponiveis.add(midiaService.midiaToCatalogo(midBR));
            
            catalogo.add(CatalogoDTO.builder()
                 .filme(filme.getContent().get(i))
                 .midias(midiasDisponiveis)
                 .build());
        }        
        return new PageImpl<>(catalogo, pageable, filme.getTotalElements());
    }  
}