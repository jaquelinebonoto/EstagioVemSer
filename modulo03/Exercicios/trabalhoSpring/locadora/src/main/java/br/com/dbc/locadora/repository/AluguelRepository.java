/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.repository;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author jaqueline.bonoto
 */
public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
    
    /*@Query("select a from Aluguel a where a.filtro = :filtro")
    public List<Aluguel> alugueis (@Param("filtro") String filtro);*/
    
    
}
