package org.centaurus.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
@Entity

@Table(name ="categorie")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name="nom_cat")
    private String nom_cat;
    @Column(name="description")
    private String description;
    @Column(name="Nomphoto")
    private String Nomphoto;


    @OneToMany(mappedBy ="categorie")
    private Collection<Produit> produits = new ArrayList<>();

    public Categorie() {
    }

    public Categorie(String nom_cat, String description, String nomphoto) {
        this.nom_cat = nom_cat;
        this.description = description;
        this.Nomphoto = nomphoto;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomphoto() {
        return Nomphoto;
    }

    public void setNomphoto(String nomphoto) {
        Nomphoto = nomphoto;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categorie that = (Categorie) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nom_cat != null ? !nom_cat.equals(that.nom_cat) : that.nom_cat != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (Nomphoto != null ? !Nomphoto.equals(that.Nomphoto) : that.Nomphoto != null) return false;
        return  (produits != null ? produits.equals(that.produits) : that.produits == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nom_cat != null ? nom_cat.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (Nomphoto != null ? Nomphoto.hashCode() : 0);

        result = 31 * result + (produits != null ? produits.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ICategorieDao{" +
                "id=" + id +
                ", nom_cat='" + nom_cat + '\'' +
                ", description='" + description + '\'' +
                ", Nomphoto='" + Nomphoto + '\'' +
                '}';
    }
}
