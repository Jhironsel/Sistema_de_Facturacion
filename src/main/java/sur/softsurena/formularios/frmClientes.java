package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.abstracta.Persona;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.ContactoEmail;
import sur.softsurena.entidades.ContactoTel;
import sur.softsurena.entidades.Direccion;
import sur.softsurena.entidades.Distrito_municipal;
import sur.softsurena.entidades.EstadoCivil;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipio;
import sur.softsurena.entidades.Privilegio;
import sur.softsurena.entidades.Provincia;
import sur.softsurena.entidades.Sexo;
import sur.softsurena.entidades.TipoPersona;
import sur.softsurena.interfaces.ICliente;
import static sur.softsurena.metodos.M_Cliente.agregarCliente;
import static sur.softsurena.metodos.M_Cliente.agregarClienteById;
import static sur.softsurena.metodos.M_Cliente.borrarCliente;
import static sur.softsurena.metodos.M_Cliente.getClientes;
import static sur.softsurena.metodos.M_Cliente.modificarCliente;
import static sur.softsurena.metodos.M_ContactoEmail.correo;
import static sur.softsurena.metodos.M_ContactoEmail.generarCorreo;
import static sur.softsurena.metodos.M_ContactoEmail.getCorreoByID;
import static sur.softsurena.metodos.M_ContactoTel.generarTelMovil;
import static sur.softsurena.metodos.M_ContactoTel.getTelefonoByID;
import static sur.softsurena.metodos.M_ContactoTel.telefono;
import static sur.softsurena.metodos.M_Direccion.agregarModificarDirecciones;
import static sur.softsurena.metodos.M_Direccion.getDireccionByID;
import static sur.softsurena.metodos.M_Distrito_Municipal.getDistritosMunicipales;
import static sur.softsurena.metodos.M_EstadoCivil.getEstadoCivilList;
import sur.softsurena.metodos.M_Generales;
import static sur.softsurena.metodos.M_Generales.generarCedula;
import static sur.softsurena.metodos.M_Municipio.getMunicipio;
import static sur.softsurena.metodos.M_Privilegio.privilegio;
import static sur.softsurena.metodos.M_Provincia.getProvincias;
import static sur.softsurena.metodos.M_Sexo.getSexoList;
import static sur.softsurena.metodos.M_TipoPersona.getTipoPersonaList;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultados;
import static sur.softsurena.utilidades.Utilidades.LOG;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.formatDate;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.utilidades.Utilidades.sqlDateToUtilDate;

public class frmClientes extends javax.swing.JInternalFrame implements ICliente {

    private Boolean v_nuevo = false;

    private JTextFieldDateEditor v_editor = null;

    private static DefaultTableModel v_dtmTelefono, v_dtmCorreo, v_dtmDireccion;

    private frmDetalleFacturaClientes v_miDetalle;

    private static List<Direccion> v_direccionesList;

    private static List<ContactoEmail> v_contactosCorreosList;

    private static List<ContactoTel> v_contactosTelsList;

    private static String criterioBusqueda = "";

    private static Integer idCliente;

    public static frmClientes getInstance() {
        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        if (!privilegio(Privilegio
                .builder()
                .privilegio(Privilegio.PRIVILEGIO_SELECT)
                .nombre_relacion("GET_CLIENTES_SB")
                .nombre_campo("^")
                .build()
        )) {

            final String mensaje = "No cuenta con permisos para ver la información de este módulo.";

            JOptionPane.showInternalMessageDialog(
                    null,
                    mensaje,
                    "",
                    JOptionPane.WARNING_MESSAGE
            );

            throw new ExceptionInInitializerError(mensaje);
        }
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmClientes INSTANCE = new frmClientes();
    }

    private frmClientes() {
        //Metodo encargado de inicializar los componentes del formulario.
        initComponents();
        //Inicializando las listas.
        v_direccionesList = new ArrayList<>();
        v_contactosCorreosList = new ArrayList<>();
        v_contactosTelsList = new ArrayList<>();

        v_editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        v_editor.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        new javax.swing.border.LineBorder(
                                new java.awt.Color(37, 45, 223), 2, true),
                        "Fecha nacimiento",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font("FreeSans", 0, 12)));

        v_editor.addActionListener((ActionEvent e) -> {
            jcbEstadoCivil.requestFocusInWindow();
            jcbEstadoCivil.showPopup();
        });

        //Mantenimiento oculto por defecto.
        jtpPrincipal.remove(jspMantenimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGMovilTelefono = new javax.swing.ButtonGroup();
        txtCedula1 = new javax.swing.JFormattedTextField();
        jspGeneral = new javax.swing.JScrollPane();
        jpGeneral = new javax.swing.JPanel();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jspClientes = new javax.swing.JScrollPane();
        jpClientes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblClientes = new rojerusan.RSTableMetro1(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel16 = new javax.swing.JPanel();
        btnImprimirInforme1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnHistorialClientes = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnActualizarRegistrosCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        jLabel1 = new javax.swing.JLabel();
        jsCantidadFilas = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jsPaginaNro = new javax.swing.JSpinner();
        jspMantenimiento = new javax.swing.JScrollPane();
        jpMantenimiento = new javax.swing.JPanel();
        jpMantenimiento2 = new javax.swing.JPanel();
        jtpDireccionContactos = new javax.swing.JTabbedPane();
        jpGenerales = new javax.swing.JPanel();
        jcbSexo = new javax.swing.JComboBox();
        txtSNombre = new javax.swing.JTextField();
        jcbPersona = new javax.swing.JComboBox();
        cbEstado = new javax.swing.JCheckBox();
        txtCedula = new javax.swing.JFormattedTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnCedulaValidad = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtApellidos = new javax.swing.JTextField();
        jcbEstadoCivil = new javax.swing.JComboBox();
        txtPNombre = new javax.swing.JTextField();
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
        jtpContactos = new javax.swing.JTabbedPane();
        jpTelefonos = new javax.swing.JPanel();
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
        jpCorreos = new javax.swing.JPanel();
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
        jlFechaCreacion = new javax.swing.JLabel();
        jpBotones = new javax.swing.JPanel();
        jpBotones2 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        txtCedula1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Cedula", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        try {
            txtCedula1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula1.setText("012-0089344-8");
        txtCedula1.setToolTipText("Ingrese su criterio de busqueda.\\n[Cedula, nombres o apellidos]");
        txtCedula1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula1.setFocusTraversalPolicyProvider(true);
        txtCedula1.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        txtCedula1.setName("txtCedula"); // NOI18N

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
        setToolTipText("Mantenimientos de los clientes del sistema.");
        setName("frmClientes"); // NOI18N
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
                formInternalFrameOpened(evt);
            }
        });

        jspGeneral.setName("jspGeneral"); // NOI18N

        jpGeneral.setName("jpGeneral"); // NOI18N

        jtpPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        jspClientes.setName("jspClientes"); // NOI18N

        jpClientes.setName("jpClientes"); // NOI18N

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

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
        jScrollPane6.setViewportView(tblClientes);

        jScrollPane2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(187, 187, 187), 1, true));
        jPanel16.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnImprimirInforme1.setText("Informe cliente");
        btnImprimirInforme1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirInforme1.setName("btnImprimirInforme"); // NOI18N
        btnImprimirInforme1.setRound(40);
        btnImprimirInforme1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirInforme1ActionPerformed(evt);
            }
        });
        jPanel16.add(btnImprimirInforme1);

        btnHistorialClientes.setText("Historial de Cliente");
        btnHistorialClientes.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnHistorialClientes.setName("btnHistorial"); // NOI18N
        btnHistorialClientes.setRound(40);
        btnHistorialClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialClientesActionPerformed(evt);
            }
        });
        jPanel16.add(btnHistorialClientes);

        btnActualizarRegistrosCliente.setText("Actualizar registros");
        btnActualizarRegistrosCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        btnActualizarRegistrosCliente.setName("btnHistorial"); // NOI18N
        btnActualizarRegistrosCliente.setRound(40);
        btnActualizarRegistrosCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegistrosClienteActionPerformed(evt);
            }
        });
        jPanel16.add(btnActualizarRegistrosCliente);

        jScrollPane2.setViewportView(jPanel16);

        jLabel1.setText("Cantidad Reg.");

        jsCantidadFilas.setModel(new javax.swing.SpinnerNumberModel(20, 10, null, 1));
        jsCantidadFilas.setMaximumSize(new java.awt.Dimension(50, 27));
        jsCantidadFilas.setMinimumSize(new java.awt.Dimension(20, 27));
        jsCantidadFilas.setPreferredSize(new java.awt.Dimension(30, 27));
        jsCantidadFilas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsCantidadFilasStateChanged(evt);
            }
        });

        jLabel2.setText("Pagina No.");

        jsPaginaNro.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jsPaginaNro.setMaximumSize(new java.awt.Dimension(50, 27));
        jsPaginaNro.setMinimumSize(new java.awt.Dimension(20, 27));
        jsPaginaNro.setPreferredSize(new java.awt.Dimension(30, 27));
        jsPaginaNro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsPaginaNroStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpClientesLayout = new javax.swing.GroupLayout(jpClientes);
        jpClientes.setLayout(jpClientesLayout);
        jpClientesLayout.setHorizontalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpClientesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpClientesLayout.createSequentialGroup()
                        .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClientesLayout.createSequentialGroup()
                .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspClientes.setViewportView(jpClientes);

        jtpPrincipal.addTab("Clientes", jspClientes);

        jspMantenimiento.setName("jspMantenimiento"); // NOI18N

        jpMantenimiento.setName("jpMantenimiento"); // NOI18N

        jpMantenimiento2.setName("jpMantenimiento2"); // NOI18N

        jtpDireccionContactos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true)));
        jtpDireccionContactos.setToolTipText("");
        jtpDireccionContactos.setName("jtpDireccionContactos"); // NOI18N
        jtpDireccionContactos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpDireccionContactosKeyPressed(evt);
            }
        });

        jpGenerales.setToolTipText("Acceso con Control + 1");
        jpGenerales.setName("jpGenerales"); // NOI18N

        jcbSexo.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbSexo.setName("jcbSexo"); // NOI18N

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

        dchFechaNacimiento.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        dchFechaNacimiento.setName("jdcFechaNacimiento"); // NOI18N

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

        javax.swing.GroupLayout jpGeneralesLayout = new javax.swing.GroupLayout(jpGenerales);
        jpGenerales.setLayout(jpGeneralesLayout);
        jpGeneralesLayout.setHorizontalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGeneralesLayout.createSequentialGroup()
                        .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEstadoCivil, 0, 174, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGeneralesLayout.createSequentialGroup()
                        .addComponent(txtPNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpGeneralesLayout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCedulaValidad, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpGeneralesLayout.setVerticalGroup(
            jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCedula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCedulaValidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jcbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dchFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jpGeneralesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcbEstadoCivil, jcbPersona, jcbSexo});

        jtpDireccionContactos.addTab("Generales", jpGenerales);

        jpDireccion.setToolTipText("Acceso con Control + 2");
        jpDireccion.setName("jpDireccion"); // NOI18N

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
        jcbProvincias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbProvinciasKeyPressed(evt);
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
        jcbMunicipios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbMunicipiosKeyPressed(evt);
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
        jcbDistritoMunicipal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcbDistritoMunicipalKeyPressed(evt);
            }
        });
        jPanel5.add(jcbDistritoMunicipal);

        jPanel7.setLayout(new java.awt.GridLayout(1, 5, 5, 0));

        btnAgregarDirecciones.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);
        btnAgregarDirecciones.setName("btnAgregarDirecciones"); // NOI18N
        btnAgregarDirecciones.setPositionIcon(null);
        btnAgregarDirecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionesActionPerformed(evt);
            }
        });
        jPanel7.add(btnAgregarDirecciones);

        btnEditarDireccion.setEnabled(false);
        btnEditarDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarDireccion.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDireccionActionPerformed(evt);
            }
        });
        jPanel7.add(btnEditarDireccion);

        btnEliminarDirrecion.setEnabled(false);
        btnEliminarDirrecion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarDirrecion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            },
            new String [] {
                "Provincia", "Municipio", "Distrito Municipal", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDireccion.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblDireccion.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblDireccion.setShowGrid(true);
        tblDireccion.setSurrendersFocusOnKeystroke(true);
        tblDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDireccionMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDireccion);

        javax.swing.GroupLayout jpDireccionLayout = new javax.swing.GroupLayout(jpDireccion);
        jpDireccion.setLayout(jpDireccionLayout);
        jpDireccionLayout.setHorizontalGroup(
            jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDireccionLayout.createSequentialGroup()
                .addGroup(jpDireccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDireccionLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
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

        jpContactos.setToolTipText("Acceso con Control + 3");
        jpContactos.setName("jpContactos"); // NOI18N

        jtpContactos.setName("telefonoCorreos"); // NOI18N

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
                .addContainerGap(300, Short.MAX_VALUE))
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
        tblTelefonos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTelefonos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jScrollPane5.setViewportView(tblTelefonos);

        javax.swing.GroupLayout jpTelefonosLayout = new javax.swing.GroupLayout(jpTelefonos);
        jpTelefonos.setLayout(jpTelefonosLayout);
        jpTelefonosLayout.setHorizontalGroup(
            jpTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpTelefonosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5)
                .addContainerGap())
        );
        jpTelefonosLayout.setVerticalGroup(
            jpTelefonosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTelefonosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpContactos.addTab("Teléfonico", jpTelefonos);

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
        txtCorreo.setName("txtCorreo"); // NOI18N
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
        tblCorreos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCorreos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jScrollPane4.setViewportView(tblCorreos);

        javax.swing.GroupLayout jpCorreosLayout = new javax.swing.GroupLayout(jpCorreos);
        jpCorreos.setLayout(jpCorreosLayout);
        jpCorreosLayout.setHorizontalGroup(
            jpCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpCorreosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpCorreosLayout.setVerticalGroup(
            jpCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpCorreosLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpContactos.addTab("Correos", jpCorreos);

        javax.swing.GroupLayout jpContactosLayout = new javax.swing.GroupLayout(jpContactos);
        jpContactos.setLayout(jpContactosLayout);
        jpContactosLayout.setHorizontalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos)
                .addGap(0, 0, 0))
        );
        jpContactosLayout.setVerticalGroup(
            jpContactosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpContactosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jtpContactos)
                .addGap(0, 0, 0))
        );

        jtpDireccionContactos.addTab("Contactos", jpContactos);

        jlFechaCreacion.setText("Fecha de creacion: ");
        jlFechaCreacion.setName("jlFechaCreacion"); // NOI18N

        javax.swing.GroupLayout jpMantenimiento2Layout = new javax.swing.GroupLayout(jpMantenimiento2);
        jpMantenimiento2.setLayout(jpMantenimiento2Layout);
        jpMantenimiento2Layout.setHorizontalGroup(
            jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimiento2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtpDireccionContactos)
                    .addComponent(jlFechaCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimiento2Layout.setVerticalGroup(
            jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimiento2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFechaCreacion)
                .addGap(0, 0, 0)
                .addComponent(jtpDireccionContactos)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpMantenimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpMantenimiento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jspMantenimiento.setViewportView(jpMantenimiento);

        jtpPrincipal.addTab("Mantenimiento", jspMantenimiento);

        jpBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Botones de Acción ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14))); // NOI18N
        jpBotones.setMaximumSize(new java.awt.Dimension(787, 81));
        jpBotones.setMinimumSize(new java.awt.Dimension(787, 81));
        jpBotones.setName("jpBotones"); // NOI18N
        jpBotones.setPreferredSize(new java.awt.Dimension(800, 80));

        jpBotones2.setName("jpBotones2"); // NOI18N
        jpBotones2.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.setRound(40);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jpBotones2.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setRound(40);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.setRound(40);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setRound(40);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBuscar);

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
        jpBotones2.add(btnGuardar);

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
        jpBotones2.add(btnCancelar);

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpGeneralLayout = new javax.swing.GroupLayout(jpGeneral);
        jpGeneral.setLayout(jpGeneralLayout);
        jpGeneralLayout.setHorizontalGroup(
            jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
                    .addComponent(jtpPrincipal))
                .addContainerGap())
        );
        jpGeneralLayout.setVerticalGroup(
            jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspGeneral.setViewportView(jpGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jspGeneral)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jspGeneral)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        v_nuevo = true;//Se va a ingresar un nuevo registro al sistema
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Se valida que exista un campo seleccionado
        if (validarRegistro("modificar.")) {
            return;
        }

        //Se hace false para indicar que es una modificacion de registro.
        v_nuevo = false;

        //Se agrega el panel de manteniento y se muestra.
        cambioBoton(true);
        
        idCliente = ((Persona) tblClientes.getValueAt(
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
        //Validamos que está correcto en la tabla.
        //Si el metodo devuelve true devolvemos el proceso.
        if (validarRegistro("eliminar.")) {
            return;
        }

        //Mostramos un mensaje de advertencia si el usuario desea continuar con
        //la eliminación del registro.
        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de Eliminar Registro del Cliente?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        //Si el usuario responde a que no a las opciones entonces devolvemos el
        //proceso.
        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        //Mandamos a borrar el cliente y obtenemos el resultado de la operacion
        //y almacenamos en una variable.
        Resultados resultados = borrarCliente(
                ((Cliente) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );

        repararColumnaTable(tblClientes);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtCedula1.setValue(null);
        //Utilidades.showTooltip(txtCedula1);
        JOptionPane.showInternalMessageDialog(
                this,
                txtCedula1,
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        try {
            txtCedula1.commitEdit();
        } catch (ParseException ex) {
            LOG.info(
                    """
                     
            No se ingreso criterios de busquedas.
            """
            );
            return;
        }

        criterioBusqueda = txtCedula1.getText();

        jsPaginaNro.setValue(1);

        llenarTablaClientes(-1, criterioBusqueda);

        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se encontro registros con dichos criterios.",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
            btnActualizarRegistrosCliente.doClick();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed
    /**
     * Proceso de validación.
     *
     * 1) Se valida que la cedula del cliente no esté vacia.
     *
     * 2) Primer nombre y apellidos no puede estar vació.
     *
     * 3) Debe Proporcionarse una fecha de nacimiento.
     *
     * 4) La fecha de nacimiento no puede ser mayor a la actual.
     *
     * 5) Debe Existir un dirección registrada.
     *
     * 6) Debe exitir una forma de contacto obligatorio.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (validaCampoCedula(txtCedula)) {
            return;
        }// Validacion 1

        if (M_Generales.cedula(txtCedula.getValue().toString())) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Cedula no pasan las pruebas.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }
        }

        if (txtPNombre.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un nombre...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            jtpDireccionContactos.setSelectedComponent(jpGenerales);
            txtPNombre.requestFocusInWindow();
            return;
        }//Validacion 2

        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un apellido...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpGenerales);
            txtApellidos.requestFocusInWindow();
            return;
        }//Validacion 2

        if (Objects.isNull(dchFechaNacimiento.getDate())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe indicar una fecha de nacimiento.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }//Validacion 3

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Fecha de nacimiento incorrecta!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }//Validacion 4

        if (tblDireccion.getRowCount() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar una direccion del cliente.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpDireccion);
            txtDireccion.requestFocusInWindow();
            return;
        }//Validacion 5

        if (tblCorreos.getRowCount() < 1 & tblTelefonos.getRowCount() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    No existe forma de contactar al cliente, 
                    Agregue un numero de telefono o correo electronico.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpContactos);
            jtpContactos.setSelectedComponent(jpTelefonos);
            return;
        }//Validacion 6

        //Buscar la cedula en la base de datos.
        List<Cliente> clientes = getClientes(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda(txtCedula.getValue().toString())
                        .build()
        );

        idCliente = -1;

        //Condicional para saber si no esta vacia la lista. 
        if (!clientes.isEmpty()) {
            //Cliente existe en la base de datos. 
            idCliente = clientes.get(0).getId_persona(); //Validacion 8
        }

        // si es nuevo validamos que el Cliente no exista
        String accion = "editar";
        if (v_nuevo) {
            accion = "crear";
            if (idCliente > 0) {
                //Preguntar si desea carga la data desde la base de datos.
                int resp = JOptionPane.showInternalConfirmDialog(
                        this,
                        """
                        Cliente se encuentra en la base de datos.
                        Desea cargar el registro?
                        """,
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (resp == JOptionPane.NO_OPTION) {
                    return;
                }

                //Carga la informacion del cliente que se trata de registrar
                mostrarRegistro(idCliente);
            }else{
                
            }
        } else {
                idCliente = ((Cliente) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona();
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "<html><b>Se va a " + accion + " el Cliente: </b>"
                + txtPNombre.getText()
                + (txtSNombre.getText().isEmpty() || txtSNombre.getText().isBlank()
                ? "" : " " + txtSNombre.getText())
                + " " + txtApellidos.getText()
                + "<br><b>Cedula no.: </b> " + txtCedula.getText()
                + "<br><b>Fecha Nacimiento: </b>" + formatDate(dchFechaNacimiento.getDate(), "dd-MM-yyyy")
                + "<br><b>Estado del Cliente: </b>" + cbEstado.getText()
                + "<br><b>Desea continuar? </b></html>",
                """
                """,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        Cliente miCliente = Cliente
                .builder()
                .id_persona(idCliente)
                .generales(
                        Generales
                                .builder()
                                .cedula(txtCedula.getValue().toString())
                                .estado_civil(
                                        ((EstadoCivil) jcbEstadoCivil.getSelectedItem()).getAbreviatura()
                                )
                                .build()
                )
                .direcciones(v_direccionesList)
                .contactosTel(v_contactosTelsList)
                .contactosEmail(v_contactosCorreosList)
                .persona(
                        ((TipoPersona) jcbPersona.getSelectedItem()).getAbreviatura()
                )
                .sexo(
                        ((Sexo) jcbSexo.getSelectedItem()).getAbreviatura()
                )
                .pnombre(txtPNombre.getText())
                .snombre(txtSNombre.getText())
                .apellidos(txtApellidos.getText())
                .fecha_nacimiento(
                        new java.sql.Date(dchFechaNacimiento.getDate().getTime())
                )
                .estado(cbEstado.isSelected())
                .build();

        Resultados resultados = (v_nuevo ? agregarCliente(miCliente)
                : modificarCliente(miCliente));

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );

        btnCancelarActionPerformed(evt);

        limpiarListas();
        v_nuevo = null;
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHistorialClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialClientesActionPerformed
        if (v_miDetalle == null) {
            v_miDetalle = new frmDetalleFacturaClientes();
        }

        frmPrincipal.abrirFormulario(v_miDetalle);
    }//GEN-LAST:event_btnHistorialClientesActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        jcbPersona.requestFocusInWindow();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        /**
         * El objectivo del siguiente codigo es generar una cedula valida para
         * fines de pruebas del sistema.
         */
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCedula.setText(generarCedula());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void jcbPersonaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        dchFechaNacimiento.requestFocusInWindow();
    }//GEN-LAST:event_jcbPersonaPopupMenuWillBecomeInvisible

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
        btnGuardar.requestFocusInWindow();
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocusInWindow();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        if (txtPNombre.getText().isBlank() && !txtSNombre.getText().isEmpty()) {
            txtPNombre.setText(txtSNombre.getText());
            txtSNombre.setText("");
        }
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        dchFechaNacimiento.requestFocusInWindow();
        v_editor.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void jcbEstadoCivilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible
        jcbSexo.requestFocusInWindow();
        jcbSexo.showPopup();
    }//GEN-LAST:event_jcbEstadoCivilPopupMenuWillBecomeInvisible

    private void jcbProvinciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbProvinciasActionPerformed
        jcbMunicipios.removeAllItems();

        getMunicipio(
                jcbProvincias.getSelectedIndex() <= 0
                ? 0 : ((Provincia) jcbProvincias.getSelectedItem()).getId()
        ).stream().forEach(
                municipio -> jcbMunicipios.addItem(municipio)
        );

        if (jcbProvincias.getSelectedIndex() > 0) {
            jcbMunicipios.setEnabled(true);
            jcbMunicipios.requestFocusInWindow();
        } else {
            jcbMunicipios.setEnabled(false);
        }
    }//GEN-LAST:event_jcbProvinciasActionPerformed

    private void jcbMunicipiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMunicipiosActionPerformed

        jcbDistritoMunicipal.removeAllItems();

        getDistritosMunicipales(jcbMunicipios.getSelectedIndex() <= 0 ? 0
                : ((Municipio) jcbMunicipios.getSelectedItem()).getId()
        ).stream().forEach(distrito -> {
            jcbDistritoMunicipal.addItem(distrito);
        });

        if (jcbMunicipios.getSelectedIndex() > 0) {
            jcbDistritoMunicipal.setEnabled(true);
            jcbDistritoMunicipal.requestFocusInWindow();
        } else {
            jcbDistritoMunicipal.setEnabled(false);
        }
    }//GEN-LAST:event_jcbMunicipiosActionPerformed

    private void jcbDistritoMunicipalPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible
        txtDireccion.requestFocusInWindow();
    }//GEN-LAST:event_jcbDistritoMunicipalPopupMenuWillBecomeInvisible


    private void btnAgregarDireccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionesActionPerformed
        //Nos aseguramos que exista una provincia seleccionada.
        if (jcbProvincias.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar una provincia.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jcbProvincias.requestFocusInWindow();
            jcbProvincias.showPopup();
            return;
        }

        //Nos aseguramos que exiista un municipio seleccionado
        if (jcbMunicipios.getSelectedIndex() < 1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un municipio.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jcbMunicipios.requestFocusInWindow();
            jcbMunicipios.showPopup();
            return;
        }

        //La direccion residencia debe escribirse en la caja de texto de direccion.
        if (txtDireccion.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar dirección.!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtDireccion.requestFocusInWindow();
            return;
        }

        /*
            Se preparan la provincia, municipio y el distrito municipal.
         */
        Provincia provincia = (Provincia) jcbProvincias.getSelectedItem();
        Municipio municipio = (Municipio) jcbMunicipios.getSelectedItem();
        Distrito_municipal distritoMunicipal
                = (Distrito_municipal) jcbDistritoMunicipal.getSelectedItem();

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                """
                
                Es la dirección por defecto del cliente?
                
                """,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        Boolean por_defecto = resp == JOptionPane.YES_OPTION;

        Direccion direccion = Direccion
                .builder()
                .id(-1)
                .id_persona(idCliente)
                .provincia(provincia)
                .municipio(municipio)
                .distrito_municipal(distritoMunicipal)
                .direccion(txtDireccion.getText())
                .estado(Boolean.TRUE)
                .por_defecto(por_defecto)
                .accion('a')
                .build();

        //Se guardan las direcciones en esta lista para ser enviada.
        v_direccionesList.add(direccion);

        if (v_nuevo) {
            Object registroDireccion[] = new Object[TITULOS_DIRECCION.length];

            registroDireccion[0] = provincia;
            registroDireccion[1] = municipio;
            registroDireccion[2] = distritoMunicipal;
            registroDireccion[3] = txtDireccion.getText();
            registroDireccion[4] = "";
            registroDireccion[5] = Boolean.TRUE;
            registroDireccion[6] = por_defecto;

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
        } else {
            agregarModificarDirecciones(
                    ((Cliente) tblClientes.getValueAt(
                            tblClientes.getSelectedRow(),
                            0
                    )).getId_persona(),
                    v_direccionesList
            );
            v_direccionesList.clear();
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

    private void btnEliminarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDirrecionActionPerformed
        if (tblDireccion.getSelectedRow() == -1) {
            return;
        }

        eliminarRegistro(tblDireccion, v_dtmDireccion, v_direccionesList);

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
                        txtTelelfonoMovil.setText(generarTelMovil());
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
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtTelelfonoMovil.setValue("");
            txtTelelfonoMovil.requestFocusInWindow();
            return;
        }

        //Esta validacion deberia de ser si el cliente en nacional
        if (!telefono(txtTelelfonoMovil.getValue().toString())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
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
        v_contactosTelsList.add(ContactoTel.builder().
                telefono(telefono).
                tipo(tipo).build());

        v_dtmTelefono.addRow(registroTel);
        tblTelefonos.setModel(v_dtmTelefono);

        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocusInWindow();

        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void btnBorrarTelefonoMovilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoMovilActionPerformed
        //TODO Esto hay que completarlo.
        if (v_nuevo) {

        } else {

        }

        eliminarRegistro(tblTelefonos, v_dtmTelefono, v_contactosTelsList);

        repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnBorrarTelefonoMovilActionPerformed

    private void btnAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        /*
            Validamos que el correo no esté vacio.
         */
        if (txtCorreo.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar correo electronico.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCorreo.requestFocusInWindow();
            return;
        }

        /*
        Verificamos que sea un correo valido.
         */
        if (!correo(txtCorreo.getText())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar correo electronico valido.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCorreo.requestFocusInWindow();
            return;
        }

        if (v_nuevo) {
            //TODO Llenamos el List de correo.
            v_contactosCorreosList.add(ContactoEmail.
                    builder().
                    email(txtCorreo.getText()).
                    build()
            );
        } else {
            //TODO Necesitamos el Id del registro del correo.

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
        txtCorreo.requestFocusInWindow();

        //Reparamos la columnas de la tabla.
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void btnEliminarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCorreoActionPerformed
        if (v_nuevo) {

        } else {

        }

        eliminarRegistro(tblCorreos, v_dtmCorreo, v_contactosCorreosList);
        repararColumnaTable(tblCorreos);
    }//GEN-LAST:event_btnEliminarCorreoActionPerformed

    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        if (validaCampoCedula(txtCedula)) {
            return;
        }

        List<Cliente> clientes = getClientes(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda(txtCedula.getValue().toString())
                        .build()
        );

        if (Objects.isNull(clientes) || clientes.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cedula valida, puede continuar.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            idCliente = clientes.get(0).getId_persona();
            if (v_nuevo) {
                if (idCliente > 0 && !clientes.get(0).getEstado()) {
                    int resp = JOptionPane.showInternalConfirmDialog(
                            this,
                            """
                            Esta cedula está registrada.
                            Procede a habilitar el cliente?
                            """,
                            "",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE
                    );

                    //Preguntamos si desea cargar la informacion del cliente.
                    if (resp == JOptionPane.NO_OPTION) {
                        btnCancelarActionPerformed(evt);
                        return;
                    }

                    /**
                     * Al insertar un cliente ya registrado el siguiente metodo
                     * devuelve falso, es por ello se valida la negacion de
                     * false, para obtener true.
                     */
                    Resultados resultado = agregarClienteById(idCliente);

                    //!resultado.getEstado();
                    JOptionPane.showInternalMessageDialog(
                            this,
                            resultado.getMensaje(),
                            "",
                            resultado.getIcono()
                    );
                }
            }
        }
    }//GEN-LAST:event_btnCedulaValidadActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //1) Llenar la lista de clientes en el sistema.
        llenarTablaClientes(-1, "");

        //2) Llenar los comboBox de las provincias.
        jcbProvincias.removeAllItems();
        getProvincias().stream().forEach(
                provincia -> jcbProvincias.addItem(provincia)
        );

        //3) Llenar los comboBox de las personas juridicas.
        jcbPersona.removeAllItems();
        getTipoPersonaList().stream().forEach(
                tipoPersona -> jcbPersona.addItem(tipoPersona)
        );

        //4) Obtener la lista de sexo de personas.
        jcbSexo.removeAllItems();
        getSexoList().stream().forEach(
                sexo -> jcbSexo.addItem(sexo)
        );

        //5) Obtener la lista de estado civil de las personas.
        jcbEstadoCivil.removeAllItems();
        getEstadoCivilList().stream().forEach(
                estadoCivil -> jcbEstadoCivil.addItem(estadoCivil)
        );

        //Validando los botones por consultas. 
        //Permiso para el boton de nuevo
        btnNuevo.setEnabled(privilegio(Privilegio
                .builder()
                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                .nombre_relacion("SP_INSERT_CLIENTE_SB")
                .nombre_campo("^")
                .build()
        )
        );

        //Permiso para el boton de Borrar
        btnBorrar.setEnabled(privilegio(Privilegio
                .builder()
                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                .nombre_relacion("SP_DELETE_CLIENTE_SB")
                .nombre_campo("^")
                .build()
        )
        );

        //Permiso para el boton de Modificar
        btnModificar.setEnabled(privilegio(Privilegio
                .builder()
                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                .nombre_relacion("SP_UPDATE_CLIENTE_SB")
                .nombre_campo("^")
                .build()
        )
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
                        txtCorreo.setText(generarCorreo());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCorreoKeyPressed
    /**
     * Para una direccion ser modificada debe cumplir lo siguente:
     *
     * 1) No contener ningun registros en facturas. 2)
     *
     * Al editar una factura se debe: 1) Deshabilitar el boton de borrar
     * registro.
     *
     *
     * @param evt
     */
    private void btnEditarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDireccionActionPerformed
        if (tblDireccion.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un registro a modificar.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        int provinciaTbl = ((Provincia) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 0)).getId();

        int municipioTbl = ((Municipio) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 1)).getId();

        int distritoTbl = ((Distrito_municipal) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 2)).getId();

        String direccion = tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 3).toString();

        int idRegistro = ((Direccion) tblDireccion.getValueAt(
                tblDireccion.getSelectedRow(), 3)).getId();

        for (int i = 0; i < jcbProvincias.getItemCount(); i++) {
            int provinciaCombo = ((Provincia) jcbProvincias.getItemAt(i)).getId();
            if (provinciaCombo == provinciaTbl) {
                jcbProvincias.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < jcbMunicipios.getItemCount(); i++) {
            int municipioCombo = ((Municipio) jcbMunicipios.getItemAt(i)).getId();
            if (municipioCombo == municipioTbl) {
                jcbMunicipios.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < jcbDistritoMunicipal.getItemCount(); i++) {
            int distritoCombo = ((Distrito_municipal) jcbDistritoMunicipal.getItemAt(i)).getId();
            if (distritoCombo == distritoTbl) {
                jcbDistritoMunicipal.setSelectedIndex(i);
                break;
            }
        }

        txtDireccion.setText(direccion);

        btnEliminarDirrecion.setEnabled(false);
    }//GEN-LAST:event_btnEditarDireccionActionPerformed

    private void jtpDireccionContactosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpDireccionContactosKeyPressed
        if (evt.isControlDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_1) {
                jtpDireccionContactos.setSelectedIndex(jtpDireccionContactos.indexOfComponent(jpGenerales));
            }
            if (evt.getKeyCode() == KeyEvent.VK_2) {
                jtpDireccionContactos.setSelectedIndex(jtpDireccionContactos.indexOfComponent(jpDireccion));
            }
            if (evt.getKeyCode() == KeyEvent.VK_3) {
                jtpDireccionContactos.setSelectedIndex(jtpDireccionContactos.indexOfComponent(jpContactos));
            }
        }
    }//GEN-LAST:event_jtpDireccionContactosKeyPressed

    private void jcbProvinciasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbProvinciasKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbProvincias.getItemCount();
                        int randon = (int) (Math.random() * cantidad);
                        if (randon == 0) {
                            randon++;
                        }
                        jcbProvincias.setSelectedIndex(randon);
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbProvinciasKeyPressed

    private void jcbDistritoMunicipalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbDistritoMunicipalKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbDistritoMunicipal.getItemCount();
                        int randon = (int) (Math.random() * cantidad);
                        jcbDistritoMunicipal.setSelectedIndex(randon);
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbDistritoMunicipalKeyPressed

    private void jcbMunicipiosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcbMunicipiosKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int cantidad = jcbMunicipios.getItemCount();
                        int randon = (int) (Math.random() * cantidad);
                        if (randon == 0) {
                            randon++;
                        }
                        jcbMunicipios.setSelectedIndex(randon);
                    }
                }
            }
        }
    }//GEN-LAST:event_jcbMunicipiosKeyPressed

    private void btnImprimirInforme1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirInforme1ActionPerformed
        // TODO Trabajando en la impresion del listado de los clientes.

    }//GEN-LAST:event_btnImprimirInforme1ActionPerformed

    private void jsCantidadFilasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsCantidadFilasStateChanged
        llenarTablaClientes(-1, criterioBusqueda);
    }//GEN-LAST:event_jsCantidadFilasStateChanged

    private void jsPaginaNroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsPaginaNroStateChanged
        llenarTablaClientes(-1, criterioBusqueda);
    }//GEN-LAST:event_jsPaginaNroStateChanged

    private void btnActualizarRegistrosClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegistrosClienteActionPerformed
        llenarTablaClientes(-1, "");
        criterioBusqueda = "";
    }//GEN-LAST:event_btnActualizarRegistrosClienteActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated

    }//GEN-LAST:event_formInternalFrameActivated

    private void tblDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDireccionMouseClicked
        boolean valor = tblDireccion.getSelectedRow() >= 0;
        btnEditarDireccion.setEnabled(valor);
        btnEliminarDirrecion.setEnabled(valor);
    }//GEN-LAST:event_tblDireccionMouseClicked

    private void eliminarRegistro(JTable tabla, DefaultTableModel modelo, List lista) {
        if (tabla.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un registro de la tabla",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        lista.remove(tabla.getSelectedRow());

        modelo.removeRow(tabla.getSelectedRow());

        tabla.setModel(modelo);
    }

    /**
     * Metodo utilizado para llenar la tabla de cliente del sistema. Nota: Este
     * evento Debe ser publico porque este es llamado desde los eventos de
     * Firebird.
     *
     * @param id
     * @param criterioBusqueda
     *
     * @return Devuelve la propiedades de un JTable para ser testeada.
     */
    public synchronized static JTable llenarTablaClientes(int id,
            String criterioBusqueda) {

        if (Objects.isNull(criterioBusqueda)) {
            criterioBusqueda = "";
        }

        if (criterioBusqueda.equalsIgnoreCase("evento")) {
            criterioBusqueda = frmClientes.criterioBusqueda;
        }

        final String titulos[] = {"Cedulas", "Persona", "Primer Nombre",
            "Segundo Nombre", "Apellidos", "Sexo", "Fecha nacimiento",
            "Fecha Ingreso", "Estado"
        };

        Object registro[] = new Object[titulos.length];

        DefaultTableModel dtmClientes = new DefaultTableModel(null, titulos);

        getClientes(
                FiltroBusqueda
                        .builder()
                        .id(id)
                        .criterioBusqueda(criterioBusqueda)
                        .filas(Boolean.TRUE)
                        .nCantidadFilas(
                                Integer.valueOf(
                                        jsCantidadFilas.getValue().toString()
                                )
                        )
                        .nPaginaNro(
                                Integer.valueOf(
                                        jsPaginaNro.getValue().toString()
                                )
                        )
                        .build()
        ).stream().forEach(
                cliente -> {
                    registro[0] = Cliente
                            .builder()
                            .id_persona(cliente.getId_persona())
                            .generales(cliente.getGenerales())
                            .build();
                    registro[1] = String.valueOf(
                            cliente.getPersona()
                    ).equalsIgnoreCase("j") ? "JURÍDICA" : "FÍSICA";
                    registro[2] = cliente.getPnombre();
                    registro[3] = cliente.getSnombre();
                    registro[4] = cliente.getApellidos();
                    registro[5] = String.valueOf(
                            cliente.getSexo()
                    ).equalsIgnoreCase("M") ? "MASCULINO" : "FEMENINO";
                    registro[6] = formatDate(
                            cliente.getFecha_nacimiento(),
                            "dd/MM/yyyy"
                    );
                    registro[7] = formatDate(
                            cliente.getFecha_ingreso(),
                            "dd/MM/yyyy"
                    );
                    registro[8] = cliente.getEstado();

                    dtmClientes.addRow(registro);
                }
        );

        tblClientes.setModel(dtmClientes);

        int[] indices = {8};
        columnasCheckBox(tblClientes, indices);

        repararColumnaTable(tblClientes);

        tblClientes.setBackgoundHover(new java.awt.Color(102, 102, 255));
        return tblClientes;
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
    private boolean validarRegistro(String accion) {
        //Si la tabla de registro de los cliente está vacia devolvemos true
        //para que el proceso no continue.
        if (tblClientes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe contar con clientes en registros, Ingrese nuevos clientes.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblClientes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe de seleccionar un cliente",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Verificamos que el registro no sea de un cliente generico, de serlo lo 
        // devolvemos true para que el proceso no continue. 
        if (((Persona) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0)).getId_persona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cliente GENERICO no puede ser %s".formatted(accion),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }

    /**
     * Es el metodo encargado de llenar el formulario del cliente cuando este se
     * va a modificar en la base de datos.<br>
     *
     * El mismo idCliente es utilizado para obtener la lista de direcciones,
     * lista de correo y lista de telefonos del cliente.<br>
     *
     * @param idCliente El identificador del cliente en la base de datos.
     */
    private void mostrarRegistro(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        LOG.info("\nSe muestran los registro del cliente %s".formatted(idCliente));
        //Obteniendo el objeto cliente.
        getClientes(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda("^+/*")
                        .id(idCliente)
                        .build()
        ).stream().forEach(
                p_cliente -> {
                    //Llenar los compos basicos.
                    txtCedula.setValue(p_cliente.getGenerales().getCedula());
                    txtPNombre.setText(p_cliente.getPnombre());
                    txtSNombre.setText(p_cliente.getSnombre());
                    txtApellidos.setText(p_cliente.getApellidos());

                    dchFechaNacimiento.setDate(sqlDateToUtilDate(p_cliente.getFecha_nacimiento()));

                    cbEstado.setSelected(p_cliente.getEstado());
                    cbEstado.setText(p_cliente.getEstado() ? "Activo" : "Inactivo");

                    jlFechaCreacion.setText("Fecha de Ingreso: " + p_cliente.getFecha_ingreso());

                    //Buscando la combinacion del tipo persona con el registro de la 
                    //base de datos.
                    for (int i = 0; i < jcbPersona.getItemCount(); i++) {
                        if (p_cliente.getPersona().equals(
                                ((TipoPersona) jcbPersona.getItemAt(i)).getAbreviatura()
                        )) {
                            jcbPersona.setSelectedIndex(i);
                            break;
                        }
                    }

                    //Buscando la combinacion del sexo con el registro de la base de datos.
                    for (int i = 0; i < jcbSexo.getItemCount(); i++) {
                        if (p_cliente.getSexo().equals(
                                ((Sexo) jcbSexo.getItemAt(i)).getAbreviatura()
                        )) {
                            jcbSexo.setSelectedIndex(i);
                            break;
                        }
                    }

                    //Buscando la combinacion del estado civil con el registro de la 
                    //base de datos.
                    for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
                        if (p_cliente.getGenerales().getEstado_civil().equals(
                                ((EstadoCivil) jcbEstadoCivil.getItemAt(i)).getAbreviatura()
                        )) {
                            jcbEstadoCivil.setSelectedIndex(i);
                            break;
                        }
                    }
                }
        );

        limpiarTablasDirTelCor();
        limpiarListas();

        updateTablaDirreciones(idCliente);
        updateTablaTelefonos(idCliente);
        updateTablaCorreos(idCliente);
    }

    public void updateTablaCorreos(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        Object registroCorreo[] = new Object[TITULOS_CORREO.length];
        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(v_dtmCorreo);
        getCorreoByID(idCliente).stream().forEach(
                p_correo -> {
                    registroCorreo[0] = p_correo;
                    registroCorreo[1] = p_correo.getFecha();

                    v_contactosCorreosList.add(p_correo);

                    v_dtmCorreo.addRow(registroCorreo);
                }
        );
        tblCorreos.setModel(v_dtmCorreo);
    }

    public void updateTablaTelefonos(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        Object registroTel[] = new Object[TITULOS_TELEFONO.length];
        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(v_dtmTelefono);
        getTelefonoByID(idCliente).stream().forEach(
                p_telefono -> {
                    registroTel[0] = p_telefono;
                    registroTel[1] = p_telefono.getTipo();
                    registroTel[2] = p_telefono.getFecha();

                    v_contactosTelsList.add(p_telefono);

                    v_dtmTelefono.addRow(registroTel);
                }
        );
        tblTelefonos.setModel(v_dtmTelefono);
    }

    public static void updateTablaDirreciones(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        Object registroDireccion[] = new Object[TITULOS_DIRECCION.length];
        v_dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);
        tblDireccion.setModel(v_dtmDireccion);
        getDireccionByID(idCliente).stream().forEach(
                p_direccione -> {

                    registroDireccion[0] = p_direccione.getProvincia();
                    registroDireccion[1] = p_direccione.getMunicipio();
                    registroDireccion[2] = p_direccione.getDistrito_municipal();
                    registroDireccion[3] = Direccion
                            .builder()
                            .id(p_direccione.getId())
                            .direccion(p_direccione.getDireccion())
                            .build();
                    registroDireccion[4] = p_direccione.getFecha();
                    registroDireccion[5] = p_direccione.getEstado();
                    registroDireccion[6] = p_direccione.getPor_defecto();
                    v_direccionesList.add(p_direccione);
                    v_dtmDireccion.addRow(registroDireccion);
                }
        );
        tblDireccion.setModel(v_dtmDireccion);
        int[] columnas = {5, 6};
        columnasCheckBox(tblDireccion, columnas);
    }

    /**
     * Este metodo debe cambiar el comportamiento de la ventana al pulsar sobre
     * nuevo o editar.<br>
     *
     * @param activo Este parametro es utilizado cuando se va a ingresar o
     * modificar registros a la base de datos.<br><br>
     *
     * <b>Si su valor es verdadero:</b><br>
     * 1) Los botones de nuevo, editar, borrar y buscar deben inhabilitarse.<br>
     * 2) Los botones de guardar y cancelar pasan habilitarse.<br>
     * <br>
     * <b>Si su valor es falso:</b>
     * Lo contrario de cuando su valor es verdadero. <br>
     * 1) Los botones de nuevo, editar, borrar y buscar deben habilitarse. <br>
     * 2) Los botones de guardar y cancelar pasan inhabilitarse.<br><br>
     *
     * Al presionar nuevo o editar debe cambiarse en la vista Clientes a
     * Mantenimiento.<br>
     * Este metodo se llama desde el boton nuevo y modificar con el valor del
     * parametros true y desde cancelar con el valor del parametro false.
     */
    private void cambioBoton(boolean activo) {
        /*
            Aqui pasan los JScrollPane se alternan con el valor de activo,
        true selecciona el mantenimiento y false selecciona los registros de 
        clientes.
         */
        if (activo) {
            jtpPrincipal.addTab("Mantenimiento", jspMantenimiento);
            jtpPrincipal.setSelectedComponent(jspMantenimiento);
            jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jspClientes), false);
        } else {
            jtpPrincipal.setSelectedComponent(jspClientes);
            jtpPrincipal.remove(jspMantenimiento);
            jtpPrincipal.setEnabledAt(jtpPrincipal.indexOfComponent(jspClientes), true);
        }

        /*
            Seleccionamos las pestañas de direcciones por defecto.
         */
        jtpDireccionContactos.setSelectedComponent(jpGenerales);

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

        jlFechaCreacion.setVisible(!v_nuevo);

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
        cbEstado.setText(activo ? "Activo" : "Inactivo");

        if (jcbPersona.getItemCount() > 0) {
            jcbPersona.setSelectedIndex(0);
        }

        if (jcbEstadoCivil.getItemCount() > 0) {
            jcbEstadoCivil.setSelectedIndex(0);
        }

        if (jcbSexo.getItemCount() > 0) {
            jcbSexo.setSelectedIndex(0);
        }

        if (jcbProvincias.getItemCount() > 0) {
            jcbProvincias.setSelectedIndex(0);
        }

        if (jcbMunicipios.getItemCount() > 0) {
            jcbMunicipios.setSelectedIndex(0);
        }

        if (jcbDistritoMunicipal.getItemCount() > 0) {
            jcbDistritoMunicipal.setSelectedIndex(0);
        }

        txtDireccion.setText("");

        jrbMovil.setSelected(true);

        if (v_nuevo) {
            txtCedula.setText("");
            txtCedula.requestFocusInWindow();
        } else {
            txtPNombre.requestFocusInWindow();
        }
        //nuevasTablasDirTelCor();
    }

    /**
     * Este metodo permite resetear todas las tablas del modulo a cero
     * registros.
     *
     * Se llama desde el constructor, y desde el metodo cambioBoton.
     */
    private void limpiarTablasDirTelCor() {
        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(v_dtmTelefono);

        v_dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);
        tblDireccion.setModel(v_dtmDireccion);

        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(v_dtmCorreo);
        LOG.info("\nTablas de telefono, correo y direcciones limpias.");
    }

    private boolean validaCampoCedula(javax.swing.JFormattedTextField campo) {
        try {
            campo.commitEdit();
        } catch (ParseException ex) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar la cedula del cliente",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpDireccionContactos.setSelectedComponent(jpGenerales);
            campo.requestFocusInWindow();
            campo.selectAll();
            return true;
        }
        return false;
    }

    /**
     * Metodo que permite limpiar las lista de direcciones, contactos de
     * telefono y correos.
     */
    private void limpiarListas() {
        v_direccionesList.clear();
        v_contactosTelsList.clear();
        v_contactosCorreosList.clear();
        LOG.info(
                """

        Lista de direcciones, contactos de telefono y correo limpias.

        """
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnActualizarRegistrosCliente;
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
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorialClientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JCheckBox cbEstado;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private static RSMaterialComponent.RSComboBox jcbDistritoMunicipal;
    private javax.swing.JComboBox jcbEstadoCivil;
    private static RSMaterialComponent.RSComboBox jcbMunicipios;
    private static javax.swing.JComboBox jcbPersona;
    private static RSMaterialComponent.RSComboBox jcbProvincias;
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpBotones2;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpContactos;
    private javax.swing.JPanel jpCorreos;
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JPanel jpGenerales;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpMantenimiento2;
    private javax.swing.JPanel jpTelefonos;
    private javax.swing.JRadioButton jrbMovil;
    private javax.swing.JRadioButton jrbResidencial;
    private static javax.swing.JSpinner jsCantidadFilas;
    private static javax.swing.JSpinner jsPaginaNro;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JScrollPane jspGeneral;
    private javax.swing.JScrollPane jspMantenimiento;
    private javax.swing.JTabbedPane jtpContactos;
    private javax.swing.JTabbedPane jtpDireccionContactos;
    public static javax.swing.JTabbedPane jtpPrincipal;
    private static rojerusan.RSTableMetro1 tblClientes;
    private static rojerusan.RSTableMetro1 tblCorreos;
    private static rojerusan.RSTableMetro1 tblDireccion;
    private static rojerusan.RSTableMetro1 tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedula1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
}

/**
 * El <b>btnNuevo</b> de cumplir lo siguiente:<br>
 * 1) Debe cambiar el valor de v_nuevo a true; X<br>
 * 2) Debe cambiar el TabPane de Cliente a Mantenimiento y presentar el <br>
 * formulario limpio. X<br>
 * 3) Debe deshabilitar los botones de nuevo, modificar borrar y buscar. X<br>
 * 4) Debe habilitar los botones de guardar y cancelar. X<br>
 * 5) Debe siempre limpiar las tablas de formulario de registro. X<br>
 * 6) Debe siempre limpiar los comboBox de provincia, municipio y distritos <br>
 * municipal. X<br>
 * 7) Debe siempre limpiar los comboBox de Estado civil, sexo y Tipo persona.
 * X<br>
 * 8) <br>
 *
 *
 * El <b>btnModificar</b> debe cumplir lo siguiente:<br>
 * 1) Debe ejecutarse el metodo validarRegistro(), si este devuelve TRUE<br>
 * Debe devolverse el flojo de control. X<br>
 * 2) Debe cambiar el valor de v_nuevo a false; X<br>
 * 3) Debe validar que un registros este seleccionado. X<br>
 * 4) Debe cambiar el TabPane de Clientes a Mantenimiento. <br>
 * 5) Presentar el formulario de registros con los datos de registros <br>
 * seleccionado a modificar. X<br>
 * 6) Debe habilitar los botones de guardar y cancelar. X<br>
 * 7) Debe de ajustarse el ancho de las columnas de las tablas como Correo,<br>
 * Direcciones y Telefono.
 *
 *
 * El <b>btnBorrar</b> debe cumplir lo siguiente:<br>
 * 1) Debe utilizar el metodo validarRegistro(). <br>
 * 2) Debe mostrar un cuadro de dialogo que diga <br>
 * ¿Esta Seguro de Eliminar Registro del Cliente?<br>
 * y mostrar la opciones de Si o No.<br>
 * 3) Si selecciona que NO debe devolver el flujo de control. <br>
 * 4) En caso contrario se procede a obtener el idCliente<br>
 * del registro de la tabla tblClientes.<br>
 * 5) Se manda a llamar el metodo borrarCliente(idCliente) y se <br>
 * obtiene un objecto de la clase Resultados la cual con el <br>
 * metodo getMensaje() obtenemos como resultado de la operacion <br>
 * un mensaje del metodo. 6) Evaluamos el resultado del mensaje con la variable
 * estatica de la <br>
 * clase Cliente CLIENTE_BORRADO_CORRECTAMENTE. 7) Mostramos el resultado de la
 * operacion en un JOpcionPane 8) Reperamos el ancho de las columnas de la tabla
 * tblClientes.
 *
 *
 *
 * El <b>btnBuscar</b> debe cumplir lo siguiente:<br>
 * 1) Debe iniciarlizar la variable v_hilo, para cuando el<br>
 * JOpcionPane se muestre gane el focus el componente.<br>
 * 2) El campo Cedula debe limpiarse.<br>
 * 3) Debe mostrarse la ventana pidiendo que digite la <br>
 * cedula a buscar.<br>
 * 4) Se interrumpe el hilo de ejecucion del paso 1. X<br>
 * 5) Si la opcion es no, se cancela el proceso. X<br>
 * 6) Si la opcion es si, se valida que se halla digitado<br>
 * una cedula completa.<br>
 * 7) En caso de que no es una cedula completa se muestra<br>
 * un mensaje de error.<br>
 * 8) Si la cedula es correcta se manda a consultar la cedula<br>
 * digitada.<br>
 * 9) En caso de no encontrarla mostrar el mensaje que diga: <br>
 * "El Cliente No Existe!" 10) Si
 *
 *
 * El <b>btnGuardar</b> debe cumplir lo siguiente:<br>
 * 1) Validamos que el campo de la cedula sea correcto. X<br>
 * 2) Mostramos mensaje de error si el campo primer nombre está en blanco. X<br>
 * 3) Mostramos mensaje de error si el campo de apellidos está en blanco. X<br>
 * 4) Mostramos mensaje de error si el campo de fecha es nulo. X<br>
 * 5) Mostramos mensaje de error si la fecha del campo fecha nacimiento está
 * <br>
 * por encima de la fecha actual. X<br>
 * 6) Nos aseguramos que la tabla de direcciones contenga por lo menos <br>
 * un registro. 7) Nos aseguramos que exista una forma de contacto con el
 * cliente.<br>
 * 8) Investigamos si existe un identificador o Id en la base de datos, <br>
 * Relacionado con la cedula suministrada.<br>
 * 9) Vamos a validar por caso: <br>
 * Si es Nuevo:<br>
 * 1) Y el identificador es diferente de -1 entonces existe un registro <br>
 * previo del cliente en la base de datos.<br>
 * Si es Modificar:<br>
 * 2) Y el identificador es igual a -1 entonces no existe un usuario <br>
 * con dicha cedula, lo que implica es que el cliente va a modificar su<br>
 * cedula anterior.<br>
 *
 *
 * El <b>btnCancelar</b> debe cumplir lo siguiente: <br>
 * 1) Debe de eliminar el formulario de mantenimiento. X <br>
 * 2) Debe solo prensentar el formulario de registros de los clientes. X <br>
 *
 *
 *
 *
 * El <b>btnAgregarCorreo</b> debe cumplir lo siguiente:<br>
 * 1) Debe validar que sea un correo valido. X<br>
 * 2) <br>
 *
 *
 *
 * El <b>btnAgregarDirecciones</b> debe cumplir lo siguiente: <br>
 * 1) Valida que se haya seleccionado una pronvincia. X<br>
 * 2) Valida que se haya seleccionado un municipio. X<br>
 * 3) Se valida que se haya digitado una dirección. X<br>
 * 4) Se obtiene el identificador del usuario si se va <br>
 * a modificar el registro. En caso contrario se obtiene -1.<br>
 * 5) Se obtienen las claves primarias de provincia, municipio y <br>
 * distritos municipales de los comboBox de estos. 6) Se prepara el objecto
 * direccion para ser agregado a la variable<br>
 * de campo global v_direccionesList. 7) Se prepara un arreglo de objecto
 * llamado registroDirecciones el <br>
 * cual servira para agregar la direccion completa a la BD.<br>
 * 8) Se obtiene el modelo de la tabla de direcciones de la variable <br>
 * tblDireccion con el metodo getModel().<br>
 * 9) Se agregar el registro de la variable registroDireccion a la variable<br>
 * de campo v_dtmDireccion.<br>
 * 10) Y se setea el modelo a la tabla de direcciones tblDireccion.<br>
 * 11) Se colocan los jComboBox en el indice 0 de Provincia, Municipio y <br>
 * Distrito Municipal. 12) Los jComboBox de Municipio y Distritos Municipal se
 * deshabilitan. 13) El campo direccion se blanquea. 14) Se Reparan el ancho de
 * las columnas.
 *
 *
 * El <b>btn</b>
 *
 *
 *
 * Comportamiento a reparar siguiente desarrollo:
 *
 * 1) La tabla de registros de los clientes debe ser paginada y solo puede
 * cargar de 15 a 20 registros a la vez.
 *
 *
 *
 *
 * Notas:
 *
 */
