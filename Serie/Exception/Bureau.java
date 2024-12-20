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
            result += ("Mr " + enseignants[i] + "\n");
        }

        return result;
    }

    @Override
    public String toString() {
        return "Bureau Salle n° " + getNum() + " de surface " + getSurface() + " m², dans le département de " + getDepartement() + (isConnected() ? ", connectée" : ", non connectée") + ", avec " + getNbrPlaces() + " nombres de places " + "les noms des enseignants :\n " + nomEns(); 
    }    

    public void ajoutEnseignant(String nomEns) throws SalleException{
        if (taille < 5) {
            try {
                enseignants[taille] = nomEns;
                taille++;
            } catch (Exception e) {
                System.out.println("Le bureau numéro : " + getNum() + " est plein.\n" + "Il est occupé par " + taille + " enseignants\n" + nomEns());
            }
        } else {
            throw new SalleException("Le bureau est plein.");
        }
    }

    @Override
    public int compareTo(Salle arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}