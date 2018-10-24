
package br.com.dbc.seguradora.rest;

import br.com.dbc.seguradora.entity.Apolice;
import br.com.dbc.seguradora.service.ApoliceService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author jaqueline.bonoto
 */
@RestController
@RequestMapping("/api/apolice")
public class ApoliceRestController {
    
    @Autowired
    private ApoliceService apoliceService;
    
    @GetMapping()    
    public ResponseEntity<Page<Apolice>> list(Pageable pageable) {
        return ResponseEntity.ok(apoliceService.findAll(pageable));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        return apoliceService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable Long id, @Valid @RequestBody Apolice input) {
        return ResponseEntity.ok(apoliceService.update(id, input));
    }
      
    @PostMapping
    public ResponseEntity<?> post(@RequestBody Apolice input) {
        return ResponseEntity.ok(apoliceService.save(input));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        apoliceService.delete(id);
        return ResponseEntity.ok().build();
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    }
    
        
}
