public class SalleCours extends Salle {
    private boolean videoProj;

    public SalleCours(int nbrPlaces, float surface, String departement, boolean connected, boolean videoProj) {
        super(nbrPlaces, surface, departement, connected);
        this.videoProj = videoProj;
    }

    public boolean isVideoProj() {
        return videoProj;
    }

    public void setVideoProj(boolean videoProj) {
        this.videoProj = videoProj;
    }
    
    @Override
    public String toString() {
        return "Salle de Cours Salle n° " + getNum() + " de surface " + getSurface() + " m², dans le département de " + getDepartement() + (isConnected() ? ", connectée" : ", non connectée") + ", avec " + getNbrPlaces() + " nombres de places " + " vidéo projecteur " + (this.videoProj ? "oui" : "non"); 
    }

    @Override
    public int compareTo(Salle arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}
