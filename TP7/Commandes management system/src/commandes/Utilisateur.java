package commandes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TypedQuery;


@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
	
	@Id
	@Column(name= "Codeut")
	private String Codeut;
	
	@Column(name= "Nomut")
	private String Nomut;
	
	@Column(name= "Prenomut")
	private String Prenomut;
	
	@Column(name= "Fonction")
	private String Fonction;


	public String getCodeut() {
		return Codeut;
	}

	public void setCodeut(String codeut) {
		Codeut = codeut;
	}

	public String getNomut() {
		return Nomut;
	}

	public void setNomut(String nomut) {
		Nomut = nomut;
	}

	public String getPrenomut() {
		return Prenomut;
	}

	public void setPrenomut(String prenomut) {
		Prenomut = prenomut;
	}

	public String getFonction() {
		return Fonction;
	}

	public void setFonction(String fonction) {
		Fonction = fonction;
	}


	public Utilisateur(String codeut, String nomut, String prenomut, String fonction) {
		super();
		Codeut = codeut;
		Nomut = nomut;
		Prenomut = prenomut;
		Fonction = fonction;
	}
	
	public static List<Utilisateur> findAll(EntityManager em) {
        TypedQuery<Utilisateur> query = em.createQuery("SELECT c FROM Utilisateur c", Utilisateur.class);
        return query.getResultList();
    }

}
