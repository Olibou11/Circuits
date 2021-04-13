// Importation du package
package ca.cegepjonquiere.simulohmatique.tests;

// Importations de classes
import ca.cegepjonquiere.simulohmatique.resistor.FabriqueResistor;

// Importations du plugin junit
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Classe ''FabriqueResistorTest''
public class FabriqueResistorTest {

    // Tests

    @Test
    void fromCodeQuatreResistance() throws Exception {
        assertEquals(270, FabriqueResistor.fabriquerResistor("RMBo").getResistance());
        assertEquals(1200000, FabriqueResistor.fabriquerResistor("BRVo").getResistance());
    }

    @Test
    void fromCodeCinqResistance() throws Exception {
        assertEquals(270, FabriqueResistor.fabriquerResistor("RMNNA").getResistance());
        assertEquals(100000, FabriqueResistor.fabriquerResistor("BNNOB").getResistance());
        assertEquals(274, FabriqueResistor.fabriquerResistor("RMJNR").getResistance());
        assertEquals(10000, FabriqueResistor.fabriquerResistor("BNNRB").getResistance());
        assertEquals(35.2, FabriqueResistor.fabriquerResistor("OVRoo").getResistance());
    }

    @Test
    void fromCodeQuatreTolerance() {
        assertEquals(0.05, FabriqueResistor.fabriquerResistor("RMBo").getTolerance());
    }

    @Test
    void fromCodeCinqTolerance() {
        assertEquals(0.1, FabriqueResistor.fabriquerResistor("RMNNA").getTolerance());
    }



    @Test
    public void exeptionFabriquerResistor(){
        assertThrows(IllegalArgumentException.class, () -> FabriqueResistor.fabriquerResistor("1234")); // La séquence de couleurs contient des nombres
        assertThrows(IllegalArgumentException.class, () -> FabriqueResistor.fabriquerResistor("BNoooo")); // La séquence de couleurs est trop longue, soit de 7 couleurs
        assertThrows(IllegalArgumentException.class, () -> FabriqueResistor.fabriquerResistor("BNo")); // La séquence de couleurs est trop courte, soit de 3 couleurs
        assertThrows(IllegalArgumentException.class, () -> FabriqueResistor.fabriquerResistor("")); // La séquence est null
    }
}
