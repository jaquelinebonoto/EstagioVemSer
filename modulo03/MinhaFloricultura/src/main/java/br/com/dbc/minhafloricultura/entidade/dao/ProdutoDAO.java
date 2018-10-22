/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.minhafloricultura.entidade.dao;

import br.com.dbc.minhafloricultura.entidade.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jaqueline.bonoto
 */
@Stateless
public class ProdutoDAO extends AbstractDAO<Produto> {

    @PersistenceContext(unitName = "minha_floricultura_pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutoDAO() {
        super(Produto.class);
    }
    
    public List<Produto> buscarProdutoPelaDescricao(String descricao){
        return em
                .createQuery("select p from Produto p where lower(p.descricao) like lower(:descricao)")
                .setParameter("descricao", descricao)
                .getResultList();
    }
    
}
