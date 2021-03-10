// Importation du package
package ca.cegepjonquiere.simulohmatique.circuit;

// Interface ''IComposant''
public interface IComposant {

    // Méthodes diverses

    void mettreSousTension(double tension);

    double calculerTension();

    void specifierCourant(double courant);

    double calculerCourant();

    double calculerResistance();
}
