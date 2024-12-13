public class TableauSalle {
    private Labo[] labos = new Labo[100];
    private Bureau[] bureaus = new Bureau[100];
    private SalleCours[] salleCours = new SalleCours[100];
    private int tailleLabos;
    private int tailleBureaus;
    private int tailleSalleCours;
    
    public TableauSalle(){
        tailleBureaus = 0;
        tailleLabos = 0;
        tailleSalleCours = 0;
    }

    public TableauSalle(Labo[] labos, Bureau[] bureaus, SalleCours[] salleCours, int tailleLabos, int tailleBureaus,
            int tailleSalleCours) {
        this.labos = labos;
        this.bureaus = bureaus;
        this.salleCours = salleCours;
        this.tailleLabos = tailleLabos;
        this.tailleBureaus = tailleBureaus;
        this.tailleSalleCours = tailleSalleCours;
    }

    public void ajoutLabo(Labo ajoutLabo){
        if (tailleLabos < 100) {
            labos[tailleLabos] = new Labo(ajoutLabo.getNbrPlaces(), ajoutLabo.getSurface(), ajoutLabo.getDepartement(), ajoutLabo.isConnected(), ajoutLabo.getNbPC());
            tailleLabos++;
        } else {
            System.out.println("Le tableau de labos est rempli.");
        }
    }

    public void ajoutBureau(Bureau ajoutBureau){
        if (tailleBureaus < 100) {
            bureaus[tailleBureaus] = new Bureau(ajoutBureau.getNbrPlaces(), ajoutBureau.getSurface(), ajoutBureau.getDepartement(), ajoutBureau.isConnected());
            tailleBureaus++;
        } else {
            System.out.println("Le tableau de bureaus est rempli.");
        }
    }

    public void ajoutSalleCours(SalleCours ajoutSalleCours) {
        if (tailleSalleCours < 100) {
            salleCours[tailleSalleCours] = new SalleCours(ajoutSalleCours.getNbrPlaces(), ajoutSalleCours.getSurface(), ajoutSalleCours.getDepartement(), ajoutSalleCours.isConnected(), ajoutSalleCours.isVideoProj());
            tailleSalleCours++;
        } else {
            System.out.println("Le tableau de salle de cours est rempli.");
        }
    }

    public float getSurfaceSalle(){
        float result = 0;

        for(int i = 0; i < tailleLabos; i++){
            result += labos[i].getSurface();
        }

        for(int i = 0; i < tailleBureaus; i++){
            result += bureaus[i].getSurface();
        }

        for(int i = 0; i < tailleSalleCours; i++){
            result += salleCours[i].getSurface();
        }

        return result;
    }

    @Override
    public String toString(){
        String result = "";

        for(int i = 0; i < tailleLabos; i++){
            result += labos[i].toString() + "\n";
        }

        for(int i = 0; i < tailleBureaus; i++){
            result += bureaus[i].toString() + "\n";
        }

        for(int i = 0; i < tailleSalleCours; i++){
            result += salleCours[i].toString() + "\n";
        }

        return result;
    }
    
}

