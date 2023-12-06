package school;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "matiere")
public class Matiere {
    @Id
    @Column(name = "Code_Mat", length = 6)
    private String code;

    @Column(name = "Libelle_Mat", length = 100)
    private String libelle;

    @ManyToMany
    private Set<Enseignant> enseignants = new HashSet<>();

    // Default constructor (required by JPA)
    public Matiere() {
    }

    // Constructor with parameters
    public Matiere(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    // Getters and setters...

    public Set<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(Set<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    public void ajouterEnseigant(Enseignant ens) {
        this.enseignants.add(ens);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;}
}
