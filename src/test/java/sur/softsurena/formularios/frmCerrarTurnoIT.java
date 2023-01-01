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
public class frmCerrarTurnoIT {
    
    public frmCerrarTurnoIT() {
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
     * Test of getIdTurno method, of class frmCerrarTurno.
     */
    @Test
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        frmCerrarTurno instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTurno method, of class frmCerrarTurno.
     */
    @Test
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        int idTurno = 0;
        frmCerrarTurno instance = null;
        instance.setIdTurno(idTurno);
    }

    /**
     * Test of isAceptar method, of class frmCerrarTurno.
     */
    @Test
    public void testIsAceptar() {
        System.out.println("isAceptar");
        frmCerrarTurno instance = null;
        boolean expResult = false;
        boolean result = instance.isAceptar();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAceptar method, of class frmCerrarTurno.
     */
    @Test
    public void testSetAceptar() {
        System.out.println("setAceptar");
        boolean aceptar = false;
        frmCerrarTurno instance = null;
        instance.setAceptar(aceptar);
    }
    
}
