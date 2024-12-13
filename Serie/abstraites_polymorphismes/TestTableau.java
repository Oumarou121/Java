import java.util.ArrayList;
import java.util.Scanner;

public class TestTableau {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TableauSalle tableauSalle = new TableauSalle();
        System.out.println("\033[H\033[2J");
        System.out.flush();

        while(true){
            System.out.println("");
            System.out.println( "********************************************************************* \n");
            System.out.println( "                   Bienvenue dans la gestion des salles!             \n");
            System.out.println("1 : Ajouter une Labo");
            System.out.println("2 : Ajouter Bureau");
            System.out.println("3 : Ajouter Salle cours");
            System.out.println("4 : Afficher la liste de salles");
            System.out.println("5 : Afficher le département a partir du numéro de la salle donnée");
            System.out.println("6 : Afficher la surface de toutes les salles");
            System.out.println("7 : Afficher la liste de salle connectés");
            System.out.println("8 : Afficher la liste de salles d'un département donné");
            System.out.println("9 : Afficher la liste de salles trie selon le nombre de places");
            System.out.println("10 : Afficher la liste de salles trie selon la surface");
            System.out.println("11 : Afficher la liste de salle par ordre de département");
            System.out.println("12 : Pourcentage des salles de cours avec Projecteur");
            System.out.println("13 : Quitter");
            System.out.println( "********************************************************************* \n");

            System.out.print( "Donner votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    ResultSalle salle1 = ajoutSalle(scanner);
                    System.out.print("Nombre de PC : ");
                    int nbrPC = scanner.nextInt();
                    Labo labo = new Labo(salle1.getNbrPlaces(), salle1.getSurface(), salle1.getDepartement(), salle1.isConnected(), nbrPC);
                    tableauSalle.ajoutLabo(labo);
                    System.out.println("Labo bien ajouter!!!");
                    break;

                case 2:
                    ResultSalle salle2 = ajoutSalle(scanner);
                    Bureau bureau = new Bureau(salle2.getNbrPlaces(), salle2.getSurface(), salle2.getDepartement(), salle2.isConnected());
                    tableauSalle.ajoutBureau(bureau);
                    System.out.println("Bureau bien ajouter!!!");
                    ajouterEnseignant(scanner, bureau);
                    break;

                case 3:
                    ResultSalle salle3 = ajoutSalle(scanner);
                    System.out.print("Est-ce qu'il y'a un vidéo rojecteur ? (true/false) : ");
                    boolean videoProj = scanner.nextBoolean();
                    SalleCours salleCours = new SalleCours(salle3.getNbrPlaces(), salle3.getSurface(), salle3.getDepartement(), salle3.isConnected(), videoProj);
                    tableauSalle.ajoutSalleCours(salleCours);
                    System.out.println("Salle de cours bien ajouter!!!");
                    break;
                
                case 4:
                    System.out.println("La liste des salles :\n" + tableauSalle.toString());
                    break;

                case 5:
                    System.out.println("");
                    System.out.print("Donner le numéro de la salle : ");
                    int num = scanner.nextInt();
                    System.out.println("Le departement est " + tableauSalle.getDepartementBySalle(num));
                    break;

                case 6:
                    System.out.println("La surface total : " + tableauSalle.getSurfaceSalle() + " m²");
                    break;

                case 7:
                    ArrayList<Salle> Clist = new ArrayList<Salle>();
                    Clist.addAll(tableauSalle.getListSallesConnected());
                    System.out.println("Voici la liste des salles connectes :\n");
                    for (Salle current : Clist) {
                        System.out.println(current.toString());
                    }
                    break;

                case 8:
                    ArrayList<Salle> Dlist = new ArrayList<Salle>();
                    System.out.print("Donner le nom du departement : ");
                    String dep = scanner.next();
                    Dlist.addAll(tableauSalle.getListeSalleByNameDepartement(dep));
                    System.out.println("Voici la liste des salles du departement :\n");
                    for (Salle current : Dlist) {
                        System.out.println(current.toString());
                    }
                    break;

                case 9:
                    ArrayList<Salle> Plist = new ArrayList<Salle>();
                    Plist.addAll(tableauSalle.getListeSalleTrieNombrePlace());
                    System.out.println("Voici la liste des salles trie par nombre de place :\n");
                    for (Salle current : Plist) {
                        System.out.println(current.toString());
                    }
                    break;

                case 10:
                    ArrayList<Salle> Slist = new ArrayList<Salle>();
                    Slist.addAll(tableauSalle.getListeSalleTrieSurface());
                    System.out.println("Voici la liste des salles trie par surface :\n");
                    for (Salle current : Slist) {
                        System.out.println(current.toString());
                    }
                    break;

                case 11:
                    ArrayList<Salle> DDlist = new ArrayList<Salle>();
                    DDlist.addAll(tableauSalle.getListeSallesTrieByDepartement());
                    System.out.println("Voici la liste des salles trie par departement :\n");
                    for (Salle current : DDlist) {
                        System.out.println(current.toString());
                    }
                    break;

                case 12:
                    System.out.println(tableauSalle.pourcentageProjecteurSalleCours() + " % de salles de cours avec Video Projecteur");
                    break;

                case 13:
                    System.out.println("Au revoir");
                    return;

                default:
                    System.out.println("Commande incorrect, réessayer!!!");
                    break;
            }
        }
    }

    public static ResultSalle ajoutSalle(Scanner scanner){
        System.out.println("Entrer les informations du nouveau Labo");
        System.out.print("Surface : ");
        float surface = scanner.nextFloat();
        System.out.print("Département : ");
        String departement = scanner.next();
        System.out.print("Nombre de places : ");
        int nbrPlaces = scanner.nextInt();
        System.out.print("Est-ce connectée? (true/false) : ");
        boolean connected = scanner.nextBoolean();
        ResultSalle salle = new ResultSalle(nbrPlaces, surface, departement, connected);
        return salle;
    }

    public static void ajouterEnseignant(Scanner scanner, Bureau bureau){
        while (true) {
            System.out.println("");
            System.out.println( "********************************************************************* \n");
            System.out.println( "                   Bienvenue dans la gestion de Bureau!             \n");
            System.out.println("1 : Ajouter un enseignant");
            System.out.println("2 : Quitter");
            System.out.println( "********************************************************************* \n");

            System.out.print( "Donner votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.print("Entrer le nom du nouveau enseignant : ");
                    String nom = scanner.next();
                    bureau.ajoutEnseignant(nom);                                        
                    break;
            
                case 2:
                    System.out.println("Au revoir");
                    return;

                default:
                    System.out.println("Commande incorrect, réessayer!!!");
                    break;
            }
        }
    }
}
