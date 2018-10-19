/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.minhafloricultura.entidade.dao;

import br.com.dbc.minhafloricultura.entidade.Produto;
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
    
}
