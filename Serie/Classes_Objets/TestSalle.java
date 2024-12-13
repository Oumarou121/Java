public class TestSalle {
    public static void main(String[] args) {
        Salle[] lesSalles  = new Salle[3];
        lesSalles[0] = new Salle(30, (float)6.8, "Gestion", true);
        lesSalles[1] = new Salle(20, (float)16.8, "Mécanique", true);
        lesSalles[2] = new Salle(18, (float)20.8, "Informatique", false);

        System.out.println("Le nombre d'instance " + Salle.getNbSales());

        for (Salle salle : lesSalles) {
            System.out.println(salle.decrire());
        }
    }
}
