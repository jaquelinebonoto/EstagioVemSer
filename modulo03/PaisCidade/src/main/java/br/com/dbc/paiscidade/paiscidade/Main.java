
package br.com.dbc.paiscidade.paiscidade;
import javax.persistence.*;

public class Main {


    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("paiscidade");
        EntityManager em = emf.createEntityManager();
    }
}
