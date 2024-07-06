package sur.softsurena.formularios;

import RSMaterialComponent.RSButtonMaterialIconOne;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import lombok.Getter;
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
import sur.softsurena.metodos.M_Cliente;
import static sur.softsurena.metodos.M_Cliente.agregarClienteById;
import static sur.softsurena.metodos.M_Cliente.borrarCliente;
import sur.softsurena.metodos.M_ContactoEmail;
import static sur.softsurena.metodos.M_ContactoEmail.agregarContactosEmail;
import static sur.softsurena.metodos.M_ContactoEmail.correo;
import static sur.softsurena.metodos.M_ContactoEmail.generarCorreo;
import static sur.softsurena.metodos.M_ContactoEmail.getCorreoByID;
import sur.softsurena.metodos.M_ContactoTel;
import static sur.softsurena.metodos.M_ContactoTel.agregarContactosTel;
import static sur.softsurena.metodos.M_ContactoTel.generarTelMovil;
import static sur.softsurena.metodos.M_ContactoTel.getTelefonoByID;
import static sur.softsurena.metodos.M_ContactoTel.telefono;
import sur.softsurena.metodos.M_Direccion;
import static sur.softsurena.metodos.M_Direccion.agregarDireccion;
import static sur.softsurena.metodos.M_Direccion.getDireccionByID;
import static sur.softsurena.metodos.M_Distrito_Municipal.getDistritosMunicipales;
import static sur.softsurena.metodos.M_EstadoCivil.getEstadoCivilList;
import sur.softsurena.metodos.M_Generales;
import static sur.softsurena.metodos.M_Generales.generarCedula;
import static sur.softsurena.metodos.M_Municipio.getMunicipio;
import sur.softsurena.metodos.M_Persona;
import static sur.softsurena.metodos.M_Privilegio.privilegio;
import static sur.softsurena.metodos.M_Provincia.getProvincias;
import static sur.softsurena.metodos.M_Sexo.getSexoList;
import static sur.softsurena.metodos.M_TipoPersona.getTipoPersonaList;
import sur.softsurena.utilidades.FiltroBusqueda;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.eliminarRegistroTabla;
import static sur.softsurena.utilidades.Utilidades.formatDate;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.utilidades.Utilidades.sqlDateToUtilDate;
import static sur.softsurena.utilidades.Utilidades.validarCampo;

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

    private static Object registro[];
    
    

    public static frmClientes getInstance() {
        /*
            Si un permiso a las vistas consultada anteriormente es negado, se 
        lanza una excepcion y la venta no se iniciará.
         */
        if (!privilegio(
                Privilegio
                        .builder()
                        .privilegio(Privilegio.PRIVILEGIO_SELECT)
                        .nombre_relacion("GET_PERSONA_CLIENTES")
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

    private void btnDireccionEnable(boolean valor) {
        btnEditarDireccion.setEnabled(valor);
        btnBorrarDirrecion.setEnabled(valor);
        txtDireccion.requestFocusInWindow();
    }

    private void mensajeResultado(Resultado resultado, boolean estado) {
        if (resultado.getEstado() == estado) {
            JOptionPane.showMessageDialog(
                    this,
                    resultado.getMensaje(),
                    "",
                    resultado.getIcono()
            );
        }
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
        jtpGeneralesDireccionContactos = new javax.swing.JTabbedPane();
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
        btnBorrarDirrecion = new RSMaterialComponent.RSButtonMaterialIconOne();
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
        btnBorrarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarTelefono = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel1 = new javax.swing.JPanel();
        jrbResidencial = new javax.swing.JRadioButton();
        jrbMovil = new javax.swing.JRadioButton();
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
        btnBorrarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtCorreo = new javax.swing.JTextField();
        btnEditarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
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
        btnNuevoCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEditarCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarCliente = new RSMaterialComponent.RSButtonMaterialIconOne();
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

        setBorder(javax.swing.BorderFactory.createMatteBorder(25, 10, 10, 10, new java.awt.Color(37, 45, 223)));
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
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Cedula", "Persona", "Primer Nombre", "Segundo Nombre", "Apellidos", "Sexo", "Fecha Nacimiento", "Fecha de Ingreso", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
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
                        .addComponent(jsCantidadFilas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jsPaginaNro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpClientesLayout.createSequentialGroup()
                        .addGroup(jpClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE))
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
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jspClientes.setViewportView(jpClientes);

        jtpPrincipal.addTab("Clientes", jspClientes);

        jspMantenimiento.setName("jspMantenimiento"); // NOI18N

        jpMantenimiento.setName("jpMantenimiento"); // NOI18N

        jpMantenimiento2.setName("jpMantenimiento2"); // NOI18N

        jtpGeneralesDireccionContactos.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true)));
        jtpGeneralesDireccionContactos.setToolTipText("");
        jtpGeneralesDireccionContactos.setName("jtpGeneralesDireccionContactos"); // NOI18N
        jtpGeneralesDireccionContactos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpGeneralesDireccionContactosKeyPressed(evt);
            }
        });

        jpGenerales.setToolTipText("Acceso con Control + 1");
        jpGenerales.setName("jpGenerales"); // NOI18N

        jcbSexo.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        jcbSexo.setName("jcbSexo"); // NOI18N
        jcbSexo.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbSexoPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
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
                .addContainerGap(153, Short.MAX_VALUE))
        );

        jpGeneralesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jcbEstadoCivil, jcbPersona, jcbSexo});

        jtpGeneralesDireccionContactos.addTab("Generales", jpGenerales);

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

        btnBorrarDirrecion.setEnabled(false);
        btnBorrarDirrecion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBorrarDirrecion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrarDirrecion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarDirrecion.setName("btnBorrarDirrecion"); // NOI18N
        btnBorrarDirrecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarDirrecionActionPerformed(evt);
            }
        });
        jPanel7.add(btnBorrarDirrecion);

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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Provincia", "Municipio", "Distrito Municipal", "Calle y No. Casa", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jtpGeneralesDireccionContactos.addTab("Dirección", jpDireccion);

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

        btnBorrarTelefono.setEnabled(false);
        btnBorrarTelefono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTelefono.setName("btnBorrarTelefono"); // NOI18N
        btnBorrarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTelefonoActionPerformed(evt);
            }
        });

        btnEditarTelefono.setEnabled(false);
        btnEditarTelefono.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarTelefono.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTelefonoActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        btnGMovilTelefono.add(jrbResidencial);
        jrbResidencial.setText("Telefono");
        jrbResidencial.setName("jrbTelefonoResidencial"); // NOI18N
        jPanel1.add(jrbResidencial);

        btnGMovilTelefono.add(jrbMovil);
        jrbMovil.setSelected(true);
        jrbMovil.setText("Movil");
        jrbMovil.setName("jrbMovil"); // NOI18N
        jPanel1.add(jrbMovil);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(txtTelelfonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTelelfonoMovil)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAgregarTelefonoMovil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBorrarTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        tblTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Tipo", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTelefonos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTelefonos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTelefonosMouseClicked(evt);
            }
        });
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
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnBorrarCorreo.setEnabled(false);
        btnBorrarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarCorreo.setName("btnBorrarCorreo"); // NOI18N
        btnBorrarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarCorreoActionPerformed(evt);
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

        btnEditarCorreo.setEnabled(false);
        btnEditarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnEditarCorreo.setName("btnAgregarDirecciones"); // NOI18N
        btnEditarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCorreoActionPerformed(evt);
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
                .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo)
                    .addComponent(btnBorrarCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAgregarCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(btnEditarCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblCorreos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", null, null}
            },
            new String [] {
                "Correo", "Fecha", "Estado", "Por defecto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCorreos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCorreos.setFont(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontHead(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowHover(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.setFontRowSelect(new java.awt.Font("FreeMono", 1, 14)); // NOI18N
        tblCorreos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCorreosMouseClicked(evt);
            }
        });
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
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

        jtpGeneralesDireccionContactos.addTab("Contactos", jpContactos);

        jlFechaCreacion.setText("Fecha de creacion: ");
        jlFechaCreacion.setName("jlFechaCreacion"); // NOI18N

        javax.swing.GroupLayout jpMantenimiento2Layout = new javax.swing.GroupLayout(jpMantenimiento2);
        jpMantenimiento2.setLayout(jpMantenimiento2Layout);
        jpMantenimiento2Layout.setHorizontalGroup(
            jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimiento2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtpGeneralesDireccionContactos)
                    .addComponent(jlFechaCreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantenimiento2Layout.setVerticalGroup(
            jpMantenimiento2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantenimiento2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlFechaCreacion)
                .addGap(0, 0, 0)
                .addComponent(jtpGeneralesDireccionContactos)
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

        btnNuevoCliente.setText("Nuevo");
        btnNuevoCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevoCliente.setName("btnNuevoCliente"); // NOI18N
        btnNuevoCliente.setRound(40);
        btnNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoClienteActionPerformed(evt);
            }
        });
        jpBotones2.add(btnNuevoCliente);

        btnEditarCliente.setText("Modificar");
        btnEditarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnEditarCliente.setName("btnEditarCliente"); // NOI18N
        btnEditarCliente.setRound(40);
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jpBotones2.add(btnEditarCliente);

        btnBorrarCliente.setText("Borrar");
        btnBorrarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarCliente.setName("btnBorrarCliente"); // NOI18N
        btnBorrarCliente.setRound(40);
        btnBorrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarClienteActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBorrarCliente);

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
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addComponent(jtpPrincipal))
                .addContainerGap())
        );
        jpGeneralLayout.setVerticalGroup(
            jpGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
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
                .addComponent(jspGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jspGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoClienteActionPerformed
        v_nuevo = true;//Se va a ingresar un nuevo registro al sistema
        idCliente = -1;
        cambioBoton(true);
        limpiarTablasDirTelCorr();
    }//GEN-LAST:event_btnNuevoClienteActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
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
        mostrarRegistro();
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnBorrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarClienteActionPerformed
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
        Resultado resultados = borrarCliente(
                ((Generales) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona()
        );

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );


    }//GEN-LAST:event_btnBorrarClienteActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        txtCedula1.setValue(null);
        //Utilidades.showTooltip(txtCedula1);
        JOptionPane.showInternalMessageDialog(
                this,
                txtCedula1,
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        if (validarCampo(txtCedula1)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Error en el campo de la cedula, Vuelva a digitarla de nuevo",
                    "",
                    JOptionPane.ERROR_MESSAGE
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


    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validamos el campo de la cedula de la persona.
        if (validarCampo(txtCedula)) {
            //Mostramos un mensaje de error si la cedula no cumple el patron 
            //de una cedula.
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Error en el campo de la cedula, Vuelva a digitarla de nuevo",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Validamos que la cedula sea valida
        if (!M_Generales.cedula(txtCedula.getValue().toString())) {
            //En caso de que no sea valida, lanzamos advertencia.
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Cedula no pasa la prueba de validación.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );

            //si la respuesta de la opcion es no, entonces.
            if (resp == JOptionPane.NO_OPTION) {
                //Nos movemos al jtp que contiene el campo de la cedula. 
                jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

                //Hacemos focos en este campo.
                txtCedula.requestFocusInWindow();

                //Seleccionamos de la posicion inicial
                txtCedula.setSelectionStart(0);

                //Hasta el final del campo.
                txtCedula.setSelectionEnd(
                        txtCedula.getValue().toString().length()
                );

                //Nos devolvemos.
                return;
            }
        }

        //Validamos que el primer campo no este vacio.
        if (txtPNombre.getText().isBlank()) {
            //En caso que este vacio, notificamos al usuario.
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un nombre...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            //Seleccionamos el componente jtp que contiene el campo
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

            //Obtenemos focos. 
            txtPNombre.requestFocusInWindow();

            //Nos devolvemos.
            return;
        }

        //Validamos el apellido del cliente.
        if (txtApellidos.getText().isBlank()) {
            //En caso que este vacio, notificamos al usuario.
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar un apellido...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            //Seleccionamos el componente jtp que contiene el campo
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

            //Obtenemos focos. 
            txtApellidos.requestFocusInWindow();

            //Nos devolvemos.
            return;
        }

        if (Objects.isNull(dchFechaNacimiento.getDate())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe indicar una fecha de nacimiento.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Fecha de nacimiento incorrecta!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }//Validacion 4

        if (tblDireccion.getRowCount() < 1) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    
                    Cliente no cuenta con una dirrecion.
                    Desea agregar una direccion?
                    
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );
            if (resp == JOptionPane.YES_OPTION) {
                jtpGeneralesDireccionContactos.setSelectedComponent(jpDireccion);
                txtDireccion.requestFocusInWindow();
                return;
            }
        }//Validacion 5

        if (tblCorreos.getRowCount() < 1 & tblTelefonos.getRowCount() < 1) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    
                    No existe forma de contactar al cliente.
                    Desea agreguar un numero de telefono o correo electronico?
                    
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null
            );

            if (resp == JOptionPane.YES_OPTION) {
                jtpGeneralesDireccionContactos.setSelectedComponent(jpContactos);
                jtpContactos.setSelectedComponent(jpTelefonos);
                return;
            }

        }//Validacion 6

        //Buscar la cedula en la base de datos.
        Generales cedula = M_Generales.getEntidadByCedula(txtCedula.getValue().toString());

        idCliente = -1;

        //Condicional para saber si no esta vacia la lista. 
        if (cedula.getId_persona() > 0) {
            //Cliente existe en la base de datos. 
            idCliente = cedula.getId_persona(); //Validacion 8
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

                if (resp == JOptionPane.YES_OPTION) {
                    mostrarRegistro();
                    v_nuevo = false;
                }
                return;
            }
        } else {
            idCliente = ((Generales) tblClientes.getValueAt(
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

        Persona persona
                = Persona
                        .builder()
                        .id_persona(idCliente)
                        .persona(((TipoPersona) jcbPersona.getSelectedItem()).getAbreviatura())
                        .sexo(((Sexo) jcbSexo.getSelectedItem()).getAbreviatura())
                        .pnombre(txtPNombre.getText())
                        .snombre(txtSNombre.getText())
                        .apellidos(txtApellidos.getText())
                        .fecha_nacimiento(
                                new java.sql.Date(
                                        dchFechaNacimiento.getDate().getTime()
                                )
                        )
                        .estado(cbEstado.isSelected())
                        .build();

        Resultado resultados = (v_nuevo ? M_Persona.agregarEntidad(persona) : M_Persona.modificarEntidad(persona));

        if (!resultados.getEstado()) {
            mensajeResultado(
                    resultados,
                    false
            );
            return;
        }

        idCliente = resultados.getId();

        if (v_nuevo && resultados.getEstado()) {
            mensajeResultado(
                    agregarClienteById(idCliente),
                    false
            );

            mensajeResultado(
                    M_Generales.agregarEntidad(
                            Generales
                                    .builder()
                                    .id_persona(idCliente)
                                    .cedula(txtCedula.getValue().toString())
                                    .estado_civil(
                                            ((EstadoCivil) jcbEstadoCivil.getSelectedItem())
                                                    .getAbreviatura()
                                    )
                                    .id_tipo_sangre(0)
                                    .build()
                    ),
                    false
            );

            v_direccionesList.stream().forEach(
                    direccion -> {
                        mensajeResultado(
                                M_Direccion.agregarDireccion(
                                        Direccion
                                                .builder()
                                                .id_persona(idCliente)
                                                .provincia(direccion.getProvincia())
                                                .municipio(direccion.getMunicipio())
                                                .distrito_municipal(direccion.getDistrito_municipal())
                                                .codigo_postal(direccion.getCodigo_postal())
                                                .direccion(direccion.getDireccion())
                                                .por_defecto(direccion.getPor_defecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );

            v_contactosTelsList.stream().forEach(
                    contacto -> {
                        mensajeResultado(
                                M_ContactoTel.agregarContactosTel(
                                        ContactoTel
                                                .builder()
                                                .id_persona(idCliente)
                                                .telefono(contacto.getTelefono())
                                                .tipo(contacto.getTipo())
                                                .por_defecto(contacto.getPor_defecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );

            v_contactosCorreosList.stream().forEach(
                    contacto -> {
                        mensajeResultado(
                                M_ContactoEmail.agregarContactosEmail(
                                        ContactoEmail
                                                .builder()
                                                .id_persona(idCliente)
                                                .email(contacto.getEmail())
                                                .por_defecto(contacto.getPor_defecto())
                                                .build()
                                ),
                                false
                        );
                    }
            );
        }

        JOptionPane.showInternalMessageDialog(
                this,
                resultados,
                "",
                resultados.getIcono()
        );

        if (resultados.getEstado()) {
            btnCancelarActionPerformed(evt);
            limpiarListas();
            v_nuevo = null;
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
        limpiarListas();
        limpiarTablasDirTelCorr();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnHistorialClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialClientesActionPerformed
        if (v_miDetalle == null) {
            v_miDetalle = new frmDetalleFacturaClientes();
        }

        frmPrincipal.abrirFormulario(v_miDetalle);
    }//GEN-LAST:event_btnHistorialClientesActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        btnCedulaValidad.requestFocusInWindow();
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
                        validarCampo(txtCedula);
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void jcbPersonaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbPersonaPopupMenuWillBecomeInvisible
        dchFechaNacimiento.requestFocusInWindow();
        v_editor.requestFocusInWindow();
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
        jcbPersona.requestFocusInWindow();
        jcbPersona.showPopup();

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

        //preguntamos si es la direccion por defecto.
        Boolean por_defecto = true;
        if (tblDireccion.getRowCount() > 0) {
            //Se pregunta si la direccion es por defecto.
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                        Es la dirección por defecto del cliente?
                    """,
                    """
                    """,
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            por_defecto = resp == JOptionPane.YES_OPTION;
        }

        //Se preparan la provincia, municipio y el distrito municipal.
        Provincia provincia = (Provincia) jcbProvincias.getSelectedItem();
        Municipio municipio = (Municipio) jcbMunicipios.getSelectedItem();
        Distrito_municipal distritoMunicipal
                = (Distrito_municipal) jcbDistritoMunicipal.getSelectedItem();

        Integer id_direccion = -1;

        if (!v_nuevo && tblDireccion.getSelectedRow() >= 0) {
            id_direccion = ((Direccion) tblDireccion.getValueAt(
                    tblDireccion.getSelectedRow(),
                    3
            )).getId();
        }

        Direccion direccion = Direccion
                .builder()
                .id(id_direccion)
                .id_persona(idCliente)
                .provincia(provincia)
                .municipio(municipio)
                .distrito_municipal(distritoMunicipal)
                .direccion(txtDireccion.getText())
                .estado(Boolean.TRUE)
                .por_defecto(por_defecto)
                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .build();

        if (v_nuevo) {
            if (por_defecto) {
                v_direccionesList = v_direccionesList.stream().map(
                        dir -> {
                            return Direccion
                                    .builder()
                                    .id(dir.getId())
                                    .id_persona(dir.getId_persona())
                                    .provincia(dir.getProvincia())
                                    .municipio(dir.getMunicipio())
                                    .distrito_municipal(dir.getDistrito_municipal())
                                    .direccion(dir.getDireccion())
                                    .estado(dir.getEstado())
                                    .por_defecto(Boolean.FALSE)
                                    .fecha(new java.sql.Date(
                                            Calendar.getInstance().getTimeInMillis())
                                    )
                                    .build();
                        }
                ).collect(Collectors.toList());
            }

            v_direccionesList.add(direccion);

            limpiarTablaDireccion();

            registro = new Object[TITULOS_DIRECCION.length];

            v_direccionesList.stream().forEach(
                    dir -> {
                        registro[0] = dir.getProvincia();
                        registro[1] = dir.getMunicipio();
                        registro[2] = dir.getDistrito_municipal();
                        registro[3] = dir.getDireccion();
                        registro[4] = dir.getFecha();
                        registro[5] = dir.getEstado();
                        registro[6] = dir.getPor_defecto();

                        //Se agrega el nuevo registro al modelo.
                        v_dtmDireccion.addRow(registro);
                    }
            );
            tblDireccion.setModel(v_dtmDireccion);
        } else {
            agregarDireccion(direccion);
        }

        LimpiarComboBoxProMuniDistr();


    }//GEN-LAST:event_btnAgregarDireccionesActionPerformed

    private void btnBorrarDirrecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarDirrecionActionPerformed
        eliminarRegistroTabla(tblDireccion, v_dtmDireccion, v_direccionesList);

        btnDireccionEnable(false);

        LimpiarComboBoxProMuniDistr();
    }//GEN-LAST:event_btnBorrarDirrecionActionPerformed

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
        if (validarCampo(txtTelelfonoMovil)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarTxtTelefonoMovil();
            return;
        }

        //Esta validacion deberia de ser si el cliente en nacional
        if (!telefono(txtTelelfonoMovil.getValue().toString())) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar numero telefonico valido!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            limpiarTxtTelefonoMovil();
            return;
        }
        Boolean por_defecto = true;
        if (tblTelefonos.getRowCount() > 0) {
            //Se pregunta si la direccion es por defecto.
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Es el telefono por defecto del cliente?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            por_defecto = resp == JOptionPane.YES_OPTION;
        }

        Integer id_telefono = -1;

        if (!v_nuevo && tblTelefonos.getSelectedRow() >= 0) {
            id_telefono = ((Direccion) tblTelefonos.getValueAt(
                    tblTelefonos.getSelectedRow(),
                    0)).getId();
        }

        ContactoTel contactoTel = ContactoTel
                .builder()
                .id(id_telefono)
                .id_persona(idCliente)
                .telefono(txtTelelfonoMovil.getValue().toString())
                .tipo((jrbMovil.isSelected() ? "Movil" : "Telefono"))
                .fecha(new java.sql.Date(Calendar.getInstance().getTimeInMillis()))
                .estado(Boolean.TRUE)
                .por_defecto(por_defecto)
                .build();

        if (v_nuevo) {
            if (por_defecto) {
                v_contactosTelsList = v_contactosTelsList
                        .stream()
                        .map(tel -> {
                            return ContactoTel
                                    .builder()
                                    .id(tel.getId())
                                    .id_persona(tel.getId_persona())
                                    .telefono(tel.getTelefono())
                                    .tipo(tel.getTipo())
                                    .fecha(tel.getFecha())
                                    .estado(tel.getEstado())
                                    .por_defecto(Boolean.FALSE)
                                    .build();
                        })
                        .collect(Collectors.toList());
            }

            v_contactosTelsList.add(
                    contactoTel
            );

            limpiarTablaTelefono();
            registro = new Object[TITULOS_TELEFONO.length];
            v_contactosTelsList.stream().forEach(telef -> {
                registro[0] = telef.getTelefono();
                registro[1] = telef.getTipo();
                registro[2] = telef.getFecha();
                registro[3] = telef.getEstado();
                registro[4] = telef.getPor_defecto();
                v_dtmTelefono.addRow(registro);
            });
            tblTelefonos.setModel(v_dtmTelefono);
        } else {
            agregarContactosTel(contactoTel);
        }

        limpiarTxtTelefonoMovil();


    }//GEN-LAST:event_btnAgregarTelefonoMovilActionPerformed

    private void limpiarTxtTelefonoMovil() {
        txtTelelfonoMovil.setValue("");
        txtTelelfonoMovil.requestFocusInWindow();
        jrbMovil.setSelected(true);
    }

    private void btnBorrarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTelefonoActionPerformed

        if (v_nuevo) {

        } else {

        }

        eliminarRegistroTabla(tblTelefonos, v_dtmTelefono, v_contactosTelsList);

        btnBorrarTelefono.setEnabled(false);
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnBorrarTelefonoActionPerformed

    private void btnAgregarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCorreoActionPerformed
        //Validamos que el correo no esté vacio.
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

        //Verificamos que sea un correo valido.
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
        Boolean por_defecto = true;
        if (tblCorreos.getRowCount() > 0) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                        Es el correo por defecto del cliente?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
            por_defecto = resp == JOptionPane.YES_OPTION;
        }

        Integer id_correo = -1;

        if (!v_nuevo && tblCorreos.getSelectedRow() >= 0) {
            id_correo = ((ContactoEmail) tblCorreos.getValueAt(
                    tblCorreos.getSelectedRow(), 0
            )).getId();
        }

        ContactoEmail contactoEmail
                = ContactoEmail
                        .builder()
                        .id(id_correo)
                        .id_persona(idCliente)
                        .email(txtCorreo.getText())
                        .estado(Boolean.TRUE)
                        .fecha(
                                new java.sql.Date(
                                        Calendar.getInstance().getTimeInMillis()
                                )
                        )
                        .por_defecto(por_defecto)
                        .build();

        if (v_nuevo) {
            if (por_defecto) {
                v_contactosCorreosList = v_contactosCorreosList
                        .stream()
                        .map(correo -> {
                            return ContactoEmail
                                    .builder()
                                    .id(correo.getId())
                                    .id_persona(correo.getId_persona())
                                    .email(correo.getEmail())
                                    .fecha(correo.getFecha())
                                    .estado(correo.getEstado())
                                    .por_defecto(Boolean.FALSE)
                                    .build();
                        })
                        .collect(Collectors.toList());
            }

            limpiarTablaCorreo();

            v_contactosCorreosList.add(contactoEmail);

            registro = new Object[TITULOS_CORREO.length];

            v_contactosCorreosList.stream().forEach(correo -> {
                registro[0] = correo.getEmail();
                registro[1] = correo.getFecha();
                registro[2] = correo.getEstado();
                registro[3] = correo.getPor_defecto();
                v_dtmCorreo.addRow(registro);
            });

            tblCorreos.setModel(v_dtmCorreo);
        } else {
            agregarContactosEmail(contactoEmail);
        }

        txtCorreo.setText("");
        txtCorreo.requestFocusInWindow();
    }//GEN-LAST:event_btnAgregarCorreoActionPerformed

    private void btnBorrarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarCorreoActionPerformed

        if (v_nuevo) {

        } else {

        }

        eliminarRegistroTabla(tblCorreos, v_dtmCorreo, v_contactosCorreosList);
        btnCorreoEnable(false);

    }//GEN-LAST:event_btnBorrarCorreoActionPerformed

    private void btnCedulaValidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedulaValidadActionPerformed
        if (txtCedula.getValue().toString().equals("000-0000000-0")) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    """
                    Cedula GENERICA del sistema.
                    Modifique la cedula del cliente.
                    """,
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocusInWindow();
            return;
        }

        if (validarCampo(txtCedula)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Error en el campo de la cedula, Vuelva a digitarla de nuevo",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue(null);
            txtCedula.requestFocusInWindow();
            return;
        }

        Generales cedula = M_Generales.getEntidadByCedula(
                txtCedula.getValue().toString()
        );

        if (cedula.getId_persona() < 0) {

            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cedula valida, puede continuar.",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
            txtPNombre.requestFocusInWindow();
        } else {
            idCliente = cedula.getId_persona();

            if (v_nuevo) {
                if (idCliente > 0 && !M_Persona.getEntidad(idCliente).getEstado()) {
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
                    Resultado resultado = agregarClienteById(idCliente);

                    //!resultado.getEstado();
                    JOptionPane.showInternalMessageDialog(
                            this,
                            resultado.getMensaje(),
                            "",
                            resultado.getIcono()
                    );
                } else {
                    JOptionPane.showInternalMessageDialog(
                            this,
                            "Este usuario esta registrado y activo.",
                            "Id Cliente: ".concat(idCliente.toString()),
                            JOptionPane.INFORMATION_MESSAGE,
                            null
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
        btnNuevoCliente.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_PERSONA")
                                .nombre_campo("^")
                                .build()
                )
                && privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_PERSONA_CLIENTE")
                                .nombre_campo("^")
                                .build()
                )
        );

        //Permiso para el boton de Borrar
        btnBorrarCliente.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_D_PERSONA_CLIENTE")
                                .nombre_campo("^")
                                .build()
                )
        );

        //Permiso para el boton de Modificar
        btnEditarCliente.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_U_PERSONA")
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

//        int idRegistro = ((Direccion) tblDireccion.getValueAt(
//                tblDireccion.getSelectedRow(), 3)).getId();
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

        btnDireccionEnable(false);

    }//GEN-LAST:event_btnEditarDireccionActionPerformed

    private void jtpGeneralesDireccionContactosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpGeneralesDireccionContactosKeyPressed
        if (evt.isControlDown()) {
            if (evt.getKeyCode() == KeyEvent.VK_1) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpGenerales)
                );
            }
            if (evt.getKeyCode() == KeyEvent.VK_2) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpDireccion)
                );
            }
            if (evt.getKeyCode() == KeyEvent.VK_3) {
                jtpGeneralesDireccionContactos.setSelectedIndex(
                        jtpGeneralesDireccionContactos.indexOfComponent(jpContactos)
                );
            }
        }
    }//GEN-LAST:event_jtpGeneralesDireccionContactosKeyPressed

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
        btnDireccionEnable(true);
    }//GEN-LAST:event_tblDireccionMouseClicked

    private void btnEditarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTelefonoActionPerformed
        btnTelefonoEnable(false);
    }//GEN-LAST:event_btnEditarTelefonoActionPerformed

    private void btnEditarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCorreoActionPerformed
        btnCorreoEnable(false);
    }//GEN-LAST:event_btnEditarCorreoActionPerformed

    private void tblTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTelefonosMouseClicked
        btnTelefonoEnable(true);
    }//GEN-LAST:event_tblTelefonosMouseClicked

    private void tblCorreosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCorreosMouseClicked
        btnCorreoEnable(true);
    }//GEN-LAST:event_tblCorreosMouseClicked

    private void jcbSexoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbSexoPopupMenuWillBecomeInvisible
        if (jcbSexo.getSelectedIndex() > 0) {
            jtpGeneralesDireccionContactos.setSelectedIndex(
                    jtpGeneralesDireccionContactos.indexOfComponent(jpDireccion)
            );
        }
    }//GEN-LAST:event_jcbSexoPopupMenuWillBecomeInvisible

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
        if (((Generales) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0)).getId_persona() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Cliente GENERICO no puede ser %s".formatted(accion),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Devolvermos falso para que continue.
        return false;
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
        jtpGeneralesDireccionContactos.setSelectedComponent(jpGenerales);

        /*
            Si el valor de activo es true, quiere decir que se va a insertar o 
        modificar un registro. Por ende, los botones nuevo, modificar, borrar y 
        buscar se deshabilitan.
        
            En caso contrario si el valor de activo es falso, los botones nuevo,
        modificar, borrar y buscar se habilitan.
         */
        btnNuevoCliente.setEnabled(!activo);
        btnEditarCliente.setEnabled(!activo);
        btnBorrarCliente.setEnabled(!activo);
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

        LimpiarComboBoxProMuniDistr();

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
     */
    private void limpiarTablasDirTelCorr() {
        limpiarTablaDireccion();
        limpiarTablaTelefono();
        limpiarTablaCorreo();
    }

    private static void limpiarTablaCorreo() {
        v_dtmCorreo = new DefaultTableModel(null, TITULOS_CORREO);
        tblCorreos.setModel(v_dtmCorreo);
        repararColumnaTable(tblCorreos);
        columnasCheckBox(tblCorreos, new int[]{2, 3});
    }

    private static void limpiarTablaDireccion() {
        v_dtmDireccion = new DefaultTableModel(null, TITULOS_DIRECCION);
        tblDireccion.setModel(v_dtmDireccion);
        repararColumnaTable(tblDireccion);
        columnasCheckBox(tblDireccion, new int[]{5, 6});
    }

    private static void limpiarTablaTelefono() {
        v_dtmTelefono = new DefaultTableModel(null, TITULOS_TELEFONO);
        tblTelefonos.setModel(v_dtmTelefono);
        repararColumnaTable(tblTelefonos);
        columnasCheckBox(tblTelefonos, new int[]{3, 4});
    }

    private void limpiarListas() {
        v_direccionesList.clear();
        v_contactosTelsList.clear();
        v_contactosCorreosList.clear();
    }

    private void btnCorreoEnable(boolean valor) {
        btnEditarCorreo.setEnabled(valor);
        btnBorrarCorreo.setEnabled(valor);
        txtCorreo.requestFocusInWindow();
    }

    private void btnTelefonoEnable(boolean valor) {
        btnEditarTelefono.setEnabled(valor);
        btnBorrarTelefono.setEnabled(valor);
        txtTelelfonoMovil.requestFocusInWindow();
    }

    private void LimpiarComboBoxProMuniDistr() {
        jcbProvincias.setSelectedIndex(0);
        jcbMunicipios.setSelectedIndex(0);
        jcbDistritoMunicipal.setSelectedIndex(0);

        jcbMunicipios.removeAllItems();
        jcbDistritoMunicipal.removeAllItems();

        //Deshabilitamos los dos jcb por defecto.
        jcbMunicipios.setEnabled(false);
        jcbDistritoMunicipal.setEnabled(false);

        //Limpiamos el campo de la direccion.
        txtDireccion.setText("");
        txtDireccion.requestFocusInWindow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnActualizarRegistrosCliente;
    @Getter
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    @Getter
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarDirecciones;
    @Getter
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarDirrecion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefono;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    @Getter
    private RSMaterialComponent.RSButtonMaterialIconOne btnCedulaValidad;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarCliente;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarDireccion;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEditarTelefono;
    private javax.swing.ButtonGroup btnGMovilTelefono;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorialClientes;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme1;
    @Getter
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevoCliente;
    private javax.swing.JCheckBox cbEstado;
    @Getter
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
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
    @Getter
    private RSMaterialComponent.RSComboBox jcbDistritoMunicipal;
    @Getter
    private javax.swing.JComboBox jcbEstadoCivil;
    @Getter
    private RSMaterialComponent.RSComboBox jcbMunicipios;
    @Getter
    private javax.swing.JComboBox jcbPersona;
    @Getter
    private RSMaterialComponent.RSComboBox jcbProvincias;
    @Getter
    private javax.swing.JComboBox jcbSexo;
    private javax.swing.JLabel jlFechaCreacion;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpBotones2;
    @Getter
    private javax.swing.JPanel jpClientes;
    @Getter
    private javax.swing.JPanel jpContactos;
    @Getter
    private javax.swing.JPanel jpCorreos;
    @Getter
    private javax.swing.JPanel jpDireccion;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JPanel jpGenerales;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpMantenimiento2;
    private javax.swing.JPanel jpTelefonos;
    @Getter
    private javax.swing.JRadioButton jrbMovil;
    @Getter
    private javax.swing.JRadioButton jrbResidencial;
    private static javax.swing.JSpinner jsCantidadFilas;
    private static javax.swing.JSpinner jsPaginaNro;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JScrollPane jspGeneral;
    private javax.swing.JScrollPane jspMantenimiento;
    @Getter
    private javax.swing.JTabbedPane jtpContactos;
    @Getter
    private javax.swing.JTabbedPane jtpGeneralesDireccionContactos;
    @Getter
    public static javax.swing.JTabbedPane jtpPrincipal;
    private static rojerusan.RSTableMetro1 tblClientes;
    private static rojerusan.RSTableMetro1 tblCorreos;
    private static rojerusan.RSTableMetro1 tblDireccion;
    private static rojerusan.RSTableMetro1 tblTelefonos;
    @Getter
    private javax.swing.JTextField txtApellidos;
    @Getter
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JFormattedTextField txtCedula1;
    @Getter
    private javax.swing.JTextField txtCorreo;
    @Getter
    private javax.swing.JTextField txtDireccion;
    @Getter
    private javax.swing.JTextField txtPNombre;
    @Getter
    private javax.swing.JTextField txtSNombre;
    @Getter
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables

    /**
     * Es el metodo encargado de llenar el formulario del cliente cuando este se
     * va a modificar en la base de datos.<br>
     *
     * El mismo idCliente es utilizado para obtener la lista de direcciones,
     * lista de correo y lista de telefonos del cliente.<br\>
     */
    private void mostrarRegistro() {
        if (Objects.isNull(idCliente) || idCliente < 0) {
            idCliente = frmClientes.idCliente;
        }

        Cliente persona = M_Cliente.getPersonaCliente(
                FiltroBusqueda
                        .builder()
                        .id(idCliente)
                        .build()
        );

        txtPNombre.setText(persona.getPnombre());
        txtSNombre.setText(persona.getSnombre());
        txtApellidos.setText(persona.getApellidos());
        dchFechaNacimiento.setDate(
                sqlDateToUtilDate(
                        persona.getFecha_nacimiento()
                )
        );
        cbEstado.setSelected(persona.getEstado());
        cbEstado.setText(
                persona.getEstado() ? "Activo" : "Inactivo"
        );
        jlFechaCreacion.setText(
                "Fecha de Ingreso: ".concat(
                        persona.getFecha_ingreso().toString()
                )
        );

        //------BUSCAR TIPO DE PERSONA------------------------------------------
        for (int i = 0; i < jcbPersona.getItemCount(); i++) {
            if (persona.getPersona().equals(
                    ((TipoPersona) jcbPersona.getItemAt(i)).getAbreviatura()
            )) {
                jcbPersona.setSelectedIndex(i);
                break;
            }
        }

        //-----BUSCAR SEXO------------------------------------------------------
        for (int i = 0; i < jcbSexo.getItemCount(); i++) {
            if (persona.getSexo().equals(
                    ((Sexo) jcbSexo.getItemAt(i)).getAbreviatura()
            )) {
                jcbSexo.setSelectedIndex(i);
                break;
            }
        }

        //-----GENERALES--------------------------------------------------------
        Generales general = M_Generales.getEntidad(idCliente);

        txtCedula.setValue(general);

        for (int i = 0; i < jcbEstadoCivil.getItemCount(); i++) {
            if (general.getEstado_civil().equals(
                    ((EstadoCivil) jcbEstadoCivil.getItemAt(i)).getAbreviatura()
            )) {
                jcbEstadoCivil.setSelectedIndex(i);
                break;
            }
        }
        //----------------------------------------------------------------------

        limpiarListas();

        llenarTablaDirreciones(idCliente);
        llenarTablaTelefonos(idCliente);
        llenarTablaCorreos(idCliente);
    }

    /**
     * Metodo utilizado para llenar la tabla de cliente del sistema. Nota: Este
     * evento Debe ser publico porque este es llamado desde los eventos de
     * Firebird.
     *
     * @param id
     * @param criterioBusqueda
     *
     */
    public synchronized static void llenarTablaClientes(int id,
            String criterioBusqueda) {

        if (Objects.isNull(criterioBusqueda)) {
            criterioBusqueda = "";
        }

        if (criterioBusqueda.isBlank()) {
            criterioBusqueda = frmClientes.criterioBusqueda;
        }

        registro = new Object[TITULOS_CLIENTE.length];

        DefaultTableModel dtmClientes = new DefaultTableModel(null, TITULOS_CLIENTE);

        //TODO settear el filtro al siguiente metodo.
        M_Cliente.getPersonasClientes(null).stream().forEach(
                cliente -> {
                    registro[0] = cliente.getGenerales();
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

        tblClientes.removeAll();
        tblClientes.setModel(dtmClientes);
        tblClientes.setBackgoundHover(new java.awt.Color(102, 102, 255));
    }

    public static synchronized JTable llenarTablaCorreos(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        registro = new Object[TITULOS_CORREO.length];
        limpiarTablaCorreo();
        getCorreoByID(idCliente).stream().forEach(
                p_correo -> {
                    registro[0] = p_correo;
                    registro[1] = p_correo.getFecha();
                    registro[2] = p_correo.getEstado();
                    registro[3] = p_correo.getPor_defecto();

                    v_contactosCorreosList.add(p_correo);

                    v_dtmCorreo.addRow(registro);
                }
        );
        tblCorreos.setModel(v_dtmCorreo);
        return tblCorreos;
    }

    public static synchronized JTable llenarTablaTelefonos(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        registro = new Object[TITULOS_TELEFONO.length];
        limpiarTablaTelefono();
        getTelefonoByID(idCliente).stream().forEach(p_telefono -> {
            registro[0] = p_telefono;
            registro[1] = p_telefono.getTipo();
            registro[2] = p_telefono.getFecha();
            registro[3] = p_telefono.getEstado();
            registro[4] = p_telefono.getPor_defecto();

            v_contactosTelsList.add(p_telefono);

            v_dtmTelefono.addRow(registro);
        }
        );
        tblTelefonos.setModel(v_dtmTelefono);
        return tblTelefonos;
    }

    public static synchronized JTable llenarTablaDirreciones(Integer idCliente) {
        if (Objects.isNull(idCliente)) {
            idCliente = frmClientes.idCliente;
        }
        registro = new Object[TITULOS_DIRECCION.length];
        limpiarTablaDireccion();
        getDireccionByID(idCliente).stream().forEach(
                p_direccione -> {
                    registro[0] = p_direccione.getProvincia();
                    registro[1] = p_direccione.getMunicipio();
                    registro[2] = p_direccione.getDistrito_municipal();
                    registro[3] = Direccion
                            .builder()
                            .id(p_direccione.getId())
                            .id_persona(p_direccione.getId_persona())
                            .direccion(p_direccione.getDireccion())
                            .build();
                    registro[4] = p_direccione.getFecha();
                    registro[5] = p_direccione.getEstado();
                    registro[6] = p_direccione.getPor_defecto();
                    v_direccionesList.add(p_direccione);
                    v_dtmDireccion.addRow(registro);
                }
        );
        tblDireccion.setModel(v_dtmDireccion);
        return tblDireccion;
    }
}
