package sur.softsurena.Test.Grafico;

import java.io.File;
import java.io.IOException;
import xy.ui.testing.Tester;
import xy.ui.testing.editor.TestEditor;

public class TestSwingConexion {

    private TestSwingConexion() {
    }

    public static void main(String[] args) throws IOException, Exception {
        final String parametros[] = {
            "testSwing/testParametros.stt" //0
        };
        final String moduloClientes[] = {
            "testSwing/testProvinciaMunicipioDistrito.stt", // 0
            "testSwing/testInsertCliente.stt", // 1
            "testSwing/testUpdateCliente.stt", // 2
            "testSwing/testBorrarCliente.stt" // 3
        };
        final String moduloProductos[] = {
            "testSwing/testInsertProducto.stt", // 0
            "testSwing/testUpdateProducto.stt", // 1
            "testSwing/testDeleteProducto.stt" // 2
        };
        final String moduloUsuario[] = {
            "testSwing/testInsertUsuario.stt" // 0
        };
        //Crear un objecto de la clase Tester
        Tester tester = new Tester();
        //Ejecutar una sola prueba
        tester.loadFromFile(new File(moduloClientes[1]));
        //Asserts that the given test specification file gets load and executed successfully.
//        for (String file : moduloUsuario) {
//            TestingUtils.assertSuccessfulReplay(new File(file));
//        }
        //The main window that allows to edit and execute test specifications.
        TestEditor testEditor = new TestEditor(tester);
        //Abre el editor
        testEditor.open();
        //Closes all the windows except the test editor windows 
        //related to the given tester instance
        //TestingUtils.closeAllTestableWindows(tester);

        //Deletes the directory where all reports are stored.
        //TestingUtils.purgeAllReportsDirectory();

        //Toca las pruebas automaticamente.
        //tester.replayAll();
    }
}
