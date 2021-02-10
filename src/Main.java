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

        do {
            // Variables diverses
            String choixCircuit;
            String resistanceCircuit;
            String erreur = "          !!! Code ERREUR: Mauvaise entrée !!!"; // Message d'erreur pré-fait

            // Variables ''Vérificateurs d'erreurs''
            Boolean messageErreur = true;
            Boolean messageErreur2 = false;

            // Création d'un circuit
            CircuitSerie circuitSerie = new CircuitSerie();
            CircuitParallele circuitParallele = new CircuitParallele();

            // Tableau des Srings résisteurs
            String tableauDesString[];

            // Création d'un séparateur
            final String SEPARATEUR = ",";

            // Questionnaire

            System.out.println("\n" + "•-----------------------Calculatrice-----------------------•");
            System.out.println("\n" + "Voulez-vous entrer un circuit en (S)érie ou un (P)arallèle?");
            System.out.print("  >> ");
            choixCircuit = sc.next().toUpperCase();

            if (choixCircuit.charAt(0) == 'S') { // Il s'agit d'un circuit en Série
                messageErreur = false; // Aucune erreur est détectée
                System.out.println("Entrez des résistances séparées par des virgules.");
                System.out.print("  >> ");
                resistanceCircuit = sc.next();

                tableauDesString = resistanceCircuit.split(SEPARATEUR); // Sépare la String entre les virgules et place les parties dans le tableau des Strings résitors

                for (int i = 0; i < tableauDesString.length; i++) {
                    Resistor r = FabriqueResistor.fabriquerResistor(tableauDesString[i]);
                    if (r != null)
                        circuitSerie.ajouterResistor(r);
                    else
                        messageErreur2 = true; // Erreur détectée
                }
                    if(messageErreur2 != true){
                        System.out.println("Entrez une tension en volts.");
                        System.out.print("  >> ");
                        circuitSerie.mettreSousTension(sc.nextDouble());
                        System.out.println("Résultats => Resistance : " + circuitSerie.calculerResistance() + "Ω Tension : " + circuitSerie.calculerTension() + "V Courant : " + circuitSerie.calculerCourrant() + "A");
                    }
                    else
                        System.out.println(erreur); // Message d'erreur

            }
            if (choixCircuit.charAt(0) == 'P') { // Il s'agit d'un circuit en paralelle
                messageErreur = false; // Aucune erreur est détectée
                System.out.println("Entrez des résistances séparées par des virgules.");
                System.out.print("  >> ");
                resistanceCircuit = sc.next();

                tableauDesString = resistanceCircuit.split(SEPARATEUR); // Sépare la String entre les virgules et les places dans un tableau

                for (int i = 0; i < tableauDesString.length; i++) {
                    Resistor r = FabriqueResistor.fabriquerResistor(tableauDesString[i]);
                    if (r != null)
                        circuitParallele.ajouterResistor(r);
                    else
                        messageErreur2 = true; // Erreur détectée
                }
                if (messageErreur2 != true){
                    System.out.println("Entrez une tension en volts.");
                    System.out.print("  >> ");
                    circuitParallele.mettreSousTension(sc.nextDouble());
                    System.out.println("Résultats => Resistance : " + circuitParallele.calculerResistance() + "Ω Tension : " + circuitParallele.calculerTension() + "V Courant : " + circuitParallele.calculerCourrant() + "A");
                }
                else
                    System.out.println(erreur); // Message d'erreur
            }
            if(messageErreur == true){
                System.out.println(erreur); // Message d'erreur
            }
        }while(true);
    }
}

// Main Laboratoire 2
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
