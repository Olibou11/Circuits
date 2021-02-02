// Classe Resistor
public class Resistor {

    // Attributs
    private double resistance;
    private double tolerance;

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

    // Méthode toString
    @Override
    public String toString() {
        return "Resistor{" +
                "resistance=" + resistance +
                ", tolerance=" + tolerance +
                '}';
    }
}
