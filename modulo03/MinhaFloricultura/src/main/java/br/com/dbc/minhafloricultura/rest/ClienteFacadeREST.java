
package br.com.dbc.minhafloricultura.rest;

import br.com.dbc.minhafloricultura.entidade.Cliente;
import br.com.dbc.minhafloricultura.entidade.dao.ClienteDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jaqueline.bonoto
 */
@Stateless
@Path("cliente")
public class ClienteFacadeREST extends AbstractCrudRest<Cliente, ClienteDAO> {

    @Inject
    private ClienteDAO clienteDAO;


    public String countREST() {
        return String.valueOf(super.count());
    }

  
    @Override
    protected ClienteDAO getDAO() {
        return clienteDAO;
    }
    
}
