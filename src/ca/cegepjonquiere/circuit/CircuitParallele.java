// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends Circuit {

    // Attributs
    private double resistanceInverse = 0;

    // Constructeur basic
    public CircuitParallele(){
    }

    // Méthodes

    public double calculerResistance() { // Calcul la résistance total
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Vérifie s'il s'agit d'un Résiteur
                resistanceInverse =+ (1 / tableauResistors[i].getResistance());
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
                "resistanceInverse=" + resistanceInverse +
                '}';
    }
}
