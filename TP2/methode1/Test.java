import java.util.Scanner;

class Adresse{
    private String gouvernorat;
    private int codePostal;

    public Adresse(String gouvernorat, int codePostal){
        this.gouvernorat = gouvernorat;
        this.codePostal = codePostal;
    }

    public String getGouvernorat(){
        return this.gouvernorat;
    }

    public  int getCodePostal(){
        return this.codePostal;
    }

    public void setGouvernorat(String gouvernorat){
        this.gouvernorat = gouvernorat;
    }

    public void setCodePostal(int codePostal){
        this.codePostal = codePostal;
    }

    @Override
    public String toString(){
        return "Adresse [gouvernorat = " + gouvernorat + ", codePostal = " + codePostal + "  ];";
    }
}

class Personne{
    private String cin;
    private String nom;
    private String prenom;
    private Adresse adresse;

    public Personne(String cin, String nom, String prenom, Adresse adresse){
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getCin(){
        return this.cin;
    }

    public String getNom(){
        return this.nom;
    }

    public String getPrenom(){
        return this.prenom;
    }

    public Adresse getAdresse(){
        return this.adresse;
    }

    public void setCin(String cin){
        this.cin = cin;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setAdresse(Adresse adresse){
        this.adresse = adresse;
    }

    @Override
    public String toString(){
        return "cin = " + cin + " nom = " + nom + " prenom = " + prenom + adresse.toString();
    }

}

public class Test{
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