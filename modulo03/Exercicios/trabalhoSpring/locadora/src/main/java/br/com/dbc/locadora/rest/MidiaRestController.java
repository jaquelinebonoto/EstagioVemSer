/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.locadora.rest;

import br.com.dbc.locadora.entity.Midia;
import br.com.dbc.locadora.entity.Tipo;
import br.com.dbc.locadora.service.MidiaService;
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
@RequestMapping("/api/midia")
public class MidiaRestController extends AbstractController<Midia> {
    @Autowired
    private MidiaService service;

    @Override
    public MidiaService getService() {
        return service;
    }
    
    @GetMapping("/count/{tipo}")
    public ResponseEntity<Long> countByTipo(@PathVariable Tipo tipo){
        return ResponseEntity.ok(service.countByTipo(tipo));
    }
}
