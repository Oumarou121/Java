public class GestionSalle {
    public static void main(String[] args) {
        //7.3.3
        // Salle[] tabSalle = new Salle[3];
        // Bureau bureau01 = new Bureau(101, 6.8f, "Gestion", true);
        //  bureau01.ajoutEnseignant("Enseignant 01");
        // Le message d'erreur est due au faite qu'on utiliser pas try/catch

        // //Solution
        // try {
        //     bureau01.ajoutEnseignant("Enseignant 01");
        // } catch (SalleException e) {
        //     System.out.println(e.getMessage());
        // }


        //7.3.4
        // Gestion des erreurs :
        // Si une condition d'ajout échoue (par exemple, dépassement de capacité), une exception SalleException est levée.
        // Bloc try-catch :
        // Le code dans le bloc try tente d'exécuter ajoutEnseignant.
        // Si une SalleException est levée, elle est attrapée dans le bloc catch.
        // La méthode getMessage() de l'exception est appelée pour afficher un message descriptif.

        Salle[] tabSalle = new Salle[3];
        Bureau bureau01 = new Bureau(2, 6.8f, "Gestion", true);

        try {
            bureau01.ajoutEnseignant("Enseignant 01");
            bureau01.ajoutEnseignant("Enseignant 02");
            bureau01.ajoutEnseignant("Enseignant 03");
        } catch (SalleException e) {
            System.out.println(e.getMessage());
        }

    }
}
