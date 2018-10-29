/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.repository;

import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.Tipo;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jaqueline.bonoto
 */
public interface MidiaRepository extends JpaRepository<Midia, Long> {
    public Long countByTipo(Tipo tipo);
    public Page<Midia> findByAluguelPrevisao(Pageable pageable, LocalDate previsao);

}
