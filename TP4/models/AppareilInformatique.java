package models;

public abstract class AppareilInformatique extends Article implements Garantissable{

    private double resolutionEcran;
    private String processeur;
    private long ram;
    private SystemeExploitation systemeExploitation;


    public AppareilInformatique(String nom, double prix, double resolutionEcran, String processeur, long ram, SystemeExploitation systemeExploitation) {
        super(nom, prix);
        
        this.resolutionEcran = resolutionEcran;
        this.processeur = processeur;
        this.ram = ram;
        this.systemeExploitation = systemeExploitation;
    }


    public double getResolutionEcran() {
        return resolutionEcran;
    }


    public void setResolutionEcran(double resolutionEcran) {
        this.resolutionEcran = resolutionEcran;
    }


    public String getProcesseur() {
        return processeur;
    }


    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }


    public long getRam() {
        return ram;
    }


    public void setRam(long ram) {
        this.ram = ram;
    }


    public SystemeExploitation getSystemeExploitation() {
        return systemeExploitation;
    }


    public void setSystemeExploitation(SystemeExploitation systemeExploitation) {
        this.systemeExploitation = systemeExploitation;
    }

    @Override
    public String toString(){
        return "ResolutionEcran : " + this.resolutionEcran + " Processeur : " + this.processeur +
         " Ram : " + this.ram + " SystemeExploitation : " + this.systemeExploitation;
    }
    
}