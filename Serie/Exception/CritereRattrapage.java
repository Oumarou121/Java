import java.util.Arrays;
import java.util.List;

public class CritereRattrapage implements CritereReservation {
    private int nbrPlaces;

    public CritereRattrapage(int nbrPlaces){
        this.nbrPlaces = nbrPlaces;
    }

    public int getNbrPlaces(){
        return nbrPlaces;
    }

    public void setNbrPlaces(int nbrPlaces){
        this.nbrPlaces = nbrPlaces;
    }

    public boolean peutEtreReserve(Salle s){
        if (s instanceof SalleCours) {
            SalleCours salleCours = (SalleCours)s;
            return salleCours.isVideoProj() && salleCours.getNbrPlaces() >= nbrPlaces;
        } else {
            return false;
        }
    }

    public static Salle[] resultatCritere(Salle[] salles, CritereReservation critere){
        List<Salle> result = Arrays.stream(salles).filter(critere::peutEtreReserve).toList();
        return result.isEmpty() ? null : result.toArray(new Salle[0]);
    }
}
