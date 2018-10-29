/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.repository;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.Filme;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jaqueline.bonoto
 */
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    
    /*@Query("select a from Aluguel a where a.filtro = :filtro")
    public List<Aluguel> alugueis (@Param("filtro") String filtro);*/
    
}
