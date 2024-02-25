package sur.softsurena.formularios;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class frmLoginNGTest {
    
    public frmLoginNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
    }

    @AfterClass
    public void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            description = "",
            priority = 0
    )
    public void testMain() {
        String[] args = null;
        frmLogin.main(args);
        
    }

    @Test(
            enabled = true,
            description = "",
            priority = 1
    )
    public void testTestClase() {
        frmLogin instance = new frmLogin("es");
        assertTrue(
                instance.testClase(), 
                "No se cargó correctamente el formulario."
        );
    }
}
