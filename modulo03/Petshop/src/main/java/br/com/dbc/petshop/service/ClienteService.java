/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.petshop.service;

import br.com.dbc.petshop.entity.Cliente;
import br.com.dbc.petshop.entity.HibernateUtil;
import br.com.dbc.petshop.entity.PersistenceUtils;
import br.com.dbc.petshop.entity.SexoType;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jaqueline.bonoto
 */
public class ClienteService {

    private static ClienteService instance;

    public static ClienteService getInstance() {
        return instance == null ? new ClienteService() : instance;
    }

    private ClienteService() {
    }

    public void adiciona10() throws SQLException { //adicionando 10 elementos com o Persistence
        EntityManager em1 = PersistenceUtils.getEm();
        em1.getTransaction().begin(); //abrir a transação
        for (int i = 0; i < 10; i++) {
            Cliente c = new Cliente (null, "Joao"+i , SexoType.M, "reporter"+i);
            em1.persist(c);
            //String sql = "INSERT INTO CLIENTE (ID, NOME, SEXO, PROFISSAO)" + "values (cliente_seq.nextval, 'Joao' + i, 'M', 'Reporter' +i)";
        }
        em1.getTransaction().commit();//encerrar a transação
    }
    
    public List<Cliente> buscarClientePorNomeCriteria(String nome) {//
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            return session.createCriteria(Cliente.class)
                    .add(Restrictions.ilike("nome", nome))
                    .list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void adiciona10Hibernate() throws SQLException { //adicionando 10 elementos com o Persistence
        Session sess = HibernateUtil.getSessionFactory().openSession();
        sess.getTransaction().begin();
        
        for (int i = 0; i < 10; i++) {
            Cliente c = new Cliente (null, "Joao"+i , SexoType.M, "reporter"+i);
            sess.save(c);           
        }
        sess.getTransaction().commit(); 
    }
}
