// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;
import java.util.Objects;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends AbstractCircuit {

    // Constructeur basic
    public CircuitSerie(){
    }

    // Méthodes redéfinies

    @Override
    public double calculerResistance() {
        return composants.stream().filter(Objects::nonNull).mapToDouble(IComposant::calculerResistance).sum();
    }

    @Override
    public void mettreSousTension(double tension) throws CircuitOuvert{
        this.tension = tension;

        if (!composants.isEmpty()){
            for (IComposant composant : composants) {
                composant.mettreSousTension(composant.calculerResistance() * calculerCourant());
            }
        }
        else // Il n'y aucun résisteur
            throw new CircuitOuvert("!!! Le circuit est ouvert !!!");
    }
}
