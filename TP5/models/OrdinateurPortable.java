package models;

public class OrdinateurPortable extends Ordinateur {

    private long capaciteBatterie;
    
    public OrdinateurPortable(String nom, double prix, double resolutionEcran, String processeur, long ram,
            SystemeExploitation systemeExploitation, long disqueDur, String carteGraphique, long capaciteBatterie) {
        super(nom, prix, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique);
        
        this.capaciteBatterie = capaciteBatterie;
        
    }

    public long getCapaciteBatterie() {
        return capaciteBatterie;
    }

    public void setCapaciteBatterie(long capaciteBatterie) {
        this.capaciteBatterie = capaciteBatterie;
    }

    @Override
    public String toString(){
        return super.toString() + " CapaciteBatterie : " + this.capaciteBatterie + " Garantie : " + garantirAppareil();
    }

    @Override
    public int garantirAppareil() {
        return 2;
    }
}
