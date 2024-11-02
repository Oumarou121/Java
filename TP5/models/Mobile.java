package models;

public class Mobile extends AppareilInformatique {
    
    private double appareilPhotoArriere;
    private double appareilPhotoFrontal;
    private int nbSim;
    private long capaciteBatterie;

    public Mobile(String nom, double prix, double resolutionEcran, String processeur, long ram,
            SystemeExploitation systemeExploitation, double appareilPhotoArriere, 
            double appareilPhotoFrontal, int nbSim, long capaciteBatterie) {
        super(nom, prix, resolutionEcran, processeur, ram, systemeExploitation);
        this.appareilPhotoArriere = appareilPhotoArriere;
        this.appareilPhotoFrontal = appareilPhotoFrontal;
        this.nbSim = nbSim;
        this.capaciteBatterie = capaciteBatterie;
    }

    public double getAppareilPhotoArriere() {
        return appareilPhotoArriere;
    }

    public void setAppareilPhotoArriere(double appareilPhotoArriere) {
        this.appareilPhotoArriere = appareilPhotoArriere;
    }

    public double getAppareilPhotoFrontal() {
        return appareilPhotoFrontal;
    }

    public void setAppareilPhotoFrontal(double appareilPhotoFrontal) {
        this.appareilPhotoFrontal = appareilPhotoFrontal;
    }

    public int getNbSim() {
        return nbSim;
    }

    public void setNbSim(int nbSim) {
        this.nbSim = nbSim;
    }

    public long getCapaciteBatterie() {
        return capaciteBatterie;
    }

    public void setCapaciteBatterie(long capaciteBatterie) {
        this.capaciteBatterie = capaciteBatterie;
    }

    @Override
    public String toString(){
        return "AppareilPhotoArriere : " + this.appareilPhotoArriere + " AppareilPhotoFrontal : " + this.appareilPhotoFrontal +
        " NbSim : " + this.nbSim + " CapaciteBatterie : " + this.capaciteBatterie + " Garantie : " + garantirAppareil();
    }

    @Override
    public int garantirAppareil(){
        return (super.getPrix() > 1000) ? 2 : 1;
    }

}
