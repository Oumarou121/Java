public class Salle{
    private int nbrPlaces;
    private int num;
    private float surface;
    private String departement;
    private boolean connected;
    private static int nbSalle = 101;

    public Salle(int nbrPlaces, float surface, String departement, boolean connected) {
        this.nbrPlaces = nbrPlaces;
        setNum();
        this.surface = surface;
        this.departement = departement;
        this.connected = connected;
    }

    public float getSurface() {
        return this.surface;
    }

    public boolean isConnected() {
        return this.connected;
    }

    @Override
    public String toString(){
        return "Salle n°" + this.num + ", de surface " + this.surface + " m², dans le département de " + this.departement + (this.connected? ", connectée" : ", non connectée") + ", avec " + this.nbrPlaces + " nombres de places "; 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Salle other = (Salle) obj;
        if (nbrPlaces != other.nbrPlaces)
            return false;
        if (num != other.num)
            return false;
        if (Float.floatToIntBits(surface) != Float.floatToIntBits(other.surface))
            return false;
        if (departement == null) {
            if (other.departement != null)
                return false;
        } else if (!departement.equals(other.departement))
            return false;
        if (connected != other.connected)
            return false;
        return true;
    }

    public static int getNbSales() {
        return nbSalle - 101;
    }

    public void setNum(){
        this.num = nbSalle++;
    }

    public int getNum(){
        return this.num;
    }

    public String getDepartement(){
        return this.departement;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }

    public static int getNbSalle() {
        return nbSalle;
    }    

    
}