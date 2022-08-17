package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static sur.softsurena.datos.delete.DeleteMetodos.borrarCliente;
import static sur.softsurena.datos.insert.InsertMetodos.agregarCliente;
import sur.softsurena.datos.select.SelectMetodos;
import static sur.softsurena.datos.select.SelectMetodos.existeCliente;
import static sur.softsurena.datos.select.SelectMetodos.getClientes;
import static sur.softsurena.datos.update.UpdateMetodos.modificarCliente;
import sur.softsurena.entidades.Celda_CheckBox;
import sur.softsurena.entidades.Clientes;
import sur.softsurena.entidades.Direcciones;
import sur.softsurena.entidades.Distritos_municipales;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.Municipios;
import sur.softsurena.entidades.Personas;
import sur.softsurena.entidades.Provincias;
import sur.softsurena.entidades.Render_CheckBox;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.utilidades.Utilidades;

public final class frmClientes extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmClientes.class.getName());
    private boolean nuevo = false;
    private final JTextFieldDateEditor editor;
//    private final JButton button;
    private frmDetalleFacturaClientes miDetalle;

    public frmClientes() {
        initComponents();

        try {
            txtTelelfonoMovil.setFormatterFactory(
                    new javax.swing.text.DefaultFormatterFactory(
                            new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        oyenteDeComponentes();
        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();
//
//        button = dchFechaNacimiento.getCalendarButton();
//
//        editor.setEditable(false);
//        button.setEnabled(false);
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspMantenimiento), false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        jcbSexo = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jcbProvincias = new RSMaterialComponent.RSComboBox();
        jcbMunicipios = new RSMaterialComponent.RSComboBox();
        jcbDistritoMunicipal = new RSMaterialComponent.RSComboBox();
        txtDireccion = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTelefonos = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        txtTelelfonoMovil = new javax.swing.JFormattedTextField();
        btnAgregarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTelefonoMovil = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCorreos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        btnAgregarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEliminarCorreo = new RSMaterialComponent.RSButtonMaterialIconOne();
        txtCorreo = new RSMaterialComponent.RSTextFieldIconOne();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

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

        jtpUnico.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N

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
        tblClientes.setPreferredSize(null);
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.setShowGrid(false);
        tblClientes.setShowHorizontalLines(true);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
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

        btnHistorial.setText("Historial de Cliente");
        btnHistorial.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
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
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jScrollPane3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 769, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel15, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpClientesLayout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
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
        jpMantenimiento.setName("Datos2"); // NOI18N

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

        cbActivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbActivo.setSelected(true);
        cbActivo.setText("Activo");
        cbActivo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 1, true), "Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N
        cbActivo.setFocusTraversalPolicyProvider(true);
        cbActivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cbActivo.setMinimumSize(new java.awt.Dimension(0, 0));
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

        jcbEstadoCivil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Estado civil", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N

        jcbSexo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeSans", 0, 12))); // NOI18N

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jcbProvincias.setForeground(new java.awt.Color(37, 45, 223));
        jcbProvincias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingrese Provincia" }));
        jcbProvincias.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbProvincias.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbProvinciasPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jcbMunicipios.setForeground(new java.awt.Color(37, 45, 223));
        jcbMunicipios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingrese Municipio" }));
        jcbMunicipios.setColorFondo(new java.awt.Color(255, 255, 255));
        jcbMunicipios.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcbMunicipiosPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jcbDistritoMunicipal.setForeground(new java.awt.Color(37, 45, 223));
        jcbDistritoMunicipal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione distrito" }));
        jcbDistritoMunicipal.setColorFondo(new java.awt.Color(255, 255, 255));

        txtDireccion.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD_LOCATION);
        txtDireccion.setPlaceholder("Ingrese la direccion residencial");

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(txtDireccion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jcbProvincias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jcbMunicipios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jcbDistritoMunicipal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, 0))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {jcbDistritoMunicipal, jcbMunicipios, jcbProvincias}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jcbDistritoMunicipal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jcbProvincias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jcbMunicipios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Dirección", jPanel3);

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
        jScrollPane2.setViewportView(tblTelefonos);

        txtTelelfonoMovil.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Telefono o movil"));
        try {
            txtTelelfonoMovil.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+1(###) ###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnAgregarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);

        btnBorrarTelefonoMovil.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtTelelfonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 199, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAgregarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnBorrarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(451, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel8Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(txtTelelfonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAgregarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnBorrarTelefonoMovil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
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
        jScrollPane7.setViewportView(tblCorreos);

        btnAgregarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PLUS_ONE);

        btnEliminarCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);

        txtCorreo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        txtCorreo.setPlaceholder("Ingrese correo valido");

        org.jdesktop.layout.GroupLayout jPanel12Layout = new org.jdesktop.layout.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 310, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnAgregarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEliminarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 40, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel12Layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(jPanel12Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnAgregarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(btnEliminarCorreo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12Layout.linkSize(new java.awt.Component[] {btnAgregarCorreo, btnEliminarCorreo}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout jPanel11Layout = new org.jdesktop.layout.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel12, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel11Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(jScrollPane7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .add(0, 0, 0))
        );

        jTabbedPane3.addTab("Correos", jPanel11);

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jTabbedPane3)
                .add(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jTabbedPane3)
                .add(0, 0, 0))
        );

        jTabbedPane2.addTab("Contactos", jPanel5);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jTabbedPane2)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {cbActivo, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtCedula, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                    .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbActivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 52, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
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
                .add(jTabbedPane2)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {cbActivo, dchFechaNacimiento, jcbEstadoCivil, jcbPersona, jcbSexo, txtApellidos, txtCedula, txtPNombre, txtSNombre}, org.jdesktop.layout.GroupLayout.VERTICAL);

        txtCedula.getAccessibleContext().setAccessibleParent(this);
        txtPNombre.getAccessibleContext().setAccessibleParent(this);
        txtApellidos.getAccessibleContext().setAccessibleParent(this);

        org.jdesktop.layout.GroupLayout jpMantenimientoLayout = new org.jdesktop.layout.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel14.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel14.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel14.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel14.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
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
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jtpUnico)
                    .add(jPanel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jtpUnico, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel4);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane4)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane4)
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
        llenarTabla();
        reOrdenar(0);
        Direcciones.llenarProvincias(jcbProvincias);
        Personas.llenarPersona(jcbPersona);
        Personas.llenarSexo(jcbSexo);
        Personas.llenarEstadoCivil(jcbEstadoCivil);
    }//GEN-LAST:event_formInternalFrameActivated
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        jcbPersona.requestFocus();
        jcbPersona.showPopup();
    }//GEN-LAST:event_txtCedulaActionPerformed
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (!tblClientes.isEnabled()) {
            return;
        }
        mostrarRegistro();
    }//GEN-LAST:event_tblClientesMouseClicked
    private void cbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivoActionPerformed
        if (cbActivo.isSelected()) {
            cbActivo.setText("Activo");
        } else {
            cbActivo.setText("Inactivo");
        }
        btnGuardar.requestFocusInWindow();
    }//GEN-LAST:event_cbActivoActionPerformed

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
        cambioBoton(null, true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtPNombre.getText().equals("Generico")) {
            JOptionPane.showMessageDialog(this,
                    "Cliente Generico no se puede Modificar!!!");
            return;
        }
        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscar.setEnabled(false);
        tblClientes.setEnabled(false);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Texto Habilitado
        txtPNombre.setEditable(true);
        txtApellidos.setEditable(true);
        txtDireccion.setEditable(true);
//        editor.setEditable(true);
//        button.setEnabled(true);

        //Desactivamos el Flag de registro Nuevo        
        nuevo = false;

        txtPNombre.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtCedula.getText().replace(" ", "").replace("-", "").isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un ID de Cliente...");
            txtCedula.requestFocusInWindow();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un Nombre...");
            txtPNombre.requestFocusInWindow();
            return;
        }
        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un Apellido...");
            txtApellidos.requestFocusInWindow();
            return;
        }
        if (txtDireccion.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar la Direccion...");
            txtDireccion.requestFocusInWindow();
            return;
        }
        if (dchFechaNacimiento.getDate() == null) {
            JOptionPane.showMessageDialog(this,
                    "Debe Indicar Una Nueva Fecha de Nacimiento...");
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        if (dchFechaNacimiento.getDate().after(new Date())) {
            JOptionPane.showMessageDialog(this,
                    "La Fecha de Nacimiento debe ser Anterior a la Fecha Actual");
            dchFechaNacimiento.requestFocusInWindow();
            return;
        }

        // si es nuevo validamos que el Cliente no exista
        if (nuevo) {

            if (existeCliente(txtCedula.getText().replace("-", ""))) {
                JOptionPane.showMessageDialog(this, "Cliente Ya existe...");
                return;
            }

        } else if (!existeCliente(txtCedula.getText().replace("-", ""))) {

            JOptionPane.showMessageDialog(this, "Cliente NO existe...");
            txtCedula.requestFocusInWindow();
            return;

        }

        Generales g = Generales.builder().
                cedula(txtCedula.getValue().toString()).build();

        Direcciones d = Direcciones.builder().
                id_provincia(((Provincias) jcbProvincias.getSelectedItem()).getId()).
                id_municipio(((Municipios) jcbMunicipios.getSelectedItem()).getId()).
                id_distrito_municipal(((Distritos_municipales) jcbDistritoMunicipal.getSelectedItem()).getId()).
                direccion(txtDireccion.getText()).build();

        Clientes miCliente = Clientes.builder().
                generales(g).
                direccion(d).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                fecha_nacimiento(new java.sql.Date(dchFechaNacimiento.getDate().getTime())).
                estado(cbActivo.isSelected()).build();

        String msg, accion = "editar";

        if (nuevo) {
            accion = "crear";
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "<html><b><big>Se va a " + accion + " el Cliente: </big></b><big>" + txtPNombre.getText() + " " + txtApellidos.getText() + "</big></html>"
                + "\n<html><b><big>Cedula no.: </big></b><big>" + txtCedula.getText() + "</big></html>"
                + "\n<html><b><big>Direccion: </big></b><big>" + txtDireccion.getText() + "</big></html>"
                + "\n<html><b><big>Fecha Nacimiento: </big></b><big>" + Utilidades.formatDate(dchFechaNacimiento.getDate(), "dd-MM-yyyy") + "</big></html>"
                + "\n<html><b><big>Estado del Cliente: </big></b><big>" + cbActivo.getText() + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resp == 1) {
            return;
        }

        //Crear la logica para agregar los contactos de un cliente.
        if (nuevo) {
            msg = agregarCliente(miCliente, null, null).getMensaje();
        } else {
            msg = modificarCliente(miCliente, null).getMensaje();
        }

        JOptionPane.showMessageDialog(this, msg);

        //Actualizamos los cambios en la Tabla
        llenarTabla();

        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        //cancelar();
        nuevo = false;
        //mostrarRegistro();
        reOrdenar(0);
//        reOrdenar(0);
        cambioBoton(null, false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtPNombre.getText().trim().equals("Generico")) {
            JOptionPane.showMessageDialog(this, "Este Cliente no se debe de eliminar...");
            return;
        }

        int rta = JOptionPane.showConfirmDialog(this,
                "¿Esta Seguro de Eliminar Registro del Cliente?",
                "Eliminar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rta == 1) {
            return;
        }

        String msg = borrarCliente(
                ((Clientes) tblClientes.getValueAt(
                        tblClientes.getSelectedRow(), 0)).getId_persona()).getMensaje();

        if (!msg.equals("error")) {
            JOptionPane.showMessageDialog(this, msg);
        } else {
            JOptionPane.showMessageDialog(this, "Usuario con facturas Existe, "
                    + "Deberia de cambiar Estado a Cliente");
        }

        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String cliente = JOptionPane.showInputDialog("Ingrese la Cedula, Nombre o Apellido del Cliente");
        int num = tblClientes.getRowCount();
        for (int i = 0; i < num; i++) {
            if (tblClientes.getValueAt(i, 0).toString().contains(cliente)) {
                break;
            }
            if (tblClientes.getValueAt(i, 1).toString().contains(cliente)) {
                break;
            }
            if (tblClientes.getValueAt(i, 2).toString().contains(cliente)) {
                break;
            }
            if (cliente.equals("")) {
                return;
            }
            if (!existeCliente(cliente)) {
                JOptionPane.showMessageDialog(this, "El Cliente No Existe");
                break;
            }
        }
        mostrarRegistro();
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

    private void jcbProvinciasPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbProvinciasPopupMenuWillBecomeInvisible
        Direcciones.llenarMunicipios(
                ((Provincias) jcbProvincias.getSelectedItem()).getId(),
                jcbMunicipios);
    }//GEN-LAST:event_jcbProvinciasPopupMenuWillBecomeInvisible

    private void jcbMunicipiosPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcbMunicipiosPopupMenuWillBecomeInvisible
        Direcciones.llenarDistritoMunicipal(
                ((Municipios) jcbMunicipios.getSelectedItem()).getId(),
                jcbDistritoMunicipal);
    }//GEN-LAST:event_jcbMunicipiosPopupMenuWillBecomeInvisible

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

    private void llenarTabla() {
        String titulos[] = {"Cedulas", "Persona", "Primer Nombre", "Segundo Nombre",
            "Apellidos", "Fecha Ingreso", "Estado"};

        Object registro[] = new Object[titulos.length];

        try {
            ResultSet rs = getClientes();
            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                Generales g = Generales.builder().
                        cedula(rs.getString("cedula")).build();

                Clientes p = Clientes.builder().
                        id_persona(rs.getInt("id")).
                        generales(g).build();
                registro[0] = p;
                registro[1] = rs.getString("persona").equalsIgnoreCase("j") ? "Juridica" : "Fisica";
                registro[2] = rs.getString("pnombre");
                registro[3] = rs.getString("snombre");
                registro[4] = rs.getString("apellidos");
                registro[5] = Utilidades.formatDate(rs.getDate("fecha_Ingreso"), "dd/MM/yyyy");
                registro[6] = rs.getBoolean("Estado");
                miTabla.addRow(registro);
            }
            tblClientes.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        //Para Alinear el Texto de la Table a la Derecha...
//        DefaultTableCellHeaderRenderer tcr = new DefaultTableCellHeaderRenderer();
//
//        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
//        tblClientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
//        tblClientes.getColumnModel().getColumn(4).setCellRenderer(tcr);
        tblClientes.getColumnModel().getColumn(6).setCellEditor(new Celda_CheckBox());
        tblClientes.getColumnModel().getColumn(6).setCellRenderer(new Render_CheckBox());
    }

    private void mostrarRegistro() {
        if (tblClientes.getRowCount() <= 0) {
            return;
        }

        txtCedula.setText(tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0).toString());
        txtPNombre.setText(tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 1).toString());
        txtApellidos.setText(tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 2).toString());

        if (tblClientes.getValueAt(tblClientes.getSelectedRow(), 5).equals(true)) {
            cbActivo.setSelected(true);
            cbActivo.setText("Activo");
        } else {
            cbActivo.setSelected(false);
            cbActivo.setText("Inactivo");
        }
        txtDireccion.setText(
                tblClientes.getValueAt(tblClientes.getSelectedRow(), 6).toString());
        dchFechaNacimiento.setDate((Date) tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 9));

        //Mover Cursor
        tblClientes.setRowSelectionInterval(tblClientes.getSelectedRow(),
                tblClientes.getSelectedRow());
    }

    private void oyenteDeComponentes() {
//        txtCredito.addFocusListener(new java.awt.event.FocusAdapter() {
//            @Override
//            public void focusGained(java.awt.event.FocusEvent evt) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        txtCredito.setSelectionStart(3);
//                        txtCredito.setSelectionEnd(txtCredito.getText().length());
//                    }
//                });
//            }
//        });
    }

    private void reOrdenar(int colm) {
        if (tblClientes.getRowCount() == 0) {
            return;
        }
        TableColumn miTableColumn;
        for (int i = 0; i <= tblClientes.getColumnCount() - 1; i++) {
            miTableColumn = tblClientes.getColumnModel().getColumn(i);
            if (i == 0) {//Cedula
                miTableColumn.setMaxWidth(170);
                miTableColumn.setPreferredWidth(150);
                miTableColumn.setMinWidth(140);
            }

            if (i == 1) {//Persona
                miTableColumn.setMaxWidth(110);
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMinWidth(90);
            }

            if (i == 2 || i == 3) {//Primer Nombre o Segundo nombre
                miTableColumn.setMaxWidth(240);
                miTableColumn.setPreferredWidth(190);
                miTableColumn.setMinWidth(170);
            }

            if (i == 4) {//Apellidos
                miTableColumn.setMaxWidth(270);
                miTableColumn.setPreferredWidth(230);
                miTableColumn.setMinWidth(200);
            }

            if (i == 5) {//Fecha de Ingresos
                miTableColumn.setMaxWidth(180);
                miTableColumn.setPreferredWidth(150);
                miTableColumn.setMinWidth(140);
            }
            if (i == 6) {//Desde Aqui
                miTableColumn.setMaxWidth(90);
                miTableColumn.setPreferredWidth(80);
                miTableColumn.setMinWidth(70);
            }
            tblClientes.repaint();
        }
        tblClientes.setRowSelectionInterval(0, 0);
    }

    private void cambioBoton(Integer idCliente, boolean activo) {
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspMantenimiento), activo);
        jtpUnico.setEnabledAt(jtpUnico.indexOfComponent(jspClientes), !activo);
        if (activo) {
            jtpUnico.setSelectedComponent(jspMantenimiento);
        } else {
            jtpUnico.setSelectedComponent(jspClientes);
        }

        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(!activo);
        btnModificar.setEnabled(!activo);
        btnBorrar.setEnabled(!activo);
        btnBuscar.setEnabled(!activo);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(activo);
        btnCancelar.setEnabled(activo);

        //txt Vaciar
        txtPNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        dchFechaNacimiento.setDate(new Date());
        cbActivo.setSelected(activo);
        cbActivo.setText("Inactivo");

        txtCedula.grabFocus();
        txtCedula.requestFocusInWindow();

        //Activamos el Flag de registro Nuevo        
        nuevo = true;
        txtCedula.setValue(idCliente);

        if (idCliente != null) {
            txtCedula.setEditable(activo);
            txtPNombre.grabFocus();
            txtPNombre.requestFocusInWindow();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTelefonoMovil;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    public RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEliminarCorreo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnHistorial;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirInforme;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JCheckBox cbActivo;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private static RSMaterialComponent.RSComboBox jcbDistritoMunicipal;
    private javax.swing.JComboBox<String> jcbEstadoCivil;
    private static RSMaterialComponent.RSComboBox jcbMunicipios;
    private static javax.swing.JComboBox jcbPersona;
    private static RSMaterialComponent.RSComboBox jcbProvincias;
    private javax.swing.JComboBox<String> jcbSexo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JScrollPane jspClientes;
    private javax.swing.JScrollPane jspMantenimiento;
    public static javax.swing.JTabbedPane jtpUnico;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblCorreos;
    private javax.swing.JTable tblTelefonos;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private RSMaterialComponent.RSTextFieldIconOne txtCorreo;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    private javax.swing.JFormattedTextField txtTelelfonoMovil;
    // End of variables declaration//GEN-END:variables
}
