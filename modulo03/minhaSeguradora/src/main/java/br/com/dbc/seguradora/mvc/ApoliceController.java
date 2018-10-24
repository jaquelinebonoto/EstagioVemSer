
package br.com.dbc.seguradora.mvc;

import br.com.dbc.seguradora.entity.Apolice;
import br.com.dbc.seguradora.service.ApoliceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jaqueline.bonoto
 */
@Controller
public class ApoliceController {
    
    @Autowired
    private ApoliceService apoliceService;
    
    @GetMapping("/")
    public String findAll(Model model) {
        List<Apolice> apolices = apoliceService.findAll(PageRequest.of(0, 20)).getContent();
        model.addAttribute("apolices", apolices);
        return "apolice";
    }
    
    @PostMapping("/")
    public String save(Apolice apolice, Model model) {
        apoliceService.save(apolice);
        List<Apolice> apolices = apoliceService.findAll(PageRequest.of(0, 20)).getContent();
        model.addAttribute("apolices", apolices);
        return "apolice";
    }
    
}
