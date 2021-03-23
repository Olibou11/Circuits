// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Classe ''ca.cegepjonquiere.circuit.CircuitParallele''
public class CircuitParallele extends AbstractCircuit {

    // Constructeur basic
    public CircuitParallele() {
    }

    // Méthodes redéfinie

    @Override
    public double calculerResistance() {
        double resistanceInverse = 0;
        for (IComposant composant : tableauResistors) {
            if (composant != null) // Vérifie s'il s'agit d'un résistor
                resistanceInverse += (1 / composant.calculerResistance());
        }
        return 1 / resistanceInverse;
    }

    @Override
    public void mettreSousTension(double tension){
        this.tension = tension;
        for (IComposant composant : tableauResistors) {
            if(composant != null) // Vérifie s'il s'agit d'un résistor
                    composant.mettreSousTension(tension);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
