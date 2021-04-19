// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;
import java.util.Objects;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends AbstractCircuit {

    // Constructeur basic
    public CircuitParallele() {
    }

    // Méthodes redéfinie

    @Override
    public double calculerResistance() {
        return 1 / composants.stream().filter(Objects::nonNull).mapToDouble(IComposant::calculerResistance).sum();
    }

    @Override
    public void mettreSousTension(double tension) throws CircuitOuvert {
        this.tension = tension;
        if (!composants.isEmpty())
            for (IComposant composant : composants) {
                composant.mettreSousTension(tension);
        }
        else // Il n'y a aucun résisteur
            throw new CircuitOuvert("!!! Le circuit est ouvert !!!");
    }
}
