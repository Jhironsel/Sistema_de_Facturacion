package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import sur.softsurena.formularios.frmClientes;
import sur.softsurena.formularios.frmProductos;

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
            //Evento para productos.
            addEventListener("addProducto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla();
            });
            
            addEventListener("del_Producto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla();
            });
            
            addEventListener("upd_Producto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla();
            });
            
            //Evento para personas.
            addEventListener("ins_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("del_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("upd_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });    
            
            //Evento para personas clientes.
            addEventListener("ins_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("del_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });
            
            addEventListener("upd_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes();
            });    
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
