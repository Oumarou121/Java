import java.util.ArrayList;
import java.util.Scanner;

public class TestTrie {
    @SuppressWarnings("resource")
    public static void listeSalleTrieNombrePlace(TableauSalle tableauSalle) {
        ArrayList<Salle> Plist = tableauSalle.getListeSalleTrieNombrePlace();
        System.out.println("Voici la liste des salles triées par nombre de places :\n");
        for (Salle current : Plist) {
            System.out.println(current);
        }
        System.out.print("Appuyez sur Entrée pour continuer...");
        new Scanner(System.in).nextLine(); // Pause
    }

    @SuppressWarnings("resource")
    public static void listeSalleTrieNombreSurface(TableauSalle tableauSalle) {
        ArrayList<Salle> Slist = tableauSalle.getListeSalleTrieSurface();
        System.out.println("Voici la liste des salles triées par surface :\n");
        for (Salle current : Slist) {
            System.out.println(current);
        }
        System.out.print("Appuyez sur Entrée pour continuer...");
        new Scanner(System.in).nextLine(); // Pause
    }

    @SuppressWarnings("resource")
    public static void listeSalleTrieNombreDepartement(TableauSalle tableauSalle) {
        ArrayList<Salle> DDlist = tableauSalle.getListeSallesTrieByDepartement();
        System.out.println("Voici la liste des salles triées par département :\n");
        for (Salle current : DDlist) {
            System.out.println(current);
        }
        System.out.print("Appuyez sur Entrée pour continuer...");
        new Scanner(System.in).nextLine(); // Pause
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TableauSalle tableauSalle = new TableauSalle();
        // Ajout des salles
        tableauSalle.ajoutLabo(new Labo(15, 100, "Chimie", false, 15));
        tableauSalle.ajoutLabo(new Labo(20, 100, "Physique", false, 19));
        tableauSalle.ajoutLabo(new Labo(10, 100, "Electronique", true, 12));
        tableauSalle.ajoutBureau(new Bureau(40, 400, "Doctorat", true));
        tableauSalle.ajoutBureau(new Bureau(50, 500, "Administration", true));
        tableauSalle.ajoutBureau(new Bureau(30, 300, "Surveillance", true));
        tableauSalle.ajoutSalleCours(new SalleCours(100, 1000, "Informatique", true, true));
        tableauSalle.ajoutSalleCours(new SalleCours(140, 1000, "Chimie", true, true));
        tableauSalle.ajoutSalleCours(new SalleCours(125, 1000, "Physique", true, true));

        while (true) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("\n*********************************************************************");
            System.out.println("                   Bienvenue dans le tri des salles !");
            System.out.println("1 : Afficher la liste de salles triée selon le nombre de places");
            System.out.println("2 : Afficher la liste de salles triée selon la surface");
            System.out.println("3 : Afficher la liste de salles triée par département");
            System.out.println("4 : Quitter");
            System.out.println("*********************************************************************\n");

            System.out.print("Donner votre choix : ");
            String input = scanner.nextLine();

            try {
                int choix = Integer.parseInt(input);
                switch (choix) {
                    case 1:
                        listeSalleTrieNombrePlace(tableauSalle);
                        break;
                    case 2:
                        listeSalleTrieNombreSurface(tableauSalle);
                        break;
                    case 3:
                        listeSalleTrieNombreDepartement(tableauSalle);
                        break;
                    case 4:
                        System.out.println("Merci d'avoir utilisé notre application!");
                        System.exit(0);
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrée non valide. Veuillez entrer un numéro.");
            }
        }
    }
}
