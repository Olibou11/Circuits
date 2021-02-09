// Importation package
package ca.cegepjonquiere.circuit;

// Importation
import ca.cegepjonquiere.resistor.Resistor;

// Classe ''ca.cegepjonquiere.circuit.Circuit''
public class Circuit {

    // Attributs
    private double tension;

    // Création d'un tableau qui contient tous mes Résisteurs
    protected Resistor tableauResistors[] = new Resistor[20];

    // Permet de compter et placer correctement le nombre de résisteurs dans mon tableau
    private int nbDefois = 0;

    // Constructeur ''ca.cegepjonquiere.circuit.Circuit'' basic
    public Circuit() {
    }

// Méthodes

    public void ajouterResistor(Resistor r){
        tableauResistors[nbDefois] = r;
        nbDefois++;
    }

    public void mettreSousTension(double tension){
            this.tension = tension;
    }

    public double calculerTension(){
        return tension;
    }
}

