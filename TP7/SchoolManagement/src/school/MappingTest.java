package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappingTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecole");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Departement dep = new Departement("GINFO", "Génie Informatique");
        em.persist(dep);

        Enseignant ens = new Enseignant("Aimad", "QAZDAR", dep);
        em.persist(ens);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
