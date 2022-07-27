package sur.softsurena.Test.SistemaBebida1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SistemaBebida1Test {
    
    public SistemaBebida1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass()");
        assertEquals("Iniciamos",0,0);
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
        assertEquals("Iniciamos",0,0);
    }
    
    @Before
    public void setUp() {
        System.out.println("setUp()");
        assertEquals("Iniciamos",0,0);
    }
    
    @After
    public void tearDown() {
        System.out.println("tearDown()");
        assertEquals("Iniciamos",0,0);
    }
    
    @Test
    public void dime(){
        assertEquals("Iniciamos",0,0);
    }

}
