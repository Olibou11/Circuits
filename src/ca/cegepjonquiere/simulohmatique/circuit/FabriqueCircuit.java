package ca.cegepjonquiere.simulohmatique.circuit;

import ca.cegepjonquiere.simulohmatique.resistor.FabriqueResistor;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;

import java.util.Stack;

public class FabriqueCircuit {

    public static AbstractCircuit fabriquerCircuit(String description){

        Stack<Character> parenthese = new Stack<>();

        Stack<AbstractCircuit> circuits = new Stack<>();

        final String SEPARATEUR = " ";
        String[] descriptionSplit;
        Resistor resistor;

        AbstractCircuit lastPop = null;

        descriptionSplit = description.split(SEPARATEUR); // Tableau des sections de la chaine qui est la description

        for (int i = 0; i < descriptionSplit.length; i++) {

            switch (descriptionSplit[i].charAt(0)) {

                case '(':
                    CircuitSerie s = new CircuitSerie();
                    circuits.peek().ajouterComposant(s);
                    circuits.push(s);
                    parenthese.push('(');
                    break;

                case ')':
                    if (parenthese.empty() || parenthese.pop() != '(')
                        return null;
                    parenthese.pop();
                    lastPop = circuits.pop();
                    break; // Les erreurs ne font rien ''break''

                case '[':
                    CircuitParallele p = new CircuitParallele();
                    circuits.peek().ajouterComposant(p);
                    circuits.push(p);
                    parenthese.push('[');
                    break;

                case']':
                    if (parenthese.empty() || parenthese.pop() != '[')
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
