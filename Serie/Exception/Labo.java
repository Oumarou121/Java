// public class Labo extends Salle {

// }
//Elle provoque un erreur car la classe salle attends ses attribusb


public class Labo extends Salle {
    private int nbPC;

    public Labo(int nbrPlaces, float surface, String departement, boolean connected, int nbPC) {
        super(nbrPlaces, surface, departement, connected);
        this.nbPC = nbPC;
    }

    public int getNbPC() {
        return nbPC;
    }

    public void setNbPC(int nbPC) {
        this.nbPC = nbPC;
    }

    @Override
    public String toString() {
        return "Labo Salle n° " + getNum() + " de surface " + getSurface() + " m², dans le département de " + getDepartement() + (isConnected() ? ", connectée" : ", non connectée") + ", avec " + getNbrPlaces() + " nombres de places " + " de nombre de PC " + nbPC; 
    }

    @Override
    public int compareTo(Salle arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }   

}