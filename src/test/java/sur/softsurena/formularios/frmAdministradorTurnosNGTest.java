package sur.softsurena.formularios;

import javax.swing.JTable;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sur.softsurena.conexion.Conexion;

/**
 *
 * @author jhironsel
 */
@Test(enabled = false)
public class frmAdministradorTurnosNGTest {

    public frmAdministradorTurnosNGTest() {
    }

    @BeforeClass
    public void setUpClass() throws Exception {
        Conexion.getInstance(
                "sysdba",
                "1",
                "SoftSurena.db",
                "localhost",
                "3050"
        );
        assertTrue(
                Conexion.verificar().getEstado(),
                "Error al conectarse..."
        );
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        Conexion.getCnn().close();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(
            enabled = false,
            priority = 0,
            description = """
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmAdministradorTurnos.getInstance(),
                "Error al cargar frmAdministradorTurnos."
        );
    }

    @Test(
            enabled = false,
            priority = 1,
            description = """
                          """
    )
    public void testCrearReporte() {
        String userName = "sysdba";
        
        JTable result = frmAdministradorTurnos.crearReporte(userName);
        
        assertNotNull(
                result,
                "Tabla de crear reporte de usuario no instanciada."
        );
        
        assertFalse(
                result.getRowCount() > 0,
                "No existe registros en el formulario."
        );
    }

}
