// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends Circuit {

    // Constructeur ''ca.cegepjonquiere.circuit.CircuitSerie'' basic
    public CircuitSerie(){
    }

    // Méthodes

    public double calculerResistance(){ // Calcul la résistance totale
        double resistance = 0;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) // Vérifie s'il s'agit d'un Résisteur
                resistance = resistance + tableauResistors[i].getResistance();
        }
        return resistance;
    }

    public double calculerCourrant(){
        return calculerTension() / calculerResistance();
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ca.cegepjonquiere.circuit.CircuitSerie{" +
                '}';
    }
}
