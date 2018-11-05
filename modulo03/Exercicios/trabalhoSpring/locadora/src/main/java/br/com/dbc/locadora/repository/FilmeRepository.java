/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.repository;

import br.com.dbc.locadora.entity.Categoria;
import br.com.dbc.locadora.entity.Filme;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jaqueline.bonoto
 */
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    public Page<Filme> findByTituloContainingIgnoreCaseOrCategoriaOrLancamentoBetween(Pageable pageable, String titulo, Categoria categoria, LocalDate lancamentoIni, LocalDate lancamentoFim);
    
}
