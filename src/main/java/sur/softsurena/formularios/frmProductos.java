package sur.softsurena.formularios;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static sur.softsurena.conexion.Conexion.getCnn;
import sur.softsurena.entidades.Categorias;
import static sur.softsurena.entidades.Categorias.getCategirias;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Productos;
import static sur.softsurena.entidades.Productos.*;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmProductos extends javax.swing.JInternalFrame {

    private int returnVal = JFileChooser.CANCEL_OPTION;
    private Boolean nuevo = null, cambio = false;
    private DefaultTableModel miTabla;
    private String path, ext, source, dest;
    private JFileChooser file = new JFileChooser();
    private final DefaultTableCellRenderer tcr;

    public frmProductos() {

        initComponents();

        jpOpciones.setVisible(false);
        
        //Mantenimiento oculto por defecto. 
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpMantenimiento), false);
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpCategorias), false);
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpESHistorial), false);
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpESProductos), false);

        tcr = new DefaultTableCellHeaderRenderer();
        
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
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscarProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jtpUnico = new javax.swing.JTabbedPane();
        jpProductos = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jpCategorias = new javax.swing.JPanel();
        jpMantenimiento = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jlImagen = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        cbActivo = new javax.swing.JCheckBox();
        cbImpuesto = new javax.swing.JCheckBox();
        jpESProductos = new javax.swing.JPanel();
        jpESHistorial = new javax.swing.JPanel();
        jpOpciones = new javax.swing.JPanel();
        btnAdmCategorias = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnImprimirLista = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEntradaProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSalidaProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSalidaProducto2 = new RSMaterialComponent.RSButtonMaterialIconOne();

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
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 6, 12));

        btnNuevo.setText("Nuevo");
        btnNuevo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnNuevo.setIconTextGap(0);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.INPUT);
        btnNuevo.setMaximumSize(new java.awt.Dimension(50, 17));
        btnNuevo.setMinimumSize(new java.awt.Dimension(50, 17));
        btnNuevo.setPreferredSize(new java.awt.Dimension(100, 30));
        btnNuevo.setRound(30);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setText("Editar");
        btnModificar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModificar.setIconTextGap(0);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnModificar.setRound(30);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBorrar.setIconTextGap(0);
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnBorrar.setRound(30);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        btnBuscarProducto.setText("Buscar");
        btnBuscarProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarProducto.setIconTextGap(0);
        btnBuscarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscarProducto.setPreferredSize(new java.awt.Dimension(100, 30));
        btnBuscarProducto.setRound(30);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarProducto);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIconTextGap(0);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnGuardar.setRound(30);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCancelar.setRound(30);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);

        jScrollPane3.setViewportView(jPanel2);

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
        tblTabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTabla.setDoubleBuffered(true);
        tblTabla.setName("tblTabla"); // NOI18N
        tblTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblTabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblTabla);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jpProductosLayout = new javax.swing.GroupLayout(jpProductos);
        jpProductos.setLayout(jpProductosLayout);
        jpProductosLayout.setHorizontalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpProductosLayout.setVerticalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpUnico.addTab("Productos", jpProductos);

        javax.swing.GroupLayout jpCategoriasLayout = new javax.swing.GroupLayout(jpCategorias);
        jpCategorias.setLayout(jpCategoriasLayout);
        jpCategoriasLayout.setHorizontalGroup(
            jpCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        jpCategoriasLayout.setVerticalGroup(
            jpCategoriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jtpUnico.addTab("Categorias", jpCategorias);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle del Producto"));

        jLabel7.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel7.setText("* Campos Obligatorios");
        jLabel7.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Notas :");

        txtNotas.setEditable(false);
        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNotas.setForeground(new java.awt.Color(0, 0, 0));
        txtNotas.setLineWrap(true);
        txtNotas.setWrapStyleWord(true);
        txtNotas.setName("txtNotas"); // NOI18N
        txtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtNotas);

        jlImagen.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setToolTipText("Doble click para buscar la imagen.");
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jlImagen.setName("jlImagen"); // NOI18N
        jlImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlImagenMouseClicked(evt);
            }
        });

        txtCodigoBarra.setEditable(false);
        txtCodigoBarra.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCodigoBarra.setForeground(java.awt.SystemColor.textText);
        txtCodigoBarra.setName("txtCodigoBarra"); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("*Codigo de barra:");

        jLabel12.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("*Categoria :");

        cbCategoria.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCategoria.setForeground(java.awt.SystemColor.textText);
        cbCategoria.setEnabled(false);
        cbCategoria.setName("cbCategoria"); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("*Descripcion :");

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDescripcion.setForeground(java.awt.SystemColor.textText);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
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

        cbActivo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        cbActivo.setForeground(new java.awt.Color(0, 0, 0));
        cbActivo.setText("Inactivo");
        cbActivo.setEnabled(false);
        cbActivo.setName("cbActivo"); // NOI18N
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });

        cbImpuesto.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        cbImpuesto.setForeground(new java.awt.Color(0, 0, 0));
        cbImpuesto.setText("Sin Impuesto");
        cbImpuesto.setToolTipText("No se esta' implementando...");
        cbImpuesto.setEnabled(false);
        cbImpuesto.setName("cbImpuesto"); // NOI18N
        cbImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbImpuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtCodigoBarra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbImpuesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbActivo))
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbCategoria, jLabel1, jLabel12, txtCodigoBarra});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbActivo)
                    .addComponent(cbImpuesto))
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpUnico.addTab("Mantenimiento", jpMantenimiento);

        javax.swing.GroupLayout jpESProductosLayout = new javax.swing.GroupLayout(jpESProductos);
        jpESProductos.setLayout(jpESProductosLayout);
        jpESProductosLayout.setHorizontalGroup(
            jpESProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        jpESProductosLayout.setVerticalGroup(
            jpESProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jtpUnico.addTab("E/S Productos", jpESProductos);

        javax.swing.GroupLayout jpESHistorialLayout = new javax.swing.GroupLayout(jpESHistorial);
        jpESHistorial.setLayout(jpESHistorialLayout);
        jpESHistorialLayout.setHorizontalGroup(
            jpESHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 776, Short.MAX_VALUE)
        );
        jpESHistorialLayout.setVerticalGroup(
            jpESHistorialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 439, Short.MAX_VALUE)
        );

        jtpUnico.addTab("E/S Historial", jpESHistorial);

        jpOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        btnAdmCategorias.setText("Categoria");
        btnAdmCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAdmCategorias.setIconTextGap(0);
        btnAdmCategorias.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FORMAT_LIST_NUMBERED);
        btnAdmCategorias.setPreferredSize(new java.awt.Dimension(100, 30));
        btnAdmCategorias.setRound(30);
        btnAdmCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmCategoriasActionPerformed(evt);
            }
        });

        btnImprimirLista.setText("Impr. Listado");
        btnImprimirLista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnImprimirLista.setIconTextGap(0);
        btnImprimirLista.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirLista.setPreferredSize(new java.awt.Dimension(100, 30));
        btnImprimirLista.setRound(30);
        btnImprimirLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirListaActionPerformed(evt);
            }
        });

        btnEntradaProducto.setText("Entrada");
        btnEntradaProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntradaProducto.setIconTextGap(0);
        btnEntradaProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnEntradaProducto.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEntradaProducto.setRound(30);
        btnEntradaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaProductoActionPerformed(evt);
            }
        });

        btnSalidaProducto.setText("Salida");
        btnSalidaProducto.setForegroundHover(new java.awt.Color(204, 0, 0));
        btnSalidaProducto.setForegroundIcon(new java.awt.Color(204, 0, 0));
        btnSalidaProducto.setForegroundIconHover(new java.awt.Color(204, 0, 0));
        btnSalidaProducto.setHideActionText(true);
        btnSalidaProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalidaProducto.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSalidaProducto.setIconTextGap(0);
        btnSalidaProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SHOPPING_CART);
        btnSalidaProducto.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSalidaProducto.setRound(30);
        btnSalidaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaProductoActionPerformed(evt);
            }
        });

        btnSalidaProducto2.setText("Historial E/S");
        btnSalidaProducto2.setForegroundHover(new java.awt.Color(204, 0, 0));
        btnSalidaProducto2.setForegroundIcon(new java.awt.Color(204, 0, 0));
        btnSalidaProducto2.setForegroundIconHover(new java.awt.Color(204, 0, 0));
        btnSalidaProducto2.setHideActionText(true);
        btnSalidaProducto2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSalidaProducto2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnSalidaProducto2.setIconTextGap(0);
        btnSalidaProducto2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HISTORY);
        btnSalidaProducto2.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSalidaProducto2.setRound(30);
        btnSalidaProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaProducto2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpOpcionesLayout = new javax.swing.GroupLayout(jpOpciones);
        jpOpciones.setLayout(jpOpcionesLayout);
        jpOpcionesLayout.setHorizontalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAdmCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
            .addComponent(btnImprimirLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEntradaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalidaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSalidaProducto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpOpcionesLayout.setVerticalGroup(
            jpOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOpcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdmCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirLista, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEntradaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalidaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalidaProducto2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpUnico)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, 0)
                .addComponent(jpOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtpUnico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        cbCategoria.requestFocusInWindow();
    }//GEN-LAST:event_txtDescripcionActionPerformed
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
            cbImpuesto.setText("Con impuesto");
        } else {
            cbImpuesto.setText("Sin impuesto");
        }
    }//GEN-LAST:event_cbImpuestoActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameActivated
    private void jlImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImagenMouseClicked
        if (!txtDescripcion.isEditable()) {
            evt.consume();
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
        path = System.getProperty("user.dir") + "/imagesProductos/"
                + ((Categorias) cbCategoria.getSelectedItem()).getDescripcion() + "/";

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
            JOptionPane.showMessageDialog(null, "Este codigo debe ser menor a 35 caracteres!!!");
        }
    }//GEN-LAST:event_txtCodigoBarraKeyTyped
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
        //txtCosto.requestFocusInWindow();
    }//GEN-LAST:event_cbCategoriaActionPerformed

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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (cbCategoria.getItemCount() == 0) {
//            getConsulta("SELECT COUNT(*) FROM TABLA_CATEGORIA")
            ResultSet rs = null;
            try {
                rs.next();
                if (rs.getInt(1) == 0) {
                    JOptionPane.showMessageDialog(null,
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
        btnModificar.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);

        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);

        //Caja de Texto Habilitado
        //txtCosto.setEditable(true);
        txtDescripcion.setEditable(true);
        txtCodigoBarra.setEditable(true);
        txtNotas.setEditable(true);
        //txtPrecio.setEditable(true);

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
        cbActivo.setText("Activo");

        cbImpuesto.setEnabled(true);
        cbImpuesto.setText("Con impuesto");

        //Vacear los txt
        //txtCosto.setValue(0);
        //txtPrecio.setValue(0);
        txtDescripcion.setText("");
        txtCodigoBarra.setText("");
        txtNotas.setText("");

        cbActivo.setSelected(false);
        cbImpuesto.setSelected(false);
        cbCategoria.setSelectedIndex(-1);

        //Activamos el Flag de registro Nuevo
        nuevo = true;
        txtCodigoBarra.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tblTabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
            return;
        }
        
        updateCategoria();
        
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpMantenimiento), true);
        jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(jpMantenimiento));
        
        jtpUnico.setEnabledAt(
                jtpUnico.indexOfComponent(jpProductos), false);
        
        //Botones Para Deshabilitar:
        btnModificar.setEnabled(false);
        btnBuscarProducto.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);
        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        //Caja de Texto Habilitado
        //txtCosto.setEditable(true);
        txtDescripcion.setEditable(true);
        txtNotas.setEditable(true);
        //txtPrecio.setEditable(true);
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
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
            return;
        }
        int rta = JOptionPane.showConfirmDialog(null,
                "Esta Seguro de Eliminar el Producto {"
                + txtDescripcion.getText() + "} de los Registro?",
                "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rta == 1) {
            return;
        }
        String msg;
        try {
            msg = borrarProductoPorID_Codigo(txtCodigoBarra.getText());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el producto porque ya ha sido facturado"
                    + "\n!!Te recomendamos cambiar el ESTADO del producto...");
            return;
        }
        JOptionPane.showMessageDialog(rootPane, msg);

        //Actualizamos los cambios en la Tabla
        llenarTabla();
        reOrdenar(0);
        reOrdenar(0);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
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
            //mostrarRegistro();
            reOrdenar(0);
            reOrdenar(0);
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

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

        /*if (txtCosto.getText().equals("")) {
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
        }*/
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

        Productos p = Productos.builder().
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

        int resp = JOptionPane.showConfirmDialog(null,
                "<html><b><big>Se va a " + accion + " el Producto: </big></b><big>" + txtDescripcion.getText() + "</big></html>"
                + "\n<html><b><big>Codigo no: </big></b><big>" + txtCodigoBarra.getText() + "</big></html>"
                //+ "\n<html><b><big>Costo: </big></b><big>" + txtCosto.getText() + "</big></html>"
                //+ "\n<html><b><big>Precio: </big></b><big>" + txtPrecio.getText() + "</big></html>"
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdmCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCategoriasActionPerformed
        frmCategorias miCategoria = new frmCategorias(null, true);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);
        cancelar();
        updateCategoria();
    }//GEN-LAST:event_btnAdmCategoriasActionPerformed

    private void btnImprimirListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirListaActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
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
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
            return;
        }

        frmEntradaProducto miEntrada = new frmEntradaProducto(null, true);
        miEntrada.setLocationRelativeTo(null);
        miEntrada.setVisible(true);
        cancelar();
    }//GEN-LAST:event_btnEntradaProductoActionPerformed

    private void btnSalidaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
            return;
        }
        frmSalidaProducto miSalida = new frmSalidaProducto(null, true);
        miSalida.setLocationRelativeTo(null);
        miSalida.setVisible(true);
        cancelar();
    }//GEN-LAST:event_btnSalidaProductoActionPerformed

    private void btnSalidaProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaProducto2ActionPerformed

    }//GEN-LAST:event_btnSalidaProducto2ActionPerformed
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
        btnModificar.setEnabled(true);
        btnBuscarProducto.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        tblTabla.setEnabled(true);

        //Botones Para Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);

        //Caja de Texto Deshabitar
        txtDescripcion.setEditable(false);
        txtCodigoBarra.setEditable(false);
        txtNotas.setEditable(false);

        file = new JFileChooser();
        source = null;
        dest = null;
        cambio = false;
        returnVal = JFileChooser.CANCEL_OPTION;
        path = null;
        ext = null;
        nuevo = null;

        llenarTabla();
        mostrarRegistro();
        reOrdenar(0);
        reOrdenar(0);
    }

    private void llenarTabla() {
        String titulos[] = {"Codigo Producto", "Categoria", "Descripcion",
            "Fecha creación", "Estado","Nota"};
        tblTabla.removeAll();

        Object registro[] = new Object[titulos.length];

        miTabla = new DefaultTableModel(null, titulos);
        
        Categorias cat = null;
        Productos prod = null;
        
        for (Productos producto : getProductos()) {

            cat = Categorias.builder().
                    id(producto.getIdCategoria()).
                    descripcion(producto.getDesc_categoria()).build();
            
            prod = Productos.builder().
                    id(producto.getId()).
                    descripcion(producto.getDescripcion()).build();
            
            registro[0] = producto.getCodigo();
            registro[1] = cat;
            registro[2] = prod;
            registro[3] = producto.getFechaCreacion();
            registro[4] = producto.getEstado();
            registro[5] = producto.getNota();
            miTabla.addRow(registro);
        }

        tblTabla.setModel(miTabla);
        repararColumnaTable(tblTabla);
        int[] indices = {4};
        columnasCheckBox(tblTabla, indices);
    }

    private void mostrarRegistro() {
        //Si la tabla no cuenta con registro se envian valores por defecto.
        if (tblTabla.getRowCount() <= 0) {
            txtDescripcion.setText("");
            txtCodigoBarra.setText("");
            txtNotas.setText("");

            cbActivo.setSelected(false);
            cbImpuesto.setSelected(false);
            cbCategoria.setSelectedIndex(-1);
            return;
        }

        txtCodigoBarra.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 0).toString());
        
        txtDescripcion.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 1).toString());
        
        txtNotas.setText(tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 6).toString());
        
        cbActivo.setSelected((Boolean) tblTabla.getValueAt(
                tblTabla.getSelectedRow(), 5));
        
        cbImpuesto.setSelected((Boolean) tblTabla.getValueAt(
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

        int[] indices = {5, 8};
        columnasCheckBox(tblTabla, indices);

        tblTabla.setRowSelectionInterval(tblTabla.getSelectedRow(),
                tblTabla.getSelectedRow());
    }

    private void updateCategoria() {
        getCategirias(cbCategoria);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAdmCategorias;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscarProducto;
    public RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEntradaProducto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirLista;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalidaProducto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalidaProducto2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JCheckBox cbImpuesto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlImagen;
    private javax.swing.JPanel jpCategorias;
    private javax.swing.JPanel jpESHistorial;
    private javax.swing.JPanel jpESProductos;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpOpciones;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JTabbedPane jtpUnico;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtNotas;
    // End of variables declaration//GEN-END:variables
}
