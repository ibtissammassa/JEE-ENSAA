package commandes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ecole");
		        EntityManager em = emf.createEntityManager();

		        try {
		            em.getTransaction().begin();
		            
		            //C
		            Article article = new Article("123", "Article1", "Rouge", "10", 150);
		            em.persist(article);

		            Article article2 = new Article("1", "Article2", "red", "10", 100);
		            em.persist(article2);

		            
		            Client client = new Client(1, "a", "b", "1 til aga", "0666666");
		            em.persist(client);

		            Utilisateur utilisateur = new Utilisateur("USER1", "utili", "user", "Manager");
		            em.persist(utilisateur);
		            
		            Facture facture = new Facture(1,"2024-01-01","100",utilisateur);
		            em.persist(facture);


		            em.getTransaction().commit();

		            
		            System.out.println("Liste des articles :");
		            List<Article> articles = Article.findAll(em);
		            for (Article a : articles) {
		                System.out.println("** "+a.getCodeart() + "  ** " + a.getDesart());
		            }

		            System.out.println("Liste des clients :");
		            List<Client> clients = Client.findAll(em);
		            for (Client c : clients) {
		                System.out.println("** "+c.getNumcl() + " ** " + c.getNomcl() + " " + c.getPrenomcl());
		            }
		            
		            System.out.println("Liste des utilisateurs :");
		            List<Utilisateur> utilisateurs = Utilisateur.findAll(em);
		            for (Utilisateur c : utilisateurs) {
		                System.out.println("** "+ c.getCodeut() + " *** " + c.getNomut() + " " + c.getPrenomut()+" ** "+c.getFonction());
		            }

		            em.getTransaction().begin();
		            
		            //U
		            Article articleToUpdate = em.find(Article.class, "123");
		            if (articleToUpdate != null) {
		                articleToUpdate.setDesart("Article update");
		            }
		            
		            

		            em.getTransaction().commit();
		            
		            System.out.println("Liste des articles apres modification :");
		            List<Article> articles2 = Article.findAll(em);
		            for (Article a : articles2) {
		                System.out.println("** "+a.getCodeart() + "  ** " + a.getDesart());
		            }

		            em.getTransaction().begin();
		            
		            //D
		            Article articleToDelete = em.find(Article.class, "1");
		            if (articleToDelete != null) {
		                em.remove(articleToDelete);
		            }

		            em.getTransaction().commit();
		            
		            System.out.println("Liste des articles apres suppression :");
		            List<Article> articles3 = Article.findAll(em);
		            for (Article a : articles3) {
		                System.out.println("** "+a.getCodeart() + "  ** " + a.getDesart());
		            }

		        } finally {
		            em.close();
		            emf.close();
		        }
		    }
		
		
		}
		
