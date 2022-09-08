package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static sur.softsurena.datos.delete.DeleteMetodos.borrarCliente;
import static sur.softsurena.datos.insert.InsertMetodos.agregarCliente;
import sur.softsurena.datos.select.SelectMetodos;
import static sur.softsurena.datos.select.SelectMetodos.existeCliente;
import static sur.softsurena.datos.select.SelectMetodos.getClienteByID;
import static sur.softsurena.datos.update.UpdateMetodos.modificarCliente;
import sur.softsurena.entidades.Celda_CheckBox;
import sur.softsurena.entidades.Clientes;
import sur.softsurena.entidades.ContactosEmail;
import sur.softsurena.entidades.ContactosTel;
import sur.softsurena.entidades.Direcciones;
import sur.softsurena.entidades.Distritos_municipales;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipios;
import sur.softsurena.entidades.Personas;
import sur.softsurena.entidades.Provincias;
import sur.softsurena.entidades.Render_CheckBox;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.entidades.ValidarCorreoTel;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.datos.select.SelectMetodos.getClientesTablaSB;
import static sur.softsurena.datos.select.SelectMetodos.getCorreoByID;
import static sur.softsurena.datos.select.SelectMetodos.getDireccionByID;
import static sur.softsurena.datos.select.SelectMetodos.getTelefonoByID;
import static sur.softsurena.datos.select.SelectMetodos.privilegioCampo;
import sur.softsurena.entidades.Privilegios;

public final class frmClientes extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmClientes.class.getName());
    private boolean nuevo = false;
    private final JTextFieldDateEditor editor;
    private static DefaultTableModel dtmClientes, dtmTelefono, dtmCorreo, dtmDireccion;
    private frmDetalleFacturaClientes miDetalle;

    private String titulosTel[] = {"Numero", "Tipo", "Fecha"};
    private String titulosCorreo[] = {"Correo", "Fecha"};
    private String titulosDireccion[] = {"Provincia", "Municipio", "Distrito M.", "Calle y No. Casa", "Fecha"};

    private Object registroTel[] = new Object[titulosTel.length];
    private Object registroCorreo[] = new Object[titulosCorreo.length];
    private Object registroDireccion[] = new Object[titulosDireccion.length];

    public frmClientes() {
        initComponents();

        try {
            txtTelelfonoMovil.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

//        .addActionListener(new java.awt.event.ActionListener() {
        editor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jcbEstadoCivil.requestFocus();
                jcbEstadoCivil.showPopup();
            }
        });

        //Mantenimiento oculto por defecto. 
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspMantenimiento), false);

        nuevasTablasDirTelCor();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txtCedula2 = new javax.swing.JFormattedTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jtpUnico = new javax.swing.JTabbedPane();
        jspClientes = new javax.swing.JScrollPane();
        jpClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel15 = new javax.swing.JPanel();
        btnImprimirInforme = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnHistorial = new RSMaterialComponent.RSButtonMaterialIconOne();
        jspMantenimiento = new javax.swing.JScrollPane();
        jpMantenimiento = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        jcbPersona = new javax.swing.JComboBox();
        cbActivo = new javax.swing.JCheckBox();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jcbEstadoCivil = new javax.swing.JComboBox();
        jcbSexo = new javax.swing.JComboBox();
        jtpDireccionContactos = new javax.swing.JTabbedPane();
        jpDireccion = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDireccion = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel2 = new javax.swing.JPanel();
        jcbProvincias = new RSMaterialComponent.RSComboBox();
        jcbMunicipios = new RSMaterialComponent.RSComboBox();
        jcbDistritoMunicipal = new RSMaterialComponent.RSComboBox();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnEliminarDirrecion = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAgregarDirecciones = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarDirrecion1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtDireccion = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jpContactos = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefonos = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel8 = new javax.swing.JPanel();
        txtTelelfonoMovil = new javax.swing.JFormattedTextField();
        btnAgregarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        jrbMovil = new javax.swing.JRadioButton();
        jrbResidencial = new javax.swing.JRadioButton();
        btnEliminarDirrecion2 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCorreos = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel12 = new javax.swing.JPanel();
        btnAgregarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtCorreo = new RSMaterialComponent.RSTextFieldIconOne();
        btnEliminarDirrecion3 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCedulaValidad = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        txtCedula2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula2.setText("");
        txtCedula2.setToolTipText("Cedula del Cliente");
        txtCedula2.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula2.setFocusTraversalPolicyProvider(true);
        txtCedula2.setFont(new java.awt.Font("Ubuntu Mono", 1, 14)); // NOI18N
        txtCedula2.setName("txtCedula"); // NOI18N
        txtCedula2.setNextFocusableComponent(jcbPersona);
        txtCedula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedula2ActionPerformed(evt);
            }
        });
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula2KeyReleased(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administración Clientes");
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(915, 535));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jtpUnico.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jtpUnico.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jtpUnico.setName("jtpUnico"); // NOI18N

        jspClientes.setName("jspClientes"); // NOI18N

        jpClientes.setName("jpClientes"); // NOI18N

        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 1, true));
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setDoubleBuffered(true);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(2000, 0));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(800, 0));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(800, 415));

        tblClientes.setAutoCreateRowSorter(true);
        tblClientes.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"
            }
        ));
        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblClientes.setMaximumSize(null);
        tblClientes.setMinimumSize(null);
        tblClientes.setName("tblClientes"); // NOI18N
        tblClientes.setPreferredSize(null);
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.setShowGrid(false);
        tblClientes.setShowHorizontalLines(true);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblClientes);
        if (tblClientes.getColumnModel().getColumnCount() > 0) {
            tblClientes.getColumnModel().getColumn(0).setHeaderValue("1");
            tblClientes.getColumnModel().getColumn(1).setHeaderValue("2");
            tblClientes.getColumnModel().getColumn(2).setHeaderValue("3");
            tblClientes.getColumnModel().getColumn(3).setHeaderValue("4");
            tblClientes.getColumnModel().getColumn(4).setHeaderValue("5");
            tblClientes.getColumnModel().getColumn(5).setHeaderValue("6");
            tblClientes.getColumnModel().getColumn(6).setHeaderValue("7");
            tblClientes.getColumnModel().getColumn(7).setHeaderValue("8");
            tblClientes.getColumnModel().getColumn(8).setHeaderValue("9");
            tblClientes.getColumnModel().getColumn(9).setHeaderValue("10");
            tblClientes.getColumnModel().getColumn(10).setHeaderValue("11");
        }

        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 1, true));

        btnImprimirInforme.setText("Imprimir informe de cliente");
        btnImprimirInforme.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirInforme.setName("btnImprimirInforme"); // NOI18N

        btnHistorial.setText("Historial de Cliente");
        btnHistorial.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnHistorial.setName("btnHistorial"); // NOI18N
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel15Layout = new org.jdesktop.layout.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnImprimirInforme, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnHistorial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel15Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnImprimirInforme, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnHistorial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jpClientesLayout = new org.jdesktop.layout.GroupLayout(jpClientes);
        jpClientes.setLayout(jpClientesLayout);
        jpClientesLayout.setHorizontalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15))
        );

        jspClientes.setViewportView(jpClientes);

        jtpUnico.addTab("Clientes", jspClientes);

        jspMantenimiento.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N

        jpMantenimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("DejaVu Sans", 0, 14))); // NOI18N
        jpMantenimiento.setFocusCycleRoot(true);
        jpMantenimiento.setFocusTraversalPolicyProvider(true);
        jpMantenimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jpMantenimiento.setName("jpMantenimiento"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 45, 223)));
        jPanel1.setName(""); // NOI18N

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("012-0089344-8");
        txtCedula.setToolTipText("Cedula del Cliente");
        txtCedula.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula.setFocusTraversalPolicyProvider(true);
        txtCedula.setFont(new java.awt.Font("Ubuntu Mono", 1, 14)); // NOI18N
        txtCedula.setMinimumSize(new java.awt.Dimension(0, 0));
        txtCedula.setName("txtCedula"); // NOI18N
        txtCedula.setNextFocusableComponent(jcbPersona);
        txtCedula.setPreferredSize(new java.awt.Dimension(0, 25));
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedulaKeyReleased(evt);
            }
        });

        jcbPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Tipo persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbPersona.setName("jcbPersona"); // NOI18N
        jcbPersona.setNextFocusableComponent(txtPNombre);
        jcbPersona.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbPersonaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbActivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbActivo.setSelected(true);
        cbActivo.setText("Activo");
        cbActivo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        cbActivo.setFocusTraversalPolicyProvider(true);
        cbActivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbActivo.setMinimumSize(new java.awt.Dimension(0, 0));
        cbActivo.setName("cbActivo"); // NOI18N
        cbActivo.setPreferredSize(new java.awt.Dimension(0, 25));
        cbActivo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });

        txtPNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Primer nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtPNombre.setDoubleBuffered(true);
        txtPNombre.setFocusTraversalPolicyProvider(true);
        txtPNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtPNombre.setName("txtPNombre"); // NOI18N
        txtPNombre.setNextFocusableComponent(txtSNombre);
        txtPNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });
        txtPNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPNombreKeyReleased(evt);
            }
        });

        txtSNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Segundo nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtSNombre.setDoubleBuffered(true);
        txtSNombre.setFocusTraversalPolicyProvider(true);
        txtSNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtSNombre.setName("txtSNombre"); // NOI18N
        txtSNombre.setNextFocusableComponent(txtApellidos);
        txtSNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });
        txtSNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSNombreKeyReleased(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtApellidos.setDoubleBuffered(true);
        txtApellidos.setFocusTraversalPolicyProvider(true);
        txtApellidos.setMinimumSize(new java.awt.Dimension(0, 0));
        txtApellidos.setName("txtApellidos"); // NOI18N
        txtApellidos.setNextFocusableComponent(dchFechaNacimiento);
        txtApellidos.setPreferredSize(new java.awt.Dimension(0, 25));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellidosKeyReleased(evt);
            }
        });

        dchFechaNacimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 45, 223), 2), "Fecha nacimiento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        dchFechaNacimiento.setName("jdcFechaNacimiento"); // NOI18N
        dchFechaNacimiento.setNextFocusableComponent(jcbEstadoCivil);

        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbEstadoCivil.setName("jcbEstadoCivil"); // NOI18N
        jcbEstadoCivil.setNextFocusableComponent(jcbSexo);
        jcbEstadoCivil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbEstadoCivilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbSexo.setName("jcbSexo"); // NOI18N
        jcbSexo.setNextFocusableComponent(jcbProvincias);

        jtpDireccionContactos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblDireccion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Provincia", "Municipio", "Distrito M.", "Dirección", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDireccion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDireccion.setColumnSelectionAllowed(true);
        tblDireccion.setName("tblDireccion"); // NOI18N
        tblDireccion.setShowVerticalLines(false);
        tblDireccion.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tblDireccion);
        tblDireccion.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblDireccion.getColumnModel().getColumnCount() > 0) {
            tblDireccion.getColumnModel().getColumn(0).setResizable(false);
            tblDireccion.getColumnModel().getColumn(1).setResizable(false);
            tblDireccion.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 6, 0));

        jcbProvincias.setForeground(new java.awt.Color(37, 45, 223));
        jcbProvincias.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbProvincias.setName("jcbProvincia"); // NOI18N
        jcbProvincias.setNextFocusableComponent(jcbMunicipios);
        jcbProvincias.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbProvinciasPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(jcbProvincias);

        jcbMunicipios.setForeground(new java.awt.Color(37, 45, 223));
        jcbMunicipios.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbMunicipios.setName("jcbMunicipios"); // NOI18N
        jcbMunicipios.setNextFocusableComponent(jcbDistritoMunicipal);
        jcbMunicipios.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbMunicipiosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(jcbMunicipios);

        jcbDistritoMunicipal.setForeground(new java.awt.Color(37, 45, 223));
        jcbDistritoMunicipal.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbDistritoMunicipal.setName("jcbDistritoMunicipal"); // NOI18N
        jcbDistritoMunicipal.setNextFocusableComponent(btnAgregarTelefonoMovil);
        jcbDistritoMunicipal.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDistritoMunicipalPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel2.add(jcbDistritoMunicipal);

        btnEliminarDirrecion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarDirrecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecionActionPerformed(evt);
            }
        });

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });

        btnEliminarDirrecion1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UNDO);
        btnEliminarDirrecion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecion1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel6Layout = new org.jdesktop.layout.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(btnAgregarDirecciones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(6, 6, 6)
                .add(btnEliminarDirrecion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(6, 6, 6)
                .add(btnEliminarDirrecion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6Layout.linkSize(new java.awt.Component[] {btnAgregarDirecciones, btnEliminarDirrecion, btnEliminarDirrecion1}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6Layout.createSequentialGroup()
                .add(jPanel6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(btnEliminarDirrecion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEliminarDirrecion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAgregarDirecciones, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0))
        );

        jPanel6Layout.linkSize(new java.awt.Component[] {btnAgregarDirecciones, btnEliminarDirrecion, btnEliminarDirrecion1}, org.jdesktop.layout.GroupLayout.VERTICAL);

        txtDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_LOCATION);
        txtDireccion.setName("txtDireccion"); // NOI18N
        txtDireccion.setPlaceholder("Ingrese la direccion residencial");
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(txtDireccion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(0, 0, 0))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {jPanel6, txtDireccion}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jpDireccionLayout = new org.jdesktop.layout.GroupLayout(jpDireccion);
        jpDireccion.setLayout(jpDireccionLayout);
        jpDireccionLayout.setHorizontalGroup(
            jpDireccionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpDireccionLayout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jpDireccionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .add(jScrollPane8))
                .addContainerGap())
        );
        jpDireccionLayout.setVerticalGroup(
            jpDireccionLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpDireccionContactos.addTab("Dirección", jpDireccion);

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTelefonos.setName("tblTelefonos"); // NOI18N
        jScrollPane2.setViewportView(tblTelefonos);

        txtTelelfonoMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Número"));
        try {
            txtTelelfonoMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelelfonoMovil.setName("txtTelefonoMovil"); // NOI18N
        txtTelelfonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelelfonoMovilActionPerformed(evt);
            }
        });

        btnAgregarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarTelefonoMovil.setName("btnAgregarTelefono"); // NOI18N
        btnAgregarTelefonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTelefonoMovilActionPerformed(evt);
            }
        });

        btnBorrarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTelefonoMovil.setName("btnBorrarTelefono"); // NOI18N
        btnBorrarTelefonoMovil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTelefonoMovilActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbMovil);
        jrbMovil.setSelected(true);
        jrbMovil.setText("Movil");
        jrbMovil.setName("jrbMovil"); // NOI18N

        buttonGroup1.add(jrbResidencial);
        jrbResidencial.setText("Telefono");
        jrbResidencial.setName("jrbTelefonoResidencial"); // NOI18N

        btnEliminarDirrecion2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UNDO);
        btnEliminarDirrecion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecion2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtTelelfonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 212, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jrbResidencial, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jrbMovil, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAgregarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnBorrarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEliminarDirrecion2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {btnAgregarTelefonoMovil, btnBorrarTelefonoMovil, btnEliminarDirrecion2}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(txtTelelfonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnAgregarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnBorrarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnEliminarDirrecion2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(jrbMovil)
                        .add(0, 0, 0)
                        .add(jrbResidencial)))
                .add(3, 3, 3))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {btnAgregarTelefonoMovil, btnBorrarTelefonoMovil, btnEliminarDirrecion2, txtTelelfonoMovil}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel10Layout = new org.jdesktop.layout.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel10Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .add(0, 0, 0))
        );

        jTabbedPane3.addTab("Teléfonico", jPanel10);

        tblCorreos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCorreos.setName("tblCorreos"); // NOI18N
        jScrollPane7.setViewportView(tblCorreos);

        btnAgregarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarCorreo.setName("btnAgregarCorreo"); // NOI18N
        btnAgregarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCorreoActionPerformed(evt);
            }
        });

        btnEliminarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarCorreo.setName("btnBorrarCorreo"); // NOI18N
        btnEliminarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCorreoActionPerformed(evt);
            }
        });

        txtCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        txtCorreo.setName("txtCorreo"); // NOI18N
        txtCorreo.setPlaceholder("Ingrese correo valido");
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnEliminarDirrecion3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UNDO);
        btnEliminarDirrecion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecion3ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAgregarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEliminarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(6, 6, 6)
                .add(btnEliminarDirrecion3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {btnAgregarCorreo, btnEliminarCorreo, btnEliminarDirrecion3}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(btnAgregarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnEliminarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnEliminarDirrecion3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(txtCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {btnAgregarCorreo, btnEliminarCorreo, btnEliminarDirrecion3}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel11Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .add(0, 0, 0))
        );

        jTabbedPane3.addTab("Correos", jPanel11);

        org.jdesktop.layout.GroupLayout jpContactosLayout = new org.jdesktop.layout.GroupLayout(jpContactos);
        jpContactos.setLayout(jpContactosLayout);
        jpContactosLayout.setHorizontalGroup(
            jpContactosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpContactosLayout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jTabbedPane3)
                .add(0, 0, 0))
        );
        jpContactosLayout.setVerticalGroup(
            jpContactosLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpContactosLayout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jTabbedPane3)
                .add(0, 0, 0))
        );

        jtpDireccionContactos.addTab("Contactos", jpContactos);

        btnCedulaValidad.setBackground(new java.awt.Color(0, 255, 75));
        btnCedulaValidad.setToolTipText("Verifica la cedula del cliente.");
        btnCedulaValidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCedulaValidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VERIFIED_USER);
        btnCedulaValidad.setName("btnCedulaValidad"); // NOI18N
        btnCedulaValidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedulaValidadActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jtpDireccionContactos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 762, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 197, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnCedulaValidad, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                            .add(txtPNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(dchFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtSNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtApellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cbActivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbSexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(6, 6, 6))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {cbActivo, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbActivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, btnCedulaValidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtPNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtSNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtApellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(dchFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jcbSexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jtpDireccionContactos)
                .add(6, 6, 6))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {btnCedulaValidad, cbActivo, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtCedula, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.VERTICAL);

        txtCedula.getAccessibleContext().setAccessibleParent(this);
        txtPNombre.getAccessibleContext().setAccessibleParent(this);
        txtApellidos.getAccessibleContext().setAccessibleParent(this);

        org.jdesktop.layout.GroupLayout jpMantenimientoLayout = new org.jdesktop.layout.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jspMantenimiento.setViewportView(jpMantenimiento);

        jtpUnico.addTab("Mantenimiento", jspMantenimiento);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Botones de Acción", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14))); // NOI18N
        jPanel13.setMaximumSize(new java.awt.Dimension(787, 81));
        jPanel13.setMinimumSize(new java.awt.Dimension(787, 81));
        jPanel13.setPreferredSize(new java.awt.Dimension(800, 80));

        jPanel14.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel14.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel14.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel14.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel14.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar);

        org.jdesktop.layout.GroupLayout jPanel13Layout = new org.jdesktop.layout.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel13Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel14, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jtpUnico)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 842, Short.MAX_VALUE))
                .add(24, 24, 24))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jtpUnico, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .add(0, 0, 0)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );

        jScrollPane4.setViewportView(jPanel4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocusInWindow();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        dchFechaNacimiento.requestFocusInWindow();
        editor.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        llenarTablaClientes();
        Direcciones.llenarProvincias(jcbProvincias);
        Personas.llenarPersona(jcbPersona);
        Personas.llenarSexo(jcbSexo);
        Personas.llenarEstadoCivil(jcbEstadoCivil);
    }//GEN-LAST:event_formInternalFrameActivated
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        jcbPersona.requestFocus();
        jcbPersona.showPopup();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtPNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPNombreKeyReleased
        txtPNombre.setText(txtPNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtPNombreKeyReleased

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        txtApellidos.setText(txtApellidos.getText().toUpperCase());
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        char caracter = evt.getKeyChar();

        if (caracter == '-') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtSNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNombreKeyReleased
        txtSNombre.setText(txtSNombre.getText().toUpperCase());
    }//GEN-LAST:event_txtSNombreKeyReleased

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarRegistro()) {
            return;
        }
        
        nuevo = false;
        
        cambioBoton(true);
        
        mostrarRegistro();
        
        repararColumnaTable(tblCorreos);
        repararColumnaTable(tblDireccion);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtCedula.getValue().toString().isBlank()
                || txtCedula.getValue().toString().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe digitar la cedula del cliente");
            txtCedula.requestFocusInWindow();
            return;
        }
        if (txtPNombre.getText().isBlank() || txtPNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe digitar un nombre...");
            txtPNombre.requestFocusInWindow();
            return;
        }
        if (txtApellidos.getText().isBlank() || txtApellidos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Debe digitar un apellido...");
            txtApellidos.requestFocusInWindow();
            return;
        }
        if (tblDireccion.getRowCount() < 1) {
            JOptionPane.showMessageDialog(null,
                    "Debe digitar una direccion del cliente.");
            txtDireccion.requestFocus();
            return;
        }
        if (dchFechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(null,
                    "Debe indicar una fecha de nacimiento.");
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showMessageDialog(null,
                    "La fecha de nacimiento debe ser anterior a la fecha actual");
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        // si es nuevo validamos que el Cliente no exista
        if (nuevo) {

            if (existeCliente(txtCedula.getValue().toString())) {
                JOptionPane.showMessageDialog(null, "Cliente Ya existe...");
                return;
            }

        } else if (!existeCliente(txtCedula.getValue().toString())) {

            JOptionPane.showMessageDialog(null, "Cliente NO existe...");
            txtCedula.requestFocusInWindow();
            return;

        }

        Generales g = Generales.builder().
                cedula(txtCedula.getValue().toString()).
                estado_civil(((EstadoCivil) jcbEstadoCivil.getSelectedItem()).getAbreviatura()).build();

        Direcciones[] d = new Direcciones[tblDireccion.getRowCount()];

        for (int i = 0; i < tblDireccion.getRowCount(); i++) {
            d[i] = Direcciones.builder().
                    id_provincia(
                            ((Provincias) tblDireccion.getValueAt(i, 0)).getId()).
                    id_municipio(
                            ((Municipios) tblDireccion.getValueAt(i, 1)).getId()).
                    id_distrito_municipal(
                            ((Distritos_municipales) tblDireccion.getValueAt(i, 2)).getId()).
                    direccion(tblDireccion.getValueAt(i, 3).toString()).build();
        }

        Clientes miCliente = Clientes.builder().
                id_persona( tblClientes.getSelectedRow()>= 0 ? 
                        ((Clientes) tblClientes.getValueAt(
                                tblClientes.getSelectedRow(), 0)).getId_persona() : 0).
                generales(g).
                direccion(d).
                persona(((TipoPersona) 
                        jcbPersona.getSelectedItem()).getAbreviatura()).
                sexo(((Sexo) jcbSexo.getSelectedItem()).getAbreviatura()).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                fecha_nacimiento(new java.sql.Date(
                        dchFechaNacimiento.getDate().getTime())).
                estado(cbActivo.isSelected()).build();

        String msg, accion = "editar";

        if (nuevo) {
            accion = "crear";
        }

        int resp = JOptionPane.showConfirmDialog(null,
                "<html><b><big>Se va a " + accion + " el Cliente: </big></b><big>"
                + txtPNombre.getText() + (txtSNombre.getText().isEmpty()
                || txtSNombre.getText().isBlank() ? "" : " " + txtSNombre.getText()) + " " + txtApellidos.getText() + "</big></html>"
                + "\n<html><b><big>Cedula no.: </big></b><big>" + txtCedula.getText() + "</big></html>"
                + "\n<html><b><big>Fecha Nacimiento: </big></b><big>" + Utilidades.formatDate(dchFechaNacimiento.getDate(), "dd-MM-yyyy") + "</big></html>"
                + "\n<html><b><big>Estado del Cliente: </big></b><big>" + cbActivo.getText() + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        ContactosTel[] ct = new ContactosTel[tblTelefonos.getRowCount()];

        for (int i = 0; i < tblTelefonos.getRowCount(); i++) {
            ct[i] = ContactosTel.builder().
                    telefono(tblTelefonos.getValueAt(i, 0).toString()).
                    tipo(tblTelefonos.getValueAt(i, 1).toString()).build();
        }

        ContactosEmail[] ce = new ContactosEmail[tblCorreos.getRowCount()];
        for (int i = 0; i < tblCorreos.getRowCount(); i++) {
            ce[i] = ContactosEmail.builder().
                    email(tblCorreos.getValueAt(i, 0).toString()).build();
        }

        //Crear la logica para agregar los contactos de un cliente.
        if (nuevo) {
            msg = agregarCliente(miCliente, ct, ce).getMensaje();
        } else {
            msg = modificarCliente(miCliente, ct, ce).getMensaje();
        }

        JOptionPane.showMessageDialog(null, msg);

        //Actualizamos los cambios en la Tabla
        //llenarTablaClientes(); Este metodo está siendo llamado desde los eventos de firebird.
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        //cancelar();
        nuevo = false;
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (validarRegistro()) {
            return;
        }

        int rta = JOptionPane.showConfirmDialog(this,
                "¿Esta Seguro de Eliminar Registro del Cliente?",
                "Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        String msg = borrarCliente(
                ((Clientes) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona(),
                Boolean.parseBoolean(tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0).toString())).getMensaje();

        if (msg.equalsIgnoreCase("Cliente borrado correctamente.")) {
            JOptionPane.showMessageDialog(this, msg);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario con facturas Existe, "
                    + "Deberia de cambiar Estado a Cliente");
        }

        //Actualizamos los cambios en la Tabla
//        llenarTablaClientes(); La tabla se está llenando desde los postEvent de Firebird
        repararColumnaTable(tblClientes);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtCedula2.setValue(null);

        int resp = JOptionPane.showInternalConfirmDialog(this,
                txtCedula2, "Buscar cliente por su cedula", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (!existeCliente(txtCedula2.getText())) {
            JOptionPane.showMessageDialog(null, "El Cliente No Existe");
            return;
        }

        for (int i = 0; i < tblClientes.getRowCount(); i++) {
            if (tblClientes.getValueAt(i, 0).toString().contains(
                    txtCedula2.getText())) {
                tblClientes.setRowSelectionInterval(i, i);
                break;
            }
            if (txtCedula2.getText().equals("")) {
                return;
            }

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if (miDetalle == null) {
            miDetalle = new frmDetalleFacturaClientes();
            dpnEscritorio.add(miDetalle);
        }

        try {
            miDetalle.setMaximum(false);
            miDetalle.setMaximum(true);
        } catch (PropertyVetoException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        miDetalle.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void jcbMunicipiosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbMunicipiosPopupMenuWillBecomeInvisible
        Direcciones.llenarDistritoMunicipal(
                jcbMunicipios.getSelectedIndex() <= 0 ? 0 :
                ((Municipios) jcbMunicipios.getSelectedItem()).getId(),
                jcbDistritoMunicipal);
    }//GEN-LAST:event_jcbMunicipiosPopupMenuWillBecomeInvisible

    private void btnAgregarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoMovilActionPerformed
        agregarTelefono();
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void jcbPersonaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        txtPNombre.requestFocus();
    }//GEN-LAST:event_jcbPersonaPopupMenuWillBecomeInvisible

    private void jcbEstadoCivilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible
        jcbSexo.requestFocus();
        jcbSexo.showPopup();
    }//GEN-LAST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible

    private void btnAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        agregarCorreo();
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void txtTelelfonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilActionPerformed
        btnAgregarTelefonoMovil.doClick();
    }//GEN-LAST:event_txtTelelfonoMovilActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        btnAgregarCorreo.doClick();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnAgregarDireccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionesActionPerformed
        agregarDireccion();
        repararColumnaTable(tblDireccion);
    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnBorrarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoMovilActionPerformed
        eliminarRegistro(tblTelefonos, dtmTelefono);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnBorrarTelefonoMovilActionPerformed

    private void btnEliminarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreoActionPerformed
        eliminarRegistro(tblCorreos, dtmCorreo);
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnEliminarCorreoActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        btnAgregarDirecciones.doClick();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void jcbProvinciasPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbProvinciasPopupMenuWillBecomeInvisible
        Direcciones.llenarMunicipios(
                jcbProvincias.getSelectedIndex() <= 0 ? 0 :
                ((Provincias) jcbProvincias.getSelectedItem()).getId(),
                jcbMunicipios);
    }//GEN-LAST:event_jcbProvinciasPopupMenuWillBecomeInvisible

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible
        txtDireccion.requestFocus();
    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

    private void btnEliminarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecionActionPerformed
        eliminarRegistro(tblDireccion, dtmDireccion);
        repararColumnaTable(tblDireccion);
    }//GEN-LAST:event_btnEliminarDirrecionActionPerformed

    private void txtCedula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedula2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2ActionPerformed

    private void txtCedula2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2KeyReleased

    private void btnEliminarDirrecion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDirrecion1ActionPerformed

    private void btnEliminarDirrecion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDirrecion2ActionPerformed

    private void btnEliminarDirrecion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecion3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarDirrecion3ActionPerformed

    private void cbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivoActionPerformed
        if (cbActivo.isSelected()) {
            cbActivo.setText("Activo");
        } else {
            cbActivo.setText("Inactivo");
        }
        btnGuardar.requestFocus();
    }//GEN-LAST:event_cbActivoActionPerformed

    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed

    }//GEN-LAST:event_btnCedulaValidadActionPerformed

    private void eliminarRegistro(JTable tabla, DefaultTableModel modelo) {
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un registro de la tabla",
                    "Validaccion de proceso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        modelo.removeRow(tabla.getSelectedRow());
        tabla.setModel(modelo);
    }

    private KeyListener limitarCaracteres(final int limite, final JFormattedTextField txt) {

        KeyListener keyListener = new KeyListener() {
            private int suma = 0;

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                suma = suma + 1;
                if (suma == limite) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "El limte se caracteres es " + suma + "\n" + txt.getText());

                }
            }
        };
        return keyListener;
    }

    private void agregarTelefono() {
        if (txtTelelfonoMovil.getValue() == null) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe digitar numero telefonico.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtTelelfonoMovil.requestFocusInWindow();
            return;
        }

        if (!ValidarCorreoTel.telefono(txtTelelfonoMovil.getValue().toString())) {
            LOG.log(Level.INFO, "TEL:" + txtTelelfonoMovil.getValue().toString());
            JOptionPane.showInternalMessageDialog(this,
                    "Debe digitar numero telefonico valido.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (!jrbMovil.isSelected()) {
            if (!jrbResidencial.isSelected()) {
                JOptionPane.showInternalMessageDialog(this,
                        "Debes de seleccionar un tipo de conctato, movil o telefono.",
                        "Validacción de contacto.", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        registroTel[0] = txtTelelfonoMovil.getValue();
        registroTel[1] = jrbMovil.isSelected() ? "Movil" : "Telefono";

        dtmTelefono.addRow(registroTel);
        tblTelefonos.setModel(dtmTelefono);

        txtTelelfonoMovil.setValue(null);
        txtTelelfonoMovil.requestFocus();
        registroTel = new Object[titulosTel.length];
    }

    private void agregarCorreo() {
        if (txtCorreo.getText().isBlank() || txtCorreo.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe digitar correo electronico.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCorreo.requestFocusInWindow();
            return;
        }

        if (!ValidarCorreoTel.correo(txtCorreo.getText())) {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe digitar correo electronico valido.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtCorreo.requestFocusInWindow();
            return;
        }

        registroCorreo[0] = txtCorreo.getText();
        dtmCorreo.addRow(registroCorreo);
        tblCorreos.setModel(dtmCorreo);

        registroCorreo = new Object[titulosCorreo.length];
        txtCorreo.setText("");
        txtCorreo.requestFocus();
    }

    private void agregarDireccion() {
        if (jcbProvincias.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe seleccionar una provincia.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            jcbProvincias.requestFocus();
            jcbProvincias.showPopup();
            return;
        }

        if (jcbMunicipios.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe seleccionar un municipio.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            jcbMunicipios.requestFocus();
            jcbMunicipios.showPopup();
            return;
        }

        if (txtDireccion.getText().isBlank() || txtDireccion.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe digitar dirección.!",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtDireccion.requestFocusInWindow();
            return;
        }

        registroDireccion[0] = jcbProvincias.getSelectedItem();
        registroDireccion[1] = jcbMunicipios.getSelectedItem();

        registroDireccion[2] = jcbDistritoMunicipal.getSelectedItem();

        registroDireccion[3] = txtDireccion.getText();

        dtmDireccion.addRow(registroDireccion);
        tblDireccion.setModel(dtmDireccion);

        jcbProvincias.setSelectedIndex(0);
        jcbMunicipios.setSelectedIndex(0);
        jcbDistritoMunicipal.setSelectedIndex(0);
        registroDireccion = new Object[titulosDireccion.length];
        txtDireccion.setText("");
    }

    public static void llenarTablaClientes() {
        String titulos[] = {"Cedulas", "Persona", "Primer Nombre", "Segundo Nombre",
            "Apellidos", "Sexo", "Fecha nacimiento", "Fecha Ingreso", "Estado"};

        Object registro[] = new Object[titulos.length];

        try {
            ResultSet rs = getClientesTablaSB();
            dtmClientes = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                Generales g = Generales.builder().
                        cedula(rs.getString("cedula")).build();

                Clientes p = Clientes.builder().
                        id_persona(rs.getInt("id")).
                        generales(g).build();
                registro[0] = p;
                registro[1] = rs.getString("persona").equalsIgnoreCase("j") ? "JURÍDICA" : "FÍSICA";
                registro[2] = rs.getString("pnombre");
                registro[3] = rs.getString("snombre");
                registro[4] = rs.getString("apellidos");
                registro[5] = rs.getString("sexo").equalsIgnoreCase("M") ? "MASCULINO" : "FEMENINO";
                registro[6] = Utilidades.formatDate(rs.getDate("fecha_nacimiento"), "dd/MM/yyyy");
                registro[7] = Utilidades.formatDate(rs.getDate("fecha_Ingreso"), "dd/MM/yyyy");
                registro[8] = rs.getBoolean("Estado");
                dtmClientes.addRow(registro);
            }
            tblClientes.setModel(dtmClientes);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Para Alinear el Texto de la Table a la Derecha...
//        DefaultTableCellHeaderRenderer tcr = new DefaultTableCellHeaderRenderer();
//
//        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
//        tblClientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
//        tblClientes.getColumnModel().getColumn(4).setCellRenderer(tcr);
        tblClientes.getColumnModel().getColumn(8).setCellEditor(new Celda_CheckBox());
        tblClientes.getColumnModel().getColumn(8).setCellRenderer(new Render_CheckBox());

        repararColumnaTable(tblClientes);
    }

    private boolean validarRegistro() {
        if (tblClientes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe contar con clientes en registros, Ingrese nuevos clientes.",
                    "Proceso de validación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        if (tblClientes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe de seleccionar un cliente",
                    "Proceso de validación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        if (((Personas) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)).getId_persona() == 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Cliente GENERICO no puede ser modificado",
                    "Proceso de validación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    private void mostrarRegistro() {

        int idCliente = ((Personas) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)).getId_persona();

        //Buscar un resulSet con los campos necesarios
        ResultSet rCliente = getClienteByID(idCliente);
        txtPNombre.requestFocus();
        try {
            rCliente.next();
            //Llenar los compos basicos.
            txtCedula.setValue(rCliente.getString("CEDULA"));
            txtPNombre.setText(rCliente.getString("PNOMBRE"));
            txtSNombre.setText(rCliente.getString("SNOMBRE"));
            txtApellidos.setText(rCliente.getString("APELLIDOS"));
            dchFechaNacimiento.setDate(rCliente.getDate("FECHA_NACIMIENTO"));
            cbActivo.setSelected(rCliente.getBoolean("ESTADO"));

            //Colocar los jcb en posicion. 
            for (int i = 0; i < jcbPersona.getItemCount(); i++) {
                if (rCliente.getString("PERSONA").equalsIgnoreCase(
                        "" + ((TipoPersona) jcbPersona.getItemAt(i)).getAbreviatura())) {
                    jcbPersona.setSelectedIndex(i);
                    break;

                }
            }

            for (int i = 0; i < jcbSexo.getItemCount(); i++) {
                if (rCliente.getString("SEXO").equalsIgnoreCase(
                        "" + ((Sexo) jcbSexo.getItemAt(i)).getAbreviatura())) {
                    jcbSexo.setSelectedIndex(i);
                    break;

                }
            }

            for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
                if (rCliente.getString("ESTADO_CIVIL").equalsIgnoreCase(
                        "" + ((EstadoCivil) jcbEstadoCivil.getItemAt(i)).getAbreviatura())) {
                    jcbEstadoCivil.setSelectedIndex(i);
                    break;

                }
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        ResultSet rDir = getDireccionByID(idCliente);

        try {
            while (rDir.next()) {
                Provincias p = Provincias.builder().
                        id(rDir.getInt("ID_PROVINCIA")).
                        nombre(rDir.getString("PROVINCIA")).build();
                registroDireccion[0] = p;

                Municipios m = Municipios.builder().
                        id(rDir.getInt("ID_MUNICIPIO")).
                        nombre(rDir.getString("MUNICIPIO")).build();
                registroDireccion[1] = m;

                Distritos_municipales d = Distritos_municipales.builder().
                        id(rDir.getInt("ID_DISTRITO_MUNICIPAL")).
                        nombre(rDir.getString("DISTRITO_MUNICIPAL")).build();
                registroDireccion[2] = d;

                registroDireccion[3] = rDir.getString("DIRECCION");

                registroDireccion[4] = rDir.getDate("FECHA");

                dtmDireccion.addRow(registroDireccion);
            }
            tblDireccion.setModel(dtmDireccion);
            registroDireccion = new Object[titulosDireccion.length];
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        ResultSet rTel = getTelefonoByID(idCliente);
        try {
            while (rTel.next()) {
                ContactosTel t = ContactosTel.builder().
                        id(rTel.getInt("ID")).
                        telefono(rTel.getString("TELEFONO")).
                        tipo(rTel.getString("TIPO")).
                        fecha(rTel.getDate("FECHA")).build();

                registroTel[0] = t;
                registroTel[1] = t.getTipo();
                registroTel[2] = t.getFecha();

                dtmTelefono.addRow(registroTel);
            }
            tblTelefonos.setModel(dtmTelefono);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        registroTel = new Object[titulosTel.length];

        ResultSet rCor = getCorreoByID(idCliente);
        try {
            while (rCor.next()) {
                ContactosEmail c = ContactosEmail.builder().
                        id(rCor.getInt("ID")).
                        email(rCor.getString("EMAIL")).
                        fecha(rCor.getDate("FECHA")).build();

                registroCorreo[0] = c;
                registroCorreo[1] = c.getFecha();

                dtmCorreo.addRow(registroCorreo);
            }
            tblCorreos.setModel(dtmCorreo);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        registroCorreo = new Object[titulosCorreo.length];
    }

    private void cambioBoton(boolean activo) {
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspClientes), !activo);
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspMantenimiento), activo);

        if (activo) {
            jtpUnico.setSelectedComponent(jspMantenimiento);
        } else {
            jtpUnico.setSelectedComponent(jspClientes);
        }

        jtpDireccionContactos.setSelectedComponent(jpDireccion);

        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(!activo);
        btnModificar.setEnabled(!activo);
        btnBorrar.setEnabled(!activo);
        btnBuscar.setEnabled(!activo);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(activo);
        btnCancelar.setEnabled(activo);

        //txt Vaciar
        txtPNombre.setText(null);
        txtSNombre.setText(null);
        txtApellidos.setText(null);

        dchFechaNacimiento.setDate(new Date());

        cbActivo.setSelected(activo);

        jcbPersona.setSelectedIndex(0);
        jcbEstadoCivil.setSelectedIndex(0);
        jcbSexo.setSelectedIndex(0);

        jcbProvincias.setSelectedIndex(0);
        jcbMunicipios.setSelectedIndex(0);
        jcbDistritoMunicipal.setSelectedIndex(0);
        txtDireccion.setText(null);

        jrbMovil.setSelected(true);

        if (nuevo) {
            //Nuevo registro
            txtCedula.setValue(null);
            txtCedula.setEditable(nuevo);
            txtCedula.requestFocus();
        } else {
            //Modificar registro
            //Consultar si el usuario tiene permiso para modificar la cedula.
            Privilegios p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("CEDULA").build();
            txtCedula.setEditable(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PNOMBRE").build();
            txtPNombre.setEditable(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PNOMBRE").build();
            txtSNombre.setEditable(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("APELLIDOS").build();
            txtApellidos.setEditable(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("FECHA_NACIMIENTO").build();
            dchFechaNacimiento.setEnabled(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PERSONA").build();
            jcbPersona.setEnabled(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("ESTADO_CIVIL").build();
            jcbEstadoCivil.setEnabled(privilegioCampo(p));
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("SEXO").build();
            jcbSexo.setEnabled(privilegioCampo(p));
            
            
            p = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("ESTADO").build();
            cbActivo.setEnabled(privilegioCampo(p));
            
            txtPNombre.requestFocus();
            
        }
        nuevasTablasDirTelCor();

    }

    private void nuevasTablasDirTelCor() {
        dtmTelefono = new DefaultTableModel(null, titulosTel);
        tblTelefonos.setModel(dtmTelefono);

        dtmDireccion = new DefaultTableModel(null, titulosDireccion);
        tblDireccion.setModel(dtmDireccion);

        dtmCorreo = new DefaultTableModel(null, titulosCorreo);
        tblCorreos.setModel(dtmCorreo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarDirecciones;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    public RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCedulaValidad;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion2;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion3;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorial;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbActivo;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane3;
    private static RSMaterialComponent.RSComboBox jcbDistritoMunicipal;
    private javax.swing.JComboBox jcbEstadoCivil;
    private static RSMaterialComponent.RSComboBox jcbMunicipios;
    private static javax.swing.JComboBox jcbPersona;
    private static RSMaterialComponent.RSComboBox jcbProvincias;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JScrollPane jspMantenimiento;
    private javax.swing.JTabbedPane jtpDireccionContactos;
    public static javax.swing.JTabbedPane jtpUnico;
    private static javax.swing.JTable tblClientes;
    private javax.swing.JTable tblCorreos;
    private javax.swing.JTable tblDireccion;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedula2;
    private RSMaterialComponent.RSTextFieldIconOne txtCorreo;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
}
