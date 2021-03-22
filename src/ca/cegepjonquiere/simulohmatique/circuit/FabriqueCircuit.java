// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations
import ca.cegepjonquiere.simulohmatique.resistor.FabriqueResistor;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;
import java.util.Stack;

// Classe ''FabriqueCircuit''
public class FabriqueCircuit {

    public static AbstractCircuit fabriquerCircuit(String description){

        // Création des différents paquets
        Stack<Character> parenthese = new Stack<>();
        Stack<AbstractCircuit> circuits = new Stack<>();

        // Variables
        final String SEPARATEUR = " ";
        String[] descriptionSplit;
        Resistor resistor;
        AbstractCircuit lastPop = null;

        descriptionSplit = description.split(SEPARATEUR); // Tableau des sections de la chaine qui est la description

        for (int i = 0; i < descriptionSplit.length; i++) {

            switch (descriptionSplit[i]) {

                case "(":
                    CircuitSerie s = new CircuitSerie();
                    if (!circuits.empty())
                        circuits.peek().ajouterComposant(s);
                    circuits.push(s);
                    parenthese.push('(');
                    break;

                case ")":
                    if (parenthese.empty() || parenthese.peek() != '(')
                        return null;
                    parenthese.pop();
                    lastPop = circuits.pop();
                    break; // Les erreurs ne font rien ''break''

                case "[":
                    CircuitParallele p = new CircuitParallele();
                    if (!circuits.empty())
                        circuits.peek().ajouterComposant(p);
                    circuits.push(p);
                    parenthese.push('[');
                    break;

                case"]":
                    if (parenthese.empty() || parenthese.peek() != '[')
                        return null;
                    parenthese.pop();
                    lastPop = circuits.pop();
                    break;

                default:
                    resistor = FabriqueResistor.fabriquerResistor(descriptionSplit[i]);
                    if (resistor != null)
                        circuits.peek().ajouterComposant(resistor);
                    break;
            }
        }
        return lastPop;
    }
}
