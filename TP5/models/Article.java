package models;

public class Article{
    private static int compteur = 1;
    private int id = 0;
    private String reference;
    private String nom;
    private double prix;

    public Article(String nom, double prix){
        this.id= compteur++;
        this.nom = nom;
        this.prix = prix;
        setReference(genererReference(nom, this.id));
    }

    public int getId(){
        return this.id;
    }

    public String getReference(){
        return this.reference;
    }

    public String getNom(){
        return this.nom;
    }

    public double getPrix(){
        return this.prix;
    }

    public void setReference(String ref){
        this.reference = ref;
    }

    public void setNom(String nom){
        this.nom = nom;
        setReference(genererReference(nom, this.id));
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public void modifier(String nom){
        setNom(nom);

        //update reference
        // setReference(genererReference(nom, this.id));
    }

    public void modifier(String nom, double prix){
        setNom(nom);
        setPrix(prix);

        // update reference
        // setReference(genererReference(nom, getId()));
    }

    public static String genererReference(String nom, int id){
        String ref = "";
        nom = nom.trim();
        for(int i = 0; i < nom.length(); i++){
            if(i % 5 == 0 && nom.charAt(i) != ' '){
                ref = ref + nom.charAt(i);
            }
        }
        ref = ref + id;
        return ref;
    }

    @Override
    public String toString(){
        return "ID : " + this.id + " Reference : " + this.reference + " Nom : " + this.nom + " Prix : " + this.prix + " TND"; 
    }

}