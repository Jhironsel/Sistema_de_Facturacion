package sur.softsurena.formularios;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Categorias;
import static sur.softsurena.entidades.Categorias.getCategoriaActivas;
import static sur.softsurena.entidades.Categorias.getCategorias;
import sur.softsurena.entidades.Clientes;
import static sur.softsurena.entidades.Clientes.getClientesCombo;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.DetalleFactura;
import static sur.softsurena.entidades.DetalleFactura.agregarDetalleFactura;
import sur.softsurena.entidades.Facturas;
import static sur.softsurena.entidades.Facturas.agregarFacturaNombre;
import static sur.softsurena.entidades.Facturas.modificarFactura;
import sur.softsurena.entidades.Generales;
import sur.softsurena.entidades.HeaderFactura;
import sur.softsurena.entidades.Opcion;
import sur.softsurena.entidades.Personas;
import static sur.softsurena.entidades.Productos.existeProducto;
import static sur.softsurena.formularios.frmPrincipal.mnuMovimientosNuevaFactura;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.Utilidades;

public final class frmFacturas extends javax.swing.JInternalFrame implements Runnable, ActionListener {

    private static final Logger LOG = Logger.getLogger(frmFacturas.class.getName());

    private Integer idUsuario, idCliente, turno, idClienteTemporal;

    private String nombreCliente = "";

    private final String titulos[] = {"Cantidad", "Descripcion", "Montos"};

    private double valorCredito = 0;

    private JButton btn, boton;

    private ActionEvent e1;

    private boolean temporal;

    private Facturas facturas;

    private DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

    private final Object[] registro = new Object[3];

    private final Properties propiedad;

    private final DefaultTableCellRenderer tcr;

    private final Thread h1;

    private Thread ct;

    private ArrayList<DetalleFactura> detalleFacturaList;

    private Properties getPropiedad() {
        return propiedad;
    }

    private void setPropiedad() {
        try {
            getPropiedad().load(new FileReader("sur/softsurena/properties/propiedades.properties"));
        } catch (FileNotFoundException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public frmFacturas() {
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();

        propiedad = new Properties();
        setPropiedad();

        this.temporal = false;
        h1 = new Thread(this);
        h1.start();

        btnGrupoPago.add(rbtContado);
        btnGrupoPago.add(rbtCredito);

        Utilidades.clickOnKey(btnLimpiarF12, "cancelar", KeyEvent.VK_F12);
        Utilidades.clickOnKey(btnGrabar, "factura", KeyEvent.VK_F10);
        Utilidades.clickOnKey(btnEspera, "temporar", KeyEvent.VK_F5);
        Utilidades.clickOnKey(btnBuscarEspera, "temporarBuscar", KeyEvent.VK_F6);
        Utilidades.clickOnKey(btnGastos, "gastos", KeyEvent.VK_F7);
        Utilidades.clickOnKey(btnPagoDeuda, "pagoDeuda", KeyEvent.VK_F8);
        Utilidades.clickOnKey(btnImpresionUltima, "impresionUltima", KeyEvent.VK_F9);

        categoriaR();
    }//Metodo Constructor...

    @Override
    public void run() {
        ct = Thread.currentThread();
        while (ct == h1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
            }
            txtHora.setText("");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrupoPago = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnEspera = new javax.swing.JButton();
        btnBuscarEspera = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnPagoDeuda = new javax.swing.JButton();
        btnImpresionUltima = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiarF12 = new javax.swing.JButton();
        btnDevolucion = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        cbTodos = new javax.swing.JCheckBox();
        cbTodosProductos = new javax.swing.JCheckBox();
        cbPrevista = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpCliente = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtContado = new javax.swing.JRadioButton();
        rbtCredito = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        btnBuscarCliente = new javax.swing.JButton();
        cmbCliente = new javax.swing.JComboBox();
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
        jPanel11 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdFactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTurno = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema de Facturacion Sophia");
        setToolTipText("");
        setAutoscrolls(true);
        setDoubleBuffered(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
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

        jPanel5.setAutoscrolls(true);
        jPanel5.setMinimumSize(new java.awt.Dimension(250, 68));
        jPanel5.setLayout(new java.awt.GridLayout(1, 7, 3, 3));

        btnEspera.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnEspera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clock 32 x 32.png"))); // NOI18N
        btnEspera.setMnemonic('T');
        btnEspera.setText("<html><center>Temporal<br>F5</center></html>");
        btnEspera.setToolTipText("Poner una factura en espera y seguir con la otra");
        btnEspera.setBorder(null);
        btnEspera.setFocusPainted(false);
        btnEspera.setFocusable(false);
        btnEspera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEspera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEsperaActionPerformed(evt);
            }
        });
        jPanel5.add(btnEspera);

        btnBuscarEspera.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscarEspera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarEspera.setText("<html><center>Temporal<br>F6</center></html>");
        btnBuscarEspera.setToolTipText("Buscar factura que estan en espera");
        btnBuscarEspera.setBorder(null);
        btnBuscarEspera.setFocusPainted(false);
        btnBuscarEspera.setFocusable(false);
        btnBuscarEspera.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscarEspera.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscarEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEsperaActionPerformed(evt);
            }
        });
        jPanel5.add(btnBuscarEspera);

        btnGastos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gasto 32 x 32.png"))); // NOI18N
        btnGastos.setText("<html><center>Gasto<br>F7</center></html>");
        btnGastos.setToolTipText("Pagar gastos del Negocio");
        btnGastos.setBorder(null);
        btnGastos.setFocusPainted(false);
        btnGastos.setFocusable(false);
        btnGastos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGastos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGastosActionPerformed(evt);
            }
        });
        jPanel5.add(btnGastos);

        btnPagoDeuda.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnPagoDeuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dinero 32 x 32.png"))); // NOI18N
        btnPagoDeuda.setText("<html><center>Deuda<br>F8</center></html>");
        btnPagoDeuda.setToolTipText("Buscar Deuda");
        btnPagoDeuda.setBorder(null);
        btnPagoDeuda.setFocusPainted(false);
        btnPagoDeuda.setFocusable(false);
        btnPagoDeuda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPagoDeuda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPagoDeuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoDeudaActionPerformed(evt);
            }
        });
        jPanel5.add(btnPagoDeuda);

        btnImpresionUltima.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnImpresionUltima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/epson32x32.png"))); // NOI18N
        btnImpresionUltima.setText("<html><center>Ultima<br>F9</center></html>");
        btnImpresionUltima.setToolTipText("Ultima Facura");
        btnImpresionUltima.setBorder(null);
        btnImpresionUltima.setFocusPainted(false);
        btnImpresionUltima.setFocusable(false);
        btnImpresionUltima.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnImpresionUltima.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnImpresionUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpresionUltimaActionPerformed(evt);
            }
        });
        jPanel5.add(btnImpresionUltima);

        btnGrabar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnGrabar.setText("<html><center>Terminar<br>F10</center></html>");
        btnGrabar.setToolTipText("Confirmar Factura");
        btnGrabar.setAutoscrolls(true);
        btnGrabar.setBorder(null);
        btnGrabar.setFocusPainted(false);
        btnGrabar.setFocusable(false);
        btnGrabar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGrabar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });
        jPanel5.add(btnGrabar);

        btnLimpiarF12.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnLimpiarF12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnLimpiarF12.setText("<html><center>Limpiar<br>F12</center></html>");
        btnLimpiarF12.setToolTipText("Cancelar Factura Actual");
        btnLimpiarF12.setBorder(null);
        btnLimpiarF12.setFocusPainted(false);
        btnLimpiarF12.setFocusable(false);
        btnLimpiarF12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLimpiarF12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLimpiarF12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarF12ActionPerformed(evt);
            }
        });
        jPanel5.add(btnLimpiarF12);

        btnDevolucion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnDevolucion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/devolucion32x32.png"))); // NOI18N
        btnDevolucion.setText("Devoluciones");
        btnDevolucion.setToolTipText("Cancelar Factura Actual");
        btnDevolucion.setBorder(null);
        btnDevolucion.setFocusPainted(false);
        btnDevolucion.setFocusable(false);
        btnDevolucion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDevolucion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDevolucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionActionPerformed(evt);
            }
        });
        jPanel5.add(btnDevolucion);

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
        cbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTodosActionPerformed(evt);
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
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
        jScrollPane3.setMinimumSize(new java.awt.Dimension(0, 100));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(381, 100));

        jpCliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));
        jpCliente.setAlignmentX(0.0F);
        jpCliente.setAlignmentY(0.0F);
        jpCliente.setMaximumSize(new java.awt.Dimension(265, 135));
        jpCliente.setMinimumSize(new java.awt.Dimension(30, 30));
        jpCliente.setPreferredSize(new java.awt.Dimension(265, 135));
        org.jdesktop.swingx.VerticalLayout verticalLayout1 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout1.setGap(3);
        jpCliente.setLayout(verticalLayout1);

        jPanel9.setMaximumSize(new java.awt.Dimension(153, 100));
        jPanel9.setMinimumSize(new java.awt.Dimension(153, 30));
        jPanel9.setName(""); // NOI18N
        jPanel9.setPreferredSize(new java.awt.Dimension(153, 40));

        jPanel4.setMaximumSize(new java.awt.Dimension(153, 40));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(153, 40));

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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rbtContado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rbtCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(rbtContado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(rbtCredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel7.setBackground(new java.awt.Color(0, 153, 255));
        jPanel7.setMaximumSize(new java.awt.Dimension(153, 40));
        jPanel7.setPreferredSize(new java.awt.Dimension(153, 40));

        btnBuscarCliente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscarCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cliente 32 x 32.png"))); // NOI18N
        btnBuscarCliente.setMnemonic('c');
        btnBuscarCliente.setText("Cliente");
        btnBuscarCliente.setToolTipText("Busca un Cliente");
        btnBuscarCliente.setBorder(null);
        btnBuscarCliente.setFocusPainted(false);
        btnBuscarCliente.setFocusable(false);
        btnBuscarCliente.setMaximumSize(new java.awt.Dimension(123, 35));
        btnBuscarCliente.setMinimumSize(new java.awt.Dimension(123, 35));
        btnBuscarCliente.setPreferredSize(new java.awt.Dimension(123, 35));
        btnBuscarCliente.setRequestFocusEnabled(false);
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnBuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

        JlCantidad1.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        JlCantidad1.setText("w");
        JlCantidad1.setToolTipText("");
        JlCantidad1.setMaximumSize(new java.awt.Dimension(360, 24));
        jpCliente.add(JlCantidad1);

        JlCantidad2.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        JlCantidad2.setText("w");
        JlCantidad2.setToolTipText("");
        JlCantidad2.setMaximumSize(new java.awt.Dimension(360, 26));
        jpCliente.add(JlCantidad2);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
        jpProductos.setPreferredSize(new java.awt.Dimension(20, 1500));
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
                    .addComponent(jpBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(0, 0, 0))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel8);

        jPanel11.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel11.setLayout(new java.awt.GridLayout(1, 2, 8, 8));

        jPanel13.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel13.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fact. no.:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel13.add(jLabel3);

        txtIdFactura.setEditable(false);
        txtIdFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtIdFactura.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtIdFactura.setAutoscrolls(false);
        txtIdFactura.setDoubleBuffered(true);
        txtIdFactura.setFocusCycleRoot(true);
        txtIdFactura.setFocusTraversalPolicy(null);
        txtIdFactura.setFocusTraversalPolicyProvider(true);
        txtIdFactura.setName(""); // NOI18N
        jPanel13.add(txtIdFactura);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel13.add(jLabel2);

        txtUsuario.setEditable(false);
        txtUsuario.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUsuario.setAutoscrolls(false);
        txtUsuario.setDoubleBuffered(true);
        txtUsuario.setFocusCycleRoot(true);
        txtUsuario.setFocusTraversalPolicy(null);
        txtUsuario.setFocusTraversalPolicyProvider(true);
        jPanel13.add(txtUsuario);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Turno:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel13.add(jLabel9);

        txtTurno.setEditable(false);
        txtTurno.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtTurno.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTurno.setAutoscrolls(false);
        txtTurno.setDoubleBuffered(true);
        txtTurno.setFocusCycleRoot(true);
        txtTurno.setFocusTraversalPolicyProvider(true);
        jPanel13.add(txtTurno);

        jPanel11.add(jPanel13);

        jPanel12.setMinimumSize(new java.awt.Dimension(0, 35));
        jPanel12.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Fecha:");
        jPanel12.add(jLabel1);

        txtFecha.setEditable(false);
        txtFecha.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtFecha.setDoubleBuffered(true);
        txtFecha.setFocusCycleRoot(true);
        txtFecha.setFocusTraversalPolicy(null);
        txtFecha.setFocusTraversalPolicyProvider(true);
        jPanel12.add(txtFecha);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Hora:");
        jPanel12.add(jLabel8);

        txtHora.setEditable(false);
        txtHora.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        txtHora.setDoubleBuffered(true);
        txtHora.setFocusCycleRoot(true);
        txtHora.setFocusTraversalPolicy(null);
        txtHora.setFocusTraversalPolicyProvider(true);
        jPanel12.add(txtHora);

        jPanel11.add(jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(null, closable);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        if (miBusqueda.getRespuesta().equals("")) {
            return;
        }

        for (int i = 0; i <= cmbCliente.getItemCount() + 1; i++) {
            if (((Opcion) cmbCliente.getItemAt(i)).getValor().equals(miBusqueda.getRespuesta())) {
                cmbCliente.setSelectedIndex(i);
                return;
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed
    private void btnPagoDeudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoDeudaActionPerformed
        int resp = JOptionPane.showOptionDialog(this, "<html><big>Tipo de Deuda?</big></html",
                "Elegir el tipo de deuda!!!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"<html><big>Credito</big></html>",
                    "<html><big>Externa</big></html",
                    "<html><big>Cancelar</big></html"}, 0);

        if (resp == 0) {
            frmCobrosClientes miPagoCliente = new frmCobrosClientes(null, closable);
            miPagoCliente.setNombreCajero(getIdUsuario().toString());
            miPagoCliente.setIdTurno(getTurno());
            miPagoCliente.setLocationRelativeTo(null);
            miPagoCliente.setVisible(true);

            return;
        }
        if (resp == 1) {

            frmCobrosDeudas miPagoDeuda = new frmCobrosDeudas(null, closable);
            miPagoDeuda.setNombreCajero(getIdUsuario().toString());
            miPagoDeuda.setIdTurno(getTurno());
            miPagoDeuda.setLocationRelativeTo(null);
            miPagoDeuda.setVisible(true);

        }
    }//GEN-LAST:event_btnPagoDeudaActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        txtFecha.setText(date.format(now));
        txtHora.setText("00:00:00 AM");
        rbtContado.doClick();
        txtUsuario.setText(getIdUsuario().toString());
        txtTurno.setText("" + getTurno());
        txtCriterio.requestFocusInWindow();
    }//GEN-LAST:event_formInternalFrameActivated
    private void cbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosActionPerformed
        jpCategoria = new javax.swing.JPanel();
        jpCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder("Categoria"));
        jpCategoria.setAutoscrolls(true);
        jpCategoria.setMaximumSize(null);
        //getPropiedad().setProperty("Yiro", "Sophia");
        categoriaR();

        getPropiedad().setProperty("cbTodosUsuario", "" + cbTodos.isSelected());
        try {
            getPropiedad().store(new FileWriter(
                    getClass().getResource(
                            "/Propeties/propiedades.properties").getFile()),
                    "Comentario");
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_cbTodosActionPerformed
    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        //Obtener el identificador de la Factura.
        Integer idFactura = Integer.parseInt(txtIdFactura.getText());

        /*
         * Validaciones Si credicto es verdadero y el cmbClientes es generico
         * debe seleccionar un cliente de la lista.
         */
        if (rbtCredito.isSelected() && cmbCliente.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe Seleccinar un Cliente...");
            cmbCliente.requestFocusInWindow();
            return;
        }

        /*
         * La cantidad del txtTotalCantidad debe estar presente, no se debe
         * digitar en el.
         */
        if (Utilidades.controlDouble(txtTotalCantidad.getValue()) == 0.0) {
            JOptionPane.showMessageDialog(this,
                    "Debe Ingresar Detalle de la Factura...");
            txtCriterio.requestFocusInWindow();
            return;
        }

        double total = Utilidades.controlDouble(txtTotalValor.getValue());

        if (total > valorCredito && rbtCredito.isSelected()) {
            int resp = JOptionPane.showConfirmDialog(this,
                    "Limite de credito Excedido! \nDesea continuar?",
                    "Autorización de venta sobre el credito", JOptionPane.YES_NO_OPTION);
            if (resp == 1) {
                return;
            } else {
                frmAutorizacion miAut = new frmAutorizacion(null, true);
                miAut.setLocationRelativeTo(null);
                miAut.setVisible(true);
                if (!miAut.isAceptado()) {
                    JOptionPane.showMessageDialog(this, "Usuario no valido");
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

        if (isTemporal()) {
            //Preparar Factura Temporal
            HeaderFactura hf = HeaderFactura.builder().
                    estado(estado).
                    nombreTemp(nombreCliente)
                    .build();
            Facturas f = Facturas.builder().id(idFactura).headerFactura(hf).build();

            if (!modificarFactura(f)) {
                JOptionPane.showMessageDialog(this, "Ocurrio un error factura Temporal");
                return;
            } else {
                for (int i = 1; i <= facturas.getDetalleFactura().size(); i++) {
//                    if (!agregarOrInsertarDetalleFactura(
//                            facturas.getId(),
//                            i,
//                            facturas.getDetalleFactura().get(i).getIdProducto(),
//                            facturas.getDetalleFactura().get(i).getPrecio(),
//                            facturas.getDetalleFactura().get(i).getCantidad())) {
//
//                        borrarFactura(idFactura);
//
//                        JOptionPane.showMessageDialog(this,
//                                "Ocurrio un error Temporal Detallle");
//
//                        return;
//                    }
                }
            }
        } else {

            HeaderFactura hf = HeaderFactura.builder().
                    idCliente(((Clientes) cmbCliente.getSelectedItem()).getId_persona()).
                    idTurno(getTurno()).
                    efectivo(new BigDecimal(miEfe.txtEfectivo.getValue().toString())).
                    cambio(new BigDecimal(miEfe.txtDevuelta.getValue().toString())).
                    credito(rbtCredito.isSelected()).build();

            DetalleFactura objDF = null;

            detalleFacturaList = new ArrayList<DetalleFactura>();

            detalleFacturaList.add(objDF);

            Facturas f = Facturas.builder().
                    id(idFactura).headerFactura(hf).detalleFactura(detalleFacturaList).build();

            if (agregarFacturaNombre(f) < 1) {
                JOptionPane.showMessageDialog(this, "Esta compra no se ha registrado...");
            } else {
                for (int i = 0; i < facturas.getDetalleFactura().size(); i++) {
                    if (agregarDetalleFactura(f) < 1) {
                        JOptionPane.showMessageDialog(this, "Esta compra no se ha registrado...");
                        return;
                    }
                }
            }
        }

//        txtIdFactura.setText("" + getNumFac(getIdUsuario(), getTurno()));
        Map parametros = new HashMap();

        parametros.put("idFactura", idFactura);

        new hiloImpresionFactura(
                cbPrevista.isSelected(),
                rbtCredito.isSelected(),
                "/Reportes/factura.jasper",
                parametros).start();

        limpiarTabla();
        totales();

        rbtContado.doClick();
        setTemporal(false);
        facturas.getDetalleFactura().clear();
        nombreCliente = "";
        idClienteTemporal = 0;
    }//GEN-LAST:event_btnGrabarActionPerformed

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
                        imagen = new ImageIcon(System.getProperty("user.dir")
                                + "/images/Sin_imagen 64 x 64.png");
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
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }

        if (cbCriterio.getSelectedIndex() == 3) {
            if (txtCriterio.getText().trim().isEmpty()) {
                return;
            }
            if (!existeProducto(txtCriterio.getText().trim())) {
                JOptionPane.showMessageDialog(null, "El Producto No Existe...");
                txtCriterio.setText("");
                return;
            }
            //Detalle de Factura
            int num = tblDetalle.getRowCount();
            if (num == 0) {
                JOptionPane.showMessageDialog(this, "No existe producto en detalle!!!");
                txtCriterio.setText("");
                return;
            }
            boolean dime = true;
            for (int i = 0; i < num; i++) {
                if (facturas.getId().equals(txtCriterio.getText().trim())) {
                    tblDetalle.setRowSelectionInterval(i, i);
                    dime = false;
                    txtCriterio.setText("");
                    break;
                }
            }

            if (dime) {
                txtCriterio.setText("");
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
            }

        }
    }//GEN-LAST:event_txtCriterioActionPerformed
    private void rbtCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtCreditoActionPerformed
        if (evt == null) {
            rbtCredito.doClick();
        }
        cmbCliente.setEnabled(true);
        btnBuscarCliente.setEnabled(true);
        cmbCliente.setSelectedIndex(0);
    }//GEN-LAST:event_rbtCreditoActionPerformed
    private void rbtContadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtContadoActionPerformed
        if (evt == null) {
            rbtContado.doClick();
        }
        cmbCliente.setEnabled(false);
        cmbCliente.setSelectedIndex(0);
        JlCantidad1.setText("Limt Cred.:$0.00");
        JlCantidad2.setText("Deud Actu.:$0.00");
    }//GEN-LAST:event_rbtContadoActionPerformed
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

    private void opcion1() {
        int rta = JOptionPane.showConfirmDialog(this,
                "¿Esta Seguro de Borrar el detalle de la Factura?",
                "Eliminando Detalle de la factura",
                JOptionPane.YES_NO_OPTION);
        if (rta == 1) {
            return;
        }
        nueva();
    }

    private void opcion2() {
        if (isTemporal()) {
            JOptionPane.showMessageDialog(this,
                    "Es una factura temporal no se permite eliminar",
                    "Negacion a eliminar producto...",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
            int fila = tblDetalle.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this,
                        "Debe seleccionar un articulo del detalle factura");
                return;
            }

            facturas.getDetalleFactura().remove(fila);

            modelo.removeRow(fila);

            totales();

        } catch (HeadlessException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    private void btnEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEsperaActionPerformed
        if (tblDetalle.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Factura Vacia...");
            return;
        }

        if (facturas.getDetalleFactura().get(0) == null) {
            JOptionPane.showMessageDialog(this,
                    "Ha ocurrido un error de factura realice de nuevo...",
                    "Validación de procesos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cmbCliente.getSelectedIndex() > 0) {
            nombreCliente = ((Opcion) cmbCliente.getSelectedItem()).getDescripcion();
            idClienteTemporal = ((Personas) cmbCliente.getSelectedItem()).getId_persona();
        } else {
            idClienteTemporal = 0;
            if ("".equals(nombreCliente)) {
                nombreCliente = JOptionPane.showInputDialog(this, "Inserte Nombre Cliente: ",
                        "Inserte nombre del Cliente...",
                        JOptionPane.INFORMATION_MESSAGE);
                if (nombreCliente == null || nombreCliente.equals("")) {
                    JOptionPane.showMessageDialog(this,
                            "Nombre vacio, Seleccione un cliente\n para guardarla en temporal... ",
                            "Advertencia", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        frmTemporal miTemporal = new frmTemporal(null, true);

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
    }//GEN-LAST:event_btnEsperaActionPerformed

    private void btnBuscarEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEsperaActionPerformed
        setTemporal(false);
        frmBuscarTemporal miTempo = new frmBuscarTemporal(null, true);
        miTempo.setLocationRelativeTo(null);
        miTempo.setVisible(true);

        if (miTempo.isAceptar()) {

            if (miTempo.getFactura().equals(txtIdFactura.getText())) {
                return;
            }

            btnBuscarCliente.setEnabled(false);

            setTemporal(true);

            setTitle("Nueva Factura: " + miTempo.getFactura()
                    + "   Numero del Turno Activo del Cajero: "
                    + getTurno() + " Factura Temporarl activa, Cliente: " + nombreCliente);

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
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
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
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }

            for (int i = 0; i <= cmbCliente.getItemCount() + 1; i++) {
                if (((Opcion) cmbCliente.getItemAt(i)).getValor().equals(getIdCliente())) {
                    cmbCliente.setSelectedIndex(i);
                    totales();
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnBuscarEsperaActionPerformed
    private void cbTodosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTodosProductosActionPerformed
        jpProductos = new javax.swing.JPanel();

        jpProductos.setAutoscrolls(true);

        jpProductos.setBackground(new java.awt.Color(255, 102, 51));

        jpProductos.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
                "Productos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Ubuntu", 0, 14)));

        jpProductos.setMaximumSize(new java.awt.Dimension(350, 1500));

        jpProductos.setMinimumSize(new java.awt.Dimension(350, 1500));

        jpProductos.setPreferredSize(new java.awt.Dimension(350, 1500));

        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();

        flowLayout1.setAlignOnBaseline(true);

        jpProductos.setLayout(flowLayout1);

        jScrollPane4.setViewportView(jpProductos);

        actionPerformed(e1);
    }//GEN-LAST:event_cbTodosProductosActionPerformed
    private void btnGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGastosActionPerformed
        int resp = JOptionPane.showOptionDialog(this, "<html><big>Que desea registrar?</big></html",
                "Elija una accion!!!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new String[]{"<html><big>Gasto</big></html>", "<html><big>Deuda</big></html", "<html><big>Cancelar</big></html"}, 0);

        if (resp == 0) {
            frmAutorizacion miAut = new frmAutorizacion(null, true);
            miAut.setLocationRelativeTo(null);
            miAut.setVisible(true);

            if (!miAut.isAceptado()) {
                JOptionPane.showMessageDialog(this, "Usuario no valido");
                return;
            }

            frmGasto miGasto = new frmGasto(null, true);
            miGasto.setIdTurno(getTurno());
            miGasto.setUsuario(txtUsuario.getText());
            miGasto.setLocationRelativeTo(null);
            miGasto.setVisible(true);

        }

        if (resp == 1) {
        }

    }//GEN-LAST:event_btnGastosActionPerformed
    private void btnImpresionUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpresionUltimaActionPerformed
        int resp = JOptionPane.showConfirmDialog(this,
                "Desea Imprimir la Ultima Factura?",
                "Confirmacion de impresion", JOptionPane.YES_NO_OPTION);
        if (resp == 1) {
            return;
        }
        frmPrintFacturaConReporte miPrint = new frmPrintFacturaConReporte(null, true);
        miPrint.setCopia(false);
        miPrint.setLocationRelativeTo(null);
        miPrint.setVisible(true);
    }//GEN-LAST:event_btnImpresionUltimaActionPerformed
    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        precio();
    }//GEN-LAST:event_tblDetalleMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        getClientes();
//        txtIdFactura.setText("" + getNumFac(getIdUsuario(), getTurno()));
        setTemporal(false);
        repararRegistro();
        totales();
    }//GEN-LAST:event_formInternalFrameOpened

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        if (tblDetalle.getRowCount() != 0) {
            int resp = JOptionPane.showInternalConfirmDialog(this,
                    "Existe una factura, Desea Salir?", "Advertencia, Factura existente",
                    JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                dispose();
            }
        } else {
            dispose();
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        if (!cmbCliente.isEnabled()) {
            return;
        }
        //estadoCliente();
    }//GEN-LAST:event_cmbClienteActionPerformed

    private void btnDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionActionPerformed
        // Procedimiento para devolucion. 

    }//GEN-LAST:event_btnDevolucionActionPerformed

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e == null) {
            return;
        }

        e1 = e;

        try {
            btn = (JButton) e.getSource();
        } catch (Exception eb) {
            return;
        }

        if (btn.getMnemonic() == 80) {//Incluir elemento a la factura....
            double cantidad = 0, precio = 0;
            boolean bandera;//Cuadro de Texto pidiendo Cantidad

            do {
                try {
                    String es = JOptionPane.showInputDialog("Introduce cantidad: ");
                    if (es == null) {
                        return;
                    }
                    cantidad = Double.parseDouble(es);
                    bandera = true;
                } catch (NumberFormatException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Solo se permiten numeros");
                    bandera = false;
                }
            } while (!bandera);//Fin del cuadro texto pidiendo la cantidad

            //Para obtener el precio                                                --IdProducto
            String sql
                    = "select Precio from "
                    + "TABLA_PRODUCTOS "
                    + "where idProducto like '" + btn.getToolTipText() + "'";

//            ResultSet rs = getConsulta(sql);
            ResultSet rs = null;

            try {
                rs.next();
                precio = rs.getDouble("Precio");
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
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

            registro[0] = cantidad;
            registro[1] = btn.getText();
            registro[2] = Utilidades.priceWithDecimal(precio * cantidad);

            miTabla.addRow(registro);
            tblDetalle.setModel(miTabla);

            e1 = null;//Porque va tu aqui...

            jpProductos.removeAll();
            jpProductos.repaint();
            jpProductos.setLayout(new FlowLayout());

            tblDetalle.changeSelection(tblDetalle.getRowCount() - 1, 0, false, false);//Seleccionar ultimo elemento
            tblDetalle.requestFocusInWindow();

            totales();
            txtCriterio.setText("");
            txtCriterio.requestFocusInWindow();
            return;
        }//Fin de la inclusion....

//        ResultSet rs = getConsulta(sql);
        ResultSet rs = null;

        String sql = "select Descripcion, IdProducto, imagePath, Precio "
                + "from TABLA_PRODUCTOS "
                + "where idCategoria = " + btn.getToolTipText() + " and "
                + "entrada > 0 and "
                + "estado = 1";

        if (cbTodosProductos.isSelected()) {
            sql = "select Descripcion, IdProducto, imagePath, Precio "
                    + "from TABLA_PRODUCTOS "
                    + "where idCategoria = " + btn.getToolTipText();
        }

        jpProductos.removeAll();
        jpProductos.repaint();
        jpProductos.setLayout(new FlowLayout());

        try {
            while (rs.next()) {
                boton = new JButton(rs.getString("Descripcion"));
                boton.setToolTipText(rs.getString("IdProducto"));
                boton.setMnemonic('p');

                String im = "";

                if (rs.getString("imagepath") != null) {
                    im = rs.getString("imagepath");
                }

                ImageIcon imagen = new ImageIcon(im);

                if (imagen.getIconHeight() == -1) {
                    imagen = new ImageIcon(System.getProperty("user.dir")
                            + "/images/Sin_imagen 64 x 64.png");
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
            }
            //jpProductos.setPreferredSize(new Dimension(jpProductos.getSize().width, 1500));
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
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
        List<Categorias> categoriasList = getCategoriaActivas();

        if (cbTodos.isSelected()) {
            categoriasList = getCategorias();
        }

        jpCategoria.removeAll();
        jpCategoria.repaint();
//        jpCategoria.setLayout(new FlowLayout());

        categoriasList.stream().forEach(x -> {
            boton = new JButton(x.getDescripcion());
            boton.setToolTipText(x.getId()+"");
            boton.setMnemonic('c');
            
            ImageIcon imagen =  Utilidades.imagenDecode64(x.getImage_texto());

            if (imagen.getIconHeight() == -1) {
                imagen = new Imagenes().getIcono("/imagenes/NoImageTransp 96 x 96.png");
            }

            Icon icon = new ImageIcon(
                    imagen.getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT));
            
            imagen.getImage().flush();
            
            boton.setIcon(icon);
            boton.validate();
            boton.setIconTextGap(2);
            boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            boton.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            boton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            boton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            boton.addActionListener(this);

            int ancho = 120, alto = 95;
            boton.setPreferredSize(new java.awt.Dimension(ancho, alto));
            boton.setMinimumSize(new java.awt.Dimension(ancho, alto));
            boton.setMaximumSize(new java.awt.Dimension(ancho, alto));

    //                boton.setLayout(new FlowLayout());
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
//                resp = JOptionPane.showConfirmDialog(this, "Cliente: " + rs.getString("nombres")
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
//                    JOptionPane.showMessageDialog(this, "Usuario no valido");
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
    private void getClientes() {
        cmbCliente.removeAllItems();
        cmbCliente.repaint();

        Generales g = Generales.builder().
                cedula("000-0000000-0").build();
        Clientes p = Clientes.builder().
                id_persona(0).
                pNombre("Seleccione un cliente").
                sNombre("").
                apellidos("").build();

        cmbCliente.addItem(p);

        try {
            ResultSet rs = getClientesCombo();

            while (rs.next()) {
                g = Generales.builder().
                        cedula(rs.getString("cedula")).build();

                p = Clientes.builder().
                        id_persona(rs.getInt("id")).
                        pNombre(rs.getString("pNombre")).
                        sNombre(rs.getString("sNombre")).
                        apellidos(rs.getString("apellidos")).
                        generales(g).build();

                cmbCliente.addItem(p);
            }//fin
            cmbCliente.setSelectedIndex(0);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        if (isTemporal()) {
            for (int i = 0; i < cmbCliente.getItemCount(); i++) {
                if (((Opcion) cmbCliente.getItemAt(i)).getValor().equals(getIdCliente())) {
                    cmbCliente.setSelectedIndex(i);
                    return;
                }
            }
        }
    }

    private void limpiarTabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblDetalle.getModel();
            int filas = tblDetalle.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        cmbCliente.setSelectedIndex(0);
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
        idClienteTemporal = 0;
        facturas.getDetalleFactura().clear();
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
        txtPrecio.setValue(facturas.getDetalleFactura().get(cell).getPrecio());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlCantidad1;
    private javax.swing.JLabel JlCantidad2;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarEspera;
    public javax.swing.JButton btnDevolucion;
    private javax.swing.JButton btnEspera;
    private javax.swing.JButton btnGastos;
    private javax.swing.JButton btnGrabar;
    private javax.swing.ButtonGroup btnGrupoPago;
    private javax.swing.JButton btnImpresionUltima;
    public javax.swing.JButton btnLimpiarF12;
    private javax.swing.JButton btnPagoDeuda;
    private javax.swing.JComboBox<String> cbCriterio;
    private javax.swing.JCheckBox cbPrevista;
    private javax.swing.JCheckBox cbTodos;
    private javax.swing.JCheckBox cbTodosProductos;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel jpBusqueda;
    private javax.swing.JPanel jpCategoria;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JRadioButton rbtContado;
    public javax.swing.JRadioButton rbtCredito;
    public javax.swing.JTable tblDetalle;
    public javax.swing.JTextField txtCriterio;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JFormattedTextField txtPrecio;
    private javax.swing.JFormattedTextField txtTotalCantidad;
    private javax.swing.JFormattedTextField txtTotalValor;
    private javax.swing.JTextField txtTurno;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
