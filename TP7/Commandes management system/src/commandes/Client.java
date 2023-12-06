package commandes;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Client")
public class Client {
	
	@Id
	@Column(name= "Numcl")
	private int Numcl;
	
	@Column(name= "Nomcl")
	private String Nomcl;
	
	@Column(name= "Prenomcl")
	private String Prenomcl;
	
	@Column(name= "Adresscl")
	private String Adresscl;
	
	@Column(name= "Telcl")
	private String Telcl;

	public Client() {
		super();
	}

	public Client(int numcl, String nomcl, String prenomcl, String adresscl, String telcl) {
		super();
		Numcl = numcl;
		Nomcl = nomcl;
		Prenomcl = prenomcl;
		Adresscl = adresscl;
		Telcl = telcl;
	}

	public int getNumcl() {
		return Numcl;
	}

	public void setNumcl(int numcl) {
		Numcl = numcl;
	}

	public String getNomcl() {
		return Nomcl;
	}

	public void setNomcl(String nomcl) {
		Nomcl = nomcl;
	}

	public String getPrenomcl() {
		return Prenomcl;
	}

	public void setPrenomcl(String prenomcl) {
		Prenomcl = prenomcl;
	}

	public String getAdresscl() {
		return Adresscl;
	}

	public void setAdresscl(String adresscl) {
		Adresscl = adresscl;
	}

	public String getTelcl() {
		return Telcl;
	}

	public void setTelcl(String telcl) {
		Telcl = telcl;
	}
	public static List<Client> findAll(EntityManager em) {
        TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c", Client.class);
        return query.getResultList();
    }
	

}
