package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.entidades.ValidarCorreoTel;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.entidades.Clientes.agregarCliente;
import static sur.softsurena.entidades.Clientes.borrarCliente;
import static sur.softsurena.entidades.Clientes.existeCliente;
import static sur.softsurena.entidades.Clientes.getClienteByID;
import static sur.softsurena.entidades.Clientes.getClientesTablaSB;
import static sur.softsurena.entidades.Clientes.modificarCliente;
import static sur.softsurena.entidades.ContactosEmail.TITULOS_CORREO;
import sur.softsurena.entidades.Privilegios;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.entidades.ContactosEmail.getCorreoByID;
import static sur.softsurena.entidades.ContactosTel.TITULOS_TELEFONO;
import static sur.softsurena.entidades.ContactosTel.getTelefonoByID;
import static sur.softsurena.entidades.Direcciones.getDireccionByID;
import static sur.softsurena.entidades.Distritos_municipales.getDistritosMunicipales;
import static sur.softsurena.entidades.Municipios.getMunicipio;
import static sur.softsurena.entidades.Privilegios.privilegioCampo;
import static sur.softsurena.entidades.Privilegios.privilegioTabla;
import static sur.softsurena.entidades.Provincias.getProvincias;

public final class frmClientes extends javax.swing.JInternalFrame implements Runnable {

    private static final Logger LOG = Logger.getLogger(frmClientes.class.getName());

    private boolean nuevo = false;

    private JTextFieldDateEditor editor = null;

    private static DefaultTableModel dtmTelefono, dtmCorreo, dtmDireccion;

    private frmDetalleFacturaClientes miDetalle;

    private List<Direcciones> direcciones;

    private List<ContactosEmail> contactosCorreos;

    private List<ContactosTel> contactosTels;

    private Privilegios privilegios;

    private Thread hilo;

    private final List<String> vistasList;

    private static final String PROCESO_DE_VALIDACION = "Proceso de validacion.";
    private static final String VALIDACCION_DE_CONTACTO = "Validacción de contacto.";

    private final static String[] TITULOS_DIRECCION = {"Provincia", "Municipio",
        "Distrito M.", "Calle y No. Casa", "Fecha"};

    public frmClientes() {
        // Lista de vista que se utilizan para operar ventanas de cliente.
        vistasList = new ArrayList<>();

        vistasList.add("V_GENERALES");
        vistasList.add("V_PERSONAS");
        vistasList.add("V_PERSONAS_CLIENTES");
        vistasList.add("V_CONTACTOS_DIRECCIONES");
        vistasList.add("V_CONTACTOS_EMAIL");
        vistasList.add("V_CONTACTOS_TEL");

        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        vistasList.stream().forEach(vista -> {

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_SELECT).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(privilegios);

            if (!priviledio) {

                String mensaje = "No cuenta con permisos para ver la información de"
                        + " este módulo.";

                JOptionPane.showInternalMessageDialog(
                        null,
                        mensaje,
                        "Validación de proceso",
                        JOptionPane.WARNING_MESSAGE
                );

                throw new ExceptionInInitializerError(mensaje);
            }
        });

        //Metodo encargado de inicializar los componentes del formulario.
        initComponents();

        direcciones = new ArrayList<>();
        contactosCorreos = new ArrayList<>();
        contactosTels = new ArrayList<>();

        try {
            txtTelelfonoMovil.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        editor.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(37, 45, 223), 2, true),
                "Fecha nacimiento",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("FreeSans", 0, 12)));

        editor.addActionListener((ActionEvent e) -> {
            jcbEstadoCivil.requestFocus();
            jcbEstadoCivil.showPopup();
        });

        //Mantenimiento oculto por defecto.
        jtpUnico.remove(jspMantenimiento);

        nuevasTablasDirTelCor();

        //Permiso para el boton de nuevo
        int cantFalso = 0;
        for (String vista : vistasList) {
            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_INSERT).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnNuevo.setEnabled(cantFalso == 0);

        //Permiso para el boton de Borrar
        cantFalso = 0;
        for (String vista : vistasList) {
            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_DELETE).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnBorrar.setEnabled(cantFalso == 0);

        //Permiso para el boton de Modificar
        cantFalso = 0;
        for (String vista : vistasList) {
            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnModificar.setEnabled(cantFalso == 0);
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
        cbEstado = new javax.swing.JCheckBox();
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
        btnAgregarDirecciones = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarDirrecion = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtDireccion = new javax.swing.JTextField();
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

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administración Clientes");
        setFocusTraversalPolicyProvider(true);
        setMinimumSize(new java.awt.Dimension(915, 535));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
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
                formInternalFrameOpened(evt);
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

        tblClientes.setAutoCreateRowSorter(true);
        tblClientes.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblClientes.setName("tblClientes"); // NOI18N
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
                .addContainerGap(425, Short.MAX_VALUE))
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
                .add(jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jScrollPane3))
                .addContainerGap())
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel15, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
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

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setSelected(true);
        cbEstado.setText("Activo");
        cbEstado.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        cbEstado.setFocusTraversalPolicyProvider(true);
        cbEstado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbEstado.setMinimumSize(new java.awt.Dimension(0, 0));
        cbEstado.setName("cbEstado"); // NOI18N
        cbEstado.setPreferredSize(new java.awt.Dimension(0, 25));
        cbEstado.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
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
        tblDireccion.setName("tblDireccion"); // NOI18N
        tblDireccion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane8.setViewportView(tblDireccion);

        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 6, 0));

        jcbProvincias.setForeground(new java.awt.Color(37, 45, 223));
        jcbProvincias.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbProvincias.setName("jcbProvincia"); // NOI18N
        jcbProvincias.setNextFocusableComponent(jcbMunicipios);
        jcbProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProvinciasActionPerformed(evt);
            }
        });
        jPanel2.add(jcbProvincias);

        jcbMunicipios.setForeground(new java.awt.Color(37, 45, 223));
        jcbMunicipios.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbMunicipios.setEnabled(false);
        jcbMunicipios.setName("jcbMunicipios"); // NOI18N
        jcbMunicipios.setNextFocusableComponent(jcbDistritoMunicipal);
        jcbMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMunicipiosActionPerformed(evt);
            }
        });
        jPanel2.add(jcbMunicipios);

        jcbDistritoMunicipal.setForeground(new java.awt.Color(37, 45, 223));
        jcbDistritoMunicipal.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbDistritoMunicipal.setEnabled(false);
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
        jcbDistritoMunicipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDistritoMunicipalActionPerformed(evt);
            }
        });
        jPanel2.add(jcbDistritoMunicipal);

        jPanel6.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.setName("btnAgregarDirecciones"); // NOI18N
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });
        jPanel6.add(btnAgregarDirecciones);

        btnEliminarDirrecion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarDirrecion.setName("btnEliminarDirrecion"); // NOI18N
        btnEliminarDirrecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecionActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminarDirrecion);

        txtDireccion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtDireccion.setDoubleBuffered(true);
        txtDireccion.setFocusTraversalPolicyProvider(true);
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 0));
        txtDireccion.setName("txtDireccion"); // NOI18N
        txtDireccion.setNextFocusableComponent(txtSNombre);
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 25));
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
                .addContainerGap()
                .add(txtDireccion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 111, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
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
                .add(jScrollPane8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpDireccionContactos.addTab("Dirección", jpDireccion);

        jTabbedPane3.setName("telefonoCorreos"); // NOI18N

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
        txtTelelfonoMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelelfonoMovilKeyPressed(evt);
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
                .addContainerGap(310, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {btnAgregarTelefonoMovil, btnBorrarTelefonoMovil}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(txtTelelfonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnAgregarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnBorrarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel8Layout.createSequentialGroup()
                        .add(jrbMovil)
                        .add(0, 0, 0)
                        .add(jrbResidencial)))
                .add(3, 3, 3))
        );

        jPanel8Layout.linkSize(new java.awt.Component[] {btnAgregarTelefonoMovil, btnBorrarTelefonoMovil, txtTelelfonoMovil}, org.jdesktop.layout.GroupLayout.VERTICAL);

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
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
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
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {btnAgregarCorreo, btnEliminarCorreo}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                        .add(btnAgregarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(btnEliminarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(txtCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {btnAgregarCorreo, btnEliminarCorreo}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel11Layout.createSequentialGroup()
                .add(3, 3, 3)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 45, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
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
        btnCedulaValidad.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SYNC);
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
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtPNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(dchFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 185, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnCedulaValidad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtSNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtApellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(cbEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jcbSexo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(6, 6, 6))
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {cbEstado, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbEstado, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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

        jPanel1Layout.linkSize(new java.awt.Component[] {btnCedulaValidad, cbEstado, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtCedula, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.VERTICAL);

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
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .add(jtpUnico, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jtpUnico, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .add(0, 0, 0)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("Unused Element")
    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        dchFechaNacimiento.requestFocus();
        editor.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        jcbPersona.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (txtPNombre.getText().isBlank() && !txtSNombre.getText().isEmpty()) {
            txtPNombre.setText(txtSNombre.getText());
            txtSNombre.setText("");
        }
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo = true;//Se va a ingresar un nuevo registro al sistema
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validarRegistro()) {
            return;
        }

        nuevo = false;

        cambioBoton(true);

        Integer idCliente = ((Personas) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)).getId_persona();

        mostrarRegistro(idCliente);

        repararColumnaTable(tblCorreos);
        repararColumnaTable(tblDireccion);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnModificarActionPerformed

    /**
     * Proceso de validación.
     *
     * 1) Se valida que la cedula del cliente no esté vacia.
     *
     * 2) Primer nombre y apellidos no puede estar vació.
     *
     * 3) Debe Existir un dirección registrada.
     *
     * 4) Debe Proporcionarse una fecha de nacimiento.
     *
     * 5) La fecha de nacimiento no puede ser mayor a la actual.
     *
     * 6) Debe exitir una forma de contacto obligatorio.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Hacemos la validaciones de los campos.
        try {
            txtCedula.commitEdit();
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar la cedula del cliente",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            txtCedula.requestFocus();
            txtCedula.selectAll();
            return;
        }

        if (txtPNombre.getText().isBlank()) {//2
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar un nombre...",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            txtPNombre.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().isBlank()) {//2
            JOptionPane.showInternalMessageDialog(null,
                    "Debe digitar un apellido...",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            txtApellidos.requestFocusInWindow();
            return;
        }

        if (tblDireccion.getRowCount() < 1) {//3
            JOptionPane.showInternalMessageDialog(null,
                    "Debe digitar una direccion del cliente.",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            txtDireccion.requestFocus();
            return;
        }

        if (dchFechaNacimiento.getDate() == null) {//4
            JOptionPane.showInternalMessageDialog(null,
                    "Debe indicar una fecha de nacimiento.",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {//5
            JOptionPane.showInternalMessageDialog(null,
                    "Fecha de nacimiento incorrecta!",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        //Recogiendo la cantidad de telefono y correo registrado del cliente.
        int cantTelefono = tblTelefonos.getRowCount();
        int cantCorreo = tblCorreos.getRowCount();

        if (cantCorreo < 1 || cantTelefono < 1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "No existe forma de contactar al cliente, "
                    + "\nAgregue un numero de telefono o correo electronico.",
                    PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        /*
            Fin del proceso de validacion basica.
         */
        Integer idCliente = existeCliente(txtCedula.getValue().toString());

        // si es nuevo validamos que el Cliente no exista
        if (nuevo) {
            if (idCliente != -1) {
                //Preguntar si desea carga la data desde la base de datos.
                int resp = JOptionPane.showInternalConfirmDialog(
                        null,
                        "Cliente se encuentra en la base de datos. \nDesea cargar el registro?",
                        "Recuperación de datos",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                if (resp == JOptionPane.NO_OPTION) {
                    return;
                }

                //Carga la informacion del cliente que se trata de registrar
                mostrarRegistro(idCliente);
            }
        } else {
            if (idCliente == -1) {
                /*
                    Si es una actualización de cliente validamos que la cedula exista
                    en el sistema.
                 */
                int resp = JOptionPane.showConfirmDialog(
                        null,
                        "Desea editar la cedula de cliente.",
                        "Validación de procesos",
                        JOptionPane.YES_NO_OPTION
                );

                if (resp == JOptionPane.NO_OPTION) {
                    return;
                }

            }
        }

        /*
            La general está compuesto solo del estado civil y el numero de 
        cedula.
         */
        Generales g = Generales.builder().
                cedula(txtCedula.getValue().toString()).
                estado_civil(
                        ((EstadoCivil) jcbEstadoCivil.getSelectedItem())
                                .getAbreviatura()).build();

        /*
             Se obtiene el identificador del cliente si este se va a actualizar
        de lo contrario se obtiene un valor 0 si se va a invertar. Ademas se 
        obtienen el tipo de persona se es fisica o juridica, el sexo, sus nombres
        los apellidos, fecha de nacimiento, su estado por defecto es true. 
         */
        Clientes miCliente = Clientes.builder().
                id_persona(idCliente).
                generales(g).
                direccion(direcciones).
                persona(((TipoPersona) jcbPersona.getSelectedItem()).getAbreviatura()).
                sexo(((Sexo) jcbSexo.getSelectedItem()).getAbreviatura()).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                fecha_nacimiento(new java.sql.Date(dchFechaNacimiento.getDate().getTime())).
                estado(cbEstado.isSelected()).
                build();

        /*
            La variable accion es utilizado para ayudar al siguiente mensaje 
        a mostrar los valores de editar o crear el cliente.
         */
        String accion = "editar";

        if (nuevo) {
            accion = "crear";
        }

        int resp = JOptionPane.showConfirmDialog(null,
                "<html><b>Se va a " + accion + " el Cliente: </b>"
                + txtPNombre.getText()
                + (txtSNombre.getText().isEmpty()
                || txtSNombre.getText().isBlank() ? "" : " " + txtSNombre.getText())
                + " " + txtApellidos.getText()
                + "<br><b>Cedula no.: </b> " + txtCedula.getText()
                + "<br><b>Fecha Nacimiento: </b>" + Utilidades.formatDate(dchFechaNacimiento.getDate(), "dd-MM-yyyy")
                + "<br><b>Estado del Cliente: </b>" + cbEstado.getText()
                + "<br><b>Desea continuar? </b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        String msg;
        int icono;

        if (nuevo) {
            msg = agregarCliente(miCliente, contactosTels, contactosCorreos).getMensaje();

            icono = msg.equals(Clientes.CLIENTE__AGREGADO__CORRECTAMENTE)
                    ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;

            JOptionPane.showInternalMessageDialog(null, msg, "Agregando cliente", icono);

        } else {
            msg = modificarCliente(miCliente).getMensaje();

            icono = msg.equals(Clientes.CLIENTE__MODIFICADO__CORRECTAMENTE)
                    ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE;

            JOptionPane.showInternalMessageDialog(null, msg, "Modificando cliente", icono);
        }

        btnCancelarActionPerformed(null);

        contactosCorreos.clear();
        contactosTels.clear();
        direcciones.clear();

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        nuevo = false;
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //Validamos que todo está correcto en la tabla.
        //Si el metodo devuelve true devolvemos el proceso. 
        if (validarRegistro()) {
            return;
        }

        //Mostramos un mensaje de advertencia si el usuario desea continuar con 
        //la eliminación del registro. 
        int rta = JOptionPane.showConfirmDialog(null,
                "¿Esta Seguro de Eliminar Registro del Cliente?",
                "Eliminar Cliente",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        //Si el usuario responde a que no a las opciones entonces devolvemos el 
        //proceso.
        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        //Para eliminar un registro de un cliente obtenemos el ID y su estado
        int idCliente = ((Clientes) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0)).getId_persona();

        //Mandamos a borrar el cliente y obtenemos el resultado de la operacion
        //y almacenamos en una variable.
        String mensaje = borrarCliente(idCliente).getMensaje();

        //Posibles icono a utilizar en el JOpcionPane
        int icono = mensaje.equals(Clientes.CLIENTE_BORRADO_CORRECTAMENTE)
                ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE;

        JOptionPane.showInternalMessageDialog(null,
                mensaje,
                "Proceso de borrado de cliente.",
                icono);

        //Actualizamos los cambios en la Tabla
        //llenarTablaClientes(); La tabla se está llenando desde los postEvent de Firebird
        repararColumnaTable(tblClientes);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Hilo creado para ganar focus en la ventana de JopcionPane en buscar 
        //cedula
        hilo = new Thread(this);
        hilo.start();

        txtCedula2.setValue("");

        int resp = JOptionPane.showInternalConfirmDialog(
                null,
                txtCedula2,
                "Buscar cliente por cedula: ",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        hilo.interrupt();

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            txtCedula2.commitEdit();
        } catch (ParseException ex) {
            LOG.log(Level.SEVERE, "Error a parsear la cedula.", ex);
            return;
        }

        if (existeCliente(txtCedula2.getValue().toString()) == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "El Cliente No Existe!",
                    "Proceso de busqueda terminado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 0; i < tblClientes.getRowCount(); i++) {

            if (tblClientes.getValueAt(i, 0).toString().contains(
                    txtCedula2.getText())) {
                tblClientes.setRowSelectionInterval(i, i);
                break;
            }

            if (txtCedula2.getText().isBlank()) {
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

    private void btnAgregarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoMovilActionPerformed

        try {
            //Validacion para agregar un telefono a la lista.
            //Que el campo de telefono o movil no sea nulo para poder registrarlo.
            txtTelelfonoMovil.commitEdit();
        } catch (ParseException ex) {
            Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (txtTelelfonoMovil.getValue() == null) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe digitar numero telefonico.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtTelelfonoMovil.setValue("");
            txtTelelfonoMovil.requestFocus();
            return;
        }

        //Esta validacion deberia de ser si el cliente en nacional
        if (!ValidarCorreoTel.telefono(txtTelelfonoMovil.getValue().toString())) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe digitar numero telefonico valido.",
                    "Validacción de contacto.",
                    JOptionPane.INFORMATION_MESSAGE);
            txtTelelfonoMovil.setValue("");
            return;
        }

        String telefono = txtTelelfonoMovil.getValue().toString();
        String tipo = (jrbMovil.isSelected() ? "Movil" : "Telefono");

        //Array de Object para la tabla.
        Object registroTel[] = new Object[TITULOS_TELEFONO.length];
        registroTel[0] = telefono;
        registroTel[1] = tipo;

        //Objecto List para contactos telefonico.
        contactosTels.add(ContactosTel.builder().
                telefono(telefono).
                tipo(tipo).build());

        dtmTelefono.addRow(registroTel);
        tblTelefonos.setModel(dtmTelefono);

        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocus();

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
        /*
            Validamos que el correo no esté vacio.
         */
        if (txtCorreo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar correo electronico.",
                    VALIDACCION_DE_CONTACTO,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtCorreo.requestFocusInWindow();
            return;
        }

        /*
            Verificamos que sea un correo valido.
         */
        if (!ValidarCorreoTel.correo(txtCorreo.getText())) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar correo electronico valido.",
                    VALIDACCION_DE_CONTACTO,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtCorreo.requestFocusInWindow();
            return;
        }

        if (nuevo) {
            //Llenamos el List de correo.
            contactosCorreos.add(
                    ContactosEmail.
                            builder().
                            email(txtCorreo.getText()).
                            build()
            );
        } else {
            //Necesitamos el Id del registro del correo.

        }

        /*
            Creamos un objecto de tipo array para las columnas. 
            Dichas columnas son Correo y Fecha.
         */
        Object registroCorreo[] = {txtCorreo.getText()};

        //Ingresamos el array al modelo
        dtmCorreo.addRow(registroCorreo);

        //Y al modelo lo pasamos a la tabla para ser mostrado.
        tblCorreos.setModel(dtmCorreo);

        //Limpiamos campos y solicitamos el focus.
        txtCorreo.setText("");
        txtCorreo.requestFocus();

        //Reparamos la columnas de la tabla. 
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed


    private void txtTelelfonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilActionPerformed
        btnAgregarTelefonoMovil.doClick();
    }//GEN-LAST:event_txtTelelfonoMovilActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        btnAgregarCorreo.doClick();
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnAgregarDireccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionesActionPerformed
        //Nos aseguramos que exista una provincia seleccionada. 
        if (jcbProvincias.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe seleccionar una provincia.",
                    "Validacción de contacto.",
                    JOptionPane.WARNING_MESSAGE
            );
            jcbProvincias.requestFocus();
            jcbProvincias.showPopup();
            return;
        }

        //Nos aseguramos que exiista un municipio seleccionado
        if (jcbMunicipios.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe seleccionar un municipio.",
                    "Validacción de contacto.",
                    JOptionPane.WARNING_MESSAGE
            );
            jcbMunicipios.requestFocus();
            jcbMunicipios.showPopup();
            return;
        }

        //La direccion residencia debe escribirse en la caja de texto de direccion.
        if (txtDireccion.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar dirección.!",
                    "Validacción de contacto.",
                    JOptionPane.WARNING_MESSAGE
            );
            txtDireccion.requestFocusInWindow();
            return;
        }

        //Se necesita el identificador del cliente para hacer un INSERT a la
        //Tabla de direcciones.
        int idCliente = (nuevo ? -1 : ((Clientes) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0)).getId_persona());

        /*
            Se preparan la provincia, municipio y el distrito municipal.
         */
        Provincias provincia = (Provincias) jcbProvincias.getSelectedItem();
        Municipios municipio = (Municipios) jcbMunicipios.getSelectedItem();
        Distritos_municipales dm = (Distritos_municipales) jcbDistritoMunicipal.getSelectedItem();

        Direcciones direccion = Direcciones.
                builder().
                id_persona(idCliente).
                provincia(provincia).
                municipio(municipio).
                distrito_municipal(dm).
                direccion(txtDireccion.getText()).
                build();

        direcciones.add(direccion);

        /*
            Se crea un array de objecto para agregarlo a la tabla como un 
        registro.
         */
        Object registroDireccion[] = new Object[TITULOS_DIRECCION.length];

        /*
            Se rellena los objetos del array con cada jcb que componen una dire-
        ccion de cada cliente.
         */
        registroDireccion[0] = provincia;
        registroDireccion[1] = municipio;
        registroDireccion[2] = dm;
        registroDireccion[3] = txtDireccion.getText();

        /*
            Se obtiene el modelo actual de la tabla de direcciones del cliente.
         */
        dtmDireccion = (DefaultTableModel) tblDireccion.getModel();

        /*
            Se agrega el nuevo registro al modelo.
         */
        dtmDireccion.addRow(registroDireccion);

        /*
            Modelo colocado en la tabla. 
         */
        tblDireccion.setModel(dtmDireccion);

        if (!nuevo) {//Si va a modificar entonces hacemos un insert 
            Direcciones.agregarDireccion(idCliente, direccion);
        }

        //Colocamos los jcb en la posicion cero
        jcbProvincias.setSelectedIndex(0);
        jcbMunicipios.setSelectedIndex(0);
        jcbDistritoMunicipal.setSelectedIndex(0);

        //Deshabilitamos los dos jcb por defecto.
        jcbMunicipios.setEnabled(false);
        jcbDistritoMunicipal.setEnabled(false);

        //Limpiamos el campo de la direccion.
        txtDireccion.setText("");

        /*
            Se reparan los anchos de la columnas de la tabla. 
         */
        repararColumnaTable(tblDireccion);
    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnBorrarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoMovilActionPerformed
        if (nuevo) {

        } else {

        }
        eliminarRegistro(tblTelefonos, dtmTelefono);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnBorrarTelefonoMovilActionPerformed

    private void btnEliminarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreoActionPerformed
        if (nuevo) {

        } else {

        }
        eliminarRegistro(tblCorreos, dtmCorreo);
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnEliminarCorreoActionPerformed

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

    private void btnEliminarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecionActionPerformed

        direcciones.remove(tblDireccion.getSelectedRow());

        eliminarRegistro(tblDireccion, dtmDireccion);

        repararColumnaTable(tblDireccion);
    }//GEN-LAST:event_btnEliminarDirrecionActionPerformed
    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
        btnGuardar.requestFocus();
    }//GEN-LAST:event_cbEstadoActionPerformed
    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        try {
            /*
                Si se va a insertar un nuevo registro la cedula no debe existir.
                Si existe mostrar mensaje de que el cliente esta registrado
             */
            txtCedula.commitEdit();
        } catch (ParseException ex) {
            LOG.log(Level.INFO, "El formato de la cedula no es el correcto.");
            return;
        }

        String cedula = (String) txtCedula.getValue();

        Integer idCliente = existeCliente(cedula);

        if (nuevo) {//Condicion para cuando el proceso es un nuevo registro.
            if (idCliente != -1) {
                int resp = JOptionPane.showInternalConfirmDialog(
                        null,
                        "Esta cedula está registrada. \nProcede a habilitar la información?",
                        PROCESO_DE_VALIDACION,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                //Preguntamos si desea cargar la informacion del cliente.
                if (resp == JOptionPane.YES_OPTION) {

                    Clientes.agregarClienteById(idCliente);

                    btnCancelarActionPerformed(evt);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null,
                        "Cedula valida, puede continuar.",
                        PROCESO_DE_VALIDACION,
                        JOptionPane.INFORMATION_MESSAGE);
                jcbPersona.requestFocus();
            }
        } else {//Condicion para cuando se va a modificar un registro. 
            /*
                Si se va a actualizar un registro, la cedula debe de existir en la 
            Base de datos. 
             */
            if (idCliente == -1) {
                int resp = JOptionPane.showInternalConfirmDialog(null,
                        "Esta cedula no está registrada, desea continuar",
                        "Proceso de validación",
                        JOptionPane.INFORMATION_MESSAGE);

                if (resp == JOptionPane.NO_OPTION) {
                    txtCedula.setValue(null);
                }
            }
        }

    }//GEN-LAST:event_btnCedulaValidadActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTablaClientes();

        getProvincias(jcbProvincias);

        Personas.llenarPersona(jcbPersona);
        Personas.llenarSexo(jcbSexo);
        Personas.llenarEstadoCivil(jcbEstadoCivil);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        btnAgregarDirecciones.doClick();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void jcbProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProvinciasActionPerformed
        getMunicipio(jcbProvincias.getSelectedIndex() <= 0 ? 0
                : ((Provincias) jcbProvincias.getSelectedItem()).getId(),
                jcbMunicipios);

        if (jcbProvincias.getSelectedIndex() > 0) {
            jcbMunicipios.setEnabled(true);
            jcbMunicipios.requestFocus();
        } else {
            jcbMunicipios.setEnabled(false);
        }
    }//GEN-LAST:event_jcbProvinciasActionPerformed

    private void jcbMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMunicipiosActionPerformed
        getDistritosMunicipales(jcbMunicipios.getSelectedIndex() <= 0 ? 0
                : ((Municipios) jcbMunicipios.getSelectedItem()).getId(),
                jcbDistritoMunicipal);

        if (jcbMunicipios.getSelectedIndex() > 0) {
            jcbDistritoMunicipal.setEnabled(true);
            jcbDistritoMunicipal.requestFocus();
        } else {
            jcbDistritoMunicipal.setEnabled(false);
        }
    }//GEN-LAST:event_jcbMunicipiosActionPerformed

    private void jcbDistritoMunicipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalActionPerformed
        txtDireccion.requestFocus();
    }//GEN-LAST:event_jcbDistritoMunicipalActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        /**
         * El objectivo del siguiente codigo es generar un cedula valida para
         * fines de pruebas del sistema.
         */
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCedula.setText(ValidarCorreoTel.generarCedula());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtTelelfonoMovilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtTelelfonoMovil.setText(ValidarCorreoTel.generarTelMovil());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtTelelfonoMovilKeyPressed

    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCorreo.setText(ValidarCorreoTel.generarCorreo());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    private void eliminarRegistro(JTable tabla, DefaultTableModel modelo) {
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe seleccionar un registro de la tabla",
                    "Validaccion de proceso",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        modelo.removeRow(tabla.getSelectedRow());
        tabla.setModel(modelo);
    }

    /**
     * Metodo utilizado para llenar la tabla de cliente del sistema.
     *
     */
    public synchronized static void llenarTablaClientes() {
        final String titulos[] = {"Cedulas", "Persona", "Primer Nombre", "Segundo Nombre",
            "Apellidos", "Sexo", "Fecha nacimiento", "Fecha Ingreso", "Estado"};

        Object registro[] = new Object[titulos.length];

        DefaultTableModel dtmClientes = new DefaultTableModel(null, titulos);

        getClientesTablaSB().stream().forEach(cliente -> {
            registro[0] = Clientes.
                    builder().
                    id_persona(cliente.getId_persona()).
                    generales(cliente.getGenerales()).
                    build();
            registro[1] = String.valueOf(cliente.getPersona()).equalsIgnoreCase("j") ? "JURÍDICA" : "FÍSICA";
            registro[2] = cliente.getPNombre();
            registro[3] = cliente.getSNombre();
            registro[4] = cliente.getApellidos();
            registro[5] = String.valueOf(cliente.getSexo()).equalsIgnoreCase("M") ? "MASCULINO" : "FEMENINO";
            registro[6] = Utilidades.formatDate(cliente.getFecha_nacimiento(), "dd/MM/yyyy");
            registro[7] = Utilidades.formatDate(cliente.getFecha_ingreso(), "dd/MM/yyyy");
            registro[8] = cliente.getEstado();
            dtmClientes.addRow(registro);
        });

        tblClientes.setModel(dtmClientes);

        int[] indices = {8};
        columnasCheckBox(tblClientes, indices);

        repararColumnaTable(tblClientes);
    }

    /**
     * Este metodo valida que: 1) Que la tabla de clientes del sistema existan
     * registros. 2) Que en la tabla haya un elemento seleccionado. 3) Que
     * cliente seleccionado no sea el GENERICO.
     *
     * @return Devuelve un valor verdadero para indicar que una restriccion, de
     * lo contrario devuelve falso indicando que no existe restriciones.
     */
    private boolean validarRegistro() {
        //Si la tabla de registro de los cliente está vacia devolvemos true
        //para que el proceso no continue.
        if (tblClientes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe contar con clientes en registros, Ingrese nuevos clientes.",
                    "Proceso de validación.",
                    JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblClientes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Debe de seleccionar un cliente",
                    "Proceso de validación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        //Verificamos que el registro no sea de un cliente generico, de serlo lo 
        // devolvemos true para que el proceso no continue. 
        if (((Personas) tblClientes.getValueAt(tblClientes.getSelectedRow(), 0)).getId_persona() == 0) {
            JOptionPane.showInternalMessageDialog(null,
                    "Cliente GENERICO no puede ser modificado",
                    "Proceso de validación.", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }

        //Si todo esta bien enviamos un false para que el proceso se permita..
        return false;
    }

    private void mostrarRegistro(Integer idCliente) {

        //Obteniendo el objeto cliente.
        Clientes cliente = getClienteByID(idCliente);

        //Llenar los compos basicos.
        txtCedula.setValue(cliente.getGenerales().getCedula());
        txtPNombre.setText(cliente.getPNombre());
        txtSNombre.setText(cliente.getSNombre());
        txtApellidos.setText(cliente.getApellidos());
        dchFechaNacimiento.setDate(cliente.getFecha_nacimiento());
        cbEstado.setSelected(cliente.getEstado());

        //Buscando la combinacion del tipo persona con el registro de la 
        //base de datos.
        for (int i = 0; i < jcbPersona.getItemCount(); i++) {
            if (cliente.getPersona()
                    == ((TipoPersona) jcbPersona.getItemAt(i)).getAbreviatura()) {
                jcbPersona.setSelectedIndex(i);
                break;

            }
        }

        //Buscando la combinacion del sexo con el registro de la base de datos.
        for (int i = 0; i < jcbSexo.getItemCount(); i++) {
            if (cliente.getSexo()
                    == ((Sexo) jcbSexo.getItemAt(i)).getAbreviatura()) {
                jcbSexo.setSelectedIndex(i);
                break;

            }
        }

        //Buscando la combinacion del estado civil con el registro de la 
        //base de datos.
        for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
            if (cliente.getGenerales().getEstado_civil()
                    == ((EstadoCivil) jcbEstadoCivil.getItemAt(i)).getAbreviatura()) {
                jcbEstadoCivil.setSelectedIndex(i);
                break;

            }
        }
        //Datos basicos listos. 

        //Obteniendo direcciones.
        dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);

        getDireccionByID(idCliente).stream().forEach(direccione -> {
            Object registroDireccion[] = new Object[TITULOS_DIRECCION.length];

            registroDireccion[0] = direccione.getProvincia();
            registroDireccion[1] = direccione.getMunicipio();
            registroDireccion[2] = direccione.getDistrito_municipal();
            registroDireccion[3] = Direcciones.
                    builder().
                    id(direccione.getId()).
                    direccion(direccione.getDireccion()).build();
            registroDireccion[4] = direccione.getFecha();

            dtmDireccion.addRow(registroDireccion);
        });

        tblDireccion.setModel(dtmDireccion);

        //Obteniendo los telefonos.
        tblTelefonos.setModel(getTelefonoByID(idCliente));

        //Obteniendo los correos.
        tblCorreos.setModel(getCorreoByID(idCliente));

        if (nuevo) {
            txtCedula.requestFocus();
        } else {
            txtPNombre.requestFocus();
        }
    }

    /**
     * Este metodo debe cambiar el comportamiento de la ventana al pulsar sobre
     * nuevo o editar.
     *
     * @param activo Este flag es utilizado cuando se va a ingresar o modificar
     * registros a la base de datos.
     *
     * <b>Si su valor es verdadero:</b>
     * 1) Los botones de nuevo, editar, borrar y buscar deben inhabilitarse. 2)
     * Los botones de guardar y cancelar pasan habilitarse.
     *
     * <b>Si su valor es falso:</b>
     * Lo contrario de cuando su valor es verdadero. 1) Los botones de nuevo,
     * editar, borrar y buscar deben habilitarse. 2) Los botones de guardar y
     * cancelar pasan inhabilitarse.
     *
     * Al presionar nuevo o editar debe cambiarse en la vista clientes a
     * Mantenimiento.
     */
    private void cambioBoton(boolean activo) {
        /*
            Aqui pasan los JScrollPane se alternan con el valor de activo,
        true selecciona el mantenimiento y false selecciona los registros de 
        clientes.
         */
        if (activo) {
            jtpUnico.addTab("Mantenimiento", jspMantenimiento);
            jtpUnico.setSelectedComponent(jspMantenimiento);
        } else {
            jtpUnico.setSelectedComponent(jspClientes);
            jtpUnico.remove(jspMantenimiento);
        }

        /*
            Seleccionamos las pestañas de direcciones por defecto.
         */
        jtpDireccionContactos.setSelectedComponent(jpDireccion);

        /*
            Si el valor de activo es true, quiere decir que se va a insertar o 
        modificar un registro. Por ende, los botones nuevo, modificar, borrar y 
        buscar se deshabilitan.
        
            En caso contrario si el valor de activo es falso, los botones nuevo,
        modificar, borrar y buscar se habilitan.
         */
        btnNuevo.setEnabled(!activo);
        btnModificar.setEnabled(!activo);
        btnBorrar.setEnabled(!activo);
        btnBuscar.setEnabled(!activo);

        //Botones de guardar y cancelar
        btnGuardar.setEnabled(activo);
        btnCancelar.setEnabled(activo);

        //txt Vaciar
        txtPNombre.setText("");
        txtSNombre.setText("");
        txtApellidos.setText("");

        dchFechaNacimiento.setDate(new Date());

        cbEstado.setSelected(activo);

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
            txtCedula.setEditable(true);
            txtCedula.requestFocus();
        } else {
            //Modificar registro
            /**
             * Debo de reducir las siguientes lineas de codigo usando vistaList.
             * Como lo hice en el constructor.
             */
            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("CEDULA").build();

            txtCedula.setEditable(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PNOMBRE").build();
            txtPNombre.setEditable(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("SNOMBRE").build();
            txtSNombre.setEditable(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("APELLIDOS").build();
            txtApellidos.setEditable(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("FECHA_NACIMIENTO").build();
            dchFechaNacimiento.setEnabled(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PERSONA").build();
            jcbPersona.setEnabled(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("ESTADO_CIVIL").build();
            jcbEstadoCivil.setEnabled(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("SEXO").build();
            jcbSexo.setEnabled(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("ESTADO").build();
            cbEstado.setEnabled(privilegioCampo(privilegios) || privilegioTabla(privilegios));

            txtPNombre.requestFocus();
        }

        nuevasTablasDirTelCor();

    }

    private void nuevasTablasDirTelCor() {
        dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(dtmTelefono);

        dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);
        tblDireccion.setModel(dtmDireccion);

        dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(dtmCorreo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarDirecciones;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCedulaValidad;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorial;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbEstado;
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
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (!txtCedula2.hasFocus()) {
            if (txtCedula2.isShowing()) {
                txtCedula2.requestFocus();
            }
        }
    }
}
