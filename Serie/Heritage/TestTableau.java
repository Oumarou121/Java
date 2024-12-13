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
            System.out.println("5 : Afficher la surface de toutes les salles");
            System.out.println("6 : Quitter");
            System.out.println( "********************************************************************* \n");

            System.out.print( "Donner votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    Salle salle1 = ajoutSalle(scanner);
                    System.out.print("Nombre de PC : ");
                    int nbrPC = scanner.nextInt();
                    Labo labo = new Labo(salle1.getNbrPlaces(), salle1.getSurface(), salle1.getDepartement(), salle1.isConnected(), nbrPC);
                    tableauSalle.ajoutLabo(labo);
                    System.out.println("Labo bien ajouter!!!");
                    break;

                case 2:
                    Salle salle2 = ajoutSalle(scanner);
                    Bureau bureau = new Bureau(salle2.getNbrPlaces(), salle2.getSurface(), salle2.getDepartement(), salle2.isConnected());
                    tableauSalle.ajoutBureau(bureau);
                    System.out.println("Bureau bien ajouter!!!");
                    ajouterEnseignant(scanner, bureau);
                    break;

                case 3:
                    Salle salle3 = ajoutSalle(scanner);
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
                    System.out.println("La surface total : " + tableauSalle.getSurfaceSalle() + " m²");
                    break;

                case 6:
                    System.out.println("Au revoir");
                    return;

                default:
                    System.out.println("Commande incorrect, réessayer!!!");
                    break;
            }
        }
    }

    public static Salle ajoutSalle(Scanner scanner){
        System.out.println("Entrer les informations du nouveau Labo");
        System.out.print("Surface : ");
        float surface = scanner.nextFloat();
        System.out.print("Département : ");
        String departement = scanner.next();
        System.out.print("Nombre de places : ");
        int nbrPlaces = scanner.nextInt();
        System.out.print("Est-ce connectée? (true/false) : ");
        boolean connected = scanner.nextBoolean();
        Salle salle = new Salle(nbrPlaces, surface, departement, connected);
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
