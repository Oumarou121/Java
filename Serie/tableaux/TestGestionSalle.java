import java.util.ArrayList;
import java.util.Scanner;

public class TestGestionSalle {
    public static void main(String[] args) {
        TableauSalle lesSalle = new TableauSalle();
        Scanner scanner = new Scanner(System.in);

        // Salle s1 = new Salle(30, (float)6.8, "Gestion", true);
        // Salle s2 = new Salle(20, (float)16.8, "Mécanique", true);
        // Salle s3 = new Salle(18, (float)20.8, "Informatique", false);

        // lesSalle.insert(s1);
        // lesSalle.insert(s2);
        // lesSalle.insert(s3);

        // System.out.println("La description du TableauSalle : \n " + lesSalle.decrire());
        // System.out.println("La surface total : " + lesSalle.getSurfaceSalle() + " m²");

        while(true){
            // System.out.println("\033[H\033[2J");
            // System.out.flush();
            System.out.println("Bienvenue dans la gestion des salles!");
            System.out.println( "********************************************************************* \n");
            System.out.println( "                                  MENU                                \n");
            System.out.println("1 : Ajouter une Salle");
            System.out.println("2 : Afficher la liste de salles");
            System.out.println("3 : Afficher le département a partir du numéro de la salle donnée");
            System.out.println("4 : Afficher la surface de toutes les salles");
            System.out.println("5 : Afficher la liste de salle connectés");
            System.out.println("6 : Afficher la liste de salles d'un département donné");
            System.out.println("7 : Afficher la liste de salles trie selon le nombre de places");
            System.out.println("8 : Afficher la liste de salles trie selon la surface");
            System.out.println("9 : Afficher la liste de salle par ordre de département");
            System.out.println("10 : Quitter");
            System.out.println( "********************************************************************* \n");

            System.out.print( "Donner votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Entrer les informations de la nouvelle salle");
                    System.out.print("Surface : ");
                    float surface = scanner.nextFloat();
                    System.out.print("Département : ");
                    String departement = scanner.next();
                    System.out.print("Nombre de places : ");
                    int nbrPlaces = scanner.nextInt();
                    System.out.print("Est-ce connectée? (true/false) : ");
                    boolean connected = scanner.nextBoolean();
                    Salle salle = new Salle(nbrPlaces, surface, departement, connected);
                    lesSalle.insert(salle);
                    System.out.println("Salle bien ajouter!!!");
                    break;
                
                case 2:
                    System.out.println("La liste des salles :\n" + lesSalle.decrire());
                    break;
            
                case 3:
                    System.out.println("");
                    System.out.print("Donner le numéro de la salle : ");
                    int num = scanner.nextInt();
                    System.out.println("Le departement est " + lesSalle.getDepartementBySalle(num));
                    break;

                case 4:
                    System.out.println("La surface total : " + lesSalle.getSurfaceSalle() + " m²");
                    break;

                case 5:
                    ArrayList<Salle> Clist = new ArrayList<Salle>();
                    Clist.addAll(lesSalle.getListSallesConnected());
                    System.out.println("Voici la liste des salles connectes :\n");
                    for (Salle current : Clist) {
                        System.out.println(current.decrire());
                    }
                    break;
                
                    case 6:
                    ArrayList<Salle> Dlist = new ArrayList<Salle>();
                    System.out.print("Donner le nom du departement : ");
                    String dep = scanner.nextLine();
                    Dlist.addAll(lesSalle.getListeSalleByNameDepartement(dep));
                    System.out.println("Voici la liste des salles du departement :\n");
                    for (Salle current : Dlist) {
                        System.out.println(current.decrire());
                    }
                    break;

                    case 7:
                    ArrayList<Salle> Plist = new ArrayList<Salle>();
                    Plist.addAll(lesSalle.getListeSalleTrieNombrePlace());
                    System.out.println("Voici la liste des salles trie par nombre de place :\n");
                    for (Salle current : Plist) {
                        System.out.println(current.decrire());
                    }
                    break;

                    case 8:
                    ArrayList<Salle> Slist = new ArrayList<Salle>();
                    Slist.addAll(lesSalle.getListeSalleTrieSurface());
                    System.out.println("Voici la liste des salles trie par surface :\n");
                    for (Salle current : Slist) {
                        System.out.println(current.decrire());
                    }
                    break;

                    case 9:
                    ArrayList<Salle> DDlist = new ArrayList<Salle>();
                    DDlist.addAll(lesSalle.getListeSallesTrieByDepartement());
                    System.out.println("Voici la liste des salles trie par departement :\n");
                    for (Salle current : DDlist) {
                        System.out.println(current.decrire());
                    }
                    break;

                    case 10:
                        System.out.println("Au revoir");
                        return;

                    default:
                        System.out.println("Commande incorrect, réessayer!!!");
                        break;
            }
        }

    }    
}
