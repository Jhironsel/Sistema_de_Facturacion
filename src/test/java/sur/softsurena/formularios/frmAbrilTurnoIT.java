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
public class frmAbrilTurnoIT {
    
    public frmAbrilTurnoIT() {
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
     * Test of isAceptar method, of class frmAbrilTurno.
     */
    @Test
    public void testIsAceptar() {
        System.out.println("isAceptar");
        frmAbrilTurno instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptar();
        assertEquals(expResult, result);
    }
    
}
