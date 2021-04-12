// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;

import java.util.EmptyStackException;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends AbstractCircuit {

    // Constructeur basic
    public CircuitParallele() {
    }

    // Méthodes redéfinie

    @Override
    public double calculerResistance() {
        double resistanceInverse = 0;
        for (IComposant composant : composants) {
            if (composant != null) // Vérifie s'il s'agit d'un résistor
                resistanceInverse += (1 / composant.calculerResistance());
        }
        return 1 / resistanceInverse;
    }

    @Override
    public void mettreSousTension(double tension) throws CircuitOuvert {
        this.tension = tension;
        if (!composants.isEmpty())
            for (IComposant composant : composants) {
                composant.mettreSousTension(tension);
        }
        else
            throw new CircuitOuvert("Il n'y a aucun résistor / circuit ouvert");
    }
}
