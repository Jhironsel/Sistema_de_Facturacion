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
public class frmBuscarTemporalIT {
    
    public frmBuscarTemporalIT() {
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
     * Test of getFactura method, of class frmBuscarTemporal.
     */
    @Test
    public void testGetFactura() {
        System.out.println("getFactura");
        frmBuscarTemporal instance = null;
        String expResult = "";
        String result = instance.getFactura();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFactura method, of class frmBuscarTemporal.
     */
    @Test
    public void testSetFactura() {
        System.out.println("setFactura");
        String factura = "";
        frmBuscarTemporal instance = null;
        instance.setFactura(factura);
    }

    /**
     * Test of isAceptar method, of class frmBuscarTemporal.
     */
    @Test
    public void testIsAceptar() {
        System.out.println("isAceptar");
        frmBuscarTemporal instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAceptar method, of class frmBuscarTemporal.
     */
    @Test
    public void testSetAceptar() {
        System.out.println("setAceptar");
        boolean aceptar = false;
        frmBuscarTemporal instance = null;
        instance.setAceptar(aceptar);
    }
    
}
