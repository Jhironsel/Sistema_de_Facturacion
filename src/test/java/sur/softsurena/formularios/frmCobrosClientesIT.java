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
public class frmCobrosClientesIT {
    
    public frmCobrosClientesIT() {
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
     * Test of getNombreCajero method, of class frmCobrosClientes.
     */
    @Test
    public void testGetNombreCajero() {
        System.out.println("getNombreCajero");
        frmCobrosClientes instance = null;
        String expResult = "";
        String result = instance.getNombreCajero();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreCajero method, of class frmCobrosClientes.
     */
    @Test
    public void testSetNombreCajero() {
        System.out.println("setNombreCajero");
        String nombreCajero = "";
        frmCobrosClientes instance = null;
        instance.setNombreCajero(nombreCajero);
    }

    /**
     * Test of getIdTurno method, of class frmCobrosClientes.
     */
    @Test
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        frmCobrosClientes instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTurno method, of class frmCobrosClientes.
     */
    @Test
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        int idTurno = 0;
        frmCobrosClientes instance = null;
        instance.setIdTurno(idTurno);
    }
    
}
