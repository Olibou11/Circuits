// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;

import java.util.ArrayList;
import java.util.Objects;

// Classe ''ca.cegepjonquiere.circuit.Circuit''
public abstract class AbstractCircuit implements IComposant {

    // Attributs
    protected double tension;

    // Création d'une liste qui contient tous mes Résisteurs
    protected ArrayList<IComposant> composants = new ArrayList<IComposant>();


    // Constructeur basic
    public AbstractCircuit() {
    }

    // Méthodes

    public void ajouterComposant(IComposant r){
        composants.add(r);
    }

    public void mettreSousTension(double tension) throws CircuitOuvert {
            this.tension = tension;
    }

    public double calculerTension(){
        return tension;
    }

    public abstract double calculerResistance();

    public double calculerCourant(){
        return calculerTension() / calculerResistance();
        }

    // Méthodes redéfinies de Equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCircuit circuit = (AbstractCircuit) o;
        return composants.equals(circuit.composants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(composants);
    }

    // Méthode toString
    public String toString(){
        String string = ""; // String vide
        for (IComposant composant : composants) {
            if (composant != null){
                string += "(" + composant.calculerResistance() + " Ω, " + composant.calculerTension() + " V, " + composant.calculerCourant() + "A), ";
            }
        }
        return string + " Circuit Total: " + "(" + calculerResistance() + " Ω, " + calculerTension() + " V, " + calculerCourant() + "A) " + "\n";
    }
}