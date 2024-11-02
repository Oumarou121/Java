package models;

public class Adresse{
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