// Importations
import ca.cegepjonquiere.circuit.CircuitParallele;
import ca.cegepjonquiere.circuit.CircuitSerie;
import ca.cegepjonquiere.resistor.FabriqueResistor;
import ca.cegepjonquiere.resistor.Resistor;
import java.util.Scanner;

// Classe ''Main''
public class Main {
    public static void main(String[] args) {

        // Initialisation du Scanner
        Scanner sc = new Scanner(System.in);

        // Variables
        String choixCircuit;
        String resistanceCircuit;

        // Création d'un circuit
        CircuitSerie circuitSerie = new CircuitSerie();
        CircuitParallele circuitParallele = new CircuitParallele();

        // Tableau des résisteurs
        String tableauDesString[];

        // Création d'un séparateur
        final String SEPARATEUR = ",";

        do {
            // Questionnairedo{
            System.out.println("Voulez-vous entrer un circuit en (S)érie ou un (P)arallèle?");
            choixCircuit = sc.next().toUpperCase();

            System.out.println("Entrez des résistances séparées par des virgules");
            resistanceCircuit = sc.next();

            tableauDesString = resistanceCircuit.split(SEPARATEUR); //

            if (choixCircuit.charAt(0) == 'S') { // Il s'agit d'un circuit en Série
                for (int i = 0; i < tableauDesString.length; i++) {
                    Resistor r = FabriqueResistor.fabriquerResistor(tableauDesString[i]);
                    circuitSerie.ajouterResistor(r);
                }
                System.out.print("Entrez une tension en volts");
                circuitSerie.mettreSousTension(sc.nextDouble());
                System.out.println(" Resistance : " + circuitSerie.calculerResistance() + " Tension : " + circuitSerie.calculerTension() + " Courant : " + circuitSerie.calculerCourrant());
            }
            if (choixCircuit.charAt(0) == 'P') { // Il s'agit d'un circuit en paralelle
                for (int i = 0; i < tableauDesString.length; i++) {
                    Resistor r = FabriqueResistor.fabriquerResistor(tableauDesString[i]);
                    circuitParallele.ajouterResistor(r);
                }
                System.out.println("Entrez une tension en volts");
                circuitParallele.mettreSousTension(sc.nextDouble());
                System.out.println(" Resistance : " + circuitParallele.calculerResistance() + " Tension : " + circuitParallele.calculerTension() + " Courant : " + circuitParallele.calculerCourrant());
            }
        }while(true);
    }
}

//do{
//System.out.println("\n" + "•----------------Calculatrice----------------•");
// System.out.println("\n" + "Veuiller entrer les couleurs d'une résistance.");
// System.out.print("  >>");
//ca.cegepjonquiere.resistor.Resistor resistor = ca.cegepjonquiere.resistor.FabriqueResistor.fabriquerResistor(sc.next());

//if (resistor == null){ // Entrée non valide
//System.out.println("\n" + "Ceci n'est pas une résistance.");
// }
// else // Entrée valide
// System.out.println("\n" + "Cette résistance vaut " + resistor.getResistance() + "Ω ±" + resistor.getTolerance() + "%");

//}while(true);
//}
