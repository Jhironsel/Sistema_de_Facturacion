package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static sur.softsurena.entidades.Clientes.getClientes;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Deudas;
import static sur.softsurena.entidades.Deudas.insertDeudas;
import static sur.softsurena.entidades.Deudas.modificarDeuda;
import sur.softsurena.entidades.FiltroBusqueda;
import sur.softsurena.utilidades.Utilidades;

public class frmDeudas extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmDeudas.class.getName());

    private int cliAct = 0;
    private boolean nuevo;
    private DefaultTableModel miTabla;
    private final JButton button;
    private final DefaultTableCellRenderer tcr;

    public static frmDeudas getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmDeudas INSTANCE = new frmDeudas();
    }

    private frmDeudas() {

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
        txtCedula = new javax.swing.JFormattedTextField();
        btnGetCliente = new javax.swing.JButton();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtMonto = new javax.swing.JFormattedTextField();
        dchFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jlFoto = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Deudor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N

        txtCedula.setEditable(false);
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setToolTipText("Cedula del Cliente");
        txtCedula.setDoubleBuffered(true);
        txtCedula.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCedula.setFocusTraversalPolicyProvider(true);
        txtCedula.setFont(new java.awt.Font("Ubuntu Mono", 1, 16)); // NOI18N
        txtCedula.setPreferredSize(new java.awt.Dimension(52, 21));
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

        btnGetCliente.setText("Clientes");
        btnGetCliente.setEnabled(false);
        btnGetCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetClienteActionPerformed(evt);
            }
        });

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

        txtMonto.setEditable(false);
        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
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

        txtConcepto.setEditable(false);
        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConcepto.setLineWrap(true);
        txtConcepto.setToolTipText("Inserte el concepto de la deuda...");
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConceptoKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtConcepto);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("*Apellidos:");
        jLabel3.setFocusable(false);
        jLabel3.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Cedula:");
        jLabel1.setFocusable(false);
        jLabel1.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombres:");
        jLabel2.setFocusable(false);
        jLabel2.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel2.setRequestFocusEnabled(false);
        jLabel2.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Concepto:");

        jLabel11.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Monto:");
        jLabel11.setFocusable(false);
        jLabel11.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel11.setRequestFocusEnabled(false);
        jLabel11.setVerifyInputWhenFocusTarget(false);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Fecha:");
        jLabel9.setFocusable(false);
        jLabel9.setPreferredSize(new java.awt.Dimension(52, 21));
        jLabel9.setRequestFocusEnabled(false);
        jLabel9.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dchFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGetCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane5)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGetCliente, dchFecha, jLabel1, jLabel11, jLabel2, jLabel3, jLabel5, jLabel9, txtApellidos, txtCedula, txtMonto, txtNombres});

        dchFecha.getAccessibleContext().setAccessibleParent(this);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones de Acción"));
        jPanel2.setMaximumSize(new java.awt.Dimension(787, 81));
        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        jPanel6.setLayout(new java.awt.GridLayout(1, 5, 4, 5));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel6.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel6.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel6.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel6.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
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
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
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
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        btnGetClienteActionPerformed(evt);
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void txtCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyReleased
        char caracter = evt.getKeyChar();

        if (caracter == '-') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtCedulaKeyReleased

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
        /*
            Obtenemos la cedula del cliente de la caja de texto o jTextField.
         */
        String cedula = txtCedula.getValue().toString();

        /*
            Validamos el campo para saber si está vacio o está en blanco.
         */
        if (cedula.isEmpty() || cedula.isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Inserte una cedula Valida, Ej: 000-0000000-0",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.setValue("");
            txtCedula.requestFocusInWindow();
            return;
        }

        /*
            Validamos si el cliente existe en la base de datos.
         */
        Integer idCliente = getClientes(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda(cedula)
                        .build()
        ).get(0).getId_persona();

        if (idCliente != -1) {

            nuevo();

//            getConsulta(
//                    "SELECT r.NOMBRES, r.APELLIDOS "
//                    + "FROM TABLA_CLIENTES r "
//                    + "WHERE r.IDCLIENTE like '" + idCliente + "'");
            ResultSet rs = null;

            try {
                rs.next();
                txtNombres.setText(rs.getString(1));
                txtApellidos.setText(rs.getString(2));
            } catch (SQLException ex) {
                //Instalar Logger
            }

            btnGetCliente.setEnabled(false);

            txtCedula.setEditable(false);
            txtNombres.setEditable(false);
            txtApellidos.setEditable(false);

            txtMonto.requestFocusInWindow();
        } else {
            //Cliente no existe
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Desea registrar este usuario al sistema?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            //Activamos el Flag de registro Nuevo
            nuevo = true;
            if (resp == JOptionPane.OK_OPTION) {

//                mnuArchivosCliente.doClick();
            } else {

                btnCancelarActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_btnGetClienteActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocusInWindow();
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
            txtCedula.requestFocusInWindow();
            return;
        }

        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            return;
        }

        int valor = JOptionPane.showInternalConfirmDialog(
                this,
                "Se procederá a eliminar los pagos tambien!",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (valor == JOptionPane.NO_OPTION) {
            return;
        }

        //TODO Sacar el Metodo de modificar la deuda y hacer que devuelva un Resultados.
        JOptionPane.showInternalMessageDialog(
                this,
                modificarDeuda(
                        Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()),
                        "i"
                ),
                "",
                JOptionPane.INFORMATION_MESSAGE
        );
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnVerPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPagosActionPerformed
        if (tblClientes.getRowCount() == 0) {

            return;
        }

        frmPagosDeudas miPagos = new frmPagosDeudas(null, true,
                Utilidades.objectToInt(tblClientes.getValueAt(cliAct, 0)),
                txtCedula.getText().trim(), txtNombres,
                txtApellidos, dchFecha, txtMonto.getValue());
        miPagos.setLocationRelativeTo(null);
        miPagos.setVisible(true);
    }//GEN-LAST:event_btnVerPagosActionPerformed

    private void btnAbonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbonarActionPerformed
//      TODO Analizar y Descomentar.  
//      if(tblClientes.getRowCount()  < 1) return;
//        if(btnCancelar.isEnabled()){
//            txtIDCliente.requestFocusInWindow();
//            return;
//        }
//        JOptionPane.showInternalMessageDialog(
//                  this, 
//                  misDatos.modificarDeuda(
//                      tblClientes.getValueAt(cliAct, 0)), 
//                  "a")
//        );
//        llenarTabla();
//        mostrarRegistro();
    }//GEN-LAST:event_btnAbonarActionPerformed

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed
        if (tblClientes.getRowCount() < 1) {
            return;
        }
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocusInWindow();
            return;
        }

        frmAutorizacion miAut = new frmAutorizacion(null, true);
        miAut.setLocationRelativeTo(null);
        miAut.setVisible(true);

        if (!miAut.isAceptado()) {
            return;
        }

        //TODO Analizar y Testear este metodo de modificarDeuda()
        //Hacer que ese metodo revuelva un resultados.
        JOptionPane.showInternalMessageDialog(
                this,
                modificarDeuda(
                        Integer.parseInt(tblClientes.getValueAt(cliAct, 0).toString()),
                        "n"),
                "",
                JOptionPane.INFORMATION_MESSAGE
        );
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
        mostrarRegistro();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnGetTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetTotalActionPerformed
        //TODO Estudiar este metodo o btn para que se utiliza.
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

//        getConsulta(
//                "SELECT SUM(r.MONTO), case r.ESTADO "
//                + "when 'i' then 'Inicial:' "
//                + "when 'a' then 'Abonado:' "
//                + "when 'p' then 'Pagado:' "
//                + "when 'n' then 'Nulado:' "
//                + "end "
//                + "FROM GET_SUMA_DEUDA r "
//                + estado);
        //TODO Realizar proceso para consultar la deuda.
        ResultSet rs = null;

        try {
            while (rs.next()) {
                msg = msg.replaceAll("Nada para mostrar", "");
                msg = msg + (rs.getString(2)) + "       " + (rs.getString(1)) + " <BR>";
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
        msg = "<html><big>" + msg + "</big></html>";
        JOptionPane.showInternalMessageDialog(
                this,
                msg,
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

    }//GEN-LAST:event_btnGetTotalActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        tblClientes.setEnabled(false);//Deshabilitamos la tabla de cliente
        txtCedula.setEditable(true);//Campo de la cedula editable
        btnGetCliente.setEnabled(true);//Se habitan el boton de obtener datos del cliente
        btnCancelar.setEnabled(true);//Deshabitamos el boton cancelar
        btnModificar.setEnabled(false);//Deshabitamos el boton modificar
        txtCedula.grabFocus();//Garantizar el focus
        txtCedula.requestFocusInWindow();//Peticion del focus
        txtCedula.setValue("");//Iniciamos el valor del focus
        nuevo = true;//Buscamos un nuevo registros de dueda...
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocusInWindow();
            return;
        }
        String idCliente = txtCedula.getText().replace("-", "").trim();
        if (idCliente.isEmpty()) {

            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
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
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtMonto.setEditable(true);
        txtConcepto.setEditable(true);

        //Desactivamos el Flag de registro Nuevo
        nuevo = false;

        txtNombres.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String idCliente = txtCedula.getText().replace("-", "").trim();
        if (idCliente.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Digitar un ID de Cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCedula.requestFocusInWindow();
            return;
        }

        if (txtNombres.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Digitar un Nombre...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNombres.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Digitar un Apellido...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtApellidos.requestFocusInWindow();
            return;
        }

        double monto = Utilidades.controlDouble(txtMonto.getValue());

        if (monto <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Ingrese una cantidad mayor que cero",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtMonto.setValue(0);
            txtMonto.requestFocusInWindow();
            return;
        }

        if (txtConcepto.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe ingresar un concepto detallado de la deuda",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtConcepto.requestFocusInWindow();
            return;
        }

        if (txtConcepto.getText().length() < 20 || txtConcepto.getText().length() > 199) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Ingrese concepto de un minimo "
                    + "de 20 caracteres y un Maximo 200, Caracteres actuales de:"
                    + " " + txtConcepto.getText().length(),
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtConcepto.requestFocusInWindow();
            return;
        }

        //Creamos el Objeto Cliente y los agregamos a Datos
        Deudas miDeuda = Deudas.builder().id_persona(-1).build();

//                new Deudas(idCliente, getIdUsuario(),
//                txtConcepto.getText(), monto);
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

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "<html><b><big>Se va a " + accion + " deuda de: </big></b><big>"
                + txtNombres.getText() + " " + txtApellidos.getText()
                + "</big></html>"
                + "\n<html><b><big>Cedula no.: </big></b><big>"
                + txtCedula.getValue() + "</big></html>"
                + "\n<html><b><big>Monto de deuda es: </big></b><big>"
                + txtMonto.getText() + "</big></html>"
                + "\n<html><b><big>Por Concepto de: </big></b><big>"
                + concepto + "</big></html>"
                + "\n<html><b><big>De fecha nacimiento: </big></b><big>"
                + Utilidades.formatDate(dchFecha.getDate(), "dd-MM-yyyy")
                + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }
        if (nuevo) {
            if (insertDeudas(miDeuda)) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Registro de deuda Insertada!",
                        "",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Falla de registro!",
                        "",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } else {
            //TODO se debe analizar si las deudas son modificables.
        }

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
            txtCedula.requestFocusInWindow();
            return;
        }
        if (tblClientes.getRowCount() == 0) {

            return;
        }
        String idCliente = txtCedula.getText().replace("-", "").trim();

        if (idCliente.isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        String idDeuda = tblClientes.getValueAt(tblClientes.getSelectedRow(), 0).toString();
        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de Eliminar Deuda #" + idDeuda,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        cliAct = 0;
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (btnCancelar.isEnabled()) {
            txtCedula.requestFocusInWindow();
            return;
        }
        if (tblClientes.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "No existe contenido que buscar...!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String cliente = JOptionPane.showInternalInputDialog(
                this,
                "Ingrese la Cedula del Cliente: ",
                "",
                JOptionPane.PLAIN_MESSAGE
        );

        if (Objects.isNull(cliente)) {
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

    private void mostrarRegistro() {
        txtCedula.setValue("");
        if (tblClientes.getRowCount() == 0) {
            return;
        }

        txtCedula.setText(tblClientes.getValueAt(cliAct, 1).toString());
        txtNombres.setText(tblClientes.getValueAt(cliAct, 2).toString());
        txtApellidos.setText(tblClientes.getValueAt(cliAct, 3).toString());
        txtConcepto.setText(tblClientes.getValueAt(cliAct, 4).toString());
        txtMonto.setValue(Utilidades.objectToDouble(tblClientes.getValueAt(cliAct, 5)));
        dchFecha.setDate(Utilidades.objectToDate(tblClientes.getValueAt(cliAct, 6)));

        tblClientes.setRowSelectionInterval(cliAct, cliAct);
        txtCedula.setEditable(false);
    }

    private void cancelar() {
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnBuscar.setEnabled(true);
        tblClientes.setEnabled(true);

        //Caja de Texto Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnGetCliente.setEnabled(false);

        txtCedula.setEditable(false);
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtMonto.setEditable(false);
        txtConcepto.setEditable(false);

        reset('s');
    }

    private void reset(char idCliente) {
        if (idCliente == 's') {
            txtCedula.setValue("");
        }

        txtNombres.setText("");
        txtApellidos.setText("");
        txtMonto.setValue(0);
        dchFecha.setDate(new Date());
        txtConcepto.setText("");
    }

    private void nuevo() {
        //Botones Para Deshabilitar:
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnBuscar.setEnabled(false);

        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Texto Habilitado
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtMonto.setEditable(true);
        txtConcepto.setEditable(true);

        reset('n');
    }

    private void llenarTabla() {
        String titulos[] = {"Numero", "Cedula Cliente", "Primer Nombre", "Segundo Nombre",
            "Apellidos", "Concepto", "Monto", "Fecha", "Estado"};
        Object registro[] = new Object[titulos.length];
        miTabla = new DefaultTableModel(null, titulos);

        List<Deudas> deudasList = new ArrayList<>();

        deudasList.stream().forEach(x -> {
            registro[0] = x.getGenerales().getCedula();
            registro[1] = x.getPnombre();
            registro[2] = x.getSnombre();
            registro[3] = x.getApellidos();
            registro[4] = x.getConcepto();
            registro[5] = x.getMonto();
            registro[6] = x.getFecha();
            registro[7] = x.getEstado();
            miTabla.addRow(registro);
        });

        tblClientes.setModel(miTabla);

        if (miTabla.getRowCount() != 0) {//La tabla esta llena
            cliAct = 0;
            tblClientes.setRowSelectionInterval(cliAct, cliAct);
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
            txtCedula.requestFocusInWindow();
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
//                    cliAct = getDatos().numeroDeudas(estados()) - 1;
                }
                mostrarRegistro();
                break;
            case "c":
                cliAct++;
//                if (cliAct == numeroDeudas(estados())) {
//                    cliAct = 0;
//                }
                mostrarRegistro();
                break;
            case "d":
//                cliAct = getDatos().numeroDeudas(estados()) - 1;
                mostrarRegistro();
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbonar;
    private javax.swing.JButton btnAnular;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JButton btnGetCliente;
    private javax.swing.JButton btnGetTotal;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JButton btnReiniciar;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jlFoto;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
