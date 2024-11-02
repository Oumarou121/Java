package models;

import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;
import java.io.FileOutputStream;
import java.time.LocalDate;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;

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
        
            // Titre principal
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font sectionFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font regularFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        
            // Titre de la facture
            Paragraph title = new Paragraph("Receipt", titleFont);
            title.setAlignment(1);
            document.add(title);
            document.add(new Paragraph(" ")); // Saut de ligne
        
            // Informations sur la commande
            document.add(new Paragraph("Order Information", sectionFont));
            document.add(new Paragraph("Order Number: #"+ idFacture +"\nOrder Date: " + LocalDate.now() +"\nPayment Method: Cash\nDelivery Status: In Progress", regularFont));
            document.add(new Paragraph(" "));
        
            // Adresse de livraison
            document.add(new Paragraph("Shipping Address", sectionFont));
            document.add(new Paragraph(  super.toString() , regularFont));
            document.add(new Paragraph(" "));
        
            // Création du tableau pour les articles
            PdfPTable table = new PdfPTable(4);
            table.setWidths(new int[]{3, 1, 2, 2});
            table.setWidthPercentage(100);
        
            PdfPCell cell;
        
            // En-têtes du tableau
            cell = new PdfPCell(new Phrase("Item", boldFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Quantity", boldFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Unit Price", boldFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Subtotal", boldFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        
            // Ajout des articles dans le tableau
            for (Element e : getPanier()) {
                double sousTotal = e.getPrixArticle() * e.getQuantite();
                total += sousTotal;
            
                table.addCell(new PdfPCell(new Phrase(e.getReferenceArticle(), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.valueOf(e.getQuantite()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.format("%.2f", e.getPrixArticle()), regularFont)));
                table.addCell(new PdfPCell(new Phrase(String.format("%.2f", sousTotal), regularFont)));
            }
        
            document.add(table);
        
            // Total de la facture
            document.add(new Paragraph(" "));
            Paragraph totalParagraph = new Paragraph("Total: " + String.format("%.2f", total), boldFont);
            totalParagraph.setAlignment(2); // Utilisation de Element.ALIGN_RIGHT pour aligner à droite
            document.add(totalParagraph);
        
            // Footer
            document.add(new Paragraph(" "));
            Paragraph footer = new Paragraph("Thank you for shopping with us! For any inquiries, contact support@example.com.\nReturn Policy: Returns accepted within 30 days.", regularFont);
            footer.setAlignment(1);
            document.add(footer);
        
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
