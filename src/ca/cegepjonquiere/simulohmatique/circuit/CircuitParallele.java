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
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Vérifie s'il s'agit d'un Résiteur
                resistanceInverse += (1 / tableauResistors[i].calculerResistance());
            }
        }
        return 1 / resistanceInverse;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Pas de résistors null
                tableauResistors[i].mettreSousTension(tension);
            }
        }
    }
}
