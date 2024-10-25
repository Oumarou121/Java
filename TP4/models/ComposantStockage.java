package models;

public class ComposantStockage extends Article implements Garantissable {
    private int capacite;

    public ComposantStockage(String nom, double prix, int capacite){
        super(nom, prix);

        this.capacite = capacite;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString(){
        return super.toString() + " Capacite : " + this.capacite + " Garantie : " + garantirAppareil();
    }

    @Override
    public int garantirAppareil() {
        return (this.capacite <= 500) ? 1 : 2; 
    }
}
