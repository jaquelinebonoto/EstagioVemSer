package br.com.dbc.minhafloricultura.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author jaqueline.bonoto
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    }


    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.dbc.minhafloricultura.rest.ClienteFacadeREST.class);
        resources.add(br.com.dbc.minhafloricultura.rest.ProdutoFacadeREST.class);
        resources.add(br.com.dbc.minhafloricultura.rest.VendaFacadeREST.class);
    }
    
}
