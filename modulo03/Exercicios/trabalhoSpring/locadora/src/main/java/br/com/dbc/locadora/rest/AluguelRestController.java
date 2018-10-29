
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import br.com.dbc.locadora.entity.Filme;
import br.com.dbc.locadora.service.AluguelService;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/api/aluguel")
public class AluguelRestController extends AbstractController<Aluguel> {
    @Autowired
    private AluguelService aluguelService;

    @Override
    public AluguelService getService() {
        return aluguelService;
    }
    
    @PostMapping("/retirada") 
    public ResponseEntity<?> cadastrarRetirada (@RequestBody AluguelDTO dto) {
        return ResponseEntity.ok(getService().cadastrarRetirada(dto));
    }
    
    @RequestMapping(value="/devolucao", method = RequestMethod.GET)
    public ResponseEntity<Page<Filme>> findByAluguelPrevisao(
                Pageable pageable,
                @RequestParam(value = "previsao", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate previsao){
       return ResponseEntity.ok(
                aluguelService.findByAluguelPrevisao(pageable, previsao)
            );  
    }

}