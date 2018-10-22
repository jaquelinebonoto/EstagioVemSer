package br.com.dbc.minhafloricultura.rest;

import br.com.dbc.minhafloricultura.entidade.Cliente;
import br.com.dbc.minhafloricultura.entidade.dao.AbstractDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author jaqueline.bonoto
 */
public abstract class AbstractCrudRest<T, DAO extends AbstractDAO<T>> {

    protected abstract DAO getDAO();

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(T entity) {
        getDAO().create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, T entity) {
        getDAO().edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id, T entity) {
        getDAO().remove(entity);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok(getDAO().find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return Response.ok(getDAO().findAll()).build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return Response.ok(getDAO().findRange(new int[]{from, to})).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public int count() {
       return getDAO().count();
    }
    
}
