import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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

    public ArrayList<Salle> getListeSalleTrieNombrePlace(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(salles));
        list.removeIf(Objects::isNull);
        list.sort(Comparator.comparingInt(Salle::getNbrPlaces));
        return list;
    }

    public ArrayList<Salle> getListeSalleTrieSurface(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(salles));
        list.removeIf(Objects::isNull);
        list.sort(Comparator.comparing(Salle::getSurface));
        return list;
    }

    public ArrayList<Salle> getListeSallesTrieByDepartement(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(salles));
        list.removeIf(Objects::isNull);
        list.sort(Comparator.comparing(Salle::getDepartement));
        return list;
    }

    public float pourcentageProjecteurSalleCours(){
        ArrayList<SalleCours> list = new ArrayList<SalleCours>();

        //Recherche de tout les salleCours
        for(int i = 0; i < taille; i++){
            if(salles[i] instanceof SalleCours){
                list.add((SalleCours) salles[i]);
            }
        }

        int total = list.size();
        int isVideoProj = 0;

        for(SalleCours c : list){
            if (c.isVideoProj()) {
                isVideoProj++;
            }
        }

        System.out.println(total);
        System.out.println(isVideoProj);

        float pourc = (isVideoProj / total) * 100;

        return pourc;
    }
}

