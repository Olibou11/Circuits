// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends AbstractCircuit {

    // Constructeur basic
    public CircuitSerie(){
    }

    // Méthodes redéfinies

    @Override
    public double calculerResistance(){
        double resistance = 0;
        for (IComposant composant : composants) {
            if (composant != null) // Vérifie s'il s'agit d'un résistor
                resistance = resistance + composant.calculerResistance();
        }
        return resistance;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (IComposant composant : composants) {
            if (composant != null) { // Vérifie s'il s'agit d'un résistor
                composant.mettreSousTension(composant.calculerResistance() * calculerCourant());
            }
        }
    }
}
