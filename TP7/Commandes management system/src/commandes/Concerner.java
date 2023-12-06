package commandes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Concerner")
public class Concerner {
	
	
	public Concerner() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Id
    private Concerner_pk pk;
    private int Qtecom;

    
    public Concerner(Concerner_pk pk, int qtecom) {
		super();
		this.pk = pk;
		Qtecom = qtecom;

    
    }


	public Concerner_pk getPk() {
		return pk;
	}


	public void setPk(Concerner_pk pk) {
		this.pk = pk;
	}


	public int getQtecom() {
		return Qtecom;
	}


	public void setQtecom(int qtecom) {
		Qtecom = qtecom;
	}}
