
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.entity.AluguelDTO;
import br.com.dbc.locadora.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

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
}