public class Bureau extends Salle{
    private String[] enseignants;
    private int taille;

    public Bureau(int nbrPlaces, float surface, String departement, boolean connected) {
        super(nbrPlaces, surface, departement, connected);
        this.enseignants = new String[nbrPlaces];
        this.taille = 0;
    }

    public String[] getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(String[] enseignants) {
        this.enseignants = enseignants;
    }

    private String nomEns(){
        String result = "";
        for (int i = 0; i < taille; i++) {
            result += enseignants[i];
        }

        return result;
    }

    @Override
    public String toString() {
        return "Bureau Salle n° " + getNum() + " de surface " + getSurface() + " m², dans le département de " + getDepartement() + (isConnected() ? ", connectée" : ", non connectée") + ", avec " + getNbrPlaces() + " nombres de places " + "les noms des enseignants " + nomEns(); 
    }    

    public void ajoutEnseignant(String nomEns){
        if (taille < getNbrPlaces()) {
            enseignants[taille] = nomEns;
            taille++;
        } else {
            System.out.println("Le nombre d'enseignants de cet bureau est atteint");
        }
    }

}