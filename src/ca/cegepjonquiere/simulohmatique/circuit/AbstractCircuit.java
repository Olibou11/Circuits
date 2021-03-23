// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Importations
import java.util.ArrayList;

// Classe ''ca.cegepjonquiere.circuit.Circuit''
public abstract class AbstractCircuit implements IComposant {

    // Attributs
    protected double tension;

    // Création d'une liste qui contient tous mes Résisteurs
    protected ArrayList<IComposant> tableauResistors = new ArrayList<IComposant>();


    // Constructeur basic
    public AbstractCircuit() {
    }

    // Méthodes

    public void ajouterComposant(IComposant r){
        tableauResistors.add(r);
    }

    public void mettreSousTension(double tension){
            this.tension = tension;
    }

    public double calculerTension(){
        return tension;
    }

    public abstract double calculerResistance();

    public double calculerCourant(){
        return calculerTension() / calculerResistance();
        }

    // Méthode toString
    public String toString(){
        String string = ""; // String vide
        for (IComposant composant : tableauResistors) {
            if (composant != null){
                string += "(" + composant.calculerResistance() + " Ω, " + composant.calculerTension() + " V, " + composant.calculerCourant() + "A), ";
            }
        }
        return string + " Circuit Total: " + "(" + calculerResistance() + " Ω, " + calculerTension() + " V, " + calculerCourant() + "A) " + "\n";
    }
}