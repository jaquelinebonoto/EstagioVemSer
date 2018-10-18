/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.floricultura.ws;

import br.com.dbc.floricultura.bean.ProdutoDAO;
import br.com.dbc.floricultura.entity.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author tiago
 */
@Stateless()
@WebService(serviceName = "ProdutoWS")
public class ProdutoWS {

    @EJB
    private ProdutoDAO produtoDao;

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Produto entity) {
        produtoDao.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Produto entity) {
        produtoDao.edit(entity);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return produtoDao.count();
    }

    @WebMethod(operationName = "find")
    public Produto find(@WebParam(name = "id") Long id) {
        return produtoDao.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Produto> findAll() {
        return produtoDao.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Produto> findRange(@WebParam(name = "range") int[] range) {
        return produtoDao.findRange(range);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Produto entity) {
        produtoDao.remove(entity);
    }

    public void setProdutoDao(ProdutoDAO produtoDao) {
        this.produtoDao = produtoDao;
    }
    
    
    
}
