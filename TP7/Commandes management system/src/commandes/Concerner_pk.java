package commandes;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Concerner_pk implements Serializable{
	private static final long serialVersionUID = 1L;
    @ManyToOne
    @JoinColumn(name = "Numcom")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "Codeart")
    private Article article;
    @ManyToOne
    @JoinColumn(name = "Numfact")
    private Facture facture;
    
    
	public Concerner_pk(Commande commande, Article article, Facture facture) {
		super();
		this.commande = commande;
		this.article = article;
		this.facture = facture;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	

}
