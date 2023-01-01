package sur.softsurena.formularios;

import java.awt.event.ActionEvent;
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
public class frmFacturasIT {
    
    public frmFacturasIT() {
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
     * Test of isTemporal method, of class frmFacturas.
     */
    @Test
    public void testIsTemporal() {
        System.out.println("isTemporal");
        frmFacturas instance = new frmFacturas();
        boolean expResult = false;
        boolean result = instance.isTemporal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTemporal method, of class frmFacturas.
     */
    @Test
    public void testSetTemporal() {
        System.out.println("setTemporal");
        boolean temporal = false;
        frmFacturas instance = new frmFacturas();
        instance.setTemporal(temporal);
    }

    /**
     * Test of getIdCliente method, of class frmFacturas.
     */
    @Test
    public void testGetIdCliente() {
        System.out.println("getIdCliente");
        frmFacturas instance = new frmFacturas();
        Integer expResult = null;
        Integer result = instance.getIdCliente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdCliente method, of class frmFacturas.
     */
    @Test
    public void testSetIdCliente() {
        System.out.println("setIdCliente");
        Integer idCliente = null;
        frmFacturas instance = new frmFacturas();
        instance.setIdCliente(idCliente);
    }

    /**
     * Test of getTurno method, of class frmFacturas.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        frmFacturas instance = new frmFacturas();
        int expResult = 0;
        int result = instance.getTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTurno method, of class frmFacturas.
     */
    @Test
    public void testSetTurno() {
        System.out.println("setTurno");
        int turno = 0;
        frmFacturas instance = new frmFacturas();
        instance.setTurno(turno);
    }

    /**
     * Test of getIdUsuario method, of class frmFacturas.
     */
    @Test
    public void testGetIdUsuario() {
        System.out.println("getIdUsuario");
        frmFacturas instance = new frmFacturas();
        Integer expResult = null;
        Integer result = instance.getIdUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdUsuario method, of class frmFacturas.
     */
    @Test
    public void testSetIdUsuario() {
        System.out.println("setIdUsuario");
        Integer idUsuario = null;
        frmFacturas instance = new frmFacturas();
        instance.setIdUsuario(idUsuario);
    }

    /**
     * Test of run method, of class frmFacturas.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        frmFacturas instance = new frmFacturas();
        instance.run();
    }

    /**
     * Test of actionPerformed method, of class frmFacturas.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        frmFacturas instance = new frmFacturas();
        instance.actionPerformed(e);
    }
    
}
