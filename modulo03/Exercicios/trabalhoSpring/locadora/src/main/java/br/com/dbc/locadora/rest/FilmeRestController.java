package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Categoria;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.dto.FilmeDTO;
import br.com.dbc.locadora.dto.MidiaDTO;
import br.com.dbc.locadora.dto.MidiaDTOCatalogo;
import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.repository.MidiaRepository;
import br.com.dbc.locadora.service.FilmeService;
import br.com.dbc.locadora.service.MidiaService;
import br.com.dbc.locadora.service.ValorMidiaService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @Autowired
    private MidiaService midiaService;
    
    @Autowired
    private ValorMidiaService valorMidiaService;
    
    @Autowired
    private MidiaRepository midiaRepository;
    @Override
    public FilmeService getService() {
        return service;
    }
    
    
    @PostMapping("/midia") //para salvar o filme com as midias e o valor requisito 2
    public Filme salvarComMidia(@RequestBody FilmeDTO dto) {
        return (getService().salvarComMidia(dto));
    }
    
    @RequestMapping(value="/search", method = RequestMethod.GET)
    public ResponseEntity<Page<Filme>> findByTituloContainingIgnoreCaseOrCategoriaOrLancamentoBetween(
                Pageable pageable,
                @RequestParam(value = "titulo", required = false) String titulo,
                @RequestParam(value = "categoria" , required = false) Categoria categoria,
                @RequestParam(value = "lancamento", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lancamentoIni, 
                @RequestParam(value = "lancamento", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate lancamentoFim)
                {
       return ResponseEntity.ok(
                getService().findByTituloContainingIgnoreCaseOrCategoriaOrLancamentoBetween(pageable, titulo, categoria, lancamentoIni, lancamentoFim)
            ); 
    }
    
    @PutMapping("/{id}/midia")
    public ResponseEntity<?> put(@PathVariable Long id, @RequestBody FilmeDTO input) {
        return ResponseEntity.ok(getService().updateFilme(id, input));
    }

    @GetMapping("/precos/{id}")
    @RequestMapping(value="/precos/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findValorMidiaByIdFilme (@PathVariable Long id) {
        return ResponseEntity.ok(getService().valoresByFilme(id));
    }
        
    @GetMapping("/count/{id}/{tipo}")
    public ResponseEntity<Long> get(@PathVariable Long id, @PathVariable Tipo tipo){
        Filme filme = service.findById(id).orElse(null);        
        return ResponseEntity.ok(midiaService.countByTipoAndFilme(tipo, filme));
    }
    
    @PostMapping("/search/catalogo")
    public ResponseEntity<?> createCatalogo (Pageable pageable, @RequestBody String titulo){
        return ResponseEntity.ok(getService().createCatalogo(pageable, titulo));
    }    
}
