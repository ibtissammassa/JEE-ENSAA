package school;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enseignant")
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Code_Ens")
    private int code;

    @Column(name = "Nom_Ens", length = 30)
    private String nom;

    @Column(name = "Prenom_Ens", length = 30)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "Code_Dep")
    private Departement departement;

    public Enseignant() {}


    public Enseignant(String nom, String prenom, Departement dep) {
        this.nom = nom;
        this.prenom = prenom;
        this.departement = dep;
    }
	public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    // Getters
    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    // Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom=prenom; }
}
