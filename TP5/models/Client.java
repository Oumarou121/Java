package models;

import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;
import java.io.FileOutputStream;

public class Client extends Personne {
    private static int idFacture = 0;
    private ArrayList<Element> panier;

    public Client(String cin, String nom, String prenom, Adresse adresse, ArrayList<Element> panier){
        super(cin, nom, prenom, adresse);
        this.panier = panier;
    }

    public Client(String cin, String nom, String prenom, Adresse adresse){
        super(cin, nom, prenom, adresse);
        this.panier = new ArrayList<Element>();
    }

    public ArrayList<Element> getPanier() {
        return panier;
    }

    public void setPanier(ArrayList<Element> panier) {
        this.panier = panier;
    }

    public Element trouverAricle(String reference){
        for(Element current : panier){
            if (current.equals(reference)) {
                return current;
            }
        }
        return null;
    }

    public void ajouterAuPanier(Stock stock, String reference, long quantite){
        Element isInStock = stock.trouverArticle(reference);

        if (isInStock != null) {
            Element isInPanier = trouverAricle(reference);
            if (isInPanier != null) {
                isInPanier.incrementerQuantite(quantite);
            } else {
                Element addPanier = new Element(isInStock.getArticle(), quantite);
                panier.add(addPanier);
            }
        }else{
            System.out.println("Cette reference n'existe pas !!!");
        }
    }

    public void mettreAjourQuantite(String reference, long quantite){
        Element isInPanier = trouverAricle(reference);

        if (isInPanier != null) {
            isInPanier.setQuantite(quantite);
        } else {
            System.out.println("Cette reference n'existe pas !!!");
        }

    }

    public void supprimerArticle(String reference){
        Element isInPanier = trouverAricle(reference);

        if (isInPanier != null) {
            panier.remove(isInPanier);
        } else {
            System.out.println("Cette reference n'existe pas !!!");
        }
    }

    public  void annulerCommande(){
        panier.clear();
    }

    public String afficherPanier(){
        String result = "";
        for(Element current : panier){
            result += current.toString() + "\n";
        }
        return result;
    }

    @Override
    public String toString(){
        return super.toString() + " Role : Client \n" + "Voici Panier : \n" + afficherPanier(); 
    }
    
    public void afficherMonPanier(){
        System.out.println(toString());
    }

    public void afficherStockCroissanr(Stock stock){
        stock.afficherCroissant();
    }

    public void afficherStockDecroissanr(Stock stock){
        stock.afficherDecroissant();
    }

    // double genererFacture() {
    //     double total = 0;
    //     String facture = "Article \t Quantité \t Prix unitaire \n";
    //     String path = "/home/oumarou/Documents/Java/TP5/factures/";
    //     String file = path + "Facture_" + idFacture + ".txt";
    //     for (Element e : getPanier()) {
    //         total += e.getPrixArticle() * e.getQuantite();
    //         facture += e.getReferenceArticle() + " \t \t \t " +e.getQuantite() + "\t\t\t" + e.getPrixArticle() + " \n"; 
    //     }

    //     facture += "\n_________________________________________________\n \t \t \t \t Total: \t" + total;
        
    //     BufferedWriter br;
    //         try {
    //             br = new BufferedWriter(new FileWriter(file));
    //             br.write(facture + "\n \n");
    //             br.close();
    //         } catch (IOException e) { e.printStackTrace(); }
    //     idFacture++;
    //     return total;
    // }

    double genererFacture() {
        double total = 0;
        String path = "/home/oumarou/Documents/Java/TP5/factures/";
        String file = path + "Facture_" + idFacture + ".pdf";
    
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
    
            // Titre de la facture
            document.add(new Paragraph("Facture", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD)));
            document.add(new Paragraph(" ")); // Saut de ligne
    
            // Tableau pour les articles
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{3, 1, 2, 2});
            table.addCell("Article");
            table.addCell("Quantité");
            table.addCell("Prix unitaire");
            table.addCell("Sous-total");
    
            // Contenu de la facture
            for (Element e : getPanier()) {
                double sousTotal = e.getPrixArticle() * e.getQuantite();
                total += sousTotal;
                table.addCell(e.getReferenceArticle());
                table.addCell(String.valueOf(e.getQuantite()));
                table.addCell(String.format("%.2f", e.getPrixArticle()));
                table.addCell(String.format("%.2f", sousTotal));
            }
    
            document.add(table);
    
            // Total de la facture
            document.add(new Paragraph(" ")); // Saut de ligne
            document.add(new Paragraph("Total: " + String.format("%.2f", total), new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
    
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        idFacture++;
        return total;
    }

    public void finaliserCommande(Stock stock){
        double total = genererFacture();
        System.out.println("Total de l’achat : " + total);
        for(Element current : panier){
            Element currentFromStock = stock.trouverArticle(current.getReferenceArticle());
            currentFromStock.decrementerQuantite(current.getQuantite());
        }
        annulerCommande();        
    }
}
