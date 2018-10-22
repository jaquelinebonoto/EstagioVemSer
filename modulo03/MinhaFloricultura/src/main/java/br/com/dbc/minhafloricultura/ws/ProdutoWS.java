/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.minhafloricultura.ws;

import br.com.dbc.minhafloricultura.entidade.Produto;
import br.com.dbc.minhafloricultura.entidade.dao.ProdutoDAO;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
//import javax.jws.WebMethod;
import javax.jws.WebService;

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
    @WebMethod(exclude=true)
    public ProdutoDAO getDAO() {
        return produtoDAO;
    }   
    
    /*@WebMethod
    public List<Produto> buscarProdutoPelaDescricao(String descricao){
        return produtoDAO.findAll().
                .createQuery("select p from Produto p where lower(p.nome) like lower(:nome)")
                .setParameter("nome", nome)
                .getResultList();
    }*/
}
