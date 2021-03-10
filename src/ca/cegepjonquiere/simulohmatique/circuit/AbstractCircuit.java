// Importation package
package ca.cegepjonquiere.simulohmatique.circuit;

// Classe ''ca.cegepjonquiere.circuit.Circuit''
public abstract class AbstractCircuit implements IComposant {

    // Attributs
    protected double tension;

    // Création d'un tableau qui contient tous mes Résisteurs
    protected IComposant tableauResistors[] = new IComposant[20];

    // Permet de compter et placer correctement le nombre de résisteurs dans mon tableau
    private int nbDefois = 0;

    // Constructeur ''ca.cegepjonquiere.circuit.Circuit'' basic
    public AbstractCircuit() {
    }

    // Méthodes

    public void ajouterComposant(IComposant r){
        tableauResistors[nbDefois] = r;
        nbDefois++;
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

    public abstract void specifierCourant(double courant); // Jamais utilisé

    // Méthode toString
    public String toString() {
        return "(" + calculerResistance() + " Ω, " + calculerTension() + " V, " + calculerCourant() + " A)";
    }
}

