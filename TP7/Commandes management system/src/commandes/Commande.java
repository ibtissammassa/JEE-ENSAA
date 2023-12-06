package commandes;

import javax.persistence.*;

@Entity
@Table(name = "Commande")
public class Commande {
	@Id
	@Column(name= "Numcom")
	private int Numcom;
	
	@Column(name= "Datecom")
	private String Datecom;
	@ManyToOne
    @JoinColumn(name = "Numcl")
	private Client client;
	
	public Commande() {}
	public Commande(int numcom, String datecom, Client client) {
		super();
		Numcom = numcom;
		Datecom = datecom;
		this.client = client;
	}

	public int getNumcom() {
		return Numcom;
	}

	public void setNumcom(int numcom) {
		Numcom = numcom;
	}

	public String getDatecom() {
		return Datecom;
	}

	public void setDatecom(String datecom) {
		Datecom = datecom;
	}


	

}
