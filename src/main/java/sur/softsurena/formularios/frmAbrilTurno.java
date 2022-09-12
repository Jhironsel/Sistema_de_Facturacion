package sur.softsurena.formularios;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static sur.softsurena.datos.procedure.ProcedureMetodos.habilitarTurno;
import static sur.softsurena.datos.select.SelectMetodos.getUsuarios;
import static sur.softsurena.datos.select.SelectMetodos.usuarioTurnoActivo;
import sur.softsurena.entidades.Opcion;
import sur.softsurena.entidades.Usuarios;

public class frmAbrilTurno extends java.awt.Dialog {

    private boolean aceptar;

    public boolean isAceptar() {
        return aceptar;
    }
    private void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }
        

    public frmAbrilTurno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbUsuarios = new javax.swing.JComboBox();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setAlwaysOnTop(true);
        setResizable(false);
        setTitle("Abrir Turno a Cajero");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jcbUsuarios.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        btnAceptar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Cajeros:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Habilitar Turno");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap())
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        getAccessibleContext().setAccessibleParent(this);

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
        if(usuarioTurnoActivo(idUsuario)){
            JOptionPane.showMessageDialog(this, "Usuario con Turno Abierto...");
            return;
        }
        if (habilitarTurno(idUsuario)) {
            JOptionPane.showMessageDialog(this, "Turno Habilitado");
        } else {
            JOptionPane.showMessageDialog(this, "Problema para habilitar el Turno");
        }
        
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
        Usuarios usuario = Usuarios.builder().
                user_name("N/A").
                pNombre("Seleccione un Usuario").
                sNombre("").
                apellidos("").build();
        jcbUsuarios.removeAllItems();
        jcbUsuarios.addItem(usuario);
        ResultSet rs = getUsuarios("all");
        try {
            while (rs.next()) {
                
                if(rs.getBoolean("O_ESTADO_ACTIVO")){
                    usuario = Usuarios.builder().
                            user_name(rs.getString("O_USER_NAME")).
                            pNombre(rs.getString("O_PRIMER_NOMBRE")).
                            sNombre(rs.getString("p.O_SEGUNDO_NOMBRE")).
                            apellidos(rs.getString("O_APELLIDOS")).build();
                    jcbUsuarios.addItem(usuario);
                }
                
                

            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox jcbUsuarios;
    // End of variables declaration//GEN-END:variables

}
