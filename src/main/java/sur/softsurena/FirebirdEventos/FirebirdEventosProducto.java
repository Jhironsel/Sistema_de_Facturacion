package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import sur.softsurena.formularios.frmProductos;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class FirebirdEventosProducto extends FBEventManager{
    
    //TODO Crear una clase para encapsular estos parametros.
    public synchronized boolean registro(String user, String clave, 
            String dominio, String pathBaseDatos, int puerto) {
        setUser(user);
        setPassword(clave);
//        setHost(dominio); //Han sido sustituido para futura versiones de JayBird
        setServerName(dominio);
        
//        setDatabase(pathBaseDatos);
        setDatabaseName(pathBaseDatos);
        
//        setPort(puerto);
        setPortNumber(puerto);
        
        try {
            if(!isConnected()){
                connect();
            }
            
            addEventListener("add_Producto", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO, 
                        "Event [{0}] occured {1} time(s)", 
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                frmProductos.llenarTabla("evento");
            });
            
            addEventListener("del_Producto", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO, 
                        "Event [{0}] occured {1} time(s)", 
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                frmProductos.llenarTabla("evento");
            });
            
            addEventListener("upd_Producto", (DatabaseEvent event) -> {
                LOG.log(
                        Level.INFO, 
                        "Event [{0}] occured {1} time(s)", 
                        new Object[]{event.getEventName(), event.getEventCount()}
                );
                frmProductos.llenarTabla("evento");
            });
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
