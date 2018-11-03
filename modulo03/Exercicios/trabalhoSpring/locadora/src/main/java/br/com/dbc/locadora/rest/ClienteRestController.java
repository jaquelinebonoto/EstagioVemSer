/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.config.SoapConnector;
import br.com.dbc.locadora.entity.Cliente;
import br.com.dbc.locadora.service.ClienteService;
import br.com.dbc.locadora.ws.ConsultaCEP;
import br.com.dbc.locadora.ws.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jaqueline.bonoto
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController extends AbstractController<Cliente> {
    @Autowired
    private ClienteService service;

    @Override
    public ClienteService getService() {
        return service;
    }
    
    @Autowired SoapConnector soapConnector;
    @Autowired ObjectFactory objectFactory;
    
    @GetMapping("/cep/{cep}")
    public ResponseEntity<?> cep(@PathVariable("cep") String cep) {
        ConsultaCEP consulta = objectFactory.createConsultaCEP();
        consulta.setCep(cep);
        return ResponseEntity.ok(soapConnector
                .callWebService(
                    objectFactory.createConsultaCEP(consulta)));
    }
}
