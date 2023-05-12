package sur.softsurena.formularios;

import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import lombok.NonNull;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import sur.softsurena.entidades.Roles;
import sur.softsurena.entidades.Usuarios;
import sur.softsurena.entidades.DesktopConFondo;
import sur.softsurena.hilos.hiloIp;
import sur.softsurena.hilos.hiloRestaurar;
import sur.softsurena.jfilechooser.ImageFileView;
import sur.softsurena.jfilechooser.ImageFilter;
import sur.softsurena.jfilechooser.ImagePreview;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.Utilidades;
//Conexiones a la base de datos.
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.entidades.E_S_SYS.getLogo;
import static sur.softsurena.entidades.E_S_SYS.insertLogo;
import static sur.softsurena.entidades.Roles.comprobandoRol;
import static sur.softsurena.entidades.Turnos.usuarioTurnoActivo;
import static sur.softsurena.entidades.Usuarios.getUsuarioActual;

public final class frmPrincipal extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(frmPrincipal.class.getName());
    private Imagenes icono;

    //Formularios Modales
    private frmFechaReporte fechaReporte;

    public frmPrincipal() {
        initComponents();

        //Hacemos la consulta a la base de datos, para saber cual es el usuario
        //y el rol del usuario conectado a la base de datos.
        Usuarios u = getUsuarioActual();        
        jlUser.setText(u.getUser_name());
        
        //Proceso para cargar los roles del usuario al sistema.
        cbRoles.removeAllItems();
        cbRoles.setToolTipText("Rol actual: "+u.getRol());
        
        cbRoles.addItem(Roles.builder().
                propietario("SYSDBA").
                roleName("None").
                descripcion("Rol que indica que no ha sido establecido").
                build()
        );
        
        comprobandoRol(jlUser.getText().strip()).stream().forEach(rolItem ->{
            cbRoles.addItem(rolItem);
        });
        
        for (int i = 0; i < cbRoles.getItemCount(); i++) {
            if(cbRoles.getItemAt(i).toString().strip().equalsIgnoreCase(u.getRol())){
                cbRoles.setSelectedIndex(i);
                break;
            }
            if(u.getRol().strip().equalsIgnoreCase("RDB$ADMIN") & 
                    cbRoles.getItemAt(i).toString().strip().equalsIgnoreCase("ADMINISTRADOR")){
                cbRoles.setSelectedIndex(i);
                break;
            }
        }
        
        jMenuBar1.add(filler3,5);
        jMenuBar1.add(jlUser, 6);
        jMenuBar1.add(liWork, 7);
        jMenuBar1.add(cbRoles, 8);

        jPanelImpresion.setVisible(false);

        icono = new Imagenes();

        cargarIconos();
        cargarLogo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanelImpresion = new javax.swing.JPanel();
        jLabelImpresion = new javax.swing.JLabel();
        jprImpresion = new javax.swing.JProgressBar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        Archivos = new javax.swing.JMenu();
        jmClientes = new javax.swing.JMenuItem();
        jmProductos = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jmCambioClave = new javax.swing.JMenuItem();
        jmCambioUsuario = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jmSalir = new javax.swing.JMenuItem();
        Movimientos = new javax.swing.JMenu();
        jmNuevaFactura = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jmReporteFactura = new javax.swing.JMenuItem();
        jmInventario = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jmAbrirTurno = new javax.swing.JMenuItem();
        jmCerrarTurno = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jmDeuda = new javax.swing.JMenuItem();
        btnOcultarPanel = new javax.swing.JButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jlUser = new RSMaterialComponent.RSLabelTextIcon();
        liWork = new necesario.LabelIcon();
        cbRoles = new RSMaterialComponent.RSComboBox();
        jsEstatus = new javax.swing.JScrollPane();
        pEstatus = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlLogoEmpresa = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtGanancia = new javax.swing.JFormattedTextField();
        txtCosto = new javax.swing.JFormattedTextField();
        txtVenta = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCajero = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        btnEstablecerEncabezado = new javax.swing.JButton();
        btnSeleccionarImpresora = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlMovimientoES = new javax.swing.JLabel();
        jlGrafica = new javax.swing.JLabel();
        jlGetIP = new javax.swing.JLabel();
        jlRestauracion = new javax.swing.JLabel();
        jlRespaldar = new javax.swing.JLabel();
        jlRestaurar = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        dpnEscritorio = new DesktopConFondo();
        jMenuBar1 = new rojerusan.RSMenuBar();
        mnuArchivos = new javax.swing.JMenu();
        mnuArchivosCliente = new javax.swing.JMenuItem();
        mnuArchivosProductos = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuCambioClave = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosAdministracionPrivilegios = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosCambioUsuario = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        mnuArchivosSalir = new javax.swing.JMenuItem();
        mnuMovimientos = new javax.swing.JMenu();
        mnuMovimientosNuevaFactura = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        mnuMovimientosReporteFactura = new javax.swing.JMenuItem();
        mnuMovimientosInventario = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        mnuMovimientosAbrirTurno = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        mnuMovimientosDeudas = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        mnuAyudaAcercaDe = new javax.swing.JMenuItem();
        mnuAyudaAyuda = new javax.swing.JMenuItem();
        mnuLicencia = new javax.swing.JMenu();

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Quireo verlo");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setText("jLabel9");

        jPanelImpresion.setMaximumSize(new java.awt.Dimension(32767, 30));
        jPanelImpresion.setMinimumSize(new java.awt.Dimension(0, 30));
        jPanelImpresion.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        jLabelImpresion.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelImpresion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelImpresion.setText("Imprimiendo ");
        jLabelImpresion.setMaximumSize(new java.awt.Dimension(120, 25));
        jLabelImpresion.setMinimumSize(new java.awt.Dimension(59, 25));
        jLabelImpresion.setPreferredSize(null);
        jPanelImpresion.add(jLabelImpresion);

        jprImpresion.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jprImpresion.setDoubleBuffered(true);
        jprImpresion.setMaximumSize(new java.awt.Dimension(32767, 30));
        jprImpresion.setMinimumSize(new java.awt.Dimension(0, 30));
        jprImpresion.setStringPainted(true);
        jPanelImpresion.add(jprImpresion);

        Archivos.setText("Archivos");
        Archivos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jmClientes.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmClientes.setText("Clientes");
        jmClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClientesActionPerformed(evt);
            }
        });
        Archivos.add(jmClientes);

        jmProductos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmProductos.setText("Productos");
        jmProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmProductosActionPerformed(evt);
            }
        });
        Archivos.add(jmProductos);
        Archivos.add(jSeparator7);

        jmCambioClave.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmCambioClave.setText("Cambio de Clave");
        jmCambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCambioClaveActionPerformed(evt);
            }
        });
        Archivos.add(jmCambioClave);

        jmCambioUsuario.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmCambioUsuario.setText("Cambio de Usuario");
        jmCambioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCambioUsuarioActionPerformed(evt);
            }
        });
        Archivos.add(jmCambioUsuario);
        Archivos.add(jSeparator8);

        jmSalir.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        Archivos.add(jmSalir);

        jPopupMenu1.add(Archivos);

        Movimientos.setText("Movimientos");
        Movimientos.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N

        jmNuevaFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmNuevaFactura.setText("Nueva Factura");
        jmNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmNuevaFacturaActionPerformed(evt);
            }
        });
        Movimientos.add(jmNuevaFactura);
        Movimientos.add(jSeparator9);

        jmReporteFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmReporteFactura.setText("Reporte de Factura");
        jmReporteFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmReporteFacturaActionPerformed(evt);
            }
        });
        Movimientos.add(jmReporteFactura);

        jmInventario.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmInventario.setText("Inventario");
        jmInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInventarioActionPerformed(evt);
            }
        });
        Movimientos.add(jmInventario);
        Movimientos.add(jSeparator10);

        jmAbrirTurno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmAbrirTurno.setText("Abrir Turno");
        jmAbrirTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAbrirTurnoActionPerformed(evt);
            }
        });
        Movimientos.add(jmAbrirTurno);

        jmCerrarTurno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmCerrarTurno.setText("Cerrar Turno");
        jmCerrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarTurnoActionPerformed(evt);
            }
        });
        Movimientos.add(jmCerrarTurno);
        Movimientos.add(jSeparator11);

        jmDeuda.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jmDeuda.setText("Deuda");
        jmDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDeudaActionPerformed(evt);
            }
        });
        Movimientos.add(jmDeuda);

        jPopupMenu1.add(Movimientos);

        btnOcultarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarPanelActionPerformed(evt);
            }
        });

        jlUser.setForeground(new java.awt.Color(255, 255, 255));
        jlUser.setText("rSLabelTextIcon1");
        jlUser.setSizeIcon(32.0F);

        liWork.setForeground(new java.awt.Color(255, 255, 255));
        liWork.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WORK);
        liWork.setMaximumSize(new java.awt.Dimension(40, 40));
        liWork.setName("liWork"); // NOI18N
        liWork.setOpaque(true);
        liWork.setLayout(new java.awt.GridLayout(1, 0));

        cbRoles.setItemHeight(20);
        cbRoles.setMaximumSize(new java.awt.Dimension(200, 40));
        cbRoles.setMinimumSize(new java.awt.Dimension(50, 30));
        cbRoles.setName("cbRoles"); // NOI18N
        cbRoles.setPreferredSize(new java.awt.Dimension(200, 40));
        cbRoles.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbRolesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ventana principal del sistema");
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setMinimumSize(new java.awt.Dimension(640, 480));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jsEstatus.setPreferredSize(new java.awt.Dimension(270, 560));

        pEstatus.setMinimumSize(new java.awt.Dimension(20, 20));
        pEstatus.setPreferredSize(new java.awt.Dimension(250, 660));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos actuales de la empresa");

        jlLogoEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogoEmpresa.setToolTipText("Doble click para cambiar el logo");
        jlLogoEmpresa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Logo de la empresa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jlLogoEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlLogoEmpresa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlLogoEmpresa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlLogoEmpresaMouseClicked(evt);
            }
        });

        jPanel2.setLayout(new java.awt.GridLayout(3, 1, 0, 5));

        txtGanancia.setEditable(false);
        txtGanancia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ganancias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtGanancia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtGanancia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGanancia.setToolTipText("");
        jPanel2.add(txtGanancia);

        txtCosto.setEditable(false);
        txtCosto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Costo del Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCosto.setToolTipText("");
        jPanel2.add(txtCosto);

        txtVenta.setEditable(false);
        txtVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proyección de venta", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtVenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtVenta.setToolTipText("");
        jPanel2.add(txtVenta);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(267, 70));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(267, 77));

        jtCajero.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtCajero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cajeros Activo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCajero.setMinimumSize(new java.awt.Dimension(267, 70));
        jtCajero.setPreferredSize(new java.awt.Dimension(267, 77));
        jScrollPane1.setViewportView(jtCajero);

        btnEstablecerEncabezado.setText("Encabezado de Factura");
        btnEstablecerEncabezado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstablecerEncabezadoActionPerformed(evt);
            }
        });

        btnSeleccionarImpresora.setText("Impresora del Sistema");
        btnSeleccionarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImpresoraActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(2, 3));

        jlMovimientoES.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlMovimientoES.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlMovimientoES.setToolTipText("Reporte e impresion de Entrada y Salida");
        jlMovimientoES.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlMovimientoES.setDoubleBuffered(true);
        jlMovimientoES.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlMovimientoES.setMaximumSize(new java.awt.Dimension(80, 45));
        jlMovimientoES.setMinimumSize(new java.awt.Dimension(80, 45));
        jlMovimientoES.setPreferredSize(new java.awt.Dimension(80, 38));
        jlMovimientoES.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlMovimientoES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlMovimientoESMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlMovimientoESMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlMovimientoESMouseExited(evt);
            }
        });
        jPanel1.add(jlMovimientoES);

        jlGrafica.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlGrafica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlGrafica.setToolTipText("Obtener la IP Publica del Equipo cuando esta conectada a Internet");
        jlGrafica.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlGrafica.setDoubleBuffered(true);
        jlGrafica.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGrafica.setMaximumSize(new java.awt.Dimension(80, 45));
        jlGrafica.setMinimumSize(new java.awt.Dimension(80, 45));
        jlGrafica.setPreferredSize(new java.awt.Dimension(80, 38));
        jlGrafica.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlGrafica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlGraficaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlGraficaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlGraficaMouseExited(evt);
            }
        });
        jPanel1.add(jlGrafica);

        jlGetIP.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlGetIP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlGetIP.setToolTipText("Obtener la IP Publica del Equipo cuando esta conectada a Internet");
        jlGetIP.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlGetIP.setDoubleBuffered(true);
        jlGetIP.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlGetIP.setMaximumSize(new java.awt.Dimension(80, 45));
        jlGetIP.setMinimumSize(new java.awt.Dimension(80, 45));
        jlGetIP.setPreferredSize(new java.awt.Dimension(80, 38));
        jlGetIP.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlGetIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlGetIPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlGetIPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlGetIPMouseExited(evt);
            }
        });
        jPanel1.add(jlGetIP);

        jlRestauracion.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlRestauracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRestauracion.setToolTipText("Restaurar una base de datos anterior...");
        jlRestauracion.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlRestauracion.setDoubleBuffered(true);
        jlRestauracion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlRestauracion.setMaximumSize(new java.awt.Dimension(80, 45));
        jlRestauracion.setMinimumSize(new java.awt.Dimension(80, 45));
        jlRestauracion.setPreferredSize(new java.awt.Dimension(80, 38));
        jlRestauracion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlRestauracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRestauracionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlRestauracionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlRestauracionMouseExited(evt);
            }
        });
        jPanel1.add(jlRestauracion);

        jlRespaldar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlRespaldar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRespaldar.setToolTipText("Hacer un Respaldo de la Base de Datos...");
        jlRespaldar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlRespaldar.setDoubleBuffered(true);
        jlRespaldar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlRespaldar.setMaximumSize(new java.awt.Dimension(80, 45));
        jlRespaldar.setMinimumSize(new java.awt.Dimension(80, 45));
        jlRespaldar.setPreferredSize(new java.awt.Dimension(80, 38));
        jlRespaldar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlRespaldar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRespaldarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlRespaldarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlRespaldarMouseExited(evt);
            }
        });
        jPanel1.add(jlRespaldar);

        jlRestaurar.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlRestaurar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlRestaurar.setToolTipText("Retaurar la Base de Datos desde un Respaldo");
        jlRestaurar.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlRestaurar.setDoubleBuffered(true);
        jlRestaurar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlRestaurar.setMaximumSize(new java.awt.Dimension(80, 45));
        jlRestaurar.setMinimumSize(new java.awt.Dimension(80, 45));
        jlRestaurar.setPreferredSize(new java.awt.Dimension(80, 38));
        jlRestaurar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jlRestaurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlRestaurarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlRestaurarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlRestaurarMouseExited(evt);
            }
        });
        jPanel1.add(jlRestaurar);

        javax.swing.GroupLayout pEstatusLayout = new javax.swing.GroupLayout(pEstatus);
        pEstatus.setLayout(pEstatusLayout);
        pEstatusLayout.setHorizontalGroup(
            pEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEstatusLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(pEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlLogoEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEstablecerEncabezado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addComponent(btnSeleccionarImpresora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        pEstatusLayout.setVerticalGroup(
            pEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEstatusLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLogoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEstablecerEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSeleccionarImpresora)
                .addGap(0, 0, 0))
        );

        pEstatusLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEstablecerEncabezado, btnSeleccionarImpresora});

        jsEstatus.setViewportView(pEstatus);

        dpnEscritorio.setBackground(new java.awt.Color(0, 102, 102));
        dpnEscritorio.setComponentPopupMenu(jPopupMenu1);
        dpnEscritorio.setPreferredSize(new java.awt.Dimension(510, 531));
        jScrollPane4.setViewportView(dpnEscritorio);

        jMenuBar1.setBackground(new java.awt.Color(58, 66, 226));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        mnuArchivos.setForeground(new java.awt.Color(255, 255, 255));
        mnuArchivos.setMnemonic('A');
        mnuArchivos.setText("Archivos");
        mnuArchivos.setDoubleBuffered(true);
        mnuArchivos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        mnuArchivosCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnuArchivosCliente.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuArchivosCliente.setMnemonic('C');
        mnuArchivosCliente.setText("Clientes ...");
        mnuArchivosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosClienteActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosCliente);

        mnuArchivosProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mnuArchivosProductos.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuArchivosProductos.setMnemonic('P');
        mnuArchivosProductos.setText("Productos ...");
        mnuArchivosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosProductosActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosProductos);
        mnuArchivos.add(jSeparator1);

        mnuCambioClave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        mnuCambioClave.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuCambioClave.setMnemonic('m');
        mnuCambioClave.setText("Cambio de Clave ...");
        mnuCambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCambioClaveActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuCambioClave);
        mnuArchivos.add(jSeparator3);

        mnuArchivosAdministracionPrivilegios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuArchivosAdministracionPrivilegios.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuArchivosAdministracionPrivilegios.setText("Administración de Privilegios...");
        mnuArchivosAdministracionPrivilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosAdministracionPrivilegiosActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosAdministracionPrivilegios);
        mnuArchivos.add(jSeparator12);

        mnuArchivosCambioUsuario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        mnuArchivosCambioUsuario.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuArchivosCambioUsuario.setMnemonic('b');
        mnuArchivosCambioUsuario.setText("Cambio de Usuario ...");
        mnuArchivosCambioUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosCambioUsuarioActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosCambioUsuario);
        mnuArchivos.add(jSeparator2);

        mnuArchivosSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuArchivosSalir.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuArchivosSalir.setText("Salir");
        mnuArchivosSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivosSalirActionPerformed(evt);
            }
        });
        mnuArchivos.add(mnuArchivosSalir);

        jMenuBar1.add(btnOcultarPanel);

        jMenuBar1.add(mnuArchivos);

        mnuMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        mnuMovimientos.setMnemonic('M');
        mnuMovimientos.setText("Movimientos");
        mnuMovimientos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        mnuMovimientosNuevaFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        mnuMovimientosNuevaFactura.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuMovimientosNuevaFactura.setText("Nueva Factura...");
        mnuMovimientosNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosNuevaFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosNuevaFactura);
        mnuMovimientos.add(jSeparator5);

        mnuMovimientosReporteFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        mnuMovimientosReporteFactura.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuMovimientosReporteFactura.setText("Reporte de Facturas...");
        mnuMovimientosReporteFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosReporteFacturaActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosReporteFactura);

        mnuMovimientosInventario.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        mnuMovimientosInventario.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuMovimientosInventario.setText("Inventario...");
        mnuMovimientosInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosInventarioActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosInventario);
        mnuMovimientos.add(jSeparator4);

        mnuMovimientosAbrirTurno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        mnuMovimientosAbrirTurno.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuMovimientosAbrirTurno.setText("Administrador de turnos ...");
        mnuMovimientosAbrirTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosAbrirTurnoActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosAbrirTurno);
        mnuMovimientos.add(jSeparator6);

        mnuMovimientosDeudas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        mnuMovimientosDeudas.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuMovimientosDeudas.setText("Deuda");
        mnuMovimientosDeudas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMovimientosDeudasActionPerformed(evt);
            }
        });
        mnuMovimientos.add(mnuMovimientosDeudas);

        jMenuBar1.add(mnuMovimientos);

        mnuAyuda.setForeground(new java.awt.Color(255, 255, 255));
        mnuAyuda.setMnemonic('y');
        mnuAyuda.setText("Ayuda");
        mnuAyuda.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N

        mnuAyudaAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mnuAyudaAcercaDe.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuAyudaAcercaDe.setText("Acerca de...");
        mnuAyudaAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAcercaDeActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAcercaDe);

        mnuAyudaAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuAyudaAyuda.setFont(new java.awt.Font("FreeSans", 0, 14)); // NOI18N
        mnuAyudaAyuda.setText("Ayuda...");
        mnuAyudaAyuda.setToolTipText("");
        mnuAyudaAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAyudaAyudaActionPerformed(evt);
            }
        });
        mnuAyuda.add(mnuAyudaAyuda);

        jMenuBar1.add(mnuAyuda);

        mnuLicencia.setBackground(new java.awt.Color(255, 255, 0));
        mnuLicencia.setForeground(new java.awt.Color(51, 255, 0));
        mnuLicencia.setMnemonic('L');
        mnuLicencia.setText("Licencia");
        mnuLicencia.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        mnuLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLicenciaActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnuLicencia);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jsEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (mnuArchivosSalir.isEnabled()) {
            mnuArchivosCambioUsuarioActionPerformed(null);
        } else {
            frmAutorizacion miAut = new frmAutorizacion(null, true);
            miAut.setLocationRelativeTo(null);
            miAut.setVisible(true);
            if (miAut.isAceptado()) {
                mnuArchivosCambioUsuarioActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario no valido");
            }
        }

    }//GEN-LAST:event_formWindowClosing
    private void jlLogoEmpresaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlLogoEmpresaMouseClicked
        if (evt.getClickCount() == 1) {
            return;
        }

        int resp = JOptionPane.showConfirmDialog(null,
                "Desea cambiar el logo de la empresa?",
                "Confirmacion!!!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        JFileChooser file = new JFileChooser();

        file.addChoosableFileFilter(new ImageFilter());
        file.setFileView(new ImageFileView());
        file.setAccessory(new ImagePreview(file));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes",
                "jpg", "png", "PNG", "JPG");

        file.setFileFilter(filter);

        resp = file.showOpenDialog(null);

        if (resp == JFileChooser.APPROVE_OPTION) {

            insertLogo(file.getSelectedFile());

            cargarLogo();
            jlLogoEmpresa.validate();
        }
    }//GEN-LAST:event_jlLogoEmpresaMouseClicked
    private void jlGetIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGetIPMouseClicked
//        EventQueue.invokeLater(() -> {
//            new UnlockJFrame().setVisible(true);
//        });        
        hiloIp miIp = new hiloIp();
        miIp.start();
    }//GEN-LAST:event_jlGetIPMouseClicked

    private void jlMovimientoESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMovimientoESMouseClicked
        abrirFormulario(new frmMovimientoEntradaSalida());
    }//GEN-LAST:event_jlMovimientoESMouseClicked

    private void jlRespaldarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRespaldarMouseClicked
        hiloRestaurar miRestaurar = new hiloRestaurar();
        miRestaurar.start();
    }//GEN-LAST:event_jlRespaldarMouseClicked

    private void jlRestaurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarMouseClicked
        JFileChooser miFile = new JFileChooser(System.getProperty("user.dir") + "/Data");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Base de Datos",
                "fbk", "FBK");
        miFile.setFileFilter(filter);

        Integer respuesta = miFile.showOpenDialog(this);

        if (respuesta == JFileChooser.CANCEL_OPTION || respuesta == null) {
            return;
        }//Elegir el backup de la base de datos a restaurar...

        String usuarioMaster = JOptionPane.showInputDialog(null,
                "Inserte el nombre de Usuario: ", "Usuario...",
                JOptionPane.INFORMATION_MESSAGE);

        if (usuarioMaster == null || usuarioMaster.equals("")) {
            return;
        }//Coner el usuario que va a realizar la operacion de back up...
        JPasswordField pf = new JPasswordField();

        Integer claveMaster = JOptionPane.showConfirmDialog(null, pf,
                "Inserte el nombre de Usuario: ", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        pf.requestFocusInWindow();
        if (claveMaster == JOptionPane.CANCEL_OPTION || claveMaster == null) {
            return;
        }//Obtener la clave del usuario a realizar el backup

//        BDR = miFile.getSelectedFile();
//        RGBAK = System.getProperty("user.dir") + "/respaldo/gbak";

    }//GEN-LAST:event_jlRestaurarMouseClicked

    private void jlMovimientoESMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMovimientoESMouseEntered
        jlMovimientoES.setText("Reporte");
    }//GEN-LAST:event_jlMovimientoESMouseEntered

    private void jlMovimientoESMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlMovimientoESMouseExited
        jlMovimientoES.setText("");
    }//GEN-LAST:event_jlMovimientoESMouseExited

    private void jlGetIPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGetIPMouseEntered
        jlGetIP.setText("Ip Publica");
    }//GEN-LAST:event_jlGetIPMouseEntered

    private void jlGetIPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGetIPMouseExited
        jlGetIP.setText("");
    }//GEN-LAST:event_jlGetIPMouseExited

    private void jlRespaldarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRespaldarMouseEntered
        jlRespaldar.setText("Respadar");
    }//GEN-LAST:event_jlRespaldarMouseEntered

    private void jlRespaldarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRespaldarMouseExited
        jlRespaldar.setText("");
    }//GEN-LAST:event_jlRespaldarMouseExited

    private void jlRestaurarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarMouseEntered
        jlRestaurar.setText("Restaurar");
    }//GEN-LAST:event_jlRestaurarMouseEntered

    private void jlRestaurarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestaurarMouseExited
        jlRestaurar.setText("");
    }//GEN-LAST:event_jlRestaurarMouseExited

    private void jlRestauracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestauracionMouseClicked
        frmRestaurarDatos restaurar = new frmRestaurarDatos();
        dpnEscritorio.add(restaurar);
        try {
            restaurar.setMaximum(true);

        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
        }
        restaurar.show();
    }//GEN-LAST:event_jlRestauracionMouseClicked

    private void jlRestauracionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestauracionMouseExited
        jlRestauracion.setText("");
    }//GEN-LAST:event_jlRestauracionMouseExited

    private void jlRestauracionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlRestauracionMouseEntered
        jlRestauracion.setText("Restauración");
    }//GEN-LAST:event_jlRestauracionMouseEntered

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ((DesktopConFondo) dpnEscritorio).setImagen("/sur/softsurena/imagenes/Fondo 1024 x 723.jpg");
    }//GEN-LAST:event_formWindowOpened
    private void jlGraficaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGraficaMouseClicked
        abrirFormulario(new frmGraficos());
    }//GEN-LAST:event_jlGraficaMouseClicked

    private void jlGraficaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGraficaMouseExited
        jlGrafica.setText("");
    }//GEN-LAST:event_jlGraficaMouseExited

    private void jlGraficaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGraficaMouseEntered
        jlGrafica.setText("Graficos");
    }//GEN-LAST:event_jlGraficaMouseEntered

    private void jmClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClientesActionPerformed
        mnuArchivosClienteActionPerformed(evt);
    }//GEN-LAST:event_jmClientesActionPerformed

    private void jmProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmProductosActionPerformed
        mnuArchivosProductosActionPerformed(evt);
    }//GEN-LAST:event_jmProductosActionPerformed

    private void jmCambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCambioClaveActionPerformed
        mnuCambioClaveActionPerformed(evt);
    }//GEN-LAST:event_jmCambioClaveActionPerformed

    private void jmCambioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCambioUsuarioActionPerformed
        mnuArchivosCambioUsuarioActionPerformed(evt);
    }//GEN-LAST:event_jmCambioUsuarioActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        mnuArchivosSalirActionPerformed(evt);
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmNuevaFacturaActionPerformed
        mnuMovimientosNuevaFacturaActionPerformed(evt);
    }//GEN-LAST:event_jmNuevaFacturaActionPerformed

    private void jmReporteFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmReporteFacturaActionPerformed
        mnuMovimientosReporteFacturaActionPerformed(evt);
    }//GEN-LAST:event_jmReporteFacturaActionPerformed

    private void jmInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInventarioActionPerformed
        mnuMovimientosInventarioActionPerformed(evt);
    }//GEN-LAST:event_jmInventarioActionPerformed

    private void jmAbrirTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAbrirTurnoActionPerformed
        mnuMovimientosAbrirTurnoActionPerformed(evt);
    }//GEN-LAST:event_jmAbrirTurnoActionPerformed

    private void jmCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarTurnoActionPerformed

    }//GEN-LAST:event_jmCerrarTurnoActionPerformed

    private void jmDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDeudaActionPerformed
        mnuMovimientosDeudasActionPerformed(evt);
    }//GEN-LAST:event_jmDeudaActionPerformed

    private void btnEstablecerEncabezadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstablecerEncabezadoActionPerformed
//        mensaje();
        frmEncabezado encabezado2 = new frmEncabezado(null, true);
        encabezado2.setLocationRelativeTo(null);
        encabezado2.setVisible(true);

    }//GEN-LAST:event_btnEstablecerEncabezadoActionPerformed

    private void btnSeleccionarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImpresoraActionPerformed
        frmImpresoras2 miImpresora = new frmImpresoras2(null, true);
        miImpresora.setLocationRelativeTo(null);
        miImpresora.setVisible(true);
    }//GEN-LAST:event_btnSeleccionarImpresoraActionPerformed
    private void btnOcultarPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarPanelActionPerformed
        jsEstatus.setVisible(!jsEstatus.isVisible());

        if (jsEstatus.isVisible()) {
            btnOcultarPanel.setIcon(icono.getIcono("Flecha Izquierda 32 x 32.png"));
        } else {
            btnOcultarPanel.setIcon(icono.getIcono("Flecha Derecha 32 x 32.png"));
        }

        pack();
    }//GEN-LAST:event_btnOcultarPanelActionPerformed

    private void mnuArchivosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosClienteActionPerformed
        abrirFormulario(new frmClientes());
    }//GEN-LAST:event_mnuArchivosClienteActionPerformed

    private void mnuArchivosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosProductosActionPerformed
        abrirFormulario(new frmProductos());
    }//GEN-LAST:event_mnuArchivosProductosActionPerformed

    private void mnuCambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCambioClaveActionPerformed
        frmCambioClave cambioClave = new frmCambioClave(this, true);
        cambioClave.setLocationRelativeTo(this);
        cambioClave.setVisible(true);
    }//GEN-LAST:event_mnuCambioClaveActionPerformed

    private void mnuArchivosAdministracionPrivilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosAdministracionPrivilegiosActionPerformed
        abrirFormulario(new frmUsuarios());
    }//GEN-LAST:event_mnuArchivosAdministracionPrivilegiosActionPerformed

    private void mnuArchivosCambioUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosCambioUsuarioActionPerformed

        dispose();
        frmLogin login = new frmLogin("es");
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_mnuArchivosCambioUsuarioActionPerformed

    private void mnuArchivosSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivosSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuArchivosSalirActionPerformed

    private void mnuMovimientosNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosNuevaFacturaActionPerformed
        Usuarios usuarioActual = getUsuarioActual();

        if (!usuarioTurnoActivo(usuarioActual.getUser_name())) {
            JOptionPane.showMessageDialog(
                null,
                "Usuario no cuenta con Turno para Facturar...!",
                "Validación de usuario.",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        abrirFormulario(new frmFacturas());
    }//GEN-LAST:event_mnuMovimientosNuevaFacturaActionPerformed

    private void mnuMovimientosReporteFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosReporteFacturaActionPerformed
        abrirFormularioCentralizado(new frmReporteFacturas());
    }//GEN-LAST:event_mnuMovimientosReporteFacturaActionPerformed

    private void mnuMovimientosInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosInventarioActionPerformed

        fechaReporte = new frmFechaReporte(this, true);

        fechaReporte.setLocationRelativeTo(null);
        fechaReporte.setVisible(true);

        if (fechaReporte.getFecha() == null) {
            return;
        }

        imprimirReporte(fechaReporte.getFecha());
    }//GEN-LAST:event_mnuMovimientosInventarioActionPerformed

    private void mnuMovimientosAbrirTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosAbrirTurnoActionPerformed
        abrirFormulario(new frmAdministradorTurnos());
    }//GEN-LAST:event_mnuMovimientosAbrirTurnoActionPerformed

    private void mnuMovimientosDeudasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMovimientosDeudasActionPerformed
        abrirFormulario(new frmDeudas());
    }//GEN-LAST:event_mnuMovimientosDeudasActionPerformed

    private void mnuAyudaAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAcercaDeActionPerformed
        frmAcercaDe acerca = new frmAcercaDe(null, true);
        acerca.setLocationRelativeTo(this);
        acerca.setVisible(true);
    }//GEN-LAST:event_mnuAyudaAcercaDeActionPerformed

    private void mnuAyudaAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAyudaAyudaActionPerformed

    }//GEN-LAST:event_mnuAyudaAyudaActionPerformed

    private void mnuLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLicenciaActionPerformed

    }//GEN-LAST:event_mnuLicenciaActionPerformed

    private void cbRolesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbRolesPopupMenuWillBecomeInvisible
        String rol = ((Roles) cbRoles.getItemAt(cbRoles.getSelectedIndex())).getRoleName();
        
        rol = (rol.equalsIgnoreCase("ADMINISTRADOR") ? "RDB$ADMIN":rol);
        
        Roles.setRole(rol);
        
        Usuarios u = getUsuarioActual();
        
        jlUser.setText(u.getUser_name());
        
        cbRoles.setToolTipText("Rol actual: "+u.getRol());
    }//GEN-LAST:event_cbRolesPopupMenuWillBecomeInvisible

    private void imprimirReporte(Date fecha) {
        try {
            String miFile = "sur.softsurena.reportes.repSistemaDeBebida.jasper";

            JasperReport masterReporte = (JasperReport) JRLoader.loadObjectFromFile(miFile);

            Map parametros = new HashMap();
            parametros.put("fecha", fecha);

            JasperPrint jp = JasperFillManager.fillReport(masterReporte, parametros, getCnn());

            JasperViewer miView = new JasperViewer(jp, false);
            miView.setTitle("Reporte de movimiento de inventario...");
            miView.setLocationRelativeTo(null);
            miView.setVisible(true);

        } catch (JRException ex) {
            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
        }
    }

    //Funciones que estan en el panel de la Ventana Principal
//    private void estado() {
//        pEstatus.setVisible(true);
//        //Trabajando con Imagen
//        ImageIcon imagen = new ImageIcon();
//        Icon icon;
//
//        ResultSet rs = getConsulta("SELECT RUTA FROM GET_LOGO");
//
//        try {
//            rs.next();
//            imagen = new ImageIcon(rs.getString(1));
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
//        }
//
//        if (imagen.getIconHeight() == -1) {
//            imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
//            icon = new ImageIcon(imagen.getImage().getScaledInstance(180, 120,
//                    Image.SCALE_DEFAULT));
//            imagen.getImage().flush();
//            jlImagen.setIcon(icon);
//            jlImagen.validate();
//        } else {
//            icon = new ImageIcon(imagen.getImage().getScaledInstance(180, 120,
//                    Image.SCALE_DEFAULT));
//            imagen.getImage().flush();
//            jlImagen.setIcon(icon);
//            jlImagen.validate();
//        }//Terminado Aqui
//
//        //panorama();
//        //cajeros();
//        //mensaje();
//
//    }
//    private void panorama() {
//        ResultSet rs = getConsulta(
//                "SELECT cast(r.VENTA as numeric(15,2)) as VENTA, "
//                + "     cast(r.COSTO as numeric(15,2)) as COSTO FROM PANORAMA r");
//        try {
//            rs.next();
//            txtVenta.setValue(rs.getDouble("venta"));
//            txtCosto.setValue(rs.getDouble("costo"));
//            txtGanancia.setValue(rs.getDouble("venta") - rs.getDouble("costo"));
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
//        }
//    }
//    private void cajeros() {
//        //Saber cuales cajeros estan Activo....
//        String titulos[] = {"Cajero Activo"};
//        Object registro[] = new Object[1];
//        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
//        ResultSet rs = getConsulta(
//                "SELECT r.IDUSUARIO, r.FECHA, r.HORA FROM ESTADO_USUARIO r");
//        try {
//            while (rs.next()) {
//                registro[0] = rs.getString("idUsuario") + " : "
//                        + Utilidades.formatDate(rs.getDate("Fecha"), "dd-MM-yyyy")
//                        + " , "
//                        + rs.getString("Hora").substring(0, 5);
//                miTabla.addRow(registro);
//            }
//            jtCajero.setModel(miTabla);
//
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
//        }
//    }
//    private void mensaje() {
//        ResultSet rs = getConsulta(
//                "SELECT r.Ruta as mensaje, o.RUTA as nombreEmpresa, "
//                + "o2.RUTA as direccionEmpresa, "
//                + "o3.RUTA as telefonoEmpresa  "
//                + "FROM OPCIONES r "
//                + "join OPCIONES o "
//                + "on o.OPCION like 'nombreEmpresa' "
//                + "join OPCIONES o2 "
//                + "on o2.OPCION like 'direccionEmpresa' "
//                + "join OPCIONES o3 "
//                + "on o3.OPCION like 'telefonoEmpresa' "
//                + "where r.OPCION like 'MensajeTickes'");
//
//        try {
//            rs.next();
//            encabezado = new Encabezado(
//                    rs.getString("nombreEmpresa"),
//                    rs.getString("direccionEmpresa"),
//                    rs.getString("telefonoEmpresa"),
//                    rs.getString("mensaje"));
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
//        }
//    }///--------------Hasta Aqui.......
//    public void menus() {
//        Perfiles miPerfil = getAcceso(getPerfil());
//        mnuArchivos.setEnabled(dime(miPerfil.getArchivos()));
//        mnuArchivosCliente.setEnabled(dime(miPerfil.getArchivosClientes()));
//        mnuArchivosProductos.setEnabled(dime(miPerfil.getArchivosProductos()));
//        mnuArchivosUsuario.setEnabled(dime(miPerfil.getArchivosUsuarios()));
//        mnuArchivosCambioClave.setEnabled(dime(miPerfil.getArchivosCambioClave()));
//        mnuArchivosCambioUsuario.setEnabled(dime(miPerfil.getArchivosCambioUsuario()));
//        mnuArchivosSalir.setEnabled(dime(miPerfil.getArchivosSalir()));
//
//        mnuMovimientos.setEnabled(dime(miPerfil.getMovimientos()));
//        mnuMovimientosNuevaFactura.setEnabled(dime(miPerfil.getMovimientosNuevaFactura()));
//        mnuMovimientosReporteFactura.setEnabled(dime(miPerfil.getMovimientosReporteFactura()));
//        mnuMovimientosInventario.setEnabled(dime(miPerfil.getMovimientosInventarios()));
//        mnuMovimientosAbrirTurno.setEnabled(dime(miPerfil.getMovimientosAbrirTurno()));
//        mnuMovimientosCerrarTurno.setEnabled(dime(miPerfil.getMovimientosCerrarTurno()));
//        mnuMovimientosDeudas.setEnabled(dime(miPerfil.getMovimientosDeuda()));
//
//        jLabel6.setText("Usuario actual: " + getIdUsuario());
//
//        jMenuBar1.add(filler1);
//        jMenuBar1.add(jLabel6);
//
//        ResultSet rs = getConsulta(
//                "SELECT CURRENT_ROLE, b.D "
//                + "FROM V_FCH_LC a "
//                + "JOIN V_TIME_LIC b on 1=1"
//        );
//        try {
//            rs.next();
//            if (rs.getString(1).equals("NONE")) {
//                jLabel9.setText("Tiempo de periodo de Licencia: " + rs.getString(2));
//                jMenuBar1.add(filler1);
//                jMenuBar1.add(jLabel9);
//            }
//        } catch (SQLException ex) {
//            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
//        }
//
//        if (getPerfil() == 1) {
////            estado();
//        } else {
//            pEstatus.setVisible(false);
//        }
//        //Ocultamiento del administrador
//        if (getIdUsuario().equals("Jhironsel")) {
//            jlRestauracion.setVisible(true);
//            jlRespaldar.setVisible(true);
//            jlRestaurar.setVisible(true);
//            mnuLicencia.setVisible(true);
//        } else {
//            jlRestauracion.setVisible(false);
//            jlRespaldar.setVisible(false);
//            jlRestaurar.setVisible(false);
//            mnuLicencia.setVisible(false);
//        }
//        jMenuBar1.add(jPanelImpresion);
//    }
    
    protected void cerrarTodos() {
        for (JInternalFrame allFrame : dpnEscritorio.getAllFrames()) {
            if (allFrame != null) {
                dpnEscritorio.getDesktopManager().closeFrame(allFrame);
            }
        }
    }

    protected synchronized void abrirFormulario(@NonNull JInternalFrame formulario) {
        dpnEscritorio.getDesktopManager().closeFrame(formulario);

        if (!dpnEscritorio.isAncestorOf(formulario)) {
            dpnEscritorio.add(formulario);
        }

        try {
            formulario.setMaximum(false);
            formulario.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, "Error al crear ventana de cliente.", ex);
        }

        formulario.setVisible(true);

        System.gc();
    }
    
    protected void abrirFormularioCentralizado(@NonNull JInternalFrame formulario) {
        if (!dpnEscritorio.isAncestorOf(formulario)) {
            dpnEscritorio.add(formulario);
        }
        
        if(formulario instanceof frmReporteFacturas){
            ((frmReporteFacturas) formulario).centralizar();
        }
        
        formulario.setVisible(true);
    }

    private void cargarIconos() {
        //Iconos de menus de opciones.
        mnuArchivos.setIcon(icono.getIcono("Archivos 32 x 32.png"));
        mnuMovimientos.setIcon(icono.getIcono("Movimiento 32 x 32.png"));
        mnuAyuda.setIcon(icono.getIcono("Ayuda 32 x 32.png"));

        //Menu Archivos
        mnuArchivosCliente.setIcon(icono.getIcono("Clientes 32 x 32.png"));
        mnuArchivosProductos.setIcon(icono.getIcono("Productos 32 x 32.png"));
        mnuCambioClave.setIcon(icono.getIcono("Cambiar Contraseña 32 x 32.png"));
        mnuArchivosAdministracionPrivilegios.setIcon(icono.getIcono("Privilegios 32 x 32.png"));
        mnuArchivosCambioUsuario.setIcon(icono.getIcono("Cambio de Usuario 32 x 32.png"));
        mnuArchivosSalir.setIcon(icono.getIcono("Salir 32 x 32.png"));

        //Menu Movimiento
        mnuMovimientosNuevaFactura.setIcon(icono.getIcono("Factura 32 x 32.png"));
        mnuMovimientosReporteFactura.setIcon(icono.getIcono("Reportar Factura 32 x 32.png"));
        mnuMovimientosInventario.setIcon(icono.getIcono("Inventario 32 x 32.png"));
        mnuMovimientosAbrirTurno.setIcon(icono.getIcono("Turno 32 x 32.png"));
        mnuMovimientosDeudas.setIcon(icono.getIcono("Money 32 x 32.png"));

        //Iconos de subMenus
        Archivos.setIcon(icono.getIcono("Archivos 32 x 32.png"));
        jmClientes.setIcon(icono.getIcono("Clientes 32 x 32.png"));
        jmProductos.setIcon(icono.getIcono("Productos 32 x 32.png"));
        jmCambioClave.setIcon(icono.getIcono("Cambiar Contraseña 32 x 32.png"));
        jmCambioUsuario.setIcon(icono.getIcono("Cambio de Usuario 32 x 32.png"));
        jmSalir.setIcon(icono.getIcono("Salir 32 x 32.png"));

        //Barra lateral izquierda
        jlMovimientoES.setIcon(icono.getIcono("Movimiento 32 x 32.png"));
        jlGetIP.setIcon(icono.getIcono("Ip 32 x 32.png"));
        jlGrafica.setIcon(icono.getIcono("Grafico 32 x 32.png"));
        jlRespaldar.setIcon(icono.getIcono("RespaldarBD 32 x 32.png"));
        jlRestauracion.setIcon(icono.getIcono("RestaurarBD 32 x 32.png"));
        jlRestaurar.setIcon(icono.getIcono("RestaurarBD 32 x 32.png"));

        //
        jlLogoEmpresa.setIcon(icono.getIcono("NoImageTransp 96 x 96.png"));

        btnEstablecerEncabezado.setIcon(icono.getIcono("Factura 32 x 32.png"));
        btnSeleccionarImpresora.setIcon(icono.getIcono("Impresora 32 x 32.png"));

        btnOcultarPanel.setIcon(icono.getIcono("Flecha Izquierda 32 x 32.png"));
    }

    private void cargarLogo() {

        ImageIcon img = new ImageIcon(
                Utilidades.imagenDecode64(getLogo())
                        .getImage()
                        .getScaledInstance(330, 155, Image.SCALE_AREA_AVERAGING));

        jlLogoEmpresa.setIcon(img);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Archivos;
    private javax.swing.JMenu Movimientos;
    private javax.swing.JButton btnEstablecerEncabezado;
    private javax.swing.JButton btnOcultarPanel;
    private javax.swing.JButton btnSeleccionarImpresora;
    private RSMaterialComponent.RSComboBox cbRoles;
    public static javax.swing.JDesktopPane dpnEscritorio;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelImpresion;
    private rojerusan.RSMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanelImpresion;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JLabel jlGetIP;
    private javax.swing.JLabel jlGrafica;
    private javax.swing.JLabel jlLogoEmpresa;
    private javax.swing.JLabel jlMovimientoES;
    private javax.swing.JLabel jlRespaldar;
    private javax.swing.JLabel jlRestauracion;
    private javax.swing.JLabel jlRestaurar;
    private RSMaterialComponent.RSLabelTextIcon jlUser;
    private javax.swing.JMenuItem jmAbrirTurno;
    private javax.swing.JMenuItem jmCambioClave;
    private javax.swing.JMenuItem jmCambioUsuario;
    private javax.swing.JMenuItem jmCerrarTurno;
    private javax.swing.JMenuItem jmClientes;
    private javax.swing.JMenuItem jmDeuda;
    private javax.swing.JMenuItem jmInventario;
    private javax.swing.JMenuItem jmNuevaFactura;
    private javax.swing.JMenuItem jmProductos;
    private javax.swing.JMenuItem jmReporteFactura;
    private javax.swing.JMenuItem jmSalir;
    public static javax.swing.JProgressBar jprImpresion;
    private javax.swing.JScrollPane jsEstatus;
    private javax.swing.JTable jtCajero;
    private necesario.LabelIcon liWork;
    private javax.swing.JMenu mnuArchivos;
    private javax.swing.JMenuItem mnuArchivosAdministracionPrivilegios;
    private javax.swing.JMenuItem mnuArchivosCambioUsuario;
    private javax.swing.JMenuItem mnuArchivosCliente;
    private javax.swing.JMenuItem mnuArchivosProductos;
    private javax.swing.JMenuItem mnuArchivosSalir;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenuItem mnuAyudaAcercaDe;
    private javax.swing.JMenuItem mnuAyudaAyuda;
    private javax.swing.JMenuItem mnuCambioClave;
    private javax.swing.JMenu mnuLicencia;
    private javax.swing.JMenu mnuMovimientos;
    private javax.swing.JMenuItem mnuMovimientosAbrirTurno;
    private javax.swing.JMenuItem mnuMovimientosDeudas;
    private javax.swing.JMenuItem mnuMovimientosInventario;
    public static javax.swing.JMenuItem mnuMovimientosNuevaFactura;
    private javax.swing.JMenuItem mnuMovimientosReporteFactura;
    private javax.swing.JPanel pEstatus;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JFormattedTextField txtGanancia;
    private javax.swing.JFormattedTextField txtVenta;
    // End of variables declaration//GEN-END:variables
}
