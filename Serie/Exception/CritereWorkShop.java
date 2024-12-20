public class CritereWorkShop implements CritereReservation {
    private int nbPC;

    public CritereWorkShop(int nbPC){
        this.nbPC = nbPC;
    }

    public int getNbPC() {
        return nbPC;
    }

    public void setNbPC(int nbPC) {
        this.nbPC = nbPC;
    }

    @Override
    public boolean peutEtreReserve(Salle s) {
        if (s instanceof Labo) {
            Labo labo = (Labo)s;
            return labo.isConnected() && labo.getNbPC() >= nbPC;
        }
        return false;
    }

}
