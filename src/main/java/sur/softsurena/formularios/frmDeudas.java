package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static sur.softsurena.datos.procedure.ProcedureMetodos.insertDeudas;
import static sur.softsurena.datos.select.SelectMetodos.existeCliente;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Deudas;
import static sur.softsurena.formularios.frmPrincipal.mnuArchivosCliente;
import sur.softsurena.utilidades.Utilidades;

public class frmDeudas extends javax.swing.JInternalFrame {

    private int cliAct = 0;
    private boolean nuevo;
    private DefaultTableModel miTabla;
    private String idUsuario;
    private final JButton button;
    private final DefaultTableCellRenderer tcr;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public frmDeudas() {
        
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtMonto.setSelectionStart(3);
                        txtMonto.setSelectionEnd(txtMonto.getText().length());
                    }
                });
            }
        });
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dchFecha.getDateEditor();
        editor.setEditable(false);
        button = dchFecha.getCalendarButton();
        button.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIDCliente = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        dchFecha = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnGetCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();
        btnVerPagos = new javax.swing.JButton();
        btnAbonar = new javax.swing.JButton();
        btnAnular = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cbTodos = new javax.swing.JCheckBox();
        cbInicial = new javax.swing.JCheckBox();
        cbPagada = new javax.swing.JCheckBox();
        cbAbonada = new javax.swing.JCheckBox();
        cbNula = new javax.swing.JCheckBox();
        btnGetTotal = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Control de la deudas del negocio");
        setToolTipText("");
        setMaximumSize(new java.awt.Dimension(3000, 3000));
        setMinimumSize(new java.awt.Dimension(42, 42));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Deudor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("*Apellidos:");
        jLabel3.setFocusable(false);
        jLabel3.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtApellidos.setDoubleBuffered(true);
        txtApellidos.setFocusTraversalPolicyProvider(true);
        txtApellidos.setPreferredSize(new java.awt.Dimension(52, 21));
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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Cedula:");
        jLabel1.setFocusable(false);
        jLabel1.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        txtIDCliente.setEditable(false);
        try {
            txtIDCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIDCliente.setToolTipText("Cedula del Cliente");
        txtIDCliente.setDoubleBuffered(true);
        txtIDCliente.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtIDCliente.setFocusTraversalPolicyProvider(true);
        txtIDCliente.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        txtIDCliente.setPreferredSize(new java.awt.Dimension(52, 21));
        txtIDCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDClienteActionPerformed(evt);
            }
        });
        txtIDCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDClienteKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombres:");
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNombres.setDoubleBuffered(true);
        txtNombres.setFocusTraversalPolicyProvider(true);
        txtNombres.setPreferredSize(new java.awt.Dimension(52, 21));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombresKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Concepto:");

        txtConcepto.setEditable(false);
        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConcepto.setForeground(new java.awt.Color(0, 0, 0));
        txtConcepto.setLineWrap(true);
        txtConcepto.setToolTipText("Inserte el concepto de la deuda...");
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConceptoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtConcepto);

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Monto:");
        jLabel11.setFocusable(false);
        jLabel11.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel11.setRequestFocusEnabled(false);
        jLabel11.setVerifyInputWhenFocusTarget(false);

        txtMonto.setEditable(false);
        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("??#,##0.00"))));
        txtMonto.setToolTipText("Indique el limite de credito del Cliente");
        txtMonto.setDoubleBuffered(true);
        txtMonto.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMonto.setFocusTraversalPolicyProvider(true);
        txtMonto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtMonto.setPreferredSize(new java.awt.Dimension(52, 21));
        txtMonto.setValue(0);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        dchFecha.setForeground(new java.awt.Color(1, 1, 1));
        dchFecha.setAutoscrolls(true);
        dchFecha.setFocusTraversalPolicyProvider(true);
        dchFecha.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        dchFecha.setPreferredSize(new java.awt.Dimension(52, 21));
        dchFecha.setVerifyInputWhenFocusTarget(false);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha:");
        jLabel9.setFocusable(false);
        jLabel9.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel9.setRequestFocusEnabled(false);
        jLabel9.setVerifyInputWhenFocusTarget(false);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/money.png"))); // NOI18N

        btnGetCliente.setText("Obtener Cliente");
        btnGetCliente.setEnabled(false);
        btnGetCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIDCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetCliente))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(dchFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dchFecha, txtApellidos, txtMonto, txtNombres});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGetCliente)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane5)
                        .addGap(0, 0, 0))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGetCliente, dchFecha, jLabel1, jLabel11, jLabel2, jLabel3, jLabel5, jLabel9, txtApellidos, txtIDCliente, txtMonto, txtNombres});

        dchFecha.getAccessibleContext().setAccessibleParent(this);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones de Acci??n"));
        jPanel2.setMaximumSize(new java.awt.Dimension(787, 81));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel5.setLayout(new java.awt.GridLayout(1, 4, 4, 0));

        btnPrimero.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnPrimero.setForeground(new java.awt.Color(1, 1, 1));
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anterior 32 x 32.png"))); // NOI18N
        btnPrimero.setMnemonic('p');
        btnPrimero.setText("Primero");
        btnPrimero.setToolTipText("Va al Primer Registro");
        btnPrimero.setMaximumSize(new java.awt.Dimension(104, 42));
        btnPrimero.setMinimumSize(new java.awt.Dimension(42, 42));
        btnPrimero.setPreferredSize(new java.awt.Dimension(104, 42));
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        jPanel5.add(btnPrimero);

        btnAnterior.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAnterior.setForeground(new java.awt.Color(1, 1, 1));
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flecha Izquierda 32 x 32.png"))); // NOI18N
        btnAnterior.setMnemonic('a');
        btnAnterior.setText("Anterior");
        btnAnterior.setToolTipText("Va al Anterior Registro");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel5.add(btnAnterior);

        btnSiguiente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(1, 1, 1));
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flecha Derecha 32 x 32.png"))); // NOI18N
        btnSiguiente.setMnemonic('s');
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setToolTipText("Va al Siguiente Registro");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel5.add(btnSiguiente);

        btnUltimo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnUltimo.setForeground(new java.awt.Color(1, 1, 1));
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Siguiente 32 x 32.png"))); // NOI18N
        btnUltimo.setMnemonic('u');
        btnUltimo.setText("Ultimo");
        btnUltimo.setToolTipText("Va al Ultimo Registro");
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel5.add(btnUltimo);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cambiar Estado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        jPanel7.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel7.setLayout(new java.awt.GridLayout(2, 2, 8, 5));

        btnReiniciar.setText("Reiniciar");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        jPanel7.add(btnReiniciar);

        btnVerPagos.setText("Ver pagos");
        btnVerPagos.setToolTipText("");
        btnVerPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPagosActionPerformed(evt);
            }
        });
        jPanel7.add(btnVerPagos);

        btnAbonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbonarActionPerformed(evt);
            }
        });
        jPanel7.add(btnAbonar);

        btnAnular.setText("Anular");
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel7.add(btnAnular);

        jPanel4.add(jPanel7);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 12))); // NOI18N
        jPanel9.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel9.setLayout(new java.awt.GridLayout(2, 3));

        buttonGroup1.add(cbTodos);
        cbTodos.setSelected(true);
        cbTodos.setText("Todos");
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
            }
        });
        jPanel9.add(cbTodos);

        buttonGroup1.add(cbInicial);
        cbInicial.setText("Iniciadas");
        cbInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbInicialActionPerformed(evt);
            }
        });
        jPanel9.add(cbInicial);

        buttonGroup1.add(cbPagada);
        cbPagada.setText("Pagadas");
        cbPagada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPagadaActionPerformed(evt);
            }
        });
        jPanel9.add(cbPagada);

        buttonGroup1.add(cbAbonada);
        cbAbonada.setText("Abonadas");
        cbAbonada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAbonadaActionPerformed(evt);
            }
        });
        jPanel9.add(cbAbonada);

        buttonGroup1.add(cbNula);
        cbNula.setText("Nulas");
        cbNula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNulaActionPerformed(evt);
            }
        });
        jPanel9.add(cbNula);

        btnGetTotal.setText("Sumar");
        btnGetTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetTotalActionPerformed(evt);
            }
        });
        jPanel9.add(btnGetTotal);

        jPanel4.add(jPanel9);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Deuda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jScrollPane6.setViewportView(jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        direccion("a");
    }//GEN-LAST:event_btnPrimeroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        direccion("b");
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        direccion("c");
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        direccion("d");
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tblClientes.setEnabled(false);//Deshabilitamos la tabla de cliente
        txtIDCliente.setEditable(true);//Campo de la cedula editable
        btnGetCliente.setEnabled(true);//Se habitan el boton de obtener datos del cliente
        btnCancelar.setEnabled(true);//Deshabitamos el boton cancelar
        btnModificar.setEnabled(false);//Deshabitamos el boton modificar
        txtIDCliente.grabFocus();//Garantizar el focus
        txtIDCliente.requestFocusInWindow();//Peticion del focus
        txtIDCliente.setValue("");//Iniciamos el valor del focus
        nuevo = true;//Buscamos un nuevo registros de dueda...
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }
        String idCliente = txtIDCliente.getText().replace("-", "").trim();
        if (idCliente.isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Debe seleccionar cliente...");
            return;
        }
        
        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscar.setEnabled(false);
        tblClientes.setEnabled(false);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Texto Habilitado
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtMonto.setEditable(true);
        txtConcepto.setEditable(true);

        //Desactivamos el Flag de registro Nuevo
        nuevo = false;

        txtNombres.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idCliente = txtIDCliente.getText().replace("-", "").trim();
        if (idCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un ID de Cliente...");
            txtIDCliente.requestFocusInWindow();
            return;
        }

        if (txtNombres.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un Nombre...");
            txtNombres.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Digitar un Apellido...");
            txtApellidos.requestFocusInWindow();
            return;
        }

        double monto = Utilidades.controlDouble(txtMonto.getValue());

        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad mayor que cero");
            txtMonto.setValue(0);
            txtMonto.requestFocusInWindow();
            return;
        }

        if (txtConcepto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un concepto detallado de la deuda");
            txtConcepto.requestFocusInWindow();
            return;
        }
        if (txtConcepto.getText().length() < 20 || txtConcepto.getText().length() > 199) {
            JOptionPane.showMessageDialog(this, "Ingrese concepto de un minimo "
                    + "de 20 caracteres y un Maximo 200, Caracteres actuales de:"
                    + " " + txtConcepto.getText().length());
            txtConcepto.requestFocusInWindow();
            return;
        }

        //Creamos el Objeto Cliente y los agregamos a Datos
        Deudas miDeuda = new Deudas(idCliente, getIdUsuario(),
                txtConcepto.getText(), monto);

        String accion = "editar";
        if (nuevo) {
            accion = "Inserta";
        }
        String concepto;

        if (txtConcepto.getText().length() >= 51) {
            concepto = txtConcepto.getText().substring(0, 49);
        } else {
            concepto = txtConcepto.getText();
        }

        
        
        
        

        int resp = JOptionPane.showConfirmDialog(this,
                "<html><b><big>Se va a " + accion + " deuda de: </big></b><big>"
                + txtNombres.getText() + " " + txtApellidos.getText()
                + "</big></html>"
                + "\n<html><b><big>Cedula no.: </big></b><big>"
                + txtIDCliente.getValue() + "</big></html>"
                + "\n<html><b><big>Monto de deuda es: </big></b><big>"
                + txtMonto.getText() + "</big></html>"
                + "\n<html><b><big>Por Concepto de: </big></b><big>"
                + concepto + "</big></html>"
                + "\n<html><b><big>De fecha nacimiento: </big></b><big>"
                + Utilidades.formatDate(dchFecha.getDate(), "dd-MM-yyyy")
                + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }
        if (nuevo) {
            if (insertDeudas(miDeuda)) {
                JOptionPane.showMessageDialog(this, 
                        "Registro de deuda Insertada!", 
                        "Confirmaci??n de proceso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                        "Falla de registro!", 
                        "Confirmaci??n de proceso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            //Modificar una deuda.??? Ummm
        }
        
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
        nuevo = false;
        mostrarRegistro();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }
        if (tblClientes.getRowCount() == 0) {
            
            return;
        }
        String idCliente = txtIDCliente.getText().replace("-", "").trim();

        

        if (idCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar cliente...");
            return;
        }
        String idDeuda = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
        int rta = JOptionPane.showConfirmDialog(this,
                "??Esta Seguro de Eliminar Deuda #" + idDeuda,
                "Borrar Deuda", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rta == 1) {
            return;
        }

        cliAct = 0;
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No existe contenido que buscar...!");
            return;
        }

        String cliente;

        cliente = "" + JOptionPane.showInputDialog(this, "Ingrese la Cedula del Cliente");

        if (cliente.equals("null")) {
            return;
        }

        

        int num = tblClientes.getRowCount();
        for (int i = 0; i < num; i++) {
            if (tblClientes.getValueAt(i, 1).toString().contains(cliente)) {
                cliAct = i;
                break;
            }
            if (tblClientes.getValueAt(i, 2).toString().contains(cliente.toUpperCase())) {
                cliAct = i;
                break;
            }
            if (tblClientes.getValueAt(i, 3).toString().contains(cliente.toUpperCase())) {
                cliAct = i;
                break;
            }
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtIDClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDClienteActionPerformed
        btnGetClienteActionPerformed(evt);
    }//GEN-LAST:event_txtIDClienteActionPerformed

    private void txtIDClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDClienteKeyReleased
        char caracter = evt.getKeyChar();

        if (caracter == '-') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtIDClienteKeyReleased

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtNombresActionPerformed

    private void txtNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyReleased
        txtNombres.setText(txtNombres.getText().toUpperCase());
    }//GEN-LAST:event_txtNombresKeyReleased

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtMonto.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyReleased
        txtApellidos.setText(txtApellidos.getText().toUpperCase());
    }//GEN-LAST:event_txtApellidosKeyReleased

    private void txtConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyReleased
        txtConcepto.setText(txtConcepto.getText().toUpperCase());
    }//GEN-LAST:event_txtConceptoKeyReleased

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        txtConcepto.requestFocusInWindow();
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnGetClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetClienteActionPerformed
        String idCliente = txtIDCliente.getText().replace("-", "").trim();

        if (idCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Inserte una cedula Valida, 000-0000000-0");
            txtIDCliente.setValue("");
            txtIDCliente.requestFocusInWindow();
            return;
        }

        

        if (existeCliente(idCliente)) {
            
            nuevo();
            ResultSet rs = getConsulta(
                    "SELECT r.NOMBRES, r.APELLIDOS "
                    + "FROM TABLA_CLIENTES r "
                    + "WHERE r.IDCLIENTE like '" + idCliente + "'");

            try {
                rs.next();
                txtNombres.setText(rs.getString(1));
                txtApellidos.setText(rs.getString(2));
            } catch (SQLException ex) {
                //Instalar Logger
            }
            btnGetCliente.setEnabled(false);
            txtIDCliente.setEditable(false);
            txtNombres.setEditable(false);
            txtApellidos.setEditable(false);
            txtMonto.requestFocusInWindow();
        } else {
            //Cliente no existe
            int resp = JOptionPane.showConfirmDialog(this,
                    "Desea registrar este usuario al sistema?",
                    "Registro de Usuario",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);

            //Activamos el Flag de registro Nuevo
            nuevo = true;
            if (resp == JOptionPane.OK_OPTION) {
                
                mnuArchivosCliente.doClick();
            } else {
                
                btnCancelarActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_btnGetClienteActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }
        cliAct = tblClientes.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblClientesMouseClicked

    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbTodosActionPerformed

    private void cbInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbInicialActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbInicialActionPerformed

    private void cbPagadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPagadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbPagadaActionPerformed

    private void cbAbonadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAbonadaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbAbonadaActionPerformed

    private void cbNulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNulaActionPerformed
        llenarTabla();
    }//GEN-LAST:event_cbNulaActionPerformed

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == '.') {
            return;
        }
        if (caracter == ',') {
            return;
        }
        if (caracter == 'R') {
            return;
        }
        if (caracter == 'D') {
            return;
        }
        if (caracter == '$') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }

        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }

        
        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setDatos(getDatos());
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            JOptionPane.showMessageDialog(this, "Usuario no valido");
            return;
        }

        int valor = JOptionPane.showConfirmDialog(this,
                "Se proceder?? a eliminar los pagos tambien!",
                "Confirmaci??n!!!", JOptionPane.YES_NO_OPTION);

        if (valor == JOptionPane.NO_OPTION) {
            return;
        }

        JOptionPane.showMessageDialog(this, modificarDeuda(
                Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()), 
                "i"));
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPagosActionPerformed
        if (tblClientes.getRowCount() == 0) {
            
            return;
        }

        frmPagosDeudas miPagos = new frmPagosDeudas(null, true,
                Utilidades.objectToInt(tblClientes.getValueAt(cliAct, 0)),
                txtIDCliente.getText().trim(), txtNombres,
                txtApellidos, dchFecha, txtMonto.getValue());
        miPagos.setLocationRelativeTo(null);
        miPagos.setVisible(true);
    }//GEN-LAST:event_btnVerPagosActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
//        if(tblClientes.getRowCount()  < 1) return;
//        if(btnCancelar.isEnabled()){
//            txtIDCliente.requestFocusInWindow();
//            return;
//        }
//        JOptionPane.showMessageDialog(this, misDatos.modificarDeuda(
//                tblClientes.getValueAt(cliAct, 0)), 
//                "a"));
//        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }
        if (btnCancelar.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }

        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        
        if (!miAut.isAceptado()) {
            JOptionPane.showMessageDialog(this, "Usuario no valido");
            return;
        }

        JOptionPane.showMessageDialog(this, modificarDeuda(
                Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()),
                "n"));
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnAnularActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        if (btnGetCliente.isEnabled()) {
            btnGetClienteActionPerformed(null);
        }
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
        mostrarRegistro();// TODO add your handling code here:
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnGetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTotalActionPerformed
        String estado = "", msg = "Nada para mostrar";

        if (cbTodos.isSelected()) {
            estado = "GROUP BY r.estado";
        }
        if (cbInicial.isSelected()) {
            estado = "WHERE r.ESTADO like 'i' GROUP BY r.estado";
        }
        if (cbNula.isSelected()) {
            estado = "WHERE r.ESTADO like 'n' GROUP BY r.estado";
        }
        if (cbAbonada.isSelected()) {
            estado = "WHERE r.ESTADO like 'a' GROUP BY r.estado";
        }
        if (cbPagada.isSelected()) {
            estado = "WHERE r.ESTADO like 'p' GROUP BY r.estado";
        }

        ResultSet rs = getConsulta(
                "SELECT SUM(r.MONTO), case r.ESTADO "
                + "when 'i' then 'Inicial:' "
                + "when 'a' then 'Abonado:' "
                + "when 'p' then 'Pagado:' "
                + "when 'n' then 'Nulado:' "
                + "end "
                + "FROM GET_SUMA_DEUDA r "
                + estado);

        try {
            while (rs.next()) {
                msg = msg.replaceAll("Nada para mostrar", "");
                msg = msg + (rs.getString(2)) + "       " + (rs.getString(1)) + " <BR>";
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
        msg = "<html><big>" + msg + "</big></html>";
        JOptionPane.showMessageDialog(this, msg);
    }//GEN-LAST:event_btnGetTotalActionPerformed

    private void mostrarRegistro() {
        txtIDCliente.setValue("");
        if (tblClientes.getRowCount() == 0) {
            return;
        }
        
        txtIDCliente.setText(tblClientes.getValueAt(cliAct, 1).toString());
        txtNombres.setText(tblClientes.getValueAt(cliAct, 2).toString());
        txtApellidos.setText(tblClientes.getValueAt(cliAct, 3).toString());
        txtConcepto.setText(tblClientes.getValueAt(cliAct, 4).toString());
        txtMonto.setValue(Utilidades.objectToDouble(tblClientes.getValueAt(cliAct, 5)));
        dchFecha.setDate(Utilidades.objectToDate(tblClientes.getValueAt(cliAct, 6)));

        tblClientes.setRowSelectionInterval(cliAct, cliAct);
        txtIDCliente.setEditable(false);
    }

    private void cancelar() {
        btnPrimero.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnBuscar.setEnabled(true);
        tblClientes.setEnabled(true);

        //Caja de Texto Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGetCliente.setEnabled(false);

        txtIDCliente.setEditable(false);
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtMonto.setEditable(false);
        txtConcepto.setEditable(false);

        reset('s');
    }

    private void reset(char idCliente) {
        if (idCliente == 's') {
            txtIDCliente.setValue("");
        }

        txtNombres.setText("");
        txtApellidos.setText("");
        txtMonto.setValue(0);
        dchFecha.setDate(new Date());
        txtConcepto.setText("");
    }

    private void nuevo() {
        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscar.setEnabled(false);

        //Caja de Texto Habilitado
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtMonto.setEditable(true);
        txtConcepto.setEditable(true);

        reset('n');
    }

    private void llenarTabla() {
        String titulos[] = {"Numero", "Cedula Cliente", "Nombres", "Apellidos",
            "Concepto", "Monto", "Fecha", "Estado"};
        Object registro[] = new Object[8];

        try {
            ResultSet rs = getConsulta(
                    "SELECT r.IDDEUDAS, IIF(r.IDCLIENTE = '0', '000-0000000-0', "
                            + "r.IDCLIENTE) as IDCLIENTE, c.NOMBRES, c.APELLIDOS, "
                    + "r.CONCEPTO, r.MONTO, r.FECHA, "
                    + "        (IIF(r.ESTADO = 'i', 'Inicial', "
                    + "         IIF(r.ESTADO = 'p', 'Pagada', "
                    + "         IIF(r.ESTADO = 'a', 'Abonada', "
                    + "         IIF(r.ESTADO = 'n','Nula','No Definida'))))) as ESTADO "
                    + "FROM TABLA_DEUDAS r "
                    + "LEFT JOIN TABLA_CLIENTES c"
                    + "    ON c.IDCLIENTE LIKE r.IDCLIENTE "
                    + estados()
                    + "ORDER by 1");
            miTabla = new DefaultTableModel(null, titulos);

            while (rs.next()) {
                registro[0] = rs.getString("IDDEUDAS");
                registro[1] = rs.getString("idCliente");
                registro[2] = rs.getString("nombres");
                registro[3] = rs.getString("apellidos");
                registro[4] = rs.getString("concepto");
                registro[5] = "RD$" + rs.getDouble("monto");
                registro[6] = Utilidades.formatDate(rs.getDate("fecha"), "dd/MM/yyyy");
                registro[7] = rs.getString("estado");
                miTabla.addRow(registro);
            }

            tblClientes.setModel(miTabla);

            if (miTabla.getRowCount() != 0) {//La tabla esta llena
                cliAct = 0;
                tblClientes.setRowSelectionInterval(cliAct, cliAct);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
        //Para Alinear el Texto de la Table a la Derecha...
        
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblClientes.getColumnModel().getColumn(5).setCellRenderer(tcr);

        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblClientes.getColumnModel().getColumn(7).setCellRenderer(tcr);

        TableColumn miTableColumn;
        for (int i = 0; i < 8; i++) {
            miTableColumn = tblClientes.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(30);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(80);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(250);
            }
            if (i == 5) {
                miTableColumn.setPreferredWidth(50);
            }
            if (i == 6) {
                miTableColumn.setPreferredWidth(50);
            }
            if (i == 7) {
                miTableColumn.setPreferredWidth(40);
            }
        }
        mostrarRegistro();
    }

    private String estados() {
        if (cbInicial.isSelected()) {
            return "where r.estado like 'i'";
        }
        if (cbPagada.isSelected()) {
            return "where r.estado like 'p'";
        }
        if (cbAbonada.isSelected()) {
            return "where r.estado like 'a'";
        }
        if (cbNula.isSelected()) {
            return "where r.estado like 'n'";
        }
        return "";
    }

    private void direccion(String direccion) {
        if (!tblClientes.isEnabled()) {
            txtIDCliente.requestFocusInWindow();
            return;
        }

        if (tblClientes.getRowCount() == 0) {
            return;
        }
        switch (direccion) {
            case "a":
                cliAct = 0;
                mostrarRegistro();
                break;
            case "b":
                cliAct--;
                if (cliAct == -1) {
                    cliAct = getDatos().numeroDeudas(estados()) - 1;
                }
                mostrarRegistro();
                break;
            case "c":
                cliAct++;
                if (cliAct == getDatos().numeroDeudas(estados())) {
                    cliAct = 0;
                }
                mostrarRegistro();
                break;
            case "d":
                cliAct = getDatos().numeroDeudas(estados()) - 1;
                mostrarRegistro();
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGetCliente;
    private javax.swing.JButton btnGetTotal;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnVerPagos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbAbonada;
    private javax.swing.JCheckBox cbInicial;
    private javax.swing.JCheckBox cbNula;
    private javax.swing.JCheckBox cbPagada;
    private javax.swing.JCheckBox cbTodos;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JFormattedTextField txtIDCliente;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
