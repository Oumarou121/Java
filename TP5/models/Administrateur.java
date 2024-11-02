package models;

public class Administrateur extends Personne {
    private Stock stock;

    public Administrateur(String cin, String nom, String prenom, Adresse adresse){
        super(cin, nom, prenom, adresse);
        this.stock = new Stock(); 
    }

    public Administrateur(Stock stock, String cin, String nom, String prenom, Adresse adresse){
        super(cin, nom, prenom, adresse);
        this.stock = stock;
    }

    public Stock getStock(){
        return stock;
    }

    public void setStock(Stock stock){
        this.stock = stock;
    }

    public void ajouterArcticle(String nom, double prix, double resolutionEcran, String processeur, long ram,
    SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, String alimentation, long quantite){
        OrdinateurDeBureau ordinateurDeBureau = new OrdinateurDeBureau(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, alimentation);
        stock.ajouterArcticle(ordinateurDeBureau, quantite);
    }

    public void ajouterArcticle(String nom, double prix, double resolutionEcran, String processeur, long ram,
    SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, long capaciteBatterie, long quantite){
        OrdinateurPortable ordinateurPortable = new OrdinateurPortable(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, capaciteBatterie);
        stock.ajouterArcticle(ordinateurPortable, quantite);
    }

    public void ajouterArcticle(String nom, double prix, double resolutionEcran, String processeur, long ram,
    SystemeExploitation systemeExploitation, double appareilPhotoArriere, 
    double appareilPhotoFrontal, int nbSim, long capaciteBatterie, long quantite){
        Mobile mobile = new Mobile(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, appareilPhotoArriere, appareilPhotoFrontal, nbSim, capaciteBatterie);
        stock.ajouterArcticle(mobile, quantite);
    }

    public void ajouterArcticle(String nom, double prix, int capacite, long quantite){
        ComposantStockage composantStockage = new ComposantStockage(nom, prix, capacite);
        stock.ajouterArcticle(composantStockage, quantite);
    }

    public void ajouterArcticle(String nom, double prix, String technologieDeConnexion, String interfaceAvecOrdinateur, long quantite){
        Peripheriques peripheriques = new Peripheriques(nom, prix, technologieDeConnexion, interfaceAvecOrdinateur);
        stock.ajouterArcticle(peripheriques, quantite);
    }

    public void modifierArticle(String reference, String nom, double prix, long quantite){
        stock.modifierArticle(reference, nom, prix, quantite);
    }

    public void supprimerArticle(String reference){
        stock.supprimerArticle(reference);
    }

    public void afficherStock(){
        System.out.println(stock.toString());
    }

    @Override
    public String toString(){
        return super.toString() + " Role : Administrateur \n" + "Voici le Stock : \n" + stock.toString();
    }

    public void incrementerQuantiteArticle(String reference, long quantite){
        stock.incrementerQuantiteArticle(reference, quantite);
    }

}
