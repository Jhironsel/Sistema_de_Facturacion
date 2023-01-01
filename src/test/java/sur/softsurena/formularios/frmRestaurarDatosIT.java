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
public class frmRestaurarDatosIT {
    
    public frmRestaurarDatosIT() {
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
     * Test of run method, of class frmRestaurarDatos.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        frmRestaurarDatos instance = new frmRestaurarDatos();
        instance.run();
    }

    /**
     * Test of iniciarHilo method, of class frmRestaurarDatos.
     */
    @Test
    public void testIniciarHilo() {
        System.out.println("iniciarHilo");
        frmRestaurarDatos instance = new frmRestaurarDatos();
        instance.iniciarHilo();
    }
    
}
