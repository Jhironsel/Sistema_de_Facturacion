package sur.softsurena.FirebirdEventos;

import java.sql.SQLException;
import java.util.logging.Level;
import org.firebirdsql.event.DatabaseEvent;
import org.firebirdsql.event.FBEventManager;
import sur.softsurena.formularios.frmClientes;
import sur.softsurena.formularios.frmProductos;
import sur.softsurena.formularios.frmUsuarios;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class FirebirdEventos extends FBEventManager{
    
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
            //Evento para productos.
            addEventListener("add_Producto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla("evento");
            });
            
            addEventListener("del_Producto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla("evento");
            });
            
            addEventListener("upd_Producto", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmProductos.llenarTabla("evento");
            });
            
            //Evento para personas.
            addEventListener("ins_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1,"evento");
            });
            
            addEventListener("del_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1, "evento");
            });
            
            addEventListener("upd_persona", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1, "evento");
            });    
            
            //Evento para personas clientes.
            addEventListener("ins_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1, "evento");
            });
            
            addEventListener("del_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1, "evento");
            });
            
            addEventListener("upd_persona_clientes", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmClientes.llenarTablaClientes(-1, "evento");
            });
            
            //Eventos de usuario.
            addEventListener("INSERT_USUARIOS", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmUsuarios.llenarTabla();
            });
            addEventListener("DELETE_USUARIOS", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmUsuarios.llenarTabla();
            });
            addEventListener("UPDATE_USUARIOS", (DatabaseEvent event) -> {
                LOG.log(Level.INFO, "Event [{0}] occured {1} time(s)", new Object[]{event.getEventName(), event.getEventCount()});
                frmUsuarios.llenarTabla();
            });
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            return false;
        }
        return true;
    }
}
