
package br.com.dbc.locadora.service;

import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jaqueline.bonoto
 */
@Transactional(readOnly = true)
public abstract class AbstractCRUDService<E> {
    protected abstract JpaRepository<E, Long> getRepository();
    
    @Transactional(readOnly = false)
    public E save(E e) {
        return getRepository().save(e);
    }
    
    @Transactional(readOnly = false)
    public void delete(Long id) {
        getRepository().deleteById(id);
    }
    
    public Page<E> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }
    
    public Optional<E> findById(Long id){
        return getRepository().findById(id);
    }

    @Transactional(readOnly = false)
    public E update(Long id, E input) {
        return getRepository().save(input);
    }
    
}