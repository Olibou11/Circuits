// Importation package
package ca.cegepjonquiere.simulohmatique.resistor;
import ca.cegepjonquiere.simulohmatique.circuit.IComposant;

// Classe ''ca.cegepjonquiere.resistor.Resistor''
public class Resistor implements IComposant {

    // Attributs
    private double resistance;
    private double tolerance;
    private double tension;

    // Constructeur
    public Resistor(double resistance, double tolerance) {
        this.resistance = resistance;
        this.tolerance = tolerance;
    }

    // Méthodes accesseurs et mutateurs

    public double getResistance() {
        return resistance;
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getTolerance() {
        return tolerance;
    }

    public void setTolerance(double tolerance) {
        this.tolerance = tolerance;
    }

    // Méthodes redéfinies

    @Override
    public void mettreSousTension(double tension) {
        this.tension = tension;
    }

    @Override
    public double calculerTension() {
        return tension;
    }

    @Override
    public void specifierCourant(double courant) {

    }

    @Override
    public double calculerCourant() {
        return tension / resistance;
    }

    @Override
    public double calculerResistance() {
        return resistance;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ca.cegepjonquiere.resistor.Resistor{" +
                "resistance=" + resistance +
                ", tolerance=" + tolerance +
                '}';
    }
}
