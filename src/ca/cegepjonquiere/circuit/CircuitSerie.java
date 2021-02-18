// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends AbstractCircuit {

    // Constructeur ''ca.cegepjonquiere.circuit.CircuitSerie'' basic
    public CircuitSerie(){
    }

    // Méthode
    @Override
    public double calculerResistance(){ // Calcul la résistance totale
        double resistance = 0;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) // Vérifie s'il s'agit d'un Résisteur
                resistance = resistance + tableauResistors[i].getResistance();
        }
        return resistance;
    }

    // Méthode toString
    @Override
    public String toString() {
        double tensions;
        String string = "";
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null){ // Pas de résistors null
                tensions = tableauResistors[i].getResistance() * calculerCourant();
                string += "(" + tableauResistors[i].getResistance() + " Ω, " + tensions + " V, " + (tensions / tableauResistors[i].getResistance()) + "), ";
            }
        }
        return string;
    }
}
