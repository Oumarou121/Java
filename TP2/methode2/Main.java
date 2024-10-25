import java.util.Scanner;
import models.Personne;
import models.Adresse;

public class Main{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adresse A1");
        System.out.print("codePostal : ");
        int codePostal1  = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Gouvernorat : ");
        String gouvernorat1  = scanner.nextLine();
        Adresse a1 = new Adresse(gouvernorat1, codePostal1);
        System.out.println(a1.toString());

        System.out.println("Adresse A2");
        System.out.print("codePostal : ");
        int codePostal2  = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Gouvernorat : ");
        String gouvernorat2  = scanner.nextLine();
        Adresse a2 = new Adresse(gouvernorat2, codePostal2);
        System.out.println(a2.toString());

        System.out.println("Personne P1");
        System.out.print("cin : ");
        String cin1  = scanner.nextLine();
        System.out.print("nom : ");
        String nom1  = scanner.nextLine();
        System.out.print("prenom : ");
        String prenom1  = scanner.nextLine();
        Personne p1 = new Personne(cin1, nom1, prenom1, a1);
        System.out.println(p1.toString());

        System.out.println("Personne P2");
        System.out.print("cin : ");
        String cin2  = scanner.nextLine();
        System.out.print("nom : ");
        String nom2  = scanner.nextLine();
        System.out.print("prenom : ");
        String prenom2  = scanner.nextLine();
        Personne p2 = new Personne(cin2, nom2, prenom2, a2);
        System.out.println(p2.toString());

    }
}