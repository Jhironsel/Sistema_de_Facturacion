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
public class frmAlmacenesNGTest {

    public frmAlmacenesNGTest() {
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
            enabled = true,
            priority = 0,
            description = """
                          Verifica que se puede realizar una instancia de frmAlmacenes.
                          """
    )
    public void testGetInstance() {
        assertNotNull(
                frmAlmacenes.getInstance(),
                "Error al obtener la instancia de frmAlmacenes"
        );
    }

    @Test(
            enabled = true,
            description = "",
            priority = 1
    )
    public void testLlenarTabla() {
        int id = 0;
        String criterioBusqueda = "";
        JTable tabla = frmAlmacenes.llenarTabla(id, criterioBusqueda);
        
        assertNotNull(
                tabla,
                "La tabla de almacenes no contiene datos."
        );
        
        assertEquals(
                tabla.getRowCount(),
                0,
                "La tabla contiene registros en el sistema."
        );
    }

}