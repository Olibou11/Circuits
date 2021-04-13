// Importation package
package ca.cegepjonquiere.simulohmatique.tests;

// Importations
import ca.cegepjonquiere.simulohmatique.circuit.*;
import ca.cegepjonquiere.simulohmatique.resistor.Resistor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//Classe ''FabriqueCircuitTest''
public class FabriqueCircuitTest {

    @Test
    public void fabriquerCircuitTest() throws Exception {

        // Création des résistors
        Resistor rA = new Resistor(10, 0.05);
        Resistor rB = new Resistor(30, 0.05);
        Resistor rC = new Resistor(40, 0.05);
        Resistor rD = new Resistor(30, 0.05);
        Resistor rE = new Resistor(50, 0.05);
        Resistor rF = new Resistor(75, 0.05);
        Resistor rG = new Resistor(150, 0.05);
        Resistor rH = new Resistor(30, 0.05);

        // Création des circuits

        AbstractCircuit ss1 = new CircuitSerie();
        ss1.ajouterComposant(rA);
        ss1.ajouterComposant(rB);

        AbstractCircuit ss2 = new CircuitParallele();
        ss2.ajouterComposant(ss1);
        ss2.ajouterComposant(rC);

        AbstractCircuit ss3 = new CircuitSerie();
        ss3.ajouterComposant(ss2);
        ss3.ajouterComposant(rD);

        AbstractCircuit ss4 = new CircuitParallele();
        ss4.ajouterComposant(ss3);
        ss4.ajouterComposant(rE);

        AbstractCircuit ss5 = new CircuitSerie();
        ss5.ajouterComposant(ss4);
        ss5.ajouterComposant(rF);

        AbstractCircuit ss6 = new CircuitParallele();
        ss6.ajouterComposant(ss5);
        ss6.ajouterComposant(rG);

        AbstractCircuit ss7 = new CircuitSerie();
        ss7.ajouterComposant(ss6);
        ss7.ajouterComposant(rH);
        ss7.mettreSousTension(600);

        AbstractCircuit circuitTotal = FabriqueCircuit.fabriquerCircuit("( [ ( [ ( [ ( BNNo ONNo ) JNNo ] ONNo ) VNNo ] MVNo ) BVBo ] ONNo )");

        circuitTotal.mettreSousTension(600);

        assertEquals(circuitTotal, ss7);
    }

    @Test
    public void exeptionFabriquerCircuit(){

        assertThrows(IllegalArgumentException.class, () -> FabriqueCircuit.fabriquerCircuit("( BVBo")); //Manque une parenthèse à la fin du String
        assertThrows(IllegalArgumentException.class, () -> FabriqueCircuit.fabriquerCircuit("[ BVBo")); // Manque un crochet à la fin du Srting
        assertThrows(IllegalArgumentException.class, () -> FabriqueCircuit.fabriquerCircuit("] BVBo")); // Débute avec un ccrochet fermante
        assertThrows(IllegalArgumentException.class, () -> FabriqueCircuit.fabriquerCircuit(") BVBo")); // Débute avec une parenthèse fermante
       // assertThrows(IllegalArgumentException.class, () -> FabriqueCircuit.fabriquerCircuit("BVbo")); // Aucune parenthèse


    }
}
