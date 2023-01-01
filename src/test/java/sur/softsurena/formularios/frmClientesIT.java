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
public class frmClientesIT {
    
    public frmClientesIT() {
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
     * Test of llenarTablaClientes method, of class frmClientes.
     */
    @Test
    public void testLlenarTablaClientes() {
        System.out.println("llenarTablaClientes");
        frmClientes.llenarTablaClientes();
    }
    
}
