// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations

import ca.cegepjonquiere.simulohmatique.resistor.FabriqueResistor;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;

import java.util.Stack;

// Classe ''FabriqueCircuit''
public class FabriqueCircuit {

    public static AbstractCircuit fabriquerCircuit(String description) throws IllegalArgumentException {

        // Création des différents paquets
        Stack<Character> parenthese = new Stack<>();
        Stack<AbstractCircuit> circuits = new Stack<>();

        // Variables utilent pour le .split
        final String SEPARATEUR = " ";
        String[] descriptionSplit;

        // Variables utilent pour la fabrication du circuit
        Resistor resistor;
        AbstractCircuit lastPop = null;

        // Split de la description
        descriptionSplit = description.split(SEPARATEUR);

        // Boucle qui vérifie et qui crée le circuit
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
                        throw new IllegalArgumentException("Erreur parenthèse");
                    parenthese.pop();
                    lastPop = circuits.pop();
                    break;

                case "[":
                    CircuitParallele p = new CircuitParallele();
                    if (!circuits.empty())
                        circuits.peek().ajouterComposant(p);
                    circuits.push(p);
                    parenthese.push('[');
                    break;

                case "]":
                    if (parenthese.empty() || parenthese.peek() != '[')
                        throw new IllegalArgumentException("Erreur parenthèse");
                    parenthese.pop();
                    lastPop = circuits.pop();
                    break;

                default:
                    resistor = FabriqueResistor.fabriquerResistor(descriptionSplit[i]);
                    if(resistor.getResistance() > 0)
                        circuits.peek().ajouterComposant(resistor);
                    else
                        throw new IllegalArgumentException("Court circuit, un résistor est null");
                    break;
            }
        }
        if (parenthese.empty()) // S'il ne reste plus de parenthèse dans la description
            return lastPop;
        else
            throw new IllegalArgumentException("Erreur les parenthèses ne sont pas fermé");
    }
}
