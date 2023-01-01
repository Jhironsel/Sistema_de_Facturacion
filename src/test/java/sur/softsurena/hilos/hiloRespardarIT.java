package sur.softsurena.hilos;

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
public class hiloRespardarIT {
    
    public hiloRespardarIT() {
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
     * Test of run method, of class hiloRespardar.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        hiloRespardar instance = new hiloRespardar();
        instance.run();
    }

    /**
     * Test of iniciar method, of class hiloRespardar.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        hiloRespardar instance = new hiloRespardar();
        instance.iniciar();
    }

    /**
     * Test of detener method, of class hiloRespardar.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        hiloRespardar instance = new hiloRespardar();
        instance.detener();
    }

    /**
     * Test of correr method, of class hiloRespardar.
     */
    @Test
    public void testCorrer() {
        System.out.println("correr");
        hiloRespardar instance = new hiloRespardar();
        instance.correr();
    }
    
}
