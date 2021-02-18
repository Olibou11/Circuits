// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends AbstractCircuit {

    // Constructeur basic
    public CircuitParallele() {
    }

    // Méthode
    @Override
    public double calculerResistance() { // Calcul la résistance total
        double resistanceInverse = 0;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Vérifie s'il s'agit d'un Résiteur
                resistanceInverse += (1 / tableauResistors[i].getResistance());
            }
        }
        return 1 / resistanceInverse;
    }

    // Méthode toString
    @Override
    public String toString() {
        double tension = calculerTension();
        String string = "";
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Pas de résistors null
                string += "(" + tableauResistors[i].getResistance() + " Ω, " + tension + " V, " + (tension / tableauResistors[i].getResistance()) + "A), ";
            }
        }
        return string;
    }
}
