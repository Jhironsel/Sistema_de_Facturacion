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
public class hiloRestaurarIT {
    
    public hiloRestaurarIT() {
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
     * Test of run method, of class hiloRestaurar.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        hiloRestaurar instance = new hiloRestaurar();
        instance.run();
    }

    /**
     * Test of detener method, of class hiloRestaurar.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        hiloRestaurar instance = new hiloRestaurar();
        instance.detener();
    }

    /**
     * Test of iniciar method, of class hiloRestaurar.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        hiloRestaurar instance = new hiloRestaurar();
        instance.iniciar();
    }

    /**
     * Test of correr method, of class hiloRestaurar.
     */
    @Test
    public void testCorrer() {
        System.out.println("correr");
        hiloRestaurar instance = new hiloRestaurar();
        instance.correr();
    }
    
}
