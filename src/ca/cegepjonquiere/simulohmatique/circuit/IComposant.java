// Importation du package
package ca.cegepjonquiere.simulohmatique.circuit;

import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;

// Interface ''IComposant''
public interface IComposant {

    // Méthodes diverses

    void mettreSousTension(double tension) throws CircuitOuvert;

    double calculerTension();

    double calculerCourant();

    double calculerResistance();
}
