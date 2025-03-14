import java.util.ArrayList;
import java.util.Scanner;

import models.Administrateur;
import models.Adresse;
import models.Client;
import models.Stock;
import models.SystemeExploitation;

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

            int choixUtilisateur;
            System.out.println("Soyez les bienvenus !!");

            do{
                System.out.println("0 : Gérant");
                System.out.println("1 : Client");
                System.out.println("2 : Quitter");
                choixUtilisateur = scanner.nextInt();
                scanner.nextLine();

                switch (choixUtilisateur) {
                    case 0:

                        System.out.print("codePostal : ");
                        int codePostalAdmin  = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Gouvernorat : ");
                        String gouvernoratAdmin  = scanner.nextLine();
                        Adresse adresseAdmin = new Adresse(gouvernoratAdmin, codePostalAdmin);
                        System.out.print("cin : ");
                        String cinAdmin  = scanner.nextLine();
                        System.out.print("nom : ");
                        String nomAdmin  = scanner.nextLine();
                        System.out.print("prenom : ");
                        String prenomAdmin  = scanner.nextLine();
                        Administrateur administrateur = new Administrateur(stock, cinAdmin, nomAdmin, prenomAdmin, adresseAdmin);

                        int choixGerant;
                        System.out.println("0 : Ajouter un article");
                        System.out.println("1 : Augmenter la quantité d'un article");
                        System.out.println("2 : Modifier un article");
                        System.out.println("3 : Supprimer un article");
                        System.out.println("4 : Consulter le stock");
                        System.out.println("5 : Quitter");
                    
                        do{
                            System.out.print("Donner votre choix : ");
                            choixGerant = scanner.nextInt();
                            scanner.nextLine();
                            switch(choixGerant){
                                case 0:
                                    System.out.println("0 : OrdinateurDeBureau");
                                    System.out.println("1 : OrdinateurPortable");
                                    System.out.println("2 : Mobile");
                                    System.out.println("3 : Stockage");
                                    System.out.println("4 : Peripheriques");
                            
                                    int choixGerant2 = scanner.nextInt();
                                    scanner.nextLine();
                            
                                    switch (choixGerant2) {
                                        case 0:
                                            System.out.print("Donner le nom de l'article a ajouter : ");
                                            String nom_article = scanner.nextLine();
                                            System.out.print("Donner le prix de l'article a ajouter : ");
                                            double prix_article = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le resolutionEcran de l'article a ajouter : ");
                                            double resolutionEcran = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le processeur de l'article a ajouter : ");
                                            String processeur = scanner.nextLine();
                                            System.out.print("Donner le ram de l'article a ajouter : ");
                                            long ram = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner le SystemeExploitation de l'article a ajouter : ");
                                            String systemeExploitationValue = scanner.nextLine();
                                            SystemeExploitation systemeExploitation = SystemeExploitation.valueOf(systemeExploitationValue);
                                            System.out.print("Donner le disqueDur de l'article a ajouter : ");
                                            long disqueDur = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner le carteGraphique de l'article a ajouter : ");
                                            String carteGraphique = scanner.nextLine();
                                            System.out.print("Donner la alimentation de l'article a ajouter : ");
                                            String alimentation = scanner.nextLine();
                                            System.out.print("Donner la quantjté de l'article a ajouter : ");
                                            long quantite_article = scanner.nextLong();
                                            scanner.nextLine();

                                            administrateur.ajouterArcticle(nom_article, prix_article, resolutionEcran, processeur, ram, systemeExploitation, disqueDur, carteGraphique, alimentation, quantite_article);
                                            break;
                                    
                                        case 1:
                                            System.out.print("Donner le nom de l'article a ajouter : ");
                                            String nom_article1 = scanner.nextLine();
                                            System.out.print("Donner le prix de l'article a ajouter : ");
                                            double prix_article1 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le resolutionEcran de l'article a ajouter : ");
                                            double resolutionEcran1 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le processeur de l'article a ajouter : ");
                                            String processeur1 = scanner.nextLine();
                                            System.out.print("Donner le ram de l'article a ajouter : ");
                                            long ram1 = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner le SystemeExploitation de l'article a ajouter : ");
                                            String systemeExploitationValue1 = scanner.nextLine();
                                            SystemeExploitation systemeExploitation1 = SystemeExploitation.valueOf(systemeExploitationValue1);
                                            System.out.print("Donner le disqueDur de l'article a ajouter : ");
                                            long disqueDur1 = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner le carteGraphique de l'article a ajouter : ");
                                            String carteGraphique1 = scanner.nextLine();
                                            System.out.print("Donner la capaciteBatterie de l'article a ajouter : ");
                                            long capaciteBatterie = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner la quantjté de l'article a ajouter : ");
                                            long quantite_article1 = scanner.nextLong();
                                            scanner.nextLine();

                                            administrateur.ajouterArcticle(nom_article1, prix_article1, resolutionEcran1, processeur1, ram1, systemeExploitation1, disqueDur1, carteGraphique1, capaciteBatterie, quantite_article1);
                                            break;
                                    
                                        case 2:
                                            System.out.print("Donner le nom de l'article a ajouter : ");
                                            String nom_article2 = scanner.nextLine();
                                            System.out.print("Donner le prix de l'article a ajouter : ");
                                            double prix_article2 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le resolutionEcran de l'article a ajouter : ");
                                            double resolutionEcran2 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le processeur de l'article a ajouter : ");
                                            String processeur2 = scanner.nextLine();
                                            System.out.print("Donner le ram de l'article a ajouter : ");
                                            long ram2 = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner le SystemeExploitation de l'article a ajouter : ");
                                            String systemeExploitationValue2 = scanner.nextLine();
                                            SystemeExploitation systemeExploitation2 = SystemeExploitation.valueOf(systemeExploitationValue2);
                                            System.out.print("Donner le appareilPhotoArriere de l'article a ajouter : ");
                                            double appareilPhotoArriere = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le appareilPhotoFrontal de l'article a ajouter : ");
                                            double appareilPhotoFrontal = scanner.nextDouble();
                                            System.out.print("Donner la nbSim de l'article a ajouter : ");
                                            int nbSim = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Donner la capaciteBatterie de l'article a ajouter : ");
                                            long capaciteBatterie2 = scanner.nextLong();
                                            scanner.nextLine();
                                            System.out.print("Donner la quantjté de l'article a ajouter : ");
                                            long quantite_article2 = scanner.nextLong();
                                            scanner.nextLine();
                                    
                                            administrateur.ajouterArcticle(nom_article2, prix_article2, resolutionEcran2, processeur2, ram2, systemeExploitation2, appareilPhotoArriere, appareilPhotoFrontal, nbSim, capaciteBatterie2, quantite_article2);
                                            break;
                                    
                                        case 3:
                                            System.out.print("Donner le nom de l'article a ajouter : ");
                                            String nom_article3 = scanner.nextLine();
                                            System.out.print("Donner le prix de l'article a ajouter : ");
                                            double prix_article3 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner la capaciteBatterie de l'article a ajouter : ");
                                            int capacite = scanner.nextInt();
                                            scanner.nextLine();
                                            System.out.print("Donner la quantjté de l'article a ajouter : ");
                                            long quantite_article3 = scanner.nextLong();
                                            scanner.nextLine();
                                    
                                            administrateur.ajouterArcticle(nom_article3, prix_article3, capacite, quantite_article3);                                    
                                            break;
                                    
                                        case 4:
                                            System.out.print("Donner le nom de l'article a ajouter : ");
                                            String nom_article4 = scanner.nextLine();
                                            System.out.print("Donner le prix de l'article a ajouter : ");
                                            double prix_article4 = scanner.nextDouble();
                                            scanner.nextLine();
                                            System.out.print("Donner le technologieDeConnexion de l'article a ajouter : ");
                                            String technologieDeConnexion = scanner.nextLine();
                                            System.out.print("Donner le interfaceAvecOrdinateur de l'article a ajouter : ");
                                            String interfaceAvecOrdinateur = scanner.nextLine();
                                            System.out.print("Donner la quantjté de l'article a ajouter : ");
                                            long quantite_article4 = scanner.nextLong();
                                            scanner.nextLine();
                                    
                                            administrateur.ajouterArcticle(nom_article4, prix_article4, technologieDeConnexion, interfaceAvecOrdinateur, quantite_article4);                                    
                                            break;
                                        default:
                                            System.out.println("Cette action n’est pas autorisée");
                                            break;
                                    }
                                    break;
                                case 1:
                                    System.out.print("Donner la reference de l'article a modifier : ");
                                    String reference_article = scanner.nextLine();
                                    System.out.print("Donner la quantité a augmente à l'article : ");
                                    long upQuantite = scanner.nextLong();
                                    administrateur.incrementerQuantiteArticle(reference_article, upQuantite);
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
                                    administrateur.modifierArticle(reference_articleM, nom_articleM, prix_articleM, quantite_articleM);
                                    System.out.println("L'article a été bien modifier!!!");                    
                                    break;
                                case 3:
                                    System.out.print("Donner la reference de l'article a supprimer : ");
                                    String reference_supprimer = scanner.nextLine();
                                    administrateur.supprimerArticle(reference_supprimer);
                                    System.out.println("L'article a été bien supprimer!!!");
                                    break;
                                case 4:
                                    System.out.print(administrateur.toString());;
                                    break;
                                case 5:
                                    System.out.println("Au revoir!!");
                                    break;
                                default:
                                System.out.println("Cette action n’est pas autorisée, réessayer!");
                                break;
                            }
                        
                        }while(choixGerant != 5);
                        break;

                    case 1:
                        System.out.println("Bonjour cher/chère client(e)");

                        System.out.print("codePostal : ");
                        int codePostal  = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Gouvernorat : ");
                        String gouvernorat  = scanner.nextLine();
                        Adresse adresse = new Adresse(gouvernorat, codePostal);
                        System.out.print("cin : ");
                        String cin  = scanner.nextLine();
                        System.out.print("nom : ");
                        String nom  = scanner.nextLine();
                        System.out.print("prenom : ");
                        String prenom  = scanner.nextLine();
                        Client client = new Client(cin, nom, prenom, adresse);
                        
                        int choixClient;
                        System.out.println("0 : Ajouter un article au panier");
                        System.out.println("1 : Consulter mon panier");
                        System.out.println("2 : Consulter les articles en stock");
                        System.out.println("3 : Mettre à jour quantité d’un article dans le panier");
                        System.out.println("4 : Supprimer un article du panier");
                        System.out.println("5 : Finaliser la commande");
                        System.out.println("6 : Annuler la commande");
                        System.out.println("7 : Quitter");
                        do{
                            System.out.print("Donner votre choix : ");
                            choixClient = scanner.nextInt();
                            scanner.nextLine();
                            switch (choixClient) {
                                case 0:
                                    System.out.print("Donner la reference de l'article à ajouter au panier : ");
                                    String referenceAdd = scanner.nextLine();
                                    System.out.print("Donner la quantité de l'article à ajouter au panier : ");
                                    long quantiteAdd = scanner.nextLong();
                                    client.ajouterAuPanier(stock, referenceAdd, quantiteAdd);
                                    System.out.println("Article ajouter au panier !!!");
                                    break;

                                case 1:
                                    client.afficherMonPanier();
                                    break;

                                case 2:
                                    System.out.println("0 : Par ordre Croissante");
                                    System.out.println("1 : Par ordre Decroissante");
                                    int choixClient2 = scanner.nextInt();
                                    switch (choixClient2) {
                                        case 0:
                                            client.afficherStockCroissanr(stock);
                                            break;

                                        case 1:
                                            client.afficherStockDecroissanr(stock);
                                            break;
                                    
                                        default:
                                            System.out.println("Cette action n’est pas autorisée!!!");
                                            break;
                                    }
                                    break;

                                case 3:
                                    System.out.print("Donner la reference de l'article pour mettre la quantité à jour dans panier : ");
                                    String referenceUpdate = scanner.nextLine();
                                    System.out.print("Donner la nouvelle quantité : ");
                                    long quantiteUpdate = scanner.nextLong();
                                    client.mettreAjourQuantite(referenceUpdate, quantiteUpdate);
                                    System.out.println("Panier mise à jour !!!");
                                    break;

                                case 4:
                                    System.out.print("Donner la reference de l'article à supprimer dans le panier : ");
                                    String referenceDelete = scanner.nextLine();
                                    client.supprimerArticle(referenceDelete);
                                    System.out.println("Article supprimer au panier !!!");
                                    break;

                                case 5:
                                    client.finaliserCommande(stock);
                                    System.out.println("Commande finaliser !!!");
                                    break;

                                case 6:
                                    client.annulerCommande();
                                    System.out.println("Commande annuler !!!");
                                    break;

                                case 7:
                                    System.out.println("Au revoir!!");
                                    break;

                                default:
                                    System.out.println("Cette action n’est pas autorisée!!!");
                                    break;
                            }
                        }while (choixClient != 7);
                        break;

                    case 2:
                        System.out.println("Au revoir!!");
                        break;
                
                    default:
                        System.out.println("Cette action n’est pas autorisée, réessayer!");
                        break;
                }

            }while(choixUtilisateur != 2);

        }    
        
    }
}