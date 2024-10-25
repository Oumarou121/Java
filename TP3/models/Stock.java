package models;
import java.util.ArrayList;

public class Stock{

    private ArrayList<Element> articleList;

    public Stock(){
        this.articleList = new ArrayList<Element>();
    }

    public Stock(ArrayList<String> noms, ArrayList<Double> prix, ArrayList<Long> quantites){
        this.articleList = new ArrayList<Element>();

        for(int i = 0; i < noms.size(); i++){
            Article currentActicle = new Article(noms.get(i), prix.get(i));
            Element currentElement = new Element(currentActicle, quantites.get(i));
            articleList.add(currentElement);
        }
    }

    public ArrayList<Element> getArticleList(){
        return this.articleList;
    }

    public int getArticleNb(){
        return this.articleList.size();
    }

    public void setArticleList(ArrayList<Element> articleList){
        this.articleList = articleList;
    }

    public void ajouterArcticle(Article article, long quantite){
        Element element = new Element(article, quantite);
        this.articleList.add(element);
    }

    public void ajouterArcticle(String nom, double prix , long quantite){
        Article article = new Article(nom, prix);
        ajouterArcticle(article, quantite);
    }

    public Element trouverArticle(String reference){
        for(Element el : this.articleList){
            if (el.getReferenceArticle().equals(reference)) {
                return el;
            } else {
                continue;
            }
        }
        return null;
    }

    public void modifierArticle(String reference, String nom, double prix, long quantite){
        Element element = trouverArticle(reference);
        
        if (element != null) {
            Article article = new Article(nom, prix);
            element.setArticle(article);
            element.setQuantite(quantite);
        } else {
            System.out.println("L'article n\'existe pas");
        }
        
    }

    public void supprimerArticle(String reference){
        Element element = trouverArticle(reference);
        
        if (element != null) {
           this.articleList.remove(element);
        } else {
            System.out.println("L'article n\'existe pas");
        }
        
    }

    public void incrementerQuantiteArticle(String reference, long quantite){
        Element element = trouverArticle(reference);
        
        if (element != null) {
           element.incrementerQuantite(quantite);
        } else {
            System.out.println("L'article n\'existe pas");
        }
    }

    public void decrementerQuantiteArticle(String reference, long quantite){
        Element element = trouverArticle(reference);
        
        if (element != null) {
           element.decrementerQuantite(quantite);
        } else {
            System.out.println("L'article n\'existe pas");
        }
    }

    @Override
    public String toString(){
        String finalResult = "";
        for (Element el : this.articleList) {
            String currentResult = "";
            currentResult = "Element [article = " + el.toString() + "]" + "\n";
            finalResult += currentResult;
        }
        return finalResult;
    }

}