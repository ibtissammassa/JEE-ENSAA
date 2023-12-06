package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappingTest4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecole");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Coordonnees crd = new Coordonnees("ENSA-agadir", "Agadir", "0525008800", "a.rabii@edu.uiz.ac.ma");
        Etudiant etd1 = new Etudiant(3322, "Ahmed", "RABII", crd);
        em.persist(etd1);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
