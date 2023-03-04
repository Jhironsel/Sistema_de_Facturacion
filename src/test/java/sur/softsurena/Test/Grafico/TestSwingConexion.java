package sur.softsurena.Test.Grafico;

import java.io.File;
import java.io.IOException;
import xy.ui.testing.Tester;
import xy.ui.testing.editor.TestEditor;
import xy.ui.testing.util.TestingUtils;

public class TestSwingConexion {

    private TestSwingConexion() {}

    public static void main(String[] args) throws IOException, Exception {

        final String parametros = "testSwing/testParametros.stt";
        final String moduloClientes[] = {
            "testSwing/testProvinciaMunicipioDistrito.stt",
            "testSwing/testInsertCliente.stt",
            "testSwing/testUpdateCliente.stt",
            "testSwing/testBorrarCliente.stt"
        };
        
        final String moduloProductos[] = {
            "testSwing/testInsertProducto.stt"
        };
        
        //Crear un objecto de la clase Tester
        Tester tester = new Tester();
        
        
        //Ejecutar una sola prueba
//        tester.loadFromFile(new File(files[1]));
        
        //Asserts that the given test specification file gets load and executed successfully.
        for (String file : moduloClientes) {
           TestingUtils.assertSuccessfulReplay(new File(file));
        }
        
        //The main window that allows to edit and execute test specifications.
        TestEditor testEditor = new TestEditor(tester);

        //Closes all the windows except the test editor windows 
        //related to the given tester instance
        TestingUtils.closeAllTestableWindows(tester);
        
        //Deletes the directory where all reports are stored.
        TestingUtils.purgeAllReportsDirectory();

        //Abre el editor
        testEditor.open();
        
        //Toca las pruebas automaticamente.
        //tester.replayAll();
    }
}