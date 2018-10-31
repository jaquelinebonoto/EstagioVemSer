package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Categoria;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.entity.FilmeDTO;
import br.com.dbc.locadora.service.FilmeService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jaqueline.bonoto
 */
@RestController
@RequestMapping("/api/filme")
public class FilmeRestController extends AbstractController<Filme> {
    @Autowired
    private FilmeService service;

    @Override
    public FilmeService getService() {
        return service;
    }
    
    @PostMapping("/midia") //para salvar o filme com as midias e o valor requisito 2
    public ResponseEntity<?> salvarComMidia(@RequestBody FilmeDTO dto) {
        return ResponseEntity.ok(getService().salvarComMidia(dto));
    }
    
    @RequestMapping(value="/search", method = RequestMethod.GET)
    public ResponseEntity<Page<Filme>> findByTituloOrCategoriaOrLancamento(
                Pageable pageable,
                @RequestParam(value = "titulo", required = false) String titulo,
                @RequestParam(value = "categoria" , required = false) Categoria categoria,
                @RequestParam(value = "lancamento", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate lancamento) {

       return ResponseEntity.ok(
                getService().findByTituloOrCategoriaOrLancamento(pageable, titulo, categoria, lancamento)
            ); 
    }
    
    @PutMapping("/{id}/midia")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody FilmeDTO input) {
        return ResponseEntity.ok(getService().updateFilme(id, input));
    }

}
