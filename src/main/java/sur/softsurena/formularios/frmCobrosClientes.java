package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class frmCobrosClientes extends javax.swing.JDialog {

    private Datos misDatos;
    private int idTurno;
    private String nombreCajero;

    public String getNombreCajero() {
        return nombreCajero;
    }

    public void setNombreCajero(String nombreCajero) {
        this.nombreCajero = nombreCajero;
    }

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public void setDatos(Datos misDatos) {
        this.misDatos = misDatos;
    }

    public frmCobrosClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtMonto.setValue(0.0);
        txtDeuda.setValue(0.0);
        txtCredito.setValue(0.0);
        txtMontoDeuda.setValue(0.0);
        txtMontoPago.setValue(0.0);
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtMonto.setValue(0.0);
                        txtMonto.setSelectionStart(3);
                        txtMonto.setSelectionEnd(txtMonto.getText().length());
                    }
                });
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbCliente = new javax.swing.JComboBox();
        btnPagar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBuscarCliente = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        txtDeuda = new javax.swing.JFormattedTextField();
        txtCredito = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPagos = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacturas = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMontoPago = new javax.swing.JFormattedTextField();
        txtMontoDeuda = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cobros Clientes");
        setMaximumSize(new java.awt.Dimension(500, 499));
        setMinimumSize(new java.awt.Dimension(500, 499));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cmbCliente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        btnPagar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dinero 32 x 32.png"))); // NOI18N
        btnPagar.setText("Pago");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscarCliente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarCliente.setMnemonic('c');
        btnBuscarCliente.setText("Cliente");
        btnBuscarCliente.setToolTipText("Busca un Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Estado del Cliente"));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Limite de Credito: ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Deuda del Cliente: ");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Monto a pagar: ");

        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMonto.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
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

        txtDeuda.setEditable(false);
        txtDeuda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtDeuda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDeuda.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        txtCredito.setEditable(false);
        txtCredito.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCredito.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(txtDeuda)
                    .addComponent(txtMonto))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txtDeuda});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, jLabel4, txtCredito, txtMonto});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Pagos de la Factura."));

        tblPagos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No?? Pago", "Fecha", "Hora", "Monto Pago"
            }
        ));
        tblPagos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblPagos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Facturas del cliente a Credito"));

        tblFacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No?? Factura", "Total Fact.", "Fecha", "Estado"
            }
        ));
        tblFacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFacturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFacturas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel1.setText("Monto Pagado:");

        jLabel5.setText("Monto Deudado:");

        txtMontoPago.setEditable(false);
        txtMontoPago.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMontoPago.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        txtMontoDeuda.setEditable(false);
        txtMontoDeuda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMontoDeuda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cmbCliente, 0, 370, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscarCliente))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagar))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMontoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnPagar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMontoPago, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(txtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(btnCancelar))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnPagar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMontoDeuda, txtMontoPago});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarCliente, cmbCliente});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            Opcion opc = new Opcion("NA", "Seleccione un Cliente...");
            cmbCliente.addItem(opc);
            ResultSet rsCli = misDatos.getConsulta(
                    "SELECT r.IDCLIENTE, (r.NOMBRES||' '||r.APELLIDOS) as nombre "
                    + "FROM TABLA_CLIENTES r "
                    + "WHERE r.DEUDAACTUAL > 0");
            while (rsCli.next()) {
                opc = new Opcion(
                        rsCli.getString("idCliente"),
                        rsCli.getString("nombre"));
                cmbCliente.addItem(opc);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_formWindowOpened
    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (cmbCliente.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe selecionar un Cliente...");
            cmbCliente.requestFocusInWindow();
            return;
        }
        if (tblFacturas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una factura");
            return;
        }

        float Monto = Utilidades.controlDouble(txtMonto.getValue());
        float montoTotal = Utilidades.controlDouble(txtDeuda.getValue());
        float montoDeuda = Utilidades.controlDouble(txtMontoDeuda.getValue());

        if (Monto == 0) {
            JOptionPane.showMessageDialog(rootPane, "Debe Ingresar un Valor Para Realizar Pago...");
            txtMonto.setValue(0.0);
            txtMonto.requestFocusInWindow();
            return;
        }
        if (Monto > montoTotal) {
            JOptionPane.showMessageDialog(rootPane, "No se permite Monto a pagar MAYOR QUE '>' Deuda del Cliente");
            return;
        }
        if (Monto <= 0) {
            JOptionPane.showMessageDialog(rootPane, "No se permite monto NEGATIVO");
            return;
        }
        if (Monto > montoDeuda && montoDeuda > 0) {
            JOptionPane.showMessageDialog(rootPane, "No se permite monto MAYOR a la DEUDA");
            return;
        }
        int num = JOptionPane.showConfirmDialog(this,
                "Esta seguro de realizar Cobro?",
                "Confirmacion de Pago",
                JOptionPane.YES_NO_OPTION);
        if (num == 1) {
            return;
        }
        //idFactura idTurno, double montoPago
        misDatos.pagarCredito(Utilidades.controlDouble(txtCredito.getValue()),
                montoTotal,
                ((Opcion) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getValor(),
                Monto,
                Utilidades.objectToInt(tblFacturas.getValueAt(tblFacturas.getSelectedRow(), 0)),
                getIdTurno());

        //Constancia de pago de Factura....
        JOptionPane.showMessageDialog(rootPane, "Pago realizado con Exito...");
        
        Map parametros = new HashMap();
        parametros.put("nombreCajero", getNombreCajero());
        parametros.put("idFactura", Utilidades.objectToInt(tblFacturas.getValueAt(tblFacturas.getSelectedRow(), 0)));
        parametros.put("idTurno", "" + getIdTurno());
        parametros.put("idCliente", ((Opcion) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getValor());
        parametros.put("nombreCliente", ((Opcion) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getDescripcion());
        parametros.put("montoFactura", Utilidades.objectToDouble(tblFacturas.getValueAt(tblFacturas.getSelectedRow(), 1)));
        hiloImpresionFactura miHilo = new hiloImpresionFactura(misDatos,
                true, //Mostrar Reporte
                false, //Con Copia
                System.getProperty("user.dir") + "/Reportes/cobroFactura.jasper", 
                parametros);
        miHilo.start();
        
        dispose();
    }//GEN-LAST:event_btnPagarActionPerformed
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(null, true);
        miBusqueda.setDatos(misDatos);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        String rta = miBusqueda.getRespuesta();
        if (rta.equals("")) {
            return;
        }
        for (int i = 0; i < cmbCliente.getItemCount(); i++) {
            if (((Opcion) cmbCliente.getItemAt(i)).getValor().equals(rta)) {
                cmbCliente.setSelectedIndex(i);
                return;
            }
        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        try {
            llenarTabla(((Opcion) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getValor());
            ResultSet rs = misDatos.getConsulta(
                    "SELECT r.CREDITO, r.DEUDAACTUAL "
                    + "FROM TABLA_CLIENTES r "
                    + "WHERE r.IDCLIENTE LIKE '" + ((Opcion) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getValor() + "'");
            if (cmbCliente.getSelectedIndex() > 0) {
                rs.next();
                txtDeuda.setValue(rs.getDouble("deudaActual"));
                txtCredito.setValue(rs.getDouble("credito"));
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_cmbClienteItemStateChanged
    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        txtMonto.grabFocus();
        txtMonto.requestFocusInWindow();
    }//GEN-LAST:event_cmbClienteActionPerformed
    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        btnPagarActionPerformed(evt);
    }//GEN-LAST:event_txtMontoActionPerformed
    private void tblFacturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturasMouseClicked
        if (tblFacturas.getSelectedRow() == -1) {
            return;
        }
        llenarPagos("" + tblFacturas.getValueAt(tblFacturas.getSelectedRow(), 0));
        totales();
    }//GEN-LAST:event_tblFacturasMouseClicked

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtMontoKeyTyped
    private void totales() {
        double montoPago = 0;
        for (int i = 0; i < tblPagos.getRowCount(); i++) {
            montoPago += Utilidades.objectToDouble(tblPagos.getValueAt(i, 3));
        }

        if (montoPago == 0) {
            txtMontoPago.setValue(0.0);
            txtMontoDeuda.setValue(0.0);
            return;
        }

        txtMontoPago.setValue(montoPago);
        double deuda = Utilidades.controlDouble(tblFacturas.getValueAt(tblFacturas.getSelectedRow(), 1)) - Utilidades.controlDouble(txtMontoPago.getValue());
        txtMontoDeuda.setValue(deuda);
    }

    private void llenarTabla(String idCliente) {
        try {
            String titulos[] = {"No?? Factura", "Total Fact.", "Fecha", "Estado"};

            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            String sql = "SELECT r.IDFACTURA, CAST(sum(d.CANTIDAD * d.PRECIO) as NUMERIC(15,2)) as Total, "
                    + "       r.FECHA, r.ESTADO "
                    + "FROM TABLA_FACTURAS r "
                    + "    JOIN TABLA_DETALLEFACTURA d "
                    + "        ON d.IDFACTURA = r.IDFACTURA "
                    + "where r.IDCLIENTE like '" + idCliente + "' and r.ESTADO in('c', 'a') "
                    + "GROUP BY r.IDFACTURA, r.FECHA, r.ESTADO";

            ResultSet rs = misDatos.getConsulta(sql);
            Object registro[] = new Object[4];
            while (rs.next()) {
                registro[0] = rs.getString("idFactura");
                registro[1] = rs.getDouble("total");
                registro[2] = rs.getString("fecha");
                String estado = "Credito";
                if (rs.getString("Estado").equals("a")) {
                    estado = "Abon??";
                }
                registro[3] = estado;
                miTabla.addRow(registro);
            }
            tblFacturas.setModel(miTabla);

        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private void llenarPagos(String idFactura) {
        try {
            String titulos[] = {"No?? Pago", "Fecha", "Hora", "Monto Pagado"};

            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            String sql = "SELECT r.IDPAGODEUDA, r.FECHA, r.HORA, r.MONTOPAGO "
                    + "FROM TABLA_PAGODEUDA r "
                    + "where r.IDFACTURA = " + idFactura + "";
            ResultSet rs = misDatos.getConsulta(sql);
            Object registro[] = new Object[4];
            int i = 1;
            while (rs.next()) {
                registro[0] = i + ") Cod.:" +rs.getString("idPagoDeuda");
                registro[1] = rs.getString("Fecha");
                registro[2] = rs.getString("Hora");
                registro[3] = rs.getString("montoPago");
                miTabla.addRow(registro);
                i++;
            }
            tblPagos.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblFacturas;
    private javax.swing.JTable tblPagos;
    private javax.swing.JFormattedTextField txtCredito;
    private javax.swing.JFormattedTextField txtDeuda;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JFormattedTextField txtMontoDeuda;
    private javax.swing.JFormattedTextField txtMontoPago;
    // End of variables declaration//GEN-END:variables
}
