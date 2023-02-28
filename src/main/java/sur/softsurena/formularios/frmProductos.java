package sur.softsurena.formularios;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import static sur.softsurena.entidades.Productos.agregarProducto;
import static sur.softsurena.entidades.Productos.borrarProductoPorID_Codigo;
import static sur.softsurena.entidades.Productos.existeProducto;
import static sur.softsurena.entidades.Productos.getProductos;
import static sur.softsurena.entidades.Productos.modificarProducto;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmProductos extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmProductos.class.getName());

    private Boolean nuevo = null;
    private final JFileChooser file;
    private final FileNameExtensionFilter filter;
    private final DefaultTableCellRenderer tcr;
    private static final String PROCESO_DE_VALIDACION_DEL_SISTEMA = "Proceso de validacion del sistema.";
    private int fila = 0;
    private static final int SCALA_ICONO = 155;

    public frmProductos() {

        initComponents();
        jpOpciones.setVisible(false);
        file = new JFileChooser();

        filter = new FileNameExtensionFilter("Imagenes", "jpg", "png", "PNG", "JPG");
        file.setFileFilter(filter);

        tcr = new DefaultTableCellHeaderRenderer();

        cancelar(true, true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        tblTabla = new RSMaterialComponent.RSTableMetro(){
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotas = new javax.swing.JTextArea();
        jlImagenProducto = new javax.swing.JLabel();
        txtCodigoBarra = new javax.swing.JTextField();
        cbCategoria = new javax.swing.JComboBox();
        txtDescripcion = new javax.swing.JTextField();
        cbActivo = new javax.swing.JCheckBox();
        btnAgregarFoto = new newscomponents.RSButtonGradientIcon_new();
        btnEliminarFoto = new newscomponents.RSButtonGradientIcon_new();
        jpESProductos = new javax.swing.JPanel();
        jpESHistorial = new javax.swing.JPanel();
        jpOpciones = new javax.swing.JPanel();
        btnAdmCategorias = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnImprimirLista = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEntradaProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnSalidaProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnEntradaSalidaProducto = new RSMaterialComponent.RSButtonMaterialIconOne();
        jlOpcionesMostrar = new RSMaterialComponent.RSLabelIcon();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Productos");
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

        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblTabla);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
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
            .addGap(0, 832, Short.MAX_VALUE)
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

        txtNotas.setColumns(20);
        txtNotas.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNotas.setForeground(new java.awt.Color(0, 0, 0));
        txtNotas.setLineWrap(true);
        txtNotas.setWrapStyleWord(true);
        txtNotas.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota:"));
        txtNotas.setName("txtNotas"); // NOI18N
        txtNotas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNotasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtNotas);

        jlImagenProducto.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagenProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagenProducto.setToolTipText("Doble click para buscar la imagen.");
        jlImagenProducto.setBorder(javax.swing.BorderFactory.createTitledBorder("Seleccione Imagen"));
        jlImagenProducto.setName("jlImagenProducto"); // NOI18N
        jlImagenProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlImagenProductoMouseClicked(evt);
            }
        });

        txtCodigoBarra.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCodigoBarra.setForeground(java.awt.SystemColor.textText);
        txtCodigoBarra.setBorder(javax.swing.BorderFactory.createTitledBorder("*Codigo de barra"));
        txtCodigoBarra.setName("txtCodigoBarra"); // NOI18N
        txtCodigoBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoBarraActionPerformed(evt);
            }
        });
        txtCodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoBarraKeyTyped(evt);
            }
        });

        cbCategoria.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCategoria.setForeground(java.awt.SystemColor.textText);
        cbCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias"));
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
        cbCategoria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbCategoriaKeyPressed(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtDescripcion.setForeground(java.awt.SystemColor.textText);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("*Descripcion el producto"));
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        cbActivo.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        cbActivo.setForeground(new java.awt.Color(0, 0, 0));
        cbActivo.setText("Inactivo");
        cbActivo.setName("cbActivo"); // NOI18N
        cbActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActivoActionPerformed(evt);
            }
        });

        btnAgregarFoto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PHOTO_SIZE_SELECT_ACTUAL);
        btnAgregarFoto.setName("btnAgregarFoto"); // NOI18N
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });

        btnEliminarFoto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnEliminarFoto.setName("btnEliminarFoto"); // NOI18N
        btnEliminarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbActivo))
                    .addComponent(txtDescripcion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(cbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigoBarra, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnEliminarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jlImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbActivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlImagenProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout jpMantenimientoLayout = new javax.swing.GroupLayout(jpMantenimiento);
        jpMantenimiento.setLayout(jpMantenimientoLayout);
        jpMantenimientoLayout.setHorizontalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        jpMantenimientoLayout.setVerticalGroup(
            jpMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantenimientoLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jtpUnico.addTab("Mantenimiento", jpMantenimiento);

        javax.swing.GroupLayout jpESProductosLayout = new javax.swing.GroupLayout(jpESProductos);
        jpESProductos.setLayout(jpESProductosLayout);
        jpESProductosLayout.setHorizontalGroup(
            jpESProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
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
            .addGap(0, 832, Short.MAX_VALUE)
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

        btnEntradaSalidaProducto.setText("Historial E/S");
        btnEntradaSalidaProducto.setForegroundHover(new java.awt.Color(204, 0, 0));
        btnEntradaSalidaProducto.setForegroundIcon(new java.awt.Color(204, 0, 0));
        btnEntradaSalidaProducto.setForegroundIconHover(new java.awt.Color(204, 0, 0));
        btnEntradaSalidaProducto.setHideActionText(true);
        btnEntradaSalidaProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEntradaSalidaProducto.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnEntradaSalidaProducto.setIconTextGap(0);
        btnEntradaSalidaProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HISTORY);
        btnEntradaSalidaProducto.setPreferredSize(new java.awt.Dimension(100, 30));
        btnEntradaSalidaProducto.setRound(30);
        btnEntradaSalidaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradaSalidaProductoActionPerformed(evt);
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
            .addComponent(btnEntradaSalidaProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(btnEntradaSalidaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jlOpcionesMostrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_BACK);
        jlOpcionesMostrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlOpcionesMostrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtpUnico)
                    .addComponent(jScrollPane3))
                .addGap(0, 0, 0)
                .addComponent(jlOpcionesMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jlOpcionesMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void txtCodigoBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoBarraActionPerformed
        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_txtCodigoBarraActionPerformed
    private void txtCodigoBarraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyReleased
        String replaceAll = txtCodigoBarra.getText();
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
    private void jlImagenProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlImagenProductoMouseClicked


    }//GEN-LAST:event_jlImagenProductoMouseClicked
    private void txtCodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyTyped
        if (txtCodigoBarra.getText().length() >= 25) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Este codigo debe ser menor a 25 caracteres!!!");
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
        nuevo = true;

        jtpUnico.addTab("Mantenimiento", jpMantenimiento);

        cancelar(false, false);

        jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(jpMantenimiento));

        /*
            Investigamos primero si existe por lo menos una categoria registrada.
         */
        if (cbCategoria.getItemCount() <= 0) {
            updateCategoria();
            if (cbCategoria.getItemCount() <= 0) {
                JOptionPane.showInternalMessageDialog(
                        null,
                        "Debe agregar una categoria de producto al sistema",
                        PROCESO_DE_VALIDACION_DEL_SISTEMA,
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }
        }

        ImageIcon imagen = new ImageIcon("imagenes/NoImageTransp 96 x 96.png");

        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(96, 96, Image.SCALE_AREA_AVERAGING));

        imagen.getImage().flush();

        jlImagenProducto.setIcon(icon);
        jlImagenProducto.validate();

        cbActivo.setEnabled(true);
        cbActivo.setText("Activo");

        //Vacear los txt
        txtDescripcion.setText("");
        txtCodigoBarra.setText("");
        txtNotas.setText("");

        cbActivo.setSelected(false);
        cbCategoria.setSelectedIndex(0);

        txtCodigoBarra.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Validamos que exista un producto seleccionar.
        if (tblTabla.getSelectedRow() <= -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un producto",
                    PROCESO_DE_VALIDACION_DEL_SISTEMA,
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        //Guardamos la fila de producto en la tabla, he tenido que hacerlo asi,
        //porque se está la fila.
        fila = tblTabla.getSelectedRow();

        //Se actualiza el combo box de la categoria. 
        updateCategoria();

        //Pasamos false para habilitar los botones guardar y cancelar.
        cancelar(false, false);

        //Agregamos el jpMantenimiento y seleccionamos jTapPane
        jtpUnico.addTab("Mantenimiento", jpMantenimiento);

        jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(jpMantenimiento));

        //Desactivamos el Flag de registro Nuevo para realizar actualizaciones.
        nuevo = false;

        //Metodo utilizado para mostrar el registro del usuario seleccionado 
        //en la tabla. 
        mostrarRegistro();

        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

        Integer id = ((Productos) tblTabla.getValueAt(tblTabla.getSelectedRow(), 2)).getId();
        String descripcion = ((Productos) tblTabla.getValueAt(tblTabla.getSelectedRow(), 2)).getDescripcion();

        if (id == null) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un producto",
                    PROCESO_DE_VALIDACION_DEL_SISTEMA,
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int rta = JOptionPane.showConfirmDialog(
                null,
                "Esta Seguro de Eliminar el Producto {" + descripcion + "} de los Registro?",
                PROCESO_DE_VALIDACION_DEL_SISTEMA,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        String msg;
        try {
            msg = borrarProductoPorID_Codigo(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(
                    null,
                    "No se puede eliminar el producto porque ya ha sido facturado"
                    + "\n!!Te recomendamos cambiar el ESTADO del producto...",
                    "Proceso de verificación.",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        JOptionPane.showMessageDialog(
                null,
                msg
        );
        reOrdenar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
            return;
        }
        String producto = JOptionPane.showInputDialog(
                null,
                "Ingrese el Codigo ID Producto...",
                "Busqueda de producto del sistema",
                JOptionPane.QUESTION_MESSAGE);

        if (!producto.isBlank()) {
            if (!existeProducto(producto)) {
                JOptionPane.showMessageDialog(
                        null,
                        "El Producto No Existe...",
                        "Consulta de productos en el sistema.",
                        JOptionPane.INFORMATION_MESSAGE);
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
            reOrdenar();
        }
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones
        //Validamos que Codigo de barra sea proporcionado. 
        if (txtCodigoBarra.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Digitar un ID",
                    PROCESO_DE_VALIDACION_DEL_SISTEMA,
                    JOptionPane.WARNING_MESSAGE);
            txtCodigoBarra.requestFocusInWindow();
            return;
        }

        //Validamos que la descripcion sea proporcionada.
        if (txtDescripcion.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Digitar una Descripcion...",
                    PROCESO_DE_VALIDACION_DEL_SISTEMA,
                    JOptionPane.WARNING_MESSAGE);
            txtDescripcion.requestFocusInWindow();
            return;
        }

        //Validamos que sea proporcionada una categoria del producto
        if (cbCategoria.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Seleccione una categoria",
                    PROCESO_DE_VALIDACION_DEL_SISTEMA,
                    JOptionPane.WARNING_MESSAGE);
            cbCategoria.requestFocusInWindow();
            return;
        }

        // Si es nuevo validamos que el Producto no exista por su codigo de 
        //barra.
        if (nuevo) {
            if (existeProducto(txtCodigoBarra.getText())) {
                JOptionPane.showMessageDialog(null,
                        "Codigo de barra existente en el sistema",
                        PROCESO_DE_VALIDACION_DEL_SISTEMA,
                        JOptionPane.WARNING_MESSAGE
                );
                txtCodigoBarra.setText("");
                txtCodigoBarra.requestFocusInWindow();
                return;
            }
        }

        //Creando el objecto producto.
        Productos p = Productos.
                builder().
                categoria(Categorias.
                        builder().
                        id_categoria(((Categorias) cbCategoria.getSelectedItem()).getId_categoria()).
                        build()).
                codigo(txtCodigoBarra.getText()).
                descripcion(txtDescripcion.getText()).
                imagenProducto(Utilidades.imagenEncode64(file.getSelectedFile())).
                estado(cbActivo.isSelected()).
                nota(txtNotas.getText()).
                build();
        /*
         * La variable msg es llamada mensaje la cual servirá para dos cosa,
         * la primera es que para recoger la nota del producto, para mostrarlo 
         * en el proximo JOpcionPane y luego para almacenar el resultado de la
         * Operacion de insertar o actualizar el producto.
         * La variable editar es utilizada para ser utilizada en el siguiente 
         * JopcionPane para dar a conocer al usuario que hara una insersion o 
         * modificación.
         */
        String msg, accion = "editar";

        if (nuevo) {
            accion = "crear";
        }

        if (txtNotas.getText().length() >= 51) {
            msg = txtNotas.getText().substring(0, 49) + "...";
        } else {
            msg = txtNotas.getText();
        }

        int resp = JOptionPane.showConfirmDialog(null,
                "<html><b><big>Se va a " + accion + " el Producto: </big></b><big>" + txtDescripcion.getText() + "</big></html>"
                + "\n<html><b><big>Codigo no: </big></b><big>" + txtCodigoBarra.getText() + "</big></html>"
                + "\n<html><b><big>Categoria: </big></b><big>" + ((Categorias) cbCategoria.getSelectedItem()).getDescripcion() + "</big></html>"
                + "\n<html><b><big>Estado: </big></b><big>" + (cbActivo.isSelected() ? "Activo" : "Inactivo") + "</big></html>"
                + "\n<html><b><big>Notas: </big></b><big>" + msg + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                jlImagenProducto.getIcon());

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (nuevo) {
            msg = agregarProducto(p).getMensaje();
        } else {
            int id = ((Productos) tblTabla.getValueAt(tblTabla.getSelectedRow(), 2)).getId();
            msg = modificarProducto(id, p);
        }

        JOptionPane.showMessageDialog(
                null,
                msg);

        jtpUnico.remove(jpMantenimiento);
        cancelar(true, true);
    }//GEN-LAST:event_btnGuardarActionPerformed


    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar(true, true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAdmCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmCategoriasActionPerformed
        frmCategorias miCategoria = new frmCategorias(null, true);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);
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
    }//GEN-LAST:event_btnEntradaProductoActionPerformed

    private void btnSalidaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaProductoActionPerformed
        if (tblTabla.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay producto registrado");
            return;
        }
        frmSalidaProducto miSalida = new frmSalidaProducto(null, true);
        miSalida.setLocationRelativeTo(null);
        miSalida.setVisible(true);
    }//GEN-LAST:event_btnSalidaProductoActionPerformed

    private void btnEntradaSalidaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradaSalidaProductoActionPerformed

    }//GEN-LAST:event_btnEntradaSalidaProductoActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //Se llena la tabla de producto por primera vez. 
        llenarTabla();
        reOrdenar();
        updateCategoria();
    }//GEN-LAST:event_formInternalFrameOpened

    private void jlOpcionesMostrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlOpcionesMostrarMouseClicked
        if (jpOpciones.isVisible()) {
            jpOpciones.setVisible(false);
            jlOpcionesMostrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_BACK);
        } else {
            jpOpciones.setVisible(true);
            jlOpcionesMostrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_FORWARD);
        }
    }//GEN-LAST:event_jlOpcionesMostrarMouseClicked

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtDescripcion.setText(Productos.generarProducto());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtCodigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoBarraKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        txtCodigoBarra.setText(Productos.generarCodigoBarra());
                    }
                }
            }
        }
    }//GEN-LAST:event_txtCodigoBarraKeyPressed

    private void cbCategoriaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbCategoriaKeyPressed
        if (evt.isControlDown()) {
            if (evt.isAltDown()) {
                if (evt.isShiftDown()) {
                    if (evt.isAltGraphDown()) {
                        int num1 = (int) (Math.random() * cbCategoria.getItemCount());
                        cbCategoria.setSelectedIndex(num1);

                        cbActivo.setSelected(((num1 % 2) == 0));

                        StringBuilder string = new StringBuilder();
                        string.append("El producto ").
                                append(txtDescripcion.getText()).
                                append(" Con el codigo de barra ").
                                append(txtCodigoBarra.getText()).
                                append(" pertenece a la categoria de producto llamado ").
                                append(((Categorias) cbCategoria.getSelectedItem()).getDescripcion()).
                                append(" con el estado actual ").
                                append((cbActivo.isSelected() ? "Activo" : "Inactivo"));
                        
                        
                        txtNotas.setText(string.toString());

                        String file2 = null;
                        try {
                            file2 = new File("").getCanonicalPath();
                        } catch (IOException ex) {
                            Logger.getLogger(frmProductos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.println("file2 = " + file2);
                        ponerImagenProducto(file2);
                    }
                }
            }
        }
    }//GEN-LAST:event_cbCategoriaKeyPressed

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        //Abrimos un dialogo para obtener la imagen del producto.
        int respuesta = file.showOpenDialog(this);

        //Cargamos la imagen en el jlImagenProducto.
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            ponerImagenProducto(file.getSelectedFile().getAbsolutePath());

        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void btnEliminarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFotoActionPerformed

    }//GEN-LAST:event_btnEliminarFotoActionPerformed

    /**
     * Metodo utilizado para controla el comportamiento de los botones del
     * formulario.
     *
     * Dichos botones son btnNuevo, btnModificar, btnBuscarProducto, btnBorrar
     * btnGuardar, btnCancelar.
     *
     * Si este metodo es ejecutado y desea seleccionar otro JPane se debe
     * ejecutar
     * jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(NOMBRE_JPANE));
     *
     * Este metodo siempre seleccionara el jpProductos.
     *
     * @param valor
     */
    private void cancelar(boolean valor, boolean cerrar) {
        //Botones Para habilitar:
        btnNuevo.setEnabled(valor);
        btnModificar.setEnabled(valor);
        btnBuscarProducto.setEnabled(valor);
        btnBorrar.setEnabled(valor);

        //Botones Para Deshabitar
        btnGuardar.setEnabled(!valor);
        btnCancelar.setEnabled(!valor);

        if (cerrar) {
            for (Component component : jtpUnico.getComponents()) {
                if (component != jpProductos) {
                    jtpUnico.remove(component);
                }
            }
        }

        jtpUnico.setSelectedIndex(jtpUnico.indexOfComponent(jpProductos));

    }

    /**
     * Es el metodo encargado de llenar la lista de producto del sistema. Este
     * metodo es llamado por los evento que ocurren cuando se inserta actualizan
     * o elimina un producto del sistema.
     *
     * Es llamado tambien cuando el modulo de producto se abre por primera vez.
     *
     */
    public static void llenarTabla() {
        // Array de String que dan nombre a las columnas de la tabla.
        String titulos[] = {"Codigo Producto", "Categoria", "Descripcion",
            "Fecha creación", "Estado", "Nota"};

        //Limpiamos todos los registro de la tabla. 
        tblTabla.removeAll();

        //Creamos un array de objectos con la longitud de los titulos de la 
        //columnas.
        Object registro[] = new Object[titulos.length];

        //Modelo que se pasará a la tablas de productos.
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

        getProductos().stream().forEach(producto -> {
            registro[0] = producto.getCodigo();
            registro[1] = Categorias.builder().
                    id_categoria(producto.getCategoria().getId_categoria()).
                    descripcion(producto.getCategoria().getDescripcion()).build();
            registro[2] = Productos.builder().
                    id(producto.getId()).
                    descripcion(producto.getDescripcion()).build();
            registro[3] = producto.getFechaCreacion();
            registro[4] = producto.getEstado();
            registro[5] = producto.getNota();
            miTabla.addRow(registro);
        });

        tblTabla.setModel(miTabla);

        repararColumnaTable(tblTabla);

        int[] indices = {4};

        columnasCheckBox(tblTabla, indices);
    }

    /**
     * Es el metodo encargado de mostrar el modulo de mantenimiento de producto
     * o registro a actualizar.
     */
    private void mostrarRegistro() {
        //Si la tabla no cuenta con registro se envian valores por defecto.
        if (tblTabla.getRowCount() <= 0) {
            txtDescripcion.setText("");
            txtCodigoBarra.setText("");
            txtNotas.setText("");

            cbActivo.setSelected(false);
            cbCategoria.setSelectedIndex(-1);
            return;
        }

        int id = ((Productos) tblTabla.getValueAt(fila, 2)).getId();

        Productos producto = Productos.getProducto(id);

        txtCodigoBarra.setText(producto.getCodigo());

        txtDescripcion.setText(producto.getDescripcion());

        txtNotas.setText(producto.getNota());

        cbActivo.setSelected(producto.getEstado());

        ImageIcon imagen = Utilidades.imagenDecode64(producto.getImagenProducto());

        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(SCALA_ICONO, SCALA_ICONO, Image.SCALE_SMOOTH));

        imagen.getImage().flush();

        jlImagenProducto.setIcon(icon);

        for (int i = 0; i < cbCategoria.getItemCount(); i++) {
            int idCategoria = ((Categorias) cbCategoria.getItemAt(i)).getId_categoria();
            if (idCategoria == producto.getCategoria().getId_categoria()) {
                cbCategoria.setSelectedIndex(i);
            }
        }

    }

    /**
     * Metodo utilizado para modicar el ancho de cada columna del modulo
     * producto.
     */
    private void reOrdenar() {
        if (tblTabla.getRowCount() <= 0) {
            return;
        }

        TableColumn miTableColumn;
        for (int i = 0; i < tblTabla.getColumnCount(); i++) {

            miTableColumn = tblTabla.getColumnModel().getColumn(i);

            if (i == 0) {//Codigo Producto
                miTableColumn.setPreferredWidth(150);
                miTableColumn.setMaxWidth(200);
                miTableColumn.setMinWidth(120);
            }

            if (i == 1) {//Categoria
                miTableColumn.setPreferredWidth(300);
                miTableColumn.setMaxWidth(400);
                miTableColumn.setMinWidth(200);
            }

            if (i == 2) {//Descripcion 
                miTableColumn.setPreferredWidth(500);
                miTableColumn.setMaxWidth(800);
                miTableColumn.setMinWidth(100);
            }

            if (i == 3) {//Fecha de vecimiento
                miTableColumn.setPreferredWidth(200);
                miTableColumn.setMaxWidth(300);
                miTableColumn.setMinWidth(100);
            }

            if (i == 4) {//Estado del producto
                miTableColumn.setPreferredWidth(100);
                miTableColumn.setMaxWidth(100);
                miTableColumn.setMinWidth(100);
            }

            if (i == 5) {//Nota del producto.
                miTableColumn.setPreferredWidth(300);
                miTableColumn.setMaxWidth(800);
                miTableColumn.setMinWidth(100);
            }
        }
        //Para Alinear el Texto de la Table a la Derecha...

        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblTabla.getColumnModel().getColumn(3).setCellRenderer(tcr);

        int[] indices = {4};

        columnasCheckBox(tblTabla, indices);

        tblTabla.setRowSelectionInterval(fila, fila);
    }

    private void updateCategoria() {
        //Elimina registros previos.
        cbCategoria.removeAllItems();

        //Agregar primer elemento con id negativo
        //Lo agregamos al comboBox.
        cbCategoria.addItem(
                Categorias.
                        builder().
                        id_categoria(-1).
                        descripcion("Seleccione categoria").
                        build()
        );
        getCategirias().stream().forEach(categoria -> {
            cbCategoria.addItem(
                    Categorias.
                            builder().
                            id_categoria(categoria.getId_categoria()).
                            descripcion(categoria.getDescripcion()).
                            fecha_creacion(categoria.getFecha_creacion()).
                            build()
            );
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAdmCategorias;
    private newscomponents.RSButtonGradientIcon_new btnAgregarFoto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscarProducto;
    public RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnEliminarFoto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEntradaProducto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnEntradaSalidaProducto;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnImprimirLista;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnSalidaProducto;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel jlImagenProducto;
    private RSMaterialComponent.RSLabelIcon jlOpcionesMostrar;
    private javax.swing.JPanel jpCategorias;
    private javax.swing.JPanel jpESHistorial;
    private javax.swing.JPanel jpESProductos;
    private javax.swing.JPanel jpMantenimiento;
    private javax.swing.JPanel jpOpciones;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JTabbedPane jtpUnico;
    private static RSMaterialComponent.RSTableMetro tblTabla;
    private javax.swing.JTextField txtCodigoBarra;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtNotas;
    // End of variables declaration//GEN-END:variables

    private void ponerImagenProducto(String file) {
        ImageIcon imagen = new ImageIcon(file);

        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(SCALA_ICONO, SCALA_ICONO, Image.SCALE_SMOOTH));

        imagen.getImage().flush();

        jlImagenProducto.setIcon(icon);

        jlImagenProducto.validate();
    }
}
