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
public class hiloIpIT {
    
    public hiloIpIT() {
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
     * Test of run method, of class hiloIp.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        hiloIp instance = new hiloIp();
        instance.run();
    }

    /**
     * Test of detener method, of class hiloIp.
     */
    @Test
    public void testDetener() {
        System.out.println("detener");
        hiloIp instance = new hiloIp();
        instance.detener();
    }

    /**
     * Test of iniciar method, of class hiloIp.
     */
    @Test
    public void testIniciar() {
        System.out.println("iniciar");
        hiloIp instance = new hiloIp();
        instance.iniciar();
    }

    /**
     * Test of correr method, of class hiloIp.
     */
    @Test
    public void testCorrer() {
        System.out.println("correr");
        hiloIp instance = new hiloIp();
        instance.correr();
    }
    
}
