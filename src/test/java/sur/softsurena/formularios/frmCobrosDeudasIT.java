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
public class frmCobrosDeudasIT {
    
    public frmCobrosDeudasIT() {
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
     * Test of getNombreCajero method, of class frmCobrosDeudas.
     */
    @Test
    public void testGetNombreCajero() {
        System.out.println("getNombreCajero");
        frmCobrosDeudas instance = null;
        String expResult = "";
        String result = instance.getNombreCajero();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreCajero method, of class frmCobrosDeudas.
     */
    @Test
    public void testSetNombreCajero() {
        System.out.println("setNombreCajero");
        String nombreCajero = "";
        frmCobrosDeudas instance = null;
        instance.setNombreCajero(nombreCajero);
    }

    /**
     * Test of getIdTurno method, of class frmCobrosDeudas.
     */
    @Test
    public void testGetIdTurno() {
        System.out.println("getIdTurno");
        frmCobrosDeudas instance = null;
        int expResult = 0;
        int result = instance.getIdTurno();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIdTurno method, of class frmCobrosDeudas.
     */
    @Test
    public void testSetIdTurno() {
        System.out.println("setIdTurno");
        int idTurno = 0;
        frmCobrosDeudas instance = null;
        instance.setIdTurno(idTurno);
    }
    
}
