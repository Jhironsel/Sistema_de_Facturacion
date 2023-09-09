import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteCommand {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("lsblk -o NAME,UUID");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Imprime cada línea de salida
            }
            process.waitFor(); // Espera a que termine el proceso
            process.destroy(); // Destruye el proceso

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
