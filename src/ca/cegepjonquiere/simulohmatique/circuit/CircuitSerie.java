// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;

import javax.swing.*;

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
    public void mettreSousTension(double tension) throws CircuitOuvert{
        this.tension = tension;
        if (!composants.isEmpty()){
            for (IComposant composant : composants) {
                composant.mettreSousTension(composant.calculerResistance() * calculerCourant());
            }
        }
        else // Il n'y aucun résisteur
            throw new CircuitOuvert("!!! Le circuit est ouvert !!!");
    }
}
