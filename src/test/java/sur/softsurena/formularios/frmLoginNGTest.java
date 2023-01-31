package sur.softsurena.formularios;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author jhironsel
 */
public class frmLoginNGTest {
    
    public frmLoginNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of main method, of class frmLogin.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        frmLogin login = new frmLogin("jhironsel", "123uasd");
        login.setVisible(true);
        assertEquals(login.isVisible(), true);
    }
    
}
