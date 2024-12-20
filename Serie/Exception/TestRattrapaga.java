public class TestRattrapaga {

    public static void main(String[] args) {
        Salle[] tabSalle = new Salle[7];
        tabSalle[0] = new SalleCours(25, 6.8f, "Gestion", true, false);
        tabSalle[1] = new SalleCours(50, 15.2f, "Mécanique", false, true);
        tabSalle[2] = new Labo(103, 20f, "Informatique", true, 12);
        tabSalle[3] = new SalleCours(9, 25f, "Informatique", true, true);
        tabSalle[4] = new Bureau(50, 50f, "Informatique", true);
        // tabSalle[5] = new SalleCours(25, 6.8f, "Gestion", true, false);
        tabSalle[6] = new Labo(108, 20f, "Mécanique", true, 8);
        CritereReservation critereRattrapage = new CritereRattrapage(10);
        for(int i = 0; i < 7; i++){
            if (critereRattrapage.peutEtreReserve(tabSalle[i])) {
                System.out.println(tabSalle[i]);                
            }
        }
    }
    
}
