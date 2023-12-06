package school;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MappingTest2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecole");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Departement dep = new Departement("GINFO", "Génie Informatique");
        em.persist(dep);

        Enseignant ens1 = new Enseignant("Aimad", "QAZDAR", dep);
        em.persist(ens1);

        Matiere mat1 = new Matiere("JEE", "Java Entreprise Edition");
        mat1.ajouterEnseigant(ens1);

        Matiere mat2 = new Matiere("SOA", "Architecture Orientée Services");
        mat2.ajouterEnseigant(ens1);

        em.persist(mat1);
        em.persist(mat2);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
