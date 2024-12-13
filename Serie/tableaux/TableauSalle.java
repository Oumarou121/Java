import java.util.*;

public class TableauSalle {
    private Salle[] lesSalles;
    private int nbSalles;

    public TableauSalle(int taille) {
        this.lesSalles = new Salle[taille];
        nbSalles = 0;
    }

    public TableauSalle(){
        this.lesSalles = new Salle[100];
        nbSalles = 0;
    }

    public void insert(Salle salle) {
        if (nbSalles < lesSalles.length) {
            lesSalles[nbSalles] = salle;
            nbSalles++;
        } else {
            System.out.println("Le tableau est plein. Impossible d'ajouter une nouvelle salle.");
        }
    }

    public String decrire(){
        String result = "";

        for (int i = 0; i < nbSalles; i++) {
            result += lesSalles[i].decrire();
        }

        return result;
    }

    public float getSurfaceSalle(){
        float result = 0;

        for (int i = 0; i < nbSalles; i++) {
            result += lesSalles[i].getSurface();
        }

        return result;
    }
    
    public String getDepartementBySalle(int num){
        for (int i = 0; i < nbSalles; i++) {
            if(lesSalles[i].getNum() == num){
                return lesSalles[i].getDepartement();
            }
        }
        return "Salle non trouvée";
    }

    public ArrayList<Salle> getListSallesConnected(){
        ArrayList<Salle> list = new ArrayList<Salle>();

        for (int i = 0; i < nbSalles; i++) {
            if(lesSalles[i].isConnected()){
                list.add(lesSalles[i]);
            }
        }

        return list;
    }

    public ArrayList<Salle> getListeSalleByNameDepartement(String Departement){
        ArrayList<Salle> list = new ArrayList<Salle>();

        for (int i = 0; i < nbSalles; i++) {
            if(lesSalles[i].getDepartement().equals(Departement)){
                list.add(lesSalles[i]);
            }
        }

        return list;
    }

    public ArrayList<Salle> getListeSalleTrieNombrePlace(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(lesSalles));
        list.sort(Comparator.comparingInt(Salle::getNbrPlaces));
        return list;
    }

    public ArrayList<Salle> getListeSalleTrieSurface(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(lesSalles));
        list.sort(Comparator.comparing(Salle::getSurface));
        return list;
    }

    public ArrayList<Salle> getListeSallesTrieByDepartement(){
        ArrayList<Salle> list = new ArrayList<Salle>();
        list.addAll(Arrays.asList(lesSalles));
        list.sort(Comparator.comparing(Salle::getDepartement));
        return list;
    }
}
