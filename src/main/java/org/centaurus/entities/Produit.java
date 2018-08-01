package org.centaurus.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    @Column(name = "designation")
    private String designation;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @Column(name = "quantite")
    private int quantite;
    @Column(name = "prix")
    private double prix;

    @ManyToOne
    @JoinColumn(name="ID_CAT")
    private Categorie categorie;

    public Produit() {
    }

    public Produit(String designation, String description, String photo, int quantite, double prix) {
        this.designation = designation;
        this.description = description;
        this.photo = photo;
        this.quantite = quantite;
        this.prix = prix;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produit produit = (Produit) o;

        if (idProduit != produit.idProduit) return false;
        if (quantite != produit.quantite) return false;
        if (Double.compare(produit.prix, prix) != 0) return false;
        if (designation != null ? !designation.equals(produit.designation) : produit.designation != null) return false;
        if (description != null ? !description.equals(produit.description) : produit.description != null) return false;
        if (photo != null ? !photo.equals(produit.photo) : produit.photo != null) return false;
        return categorie != null ? categorie.equals(produit.categorie) : produit.categorie == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (idProduit ^ (idProduit >>> 32));
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + quantite;
        temp = Double.doubleToLongBits(prix);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (categorie != null ? categorie.hashCode() : 0);
        return result;
    }
}
