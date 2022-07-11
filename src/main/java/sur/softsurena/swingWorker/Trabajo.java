package sur.softsurena.swingWorker;

import java.util.List;
import javax.swing.SwingWorker;
import sur.softsurena.formularios.frmLogin;
import static sur.softsurena.formularios.frmSplash.pgProceso;

public class Trabajo extends SwingWorker<Double, Integer> {

    private String estado, usuario, clave;
    private int perfil;
    private frmLogin login;

    public int getPerfil() {
        return perfil;
    }
    public final void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getUsuario() {
        return usuario;
    }
    public final void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }
    public final void setClave(String clave) {
        this.clave = clave;
    }

    public frmLogin getLogin() {
        return login;
    }
    private void setLogin(frmLogin login) {
        this.login = login;
    }
    
    
    
    public Trabajo(int Perfil, 
            String usuario, String clave, frmLogin login) {
        
        setPerfil(Perfil);
        setUsuario(usuario);
        setClave(clave);
        setLogin(login);        
    }
    
    @Override
    protected Double doInBackground() throws Exception {
        
        
        publish(4);
        estado = "Cargando Formulario principal";
        
        
        publish(10);
        estado = "Cargando Clientes";
        
        
        publish(13);
        estado = "Cargando Productos";
        
        publish(20);
        estado = "Cargando Usuarios";
        
        publish(25);
        estado = "Cargado Reporte Factura";
        
        publish(28);
        estado = "Turnos Cargados";
        
        publish(29);
        estado = "Limpiando";
        
        publish(35);
        estado = "Formulario de Turno";
        
        publish(41);
        estado = "Leyendo Turno y formulario Deudas";
        
        publish(59);
        estado = "Inventario y Categoria Listo";
        
        
        publish(74);
        estado = "Cargando Sistema Bebida Factura...";
        
        publish(89);
        estado = "Cargando Sistema Bebida Factura...";
        
        publish(96);
        estado = "Cargando Sistema Bebida Factura...";
        return 100.0;
    }
    @Override
    protected void process(List<Integer> chunks) {
        pgProceso.setValue(chunks.get(0));
        pgProceso.setString("" + chunks.get(0) + " %" +"      "+estado);
    }
    @Override
    protected void done() {
        
        pgProceso.setValue(100);
        //Maximizar la ventana
    }
}