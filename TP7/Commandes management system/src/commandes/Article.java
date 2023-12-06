package commandes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import java.util.List;

@Entity
@Table(name = "Article")
public class Article {
	
	@Id
	@Column(name= "Codeart")
	private String Codeart;
	
	@Column(name= "Desart")
	private String Desart;
	
	@Column(name= "Couleur")
	private String Couleur;
	
	@Column(name= "Puart")
	private String Puart;
	
	@Column(name= "Qtestock")
	private int Qtestock;

	public String getCodeart() {
		return Codeart;
	}

	public void setCodeart(String codeart) {
		Codeart = codeart;
	}

	public String getDesart() {
		return Desart;
	}

	public void setDesart(String desart) {
		Desart = desart;
	}

	public String getCouleur() {
		return Couleur;
	}

	public void setCouleur(String couleur) {
		Couleur = couleur;
	}

	public String getPuart() {
		return Puart;
	}

	public void setPuart(String puart) {
		Puart = puart;
	}

	public int getQtestock() {
		return Qtestock;
	}

	public void setQtestock(int qtestock) {
		Qtestock = qtestock;
	}
	public Article() {}

	public Article(String codeart, String desart, String couleur, String puart, int qtestock) {
		super();
		Codeart = codeart;
		Desart = desart;
		Couleur = couleur;
		Puart = puart;
		Qtestock = qtestock;
	}
	public static List<Article> findAll(EntityManager em) {
        TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
        return query.getResultList();
    }

}
