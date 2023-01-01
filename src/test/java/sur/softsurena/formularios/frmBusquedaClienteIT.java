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
public class frmBusquedaClienteIT {
    
    public frmBusquedaClienteIT() {
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
     * Test of getRespuesta method, of class frmBusquedaCliente.
     */
    @Test
    public void testGetRespuesta() {
        System.out.println("getRespuesta");
        frmBusquedaCliente instance = null;
        String expResult = "";
        String result = instance.getRespuesta();
        assertEquals(expResult, result);
    }
    
}
