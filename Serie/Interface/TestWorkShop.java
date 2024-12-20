public class TestWorkShop {
    public static void main(String[] args) {
        Salle[] tabSalle = {
            new SalleCours(25, 6.8f, "Gestion", true, false),
            new SalleCours(50, 15.2f, "Mécanique", false,  true),
            new Labo(103, 20f, "Informatique", true, 12),
            new SalleCours(9, 25f, "Informatique", true, true),
            new Bureau(50 ,50f, "Informatique", true),
            new Labo(103, 20f, "Mécanique", true, 8)
        };

        CritereReservation critere = new CritereWorkShop(10);

        for (Salle salle : tabSalle) {
            if (critere.peutEtreReserve(salle)) {
                System.out.println(salle);
            }
        }
    }
}