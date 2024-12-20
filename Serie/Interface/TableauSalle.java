import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TableauSalle {

    private Salle[] salles = new Salle[100];
    private int taille;
    
    public TableauSalle(){
        taille = 0;
    }

    public TableauSalle(Salle[] dSalles, int nSalle) {
        this.salles = dSalles;
        this.taille = nSalle;
    }

    public void ajoutLabo(Labo ajoutLabo){
        if (taille < 100) {
            salles[taille] = new Labo(ajoutLabo.getNbrPlaces(), ajoutLabo.getSurface(), ajoutLabo.getDepartement(), ajoutLabo.isConnected(), ajoutLabo.getNbPC());
            taille++;
        } else {
            System.out.println("Le tableau de salles est rempli.");
        }
    }

    public void ajoutBureau(Bureau ajoutBureau){
        if (taille < 100) {
            salles[taille] = new Bureau(ajoutBureau.getNbrPlaces(), ajoutBureau.getSurface(), ajoutBureau.getDepartement(), ajoutBureau.isConnected());
            taille++;
        } else {
            System.out.println("Le tableau de salles est rempli.");
        }
    }

    public void ajoutSalleCours(SalleCours ajoutSalleCours) {
        if (taille < 100) {
            salles[taille] = new SalleCours(ajoutSalleCours.getNbrPlaces(), ajoutSalleCours.getSurface(), ajoutSalleCours.getDepartement(), ajoutSalleCours.isConnected(), ajoutSalleCours.isVideoProj());
            taille++;
        } else {
            System.out.println("Le tableau de salle est rempli.");
        }
    }

    public float getSurfaceSalle(){
        float result = 0;

        for(int i = 0; i < taille; i++){
            result += salles[i].getSurface();
        }

        return result;
    }

    @Override
    public String toString(){
        String result = "";

        for(int i = 0; i < taille; i++){
            result += salles[i].toString() + "\n";
        }

        return result;
    }
    
    public String getDepartementBySalle(int num){
        for (int i = 0; i < taille; i++) {
            if(salles[i].getNum() == num){
                return salles[i].getDepartement();
            }
        }
        return "Salle non trouvée";
    }

    public ArrayList<Salle> getListSallesConnected(){
        ArrayList<Salle> list = new ArrayList<Salle>();

        for (int i = 0; i < taille; i++) {
            if(salles[i].isConnected()){
                list.add(salles[i]);
            }
        }

        return list;
    }

    public ArrayList<Salle> getListeSalleByNameDepartement(String Departement){
        ArrayList<Salle> list = new ArrayList<Salle>();

        for (int i = 0; i < taille; i++) {
            if(salles[i].getDepartement().equals(Departement)){
                list.add(salles[i]);
            }
        }

        return list;
    }

    public ArrayList<Salle> getListeSalleTrieNombrePlace() {
        return new ArrayList<>(
            Arrays.stream(salles)
                  .filter(salle -> salle != null) // Filtrer les éléments non nuls
                  .sorted(Comparator.comparingInt(Salle::getNbrPlaces))
                  .toList() // Retourne une liste immuable
        );
    }
    
    public ArrayList<Salle> getListeSalleTrieSurface() {
        return new ArrayList<>(
            Arrays.stream(salles)
                  .filter(salle -> salle != null) // Filtrer les éléments non nuls
                  .sorted(Comparator.comparing(Salle::getSurface))
                  .toList()
        );
    }
    
    public ArrayList<Salle> getListeSallesTrieByDepartement() {
        return new ArrayList<>(
            Arrays.stream(salles)
                  .filter(salle -> salle != null) // Filtrer les éléments non nuls
                  .sorted(Comparator.comparing(Salle::getDepartement))
                  .toList()
        );
    }
    

    public float pourcentageProjecteurSalleCours() {
        ArrayList<SalleCours> list = new ArrayList<>();
    
        // Recherche de toutes les SalleCours
        for (int i = 0; i < taille; i++) {
            if (salles[i] instanceof SalleCours) {
                list.add((SalleCours) salles[i]);
            }
        }
    
        int total = list.size();
        int isVideoProj = 0;

        if (total == 0) {
            System.out.println("Aucune salle de cours trouvée.");
            return 0.0f; // Évitez la division par zéro
        }
        
    
        for (SalleCours c : list) {
            if (c.isVideoProj()) {
                isVideoProj++;
            }
        }
    
        System.out.println("Total des salles de cours : " + total);
        System.out.println("Salles avec vidéoprojecteur : " + isVideoProj);
    
        // Correction du calcul du pourcentage
        float pourc = ((float) isVideoProj / total) * 100;
    
        return pourc;
    }
    
}

