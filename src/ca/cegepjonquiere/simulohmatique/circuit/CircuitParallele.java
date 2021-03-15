// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends AbstractCircuit {

    // Constructeur basic
    public CircuitParallele() {
    }

    // Méthodes redéfinie

    @Override
    public void specifierCourant(double courant) {  // Jamais utilisé
    }

    @Override
    public double calculerResistance() { // Calcul la résistance total
        double resistanceInverse = 0;
        for (IComposant composant : tableauResistors) {
            if (composant != null) // Pas de résistors null
                resistanceInverse += (1 / composant.calculerResistance());
        }
        return 1 / resistanceInverse;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (IComposant composant : tableauResistors) {
            if(composant != null) // Pas de résistors null
                    composant.mettreSousTension(tension);
        }
    }
}
