package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Clientes;
import static sur.softsurena.entidades.Clientes.agregarCliente;
import static sur.softsurena.entidades.Clientes.borrarCliente;
import static sur.softsurena.entidades.Clientes.existeCliente;
import static sur.softsurena.entidades.Clientes.getClienteByID;
import static sur.softsurena.entidades.Clientes.getClientesTablaSB;
import static sur.softsurena.entidades.Clientes.modificarCliente;
import sur.softsurena.entidades.ContactosEmail;
import static sur.softsurena.entidades.ContactosEmail.TITULOS_CORREO;
import static sur.softsurena.entidades.ContactosEmail.getCorreoByID;
import sur.softsurena.entidades.ContactosTel;
import static sur.softsurena.entidades.ContactosTel.TITULOS_TELEFONO;
import static sur.softsurena.entidades.ContactosTel.getTelefonoByID;
import sur.softsurena.entidades.Direcciones;
import static sur.softsurena.entidades.Direcciones.getDireccionByID;
import sur.softsurena.entidades.Distritos_municipales;
import static sur.softsurena.entidades.Distritos_municipales.getDistritosMunicipales;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipios;
import static sur.softsurena.entidades.Municipios.getMunicipio;
import sur.softsurena.entidades.Personas;
import sur.softsurena.entidades.Privilegios;
import static sur.softsurena.entidades.Privilegios.privilegioCampo;
import static sur.softsurena.entidades.Privilegios.privilegioTabla;
import sur.softsurena.entidades.Provincias;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.entidades.ValidarCorreoTel;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmClientes extends javax.swing.JInternalFrame implements Runnable {

    private static final Logger v_LOG = Logger.getLogger(frmClientes.class.getName());

    private boolean v_nuevo = false;

    private JTextFieldDateEditor v_editor = null;

    private static DefaultTableModel v_dtmTelefono, v_dtmCorreo, v_dtmDireccion;

    private frmDetalleFacturaClientes v_miDetalle;

    private List<Direcciones> v_direccionesList;

    private List<ContactosEmail> v_contactosCorreosList;

    private List<ContactosTel> v_contactosTelsList;

    private final List<String> v_vistasList;

    private Privilegios v_privilegios;

    private Thread v_hilo;

    private static final String v_PROCESO_DE_VALIDACION = "Proceso de validacion.";

    private static final String v_VALIDACCION_DE_CONTACTO = "Validacción de contacto.";

    /**
     * Variable para uso de las columnas de las tablas de las direcciones del
     * cliente. {"Provincia", "Municipio", "Distrito M.", "Calle y No. Casa",
     * "Fecha"}
     */
    private final static String[] v_TITULOS_DIRECCION = {"Provincia", "Municipio",
        "Distrito M.", "Calle y No. Casa", "Fecha"};

    public frmClientes() {
        // Lista de vista que se utilizan para operar ventanas de cliente.
        v_vistasList = new ArrayList<>();
        v_vistasList.add("V_GENERALES");
        v_vistasList.add("V_PERSONAS");
        v_vistasList.add("V_PERSONAS_CLIENTES");
        v_vistasList.add("V_CONTACTOS_DIRECCIONES");
        v_vistasList.add("V_CONTACTOS_EMAIL");
        v_vistasList.add("V_CONTACTOS_TEL");

        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        v_vistasList.stream().forEach(vista -> {

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_SELECT).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(v_privilegios);

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

        v_direccionesList = new ArrayList<>();
        v_contactosCorreosList = new ArrayList<>();
        v_contactosTelsList = new ArrayList<>();

        v_editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        v_editor.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(37, 45, 223), 2, true),
                "Fecha nacimiento",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("FreeSans", 0, 12)));

        v_editor.addActionListener((ActionEvent e) -> {
            jcbEstadoCivil.requestFocus();
            jcbEstadoCivil.showPopup();
        });

        //Mantenimiento oculto por defecto.
        jtpUnico.remove(jspMantenimiento);

        //Reseteando las tablas del modulo.
        nuevasTablasDirTelCor();

        //Permiso para el boton de nuevo
        int cantFalso = 0;
        for (String vista : v_vistasList) {
            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_INSERT).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(v_privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnNuevo.setEnabled(cantFalso == 0);

        //Permiso para el boton de Borrar
        cantFalso = 0;
        for (String vista : v_vistasList) {
            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_DELETE).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(v_privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnBorrar.setEnabled(cantFalso == 0);

        //Permiso para el boton de Modificar
        cantFalso = 0;
        for (String vista : v_vistasList) {
            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion(vista).build();

            boolean priviledio = privilegioTabla(v_privilegios);

            if (!priviledio) {
                cantFalso++;
            }
        }
        btnModificar.setEnabled(cantFalso == 0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGMovilTelefono = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jtpUnico = new javax.swing.JTabbedPane();
        jspClientes = new javax.swing.JScrollPane();
        jpClientes = new javax.swing.JPanel();
        jpsTablaCliente = new javax.swing.JScrollPane();
        tblClientes = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        btnImprimirInforme1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnHistorial1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jspMantenimiento = new javax.swing.JScrollPane();
        jpMantenimiento = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        jPanel5 = new javax.swing.JPanel();
        jcbProvincias = new RSMaterialComponent.RSComboBox();
        jcbMunicipios = new RSMaterialComponent.RSComboBox();
        jcbDistritoMunicipal = new RSMaterialComponent.RSComboBox();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAgregarDirecciones = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarDireccion = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarDirrecion = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtDireccion = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDireccion = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jpContactos = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtTelelfonoMovil = new javax.swing.JFormattedTextField();
        btnAgregarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        jrbMovil = new javax.swing.JRadioButton();
        jrbResidencial = new javax.swing.JRadioButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblTelefonos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        btnAgregarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCorreos = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        btnCedulaValidad = new RSMaterialComponent.RSButtonMaterialIconOne();
        jlFechaCreacion = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Administración Clientes");
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

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));

        jpsTablaCliente.setName("jpsTablaCliente"); // NOI18N

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblClientes.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblClientes.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblClientes.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblClientes.setName("tblClientes"); // NOI18N
        tblClientes.setShowGrid(true);
        jpsTablaCliente.setViewportView(tblClientes);

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 1, true));
        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnImprimirInforme1.setText("Imprimir informe de cliente");
        btnImprimirInforme1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirInforme1.setName("btnImprimirInforme"); // NOI18N
        btnImprimirInforme1.setRound(40);
        jPanel16.add(btnImprimirInforme1);

        btnHistorial1.setText("Historial de Cliente");
        btnHistorial1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnHistorial1.setName("btnHistorial"); // NOI18N
        btnHistorial1.setRound(40);
        btnHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorial1ActionPerformed(evt);
            }
        });
        jPanel16.add(btnHistorial1);

        jScrollPane2.setViewportView(jPanel16);

        javax.swing.GroupLayout jpClientesLayout = new javax.swing.GroupLayout(jpClientes);
        jpClientes.setLayout(jpClientesLayout);
        jpClientesLayout.setHorizontalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpsTablaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpsTablaCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspClientes.setViewportView(jpClientes);

        jtpUnico.addTab("Clientes", jspClientes);

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
        txtCedula.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtCedula.setName("txtCedula"); // NOI18N
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

        jcbPersona.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbPersona.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Tipo persona", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbPersona.setName("jcbPersona"); // NOI18N
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

        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtPNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Primer nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtPNombre.setDoubleBuffered(true);
        txtPNombre.setFocusTraversalPolicyProvider(true);
        txtPNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtPNombre.setName("txtPNombre"); // NOI18N
        txtPNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });

        txtSNombre.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtSNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Segundo nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtSNombre.setDoubleBuffered(true);
        txtSNombre.setFocusTraversalPolicyProvider(true);
        txtSNombre.setMinimumSize(new java.awt.Dimension(0, 0));
        txtSNombre.setName("txtSNombre"); // NOI18N
        txtSNombre.setPreferredSize(new java.awt.Dimension(0, 25));
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });

        txtApellidos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtApellidos.setDoubleBuffered(true);
        txtApellidos.setFocusTraversalPolicyProvider(true);
        txtApellidos.setMinimumSize(new java.awt.Dimension(0, 0));
        txtApellidos.setName("txtApellidos"); // NOI18N
        txtApellidos.setPreferredSize(new java.awt.Dimension(0, 25));
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });

        dchFechaNacimiento.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        dchFechaNacimiento.setName("jdcFechaNacimiento"); // NOI18N

        jcbEstadoCivil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbEstadoCivil.setName("jcbEstadoCivil"); // NOI18N
        jcbEstadoCivil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbEstadoCivilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jcbSexo.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbSexo.setName("jcbSexo"); // NOI18N

        jtpDireccionContactos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel5.setLayout(new java.awt.GridLayout(1, 3, 6, 0));

        jcbProvincias.setForeground(new java.awt.Color(37, 45, 223));
        jcbProvincias.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbProvincias.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbProvincias.setName("jcbProvincia"); // NOI18N
        jcbProvincias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbProvinciasActionPerformed(evt);
            }
        });
        jPanel5.add(jcbProvincias);

        jcbMunicipios.setForeground(new java.awt.Color(37, 45, 223));
        jcbMunicipios.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbMunicipios.setEnabled(false);
        jcbMunicipios.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbMunicipios.setName("jcbMunicipios"); // NOI18N
        jcbMunicipios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbMunicipiosActionPerformed(evt);
            }
        });
        jPanel5.add(jcbMunicipios);

        jcbDistritoMunicipal.setForeground(new java.awt.Color(37, 45, 223));
        jcbDistritoMunicipal.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbDistritoMunicipal.setEnabled(false);
        jcbDistritoMunicipal.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbDistritoMunicipal.setName("jcbDistritoMunicipal"); // NOI18N
        jcbDistritoMunicipal.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbDistritoMunicipalPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel5.add(jcbDistritoMunicipal);

        jPanel7.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.setName("btnAgregarDirecciones"); // NOI18N
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregarDirecciones);

        btnEditarDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarDireccion.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDireccionActionPerformed(evt);
            }
        });
        jPanel7.add(btnEditarDireccion);

        btnEliminarDirrecion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarDirrecion.setName("btnEliminarDirrecion"); // NOI18N
        btnEliminarDirrecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDirrecionActionPerformed(evt);
            }
        });
        jPanel7.add(btnEliminarDirrecion);

        txtDireccion.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtDireccion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Dirección", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        txtDireccion.setDoubleBuffered(true);
        txtDireccion.setFocusTraversalPolicyProvider(true);
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 0));
        txtDireccion.setName("txtDireccion"); // NOI18N
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 25));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblDireccion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDireccion.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jScrollPane3.setViewportView(tblDireccion);

        javax.swing.GroupLayout jpDireccionLayout = new javax.swing.GroupLayout(jpDireccion);
        jpDireccion.setLayout(jpDireccionLayout);
        jpDireccionLayout.setHorizontalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addGroup(jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDireccionLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE))
                    .addGroup(jpDireccionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))))
                .addContainerGap())
        );
        jpDireccionLayout.setVerticalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpDireccionContactos.addTab("Dirección", jpDireccion);

        jTabbedPane3.setName("telefonoCorreos"); // NOI18N

        txtTelelfonoMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Número"));
        try {
            txtTelelfonoMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelelfonoMovil.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
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

        btnGMovilTelefono.add(jrbMovil);
        jrbMovil.setSelected(true);
        jrbMovil.setText("Movil");
        jrbMovil.setName("jrbMovil"); // NOI18N

        btnGMovilTelefono.add(jrbResidencial);
        jrbResidencial.setText("Telefono");
        jrbResidencial.setName("jrbTelefonoResidencial"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTelelfonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jrbResidencial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jrbMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarTelefonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(310, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelelfonoMovil)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jrbMovil)
                        .addGap(0, 0, 0)
                        .addComponent(jrbResidencial)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBorrarTelefonoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );

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
        tblTelefonos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jScrollPane5.setViewportView(tblTelefonos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane3.addTab("Teléfonico", jPanel10);

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

        txtCorreo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true), "Ingrese correo"));
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

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

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
        tblCorreos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jScrollPane4.setViewportView(tblCorreos);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jTabbedPane3.addTab("Correos", jPanel11);

        javax.swing.GroupLayout jpContactosLayout = new javax.swing.GroupLayout(jpContactos);
        jpContactos.setLayout(jpContactosLayout);
        jpContactosLayout.setHorizontalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane3)
                .addGap(0, 0, 0))
        );
        jpContactosLayout.setVerticalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane3)
                .addGap(0, 0, 0))
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

        jlFechaCreacion.setText("Fecha de creacion: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtpDireccionContactos, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCedulaValidad, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jlFechaCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, false)
                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCedulaValidad, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jcbSexo)
                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFechaCreacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtpDireccionContactos)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
            .addGroup(jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                    .addContainerGap(7, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMantenimientoLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
        btnNuevo.setRound(40);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel14.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setRound(40);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.setRound(40);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel14.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setRound(40);
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
        btnGuardar.setRound(40);
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
        btnCancelar.setRound(40);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpUnico)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpUnico, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        v_nuevo = true;//Se va a ingresar un nuevo registro al sistema
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Se valida que exista un campo seleccionado
        if (validarRegistro()) {
            return;
        }

        //Se hace false para indicar que es una modificacion de registro.
        v_nuevo = false;

        //Se agrega el panel de manteniento y se muestra.
        cambioBoton(true);

        //Se obtiene el id del cliente para ser modificado.
        Integer idCliente
                = ((Personas) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona();

        //Al mostrarse el modulo de mantenimiento se deberia mostrar la 
        //informacion del cliente.
        mostrarRegistro(idCliente);

        //Se modifica el ancho de cada columna en todas las tablas siguiente.
        repararColumnaTable(tblCorreos);
        repararColumnaTable(tblDireccion);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnModificarActionPerformed

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
        v_hilo = new Thread(this);
        v_hilo.start();

        txtCedula.setValue("");

        int resp = JOptionPane.showInternalConfirmDialog(
                null,
                txtCedula,
                "Buscar cliente por cedula: ",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);

        v_hilo.interrupt();

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            txtCedula.commitEdit();
        } catch (ParseException ex) {
            v_LOG.log(Level.SEVERE, "Error a parsear la cedula.", ex);
            return;
        }

        if (existeCliente(txtCedula.getValue().toString()) == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "El Cliente No Existe!",
                    "Proceso de busqueda terminado",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int i = 0; i < tblClientes.getRowCount(); i++) {

            if (tblClientes.getValueAt(i, 0).toString().contains(
                    txtCedula.getText())) {
                tblClientes.setRowSelectionInterval(i, i);
                break;
            }

            if (txtCedula.getText().isBlank()) {
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
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
        if (validaCampoCedula()) {
            return;
        }

        if (txtPNombre.getText().isBlank()) {//2
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar un nombre...",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtPNombre.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().isBlank()) {//2
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar un apellido...",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtApellidos.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate() == null) {//4
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe indicar una fecha de nacimiento.",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {//5
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Fecha de nacimiento incorrecta!",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (tblDireccion.getRowCount() < 1) {//3
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar una direccion del cliente.",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtDireccion.requestFocus();
            return;
        }

        //Recogiendo la cantidad de telefono y correo registrado del cliente.
        
        if (tblCorreos.getRowCount() < 1 || tblTelefonos.getRowCount() < 1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "No existe forma de contactar al cliente, "
                    + "\nAgregue un numero de telefono o correo electronico.",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        /*
        Fin del proceso de validacion basica.
         */
        Integer idCliente = existeCliente(txtCedula.getValue().toString());

        // si es nuevo validamos que el Cliente no exista
        if (v_nuevo) {
            if (idCliente != -1) {
                //Preguntar si desea carga la data desde la base de datos.
                int resp = JOptionPane.showInternalConfirmDialog(
                        null,
                        "Cliente se encuentra en la base de datos. \nDesea cargar el registro?",
                        "Recuperación de datos",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
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

 /*
        Se obtiene el identificador del cliente si este se va a actualizar
        de lo contrario se obtiene un valor 0 si se va a invertar. Ademas se
        obtienen el tipo de persona si es fisica o juridica, el sexo, 
        sus nombres, los apellidos, fecha de nacimiento, su estado por defecto 
        es true.
         */
        Clientes miCliente = Clientes.builder().
                id_persona(idCliente).
                generales(
                        Generales.
                                builder().
                                cedula(txtCedula.getValue().toString()).
                                estado_civil(((EstadoCivil) jcbEstadoCivil.getSelectedItem())
                                        .getAbreviatura()).
                                build()
                ).
                direccion(v_direccionesList).
                contactosTel(v_contactosTelsList).
                contactosEmail(v_contactosCorreosList).
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

        if (v_nuevo) {
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

        if (v_nuevo) {
            msg = agregarCliente(miCliente).getMensaje();

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

        v_contactosCorreosList.clear();
        v_contactosTelsList.clear();
        v_direccionesList.clear();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorial1ActionPerformed
        if (v_miDetalle == null) {
            v_miDetalle = new frmDetalleFacturaClientes();
            dpnEscritorio.add(v_miDetalle);
        }

        try {
            v_miDetalle.setMaximum(false);
            v_miDetalle.setMaximum(true);
        } catch (PropertyVetoException ex) {
            v_LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        v_miDetalle.setVisible(true);
    }//GEN-LAST:event_btnHistorial1ActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        jcbPersona.requestFocus();
    }//GEN-LAST:event_txtCedulaActionPerformed

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

    private void jcbPersonaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        txtPNombre.requestFocus();
    }//GEN-LAST:event_jcbPersonaPopupMenuWillBecomeInvisible

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
        btnGuardar.requestFocus();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (txtPNombre.getText().isBlank() && !txtSNombre.getText().isEmpty()) {
            txtPNombre.setText(txtSNombre.getText());
            txtSNombre.setText("");
        }
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        dchFechaNacimiento.requestFocus();
        v_editor.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jcbEstadoCivilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible
        jcbSexo.requestFocus();
        jcbSexo.showPopup();
    }//GEN-LAST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible

    private void jcbProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProvinciasActionPerformed
        jcbMunicipios.removeAllItems();

        getMunicipio(jcbProvincias.getSelectedIndex() <= 0 ? 0
                : ((Provincias) jcbProvincias.getSelectedItem()).getId()
        ).stream().forEach(municipio -> {
            jcbMunicipios.addItem(municipio);
        });

        if (jcbProvincias.getSelectedIndex() > 0) {
            jcbMunicipios.setEnabled(true);
            jcbMunicipios.requestFocus();
        } else {
            jcbMunicipios.setEnabled(false);
        }
    }//GEN-LAST:event_jcbProvinciasActionPerformed

    private void jcbMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMunicipiosActionPerformed

        jcbDistritoMunicipal.removeAllItems();

        getDistritosMunicipales(
                jcbMunicipios.getSelectedIndex() <= 0 ? 0
                : ((Municipios) jcbMunicipios.getSelectedItem()).getId()
        ).stream().forEach(distrito -> {
            jcbDistritoMunicipal.addItem(distrito);
        });

        if (jcbMunicipios.getSelectedIndex() > 0) {
            jcbDistritoMunicipal.setEnabled(true);
            jcbDistritoMunicipal.requestFocus();
        } else {
            jcbDistritoMunicipal.setEnabled(false);
        }
    }//GEN-LAST:event_jcbMunicipiosActionPerformed

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible
        txtDireccion.requestFocus();
    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible

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
        int idCliente = (v_nuevo ? -1 : ((Clientes) tblClientes.getValueAt(
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

        //Se guardan las direcciones en esta lista para ser enviada.
        v_direccionesList.add(direccion);

        /*
            Se crea un array de objecto para agregarlo a la tabla como un
            registro.
         */
        Object registroDireccion[] = new Object[v_TITULOS_DIRECCION.length];

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
        v_dtmDireccion = (DefaultTableModel) tblDireccion.getModel();

        /*
            Se agrega el nuevo registro al modelo.
         */
        v_dtmDireccion.addRow(registroDireccion);

        /*
            Modelo colocado en la tabla.
         */
        tblDireccion.setModel(v_dtmDireccion);

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

    private void btnEliminarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecionActionPerformed

        v_direccionesList.remove(tblDireccion.getSelectedRow());

        eliminarRegistro(tblDireccion, v_dtmDireccion);

        repararColumnaTable(tblDireccion);
    }//GEN-LAST:event_btnEliminarDirrecionActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        btnAgregarDirecciones.doClick();
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtTelelfonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilActionPerformed
        btnAgregarTelefonoMovil.doClick();
    }//GEN-LAST:event_txtTelelfonoMovilActionPerformed

    private void txtTelelfonoMovilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelelfonoMovilKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtTelelfonoMovil.setText(ValidarCorreoTel.generarTelMovil());
                        int numero = (int) (Math.random() * 10);
                        jrbMovil.setSelected((numero % 2) == 0);
                        jrbResidencial.setSelected((numero % 2) != 0);
                    }
                }
            }
        }
    }//GEN-LAST:event_txtTelelfonoMovilKeyPressed

    private void btnAgregarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTelefonoMovilActionPerformed

        try {
            //Validacion para agregar un telefono a la lista.
            //Que el campo de telefono o movil no sea nulo para poder registrarlo.
            txtTelelfonoMovil.commitEdit();
        } catch (ParseException ex) {
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
        v_contactosTelsList.add(ContactosTel.builder().
                telefono(telefono).
                tipo(tipo).build());

        v_dtmTelefono.addRow(registroTel);
        tblTelefonos.setModel(v_dtmTelefono);

        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocus();

        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void btnBorrarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoMovilActionPerformed
        if (v_nuevo) {

        } else {

        }
        eliminarRegistro(tblTelefonos, v_dtmTelefono);
        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnBorrarTelefonoMovilActionPerformed

    private void btnAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        /*
        Validamos que el correo no esté vacio.
         */
        if (txtCorreo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar correo electronico.",
                    v_VALIDACCION_DE_CONTACTO,
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
                    v_VALIDACCION_DE_CONTACTO,
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtCorreo.requestFocusInWindow();
            return;
        }

        if (v_nuevo) {
            //Llenamos el List de correo.
            v_contactosCorreosList.add(
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
        v_dtmCorreo.addRow(registroCorreo);

        //Y al modelo lo pasamos a la tabla para ser mostrado.
        tblCorreos.setModel(v_dtmCorreo);

        //Limpiamos campos y solicitamos el focus.
        txtCorreo.setText("");
        txtCorreo.requestFocus();

        //Reparamos la columnas de la tabla.
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void btnEliminarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreoActionPerformed
        if (v_nuevo) {

        } else {

        }
        eliminarRegistro(tblCorreos, v_dtmCorreo);
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnEliminarCorreoActionPerformed

    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        /*
            Si se va a insertar un nuevo registro la cedula no debe existir.
            Si existe mostrar mensaje de que el cliente esta registrado.
         */
        if (validaCampoCedula()) {
            return;
        }

        String cedula = (String) txtCedula.getValue();

        Integer idCliente = existeCliente(cedula);

        if (v_nuevo) {//Condicion para cuando el proceso es un nuevo registro.
            if (idCliente != -1) {
                int resp = JOptionPane.showInternalConfirmDialog(
                        null,
                        "Esta cedula está registrada. \nProcede a habilitar la información?",
                        v_PROCESO_DE_VALIDACION,
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);

                //Preguntamos si desea cargar la informacion del cliente.
                if (resp == JOptionPane.YES_OPTION) {

                    /**
                     * Al insertar un cliente ya registrado el siguiente metodo
                     * devuelve falso, es por ello se valida la negacion de
                     * false, para obtener true.
                     */
                    if (!Clientes.agregarClienteById(idCliente)) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cliente agregado correctamente",
                                v_PROCESO_DE_VALIDACION,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        for (int i = 0; i < tblClientes.getRowCount(); i++) {

                            if (((Clientes) tblClientes.getValueAt(i, 0)).getId_persona() == idCliente) {
                                tblClientes.setRowSelectionInterval(i, i);
                                break;
                            }

                            if (txtCedula.getText().isBlank()) {
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Cliente no pudo ser agreado al sistema.",
                                v_PROCESO_DE_VALIDACION,
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }

                    btnCancelarActionPerformed(evt);
                }
            } else {
                JOptionPane.showInternalMessageDialog(null,
                        "Cedula valida, puede continuar.",
                        v_PROCESO_DE_VALIDACION,
                        JOptionPane.INFORMATION_MESSAGE);
                jcbPersona.requestFocus();
            }
        } else {//Condicion para cuando se va a modificar un registro.
            /*
            Si se va a actualizar un registro, la cedula debe de existir en la
            Base de datos.
             */
            if (idCliente == -1) {
                int resp = JOptionPane.showInternalConfirmDialog(
                        null,
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

        jcbProvincias.removeAllItems();
        Provincias.getProvincias().stream().forEach(provincia
                -> jcbProvincias.addItem(provincia)
        );

        jcbPersona.removeAllItems();
        TipoPersona.getTipoPersonaList().stream().forEach(tipoPersona
                -> jcbPersona.addItem(tipoPersona)
        );

        jcbSexo.removeAllItems();
        Sexo.getSexoList().stream().forEach(sexo
                -> jcbSexo.addItem(sexo)
        );

        jcbEstadoCivil.removeAllItems();
        EstadoCivil.getEstadoCivilList().stream().forEach(estadoCivil
                -> jcbEstadoCivil.addItem(estadoCivil)
        );

    }//GEN-LAST:event_formInternalFrameOpened

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        btnAgregarCorreo.doClick();
    }//GEN-LAST:event_txtCorreoActionPerformed

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

    private void btnEditarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarDireccionActionPerformed
    
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
     * Este metodo valida que: <br>
     * 1) Que en la tabla de los clientes del sistema deben de existir mas
     * de<br>
     * de un registros.<br>
     * 2) Que en la tabla haya un elemento seleccionado. <br>
     * 3) Que cliente seleccionado no sea el GENERICO.<br>
     *
     * <hr>
     *
     * @return Devuelve un valor verdadero para indicar que existe una <br>
     * restriccion de las mensionadas, de lo contrario devuelve falso <br>
     * indicando que no existe restriciones.
     */
    private boolean validarRegistro() {
        //Si la tabla de registro de los cliente está vacia devolvemos true
        //para que el proceso no continue.
        if (tblClientes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe contar con clientes en registros, Ingrese nuevos clientes.",
                    "Proceso de validación.",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblClientes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe de seleccionar un cliente",
                    "Proceso de validación.",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        //Verificamos que el registro no sea de un cliente generico, de serlo lo 
        // devolvemos true para que el proceso no continue. 
        if (((Personas) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0)).getId_persona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Cliente GENERICO no puede ser modificado",
                    "Proceso de validación.",
                    JOptionPane.INFORMATION_MESSAGE
            );
            return true;
        }

        //Si todo esta bien enviamos un false para que el proceso se permita..
        return false;
    }

    /**
     * Es el metodo encargado de llenar el formulario del cliente cuando este se
     * va a modificar en la base de datos, el cual llama al metodo
     * getClienteByID(idCliente) que retorna un objecto de la clase cliente.
     *
     * El mismo idCliente es utilizado para obtener la lista de direcciones,
     * lista de correo y lista de telefonos del cliente.
     *
     * @param idCliente El identificador del cliente en la base de datos.
     */
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
        jlFechaCreacion.setText("Fecha de Ingreso: " + cliente.getFecha_ingreso());

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
        v_dtmDireccion = new DefaultTableModel(null, v_TITULOS_DIRECCION);

        //Se limpia la lista de direcciones para agregar la del cliente.
        v_direccionesList.clear();

        getDireccionByID(idCliente).stream().forEach(direccione -> {
            Object registroDireccion[] = new Object[v_TITULOS_DIRECCION.length];

            registroDireccion[0] = direccione.getProvincia();
            registroDireccion[1] = direccione.getMunicipio();
            registroDireccion[2] = direccione.getDistrito_municipal();
            registroDireccion[3] = Direcciones.
                    builder().
                    id(direccione.getId()).
                    direccion(direccione.getDireccion()).
                    build();
            registroDireccion[4] = direccione.getFecha();

            v_direccionesList.add(direccione);

            v_dtmDireccion.addRow(registroDireccion);
        });

        tblDireccion.setModel(v_dtmDireccion);
        //------------------------FIN con la lista de direcciones.

        Object registroTel[] = new Object[TITULOS_TELEFONO.length];

        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);

        //Se limpia la lista telefonica del cliente.
        v_contactosTelsList.clear();

        getTelefonoByID(idCliente).stream().forEach(telefono -> {

            registroTel[0] = telefono;
            registroTel[1] = telefono.getTipo();
            registroTel[2] = telefono.getFecha();

            v_contactosTelsList.add(telefono);

            v_dtmTelefono.addRow(registroTel);
        });
        tblTelefonos.setModel(v_dtmTelefono);

        //-------------------------FIN con la lista de telefono
        Object registroCorreo[] = new Object[TITULOS_CORREO.length];

        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);

        //Se limpia la lista de correo del cliente.
        v_contactosCorreosList.clear();

        getCorreoByID(idCliente).stream().forEach(correo -> {
            registroCorreo[0] = correo;
            registroCorreo[1] = correo.getFecha();

            v_contactosCorreosList.add(correo);

            v_dtmCorreo.addRow(registroCorreo);
        });

        //Obteniendo los correos.
        tblCorreos.setModel(v_dtmCorreo);
        //--------------------------FIN con la lista de correo.

        if (v_nuevo) {
            txtCedula.requestFocus();
        } else {
            txtPNombre.requestFocus();
        }
    }

    /**
     * Este metodo debe cambiar el comportamiento de la ventana al pulsar sobre
     * nuevo o editar.
     *
     * @param activo Este parametro es utilizado cuando se va a ingresar o
     * modificar registros a la base de datos.
     *
     * <b>Si su valor es verdadero:</b>
     * 1) Los botones de nuevo, editar, borrar y buscar deben inhabilitarse.<br>
     * 2) Los botones de guardar y cancelar pasan habilitarse.<br>
     * <br>
     * <b>Si su valor es falso:</b>
     * Lo contrario de cuando su valor es verdadero. <br>
     * 1) Los botones de nuevo, editar, borrar y buscar deben habilitarse. <br>
     * 2) Los botones de guardar y cancelar pasan inhabilitarse.<br>
     *
     * Al presionar nuevo o editar debe cambiarse en la vista Clientes a
     * Mantenimiento.
     * 
     * Este metodo se llama desde el boton nuevo y modificar con el valor
     * del parametros true y desde cancelar con el valor del parametro 
     * false.
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
        txtCorreo.setText("");
        txtTelelfonoMovil.setText("");

        //Se setea la fecha actual en el campo.
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

        if (v_nuevo) {
            //Nuevo registro
            txtCedula.setText("");
            txtCedula.requestFocus();
        } else {
            //Modificar registro
            /**
             * Debo de reducir las siguientes lineas de codigo usando vistaList.
             * Como lo hice en el constructor.
             */
            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("CEDULA").build();
            txtCedula.setEditable(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PNOMBRE").build();
            txtPNombre.setEditable(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("SNOMBRE").build();
            txtSNombre.setEditable(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("APELLIDOS").build();
            txtApellidos.setEditable(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("FECHA_NACIMIENTO").build();
            dchFechaNacimiento.setEnabled(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("PERSONA").build();
            jcbPersona.setEnabled(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_GENERALES").
                    nombre_campo("ESTADO_CIVIL").build();
            jcbEstadoCivil.setEnabled(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("SEXO").build();
            jcbSexo.setEnabled(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            v_privilegios = Privilegios.builder().
                    privilegio(Privilegios.PRIVILEGIO_UPDATE).
                    nombre_relacion("V_PERSONAS").
                    nombre_campo("ESTADO").build();
            cbEstado.setEnabled(privilegioCampo(v_privilegios) || 
                    privilegioTabla(v_privilegios));

            txtPNombre.requestFocus();
        }
        nuevasTablasDirTelCor();
    }

    /**
     * Este metodo permite resetear todas las tablas del modulo a cero
     * registros.
     * 
     * Se llama desde el constructor, y desde el metodo cambioBoton.
     */
    private void nuevasTablasDirTelCor() {
        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(v_dtmTelefono);

        v_dtmDireccion = new DefaultTableModel(null, v_TITULOS_DIRECCION);
        tblDireccion.setModel(v_dtmDireccion);

        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(v_dtmCorreo);
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
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarDireccion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarDirrecion;
    private javax.swing.ButtonGroup btnGMovilTelefono;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorial1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JCheckBox cbEstado;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private static RSMaterialComponent.RSComboBox jcbDistritoMunicipal;
    private javax.swing.JComboBox jcbEstadoCivil;
    private static RSMaterialComponent.RSComboBox jcbMunicipios;
    private static javax.swing.JComboBox jcbPersona;
    private static RSMaterialComponent.RSComboBox jcbProvincias;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JScrollPane jpsTablaCliente;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JScrollPane jspMantenimiento;
    private javax.swing.JTabbedPane jtpDireccionContactos;
    public static javax.swing.JTabbedPane jtpUnico;
    private static rojerusan.RSTableMetro1 tblClientes;
    private rojerusan.RSTableMetro1 tblCorreos;
    private rojerusan.RSTableMetro1 tblDireccion;
    private rojerusan.RSTableMetro1 tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
 @Override
    public void run() {
        while (!txtCedula.hasFocus()) {
            if (txtCedula.isShowing()) {
                txtCedula.requestFocus();
            }
        }
    }

    private boolean validaCampoCedula() {
        try {
            txtCedula.commitEdit();
        } catch (ParseException ex) {

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe digitar la cedula del cliente",
                    v_PROCESO_DE_VALIDACION,
                    JOptionPane.INFORMATION_MESSAGE
            );

            txtCedula.requestFocus();
            txtCedula.selectAll();

            v_LOG.log(Level.INFO, "El formato de la cedula no es el correcto.");

            return true;
        }
        return false;
    }
}

/**
 * El <b>btnNuevo</b> de cumplir lo siguiente:<br>
 *  1) Debe cambiar el valor de v_nuevo a true; X<br>
 *  2) Debe cambiar el TabPane de Cliente a Mantenimiento y presentar el <br>
 *      formulario limpio. X<br>
 *  3) Debe deshabilitar los botones de nuevo, modificar borrar y buscar. X<br>
 *  4) Debe habilitar los botones de guardar y cancelar. X<br>
 *  5) Debe siempre limpiar las tablas de formulario de registro. X<br>
 *  6) Debe siempre limpiar los comboBox de provincia, municipio y distritos <br>
 *      municipal. X<br>
 *  7) Debe siempre limpiar los comboBox de Estado civil, sexo y Tipo persona. X<br>
 *  8) <br>
 *
 *
 * El <b>btnModificar</b> debe cumplir lo siguiente:<br>
 *  1) Debe ejecutarse el metodo validarRegistro(), si este devuelve TRUE<br>
 *      Debe devolverse el flojo de control. X<br>
 *  2) Debe cambiar el valor de v_nuevo a false; X<br>
 *  3) Debe validar que un registros este seleccionado. X<br>
 *  4) Debe cambiar el TabPane de Clientes a Mantenimiento. <br>
 *  5) Presentar el formulario de registros con los datos de registros <br>
 *      seleccionado a modificar. X<br>
 *  6) Debe habilitar los botones de guardar y cancelar. X<br>
 *  7) Debe de ajustarse el ancho de las columnas de las tablas como Correo,<br>
 *      Direcciones y Telefono.
 *
 *
 * El <b>btnBorrar</b> debe cumplir lo siguiente:<br>
 *  1) Debe utilizar el metodo validarRegistro(). <br>
 *  2) Debe mostrar un cuadro de dialogo que diga <br>
 *      ¿Esta Seguro de Eliminar Registro del Cliente?<br>
 *      y mostrar la opciones de Si o No.<br>
 *  3) Si selecciona que NO debe devolver el flujo de control. <br>
 *  4) En caso contrario se procede a obtener el idCliente<br>
 *      del registro de la tabla tblClientes.<br>
 *  5) Se manda a llamar el metodo borrarCliente(idCliente) y se <br>
 *      obtiene un objecto de la clase Resultados la cual con el <br>
 *      metodo getMensaje() obtenemos como resultado de la operacion <br>
 *      un mensaje del metodo.
 *  6) Evaluamos el resultado del mensaje con la variable estatica de la <br>
 *      clase Cliente CLIENTE_BORRADO_CORRECTAMENTE.
 *  7) Mostramos el resultado de la operacion en un JOpcionPane
 *  8) Reperamos el ancho de las columnas de la tabla tblClientes.
 *
 *
 *
 * El <b>btnBuscar</b> debe cumplir lo siguiente:<br>
 *  1) Debe iniciarlizar la variable v_hilo, para cuando el<br>
 *      JOpcionPane se muestre gane el focus el componente.<br>
 *  2) El campo Cedula debe limpiarse.<br>
 *  3) Debe mostrarse la ventana pidiendo que digite la <br>
 *      cedula a buscar.<br>
 *  4) Se interrumpe el hilo de ejecucion del paso 1. X<br>
 *  5) Si la opcion es no, se cancela el proceso. X<br>
 *  6) Si la opcion es si, se valida que se halla digitado<br>
 *      una cedula completa.<br>
 *  7) En caso de que no es una cedula completa se muestra<br>
 *      un mensaje de error.<br>
 *  8) Si la cedula es correcta se manda a consultar la cedula<br>
 *      digitada.<br>
 *  9) En caso de no encontrarla mostrar el mensaje que diga: <br>
 *      "El Cliente No Existe!"
 *  10) Si 
 * 
 *
 * El <b>btnGuardar</b> debe cumplir lo siguiente:<br>
 *  1) Validamos que el campo de la cedula sea correcto.
 *  2) Mostramos mensaje de error si el campo primer nombre está en blanco.
 *  3) Mostramos mensaje de error si el campo segundo nombre está en blanco.
 *  4) Mostramos mensaje de error si el campo de apellidos está en blanco.
 *  5) Mostramos mensaje de error si el campo de fecha es nulo.
 *  6) Mostramos mensaje de error si la fecha del campo fecha nacimiento está
 *      por encima de la fecha actual. 
 *  7) Nos aseguramos que la tabla de direcciones contenga por lo menos 
 *      un registro.
 *  8) Nos aseguramos que exista una forma de contacto con el cliente.
 *  
 *
 *
 * 
 * El <b>btnCancelar</b> debe cumplir lo siguiente: <br>
 *  1) Debe de eliminar el formulario de mantenimiento. X <br>
 *  2) Debe solo prensentar el formulario de registros de los clientes. X <br>
 *
 *
 *
 * 
 * El <b>btnAgregarCorreo</b> debe cumplir lo siguiente:<br>
 *  1) Debe validar que sea un correo valido. X<br>
 *  2) <br>
 * 
 * 
 *
 * El <b>btnAgregarDirecciones</b> debe cumplir lo siguiente: <br>
 *  1) Valida que se haya seleccionado una pronvincia. X<br>
 *  2) Valida que se haya seleccionado un municipio. X<br>
 *  3) Se valida que se haya digitado una dirección. X<br>
 *  4) Se obtiene el identificador del usuario si se va <br>
 *      a modificar el registro. En caso contrario se obtiene -1.<br>
 *  5) Se obtienen las claves primarias de provincia, municipio y <br>
 *      distritos municipales de los comboBox de estos.
 *  6) Se prepara el objecto direccion para ser agregado a la variable<br>
 *      de campo global v_direccionesList.
 *  7) Se prepara un arreglo de objecto llamado registroDirecciones el <br>
 *      cual servira para agregar la direccion completa a la BD.<br>
 *  8) Se obtiene el modelo de la tabla de direcciones de la variable <br>
 *      tblDireccion con el metodo getModel().<br>
 *  9) Se agregar el registro de la variable registroDireccion a la variable<br>
 *      de campo v_dtmDireccion.<br>
 *  10) Y se setea el modelo a la tabla de direcciones tblDireccion.<br>
 *  11) Se colocan los jComboBox en el indice 0 de Provincia, Municipio y <br>
 *      Distrito Municipal.
 *  12) Los jComboBox de Municipio y Distritos Municipal se deshabilitan.
 *  13) El campo direccion se blanquea.
 *  14) Se Reparan el ancho de las columnas.
 * 
 *
 * El <b>btn</b>
 *
 * 
 * 
 * Comportamiento a reparar siguiente desarrollo:
 *
 *  1) La tabla de registros de los clientes debe ser paginada y solo puede
 *      cargar de 15 a 20 registros a la vez.
 * 
 * 
 * 
 *
 * Notas:
 *
 */
