package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import sur.softsurena.entidades.Usuario;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmSolicitudFecha extends javax.swing.JDialog {

    public frmSolicitudFecha(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jmMes = new com.toedter.calendar.JMonthChooser();
        jyAnno = new com.toedter.calendar.JYearChooser();
        cbCajeros = new javax.swing.JCheckBox();
        jcbUsuarios = new javax.swing.JComboBox();
        cbFechaFacturas = new javax.swing.JCheckBox();
        jsInicio = new javax.swing.JSpinner();
        cbIntervalosFactura = new javax.swing.JCheckBox();
        jsFin = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jcEstados = new javax.swing.JComboBox<>();
        cbEstados = new javax.swing.JCheckBox();
        cbFechaFacturasDia = new javax.swing.JCheckBox();
        jdDia = new com.toedter.calendar.JDateChooser();
        cbSinFecha = new javax.swing.JCheckBox();
        cbFechaRango = new javax.swing.JCheckBox();
        jdDiaRango = new com.toedter.calendar.JDateChooser();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar1 = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filtrando Busquedas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jmMes.setEnabled(false);
        jmMes.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jyAnno.setEnabled(false);

        cbCajeros.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbCajeros.setText("Todos los Cajeros");
        cbCajeros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCajerosActionPerformed(evt);
            }
        });

        jcbUsuarios.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcbUsuarios.setEnabled(false);

        buttonGroup1.add(cbFechaFacturas);
        cbFechaFacturas.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbFechaFacturas.setText("Fechas de Facturas");
        cbFechaFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaFacturasActionPerformed(evt);
            }
        });

        jsInicio.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsInicio.setEnabled(false);

        cbIntervalosFactura.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbIntervalosFactura.setText("Intervalos de Facturas");
        cbIntervalosFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIntervalosFacturaActionPerformed(evt);
            }
        });

        jsFin.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jsFin.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criterios de Busquedas");

        jcEstados.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jcEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un estado", "Pagada", "Credito", "Abono" }));
        jcEstados.setEnabled(false);

        cbEstados.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbEstados.setText("Estados");
        cbEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadosActionPerformed(evt);
            }
        });

        buttonGroup1.add(cbFechaFacturasDia);
        cbFechaFacturasDia.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbFechaFacturasDia.setText("Fecha dia de Facturas");
        cbFechaFacturasDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaFacturasDiaActionPerformed(evt);
            }
        });

        jdDia.setEnabled(false);
        jdDia.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        buttonGroup1.add(cbSinFecha);
        cbSinFecha.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbSinFecha.setSelected(true);
        cbSinFecha.setText("Sin Fecha");
        cbSinFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSinFechaActionPerformed(evt);
            }
        });

        cbFechaRango.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        cbFechaRango.setText("Entre rango");
        cbFechaRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaRangoActionPerformed(evt);
            }
        });

        jdDiaRango.setEnabled(false);
        jdDiaRango.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Aceptar");
        btnCancelar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar1.setName("btnCancelar"); // NOI18N
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbEstados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcEstados, 0, 404, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jsInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jsFin, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbIntervalosFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCajeros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jyAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbFechaFacturasDia)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbFechaFacturas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbSinFecha))
                    .addComponent(jdDiaRango, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbFechaRango))
                .addGap(6, 6, 6))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(cbCajeros)
                .addGap(0, 0, 0)
                .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFechaFacturas)
                    .addComponent(cbSinFecha))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jyAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jmMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(cbFechaFacturasDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdDia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbFechaRango)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdDiaRango, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbIntervalosFactura)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(cbEstados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql = "SELECT r.IDUSUARIO, (r.NOMBRES||' '||r.APELLIDOS) AS Nombre "
                + "FROM TABLA_USUARIOS r "
                + "WHERE r.ESTADO = 1 AND r.BORRADO LIKE 'n'";

        Usuario user = Usuario.builder().
                user_name("").
                pnombre("").
                snombre("").
                apellidos("").build();

        jcbUsuarios.addItem(user);

        ResultSet rs = null;

        try {
            while (rs.next()) {
                user = Usuario.builder().
                        user_name("").
                        pnombre("").
                        snombre("").
                        apellidos("").build();

                jcbUsuarios.addItem(user);
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }


    }//GEN-LAST:event_formWindowOpened

    private void cbCajerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCajerosActionPerformed
        if (cbCajeros.isSelected()) {
            jcbUsuarios.setEnabled(true);
        } else {
            jcbUsuarios.setEnabled(false);
        }
    }//GEN-LAST:event_cbCajerosActionPerformed

    private void cbIntervalosFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIntervalosFacturaActionPerformed
        if (cbIntervalosFactura.isSelected()) {
            jsInicio.setEnabled(true);
            jsFin.setEnabled(true);
        } else {
            jsInicio.setEnabled(false);
            jsFin.setEnabled(false);
        }
    }//GEN-LAST:event_cbIntervalosFacturaActionPerformed

    private void cbFechaFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaFacturasActionPerformed
        if (cbFechaFacturas.isSelected()) {
            jmMes.setEnabled(true);
            jyAnno.setEnabled(true);
            cbFechaFacturasDiaActionPerformed(evt);
        } else {
            jmMes.setEnabled(false);
            jyAnno.setEnabled(false);
        }
    }//GEN-LAST:event_cbFechaFacturasActionPerformed

    private void cbFechaFacturasDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaFacturasDiaActionPerformed
        if (cbFechaFacturasDia.isSelected()) {
            jdDia.setEnabled(true);
            cbFechaFacturasActionPerformed(evt);
        } else {
            jdDia.setEnabled(false);
        }
    }//GEN-LAST:event_cbFechaFacturasDiaActionPerformed

    private void cbEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadosActionPerformed
        if (cbEstados.isSelected()) {
            jcEstados.setEnabled(true);
        } else {
            jcEstados.setEnabled(false);
        }
    }//GEN-LAST:event_cbEstadosActionPerformed

    private void cbSinFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSinFechaActionPerformed
        cbFechaFacturasDiaActionPerformed(evt);
        cbFechaFacturasActionPerformed(evt);
    }//GEN-LAST:event_cbSinFechaActionPerformed

    private void cbFechaRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaRangoActionPerformed
        if (!cbFechaFacturasDia.isSelected()) {
            cbFechaRango.doClick();
            return;
        }
        if (cbFechaRango.isSelected()) {
            jdDiaRango.setEnabled(true);
        } else {
            jdDiaRango.setEnabled(false);
        }
    }//GEN-LAST:event_cbFechaRangoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        if (cbCajeros.isSelected()) {
            if (jcbUsuarios.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe seleccionar un usuario",
                        "",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (cbFechaFacturasDia.isSelected()) {
            if (Objects.isNull(jdDia.getDate())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Digiste una fecha",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            if (jdDia.getDate().after(new Date())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Fecha futura, incorrecta!!!",
                        "", 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        if (cbIntervalosFactura.isSelected()) {
            if (Utilidades.objectToInt(jsInicio.getValue())
                    > Utilidades.objectToInt(jsFin.getValue())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Intervalo de factura, incorrecto!!!",
                        "", 
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        if (cbEstados.isSelected()) {
            if (jcEstados.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debe seleccionar un estado",
                        "", 
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
        //TODO Hay que analizar que sigue despues de las lineas de arriba.
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbCajeros;
    private javax.swing.JCheckBox cbEstados;
    private javax.swing.JCheckBox cbFechaFacturas;
    private javax.swing.JCheckBox cbFechaFacturasDia;
    private javax.swing.JCheckBox cbFechaRango;
    private javax.swing.JCheckBox cbIntervalosFactura;
    private javax.swing.JCheckBox cbSinFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> jcEstados;
    private javax.swing.JComboBox jcbUsuarios;
    private com.toedter.calendar.JDateChooser jdDia;
    private com.toedter.calendar.JDateChooser jdDiaRango;
    private com.toedter.calendar.JMonthChooser jmMes;
    private javax.swing.JSpinner jsFin;
    private javax.swing.JSpinner jsInicio;
    private com.toedter.calendar.JYearChooser jyAnno;
    // End of variables declaration//GEN-END:variables
}
