package models;

public abstract class Ordinateur extends AppareilInformatique {
    private long disqueDur;
    private String carteGraphique;

    public Ordinateur(String nom, double prix, double resolutionEcran, String processeur, long ram,
            SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique) {
        super(nom, prix, resolutionEcran, processeur, ram, systemeExploitation);
        this.disqueDur = disqueDur;
        this.carteGraphique = carteGraphique;
    }

    public long getDisqueDur() {
        return disqueDur;
    }

    public void setDisqueDur(long disqueDur) {
        this.disqueDur = disqueDur;
    }

    public String getCarteGraphique() {
        return carteGraphique;
    }

    public void setCarteGraphique(String carteGraphique) {
        this.carteGraphique = carteGraphique;
    }    

    @Override
    public String toString(){
        return "DisqueDur : " + this.disqueDur + " CarteGraphique : " + this.carteGraphique;
    }
    
}
