package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappingTest3 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecole");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Noter note1 = new Noter(2300, "JEE", 16.75);
        em.persist(note1);

        Noter note2 = new Noter(5376, "JEE", 18.00);
        em.persist(note2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
