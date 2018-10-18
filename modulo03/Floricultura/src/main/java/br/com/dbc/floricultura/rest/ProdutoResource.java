/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.floricultura.rest;

import br.com.dbc.floricultura.bean.ProdutoDAO;
import br.com.dbc.floricultura.entity.Produto;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author tiago
 */
@Stateless
@Path("produto")
public class ProdutoResource {

    @Inject
    private ProdutoDAO produtoDao;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Produto entity) {
        produtoDao.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Produto entity) {
        produtoDao.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        produtoDao.remove(produtoDao.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Long id) {
        return Response.ok(produtoDao.find(id)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll(@DefaultValue("0")@QueryParam("ini") int ini, @DefaultValue("20")@QueryParam("fim") int fim) {
        return Response.ok(produtoDao.findRange(new int[]{ini, fim})).build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return Response.ok(produtoDao.findRange(new int[]{from, to})).build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(produtoDao.count());
    }
}
