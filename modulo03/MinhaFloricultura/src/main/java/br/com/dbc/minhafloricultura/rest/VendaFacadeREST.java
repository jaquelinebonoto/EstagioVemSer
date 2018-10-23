package br.com.dbc.minhafloricultura.rest;


import br.com.dbc.minhafloricultura.entidade.Venda;
import br.com.dbc.minhafloricultura.entidade.dao.VendaDAO;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;


/**
 *
 * @author jaqueline.bonoto
 */
@Stateless
@Path("venda")
public class VendaFacadeREST extends AbstractCrudRest<Venda, VendaDAO> {

    @Inject
    private VendaDAO vendaDAO;

   
    @Override
    protected VendaDAO getDAO() {
        return vendaDAO;
    }
    
}
