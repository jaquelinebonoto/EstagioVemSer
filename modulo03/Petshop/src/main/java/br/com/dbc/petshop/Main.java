package br.com.dbc.petshop;

import br.com.dbc.petshop.entity.Cliente;
import br.com.dbc.petshop.entity.HibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;


public class Main {

    public static void main(String... args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("petshop");
        EntityManager em = factory.createEntityManager();
        List<Cliente> clientes = em.createQuery("select c from Cliente c").getResultList();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        clientes = session.createCriteria(Cliente.class).list();
        
        
    }

}
