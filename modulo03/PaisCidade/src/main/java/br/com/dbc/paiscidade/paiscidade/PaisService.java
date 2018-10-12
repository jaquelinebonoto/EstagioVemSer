
package br.com.dbc.paiscidade.paiscidade;
import br.com.br.dbc.paiscidade.paiscidade.entity.Pais;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author jaqueline.bonoto
 */
public class PaisService {
    private static EntityManager em;
    private static PaisService instance;
    
    public static PaisService getInstance(){
        return instance == null ? new PaisService(): instance;
    }
    
    private static EntityManager getEm(){
        if(em ==  null){
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("paiscidade");
            em = emf.createEntityManager();
        }
        return em;
    }
    
    private PaisService() {}
    
    public List<Pais> buscarPaisPorNome (String nome){
        return getEm()
                .createQuery("select p from Pais p where lower(p.nomepais) like :nome", Pais.class)
                .setParameter("nome", nome.toLowerCase())
                .getResultList();
    }
    
    public List<Pais> buscarPaisPorSigla (String sigla){
        return getEm()
                .createQuery("select p from Pais p where p.siglapais like :sigla", Pais.class)
                .setParameter("sigla", sigla)
                .getResultList();
    }
    
    public List<Pais> buscarPaisPorId (Long Id){
        return getEm()
                .createQuery("select p from Pais p where p.idpais like :Id", Pais.class)
                .setParameter("Id", Id)
                .getResultList();
    }   
    
    
}
