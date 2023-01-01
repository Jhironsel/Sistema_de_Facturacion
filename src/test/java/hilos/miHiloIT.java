package hilos;

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
public class miHiloIT {
    
    public miHiloIT() {
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
     * Test of run method, of class miHilo.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        miHilo instance = new miHilo();
        instance.run();
    }

    /**
     * Test of detenElHilo method, of class miHilo.
     */
    @Test
    public void testDetenElHilo() {
        System.out.println("detenElHilo");
        miHilo instance = new miHilo();
        instance.detenElHilo();
    }

    /**
     * Test of iniciarElHilo method, of class miHilo.
     */
    @Test
    public void testIniciarElHilo() {
        System.out.println("iniciarElHilo");
        miHilo instance = new miHilo();
        instance.iniciarElHilo();
    }
    
}
