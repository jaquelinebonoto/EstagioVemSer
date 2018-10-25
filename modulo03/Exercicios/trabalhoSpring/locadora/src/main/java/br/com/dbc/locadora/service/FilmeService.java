/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.service;

import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author jaqueline.bonoto
 */
@Service
public class FilmeService extends AbstractCRUDService<Filme>{
    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    protected JpaRepository<Filme, Long> getRepository() {
        return filmeRepository;
    }
    
}
