// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends AbstractCircuit {

    // Constructeur ''ca.cegepjonquiere.circuit.CircuitSerie'' basic
    public CircuitSerie(){
    }

    // Méthodes redéfinies

    @Override
    public void specifierCourant(double courant) { // Jamais utilisé
    }

    @Override
    public double calculerResistance(){ // Calcul la résistance totale
        double resistance = 0;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) // Vérifie s'il s'agit d'un Résisteur
                resistance = resistance + tableauResistors[i].calculerResistance();
        }
        return resistance;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (int i = 0; i < tableauResistors.length; i++) {
            if (tableauResistors[i] != null) { // Pas de résistors null
                tableauResistors[i].mettreSousTension(tableauResistors[i].calculerResistance() * calculerCourant());
            }
        }
    }
}
