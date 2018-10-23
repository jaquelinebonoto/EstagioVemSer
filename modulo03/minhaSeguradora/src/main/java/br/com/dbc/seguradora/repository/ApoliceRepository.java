
package br.com.dbc.seguradora.repository;

import br.com.dbc.seguradora.entity.Apolice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jaqueline.bonoto
 */
public interface ApoliceRepository extends JpaRepository<Apolice, Long> {
    
}
