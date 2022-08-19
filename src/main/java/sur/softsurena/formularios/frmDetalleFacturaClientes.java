package sur.softsurena.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.utilidades.Utilidades;

public class frmDetalleFacturaClientes extends javax.swing.JInternalFrame {

    private DefaultTableModel miTabla, miTabla2, miTabla3;
    private TableColumn miTableColumn = null;
    private final DefaultTableCellRenderer tcr;

    public frmDetalleFacturaClientes() {
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrTipoBusqueda = new javax.swing.ButtonGroup();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleFactura = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jPanel3 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JFormattedTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        rbtID = new javax.swing.JRadioButton();
        rbtNombes = new javax.swing.JRadioButton();
        rbtApellidos = new javax.swing.JRadioButton();
        rbtIdFactura = new javax.swing.JRadioButton();
        txtCriterio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jScrollPane7 = new javax.swing.JScrollPane();
        tblFactura = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Detalle de los Clientes");
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
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles de Factura Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        tblDetalleFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDetalleFactura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalleFactura.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblDetalleFactura);

        jPanel3.setLayout(new java.awt.GridLayout(1, 4, 8, 0));

        btnSalir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(1, 1, 1));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Salir 32 x 32.png"))); // NOI18N
        btnSalir.setMnemonic('a');
        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.setBorder(null);
        btnSalir.setPreferredSize(new java.awt.Dimension(123, 44));
        btnSalir.setSelected(true);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir);

        btnAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Impresora.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Imprimir");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.setSelected(true);
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel3.add(btnAceptar);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total:");
        jPanel3.add(jLabel4);

        txtTotal.setEditable(false);
        txtTotal.setForeground(new java.awt.Color(0, 0, 255));
        txtTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));
        txtTotal.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtTotal.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jPanel3.add(txtTotal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jScrollPane4.setViewportView(jPanel1);

        jPanel5.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setLayout(new java.awt.GridLayout(1, 4));

        bgrTipoBusqueda.add(rbtID);
        rbtID.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtID.setMnemonic('i');
        rbtID.setSelected(true);
        rbtID.setText("Cedula");
        rbtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIDActionPerformed(evt);
            }
        });
        jPanel4.add(rbtID);

        bgrTipoBusqueda.add(rbtNombes);
        rbtNombes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtNombes.setMnemonic('n');
        rbtNombes.setText("Nombres");
        rbtNombes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNombesActionPerformed(evt);
            }
        });
        jPanel4.add(rbtNombes);

        bgrTipoBusqueda.add(rbtApellidos);
        rbtApellidos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtApellidos.setMnemonic('a');
        rbtApellidos.setText("Apellidos");
        rbtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtApellidosActionPerformed(evt);
            }
        });
        jPanel4.add(rbtApellidos);

        bgrTipoBusqueda.add(rbtIdFactura);
        rbtIdFactura.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rbtIdFactura.setMnemonic('a');
        rbtIdFactura.setText("Factura");
        rbtIdFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIdFacturaActionPerformed(evt);
            }
        });
        jPanel4.add(rbtIdFactura);

        jPanel5.add(jPanel4);

        txtCriterio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioActionPerformed(evt);
            }
        });
        txtCriterio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCriterioKeyReleased(evt);
            }
        });
        jPanel5.add(txtCriterio);

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
        tblClientes.setToolTipText("Doble click para buscar factura");
        tblClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClientes.getTableHeader().setReorderingAllowed(false);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        tblFactura.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFactura.setToolTipText("Doble Click para imprimir la factura");
        tblFactura.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblFactura.getTableHeader().setReorderingAllowed(false);
        tblFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFacturaMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblFactura);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        tablaClientes();
    }//GEN-LAST:event_formInternalFrameOpened

    private void tblFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFacturaMouseClicked
        try {
            String idFactura = tblFactura.getValueAt(
                    tblFactura.getSelectedRow(), 0).toString();
            

            DefaultTableModel modelo = (DefaultTableModel) tblDetalleFactura.getModel();
            
            int filas = tblDetalleFactura.getRowCount();
            
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }

            String sql = "SELECT factura.idFactura, factura.idCliente, nombres||' '||apellidos AS nombreFull, \n"
                    + "        fecha, idLinea, (select p.Descripcion \n"
                    + "                            from PRODUCTOS p \n"
                    + "                            where p.idProducto = DETALLEFACTURA.IDPRODUCTO ) as Descripcion, \n"
                    + "        idProducto, precio, cantidad, precio * cantidad AS Valor \n"
                    + "FROM factura \n"
                    + "INNER JOIN cliente ON factura.idCliente = cliente.idCliente \n"
                    + "INNER JOIN detalleFactura ON factura.idFactura = detalleFactura.idFactura\n"
                    + "WHERE factura.idFactura ='" + idFactura + "'";
            
            ResultSet rs = null;
            String registro[] = new String[5];
            double suma = 0;
            while (rs.next()) {
                registro[0] = rs.getString("idProducto");
                registro[1] = rs.getString("descripcion");
                registro[2] = "$ " + Utilidades.priceWithDecimal(
                        Double.parseDouble(Utilidades.priceWithDecimal(
                                rs.getDouble("precio"))));
                registro[3] = rs.getString("cantidad");
                suma += Double.parseDouble(Utilidades.priceWithDecimal(
                        rs.getDouble("Valor")));
                registro[4] = "$ " + Utilidades.priceWithDecimal(
                        Double.parseDouble(Utilidades.priceWithDecimal(
                                rs.getDouble("Valor"))));
                miTabla3.addRow(registro);
            }
            txtTotal.setValue(suma);
            tblDetalleFactura.setModel(miTabla3);
        } catch (SQLException ex) {
            //Instalar Logger
        }
        if (evt.getClickCount() == 2) {
            btnAceptarActionPerformed(null);
        }
    }//GEN-LAST:event_tblFacturaMouseClicked

    private void rbtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIDActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        tablaClientes();
    }//GEN-LAST:event_rbtIDActionPerformed

    private void rbtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtApellidosActionPerformed
        rbtIDActionPerformed(evt);
    }//GEN-LAST:event_rbtApellidosActionPerformed

    private void rbtNombesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNombesActionPerformed
        rbtIDActionPerformed(evt);
    }//GEN-LAST:event_rbtNombesActionPerformed

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        tablaClientes();
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        if (evt.getClickCount() == 1) {
            return;
        }
        frmSolicitudFecha miFecha = new frmSolicitudFecha(null, true);
        miFecha.setLocationRelativeTo(null);
        miFecha.setVisible(true);
        tblFactura.repaint();
        ajusteDetalle();
        String idCliente = tblClientes.getValueAt(
                tblClientes.getSelectedRow(), 0).toString();

        String sql = "SELECT f.idFactura, f.estado , f.fecha, f.USUARIO, "
                + "COALESCE(SUM(d.precio * d.cantidad), 0.00) AS Valor "
                + "FROM factura f "
                + "LEFT JOIN cliente c "
                + "    ON f.idCliente = c.idCliente "
                + "LEFT JOIN detalleFactura d "
                + "    ON f.idFactura = d.idFactura "
                + "WHERE f.idCliente = '" + idCliente + "' "
                + "GROUP BY f.idFactura, f.estado , f.fecha, f.USUARIO "
                + "order by 1";

        if (rbtIdFactura.isSelected()) {
            sql = "SELECT f.idFactura, f.estado , f.fecha, f.USUARIO, "
                    + "COALESCE(SUM(d.precio * d.cantidad), 0.00) AS Valor "
                    + "FROM factura f "
                    + "LEFT JOIN cliente c "
                    + "    ON f.idCliente = c.idCliente "
                    + "LEFT JOIN detalleFactura d "
                    + "    ON f.idFactura = d.idFactura "
                    + "WHERE f.idCliente = '" + idCliente + "' "
                    + "and f.idFactura = " + txtCriterio.getText()
                    + "GROUP BY f.idFactura, f.estado , f.fecha, f.USUARIO "
                    + "order by 1";
        }
        
        try {
            DefaultTableModel modelo = (DefaultTableModel) tblFactura.getModel();
            int filas = tblFactura.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }

            ResultSet rs = null;
            String registro[] = new String[4];

            while (rs.next()) {
                registro[0] = rs.getString("idFactura");
                registro[1] = rs.getString("fecha");
                registro[2] = "RD$ " + Utilidades.priceWithDecimal(rs.getDouble("Valor"));
                String estado = rs.getString("Estado");
                if (estado.equals("p")) {
                    estado = "Pagada";
                }
                if (estado.equals("a")) {
                    estado = "Abonada";
                }
                if (estado.equals("c")) {
                    estado = "Credito";
                }
                if (estado.equals("t")) {
                    estado = "Temporal";
                }
                if(estado.equals("x")){
                    estado = "Asignada: " + rs.getString("Usuario");
                }
                
                registro[3] = estado;

                miTabla2.addRow(registro);
            }
            tblFactura.setModel(miTabla2);
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblDetalleFactura.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado Factura");
            return;
        }
        Map parametros = new HashMap();
        parametros.put("idFactura", Integer.parseInt(
                tblFactura.getValueAt(
                        tblFactura.getSelectedRow(), 0).toString()));
        hiloImpresionFactura impresionFactura = new hiloImpresionFactura(
                true,
                false,
                System.getProperty("user.dir") + "/Reportes/factura(copia).jasper",
                parametros);
        impresionFactura.start();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        tablaClientes();
    }//GEN-LAST:event_txtCriterioKeyReleased

    private void rbtIdFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIdFacturaActionPerformed
        rbtIDActionPerformed(evt);
    }//GEN-LAST:event_rbtIdFacturaActionPerformed
    void tablaClientes() {
        String titulos[] = {"ID Cliente", "Nombres y Apellidos", "Credito", "Deuda Actual"};
        String registro[] = new String[4];
        miTabla = new DefaultTableModel(null, titulos);

        String sql = "";
        if (txtCriterio.getText().equals("")) {
            sql = "SELECT r.IDCLIENTE, r.NOMBRES, r.APELLIDOS, r.CREDITO, "
                    + "r.DEUDAACTUAL "
                    + "FROM Tabla_Clientes r ";
        } else {
            if (rbtNombes.isSelected()) {
                sql = "SELECT r.IDCLIENTE, r.NOMBRES, r.APELLIDOS, r.CREDITO, "
                        + "r.DEUDAACTUAL "
                        + "FROM Tabla_Clientes r "
                        + "where nombres CONTAINING '" + txtCriterio.getText() + "'";
            }
            if (rbtApellidos.isSelected()) {
                sql = "SELECT r.IDCLIENTE, r.NOMBRES, r.APELLIDOS, r.CREDITO, "
                        + "r.DEUDAACTUAL "
                        + "FROM Tabla_Clientes r "
                        + "where apellidos CONTAINING '" + txtCriterio.getText() + "'";
            }
            if (rbtID.isSelected()) {
                sql = "SELECT r.IDCLIENTE, r.NOMBRES, r.APELLIDOS, r.CREDITO, "
                        + "r.DEUDAACTUAL "
                        + "FROM Tabla_Clientes r "
                        + "where idCliente CONTAINING '" + txtCriterio.getText() + "'";
            }
            if (rbtIdFactura.isSelected()) {
                sql = "SELECT f.IDCLIENTE, c.NOMBRES, c.Apellidos, c.credito, "
                        + "c.deudaactual "
                        + "FROM tabla_Facturas f "
                        + "    left join tabla_Clientes c "
                        + "        on c.IDCLIENTE = f.IDCLIENTE "
                        + "where f.IDFACTURA = " + txtCriterio.getText() + "";
            }
        }
        //llenar Tabla con el Query        
        ResultSet rs = null;

        try {
            while (rs.next()) {
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("nombres") + " " + rs.getString("apellidos");
                registro[2] = "$ " + Utilidades.priceWithDecimal(Double.parseDouble(Utilidades.priceWithDecimal(rs.getDouble("credito"))));
                registro[3] = "$ " + Utilidades.priceWithDecimal(Double.parseDouble(Utilidades.priceWithDecimal(rs.getDouble("deudaActual"))));
                miTabla.addRow(registro);
            }
            tblClientes.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }

        //**************************Para Alinear el Texto de la Table a la Derecha...
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblClientes.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tblClientes.getColumnModel().getColumn(3).setCellRenderer(tcr);
        /////////////////////////////////////////////////////////////////Finn

        /*Ancho de Columnas de Clientes*/
        for (int i = 0; i <= 3; i++) {
            miTableColumn = tblClientes.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(210);
                //JTable tabla = new JTable(modelo.isCellEditable(proAct, WIDTH));
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(500);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(170);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(190);
            }
        }/////FIN---------------------------------------------------------------

        ajusteFactura();
        ajusteDetalle();
        txtTotal.setValue(0);
    }

    private void ajusteFactura() {
        //Segunda Tabla....=_=_=_=_=_=_=_=_=_=_=_=_=_
        String titulos2[] = {"ID Factura", "Fecha", "Valor", "Estado"};
        miTabla2 = new DefaultTableModel(null, titulos2);
        tblFactura.setModel(miTabla2);

        //Para Alinear Columnas 2 en Factuas Clientes
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblFactura.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    private void ajusteDetalle() {
        //Tercera Tabla....=_=_=_=_=_=_=_=_=_=_=_=_=_
        String titulos3[] = {"ID Producto", "Descripcion", "Precio", "Cantidad", "Valor"};
        miTabla3 = new DefaultTableModel(null, titulos3);
        tblDetalleFactura.setModel(miTabla3);

        //Para Alinear Columnas 2 y 4 en Factura
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblDetalleFactura.getColumnModel().getColumn(2).setCellRenderer(tcr);
        tblDetalleFactura.getColumnModel().getColumn(4).setCellRenderer(tcr);

        /*Ancho de Columnas de Facturas*/
        miTableColumn = null;
        for (int i = 0; i <= 4; i++) {
            miTableColumn = tblDetalleFactura.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(150);
                //JTable tabla = new JTable(modelo.isCellEditable(proAct, WIDTH));
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(500);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(110);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(110);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(140);
            }
        }/////FIN
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrTipoBusqueda;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JRadioButton rbtApellidos;
    private javax.swing.JRadioButton rbtID;
    private javax.swing.JRadioButton rbtIdFactura;
    private javax.swing.JRadioButton rbtNombes;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblDetalleFactura;
    private javax.swing.JTable tblFactura;
    private javax.swing.JTextField txtCriterio;
    private javax.swing.JFormattedTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
