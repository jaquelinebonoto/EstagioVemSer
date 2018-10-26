
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Aluguel;
import br.com.dbc.locadora.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
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
    
}