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
public class frmDetalleQuitarEliminarIT {
    
    public frmDetalleQuitarEliminarIT() {
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
     * Test of getOpcion method, of class frmDetalleQuitarEliminar.
     */
    @Test
    public void testGetOpcion() {
        System.out.println("getOpcion");
        frmDetalleQuitarEliminar instance = null;
        int expResult = 0;
        int result = instance.getOpcion();
        assertEquals(expResult, result);
    }

    /**
     * Test of setOpcion method, of class frmDetalleQuitarEliminar.
     */
    @Test
    public void testSetOpcion() {
        System.out.println("setOpcion");
        int opcion = 0;
        frmDetalleQuitarEliminar instance = null;
        instance.setOpcion(opcion);
    }
    
}
