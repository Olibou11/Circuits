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
    void fromCodeQuatreTolerance() throws Exception {
        assertEquals(5, FabriqueResistor.fabriquerResistor("RMBo").getTolerance());
    }

    @Test
    void fromCodeCinqTolerance() throws Exception {
        assertEquals(10, FabriqueResistor.fabriquerResistor("RMNNA").getTolerance());
    }

    @Test
    void fromCodeInvalid() throws Exception {
        assertNull(FabriqueResistor.fabriquerResistor(""));
        assertNull(FabriqueResistor.fabriquerResistor("NoNono"));
        assertNull(FabriqueResistor.fabriquerResistor("oBbo"));
        assertNull(FabriqueResistor.fabriquerResistor("XZXZZ"));
        assertNull(FabriqueResistor.fabriquerResistor("RMNNL"));
    }

    @Test
    void fromCodeNull() throws Exception {
        assertNull(FabriqueResistor.fabriquerResistor(null));
    }
}
