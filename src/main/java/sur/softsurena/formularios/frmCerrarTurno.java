package sur.softsurena.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import static sur.softsurena.datos.procedure.ProcedureMetodos.cerrarTurno;
import static sur.softsurena.datos.select.SelectMetodos.idTurnoActivo;
import static sur.softsurena.datos.select.SelectMetodos.usuarioTurnoActivo;
import sur.softsurena.entidades.Opcion;
import sur.softsurena.hilos.hiloImpresionFactura;

public class frmCerrarTurno extends java.awt.Dialog {

    private int idTurno;
    private boolean aceptar;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }


    public frmCerrarTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gradientPreviewPanel1 = new org.jdesktop.swingx.color.GradientPreviewPanel();
        jcbUsuarios = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setResizable(false);
        setTitle("Cerrar Turno de Cajero");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jcbUsuarios.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel1.setText("Cajeros:");

        btnAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cerrar Turno");

        javax.swing.GroupLayout gradientPreviewPanel1Layout = new javax.swing.GroupLayout(gradientPreviewPanel1);
        gradientPreviewPanel1.setLayout(gradientPreviewPanel1Layout);
        gradientPreviewPanel1Layout.setHorizontalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(180, 180, 180))
                    .addComponent(jcbUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientPreviewPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        gradientPreviewPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        gradientPreviewPanel1Layout.setVerticalGroup(
            gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientPreviewPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gradientPreviewPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gradientPreviewPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPreviewPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gradientPreviewPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered
    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String idUsuario = ((Opcion) jcbUsuarios.getSelectedItem()).getValor();
        if (idUsuario.equals("0")) {
            JOptionPane.showMessageDialog(this, "Debe Seleccionar un Usuario");
            return;
        }
        if (!usuarioTurnoActivo(idUsuario)) {
            JOptionPane.showMessageDialog(this, "Usuario sin Turno Abierto...");
            return;
        }

        setIdTurno(idTurnoActivo(idUsuario));

        if (cerrarTurno(idUsuario)) {
            JOptionPane.showMessageDialog(this, "Turno Cerrado");
        } else {
            JOptionPane.showMessageDialog(this, "Problema para cerrar Turno");
        }
        
        imprimirReporte(((Opcion) jcbUsuarios.getSelectedItem()).getDescripcion());
        setAceptar(true);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setForeground(Color.blue);
    }//GEN-LAST:event_btnCancelarMouseEntered
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setAceptar(false);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Opcion miOpcion = new Opcion("0", "Seleccione un Usuario");
        jcbUsuarios.removeAllItems();
        jcbUsuarios.addItem(miOpcion);
        ResultSet rs = getUsuariosActivo();
        try {
            while (rs.next()) {
                miOpcion = new Opcion(
                        rs.getString("idUsuario"),
                        rs.getString("Nombres") + " " + rs.getString("Apellidos")
                );
                jcbUsuarios.addItem(miOpcion);

            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_formWindowOpened
    private void imprimirReporte(String nombreUsuario) {
        Map parametros = new HashMap();
        parametros.put("idTurno", getIdTurno());
        parametros.put("idUsuario", nombreUsuario);
        hiloImpresionFactura miHilo = new hiloImpresionFactura(
                true,//Mostrar Reporte
                false,//Con Copia
                System.getProperty("user.dir") + "/Reportes/reporteCuadre.jasper", 
                parametros);
        miHilo.start();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private org.jdesktop.swingx.color.GradientPreviewPanel gradientPreviewPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox jcbUsuarios;
    // End of variables declaration//GEN-END:variables
}
