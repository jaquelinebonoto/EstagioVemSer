
package br.com.dbc.petshopjpa.dao;

import static java.lang.String.format;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author jaqueline.bonoto
 */
public abstract class AbstractDAO <E, ID>{
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    protected abstract Class<E> getEntityClass();

    public List<E> findAll() {
        EntityManager em = PersistenceUtils.getEntityManager();
        return em.createQuery(
                format("select e from %s e", getEntityClass().getSimpleName()),
                getEntityClass()).getResultList();
    }

    public E findOne(ID id) {
        EntityManager em = PersistenceUtils.getEntityManager();
        return em.createQuery(
                format("select e from %s e where e.id = :id", getEntityClass().getSimpleName()),
                getEntityClass())
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(ID id) {
        EntityManager em = PersistenceUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery(
                    format("delete from %s e where e.id = :id", getEntityClass().getSimpleName()))
                    .setParameter("id", id)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void create(E entity) {
        EntityManager em = PersistenceUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            em.getTransaction().rollback();
            throw ex;
        }
    }

    public void update(E entity) {
        EntityManager em = PersistenceUtils.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            em.getTransaction().rollback();
            throw ex;
        }
    }
}
