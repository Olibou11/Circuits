// Importation package
package ca.cegepjonquiere.simulohmatique.tests;

// Importations des classes
import ca.cegepjonquiere.simulohmatique.circuit.CircuitParallele;
import ca.cegepjonquiere.simulohmatique.circuit.CircuitSerie;
import ca.cegepjonquiere.simulohmatique.circuit.IComposant;
import ca.cegepjonquiere.simulohmatique.circuit.exeption.CircuitOuvert;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;

// Importation du plugin junit
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Classe ''CircuitTest''
public class CircuitTest {

    // Attribut
    private Resistor[] res;

    // Tests

    @Test
    public void serieTest() throws CircuitOuvert {
        CircuitSerie p1 = new CircuitSerie();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(24);

        assertEquals(29, p1.calculerResistance(), 0.1);
        assertEquals(0.827, p1.calculerCourant(), 0.1);
        assertEquals(24, p1.calculerTension(), 0.1);
    }

    @Test
    public void paralleleTest() throws CircuitOuvert {
        CircuitParallele p1 = new CircuitParallele();
        for (Resistor r : res)
            p1.ajouterComposant(r);

        p1.mettreSousTension(120);

        assertEquals(1.518, p1.calculerResistance(), 0.1);
        assertEquals(79.05, p1.calculerCourant(), 0.1);
        assertEquals(120, p1.calculerTension(), 0.1);
    }

    @BeforeEach
    public void setUpResistors() {
        res = new Resistor[4];
        res[0] = new Resistor(5, 0.1);
        res[0].setResistance(5);
        res[1] = new Resistor(4, 0.1);
        res[1].setResistance(4);
        res[2] = new Resistor(12, 0.1);
        res[2].setResistance(12);
        res[3] = new Resistor(8, 0.1);
        res[3].setResistance(8);
    }

    @Test
    public void exeptionCircuit(){

        IComposant cicuit = new CircuitSerie(); // Création d'un circuit qui n'a pas de composant, ainsi il est ouvert

        assertThrows(CircuitOuvert.class, () -> cicuit.mettreSousTension(120));
    }
}
