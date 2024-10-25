import java.util.ArrayList;
import java.util.Scanner;
import models.Stock;

public class Main{
    public static void main(String [] args){
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<String> noms = new ArrayList<String>();
            ArrayList<Double> prix = new ArrayList<Double>();
            ArrayList<Long> quantites = new ArrayList<Long>();

            noms.add("PC Portable Dell Vostro 3500");
            noms.add("Écouteur JBL T125BT");
            noms.add("Smartphone INFINIX Hot 10");
            noms.add("Micro Casque 588 Filaire");
            noms.add("Smartphone NOKIA C1");
            prix.add((double)1999);
            prix.add((double)129);
            prix.add((double)439);
            prix.add((double)9.900);
            prix.add((double)185);
            quantites.add((long)5);
            quantites.add((long)50);
            quantites.add((long)10);
            quantites.add((long)25);
            quantites.add((long)15);

            Stock stock  = new Stock(noms, prix, quantites);

            System.out.println("0 : Ajouter un article");
            System.out.println("1 : Augmenter la quantité d'un article");
            System.out.println("2 : Modifier un article");
            System.out.println("3 : Supprimer un article");
            System.out.println("4 : Consulter le stock");
            System.out.println("5 : Quitter");
            
            while(true){
                System.out.print("Donner votre choix : ");
                int choix_gerant = scanner.nextInt();
                scanner.nextLine();
                switch(choix_gerant){
                    case 0:
                        System.out.print("Donner le nom de l'article a ajouter : ");
                        String nom_article = scanner.nextLine();
                        System.out.print("Donner le prix de l'article a ajouter : ");
                        double prix_article = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Donner la quantjté de l'article a ajouter : ");
                        long quantite_article = scanner.nextLong();
                        scanner.nextLine();
                        stock.ajouterArcticle(nom_article, prix_article, quantite_article);
                        System.out.println("L'article a été bien ajouter!!!");
                        break;
                    case 1:
                        System.out.print("Donner la reference de l'article a modifier : ");
                        String reference_article = scanner.nextLine();
                        System.out.print("Donner la quantité a augmente à l'article : ");
                        long upQuantite = scanner.nextLong();
                        stock.incrementerQuantiteArticle(reference_article, upQuantite);
                        System.out.println("La quantité de l'atrticle a été augmenter!!!");                    
                        break;
                    case 2:
                        System.out.print("Donner la reference de l'article a modifier : ");
                        String reference_articleM = scanner.nextLine();
                        System.out.print("Donner le nouveau nom de l'article a modifier : ");
                        String nom_articleM = scanner.nextLine();
                        System.out.print("Donner le nouveau prix de l'article a modifier : ");
                        double prix_articleM = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Donner la nouvelle quatité de l'article a modifier : ");
                        long quantite_articleM = scanner.nextLong();
                        scanner.nextLine();
                        stock.modifierArticle(reference_articleM, nom_articleM, prix_articleM, quantite_articleM);
                        System.out.println("L'article a été bien modifier!!!");                    
                        break;
                    case 3:
                        System.out.print("Donner la reference de l'article a supprimer : ");
                        String reference_supprimer = scanner.nextLine();
                        stock.supprimerArticle(reference_supprimer);
                        System.out.println("L'article a été bien supprimer!!!");
                        break;
                    case 4:
                        System.out.println("La liste des articles : ");
                        System.out.print(stock.toString());;
                        break;
                    case 5:
                        break;
                }
                if (choix_gerant == 5) {
                    break;
                }
                // scanner.close();
            }
        }    
        
    }
}