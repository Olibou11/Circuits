// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.processor.ObjectRowWriterProcessor;

import java.util.HashMap;
import java.util.Map;

// Classe ''ca.cegepjonquiere.circuit.CircuitSerie''
public class CircuitSerie extends AbstractCircuit {

    // Constructeur basic
    public CircuitSerie(){
    }

    // Méthodes redéfinies

    @Override
    public double calculerResistance(){
        double resistance = 0;
        for (IComposant composant : tableauResistors) {
            if (composant != null) // Vérifie s'il s'agit d'un résistor
                resistance = resistance + composant.calculerResistance();
        }
        return resistance;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (IComposant composant : tableauResistors) {
            if (composant != null) { // Vérifie s'il s'agit d'un résistor
                composant.mettreSousTension(composant.calculerResistance() * calculerCourant());
            }
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {

        Map<IComposant, Integer> map = new HashMap<>();

        for (IComposant resistor: tableauResistors) {
            
        }
    }
}
