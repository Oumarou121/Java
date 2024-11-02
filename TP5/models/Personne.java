package models;

public abstract class Personne{
    private String cin;
    private String nom;
    private String prenom;
    private Adresse adresse;

    public Personne(String cin, String nom, String prenom, Adresse adresse){
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getCin(){
        return this.cin;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public Adresse getAdresse(){
        return this.adresse;
    }

    public void setCin(String cin){
        this.cin = cin;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setAdresse(Adresse adresse){
        this.adresse = adresse;
    }

    @Override
    public String toString(){
        return "cin = " + cin + " nom = " + nom + " prenom = " + prenom + adresse.toString();
    }

}