package school;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @Column(name = "Apogee_Etd")
    private int apogee;

    @Column(name = "Nom_Etd", length = 30)
    private String nom;

    @Column(name = "Nom_Prenom", length = 30)
    private String prenom;

    @Embedded
    private Coordonnees coordonnees;

    public Etudiant() {
        // Default constructor
    }

    public Etudiant(int apogee, String nom, String prenom, Coordonnees coordonnees) {
        this.apogee = apogee;
        this.nom = nom;
        this.prenom = prenom;
        this.coordonnees = coordonnees;
    }

    public int getApogee() {
        return apogee;
    }

    public void setApogee(int apogee) {
        this.apogee = apogee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Coordonnees getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Coordonnees coordonnees) {
        this.coordonnees = coordonnees;
    }
}
