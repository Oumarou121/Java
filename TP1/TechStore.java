import java.util.Scanner;
import java.util.ArrayList;


public class TechStore{
    public static void main(String [] args){
        System.out.println("Soyez les bienvenus !!");

        System.out.println("0 : Gerant");
        System.out.println("1 : Client");

        Scanner scanner = new Scanner(System.in);
        int choix_user = scanner.nextInt();

        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(0, "Prelt50", "PC Portable Dell Vostro 3500", 1999));
        products.add(new Product(1, "EeB21", "Ecouteur JBL T125BT", 129));
        products.add(new Product(2, "SpNo2", "Smartphone INFINIX Hot 10", 439));
        products.add(new Product(3, "Mu8a3", "Micro Casque 588 Filaire", 9.900));
        products.add(new Product(4, "SpA4", "Smartphone NOKIA C1", 185));


        if(choix_user == 0){
            System.out.println("0 : Ajouter un article");
            System.out.println("1 : Modifier un article");
            System.out.println("2 : Consulter un article");
            System.out.println("3 : Supprimer un article");

            int choix_gerant = scanner.nextInt();
            scanner.nextLine();
            switch(choix_gerant){
                case 0:
                    System.out.print("Donner le nom de l'article a ajouter : ");
                    String nom_product = scanner.nextLine();
                    System.out.print("Donner le prix de l'article a ajouter : ");
                    double prix_product = scanner.nextDouble();
                    ajouterArticle(products, nom_product,prix_product);
                    break;

                case 1:
                    System.out.print("Donner la reference de l'article a modifier : ");
                    String reference_product = scanner.nextLine();
                    System.out.print("Donner le nouveau prix de l'article a modifier : ");
                    double prix_modifier = scanner.nextDouble();
                    modifierArticle(products, reference_product,prix_modifier);                    
                    break;

                case 2:
                    System.out.println("0 : Consulter par ordre croissante");
                    System.out.println("1 : Consulter par ordre decroissante");
                    int ordre = scanner.nextInt();
                    if(ordre == 0){
                        ArrayList<Product> productsCroissant = new ArrayList<Product>();
                        productsCroissant.addAll(products);
                        affichageCroissant(productsCroissant);
                    }else if(ordre == 1){
                        ArrayList<Product> productsDecroissant = new ArrayList<Product>();
                        productsDecroissant.addAll(products);
                        affichageDecroissant(productsDecroissant);

                    }

                    break;

                case 3:
                    System.out.print("Donner la reference de l'article a supprimer : ");
                    String reference_supprimer = scanner.nextLine();
                    supprimerArticle(products, reference_supprimer);
                    break;
            }

        }else if(choix_user == 1){
            System.out.println("Bonjour cher/chere client(e)");
            for(Product product : products){
                System.out.println(product.Affichage());
            }
        }

    }

    public static String genererReference(String nom, int id){
        String ref = "";
        nom = nom.trim();
        for(int i = 0; i < nom.length(); i++){
            if(i % 5 == 0 && nom.charAt(i) != ' '){
                ref = ref + nom.charAt(i);
            }
        }
        ref = ref + id;
        return ref;
    }

    public static void ajouterArticle(ArrayList<Product> products, String nom, double prix){
        Product p;
        int id = products.size();
        String ref = genererReference(nom, id);
        p = new Product(id, ref, nom, prix);
        products.add(p);
    }

    public static void modifierArticle(ArrayList<Product> products, String reference, double prix){
        int i = 0;
        while(i < products.size()){
            Product product = products.get(i);
            String current = product.getReference();
            if(current.equals(reference)){
                product.setPrix(prix);
            }
            i++;
        }
    }

    public static Product prixMin(ArrayList<Product> products){
        Product min = products.get(0);
        for(Product current : products){
            if(min.getPrix() > current.getPrix()){
                min = current;
            }
        }
        return min;
    }

    public static void affichageCroissant(ArrayList<Product> products){
        int taille = products.size();
        Product productSort[] = new Product[taille];
        ArrayList<Product> allProduct = products;
        for(int i = 0; i < taille; i++){
            if(i == 0){
                productSort[i] = prixMin(allProduct);
            }else{
                Product removeProduct = productSort[i - 1];
                allProduct.remove(removeProduct);
                productSort[i] = prixMin(allProduct);
            }
        }
        for(Product p : productSort){
            System.out.println(p.Affichage());
        }
    }

    public static Product prixMax(ArrayList<Product> products){
        Product max = products.get(0);
        for(Product current : products){
            if(max.getPrix() < current.getPrix()){
                max = current;
            }
        }
        return max;
    }

    public static void affichageDecroissant(ArrayList<Product> products){
        int taille = products.size();
        Product productSort[] = new Product[taille];
        ArrayList<Product> allProduct = products;
        for(int i = 0; i < taille; i++){
            if(i == 0){
                productSort[i] = prixMax(allProduct);
            }else{
                Product removeProduct = productSort[i - 1];
                allProduct.remove(removeProduct);
                productSort[i] = prixMax(allProduct);
            }
        }
        for(Product p : productSort){
            System.out.println(p.Affichage());
        }
    }

    public static void supprimerArticle(ArrayList<Product> products, String reference){
        int taille = products.size();
        for(int i = 0; i < taille; i++){
            Product current = products.get(i);
            if(current.getReference().equals(reference)){
                products.remove(current);
                break;
            }
        }
    }

}

class Product{
    private int id;
    private String reference;
    private String nom;
    private double prix;

    public Product(int id, String reference, String nom, double prix){
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.prix = prix;
    }

    public int getId(){
        return this.id;
    }

    public String getReference(){
        return this.reference;
    }

    public String getNom(){
        return this.nom;
    }

    public double getPrix(){
        return this.prix;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setReference(String ref){
        this.reference = ref;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrix(double prix){
        this.prix = prix;
    }

    public String Affichage(){
        return "ID : " + this.id + " Reference : " + this.reference + " Nom : " + this.nom + " Prix : " + this.prix + " TND"; 
    }

}