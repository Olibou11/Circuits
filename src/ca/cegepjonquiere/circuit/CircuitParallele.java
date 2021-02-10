// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends Circuit {

    // Constructeur basic
    public CircuitParallele(){
    }

    // Méthodes

    public double calculerResistance() { // Calcul la résistance total
        double resistanceInverse = 0;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Vérifie s'il s'agit d'un Résiteur
                resistanceInverse += (1 / tableauResistors[i].getResistance());
            }
        }
        return 1 / resistanceInverse;
    }

    public double calculerCourrant(){
        return calculerTension() / calculerResistance();
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ca.cegepjonquiere.circuit.CircuitParallele{" +
                '}';
    }
}
