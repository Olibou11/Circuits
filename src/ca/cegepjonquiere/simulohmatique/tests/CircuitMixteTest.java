// Importation package
package ca.cegepjonquiere.simulohmatique.tests;

// Importations des classes
import ca.cegepjonquiere.simulohmatique.circuit.AbstractCircuit;
import ca.cegepjonquiere.simulohmatique.circuit.CircuitParallele;
import ca.cegepjonquiere.simulohmatique.circuit.CircuitSerie;
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;

// Importations du plugin junit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Classe ''CircuitMixteTest''
public class CircuitMixteTest {

    // Attribut
    private Resistor[] res;

    // Méthode de test

    @Test
    public void mixteTest() throws CircuitOuvert {
        res = new Resistor[4];
        res[0] = new Resistor(5, 0.1);
        res[0].setResistance(5);
        res[1] = new Resistor(8, 0.1);
        res[1].setResistance(8);
        res[2] = new Resistor(8, 0.1);
        res[2].setResistance(8);
        res[3] = new Resistor(6, 0.1);
        res[3].setResistance(6);

        // Création du circuit ''ss1''
        AbstractCircuit ss1 = new CircuitParallele();
        ss1.ajouterComposant(res[1]);
        ss1.ajouterComposant(res[2]);

        // Création circuit ''circuit''
        AbstractCircuit circuit = new CircuitSerie();
        circuit.ajouterComposant(res[0]);
        circuit.ajouterComposant(ss1);
        circuit.ajouterComposant(res[3]);

        // Allume le circuit
        circuit.mettreSousTension(60);

        // Test pour le circuit
        assertEquals(15, circuit.calculerResistance(), 0.001);
        assertEquals(60, circuit.calculerTension(), 0.001);
        assertEquals(4, circuit.calculerCourant(), 0.001);

        // Test pour le resistor 1
        assertEquals(5, res[0].calculerResistance(), 0.001);
        assertEquals(20, res[0].calculerTension(), 0.001);
        assertEquals(4, res[0].calculerCourant(), 0.001);

        // Test pour le resistor 2
        assertEquals(8, res[1].calculerResistance(), 0.001);
        assertEquals(16, res[1].calculerTension(), 0.001);
        assertEquals(2, res[1].calculerCourant(), 0.001);

        // Test pour le resistor 3
        assertEquals(8, res[2].calculerResistance(), 0.001);
        assertEquals(16, res[2].calculerTension(), 0.001);
        assertEquals(2, res[2].calculerCourant(), 0.001);

        // Test pour le resistor 4
        assertEquals(6, res[3].calculerResistance(), 0.001);
        assertEquals(4, res[3].calculerCourant(), 0.001);
        assertEquals(4, res[3].calculerCourant(), 0.001);

        // Test pour le circuit ss1
        assertEquals(4, ss1.calculerResistance(), 0.001);
        assertEquals(16, ss1.calculerTension(), 0.001);
        assertEquals(4, ss1.calculerCourant(), 0.001);
    }
}
