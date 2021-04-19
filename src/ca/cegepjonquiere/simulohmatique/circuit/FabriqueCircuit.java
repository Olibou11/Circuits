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

        if (descriptionSplit[0].equals("(") || descriptionSplit[0].equals("[")) {

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
                            throw new IllegalArgumentException("!!! Dans le circuit, une erreur dans les crochets s'est produite !!!");
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
                            throw new IllegalArgumentException("!!! Dans le circuit, une erreur dans les crochets s'est produite !!!");
                        parenthese.pop();
                        lastPop = circuits.pop();
                        break;

                    default:
                        resistor = FabriqueResistor.fabriquerResistor(descriptionSplit[i]);
                        if (resistor.getResistance() > 0)
                            circuits.peek().ajouterComposant(resistor);
                        else // Le résisteur fabriqué est null = 0
                            throw new IllegalArgumentException("!!! Un court circuit s'est produit: Le résisteur " + resistor + " est null !!!");
                        break;
                }
            }
            if (parenthese.empty()) // S'il ne reste plus de parenthèse dans la description
                return lastPop;
            else
                throw new IllegalArgumentException("!!! Une parenthèse dans le circuit n'est pas fermée !!!");
        }
        else
            throw new IllegalArgumentException("!!! Aucune parenthèse ou aucun crochet n'est présent dans la description du circuit !!!");
    }
}
