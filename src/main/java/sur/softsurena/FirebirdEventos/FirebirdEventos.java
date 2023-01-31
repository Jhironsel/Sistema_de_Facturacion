package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import sur.softsurena.formularios.frmClientes;

public class FirebirdEventos extends FBEventManager{

    private static final Logger LOG = Logger.getLogger(FirebirdEventos.class.getName());
    
    public synchronized boolean registro(
            String user, 
            String clave, 
            String dominio, 
            String pathBaseDatos, 
            int puerto) {
        setUser(user);
        setPassword(clave);
        setHost(dominio);
        setDatabase(pathBaseDatos);
        setPort(puerto);
        
        try {
            if(isConnected()){
                disconnect();
            }
            connect();
            
            addEventListener("addProducto", (DatabaseEvent event) -> {
                LOG.info(
                        "Event [" + event.getEventName() + "] occured "
                                + event.getEventCount() + " time(s)");
            });

            addEventListener("ins_persona", (DatabaseEvent event) -> {
                LOG.info("Event ["
                        + event.getEventName() + "] occured "
                        + event.getEventCount() + " time(s)");
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("del_persona", (DatabaseEvent event) -> {
                LOG.info("Event ["
                        + event.getEventName() + "] occured "
                        + event.getEventCount() + " time(s)");
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("upd_persona", (DatabaseEvent event) -> {
                LOG.info("Event ["
                        + event.getEventName() + "] occured "
                        + event.getEventCount() + " time(s)");
                frmClientes.llenarTablaClientes();
            });         
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
