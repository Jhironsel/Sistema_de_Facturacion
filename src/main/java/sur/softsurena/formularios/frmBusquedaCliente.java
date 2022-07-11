package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmBusquedaCliente extends javax.swing.JDialog {

    private DefaultTableModel miTabla;
    private String respuesta = "";

    public String getRespuesta() {
        return respuesta;
    }

    public frmBusquedaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //Agrupamos los botones para que sean excluyentes
        bgrTipoBusqueda.add(rbtID);
        bgrTipoBusqueda.add(rbtNombes);
        bgrTipoBusqueda.add(rbtApellidos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgrTipoBusqueda = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        rbtID = new javax.swing.JRadioButton();
        rbtNombes = new javax.swing.JRadioButton();
        rbtApellidos = new javax.swing.JRadioButton();
        txtCriterio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Busqueda de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblTabla.setForeground(new java.awt.Color(1, 1, 1));
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
        tblTabla.setAutoscrolls(false);
        tblTabla.setGridColor(new java.awt.Color(1, 1, 1));
        jScrollPane1.setViewportView(tblTabla);

        rbtID.setForeground(new java.awt.Color(1, 1, 1));
        rbtID.setMnemonic('i');
        rbtID.setSelected(true);
        rbtID.setText("ID");
        rbtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIDActionPerformed(evt);
            }
        });

        rbtNombes.setForeground(new java.awt.Color(1, 1, 1));
        rbtNombes.setMnemonic('n');
        rbtNombes.setText("Nombres");
        rbtNombes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtNombesActionPerformed(evt);
            }
        });

        rbtApellidos.setForeground(new java.awt.Color(1, 1, 1));
        rbtApellidos.setMnemonic('a');
        rbtApellidos.setText("Apellidos");
        rbtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtApellidosActionPerformed(evt);
            }
        });

        txtCriterio.setForeground(new java.awt.Color(1, 1, 1));
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

        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setBorder(null);
        btnAceptar.setMaximumSize(new java.awt.Dimension(66, 42));
        btnAceptar.setMinimumSize(new java.awt.Dimension(66, 42));
        btnAceptar.setPreferredSize(new java.awt.Dimension(66, 42));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setBorder(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rbtID, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtNombes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtApellidos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCriterio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {rbtApellidos, rbtNombes});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtID)
                    .addComponent(rbtApellidos)
                    .addComponent(rbtNombes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtNombesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtNombesActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        llenarTabla();
    }//GEN-LAST:event_rbtNombesActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
        txtCriterio.requestFocusInWindow();

    }//GEN-LAST:event_formWindowOpened

    private void rbtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtApellidosActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        llenarTabla();
    }//GEN-LAST:event_rbtApellidosActionPerformed

    private void rbtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIDActionPerformed
        txtCriterio.setText("");
        txtCriterio.requestFocusInWindow();
        llenarTabla();
    }//GEN-LAST:event_rbtIDActionPerformed

    private void txtCriterioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioActionPerformed
        llenarTabla();
        btnAceptarActionPerformed(evt);
    }//GEN-LAST:event_txtCriterioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        respuesta = "";
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        int num = tblTabla.getRowCount();
        if (num == 0) {
            respuesta = "";
            dispose();
            return;
        }
        for (int i = 0; i < num; i++) {
            if (tblTabla.isRowSelected(i)) {
                respuesta = (tblTabla.getValueAt(i, 0).toString());
                dispose();
                return;
            }
        }
        respuesta = (tblTabla.getValueAt(0, 0)).toString();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtCriterioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCriterioKeyReleased
        llenarTabla();
    }//GEN-LAST:event_txtCriterioKeyReleased

    private void llenarTabla() {
        String titulos[] = {"ID Cliente", "Nombres", "Apellidos"};
        miTabla = new DefaultTableModel(null, titulos);

        String sql = null;
        if (txtCriterio.getText().equals("")) {
            sql = "select idCliente, nombres, apellidos "
                    + "from tabla_clientes "
                    + "where estado = 1 order by 1";
        } else {
            if (rbtNombes.isSelected()) {
                sql = "select idCliente, nombres, apellidos "
                        + "from tabla_clientes "
                        + "where nombres like '" + txtCriterio.getText() + "%' and estado = 1";
            }
            if (rbtApellidos.isSelected()) {
                sql = "select idCliente, nombres, apellidos "
                        + "from tabla_clientes "
                        + "where apellidos like '" + txtCriterio.getText() + "%' and estado = 1";
            }
            if (rbtID.isSelected()) {
                sql = "select idCliente, nombres, apellidos "
                        + "from tabla_clientes "
                        + "where idCliente like '" + txtCriterio.getText() + "%' and estado = 1";
            }
        }

        ResultSet rs = ejecutarSQL(sql);

        Object registro[] = new Object[3];
        try {
            while (rs.next()) {
                registro[0] = rs.getString("idCliente");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgrTipoBusqueda;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtApellidos;
    private javax.swing.JRadioButton rbtID;
    private javax.swing.JRadioButton rbtNombes;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtCriterio;
    // End of variables declaration//GEN-END:variables
}
