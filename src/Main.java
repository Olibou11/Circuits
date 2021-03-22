// Importations
import ca.cegepjonquiere.simulohmatique.circuit.*;
import ca.cegepjonquiere.simulohmatique.resistor.FabriqueResistor;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;
import java.util.Scanner;

// Classe ''Main''
public class Main {
    public static void main(String[] args) {

        // Initialisation du Scanner
        Scanner sc = new Scanner(System.in);

        // Variables diverses
        AbstractCircuit circuit;

        // Variables responsable de la vérification des entrées
        String messageErreur = "          !!! Code ERREUR: Mauvaise entrée !!!"; // Message d'erreur pré-fait

        // Questionnaire

        System.out.println("\n" + "•-----------------------Calculatrice-----------------------•");
        System.out.println("\n" + "Veuillez entrer vos résistors entre parenthèses ''( )'' s'il s'agit d'un circuit en série, si non entre crochets ''[ ]'' s'il sagit d'un circuit en parallèle.");
        System.out.print("  >> ");

        circuit = FabriqueCircuit.fabriquerCircuit(sc.nextLine()); // Une erreur survient, le circuit est null, donc ca crée des erreurs plus loin dont le mettre sous tension et le toString.

        System.out.println("\n" + "Veuillez entrer une tension en Volt (V).");
        System.out.print("  >> ");
        if (circuit != null)
            circuit.mettreSousTension(sc.nextDouble());

        System.out.println(circuit.toString());
    }
}