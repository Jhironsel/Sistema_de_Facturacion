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
public class frmGastoIT {
    
    public frmGastoIT() {
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
     * Test of getIdTurno method, of class frmGasto.
     */
    @Test
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        frmGasto instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTurno method, of class frmGasto.
     */
    @Test
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        int idTurno = 0;
        frmGasto instance = null;
        instance.setIdTurno(idTurno);
    }

    /**
     * Test of getUsuario method, of class frmGasto.
     */
    @Test
    public void testGetUsuario() {
        System.out.println("getUsuario");
        frmGasto instance = null;
        String expResult = "";
        String result = instance.getUsuario();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsuario method, of class frmGasto.
     */
    @Test
    public void testSetUsuario() {
        System.out.println("setUsuario");
        String usuario = "";
        frmGasto instance = null;
        instance.setUsuario(usuario);
    }
    
}
