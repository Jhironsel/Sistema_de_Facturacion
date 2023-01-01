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
public class frmDetalleFacturaClientesIT {
    
    public frmDetalleFacturaClientesIT() {
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
     * Test of tablaClientes method, of class frmDetalleFacturaClientes.
     */
    @Test
    public void testTablaClientes() {
        System.out.println("tablaClientes");
        frmDetalleFacturaClientes instance = new frmDetalleFacturaClientes();
        instance.tablaClientes();
    }
    
}
