public class ResultSalle {
    private int nbrPlaces;
    private float surface;
    private String departement;
    private boolean connected;

    public ResultSalle(int nbrPlaces, float surface, String departement, boolean connected) {
        this.nbrPlaces = nbrPlaces;
        this.surface = surface;
        this.departement = departement;
        this.connected = connected;
    }

    public int getNbrPlaces() {
        return nbrPlaces;
    }


    public float getSurface() {
        return surface;
    }


    public String getDepartement() {
        return departement;
    }


    public boolean isConnected() {
        return connected;
    }
    
} 