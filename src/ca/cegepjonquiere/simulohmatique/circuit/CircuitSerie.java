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
        for (IComposant composant : tableauResistors) {
            if (composant != null) // Vérifie s'il s'agit d'un Résisteur
                resistance = resistance + composant.calculerResistance();
        }
        return resistance;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (IComposant composant : tableauResistors) {
            if (composant != null) { // Pas de résistors null
                composant.mettreSousTension(composant.calculerResistance() * calculerCourant());
            }
        }
    }
}
