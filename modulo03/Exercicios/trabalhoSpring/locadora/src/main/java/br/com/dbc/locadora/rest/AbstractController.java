
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.service.AbstractCRUDService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author jaqueline.bonoto
 * @param <ENTIDADE>
 */
public abstract class AbstractController <ENTIDADE> {
    protected abstract AbstractCRUDService<ENTIDADE> getService();
    

    @GetMapping()    
    public ResponseEntity<Page<ENTIDADE>> list(Pageable pageable) {
        return ResponseEntity.ok(getService().findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return getService().findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody ENTIDADE input) {
        return ResponseEntity.ok(getService().save(input));
    }
    
    
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody ENTIDADE input) {
        return ResponseEntity.ok(getService().save(input));
    }
       
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.ok().build();
    }
}
