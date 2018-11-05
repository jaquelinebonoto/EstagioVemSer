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
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jaqueline.bonoto
 */
public interface MidiaRepository extends JpaRepository<Midia, Long> {
    public Long countByTipo(Tipo tipo);
    public Page<Midia> findByAluguelPrevisao(Pageable pageable, LocalDate previsao);
    public List<Midia> findByFilmeId(Long i);

    @Query("select m from Midia m where m.id in (:midias)")
    public List<Midia> findByIdIn(@Param("midias")List<Long> midias);

    @Modifying
    @Query("update Midia m set m.aluguel = null where m.id in (:midias)")
    public void updateAluguelToNullByIdMidias(@Param("midias")List<Long> midias);

    //@Query("select f from Filme f where f.id in(:midias) and Midia.tipo = tipo ")
    public List<Midia> findByFilmeIdAndTipo(Long i, Tipo tipo);

    //public Long countByFilmeIdAndTipo(Long id, Tipo tipo);

    public long countByTipoAndFilme(Tipo tipo, Filme filme);
    
    public Midia findFirstByFilmeIdAndTipoAndAluguelIsNull(Long id, Tipo tipo);
}
