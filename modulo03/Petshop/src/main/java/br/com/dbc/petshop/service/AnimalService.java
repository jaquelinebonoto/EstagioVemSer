
package br.com.dbc.petshop.service;


import br.com.dbc.petshop.entity.Animal;
import br.com.dbc.petshop.entity.Cliente;
import br.com.dbc.petshop.entity.PersistenceUtils;
import br.com.dbc.petshop.entity.SexoType;
import java.sql.SQLException;
import javax.persistence.EntityManager;


public class AnimalService {
    private static AnimalService instance;
   
    public static AnimalService getInstance(){
        return instance == null ? new AnimalService(): instance;
    }
    
  
    private AnimalService() {}
    
    public void adiciona10Animais(Cliente cliente) throws SQLException {
        EntityManager em1 = PersistenceUtils.getEm();
        em1.getTransaction().begin(); //abrir a transação
        for (int i = 0; i < 10; i++) {
            Animal a;
            a = new Animal(null, "Cao" +i, SexoType.F, cliente);
            em1.persist(a);
        }
        em1.getTransaction().commit();//encerrar a transação
    }
    
    
}