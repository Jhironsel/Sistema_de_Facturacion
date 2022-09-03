package sur.softsurena.Test.SistemaBebida1;

import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sur.softsurena.formularios.frmLogin;

public class SistemaBebida1Test {

    private static int resp;

    private static frmLogin l;
    private static Scanner dime;
    
    @BeforeClass
    public static void principios() throws InterruptedException{
        System.out.println("BeforeClass");
        l = new frmLogin();
        l.setVisible(true);
        dime = new Scanner(System.in);
        Thread.sleep(3000);
    }
    
    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @Test
    public void dime() {
        System.out.println("Test");
        assertTrue("No se ve el formulario", l.isVisible());
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }
    
    @AfterClass
    public static void finales(){
        System.out.println("AfterClass");
//        System.out.println("Ingresa 1 si lo ves, 2 si no puedes verlo:");
//        resp = dime.nextInt();
//        assertEquals("No pudiste ver el formuario.", 1, resp);
//        l = null;
    }
}
