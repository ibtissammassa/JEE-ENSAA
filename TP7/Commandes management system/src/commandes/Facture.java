package commandes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Facture")
public class Facture {

	@Id
	@Column(name= "Numfact")
	private int Numfact;
	
	@Column(name= "Datefact")
	private String Datefact;
	
	@Column(name= "Montant")
	private String Montant;
	@ManyToOne
    @JoinColumn(name = "Codeut") 
    private Utilisateur utilisateur;

	public int getNumfact() {
		return Numfact;
	}

	public void setNumfact(int numfact) {
		Numfact = numfact;
	}

	public String getDatefact() {
		return Datefact;
	}

	public void setDatefact(String datefact) {
		Datefact = datefact;
	}

	public String getMontant() {
		return Montant;
	}

	public void setMontant(String montant) {
		Montant = montant;
	}

	public Facture(int numfact, String datefact, String montant, Utilisateur utilisateur) {
		super();
		Numfact = numfact;
		Datefact = datefact;
		Montant = montant;
		this.utilisateur = utilisateur;
	}


	
}
