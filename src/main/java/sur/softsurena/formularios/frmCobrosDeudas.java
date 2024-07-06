package sur.softsurena.formularios;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Cliente;
import sur.softsurena.hilos.hiloImpresionFactura;
import static sur.softsurena.metodos.M_Deuda.getDeudas;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmCobrosDeudas extends javax.swing.JDialog {

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

    public frmCobrosDeudas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtMonto.setValue(0.0);
        txtDeuda.setValue(0.0);
        txtMontoDeuda.setValue(0.0);
        txtMontoPago.setValue(0.0);
        txtSaldo.setValue(0.0);

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
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel2 = new javax.swing.JLabel();
        txtDeuda = new javax.swing.JFormattedTextField();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel4 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JFormattedTextField();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPago = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDeudas = new JTable(){
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
        setTitle("Cobros Deudas");
        setMinimumSize(new java.awt.Dimension(656, 531));
        setResizable(false);
        setSize(new java.awt.Dimension(656, 531));
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
        btnPagar.setText("Pago");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnBuscarCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarCliente.setMnemonic('c');
        btnBuscarCliente.setText("Cliente");
        btnBuscarCliente.setToolTipText("Busca un Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estado del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N
        jPanel1.setLayout(new java.awt.GridLayout(3, 3, 0, 5));
        jPanel1.add(filler1);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Deuda del Cliente: ");
        jPanel1.add(jLabel2);

        txtDeuda.setEditable(false);
        txtDeuda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtDeuda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtDeuda.setToolTipText("");
        txtDeuda.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel1.add(txtDeuda);
        jPanel1.add(filler3);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Saldo: ");
        jPanel1.add(jLabel4);

        txtSaldo.setEditable(false);
        txtSaldo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSaldo.setToolTipText("");
        txtSaldo.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        jPanel1.add(txtSaldo);
        jPanel1.add(filler2);

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Monto a pagar: ");
        jPanel1.add(jLabel3);

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
        jPanel1.add(txtMonto);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de pagos de deudas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        tblPago.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No° Pago", "Fecha", "Hora", "Monto Pago"
            }
        ));
        tblPago.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblPago);

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

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Deudas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 1, 14))); // NOI18N

        tblDeudas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cod. Deuda", "Concepto", "Monto", "Fecha", "Estado"
            }
        ));
        tblDeudas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDeudas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDeudasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDeudas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
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
        txtMontoPago.setPreferredSize(new java.awt.Dimension(10, 19));

        txtMontoDeuda.setEditable(false);
        txtMontoDeuda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMontoDeuda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtMontoDeuda.setPreferredSize(new java.awt.Dimension(10, 19));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cmbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(txtMontoDeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnPagar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMontoDeuda, txtMontoPago});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBuscarCliente, cmbCliente});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cmbCliente.removeAllItems();
        cmbCliente.addItem(Cliente
                        .builder()
                        .id_persona(-1)
                        .pnombre("Seleccione un cliente")
                        .snombre("")
                        .apellidos("")
                        .build()
        );

        getDeudas().stream().forEach(cliente -> {
            cmbCliente.addItem(Cliente
                            .builder()
                            .id_persona(cliente.getId_persona())
                            .pnombre(cliente.getPnombre())
                            .snombre(cliente.getSnombre())
                            .apellidos(cliente.getApellidos())
                            .build()
            );
        });
    }//GEN-LAST:event_formWindowOpened

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (cmbCliente.getSelectedIndex() <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Selecionar un Cliente...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            cmbCliente.requestFocusInWindow();
            return;
        }
        if (tblDeudas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe seleccionar una factura",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        BigDecimal monto = new BigDecimal(txtMonto.getValue().toString());//Lo que se inserta en ese momento
        BigDecimal montoSaldo = new BigDecimal(txtSaldo.getValue().toString());//La suma de todas las deudas
        //float montoDeuda = Utilidades.controlDouble(txtMontoDeuda.getValue());//Total de lo que debe...

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar un valor mayor a cero(0)",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtMonto.setValue(0.0);
            txtMonto.requestFocusInWindow();
            return;
        }

        if (monto.compareTo(montoSaldo) > 1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Monto excede el saldo",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtMonto.setValue(0.0);
            txtMonto.requestFocusInWindow();
            return;
        }

        int num = JOptionPane.showConfirmDialog(
                this,
                "Esta seguro de realizar Cobro?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (num == JOptionPane.NO_OPTION) {
            return;
        }

        //TODO Trabajos
//        PagoDeuda(
//                Utilidades.objectToInt(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 0)),
//                getIdTurno(), 
//                monto);
        JOptionPane.showMessageDialog(
                this,
                "Pago realizado con Exito...",
                "",
                JOptionPane.INFORMATION_MESSAGE
        );

        //imprimirPago();
        dispose();
    }//GEN-LAST:event_btnPagarActionPerformed
    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        frmBusquedaCliente miBusqueda = new frmBusquedaCliente(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        Cliente cliente = miBusqueda.getCliente();

        if (cliente == null) {
            return;
        }
        //TODO Trabajos.
//        for (int i = 0; i < cmbCliente.getItemCount(); i++) {
//            if (((Cliente) cmbCliente.getItemAt(i)).getGenerales().getCedula().equals(cliente.getGenerales().getCedula())) {
//                cmbCliente.setSelectedIndex(i);
//                return;
//            }
//        }
    }//GEN-LAST:event_btnBuscarClienteActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cmbClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClienteItemStateChanged
        llenarTabla(((Cliente) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getId_persona());

        txtMonto.setValue(0.0);
        txtDeuda.setValue(0.0);
        txtMontoDeuda.setValue(0.0);
        txtMontoPago.setValue(0.0);
        txtSaldo.setValue(0.0);

        if (tblDeudas.getRowCount() > 0) {
            Double montoDeuda = 0.0;
            for (int i = 0; i < tblDeudas.getRowCount(); i++) {
                montoDeuda = montoDeuda + Utilidades.controlDouble(tblDeudas.getValueAt(i, 2));
            }
            txtMontoDeuda.setValue(montoDeuda);
        }

    }//GEN-LAST:event_cmbClienteItemStateChanged
    private void cmbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClienteActionPerformed
        txtMonto.grabFocus();
        txtMonto.requestFocusInWindow();
    }//GEN-LAST:event_cmbClienteActionPerformed
    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        btnPagarActionPerformed(evt);
    }//GEN-LAST:event_txtMontoActionPerformed
    private void tblDeudasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDeudasMouseClicked
        if (tblDeudas.getSelectedRow() == -1) {
            return;
        }
        llenarPagos("" + tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 0));

        txtDeuda.setValue(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 2));
        double montoPagado = 0.0;
        for (int i = 0; i < tblPago.getRowCount(); i++) {
            montoPagado = montoPagado + Utilidades.objectToDouble(tblPago.getValueAt(i, 3));
        }
        txtMontoPago.setValue(montoPagado);
        txtSaldo.setValue(Utilidades.objectToDouble(txtDeuda.getValue()) - Utilidades.objectToDouble(txtMontoPago.getValue()));
        txtMonto.requestFocusInWindow();
    }//GEN-LAST:event_tblDeudasMouseClicked

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtMontoKeyTyped

    private void imprimirPago() {
        Map parametros = new HashMap();
        parametros.put("nombreCajero", getNombreCajero());
        parametros.put("idFactura", Utilidades.objectToInt(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 0)));
        parametros.put("montoFactura", Utilidades.objectToDouble(tblDeudas.getValueAt(tblDeudas.getSelectedRow(), 1)));
        parametros.put("idTurno", "" + getIdTurno());
        parametros.put("idCliente", ((Cliente) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).getId_persona());
        parametros.put("nombreCliente", ((Cliente) cmbCliente.getItemAt(cmbCliente.getSelectedIndex())).toString());

        hiloImpresionFactura impresionFactura = new hiloImpresionFactura(
                true,
                false,
                System.getProperty("user.dir") + "/Reportes/cobroFactura.jasper",
                parametros,
                frmPrincipal.jPanelImpresion,
                frmPrincipal.jprImpresion);

        impresionFactura.start();
    }

    private void llenarTabla(int idCliente) {
        try {
            String titulos[] = {"Cod. Deuda", "Concepto", "Monto", "Fecha", "Estado"};

            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            String sql = "SELECT r.IDDEUDAS, r.CONCEPTO, r.MONTO, r.FECHA, r.ESTADO "
                    + "FROM TABLA_DEUDAS r "
                    + "WHERE r.IDCLIENTE LIKE '" + idCliente + "' AND r.ESTADO NOT IN('n', 'p')";

            ResultSet rs = null;
            Object registro[] = new Object[5];
            while (rs.next()) {
                registro[0] = rs.getInt("IDDEUDAS");
                registro[1] = rs.getString("CONCEPTO");
                registro[2] = rs.getDouble("MONTO");
                registro[3] = rs.getString("FECHA");

                String estado = rs.getString("Estado");
                if (estado.equals("i")) {
                    estado = "Iniciada";
                }
                if (estado.equals("a")) {
                    estado = "Abonada";
                }
                registro[4] = estado;
                miTabla.addRow(registro);
            }
            tblDeudas.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al llenar tabla de deudas.", ex);
        }
    }

    private void llenarPagos(String idDeuda) {
        try {
            String titulos[] = {"No° Pago", "Fecha", "Hora", "Monto Pagado"};

            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);

            String sql = "SELECT r.CODIGO, r.FECHA, r.HORA, r.MONTO "
                    + "FROM TABLA_PAGO_DEUDAS_EXTERNA r "
                    + "WHERE r.IDDEUDA = " + idDeuda;

            ResultSet rs = null;

            Object registro[] = new Object[4];

            int i = 1;

            while (rs.next()) {
                registro[0] = i + ") Cod.:" + rs.getString("CODIGO");
                registro[1] = rs.getString("Fecha");
                registro[2] = rs.getString("Hora");
                registro[3] = "RD$ " + rs.getString("MONTO");
                miTabla.addRow(registro);
                i++;
            }
            tblPago.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al obtener pagos de deudas externas.", ex);
        }
        txtMonto.requestFocusInWindow();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnPagar;
    private javax.swing.JComboBox cmbCliente;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
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
    private javax.swing.JTable tblDeudas;
    private javax.swing.JTable tblPago;
    private javax.swing.JFormattedTextField txtDeuda;
    private javax.swing.JFormattedTextField txtMonto;
    private javax.swing.JFormattedTextField txtMontoDeuda;
    private javax.swing.JFormattedTextField txtMontoPago;
    private javax.swing.JFormattedTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}
