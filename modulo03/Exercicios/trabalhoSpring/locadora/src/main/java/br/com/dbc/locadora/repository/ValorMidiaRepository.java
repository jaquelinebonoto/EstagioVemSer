
package br.com.dbc.locadora.repository;

import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.ValorMidia;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jaqueline.bonoto
 */
public interface ValorMidiaRepository extends JpaRepository<ValorMidia, Long> {

    public void deleteByMidiaId(Long id);

    public List<ValorMidia> findByMidiaId(Long id);

    @Query("select vm from ValorMidia vm where vm.midia.id in (:midias) and vm.inicioVigencia >= :retirada and (vm.fimVigencia is null or vm.fimVigencia <= :retirada)")
    public List<ValorMidia> findByMidiaIdIn(@Param("midias")List<Long> midias, @Param("retirada")LocalDateTime retirada);
    
    //@Query("select vm from ValorMidia vm where vm.midia.id in (:midias)")
    //public List<ValorMidia> findByMidiaId(@Param("midias") id);

    public Optional<ValorMidia> findByMidiaIdAndFimVigenciaIsNull(Long id);

    
       
}
