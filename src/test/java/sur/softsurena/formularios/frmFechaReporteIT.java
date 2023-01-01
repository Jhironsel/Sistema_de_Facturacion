package sur.softsurena.formularios;

import java.sql.Date;
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
public class frmFechaReporteIT {
    
    public frmFechaReporteIT() {
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
     * Test of getFecha method, of class frmFechaReporte.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        frmFechaReporte instance = null;
        Date expResult = null;
        Date result = instance.getFecha();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFecha method, of class frmFechaReporte.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        frmFechaReporte instance = null;
        instance.setFecha(fecha);
    }
    
}
