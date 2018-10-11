/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.floricultura.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author tiago
 */
@javax.ws.rs.ApplicationPath("api") //api rest implementada
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() { //adiciona as classes que recbem as comunicacoes
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.dbc.floricultura.rest.ProdutoResource.class);
    }
    
}
