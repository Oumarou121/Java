package models;

public class Peripheriques extends Article {
    private String technologieDeConnexion;
    private String interfaceAvecOrdinateur;
   
    public Peripheriques(String nom, double prix, String technologieDeConnexion, String interfaceAvecOrdinateur) {
        super(nom, prix);

        this.technologieDeConnexion = technologieDeConnexion;
        this.interfaceAvecOrdinateur = interfaceAvecOrdinateur;
        
    }

    public String getTechnologieDeConnexion() {
        return technologieDeConnexion;
    }

    public void setTechnologieDeConnexion(String technologieDeConnexion) {
        this.technologieDeConnexion = technologieDeConnexion;
    }

    public String getInterfaceAvecOrdinateur() {
        return interfaceAvecOrdinateur;
    }

    public void setInterfaceAvecOrdinateur(String interfaceAvecOrdinateur) {
        this.interfaceAvecOrdinateur = interfaceAvecOrdinateur;
    }
    
    @Override
    public String toString(){
        return super.toString() + " TechnologieDeConnexion : " + this.technologieDeConnexion + " InterfaceAvecOrdinateur : " + this.interfaceAvecOrdinateur;
    }

}
