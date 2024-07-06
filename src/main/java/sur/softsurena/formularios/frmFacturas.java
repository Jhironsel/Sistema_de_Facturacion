package sur.softsurena.formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Categoria;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.entidades.D_Factura;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.Turno;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.formularios.frmPrincipal.mnuMovimientosNuevaFactura;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.Imagenes;
import static sur.softsurena.metodos.M_Categoria.getCategoriaActivas;
import static sur.softsurena.metodos.M_Categoria.getCategorias;
import static sur.softsurena.metodos.M_Producto.existeProducto;
import static sur.softsurena.metodos.M_Producto.getProductosByCategoria;
import static sur.softsurena.metodos.M_Turno.turnosActivoByUsuario;
import static sur.softsurena.metodos.M_Usuario.getUsuarioActual;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;
import static sur.softsurena.utilidades.Utilidades.imagenDecode64;

public final class frmFacturas extends javax.swing.JInternalFrame implements ActionListener {

    private final Usuario usuario;

    private Integer idCliente;

    private String nombreCliente = "";

    private JButton btn, boton;

    private Factura factura;

    private final String titulos[] = {"Cantidad", "Descripcion", "Montos"};
    
    private DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

    private final Object[] registro = new Object[3];

    private final Properties propiedad;

    private final DefaultTableCellRenderer tcr;

    private List<D_Factura> detalleFacturaList;

    private static Turno turno;

    private Properties getPropiedad() {
        return propiedad;
    }

    private void setPropiedad() {
        File file = new File("target/classes/sur/softsurena/properties/proFacturas.prop");
        try (InputStream is = new FileInputStream(file);) {
            getPropiedad().load(is);
        } catch (FileNotFoundException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ARCHIVO_PRO_FACTURASPROP_NO_HA_SIDO_ENCONT, 
                    ex
            );
        } catch (IOException ex) {
            LOG.log(
                    Level.SEVERE, 
                    ERROR_AL_CARGAR_EL_ARCHIVOS_DE_PROPIEDADE, 
                    ex
            );
        }
    }
    public static final String ERROR_AL_CARGAR_EL_ARCHIVOS_DE_PROPIEDADE 
            = "Error al cargar el archivos de propiedades proFacturas.prop";
    public static final String ARCHIVO_PRO_FACTURASPROP_NO_HA_SIDO_ENCONT 
            = "Archivo proFacturas.prop no ha sido encontrado.";

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public static frmFacturas getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {
        private static final frmFacturas INSTANCE = new frmFacturas();
    }

    private frmFacturas() {
        initComponents();

        usuario = getUsuarioActual();

        turno = turnosActivoByUsuario(usuario.getUser_name());

        txtCriterio.requestFocusInWindow();

        tcr = new DefaultTableCellHeaderRenderer();

        propiedad = new Properties();
        setPropiedad();

        btnGrupoPago.add(rbtContado);
        btnGrupoPago.add(rbtCredito);

        Utilidades.clickOnKey(btnPonerTemporal, "temporar", KeyEvent.VK_F5);
        Utilidades.clickOnKey(btnBuscarTemporal, "temporarBuscar", KeyEvent.VK_F6);
        Utilidades.clickOnKey(btnGastos, "gastos", KeyEvent.VK_F7);
        Utilidades.clickOnKey(btnPagoDeuda, "pagoDeuda", KeyEvent.VK_F8);
        Utilidades.clickOnKey(btnImpresionUltima, "impresionUltima", KeyEvent.VK_F9);
        Utilidades.clickOnKey(btnGrabar, "factura", KeyEvent.VK_F10);
        Utilidades.clickOnKey(btnLimpiarF12, "cancelar", KeyEvent.VK_F12);

        jlAlmacen.setIcon(new Imagenes("Almacen 32 x 32.png").getIcono());

        categoriaR();

    }//Metodo Constructor...

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoPago = new javax.swing.ButtonGroup();
        rSMenuBar2 = new rojerusan.RSMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jpInfoFactura = new javax.swing.JPanel();
        jlFacturaNo = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        txtTurno = new javax.swing.JTextField();
        jlAlmacen = new rojeru_san.rslabel.RSLabelAnimated();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnPonerTemporal = new newscomponents.RSButtonGradientIcon_new();
        btnBuscarTemporal = new newscomponents.RSButtonGradientIcon_new();
        btnGastos = new newscomponents.RSButtonGradientIcon_new();
        btnPagoDeuda = new newscomponents.RSButtonGradientIcon_new();
        btnImpresionUltima = new newscomponents.RSButtonGradientIcon_new();
        btnGrabar = new newscomponents.RSButtonGradientIcon_new();
        btnLimpiarF12 = new newscomponents.RSButtonGradientIcon_new();
        jPanel6 = new javax.swing.JPanel();
        cbTodos = new javax.swing.JCheckBox();
        cbTodosProductos = new javax.swing.JCheckBox();
        cbPrevista = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jpFacturas = new javax.swing.JPanel();
        jpCliente = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtContado = new javax.swing.JRadioButton();
        rbtCredito = new javax.swing.JRadioButton();
        btnBuscarCliente = new newscomponents.RSButtonGradientIcon_new();
        cmbCliente = new javax.swing.JComboBox();
        jPanel14 = new javax.swing.JPanel();
        JlCantidad1 = new javax.swing.JLabel();
        JlCantidad2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalCantidad = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotalValor = new javax.swing.JFormattedTextField();
        jPanel10 = new javax.swing.JPanel();
        jpCategoria = new javax.swing.JPanel();
        jpBusqueda = new javax.swing.JPanel();
        txtCriterio = new javax.swing.JTextField();
        cbCriterio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jpProductos = new javax.swing.JPanel();

        jMenu3.setText("File");
        rSMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        rSMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        jpInfoFactura.setMinimumSize(new java.awt.Dimension(0, 35));
        jpInfoFactura.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jlFacturaNo.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlFacturaNo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlFacturaNo.setText("Fact. no.:");
        jlFacturaNo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlFacturaNo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jlFacturaNo.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpInfoFactura.add(jlFacturaNo);

        txtIdFactura.setEditable(false);
        txtIdFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtIdFactura.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdFactura.setAutoscrolls(false);
        txtIdFactura.setDoubleBuffered(true);
        txtIdFactura.setFocusCycleRoot(true);
        txtIdFactura.setFocusTraversalPolicyProvider(true);
        txtIdFactura.setName(""); // NOI18N
        jpInfoFactura.add(txtIdFactura);

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtTurno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTurno.setAutoscrolls(false);
        txtTurno.setDoubleBuffered(true);
        txtTurno.setFocusCycleRoot(true);
        txtTurno.setFocusTraversalPolicyProvider(true);
        jpInfoFactura.add(txtTurno);

        jlAlmacen.setToolTipText("Indica que el cajero actual, esta realizando facturas desde este almacen.");
        jlAlmacen.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jlAlmacen.setMaximumSize(new java.awt.Dimension(500, 40));
        jlAlmacen.setMinimumSize(new java.awt.Dimension(100, 40));
        jlAlmacen.setPreferredSize(new java.awt.Dimension(400, 40));
        jpInfoFactura.add(jlAlmacen);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion Sophia & Sophie");
        setToolTipText("");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameDeiconified(evt);
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameIconified(evt);
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel5.setAutoscrolls(true);
        jPanel5.setMinimumSize(new java.awt.Dimension(250, 68));
        jPanel5.setLayout(new java.awt.GridLayout(1, 7, 3, 3));

        btnPonerTemporal.setText("<html><center>Getion<br>Temporal F5</center></html>");
        btnPonerTemporal.setToolTipText("<html><center>Temporal<br>F5</center></html>");
        btnPonerTemporal.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPonerTemporal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPonerTemporal.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.HOURGLASS_FULL);
        btnPonerTemporal.setName("btnTemporal"); // NOI18N
        btnPonerTemporal.setRound(30);
        btnPonerTemporal.setSizeIcon(40.0F);
        btnPonerTemporal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPonerTemporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPonerTemporalActionPerformed(evt);
            }
        });
        jPanel5.add(btnPonerTemporal);

        btnBuscarTemporal.setText("<html><center>Buscar<br>Temporal F6</center></html>");
        btnBuscarTemporal.setToolTipText("<html><center>Temporal<br>F6</center></html>");
        btnBuscarTemporal.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBuscarTemporal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarTemporal.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
        btnBuscarTemporal.setName("btnTemporal"); // NOI18N
        btnBuscarTemporal.setRound(30);
        btnBuscarTemporal.setSizeIcon(40.0F);
        btnBuscarTemporal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarTemporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarTemporalActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarTemporal);

        btnGastos.setText("<html><center>Gestion<br>Gastos F7</center></html>");
        btnGastos.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnGastos.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnGastos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGastos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCAL_ATM);
        btnGastos.setName("btnTemporal"); // NOI18N
        btnGastos.setRound(30);
        btnGastos.setSizeIcon(40.0F);
        btnGastos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });
        jPanel5.add(btnGastos);

        btnPagoDeuda.setText("<html><center>Gestion<br>Deudas F8</center></html>");
        btnPagoDeuda.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnPagoDeuda.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnPagoDeuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagoDeuda.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ATTACH_MONEY);
        btnPagoDeuda.setName("btnTemporal"); // NOI18N
        btnPagoDeuda.setRound(30);
        btnPagoDeuda.setSizeIcon(40.0F);
        btnPagoDeuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagoDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoDeudaActionPerformed(evt);
            }
        });
        jPanel5.add(btnPagoDeuda);

        btnImpresionUltima.setText("<html><center>Ultimas<br>Facturas F9</center></html>");
        btnImpresionUltima.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnImpresionUltima.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnImpresionUltima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImpresionUltima.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.YOUTUBE_SEARCHED_FOR);
        btnImpresionUltima.setName("btnTemporal"); // NOI18N
        btnImpresionUltima.setRound(30);
        btnImpresionUltima.setSizeIcon(40.0F);
        btnImpresionUltima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImpresionUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpresionUltimaActionPerformed(evt);
            }
        });
        jPanel5.add(btnImpresionUltima);

        btnGrabar.setText("<html>\n<center>\nTerminar<br>\nF10\n</center>\n</html>");
        btnGrabar.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnGrabar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnGrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrabar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE_ALL);
        btnGrabar.setName("btnTemporal"); // NOI18N
        btnGrabar.setRound(30);
        btnGrabar.setSizeIcon(40.0F);
        btnGrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGrabar);

        btnLimpiarF12.setText("<html>\n<center>\nLimpiar<br>\nF12\n</center>\n</html>");
        btnLimpiarF12.setToolTipText("<html><center>Gasto<br>F7</center></html>");
        btnLimpiarF12.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnLimpiarF12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiarF12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLEAR_ALL);
        btnLimpiarF12.setName("btnTemporal"); // NOI18N
        btnLimpiarF12.setRound(30);
        btnLimpiarF12.setSizeIcon(40.0F);
        btnLimpiarF12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiarF12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarF12ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiarF12);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));
        jPanel6.setAutoscrolls(true);
        jPanel6.setMinimumSize(new java.awt.Dimension(0, 54));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        cbTodos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbTodos.setText("Todas las Categorias");
        cbTodos.setBorder(null);
        cbTodos.setFocusPainted(false);
        cbTodos.setFocusable(false);
        cbTodos.setMinimumSize(new java.awt.Dimension(0, 16));
        cbTodos.setPreferredSize(new java.awt.Dimension(0, 16));
        cbTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTodosMouseClicked(evt);
            }
        });
        jPanel6.add(cbTodos);

        cbTodosProductos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbTodosProductos.setText("Todos los Productos");
        cbTodosProductos.setBorder(null);
        cbTodosProductos.setFocusPainted(false);
        cbTodosProductos.setFocusable(false);
        cbTodosProductos.setMinimumSize(new java.awt.Dimension(0, 16));
        cbTodosProductos.setPreferredSize(new java.awt.Dimension(0, 16));
        cbTodosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosProductosActionPerformed(evt);
            }
        });
        jPanel6.add(cbTodosProductos);

        cbPrevista.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbPrevista.setSelected(true);
        cbPrevista.setText("Prevista");
        cbPrevista.setBorder(null);
        cbPrevista.setMinimumSize(new java.awt.Dimension(0, 16));
        cbPrevista.setPreferredSize(new java.awt.Dimension(0, 16));
        jPanel6.add(cbPrevista);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(381, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(381, 100));

        jpCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jpCliente.setAlignmentX(0.0F);
        jpCliente.setAlignmentY(0.0F);
        jpCliente.setMinimumSize(new java.awt.Dimension(265, 135));
        jpCliente.setPreferredSize(new java.awt.Dimension(265, 135));
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(10);
        jpCliente.setLayout(verticalLayout1);

        jPanel9.setMaximumSize(new java.awt.Dimension(153, 100));
        jPanel9.setMinimumSize(new java.awt.Dimension(153, 50));
        jPanel9.setName(""); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(153, 50));
        jPanel9.setLayout(new org.jdesktop.swingx.HorizontalLayout());

        jPanel4.setMinimumSize(new java.awt.Dimension(32767, 32767));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(300, 10));
        jPanel4.setLayout(new org.jdesktop.swingx.VerticalLayout());

        btnGrupoPago.add(rbtContado);
        rbtContado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtContado.setSelected(true);
        rbtContado.setText("Contado");
        rbtContado.setBorder(null);
        rbtContado.setFocusPainted(false);
        rbtContado.setFocusable(false);
        rbtContado.setMaximumSize(new java.awt.Dimension(363, 26));
        rbtContado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtContadoActionPerformed(evt);
            }
        });
        jPanel4.add(rbtContado);

        btnGrupoPago.add(rbtCredito);
        rbtCredito.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtCredito.setText("Credito");
        rbtCredito.setBorder(null);
        rbtCredito.setFocusPainted(false);
        rbtCredito.setFocusable(false);
        rbtCredito.setMaximumSize(new java.awt.Dimension(363, 26));
        rbtCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtCreditoActionPerformed(evt);
            }
        });
        jPanel4.add(rbtCredito);

        jPanel9.add(jPanel4);

        btnBuscarCliente.setText("Clientes");
        btnBuscarCliente.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBuscarCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscarCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PEOPLE);
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(150, 40));
        btnBuscarCliente.setRound(30);
        btnBuscarCliente.setSizeIcon(40.0F);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        jPanel9.add(btnBuscarCliente);

        jpCliente.add(jPanel9);

        cmbCliente.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        cmbCliente.setForeground(new java.awt.Color(0, 0, 255));
        cmbCliente.setEnabled(false);
        cmbCliente.setLightWeightPopupEnabled(false);
        cmbCliente.setMaximumSize(new java.awt.Dimension(363, 26));
        cmbCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClienteItemStateChanged(evt);
            }
        });
        cmbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClienteActionPerformed(evt);
            }
        });
        jpCliente.add(cmbCliente);

        org.jdesktop.swingx.HorizontalLayout horizontalLayout1 = new org.jdesktop.swingx.HorizontalLayout();
        horizontalLayout1.setGap(20);
        jPanel14.setLayout(horizontalLayout1);

        JlCantidad1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        JlCantidad1.setText("w");
        JlCantidad1.setToolTipText("");
        JlCantidad1.setMaximumSize(new java.awt.Dimension(360, 24));
        jPanel14.add(JlCantidad1);

        JlCantidad2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        JlCantidad2.setText("w");
        JlCantidad2.setToolTipText("");
        JlCantidad2.setMaximumSize(new java.awt.Dimension(360, 26));
        jPanel14.add(JlCantidad2);

        jpCliente.add(jPanel14);

        jScrollPane5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane5.setMaximumSize(new java.awt.Dimension(452, 300));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(452, 200));

        tblDetalle.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblDetalle);

        jPanel3.setLayout(new java.awt.GridLayout(3, 2, 2, 6));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cantidad:");
        jPanel3.add(jLabel5);

        txtTotalCantidad.setEditable(false);
        txtTotalCantidad.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTotalCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtTotalCantidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalCantidad.setToolTipText("Total Neto de la factura actual");
        txtTotalCantidad.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jPanel3.add(txtTotalCantidad);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Precio:");
        jPanel3.add(jLabel7);

        txtPrecio.setEditable(false);
        txtPrecio.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtPrecio.setToolTipText("Precio del articulo seleccionado");
        txtPrecio.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jPanel3.add(txtPrecio);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Total Neto:");
        jPanel3.add(jLabel6);

        txtTotalValor.setEditable(false);
        txtTotalValor.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        txtTotalValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtTotalValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalValor.setToolTipText("Total Neto de la factura actual");
        txtTotalValor.setFont(new java.awt.Font("Ubuntu", 1, 20)); // NOI18N
        jPanel3.add(txtTotalValor);

        javax.swing.GroupLayout jpFacturasLayout = new javax.swing.GroupLayout(jpFacturas);
        jpFacturas.setLayout(jpFacturasLayout);
        jpFacturasLayout.setHorizontalGroup(
            jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturasLayout.createSequentialGroup()
                .addGroup(jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addComponent(jpCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jpFacturasLayout.setVerticalGroup(
            jpFacturasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFacturasLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
        jpCategoria.setAutoscrolls(true);
        jpCategoria.setMinimumSize(new java.awt.Dimension(0, 32));

        jpBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones de busqueda"));
        jpBusqueda.setMinimumSize(new java.awt.Dimension(0, 45));
        jpBusqueda.setPreferredSize(new java.awt.Dimension(360, 45));
        java.awt.FlowLayout flowLayout5 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0);
        flowLayout5.setAlignOnBaseline(true);
        jpBusqueda.setLayout(flowLayout5);

        txtCriterio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCriterio.setAutoscrolls(false);
        txtCriterio.setBorder(null);
        txtCriterio.setDoubleBuffered(true);
        txtCriterio.setFocusCycleRoot(true);
        txtCriterio.setFocusTraversalPolicy(null);
        txtCriterio.setFocusTraversalPolicyProvider(true);
        txtCriterio.setMinimumSize(new java.awt.Dimension(0, 25));
        txtCriterio.setPreferredSize(new java.awt.Dimension(300, 25));
        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        jpBusqueda.add(txtCriterio);

        cbCriterio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Opcion Busqueda", "Codigo", "Descripcion", "En Detalle" }));
        cbCriterio.setSelectedIndex(1);
        cbCriterio.setFocusable(false);
        cbCriterio.setMinimumSize(new java.awt.Dimension(150, 25));
        cbCriterio.setPreferredSize(new java.awt.Dimension(160, 25));
        jpBusqueda.add(cbCriterio);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setText("\",\" Codigo \".\" Descripcion \"-\" Detalle Factura");
        jLabel4.setMinimumSize(new java.awt.Dimension(0, 16));
        jpBusqueda.add(jLabel4);

        jpProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14))); // NOI18N
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        jpProductos.setLayout(flowLayout1);
        jScrollPane4.setViewportView(jpProductos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                    .addComponent(jpCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jpFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpFacturas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        jScrollPane3.setViewportView(jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        turno = turnosActivoByUsuario(usuario.getUser_name());
        txtTurno.setText("Turno: " + turno.getId());
        jlAlmacen.setText("Almacen: " + turno.getAlmacen().getNombre());
        txtIdFactura.setText(turno.getFactura().getId().toString());
        txtCriterio.requestFocusInWindow();
    }//GEN-LAST:event_formInternalFrameActivated

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        //Cambio de tipo de criterio del comboBox
        if (txtCriterio.getText().trim().equals(",")) {
            cbCriterio.setSelectedIndex(1);
            txtCriterio.setText("");
            return;
        }

        if (txtCriterio.getText().trim().equals(".")) {
            cbCriterio.setSelectedIndex(2);
            txtCriterio.setText("");
            return;
        }

        if (txtCriterio.getText().trim().equals("-")) {
            cbCriterio.setSelectedIndex(3);
            txtCriterio.setText("");
            return;
        }

        if (cbCriterio.getSelectedIndex() == 0) {
            jpProductos.removeAll();
            jpProductos.repaint();
            jpProductos.setLayout(new FlowLayout());
            return;
        }

        String sql = "select Id, Codigo, Descripcion, imagePath "
                + "from TABLA_PRODUCTOS ";

        if (cbCriterio.getSelectedIndex() == 1 || cbCriterio.getSelectedIndex() == 2) {

            if (cbCriterio.getSelectedIndex() == 1) {
                sql = "where Codigo = '" + txtCriterio.getText().trim() + "'";
            }

            if (cbCriterio.getSelectedIndex() == 2) {
                sql = "where Descripcion CONTAINING '" + txtCriterio.getText().trim() + "'";
            }

//            ResultSet rs = getConsulta(sql);
            ResultSet rs = null;

            jpProductos.removeAll();
            jpProductos.repaint();
            jpProductos.setLayout(new FlowLayout());

            //TODO Crear la consulta que trae los productos que cumpla los crterios.
            try {
                while (rs.next()) {
                    boton = new JButton(rs.getString("Descripcion").concat("                   ").substring(0, 17));
                    boton.setToolTipText(rs.getString("IdProducto"));
                    boton.setMnemonic('p');

                    String im = "";

                    if (rs.getString("imagepath") != null) {
                        im = rs.getString("imagepath");
                    }

                    ImageIcon imagen = new ImageIcon(im);

                    if (imagen.getIconHeight() == -1) {
                        imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
                    }
                    Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(
                            64,
                            64,
                            Image.SCALE_DEFAULT));
                    imagen.getImage().flush();

                    boton.setIcon(icon);

                    boton.addActionListener(this);

                    boton.setIconTextGap(2);
                    boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
                    boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
                    boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

                    int ancho = 170, alto = 100;

                    boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
                    boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
                    boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

                    boton.setLayout(new BorderLayout(8, 8));
                    boton.requestFocusInWindow();
                    jpProductos.add(boton);
                    jpProductos.repaint();
                    jpProductos.validate();
                    boton.requestFocusInWindow();
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error al cargar los productos.", ex);
            }
        }

        if (cbCriterio.getSelectedIndex() == 3) {
            
            if (txtCriterio.getText().isBlank()) {
                return;
            }
            
            if (!existeProducto(txtCriterio.getText().trim())) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "El Producto No Existe...",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );

                txtCriterio.setText("");
                return;
            }
            //Detalle de Factura
            int num = tblDetalle.getRowCount();
            if (num == 0) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "No existe producto en detalle!!!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtCriterio.setText("");
                return;
            }
            boolean dime = true;
            for (int i = 0; i < num; i++) {
                //TODO Esto no tiene sentido.
                if (factura.getId().equals(txtCriterio.getText().trim())) {
                    tblDetalle.setRowSelectionInterval(i, i);
                    dime = false;
                    txtCriterio.setText("");
                    break;
                }
            }

            if (dime) {
                txtCriterio.setText("");
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Producto no encontrado",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }//GEN-LAST:event_txtCriterioActionPerformed
    private void rbtCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCreditoActionPerformed

        if (evt == null) {
            rbtCredito.doClick();
        }

        //Si la venta sera a credito, debe seleccionarse un cliente.
        cmbCliente.setEnabled(true);

        //Se habilita el boton que permite obtener los clientes.
        btnBuscarCliente.setEnabled(true);

        //Se seleccionan el primero Item del comboBox.
        if (cmbCliente.getItemCount() > 0) {
            cmbCliente.setSelectedIndex(0);
        }
    }//GEN-LAST:event_rbtCreditoActionPerformed

    private void rbtContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtContadoActionPerformed

        if (evt == null) {
            rbtContado.doClick();
        }

        cmbCliente.setEnabled(false);

        if (cmbCliente.getItemCount() > 0) {
            cmbCliente.setSelectedIndex(0);
        }

        JlCantidad1.setText("Limt Cred.:$0.00");
        JlCantidad2.setText("Deud Actu.:$0.00");
    }//GEN-LAST:event_rbtContadoActionPerformed

    private void cbTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosProductosActionPerformed
        jpProductos = new javax.swing.JPanel();

        jpProductos.setAutoscrolls(true);

        jpProductos.setBackground(new java.awt.Color(255, 102, 51));

        jpProductos.setBorder(
                javax.swing.BorderFactory.createTitledBorder(
                        null,
                        "Productos",
                        javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION,
                        new java.awt.Font(
                                "Ubuntu",
                                0,
                                14
                        )
                )
        );

        jpProductos.setMaximumSize(new java.awt.Dimension(350, 1500));

        jpProductos.setMinimumSize(new java.awt.Dimension(350, 1500));

        jpProductos.setPreferredSize(new java.awt.Dimension(350, 1500));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();

        flowLayout1.setAlignOnBaseline(true);

        jpProductos.setLayout(flowLayout1);

        jScrollPane4.setViewportView(jpProductos);

        actionPerformed(evt);
    }//GEN-LAST:event_cbTodosProductosActionPerformed
    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        precio();
    }//GEN-LAST:event_tblDetalleMouseClicked


    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        getClientesCombo();
//        txtIdFactura.setText("" + getNumFac(getIdUsuario(), getTurno()));
        repararRegistro();
        totales();

        formInternalFrameDeiconified(evt);
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (tblDetalle.getRowCount() != 0) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Existe una factura, Desea Salir?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.YES_OPTION) {
                dispose();
            }
        } else {
            dispose();
        }
        formInternalFrameIconified(evt);
    }//GEN-LAST:event_formInternalFrameClosing

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        if (!cmbCliente.isEnabled()) {
            return;
        }
        //TODO Analizar el siguiente metodo para ser descomentado.
//        estadoCliente();
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        if (cmbCliente.getSelectedIndex() == 0) {
            JlCantidad1.setVisible(false);
            JlCantidad2.setVisible(false);
            jpCliente.setSize(265, 86);
            jpCliente.setPreferredSize(new Dimension(265, 86));
            jpCliente.setMinimumSize(new Dimension(265, 86));
            jpCliente.setMaximumSize(new Dimension(265, 86));

        } else {
            JlCantidad1.setVisible(true);
            JlCantidad2.setVisible(true);
            jpCliente.setSize(265, 135);
            jpCliente.setPreferredSize(new Dimension(265, 135));
            jpCliente.setMinimumSize(new Dimension(265, 135));
            jpCliente.setMaximumSize(new Dimension(265, 135));
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged

    private void btnPonerTemporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPonerTemporalActionPerformed
        if (tblDetalle.getRowCount() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Factura Vacia...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (factura.getDetalleFactura().get(0) == null) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Ha ocurrido un error de factura realice de nuevo...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (cmbCliente.getSelectedIndex() > 0) {
            nombreCliente = ((Cliente) cmbCliente.getSelectedItem()).toString();
        } else {

            if (Objects.isNull(nombreCliente) || nombreCliente.isBlank()) {

                nombreCliente = JOptionPane.showInternalInputDialog(
                        this,
                        "Cual es el nombre del cliente?: ",
                        "",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (Objects.isNull(nombreCliente) || nombreCliente.isBlank()) {
                    JOptionPane.showInternalMessageDialog(
                            this,
                            "Seleccione un cliente para guardarla en temporal... ",
                            "",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }
            }
            
        }

        frmPonerTemporal miTemporal = new frmPonerTemporal(
                null,
                true
        );

//        miTemporal.setFactura(Integer.parseInt(txtIdFactura.getText()));
//        miTemporal.setMiTabla(miTabla);
//        miTemporal.setFacturas(facturas);
//        miTemporal.setCredicto(rbtCredito.isSelected());
//        miTemporal.setIdTurno(getTurno());
//        miTemporal.setIdCliente(idClienteTemporal);
//        miTemporal.setNombreCliente(nombreCliente);
//        miTemporal.setIdUsuario(getIdUsuario());
//        miTemporal.setAceptar(false);
//
//        miTemporal.setLocationRelativeTo(null);
//        miTemporal.setVisible(true);
//
//        if (miTemporal.isAceptar()) {
//            nueva();
//        }
    }//GEN-LAST:event_btnPonerTemporalActionPerformed

    private void btnBuscarTemporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarTemporalActionPerformed
        frmBuscarTemporal miTempo = new frmBuscarTemporal(null, true);
        miTempo.setLocationRelativeTo(null);
        miTempo.setVisible(true);

        if (miTempo.isAceptar()) {

            if (miTempo.getFactura().equals(txtIdFactura.getText())) {
                return;
            }

            btnBuscarCliente.setEnabled(false);

            setTitle("[Nueva Factura: " + miTempo.getFactura()
                    + "] - [Turno No.: " + turno.getId()
                    + "] - [Factura Temporarl activa, Cliente: " + nombreCliente + "]");

            txtIdFactura.setText("" + miTempo.getFactura());

            String sql = "SELECT d.IDFACTURA, d.IDLINEA, d.IDPRODUCTO, "
                    + "          p.DESCRIPCION, d.CANTIDAD, d.PRECIO "
                    + "FROM DETALLEFACTURA d "
                    + "    LEFT JOIN PRODUCTOS p "
                    + "        on p.IDPRODUCTO = d.IDPRODUCTO "
                    + "where d.IDFACTURA = " + miTempo.getFactura() + " "
                    + "order by 2";

//            ResultSet rs = getConsulta(sql);
            ResultSet rs = null;

            try {
                while (rs.next()) {
//                    facturas.(
//                            rs.getInt("idLinea") - 1,
//                            new Factura(
//                                    Integer.parseInt(miTempo.getFactura()),
//                                    rs.getShort("idLinea"),
//                                    rs.getString("idProducto"),
//                                    rs.getString("descripcion"),
//                                    rs.getDouble("precio"),
//                                    rs.getDouble("cantidad")
//                            )
//                            null
//                    );

                    registro[0] = rs.getDouble("cantidad");
                    registro[1] = rs.getString("descripcion");
                    registro[2] = Utilidades.priceWithDecimal(
                            rs.getDouble("precio") * rs.getDouble("cantidad"));

                    miTabla.addRow(registro);

                    tblDetalle.setModel(miTabla);
                    tblDetalle.setRowSelectionInterval(rs.getInt("idLinea") - 1, rs.getInt("idLinea") - 1);
                }
            } catch (SQLException ex) {
                LOG.log(
                        Level.SEVERE, 
                        "Error al leer los detalles de la factura.", 
                        ex
                );
            }

            precio();//Precio porque acaba de ser creada

            sql = "SELECT r.IDCLIENTE, nombreCliente "
                    + "FROM FACTURA r "
                    + "where r.IDFACTURA = " + miTempo.getFactura() + " ";

//            rs = getConsulta(sql);
            try {
                rs.next();
                setIdCliente(rs.getInt(1));
                nombreCliente = rs.getString(2);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error al cargar la factura.", ex);
            }

            for (int i = 0; i <= cmbCliente.getItemCount() + 1; i++) {

                if (((Cliente) cmbCliente.getItemAt(i)).getId_persona() == getIdCliente()) {
                    cmbCliente.setSelectedIndex(i);
                    totales();
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnBuscarTemporalActionPerformed

    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        int resp = JOptionPane.showInternalOptionDialog(
                this,
                "<html><big>Que desea registrar?</big></html>",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"<html><big>Gasto</big></html>", "<html><big>Deuda</big></html", "<html><big>Cancelar</big></html"},
                0
        );

        if (resp == 0) {
            frmAutorizacion miAut = new frmAutorizacion(null, true);
            miAut.setLocationRelativeTo(null);
            miAut.setVisible(true);

            if (!miAut.isAceptado()) {
                return;
            }

            frmGasto miGasto = new frmGasto(null, true);
            miGasto.setLocationRelativeTo(null);
            miGasto.setVisible(true);

        }

        if (resp == 1) {
        }
    }//GEN-LAST:event_btnGastosActionPerformed

    private void btnPagoDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoDeudaActionPerformed
        int resp = JOptionPane.showInternalOptionDialog(
                this,
                "<html><big>Tipo de Deuda?</big></html",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new String[]{"<html><big>Credito</big></html>", "<html><big>Externa</big></html", "<html><big>Cancelar</big></html"},
                0
        );

        if (resp == 0) {
            frmCobrosClientes miPagoCliente = new frmCobrosClientes(null, closable);
            miPagoCliente.setNombreCajero(usuario.getUser_name());
            miPagoCliente.setIdTurno(turno.getId());
            miPagoCliente.setLocationRelativeTo(null);
            miPagoCliente.setVisible(true);

            return;
        }
        if (resp == 1) {

            frmCobrosDeudas miPagoDeuda = new frmCobrosDeudas(null, closable);
            miPagoDeuda.setNombreCajero(usuario.getUser_name());
            miPagoDeuda.setIdTurno(turno.getId());
            miPagoDeuda.setLocationRelativeTo(null);
            miPagoDeuda.setVisible(true);

        }
    }//GEN-LAST:event_btnPagoDeudaActionPerformed

    private void btnImpresionUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpresionUltimaActionPerformed
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea Imprimir la Ultima Factura?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.ERROR_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        frmPrintFacturaConReporte2 miPrint = new frmPrintFacturaConReporte2(null, true);
        miPrint.setCopia(false);
        miPrint.setLocationRelativeTo(null);
        miPrint.setVisible(true);
    }//GEN-LAST:event_btnImpresionUltimaActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        //Obtener el identificador de la Factura.
        Integer idFactura = Integer.valueOf(txtIdFactura.getText());

        /*
         * Validaciones Si credicto es verdadero y el cmbClientes es generico
         * debe seleccionar un cliente de la lista.
         */
        if (rbtCredito.isSelected() && cmbCliente.getSelectedIndex() == 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Seleccinar un Cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbCliente.requestFocusInWindow();
            return;
        }

        /*
         * La cantidad del txtTotalCantidad debe estar presente, no se debe
         * digitar en el.
         */
        if (Utilidades.controlDouble(txtTotalCantidad.getValue()) == 0.0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Ingresar Detalle de la Factura...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCriterio.requestFocusInWindow();
            return;
        }

        double total = Utilidades.controlDouble(txtTotalValor.getValue());

        if (total > 0 && rbtCredito.isSelected()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Limite de credito Excedido! \nDesea continuar?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                return;
            } else {
                frmAutorizacion miAut = new frmAutorizacion(null, true);
                miAut.setLocationRelativeTo(null);
                miAut.setVisible(true);
                if (!miAut.isAceptado()) {
                    return;
                }
            }
        }

        frmCalculoEfectivo miEfe = new frmCalculoEfectivo(null, true, total, rbtCredito.isSelected());

        miEfe.setLocationRelativeTo(null);
        miEfe.setVisible(true);

        if (miEfe.getResp() == 0) {
            return;
        }

        //Adicionamos un consecutivo a la Factura oh numero d Factura proxima
        char estado = rbtCredito.isSelected() ? 'c' : 'p';

//        if (factura.getHeaderFactura().getEstado() == 'T') {
//            //Preparar Factura Temporal
//            HeaderFactura hf = HeaderFactura.builder().
//                    estado(estado).build();
//
//            Factura f = Factura.builder().id(idFactura).headerFactura(hf).build();
//
//            if (!modificarFactura(f)) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Ocurrio un error factura Temporal",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//                return;
//            } else {
//                for (int i = 1; i <= factura.getDetalleFactura().size(); i++) {
////                    if (!agregarOrInsertarDetalleFactura(
////                            facturas.getId(),
////                            i,
////                            facturas.getDetalleFactura().get(i).getIdProducto(),
////                            facturas.getDetalleFactura().get(i).getPrecio(),
////                            facturas.getDetalleFactura().get(i).getCantidad())) {
////
////                        borrarFactura(idFactura);
////
////                        JOptionPane.showInternalMessageDialog(
////                              this,
////                              "Ocurrio un error Temporal Detallle"
////                        );
////                        return;
////                    }
//                }
//            }
//        } else {
//
//            HeaderFactura hf = HeaderFactura
//                    .builder()
//                    .id_persona(((Cliente) cmbCliente.getSelectedItem()).getId_persona())
//                    .idTurno(turno.getId())
//                    .efectivo(new BigDecimal(miEfe.txtEfectivo.getValue().toString()))
//                    //.cambio(new BigDecimal(miEfe.txtDevuelta.getValue().toString()))
//                    //.credito(rbtCredito.isSelected())
//                    .build();
//
//            D_Factura objDF = null;
//
//            detalleFacturaList = new ArrayList<D_Factura>();
//
//            detalleFacturaList.add(objDF);
//
//            Factura factura = Factura.builder().
//                    id(idFactura).headerFactura(hf).detalleFactura(detalleFacturaList).build();
//
//            if (agregarFacturaNombre(factura) < 1) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Esta compra no se ha registrado...",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//            } else {
//                for (int i = 0; i < factura.getDetalleFactura().size(); i++) {
//                    if (agregarDetalleFactura(factura) < 1) {
//                        JOptionPane.showInternalMessageDialog(
//                                this,
//                                "Esta compra no se ha registrado...",
//                                "",
//                                JOptionPane.ERROR_MESSAGE
//                        );
//                        return;
//                    }
//                }
//            }
//        }

//        txtIdFactura.setText("" + getNumFac(getIdUsuario(), getTurno()));
        Map parametros = new HashMap();

        parametros.put("idFactura", idFactura);

        new hiloImpresionFactura(
                cbPrevista.isSelected(),
                rbtCredito.isSelected(),
                "/Reportes/factura.jasper",
                parametros,
                frmPrincipal.jPanelImpresion,
                frmPrincipal.jprImpresion).start();

        totales();

        rbtContado.doClick();
        factura.getDetalleFactura().clear();
        nombreCliente = "";
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void btnLimpiarF12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarF12ActionPerformed
        frmDetalleQuitarEliminar miForm = new frmDetalleQuitarEliminar(null, true);

        miForm.setLocationRelativeTo(null);
        miForm.setVisible(true);

        if (miForm.getOpcion() == 1) {
            opcion1();
        }
        if (miForm.getOpcion() == 2) {
            opcion2();
        }
    }//GEN-LAST:event_btnLimpiarF12ActionPerformed

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        Cliente cliente = miBusqueda.getCliente();

        if (cliente == null) {
            return;
        }
        getClientesCombo();

        for (int i = 0; i < cmbCliente.getItemCount(); i++) {
            if (((Cliente) cmbCliente.getItemAt(i)).getId_persona() == cliente.getId_persona()) {
                cmbCliente.setSelectedIndex(i);
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void formInternalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameDeiconified
        if (frmPrincipal.jpEstados.getComponent(0) != jpInfoFactura)
            frmPrincipal.jpEstados.add(jpInfoFactura, 0);
    }//GEN-LAST:event_formInternalFrameDeiconified

    private void formInternalFrameIconified(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameIconified
        if (frmPrincipal.jpEstados.getComponent(0) == jpInfoFactura)
            frmPrincipal.jpEstados.remove(jpInfoFactura);
    }//GEN-LAST:event_formInternalFrameIconified

    private void cbTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTodosMouseClicked
        jpCategoria = new javax.swing.JPanel();
        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
        jpCategoria.setAutoscrolls(true);
        jpCategoria.setMaximumSize(null);

        categoriaR();

        //TODO Hacer que el cbTodos lea la siguiente propiedad al iniciar este frmFactura.
        getPropiedad().setProperty("cbTodosUsuario", "" + cbTodos.isSelected());

        try {
            getPropiedad().store(new FileWriter(
                    new File(getClass().getResource("/sur/softsurena/properties/frmFacturaPropiedades.properties").toURI())),
                    "Valor que permite obtener las categorias.");
        } catch (IOException | URISyntaxException ex) {
            LOG.log(
                    Level.SEVERE, 
                    "Error al cargar la URI de archivo properties frmFacturaPropiedades.properties", 
                    ex
            );
        }
    }//GEN-LAST:event_cbTodosMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        formInternalFrameIconified(evt);
    }//GEN-LAST:event_formInternalFrameClosed

    /**
     * Es el metodo Sobre escrito que me permite hacer varias acciones en el.
     *
     * Este metodo detecta varias acciones que realiza el usuario al crear una
     * factura.
     *
     * @param actionEvent
     */
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        //Parametro no puede ser nulo.
        if (actionEvent == null) {
            return;
        }

        //Se obtiene el boton presionado.
        try {
            btn = (JButton) actionEvent.getSource();
        } catch (Exception eb) {
            return;
        }

        /*
         * La siguiente condicional es utilizada para obtener el producto a 
         * facturar. 
         */
        if (btn.getMnemonic() == 80) {//Para cuando btn en su Mnemonic es P
            /*
             * El siguiente bucle permite obtener la cantidad del producto a
             * facturar.
             *
             * Si la cantidadPro es nula se devuelve. Si la cantidadPro es
             * diferente de nulo, entonces se guarda este String en la variable
             * cantidad, parseandola, la cual es de tipo Double.
             *
             * Si introduce una cantidad valida el ciclo se rompe.
             * 
             * la variable cantidad es la cantidad ingresada por el usuario de 
             * un producto.
             *
             */
            if (validarCantidad().getEstado()) {
                return;
            }

            String idProducto = btn.getToolTipText();

            ResultSet rs = null;

            double precio = 0;
            try {
                rs.next();
                precio = rs.getDouble("Precio");
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error al obtener precio.", ex);
            }//Fin de obtener el precio del producto

//            facturas.add(
//                    tblDetalle.getRowCount(),
//                    new Factura(
//                            Integer.parseInt(txtIdFactura.getText()),//IdFactura
//                            (short) tblDetalle.getRowCount(),//IdLinea
//                            btn.getToolTipText(),//IdProducto
//                            btn.getText(),//Descripcion del producto
//                            precio,//Precio del producto
//                            cantidad
//                    )
//                    null
//            );//Cantidad
            txtPrecio.setValue(precio);

            registro[0] = validarCantidad().getCantidadDecimal();
            registro[1] = btn.getText();
            registro[2] = Utilidades.priceWithDecimal(
                    precio * validarCantidad().getCantidadDecimal()
            );

            miTabla.addRow(registro);
            tblDetalle.setModel(miTabla);

            jpProductos.removeAll();
            jpProductos.repaint();
            jpProductos.setLayout(new FlowLayout());

            tblDetalle.changeSelection(tblDetalle.getRowCount() - 1, 0, false, false);//Seleccionar ultimo elemento
            tblDetalle.requestFocusInWindow();

            totales();
            txtCriterio.setText("");
            txtCriterio.requestFocusInWindow();
            return;
        }//Fin de la inclusion de producto....

        int idCategoria = Integer.parseInt(btn.getToolTipText());

        jpProductos.removeAll();
        jpProductos.repaint();
        jpProductos.setLayout(new FlowLayout());

        getProductosByCategoria(
                idCategoria,
                cbTodosProductos.isSelected()).stream().forEach(producto -> {

            boton = new JButton(producto.getDescripcion());
            boton.setToolTipText(producto.getId().toString());

            boton.setMnemonic('P');

            ImageIcon imagen = null;

            if (Objects.isNull(producto.getImagenProducto())) {
                imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
            } else {
                imagen = imagenDecode64(producto.getImagenProducto(), 96, 96);
            }

            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(
                    64,
                    64,
                    Image.SCALE_DEFAULT));

            imagen.getImage().flush();

            boton.setIcon(icon);

            boton.addActionListener(this);

            boton.setIconTextGap(2);
            boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            int ancho = 170, alto = 100;

            boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
            boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
            boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

            boton.setLayout(new BorderLayout(8, 8));

            jpProductos.add(boton);
            jpProductos.repaint();
            jpProductos.validate();

        });

    }//Fin de actionPerformed

    private void repararRegistro() {
        miTabla = new DefaultTableModel(null, titulos);
        tblDetalle.setModel(miTabla);
        TableColumn miTableColumn;
        for (int i = 0; i < 2; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(80); // la tercera columna sera la mas grande
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(200); // la tercera columna sera la mas grande
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(15); // la tercera columna sera la mas grande
            }
        }

        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tcr.setFont(new java.awt.Font("Ubuntu", 50, 80));
        tcr.setBackground(Color.yellow);
        tblDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    private void categoriaR() {
        List<Categoria> categoriasList;

        //Mandamos a buscar todas las categorias del sistema.
        //TODO No se está obteniendo todas las categorias.
        if (cbTodos.isSelected()) {
            categoriasList = getCategorias(null,true);
        } else {
            categoriasList = getCategoriaActivas();
        }

        //Limpiamos el jPanel de las categorias.
        jpCategoria.removeAll();
        jpCategoria.repaint();
        jpCategoria.setLayout(new FlowLayout());

        categoriasList.stream().forEach(categoria -> {
            //Nombre de la categoria.
            boton = new JButton(categoria.getDescripcion());

            //ID de la categoria.
            boton.setToolTipText("" + categoria.getId_categoria());

            //Una constante del boton que indica que es una categoria.
            boton.setMnemonic('c');

            //Obteniendo la imagen de la categoria.
            ImageIcon imagen = Utilidades.imagenDecode64(categoria.getImage_texto(), 64, 64);

            if (imagen.getIconHeight() == -1) {
                imagen = new Imagenes("NoImageTransp 96 x 96.png").getIcono();
            }

            Icon icon = new ImageIcon(
                    imagen.getImage().getScaledInstance(
                            64, 64, Image.SCALE_DEFAULT));

            //imagen.getImage().flush();
            //Personalizamos el boton. 
            boton.setIcon(icon);
            boton.addActionListener(this);

            boton.validate();
            boton.setIconTextGap(2);
            boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            final int ancho = 120, alto = 95;
            boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
            boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
            boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

            boton.setLayout(new FlowLayout());
            jpCategoria.add(boton);
            jpCategoria.repaint();
            jpCategoria.validate();
        });

    }

//    private void estadoCliente() {
//        //Obtenemos el ID de la persona
//        int idPersona = 0;
//        try {
//            idPersona = ((Persona) cmbCliente.getSelectedItem()).getId();
//        } catch (Exception ex) {
//            idPersona = 0;
//        }
//
//        //Consultamos en la base de datos por el id de la persona.
//        ResultSet rs = getClientesPorDeudaCredito(idPersona);
//
//        int resp = JOptionPane.NO_OPTION;
//
//        try {
//            rs.next();
//            JlCantidad1.setText("Limt Cred.:$"
//                    + Utilidades.priceWithDecimal(rs.getDouble("credito")));
//            JlCantidad2.setText("Deud Actu.:$"
//                    + Utilidades.priceWithDecimal(rs.getDouble("deudaActual")));
//            valorCredito = rs.getDouble("credito");
//            if (idPersona != 0 && rbtCredito.isSelected()) {
//                resp = JOptionPane.showInternalConfirmDialog(this, "Cliente: " + rs.getString("nombres")
//                        + "\nSu credito es de: " + "RD$" + rs.getString("credito")
//                        + "\nDesea Continuar?",
//                        "Credito insuficiente", JOptionPane.YES_NO_OPTION);
//            }
//        } catch (SQLException ex) {
//
//            LOG.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//
//        switch (resp) {
//            case JOptionPane.OK_OPTION:
//
//                frmAutorizacion miAut = new frmAutorizacion(null, true);
//                miAut.setLocationRelativeTo(null);
//                miAut.setVisible(true);
//
////Si la Autenticacion falla emitimos un mensaje de Usuario no valido.
//                if (!miAut.isAceptado()) {
//                    rbtContadoActionPerformed(null);
//                }
//
//                break;
//
//            case JOptionPane.NO_OPTION:
//                rbtContado.setSelected(true);
//                rbtContadoActionPerformed(null);
//                rbtContado.validate();
//                rbtContado.revalidate();
//                break;
//        }
//    }
    /**
     * Este metodo se esta ejecutando en dos metodos, son:
     * formInternalFrameOpened: Permite cargar la lista de los clientes en el
     * JComboBox al abrirse el Formulario.
     *
     * btnBuscarClienteActionPerformed: Actualiza el combo para que un bucl
     * busque si un cliente existe.
     *
     */
    private void getClientesCombo() {
        cmbCliente.removeAllItems();
        cmbCliente.repaint();

        //TODO traer solo cliente.
//        List<Cliente> clientesList = getClientes(
//                FiltroBusqueda
//                        .builder()
//                        .estado(true)
//                        .build()
//        );
//
//        clientesList.stream().forEach(cliente -> {
//            cmbCliente.addItem(cliente);
//        });

        if (cmbCliente.getItemCount() > 0) {
            cmbCliente.setSelectedIndex(0);
        }
    }


    private void totales() {
        int num = tblDetalle.getRowCount();
        double sumCan = 0;
        double sumVal = 0;

        if (num != 0) {
            for (int i = 0; i < num; i++) {
                sumCan += Utilidades.objectToDouble(tblDetalle.getValueAt(i, 0));
                sumVal += Utilidades.objectToDouble(tblDetalle.getValueAt(i, 2));
            }
        } else {
            txtTotalCantidad.setValue(0);
            txtTotalValor.setValue(0);
            txtPrecio.setValue(0);
            return;
        }
        txtTotalCantidad.setValue(sumCan);
        txtTotalValor.setValue(sumVal);
    }

    private void nueva() {
        mnuMovimientosNuevaFactura.doClick();
        nombreCliente = "";
        factura.getDetalleFactura().clear();
    }

    private void precio() {
        int cell;
        try {
            cell = tblDetalle.getSelectedRow();
        } catch (Exception e) {
            cell = -1;
        }
        if (cell == -1) {
            txtPrecio.setValue(0.0);
            return;
        }
        txtPrecio.setValue(factura.getDetalleFactura().get(cell).getPrecio());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCantidad1;
    private javax.swing.JLabel JlCantidad2;
    private newscomponents.RSButtonGradientIcon_new btnBuscarCliente;
    private newscomponents.RSButtonGradientIcon_new btnBuscarTemporal;
    private newscomponents.RSButtonGradientIcon_new btnGastos;
    private newscomponents.RSButtonGradientIcon_new btnGrabar;
    private javax.swing.ButtonGroup btnGrupoPago;
    private newscomponents.RSButtonGradientIcon_new btnImpresionUltima;
    private newscomponents.RSButtonGradientIcon_new btnLimpiarF12;
    private newscomponents.RSButtonGradientIcon_new btnPagoDeuda;
    private newscomponents.RSButtonGradientIcon_new btnPonerTemporal;
    private javax.swing.JComboBox<String> cbCriterio;
    private javax.swing.JCheckBox cbPrevista;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JCheckBox cbTodosProductos;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private rojeru_san.rslabel.RSLabelAnimated jlAlmacen;
    private javax.swing.JLabel jlFacturaNo;
    private javax.swing.JPanel jpBusqueda;
    private javax.swing.JPanel jpCategoria;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpFacturas;
    private static javax.swing.JPanel jpInfoFactura;
    private javax.swing.JPanel jpProductos;
    private rojerusan.RSMenuBar rSMenuBar2;
    private javax.swing.JRadioButton rbtContado;
    public javax.swing.JRadioButton rbtCredito;
    public javax.swing.JTable tblDetalle;
    public javax.swing.JTextField txtCriterio;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JFormattedTextField txtTotalCantidad;
    private javax.swing.JFormattedTextField txtTotalValor;
    private javax.swing.JTextField txtTurno;
    // End of variables declaration//GEN-END:variables

    /**
     * Este metodo nos permite validar las cantidades registradas al sistema,
     * esta solo permite ingresar valores positivos mayores que 0, no permite
     * que letras o caracteres que no puedan convertirse a numero.
     *
     * @return retorna un objecto de la clase Resultados, la cual lleva consigo
     * el estado de la validacion true o false y la cantidad valida.
     */
    private Resultado validarCantidad() {
        Float cantidad = 0.0f;
        boolean bandera;
        do {
            bandera = false;
            try {
                String cantidadPro = JOptionPane.showInternalInputDialog(
                        this,
                        "Cantidad: ",
                        "",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (Objects.isNull(cantidadPro)) {
                    bandera = true;
                    break;
                }

                cantidad = Float.valueOf(cantidadPro);

            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese una cantidad numerica: ",
                        "",
                        JOptionPane.WARNING_MESSAGE
                );

                bandera = true;
                continue;
            }

            if (cantidad <= 0) {
                javax.swing.JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese una cantidad positiva y diferente de cero: ",
                        "",
                        JOptionPane.WARNING_MESSAGE);
                bandera = true;
            }

        } while (bandera);//Fin del bucle.

        return Resultado.builder().
                cantidadDecimal(cantidad).
                estado(bandera)
                .build();
    }
    
    private void opcion1() {
        int rta = JOptionPane.showInternalConfirmDialog(
                this,
                "¿Esta Seguro de Borrar el detalle de la Factura?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }
        nueva();
    }

    private void opcion2() {
//        if (factura.getHeaderFactura().getEstado() == 'T') {
//            JOptionPane.showInternalMessageDialog(
//                    this,
//                    "Es una factura temporal no se permite eliminar",
//                    "",
//                    JOptionPane.ERROR_MESSAGE
//            );
//            return;
//        }
//
//        try {
//            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
//            int fila = tblDetalle.getSelectedRow();
//            if (fila == -1) {
//                JOptionPane.showInternalMessageDialog(
//                        this,
//                        "Debe seleccionar un articulo del detalle factura",
//                        "",
//                        JOptionPane.ERROR_MESSAGE
//                );
//                return;
//            }
//
//            factura.getDetalleFactura().remove(fila);
//
//            modelo.removeRow(fila);
//
//            totales();
//
//        } catch (HeadlessException ex) {
//            LOG.log(Level.SEVERE, "Error al remover articulo.", ex);
//        }
    }
}
