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
public class frmPrintFacturaConReporteIT {
    
    public frmPrintFacturaConReporteIT() {
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
     * Test of getCopia method, of class frmPrintFacturaConReporte.
     */
    @Test
    public void testGetCopia() {
        System.out.println("getCopia");
        frmPrintFacturaConReporte2 instance = null;
        boolean expResult = false;
        boolean result = instance.getCopia();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCopia method, of class frmPrintFacturaConReporte.
     */
    @Test
    public void testSetCopia() {
        System.out.println("setCopia");
        boolean copia = false;
        frmPrintFacturaConReporte2 instance = null;
        instance.setCopia(copia);
    }
    
}
