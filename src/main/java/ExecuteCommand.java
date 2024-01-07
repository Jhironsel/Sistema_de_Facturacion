import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExecuteCommand {

    private static final Logger LOG = Logger.getLogger(ExecuteCommand.class.getName());
    
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("lsblk -o NAME,UUID");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "", aux = "\n";
            while ((line = reader.readLine()) != null) {
                aux += line + "\n";
            }
            LOG.info(aux);
            
            process.waitFor(); // Espera a que termine el proceso
            
            process.destroy(); // Destruye el proceso

        } catch (IOException | InterruptedException e) {
            LOG.log(Level.SEVERE, "Error a leer las UUID del sistema.", e);
        }
    }
}
