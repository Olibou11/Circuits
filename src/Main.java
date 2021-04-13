// Importations
import ca.cegepjonquiere.simulohmatique.circuit.*;
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;

import java.util.Scanner;

// Classe ''Main''
public class Main {

    public static void main(String[] args) {

        // Initialisation du Scanner
        Scanner sc = new Scanner(System.in);

        // Création du circuit
        AbstractCircuit circuit;

        // String responsable du message d'erreur
        String messageErreur = "          !!! Code ERREUR: Mauvaise entrée !!!";

        // Questionnaire

        System.out.println("\n" + "•-----------------------Calculatrice-----------------------•");
        System.out.println("\n" + "Veuillez entrer vos résistors entre parenthèses ''( )'' s'il s'agit d'un circuit en série, si non entre crochets ''[ ]'' s'il sagit d'un circuit en parallèle.");
        System.out.print("  >> ");

        try {
            circuit = FabriqueCircuit.fabriquerCircuit(sc.nextLine()); // Crée le circuit

            System.out.println("\n" + "Veuillez entrer une tension en Volt (V).");
            System.out.print("  >> ");

            circuit.mettreSousTension(sc.nextDouble()); // Met le voltage à la source
            System.out.println(circuit.toString()); // Imprime les données

            // Fermeture du scanner
                sc.close();
        }
        catch (IllegalArgumentException | CircuitOuvert e) { // Une erreur s'est produite dans le code
            System.out.println(e); // Imprime la description personnalisé de l'erreur
            e.printStackTrace(); //Imprime les traces d'erreur dans le code
        }
    }
}