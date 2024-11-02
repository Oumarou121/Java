package models;

public class Element{
    private Article article;
    private long quantite;

    public Element(Article article, long quantite){
        this.article = article;
        this.quantite = quantite;
    }

    public Element(String nom, double prix, long quantite){
        this.article = new Article(nom, prix);
        this.quantite = quantite;
    }

    public Article getArticle(){
        return this.article;
    }

    public long getQuantite(){
        return this.quantite;
    }

    public String getReferenceArticle(){
        return this.article.getReference();
    }

    public String getNomArticle(){
        return this.article.getNom();
    }

    public double getPrixArticle(){
        return this.article.getPrix();
    }

    public void setArticle(Article article){
        this.article = article;
    }

    public void setQuantite(long quantite){
        this.quantite = quantite;
    }

    public void incrementerQuantite(long upQuantite){
        this.quantite += upQuantite;
    }

    public void decrementerQuantite(long upQuantite){
        if(this.quantite >= upQuantite){
            this.quantite -= upQuantite;
        }else{
            System.out.println("La quantite est insuffisante pour cette action. ");
        }
    }

    public void modifier(String nom, double prix, long quantite){
        Article newActicle = new Article(nom, prix);
        setArticle(newActicle);
        setQuantite(quantite);
    }

    public boolean equals(String reference){
        return this.article.getReference().equals(reference);
    }

    public boolean equals(Article article){
        return this.article.equals(article);
    }

    @Override
    public String toString(){
        return "article = " + this.article.toString() + " quantité = " + this.getQuantite();
    }

}
