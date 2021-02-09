// Importation package
package ca.cegepjonquiere.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends Circuit {

    // Attributs
    private double resistance = 0;
    private double courant;

    // Constructeur ''ca.cegepjonquiere.circuit.CircuitSerie'' basic
    public CircuitSerie(){
    }

    // Méthodes

    public double calculerResistance(){ // Calcul la résistance totale
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
                "resistance=" + resistance +
                '}';
    }
}
