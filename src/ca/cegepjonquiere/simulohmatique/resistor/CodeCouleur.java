// Importation package
package ca.cegepjonquiere.simulohmatique.resistor;

// Enum ''ca.cegepjonquiere.resistor.CodeCouleur''
public enum CodeCouleur {
    N (0, 1, 0) , // Noir
    B (1, 10, 1) , // Brun
    R (2, 100, 2) , // Rouge
    O (3, 1000, 3) , // Orange
    J (4, 10000, 4) , // Jaune
    V (5, 100000, 0.5) , // Vert
    b (6, 1000000, 0.25) , // bleu
    M (7, 10000000, 0.1) , // Mauve
    G (8, 100000000, 0.05) , // Gris
    L (9, 1000000000, 0) , // Blanc
    A (0,0.01, 10) , // Argent
    o (0, 0.1, 5) ; // Or

    // Attributs privés
    private final int valeur;
    private final double multiplicateur;
    private final double tolerance;

    // Constructeur
    CodeCouleur(int valeur, double multiplication, double tolerance){
        this.valeur = valeur;
        this.multiplicateur = multiplication;
        this.tolerance = tolerance;

    }

    // Méthodes accesseurs et mutateurs

    public double getMultiplicateur() {
        return multiplicateur;
    }

    public int getValeur() {
        return valeur;
    }

    public double getTolerance() {
        return tolerance;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "ca.cegepjonquiere.resistor.CodeCouleur{" +
                "valeur=" + valeur +
                ", multiplicateur=" + multiplicateur +
                ", tolerance=" + tolerance +
                '}';
    }
}
