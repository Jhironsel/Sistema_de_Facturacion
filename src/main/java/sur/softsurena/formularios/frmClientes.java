package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static sur.softsurena.datos.insert.InsertMetodos.agregarCliente;
import static sur.softsurena.datos.select.SelectMetodos.existeCliente;
import static sur.softsurena.datos.select.SelectMetodos.getClientes;
import static sur.softsurena.datos.update.UpdateMetodos.modificarCliente;
import sur.softsurena.entidades.Celda_CheckBox;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Render_CheckBox;
import static sur.softsurena.formularios.frmPrincipal.dpnEscritorio;
import sur.softsurena.utilidades.Utilidades;

public final class frmClientes extends javax.swing.JInternalFrame {

    private boolean nuevo = false;
    private final JTextFieldDateEditor editor;
    private final JButton button;
    private frmDetalleFacturaClientes miDetalle;

    public frmClientes() {
        
        initComponents();
        oyenteDeComponentes();
        editor = (JTextFieldDateEditor) dchFechaNacimiento.getDateEditor();

        button = dchFechaNacimiento.getCalendarButton();

        editor.setEditable(false);
        button.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpClientes = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        chbDireccion = new javax.swing.JCheckBox();
        chbTelefono = new javax.swing.JCheckBox();
        chbCiudad = new javax.swing.JCheckBox();
        chbFechaNacimiento = new javax.swing.JCheckBox();
        chbFechaIngreso = new javax.swing.JCheckBox();
        chbSolo6 = new javax.swing.JCheckBox();
        jpMantenimiento = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtCedula = new javax.swing.JFormattedTextField();
        cbActivo = new javax.swing.JCheckBox();
        txtPNombre = new javax.swing.JTextField();
        txtSNombre = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        dchFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcbPersona = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jcbEstadoCivil = new javax.swing.JComboBox<>();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jcbProvincias = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jcbMunicipios = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jcbDistritoMunicipal = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnHistorial = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Clientes");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones de Acción"));
        jPanel2.setMaximumSize(new java.awt.Dimension(787, 81));
        jPanel2.setMinimumSize(new java.awt.Dimension(787, 81));

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.setMaximumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setMinimumSize(new java.awt.Dimension(104, 44));
        btnNuevo.setPreferredSize(new java.awt.Dimension(104, 44));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 1, 1));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setMnemonic('m');
        btnModificar.setText("Modificar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(1, 1, 1));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(1, 1, 1));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar2 32 x 32.png"))); // NOI18N
        btnBuscar.setMnemonic('r');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el Registro");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0))
        );

        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setDoubleBuffered(true);

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
        tblClientes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblClientes.setColumnSelectionAllowed(true);
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Columna ocultas"));
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0);
        flowLayout2.setAlignOnBaseline(true);
        jPanel7.setLayout(flowLayout2);

        buttonGroup1.add(chbDireccion);
        chbDireccion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbDireccion.setText("Dirección");
        chbDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbDireccionActionPerformed(evt);
            }
        });
        jPanel7.add(chbDireccion);

        buttonGroup1.add(chbTelefono);
        chbTelefono.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbTelefono.setText("Telefono");
        chbTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbTelefonoActionPerformed(evt);
            }
        });
        jPanel7.add(chbTelefono);

        buttonGroup1.add(chbCiudad);
        chbCiudad.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbCiudad.setText("Ciudad");
        chbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCiudadActionPerformed(evt);
            }
        });
        jPanel7.add(chbCiudad);

        buttonGroup1.add(chbFechaNacimiento);
        chbFechaNacimiento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbFechaNacimiento.setText("Fecha de Nacimiento");
        chbFechaNacimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbFechaNacimientoActionPerformed(evt);
            }
        });
        jPanel7.add(chbFechaNacimiento);

        buttonGroup1.add(chbFechaIngreso);
        chbFechaIngreso.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbFechaIngreso.setText("Fecha de Ingreso");
        chbFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbFechaIngresoActionPerformed(evt);
            }
        });
        jPanel7.add(chbFechaIngreso);

        buttonGroup1.add(chbSolo6);
        chbSolo6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chbSolo6.setSelected(true);
        chbSolo6.setText("Solo 6");
        chbSolo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSolo6ActionPerformed(evt);
            }
        });
        jPanel7.add(chbSolo6);

        jScrollPane1.setViewportView(jPanel7);

        org.jdesktop.layout.GroupLayout jpClientesLayout = new org.jdesktop.layout.GroupLayout(jpClientes);
        jpClientes.setLayout(jpClientesLayout);
        jpClientesLayout.setHorizontalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3)
            .add(jScrollPane1)
        );
        jpClientesLayout.setVerticalGroup(
            jpClientesLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpClientesLayout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .add(0, 0, 0))
        );

        jTabbedPane1.addTab("Clientes", jpClientes);

        jpMantenimiento.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("URW Palladio L", 0, 12), new java.awt.Color(1, 1, 1))); // NOI18N
        jpMantenimiento.setFocusCycleRoot(true);
        jpMantenimiento.setFocusTraversalPolicyProvider(true);
        jpMantenimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jpMantenimiento.setName("Datos2"); // NOI18N

        txtCedula.setEditable(false);
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setText("012-0089344-8");
        txtCedula.setToolTipText("Cedula del Cliente");
        txtCedula.setDoubleBuffered(true);
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

        cbActivo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbActivo.setText("Activo");
        cbActivo.setFocusTraversalPolicyProvider(true);
        cbActivo.setMinimumSize(new java.awt.Dimension(0, 0));
        cbActivo.setPreferredSize(new java.awt.Dimension(0, 25));
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });

        txtPNombre.setEditable(false);
        txtPNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        txtSNombre.setEditable(false);
        txtSNombre.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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

        dchFechaNacimiento.setForeground(new java.awt.Color(1, 1, 1));
        dchFechaNacimiento.setAutoscrolls(true);
        dchFechaNacimiento.setFocusTraversalPolicyProvider(true);
        dchFechaNacimiento.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        dchFechaNacimiento.setMinimumSize(new java.awt.Dimension(0, 0));
        dchFechaNacimiento.setPreferredSize(new java.awt.Dimension(0, 25));
        dchFechaNacimiento.setVerifyInputWhenFocusTarget(false);
        dchFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dchFechaNacimientoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                dchFechaNacimientoFocusLost(evt);
            }
        });
        dchFechaNacimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dchFechaNacimientoKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("*Cedula:");
        jLabel1.setFocusable(false);
        jLabel1.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("*Primer Nombres:");
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("*Apellidos:");
        jLabel3.setFocusable(false);
        jLabel3.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setText("*Fecha Nacimiento:");
        jLabel9.setFocusable(false);
        jLabel9.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel9.setRequestFocusEnabled(false);
        jLabel9.setVerifyInputWhenFocusTarget(false);

        jLabel14.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel14.setText("Estado:");
        jLabel14.setFocusable(false);
        jLabel14.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel14.setRequestFocusEnabled(false);
        jLabel14.setVerifyInputWhenFocusTarget(false);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setText("*Segundo Nombres:");
        jLabel4.setFocusable(false);
        jLabel4.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel4.setRequestFocusEnabled(false);
        jLabel4.setVerifyInputWhenFocusTarget(false);

        jcbPersona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione opción", "Fisica", "Juridica" }));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setText("*Persona:");
        jLabel6.setFocusable(false);
        jLabel6.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel6.setRequestFocusEnabled(false);
        jLabel6.setVerifyInputWhenFocusTarget(false);

        jLabel13.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel13.setText("Estado civil: ");
        jLabel13.setFocusable(false);
        jLabel13.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel13.setRequestFocusEnabled(false);
        jLabel13.setVerifyInputWhenFocusTarget(false);

        jcbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel10.setText("Provincias: ");
        jLabel10.setFocusable(false);
        jLabel10.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel10.setRequestFocusEnabled(false);
        jLabel10.setVerifyInputWhenFocusTarget(false);

        jcbProvincias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setText("Municipios: ");
        jLabel11.setFocusable(false);
        jLabel11.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel11.setRequestFocusEnabled(false);
        jLabel11.setVerifyInputWhenFocusTarget(false);

        jcbMunicipios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel12.setText("Distrito Municipal: ");
        jLabel12.setFocusable(false);
        jLabel12.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel12.setRequestFocusEnabled(false);
        jLabel12.setVerifyInputWhenFocusTarget(false);

        jcbDistritoMunicipal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setText("*Direccion:");
        jLabel5.setFocusable(false);
        jLabel5.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);

        txtDireccion.setEditable(false);
        txtDireccion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDireccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDireccion.setDoubleBuffered(true);
        txtDireccion.setFocusTraversalPolicyProvider(true);
        txtDireccion.setMinimumSize(new java.awt.Dimension(0, 0));
        txtDireccion.setPreferredSize(new java.awt.Dimension(0, 25));
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, txtDireccion, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(jcbProvincias, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel11, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jcbMunicipios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jcbDistritoMunicipal, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel12, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbDistritoMunicipal, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbProvincias, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbMunicipios, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(txtDireccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(297, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(new java.awt.Component[] {jcbDistritoMunicipal, jcbMunicipios, jcbProvincias, txtDireccion}, org.jdesktop.layout.GroupLayout.VERTICAL);

        txtDireccion.getAccessibleContext().setAccessibleParent(this);

        jTabbedPane2.addTab("Dirección", jPanel3);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        org.jdesktop.layout.GroupLayout jPanel8Layout = new org.jdesktop.layout.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 654, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 69, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel5Layout = new org.jdesktop.layout.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(0, 0, 0)
                .add(jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane2)
                    .add(jPanel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel5Layout.createSequentialGroup()
                .add(jPanel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, 0)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Contactos", jPanel5);

        btnHistorial.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(1, 1, 1));
        btnHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Clientes 64 x 64.png"))); // NOI18N
        btnHistorial.setText("Detalles Clientes");
        btnHistorial.setAutoscrolls(true);
        btnHistorial.setDoubleBuffered(true);
        btnHistorial.setFocusPainted(false);
        btnHistorial.setFocusTraversalPolicyProvider(true);
        btnHistorial.setMinimumSize(new java.awt.Dimension(0, 0));
        btnHistorial.setPreferredSize(new java.awt.Dimension(0, 25));
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel9Layout = new org.jdesktop.layout.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnHistorial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 163, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .add(btnHistorial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 27, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnHistorial.getAccessibleContext().setAccessibleParent(this);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabbedPane2)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(txtPNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(txtCedula, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                        .add(jPanel1Layout.createSequentialGroup()
                            .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(6, 6, 6)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(dchFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 200, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)))
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txtSNombre, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jcbPersona, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel13, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jcbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 230, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(txtApellidos, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 62, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(cbActivo, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(txtCedula, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(jcbPersona, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(cbActivo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtPNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtSNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtApellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(dchFechaNacimiento, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel13, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jcbEstadoCivil, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jTabbedPane2)
                .add(0, 0, 0)
                .add(jPanel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1Layout.linkSize(new java.awt.Component[] {cbActivo, jLabel14, txtApellidos, txtCedula, txtPNombre}, org.jdesktop.layout.GroupLayout.VERTICAL);

        txtCedula.getAccessibleContext().setAccessibleParent(this);
        txtPNombre.getAccessibleContext().setAccessibleParent(this);
        txtApellidos.getAccessibleContext().setAccessibleParent(this);
        dchFechaNacimiento.getAccessibleContext().setAccessibleParent(this);

        org.jdesktop.layout.GroupLayout jpMantenimientoLayout = new org.jdesktop.layout.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Mantenimiento", jpMantenimiento);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jTabbedPane1)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jTabbedPane1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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

        String msg = borrarCliente(txtCedula.getValue().toString().replace("-", ""));
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
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cancelar();
        nuevo = false;
        mostrarRegistro();
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo(null);
    }//GEN-LAST:event_btnNuevoActionPerformed
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
        

        //Creamos el Objeto Cliente y los agregamos a Datos
        Cliente miCliente = Cliente.builder().
                cedula(txtCedula.getValue().toString()).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                direccion(txtDireccion.getText()).
                fecha_Nacimiento(new java.sql.Date(dchFechaNacimiento.getDate().getTime())).
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
            msg = agregarCliente(miCliente, null);
        } else {
            msg = modificarCliente(miCliente, null);
        }

        JOptionPane.showMessageDialog(this, msg);

        //Actualizamos los cambios en la Tabla
        llenarTabla();

        btnCancelarActionPerformed(evt);


    }//GEN-LAST:event_btnGuardarActionPerformed
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
        editor.setEditable(true);
        button.setEnabled(true);

        

        //Desactivamos el Flag de registro Nuevo        
        nuevo = false;

        txtPNombre.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed
    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtDireccion.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed
    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        //txtTelefono.requestFocusInWindow();
    }//GEN-LAST:event_txtDireccionActionPerformed
    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        if(miDetalle == null){
            miDetalle = new frmDetalleFacturaClientes();
            dpnEscritorio.add(miDetalle);
        }
        
        try {
            miDetalle.setMaximum(false);
            miDetalle.setMaximum(true);
        } catch (PropertyVetoException ex) {
            //Instalar Logger
        }
        
        miDetalle.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        llenarTabla();
        mostrarRegistro();
        reOrdenar(6);
        reOrdenar(0);
        reOrdenar(0);
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formInternalFrameActivated
    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        txtPNombre.requestFocusInWindow();
    }//GEN-LAST:event_txtCedulaActionPerformed
    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (!tblClientes.isEnabled()) {
            return;
        }
        mostrarRegistro();
    }//GEN-LAST:event_tblClientesMouseClicked
    private void cbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivoActionPerformed
        if (!txtPNombre.isEditable()) {
            cbActivo.setSelected(!cbActivo.isSelected());
            return;
        }

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

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        txtDireccion.setText(txtDireccion.getText().toUpperCase());
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        char caracter = evt.getKeyChar();

        if (caracter == '-') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtCedulaKeyReleased

    private void dchFechaNacimientoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dchFechaNacimientoKeyReleased

        JOptionPane.showMessageDialog(this, evt.getKeyCode() + " " + KeyEvent.VK_ENTER);

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            //txtCredito.requestFocusInWindow();
        }
    }//GEN-LAST:event_dchFechaNacimientoKeyReleased

    private void dchFechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dchFechaNacimientoFocusGained
//        dchFechaNacimiento.requestFocusInWindow();
    }//GEN-LAST:event_dchFechaNacimientoFocusGained

    private void dchFechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dchFechaNacimientoFocusLost
//        txtCredito.requestFocusInWindow();
//        dchFechaNacimiento.transferFocus();
    }//GEN-LAST:event_dchFechaNacimientoFocusLost

    private void chbDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbDireccionActionPerformed
        reOrdenar(6);
        reOrdenar(6);
    }//GEN-LAST:event_chbDireccionActionPerformed

    private void chbTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbTelefonoActionPerformed
        reOrdenar(7);
        reOrdenar(7);
    }//GEN-LAST:event_chbTelefonoActionPerformed

    private void chbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCiudadActionPerformed
        reOrdenar(8);
        reOrdenar(8);
    }//GEN-LAST:event_chbCiudadActionPerformed

    private void chbFechaNacimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbFechaNacimientoActionPerformed
        reOrdenar(9);
        reOrdenar(9);
    }//GEN-LAST:event_chbFechaNacimientoActionPerformed

    private void chbFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbFechaIngresoActionPerformed
        reOrdenar(10);
        reOrdenar(10);
    }//GEN-LAST:event_chbFechaIngresoActionPerformed

    private void chbSolo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSolo6ActionPerformed
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_chbSolo6ActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void txtSNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNombreKeyReleased
    private void cancelar() {
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnBuscar.setEnabled(true);
        tblClientes.setEnabled(true);

        //Caja de Texto Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);

        txtCedula.setEditable(false);
        txtPNombre.setEditable(false);
        txtApellidos.setEditable(false);
        txtDireccion.setEditable(false);
        editor.setEditable(false);
        button.setEnabled(false);
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

    private void llenarTabla() {
        String titulos[] = {"Cedula Cliente", "Primer Nombre", "Segundo Nombre", 
            "Apellidos", "Estado civil", "Direccion", "Telefono",
            "Ciudad", "Fecha Nacimiento", "Fecha Ingreso"};
        
        Object registro[] = new Object[11];

        try {
            ResultSet rs = getClientes();
            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            while (rs.next()) {
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = "RD$" + rs.getString("credito");
                registro[4] = "RD$" + rs.getString("deudaActual");
                registro[5] = rs.getBoolean("Estado");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("ciudad");
                registro[9] = Utilidades.formatDate(rs.getDate("fechaNacimiento"), "dd/MM/yyyy");
                registro[10] = Utilidades.formatDate(rs.getDate("fechaIngreso"), "dd/MM/yyyy");
                miTabla.addRow(registro);
            }
            tblClientes.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }

        //Para Alinear el Texto de la Table a la Derecha...
        DefaultTableCellHeaderRenderer tcr = new DefaultTableCellHeaderRenderer();
        
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblClientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tblClientes.getColumnModel().getColumn(4).setCellRenderer(tcr);

        tblClientes.getColumnModel().getColumn(5).setCellEditor(new Celda_CheckBox());
        tblClientes.getColumnModel().getColumn(5).setCellRenderer(new Render_CheckBox());
    }

    private void mostrarRegistro() {
        if (tblClientes.getRowCount() == 0) {
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
        for (int i = 0; i <= 10; i++) {
            miTableColumn = tblClientes.getColumnModel().getColumn(i);
            if (i == 0) {
                if (colm == 0) {
                    chbSolo6.setSelected(true);
                }
                miTableColumn.setPreferredWidth(110);
                miTableColumn.setMaxWidth(110);
                miTableColumn.setMinWidth(110);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(170);
                miTableColumn.setMaxWidth(270);
                miTableColumn.setMinWidth(170);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(170);
                miTableColumn.setMaxWidth(270);
                miTableColumn.setMinWidth(170);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMaxWidth(100);
                miTableColumn.setMinWidth(100);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMaxWidth(100);
                miTableColumn.setMinWidth(100);
            }
            if (i == 5) {
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMaxWidth(100);
                miTableColumn.setMinWidth(100);
            }
            if (i == 6) {//Desde Aqui
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 6) {
                    miTableColumn.setPreferredWidth(400);
                    miTableColumn.setMaxWidth(400);
                    miTableColumn.setMinWidth(400);
                }
            }
            if (i == 7) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 7) {
                    miTableColumn.setPreferredWidth(120);
                    miTableColumn.setMaxWidth(120);
                    miTableColumn.setMinWidth(120);
                }
            }
            if (i == 8) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 8) {
                    miTableColumn.setPreferredWidth(200);
                    miTableColumn.setMaxWidth(200);
                    miTableColumn.setMinWidth(200);
                }
            }
            if (i == 9) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 9) {
                    miTableColumn.setPreferredWidth(150);
                    miTableColumn.setMaxWidth(150);
                    miTableColumn.setMinWidth(150);
                }
            }
            if (i == 10) {//Hasta aqui
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 10) {
                    miTableColumn.setPreferredWidth(150);
                    miTableColumn.setMaxWidth(150);
                    miTableColumn.setMinWidth(150);
                }
            }
            tblClientes.repaint();
        }
        tblClientes.setRowSelectionInterval(tblClientes.getSelectedRow(), 
                tblClientes.getSelectedRow());
    }
    private void nuevo(Object idCliente) {
        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscar.setEnabled(false);
        tblClientes.setEnabled(false);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Textos
        txtCedula.setEditable(true);
        txtPNombre.setEditable(true);
        txtApellidos.setEditable(true);
        txtDireccion.setEditable(true);
        editor.setEditable(true);
        button.setEnabled(true);

        //txt Vaciar
        txtPNombre.setText("");
        txtApellidos.setText("");
        txtDireccion.setText("");
        dchFechaNacimiento.setDate(new Date());
        cbActivo.setSelected(false);
        cbActivo.setText("Inactivo");

        txtCedula.grabFocus();
        txtCedula.requestFocusInWindow();

        //Activamos el Flag de registro Nuevo        
        nuevo = true;
        txtCedula.setValue(idCliente);

        if (idCliente != null) {
            txtCedula.setEditable(false);
            txtPNombre.grabFocus();
            txtPNombre.requestFocusInWindow();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JCheckBox chbCiudad;
    private javax.swing.JCheckBox chbDireccion;
    private javax.swing.JCheckBox chbFechaIngreso;
    private javax.swing.JCheckBox chbFechaNacimiento;
    private javax.swing.JCheckBox chbSolo6;
    private javax.swing.JCheckBox chbTelefono;
    private com.toedter.calendar.JDateChooser dchFechaNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> jcbDistritoMunicipal;
    private javax.swing.JComboBox<String> jcbEstadoCivil;
    private javax.swing.JComboBox<String> jcbMunicipios;
    private javax.swing.JComboBox<String> jcbPersona;
    private javax.swing.JComboBox<String> jcbProvincias;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtPNombre;
    private javax.swing.JTextField txtSNombre;
    // End of variables declaration//GEN-END:variables

}
