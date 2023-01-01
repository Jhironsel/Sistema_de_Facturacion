package sur.softsurena.formularios;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhironsel
 */
public class frmSelectorArchivoIT {
    
    public frmSelectorArchivoIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getArchivo method, of class frmSelectorArchivo.
     */
    @Test
    public void testGetArchivo() {
        System.out.println("getArchivo");
        frmSelectorArchivo instance = null;
        String expResult = "";
        String result = instance.getArchivo();
        assertEquals(expResult, result);
    }
    
}
