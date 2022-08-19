package sur.softsurena.formularios;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.datos.delete.DeleteMetodos.borrarProductoPorCodigo;
import static sur.softsurena.datos.insert.InsertMetodos.agregarProducto;
import static sur.softsurena.datos.select.SelectMetodos.existeProducto;
import static sur.softsurena.datos.select.SelectMetodos.getProductos;
import static sur.softsurena.datos.update.UpdateMetodos.modificarProducto;
import sur.softsurena.entidades.Categorias;
import sur.softsurena.entidades.Celda_CheckBox;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Producto;
import sur.softsurena.entidades.Render_CheckBox;
import sur.softsurena.utilidades.Utilidades;

public class frmProductos extends javax.swing.JInternalFrame {

    private int returnVal = JFileChooser.CANCEL_OPTION;
    private boolean nuevo = false, cambio = false;
    private DefaultTableModel miTabla;
    private String path, ext, source, dest;
    private JFileChooser file = new JFileChooser();
    private final Object registro[] = new Object[11];
    private final DefaultTableCellRenderer tcr;

    public frmProductos() {

        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
        txtCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtCosto.setSelectionStart(3);
                        txtCosto.setSelectionEnd(txtCosto.getText().length());
                    }
                });
            }
        });
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtPrecio.setSelectionStart(3);
                        txtPrecio.setSelectionEnd(txtPrecio.getText().length());
                    }
                });
            }
        });
//        editor = (JTextFieldDateEditor) dchFechaVencimiento.getDateEditor();
//        button = (JButton) dchFechaVencimiento.getCalendarButton();
//        editor.setEditable(false);
//        button.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jlImagen = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JFormattedTextField();
        txtPrecio = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        cbActivo = new javax.swing.JCheckBox();
        cbImpuesto = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        btnBuscarProducto = new javax.swing.JButton();
        btnImprimirLista = new javax.swing.JButton();
        btnEntradaProducto = new javax.swing.JButton();
        btnSalidaProducto = new javax.swing.JButton();
        btnAdmCategorias = new javax.swing.JButton();
        btnSalidaProducto1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        chbFecha = new javax.swing.JCheckBox();
        chbNota = new javax.swing.JCheckBox();
        chbCategoria = new javax.swing.JCheckBox();
        chbImpuesto = new javax.swing.JCheckBox();
        chbSolo6 = new javax.swing.JCheckBox();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
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

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Navegacion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        jScrollPane3.setToolTipText("");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 4, 0));

        btnPrimero.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnPrimero.setForeground(new java.awt.Color(1, 1, 1));
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anterior 32 x 32.png"))); // NOI18N
        btnPrimero.setMnemonic('p');
        btnPrimero.setText("Primero");
        btnPrimero.setToolTipText("Va al Primer Registro");
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrimero);

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
        jPanel3.add(btnAnterior);

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
        jPanel3.add(btnSiguiente);

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
        jPanel3.add(btnUltimo);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(1, 1, 1));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(1, 1, 1));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setMnemonic('e');
        btnModificar.setText("Editar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.setMaximumSize(new java.awt.Dimension(80, 44));
        btnGuardar.setMinimumSize(new java.awt.Dimension(80, 44));
        btnGuardar.setPreferredSize(new java.awt.Dimension(80, 44));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar);

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
        jPanel4.add(btnCancelar);

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
        jPanel4.add(btnBorrar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4});

        jScrollPane3.setViewportView(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Producto"));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("* Campos Obligatorios");
        jLabel7.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Notas :");

        txtNotas.setEditable(false);
        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNotas.setForeground(new java.awt.Color(0, 0, 0));
        txtNotas.setLineWrap(true);
        txtNotas.setWrapStyleWord(true);
        txtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtNotas);

        jlImagen.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sin_imagen 64 x 64.png"))); // NOI18N
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jlImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlImagenMouseClicked(evt);
            }
        });

        jPanel7.setLayout(new java.awt.GridLayout(2, 3, 5, 0));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("*Codigo de barra:");
        jPanel7.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("*Descripcion :");
        jPanel7.add(jLabel2);

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("*Categoria :");
        jPanel7.add(jLabel12);

        txtCodigoBarra.setEditable(false);
        txtCodigoBarra.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCodigoBarra.setForeground(java.awt.SystemColor.textText);
        txtCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarraActionPerformed(evt);
            }
        });
        txtCodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyTyped(evt);
            }
        });
        jPanel7.add(txtCodigoBarra);

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDescripcion.setForeground(java.awt.SystemColor.textText);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jPanel7.add(txtDescripcion);

        cbCategoria.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCategoria.setForeground(java.awt.SystemColor.textText);
        cbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriaActionPerformed(evt);
            }
        });
        jPanel7.add(cbCategoria);

        jPanel8.setLayout(new java.awt.GridLayout(2, 3, 5, 0));

        jLabel6.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("*Costo :");
        jPanel8.add(jLabel6);

        jLabel3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("*Precio :");
        jPanel8.add(jLabel3);

        txtCosto.setEditable(false);
        txtCosto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtCosto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCosto.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });
        jPanel8.add(txtCosto);

        txtPrecio.setEditable(false);
        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });
        jPanel8.add(txtPrecio);

        jPanel9.setLayout(new java.awt.GridLayout(2, 1, 5, 0));

        cbActivo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        cbActivo.setForeground(new java.awt.Color(0, 0, 0));
        cbActivo.setText("Activo");
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });
        jPanel9.add(cbActivo);

        cbImpuesto.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        cbImpuesto.setForeground(new java.awt.Color(0, 0, 0));
        cbImpuesto.setText("Sin Impuesto");
        cbImpuesto.setToolTipText("No se esta' implementando...");
        cbImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImpuestoActionPerformed(evt);
            }
        });
        jPanel9.add(cbImpuesto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel7, jPanel8});

        jScrollPane4.setViewportView(jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnBuscarProducto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnBuscarProducto.setForeground(new java.awt.Color(1, 1, 1));
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar2 32 x 32.png"))); // NOI18N
        btnBuscarProducto.setMnemonic('r');
        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setToolTipText("Buscar el Registro");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnImprimirLista.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnImprimirLista.setForeground(new java.awt.Color(1, 1, 1));
        btnImprimirLista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Impresora.png"))); // NOI18N
        btnImprimirLista.setMnemonic('l');
        btnImprimirLista.setText("Imprimir Lista");
        btnImprimirLista.setToolTipText("Buscar el Registro");
        btnImprimirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirListaActionPerformed(evt);
            }
        });

        btnEntradaProducto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnEntradaProducto.setForeground(new java.awt.Color(1, 1, 1));
        btnEntradaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Productos 32 x 32.png"))); // NOI18N
        btnEntradaProducto.setText("Entrada");
        btnEntradaProducto.setToolTipText("Buscar el Registro");
        btnEntradaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaProductoActionPerformed(evt);
            }
        });

        btnSalidaProducto.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSalidaProducto.setForeground(new java.awt.Color(1, 1, 1));
        btnSalidaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Productos 32 x 32.png"))); // NOI18N
        btnSalidaProducto.setText("Salida");
        btnSalidaProducto.setToolTipText("Buscar el Registro");
        btnSalidaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaProductoActionPerformed(evt);
            }
        });

        btnAdmCategorias.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnAdmCategorias.setForeground(new java.awt.Color(1, 1, 1));
        btnAdmCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Categoria 32 x 32.png"))); // NOI18N
        btnAdmCategorias.setText("Categoria");
        btnAdmCategorias.setToolTipText("Buscar el Registro");
        btnAdmCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCategoriasActionPerformed(evt);
            }
        });

        btnSalidaProducto1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSalidaProducto1.setForeground(new java.awt.Color(1, 1, 1));
        btnSalidaProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Productos 32 x 32.png"))); // NOI18N
        btnSalidaProducto1.setText("Historial E/S");
        btnSalidaProducto1.setToolTipText("Buscar el Registro");
        btnSalidaProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaProducto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnImprimirLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEntradaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalidaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnAdmCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalidaProducto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnAdmCategorias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntradaProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalidaProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalidaProducto1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Columna ocultas"));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 0);
        flowLayout1.setAlignOnBaseline(true);
        jPanel6.setLayout(flowLayout1);

        buttonGroup1.add(chbFecha);
        chbFecha.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chbFecha.setText("Fecha Vencimiento");
        chbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbFechaActionPerformed(evt);
            }
        });
        jPanel6.add(chbFecha);

        buttonGroup1.add(chbNota);
        chbNota.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chbNota.setText("Nota");
        chbNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbNotaActionPerformed(evt);
            }
        });
        jPanel6.add(chbNota);

        buttonGroup1.add(chbCategoria);
        chbCategoria.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chbCategoria.setText("Categoria");
        chbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbCategoriaActionPerformed(evt);
            }
        });
        jPanel6.add(chbCategoria);

        buttonGroup1.add(chbImpuesto);
        chbImpuesto.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chbImpuesto.setText("Impuesto");
        chbImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbImpuestoActionPerformed(evt);
            }
        });
        jPanel6.add(chbImpuesto);

        buttonGroup1.add(chbSolo6);
        chbSolo6.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        chbSolo6.setSelected(true);
        chbSolo6.setText("Solo 6");
        chbSolo6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSolo6ActionPerformed(evt);
            }
        });
        jPanel6.add(chbSolo6);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalle de Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tblTabla.setAutoCreateRowSorter(true);
        tblTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N
        tblTabla.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Título 1", "Título 2", "Título 3", "Título 4", "Título 5", "Título 6", "Título 7"
            }
        ));
        tblTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTabla.setDoubleBuffered(true);
        tblTabla.setName(""); // NOI18N
        tblTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTabla.getTableHeader().setResizingAllowed(false);
        tblTabla.getTableHeader().setReorderingAllowed(false);
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        tblTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTablaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTablaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblTabla);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_txtCodigoBarraActionPerformed
    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyReleased
        String replaceAll = txtCodigoBarra.getText().replaceAll(" ", "");
        replaceAll = replaceAll.toUpperCase();
        txtCodigoBarra.setText(replaceAll);
    }//GEN-LAST:event_txtCodigoBarraKeyReleased
    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        if (!tblTabla.isEnabled() || tblTabla.getRowCount() == 0) {
            return;
        }
        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(), tblTabla.getSelectedRow());
        mostrarRegistro();
    }//GEN-LAST:event_btnPrimeroActionPerformed
    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        if (!tblTabla.isEnabled() || tblTabla.getRowCount() == 0) {
            return;
        }
        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                tblTabla.getSelectedRow());
        mostrarRegistro();
    }//GEN-LAST:event_btnUltimoActionPerformed
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (!tblTabla.isEnabled() || tblTabla.getRowCount() == 0) {
            return;
        }
        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                tblTabla.getSelectedRow());
        mostrarRegistro();
    }//GEN-LAST:event_btnAnteriorActionPerformed
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed

        if (!tblTabla.isEnabled() || tblTabla.getRowCount() == 0) {
            return;
        }

        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                tblTabla.getSelectedRow());
        mostrarRegistro();
    }//GEN-LAST:event_btnSiguienteActionPerformed
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (cbCategoria.getItemCount() == 0) {
//            getConsulta("SELECT COUNT(*) FROM TABLA_CATEGORIA")
            ResultSet rs = null;
            try {
                rs.next();
                if (rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(this,
                            "Deberia de crear una Categoria primero!!",
                            "Sin categoria en el sistema",
                            JOptionPane.INFORMATION_MESSAGE);
                    btnAdmCategoriasActionPerformed(null);
                    return;
                }
            } catch (SQLException ex) {
                //Instalar Logger
            }
        }
        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);

        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Texto Habilitado
        txtCosto.setEditable(true);
        txtDescripcion.setEditable(true);
        txtCodigoBarra.setEditable(true);
        txtNotas.setEditable(true);
        txtPrecio.setEditable(true);

        //Caja de Perfil Habilitado
        cbCategoria.setEnabled(true);

        jlImagen.setEnabled(true);
        String miFile = System.getProperty("user.dir") + "/images/Sin_imagen 64 x 64.png";
        ImageIcon imagen = new ImageIcon(miFile);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();
        jlImagen.setIcon(icon);
        jlImagen.validate();

        cbActivo.setEnabled(true);
        cbImpuesto.setEnabled(true);
        cbActivo.setSelected(false);
        cbImpuesto.setSelected(false);
        cbActivo.setText("Inactivo");
        cbImpuesto.setText("Sin Impuesto");

        //Vacear los txt
        txtCosto.setValue(0);
        txtPrecio.setValue(0);
        txtDescripcion.setText("");
        txtCodigoBarra.setText("");
        txtNotas.setText("");

        cbCategoria.setSelectedIndex(-1);

        //Activamos el Flag de registro Nuevo
        nuevo = true;
        txtCodigoBarra.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones
        if (txtCodigoBarra.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un ID");
            txtCodigoBarra.requestFocusInWindow();
            return;
        }
        if (txtDescripcion.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar una Descripcion...");
            txtDescripcion.requestFocusInWindow();
            return;
        }
        if (txtCosto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Valor en Costo");
            txtCosto.requestFocusInWindow();
            return;
        }
        if (!Utilidades.isNumercFloat(txtCosto.getValue().toString())) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Valor Numerico...");
            txtCosto.requestFocusInWindow();
            return;
        }
        if (txtPrecio.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Valor en Precio");
            txtPrecio.requestFocusInWindow();
            return;
        }
        if (!Utilidades.isNumercFloat(txtPrecio.getValue().toString())) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Valor Numerico...");
            txtPrecio.requestFocusInWindow();
            return;
        }
        if (cbCategoria.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione una categoria");
            cbCategoria.requestFocusInWindow();
            return;
        }

        // si es nuevo validamos que el Producto no exista
        if (nuevo) {
            if (existeProducto(txtCodigoBarra.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Producto ID Ya existe...");
                txtCodigoBarra.setText("");
                txtCodigoBarra.requestFocusInWindow();
                return;
            }
        }

        String miFile = System.getProperty("user.dir")
                + "/images/Sin_imagen 64 x 64.png";

        if (cambio) {
            miFile = System.getProperty("user.dir") + path + "/" + txtCodigoBarra.getText().concat(
                    "                                                 ").
                    substring(0, 35) + "." + ext;
        } else {
            String sql = "select imagepath from tabla_productos where idProducto"
                    + " like '" + txtCodigoBarra.getText() + "'";
            ResultSet rs = null;
            try {
                while (rs.next()) {
                    miFile = rs.getString("imagepath");
                }
            } catch (SQLException ex) {
                //Instalar Logger
            }
        }
        cambio = false;

        Producto p = Producto.builder().
                idCategoria(((Categorias) cbCategoria.getSelectedItem()).getId()).
                codigo(txtCodigoBarra.getText()).
                descripcion(txtDescripcion.getText()).
                estado(cbActivo.isSelected()).
                nota(txtNotas.getText()).build();

        String msg = "", accion = "editar";
        if (nuevo) {
            accion = "crear";
        }
        if (txtNotas.getText().length() >= 51) {
            msg = txtNotas.getText().substring(0, 49);
        } else {
            msg = txtNotas.getText();
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "<html><b><big>Se va a " + accion + " el Producto: </big></b><big>" + txtDescripcion.getText() + "</big></html>"
                + "\n<html><b><big>Codigo no: </big></b><big>" + txtCodigoBarra.getText() + "</big></html>"
                + "\n<html><b><big>Costo: </big></b><big>" + txtCosto.getText() + "</big></html>"
                + "\n<html><b><big>Precio: </big></b><big>" + txtPrecio.getText() + "</big></html>"
                + "\n<html><b><big>Categoria: </big></b><big>" + ((Categorias) cbCategoria.getSelectedItem()).getDescripcion() + "</big></html>"
                + "\n<html><b><big>Estado: </big></b><big>" + (cbActivo.isSelected() ? "Activo" : "Inactivo") + "</big></html>"
                + "\n<html><b><big>Impuesto al Articulo: </big></b><big>" + (cbImpuesto.isSelected() ? "Con Impuesto" : "Sin Impuesto") + "</big></html>"
                + "\n<html><b><big>Notas: </big></b><big>" + msg + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, jlImagen.getIcon());
        if (resp != 0) {
            return;
        }

        if (nuevo) {
            msg = agregarProducto(p).getMensaje();
        } else {
            msg = modificarProducto(p);
        }

        JOptionPane.showMessageDialog(rootPane, msg);

        if (msg.equals("Error al Insertar Producto...")
                || msg.equals("Error al Modificar Producto...")) {
            file = new JFileChooser();
            source = null;
            dest = null;
            cambio = false;
            returnVal = JFileChooser.CANCEL_OPTION;
            path = null;
            ext = null;
            cancelar();
            return;
        }

        if (source != null && returnVal == JFileChooser.APPROVE_OPTION) {
            Utilidades.copyFileUsingFileChannels(source, dest);
            ImageIcon imagen = new ImageIcon("" + dest);
            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                    Image.SCALE_DEFAULT));
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();
        }

        file = new JFileChooser();
        source = null;
        dest = null;
        cambio = false;
        returnVal = JFileChooser.CANCEL_OPTION;
        path = null;
        ext = null;
        cancelar();
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtCodigoBarra.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
            return;
        }
        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);
        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        //Caja de Texto Habilitado
        txtCosto.setEditable(true);
        txtDescripcion.setEditable(true);
        txtNotas.setEditable(true);
        txtPrecio.setEditable(true);
        cbCategoria.setEnabled(true);

        //Caja de Perfil Habilitado
        cbActivo.setEnabled(true);
        cbImpuesto.setEnabled(true);

        //Desactivamos el Flag de registro Nuevo
        nuevo = false;

        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtCodigoBarra.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto");
            return;
        }
        int rta = JOptionPane.showConfirmDialog(this,
                "Esta Seguro de Eliminar el Producto {"
                + txtDescripcion.getText() + "} de los Registro?",
                "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rta == 1) {
            return;
        }
        String msg;
        try {
            msg = borrarProductoPorCodigo(txtCodigoBarra.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se puede eliminar el producto porque ya ha sido facturado"
                    + "\n!!Te recomendamos cambiar el ESTADO del producto...");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, msg);

        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_btnBorrarActionPerformed
    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay producto registrado");
            return;
        }
        String producto = JOptionPane.showInputDialog("Ingrese el Codigo ID Producto...");

        if (producto == null || producto.equals("")) {
        } else {
            if (!existeProducto(producto)) {
                JOptionPane.showMessageDialog(null, "El Producto No Existe...");
                return;
            }
            //Detalle de Factura
            int num = tblTabla.getRowCount();
            for (int i = 0; i < num; i++) {
                if (tblTabla.getValueAt(i, 0).toString().equals(producto)) {
                    tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                            tblTabla.getSelectedRow());
                    break;
                }
            }
            llenarTabla();
            mostrarRegistro();
            reOrdenar(0);
            reOrdenar(0);
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        if (!tblTabla.isEnabled()) {
            return;
        }
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaMouseClicked
    private void tblTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyPressed
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaKeyPressed
    private void tblTablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyReleased
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaKeyReleased
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        cbCategoria.requestFocusInWindow();
    }//GEN-LAST:event_txtDescripcionActionPerformed
    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        txtPrecio.requestFocusInWindow();
    }//GEN-LAST:event_txtCostoActionPerformed
    private void cbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActivoActionPerformed
        if (!txtDescripcion.isEditable()) {
            cbActivo.setSelected(!cbActivo.isSelected());
            return;
        }

        if (cbActivo.isSelected()) {
            cbActivo.setText("Activo");
        } else {
            cbActivo.setText("Inactivo");
        }
    }//GEN-LAST:event_cbActivoActionPerformed
    private void cbImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbImpuestoActionPerformed
        if (!txtDescripcion.isEditable()) {
            cbImpuesto.setSelected(!cbImpuesto.isSelected());
            return;
        }
        if (cbImpuesto.isSelected()) {
            cbImpuesto.setText("Con Impuesto");
        } else {
            cbImpuesto.setText("Sin Impuesto");
        }
    }//GEN-LAST:event_cbImpuestoActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        updateCategoria();
        llenarTabla();
        mostrarRegistro();
        reOrdenar(6);
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_formInternalFrameActivated
    private void jlImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImagenMouseClicked
        if (!txtDescripcion.isEditable()) {
            return;
        }

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes", "jpg", "png", "PNG", "JPG");
        file.setFileFilter(filter);
        returnVal = file.showOpenDialog(this);
        source = file.getSelectedFile().getAbsolutePath();

        if (source == null || returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }
        cambio = true;
        path = System.getProperty("user.dir") + "/imagesProductos/" + 
                ((Categorias) cbCategoria.getSelectedItem()).getDescripcion() + "/";

        dest = System.getProperty("user.dir") + path + "/"
                + txtCodigoBarra.getText().
                        concat("                                         ").
                        substring(0, 35) + "." + getExtension(source);

        ImageIcon imagen = new ImageIcon("" + source);
        //Tamaño de icono
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();
        jlImagen.setIcon(icon);
        jlImagen.validate();
    }//GEN-LAST:event_jlImagenMouseClicked
    private void txtCodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyTyped
        if (txtCodigoBarra.getText().length() >= 35) {
            evt.consume();
            JOptionPane.showMessageDialog(this, "Este codigo debe ser menor a 35 caracteres!!!");
        }
    }//GEN-LAST:event_txtCodigoBarraKeyTyped
    private void btnImprimirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirListaActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay producto registrado");
            return;
        }

        try {
            String miFile = System.getProperty("user.dir")
                    + "/Reportes/Productos.jasper";
            JasperReport masterReporte
                    = (JasperReport) JRLoader.loadObjectFromFile(miFile);
            JasperPrint jp = JasperFillManager.fillReport(masterReporte, null,
                    getCnn());

            JasperViewer miView = new JasperViewer(jp, false);
            miView.setTitle("Lista de productos del sistema actual...");
            miView.setLocationRelativeTo(null);
            miView.setVisible(true);
        } catch (JRException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_btnImprimirListaActionPerformed
    private void btnEntradaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay producto registrado");
            return;
        }

        frmEntradaProducto miEntrada = new frmEntradaProducto(null, true);
        miEntrada.setLocationRelativeTo(null);
        miEntrada.setVisible(true);
        cancelar();
    }//GEN-LAST:event_btnEntradaProductoActionPerformed
    private void btnSalidaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No hay producto registrado");
            return;
        }
        frmSalidaProducto miSalida = new frmSalidaProducto(null, true);
        miSalida.setLocationRelativeTo(null);
        miSalida.setVisible(true);
        cancelar();
    }//GEN-LAST:event_btnSalidaProductoActionPerformed
    private void btnAdmCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCategoriasActionPerformed
        frmCategorias miCategoria = new frmCategorias(null, true);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);
        cancelar();
        updateCategoria();
    }//GEN-LAST:event_btnAdmCategoriasActionPerformed
    private void chbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbFechaActionPerformed
        reOrdenar(7);
        reOrdenar(7);
    }//GEN-LAST:event_chbFechaActionPerformed
    private void chbNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbNotaActionPerformed
        reOrdenar(6);
        reOrdenar(6);
    }//GEN-LAST:event_chbNotaActionPerformed
    private void chbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbCategoriaActionPerformed
        reOrdenar(9);
        reOrdenar(9);
    }//GEN-LAST:event_chbCategoriaActionPerformed
    private void chbImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbImpuestoActionPerformed
        reOrdenar(8);
        reOrdenar(8);
    }//GEN-LAST:event_chbImpuestoActionPerformed
    private void chbSolo6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSolo6ActionPerformed
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_chbSolo6ActionPerformed
    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        txtDescripcion.setText(txtDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcionKeyReleased
    private void txtNotasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNotasKeyReleased
        txtNotas.setText(txtNotas.getText().toUpperCase());
    }//GEN-LAST:event_txtNotasKeyReleased

    private void cbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriaActionPerformed
        if (!txtDescripcion.isEditable()) {
            return;
        }
        txtCosto.requestFocusInWindow();
    }//GEN-LAST:event_cbCategoriaActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed

    }//GEN-LAST:event_txtPrecioActionPerformed

    private void cbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCategoriaPopupMenuWillBecomeInvisible
        if (!txtDescripcion.isEditable()) {
            for (int i = 0; i < cbCategoria.getItemCount(); i++) {
                if (tblTabla.getRowCount() == 0) {
                    cbCategoria.setSelectedIndex(-1);
                    break;
                }
                if (tblTabla.getValueAt(tblTabla.getSelectedRow(), 9).
                        toString().equals(((Categorias) cbCategoria.getItemAt(i)).getDescripcion())) {
                    cbCategoria.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cbCategoriaPopupMenuWillBecomeInvisible

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        teclas(evt);
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        teclas(evt);
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void btnSalidaProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaProducto1ActionPerformed

    }//GEN-LAST:event_btnSalidaProducto1ActionPerformed
    private void teclas(java.awt.event.KeyEvent evt) {
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
    }

    private String getExtension(String s) {
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }

    private void cancelar() {
        //Botones Para habilitar:
        btnPrimero.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBuscarProducto.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        tblTabla.setEnabled(true);

        //Botones Para Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);

        //Caja de Texto Deshabitar
        txtCosto.setEditable(false);
        txtDescripcion.setEditable(false);
        txtCodigoBarra.setEditable(false);
        txtNotas.setEditable(false);
        txtPrecio.setEditable(false);

        file = new JFileChooser();
        source = null;
        dest = null;
        cambio = false;
        returnVal = JFileChooser.CANCEL_OPTION;
        path = null;
        ext = null;

        llenarTabla();
        mostrarRegistro();
        reOrdenar(0);
        reOrdenar(0);
    }

    private String llenarTabla() {
        try {
            String titulos[] = {"ID Producto", "Descripcion", "Costo", "Precio",
                "Existencia", "Estado", "Nota", "Fecha Vencimiento", "Impuesto", "Categoria"};
            tblTabla.removeAll();
            miTabla = new DefaultTableModel(null, titulos);
            ResultSet rs = getProductos();
            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("descripcion");
                registro[2] = "RD$ " + Utilidades.priceWithDecimal(rs.getDouble("COSTO"));
                registro[3] = "RD$ " + Utilidades.priceWithDecimal(rs.getDouble("PRECIO"));
                registro[4] = Utilidades.priceWithDecimal(rs.getDouble("ENTRADA"));
                registro[5] = rs.getBoolean("estado");
                registro[6] = rs.getString("nota");
                registro[7] = rs.getDate("FECHAVENCIMIENTO");
                registro[8] = rs.getBoolean("impuesto");
                registro[9] = rs.getString("Categoria");
                registro[10] = rs.getString("idCategoria");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
            return "Tabla llena.";
        } catch (SQLException ex) {
            //Instalar Logger
            return "Error llenar tabla.";
        }
    }

    private void mostrarRegistro() {
        if (tblTabla.getRowCount() < 1) {
            txtCosto.setValue(0);
            txtDescripcion.setText("");
            txtCodigoBarra.setText("");
            txtNotas.setText("");
            txtPrecio.setValue(0);
            cbActivo.setSelected(false);
            cbImpuesto.setSelected(false);
            cbCategoria.setSelectedIndex(-1);
            return;
        }

        txtCodigoBarra.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 0).toString());
        txtDescripcion.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 1).toString());
        txtCosto.setValue(Utilidades.objectToDouble(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 2)));
        txtPrecio.setValue(Utilidades.objectToDouble(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 3)));
        txtNotas.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 6).toString());
        cbActivo.setSelected((boolean) tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 5));
        cbImpuesto.setSelected((boolean) tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 8));

        String sql = "select p.IDCATEGORIA, p.IMAGEPATH "
                + "from GET_PRODUCTOS p "
                + "where idProducto like '" + txtCodigoBarra.getText() + "'";
        ResultSet rs = null;
        try {
            while (rs.next()) {
                ImageIcon imagen = new ImageIcon(rs.getString("imagepath"));
                if (imagen.getIconHeight() == -1) {
                    imagen = new ImageIcon(System.getProperty("user.dir")
                            + "/images/Sin_imagen 64 x 64.png");
                }
                Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                        Image.SCALE_DEFAULT));
                imagen.getImage().flush();
                jlImagen.setIcon(icon);
                jlImagen.validate();

                for (int i = 0; i < cbCategoria.getItemCount(); i++) {
                    if (((Categorias) cbCategoria.getItemAt(i)).getId().equals(
                            rs.getInt("idCategoria"))) {
                        cbCategoria.setSelectedIndex(i);
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private void reOrdenar(int colm) {
        if (tblTabla.getRowCount() == 0) {
            return;
        }
        TableColumn miTableColumn;
        for (int i = 0; i <= 9; i++) {
            miTableColumn = tblTabla.getColumnModel().getColumn(i);
            if (i == 0) {
                if (colm == 0) {
                    chbSolo6.setSelected(true);
                }
                miTableColumn.setPreferredWidth(120);
                miTableColumn.setMaxWidth(120);
                miTableColumn.setMinWidth(120);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(400);
                miTableColumn.setMaxWidth(400);
                miTableColumn.setMinWidth(400);
                if (colm != 0) {
                    miTableColumn.setPreferredWidth(300);
                    miTableColumn.setMaxWidth(300);
                    miTableColumn.setMinWidth(300);
                }
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMaxWidth(100);
                miTableColumn.setMinWidth(100);
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
                miTableColumn.setPreferredWidth(80);
                miTableColumn.setMaxWidth(80);
                miTableColumn.setMinWidth(80);
            }
            if (i == 6) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(00);
                miTableColumn.setMinWidth(00);
                if (colm == 6) {
                    miTableColumn.setPreferredWidth(200);
                    miTableColumn.setMaxWidth(200);
                    miTableColumn.setMinWidth(200);
                    tblTabla.repaint();
                }
            }
            if (i == 7) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 7) {
                    miTableColumn.setPreferredWidth(150);
                    miTableColumn.setMaxWidth(150);
                    miTableColumn.setMinWidth(150);
                    tblTabla.repaint();
                }
            }
            if (i == 8) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 8) {
                    miTableColumn.setPreferredWidth(100);
                    miTableColumn.setMaxWidth(100);
                    miTableColumn.setMinWidth(100);
                    tblTabla.repaint();
                }
            }
            if (i == 9) {
                miTableColumn.setPreferredWidth(0);
                miTableColumn.setMaxWidth(0);
                miTableColumn.setMinWidth(0);
                if (colm == 9) {
                    miTableColumn.setPreferredWidth(100);
                    miTableColumn.setMaxWidth(100);
                    miTableColumn.setMinWidth(100);
                    tblTabla.repaint();
                }
            }
        }
        //Para Alinear el Texto de la Table a la Derecha...

        tcr.setHorizontalAlignment(SwingConstants.RIGHT);

        tblTabla.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tblTabla.getColumnModel().getColumn(3).setCellRenderer(tcr);
        tblTabla.getColumnModel().getColumn(4).setCellRenderer(tcr);

        tblTabla.getColumnModel().getColumn(5).setCellEditor(new Celda_CheckBox());
        tblTabla.getColumnModel().getColumn(5).setCellRenderer(new Render_CheckBox());
        tblTabla.getColumnModel().getColumn(8).setCellEditor(new Celda_CheckBox());
        tblTabla.getColumnModel().getColumn(8).setCellRenderer(new Render_CheckBox());

        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                tblTabla.getSelectedRow());
    }

    private void updateCategoria() {
        //Llenando combo Box
        String sql = "";
        ResultSet rs = null;
        cbCategoria.removeAllItems();
        Categorias categorias= Categorias.builder().
                        id(-1).
                        descripcion("Seleccione categoria").build();
                cbCategoria.addItem(categorias);;
        try {
            int i = 0;
            while (rs.next()) {
                categorias = Categorias.builder().
                        id(rs.getInt("ID")).
                        descripcion(rs.getString("Descripcion")).build();
                cbCategoria.addItem(categorias);
                i++;
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }//Fin de llenando combo Box
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmCategorias;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscarProducto;
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEntradaProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimirLista;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSalidaProducto;
    private javax.swing.JButton btnSalidaProducto1;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JCheckBox cbImpuesto;
    private javax.swing.JCheckBox chbCategoria;
    private javax.swing.JCheckBox chbFecha;
    private javax.swing.JCheckBox chbImpuesto;
    private javax.swing.JCheckBox chbNota;
    private javax.swing.JCheckBox chbSolo6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JLabel jlImagen;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JFormattedTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtNotas;
    private javax.swing.JFormattedTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
