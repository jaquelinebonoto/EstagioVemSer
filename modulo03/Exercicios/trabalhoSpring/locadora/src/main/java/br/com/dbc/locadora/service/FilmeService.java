/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.entity.MidiaDTO;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class FilmeService extends AbstractCRUDService<Filme>{
    @Autowired
    private FilmeRepository filmeRepository;
    
    @Autowired
    private MidiaService midiaService;

    @Override
    protected JpaRepository<Filme, Long> getRepository() {
        return filmeRepository;
    }
 
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public Filme salvarComMidia(@RequestBody FilmeDTO dto){ //
        Filme filme = getRepository().save(dto.DtotoFilme());
        for(MidiaDTO midiaDTO: dto.getMidia()){
          midiaService.salvarMidiaDTO(midiaDTO, filme);          
        }
        return filme;
    }
    
}


