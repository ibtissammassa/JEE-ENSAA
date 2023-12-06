package school;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Coordonnees {

    @Column(name = "adresse_Crd")
    private String adresse;

    @Column(name = "ville_Crd")
    private String ville;

    @Column(name = "email_Crd")
    private String email;

    @Column(name = "tel_Crd")
    private String tel;

    public Coordonnees() {
        // Default constructor
    }

    public Coordonnees(String adresse, String ville, String tel, String email) {
        this.adresse = adresse;
        this.ville = ville;
        this.tel = tel;
        this.email = email;
    }

    // Getters and setters
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
