/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.minhafloricultura.ws;

import br.com.dbc.minhafloricultura.entidade.Produto;
import br.com.dbc.minhafloricultura.entidade.dao.AbstractDAO;
import br.com.dbc.minhafloricultura.entidade.dao.ProdutoDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;

/**
 *
 * @author jaqueline.bonoto
 */
@Stateless
@WebService(serviceName = "ProdutoWS")
public class ProdutoWS extends AbstractCrudWS<ProdutoDAO, Produto> {

    @EJB
    private ProdutoDAO produtoDAO;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @Override
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }   
}
