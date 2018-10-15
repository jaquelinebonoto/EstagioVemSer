/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dbc.petshophibernate.dao;

import br.com.dbc.petshophibernate.entity.Cliente;
import java.io.PrintStream;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author jaqueline.bonoto
 */
public abstract class AbstractDAO<ENTITY>{
    private Class<ENTITY> entityClass;
    
    public AbstractDAO (Class entityClass){
        this.entityClass = entityClass;
    }
    
    public ENTITY findById(Long id){
                return entityClass
                    .cast(HibernateUtil.getSessionFactory()
                    .openSession()
                    .createCriteria(entityClass)
                    .add(Restrictions.eq("id", id))
                .uniqueResult());
    }

    public void createOrUpdate (ENTITY e){
        Session session = null;
        try{
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction  = session.beginTransaction();
        session.saveOrUpdate(e);
        transaction.commit();
        } catch(Exception ex){
            ex.printStackTrace();
            throw ex;
        }finally {
            if(session != null)
                session.close();
        }
    }
}
