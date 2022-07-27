package sur.softsurena.formularios;

import java.awt.Color;
import javax.swing.JOptionPane;
import static sur.softsurena.datos.alter.AlterMetodos.cambioClave;
import sur.softsurena.metodos.Imagenes;

public class frmCambioClave extends javax.swing.JDialog {

    private String clave;
    private String usuario;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public frmCambioClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Imagenes icon = new Imagenes("Panel de Control 128 x 128.png");
        jlFoto.setIcon(icon.getICono());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        txtActual = new RSMaterialComponent.RSPasswordIconOne();
        txtNueva = new RSMaterialComponent.RSPasswordIconOne();
        txtConfirmacion = new RSMaterialComponent.RSPasswordIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        panel1 = new necesario.Panel();
        start1 = new necesario.LabelIcon();
        start2 = new necesario.LabelIcon();
        start3 = new necesario.LabelIcon();
        start4 = new necesario.LabelIcon();
        start5 = new necesario.LabelIcon();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio de Clave");
        setResizable(false);

        jlFoto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtActual.setColorIcon(new java.awt.Color(255, 0, 0));
        txtActual.setPlaceholder("Ingrese contraseña actual");
        txtActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActualActionPerformed(evt);
            }
        });

        txtNueva.setPlaceholder("Ingrese nueva contraseña");
        txtNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevaActionPerformed(evt);
            }
        });
        txtNueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNuevaKeyReleased(evt);
            }
        });

        txtConfirmacion.setColorIcon(new java.awt.Color(102, 255, 0));
        txtConfirmacion.setPlaceholder("Confirme clave anterior");
        txtConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacionActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setEnabled(false);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Medidor de contraseñas"));
        panel1.setOpaque(false);

        start1.setForeground(new java.awt.Color(255, 255, 0));
        start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        start2.setForeground(new java.awt.Color(255, 255, 0));
        start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        start3.setForeground(new java.awt.Color(255, 255, 0));
        start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        start4.setForeground(new java.awt.Color(255, 255, 0));
        start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        start5.setForeground(new java.awt.Color(255, 255, 0));
        start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        jLabel1.setText("1) Debe contener minusculas");

        jLabel2.setText("2) Debe contener mayusculas");

        jLabel3.setText("3) Debe contener numeros");

        jLabel4.setText("4) Debe contener minimo 10");

        jLabel5.setText("5) Debe contener caracter");

        jLabel6.setText("especial");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(start1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(start2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(start3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(start4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(start5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(start5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addComponent(txtNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtActual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActualActionPerformed
        txtNueva.requestFocusInWindow();
    }//GEN-LAST:event_txtActualActionPerformed

    private void txtNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevaActionPerformed
        txtConfirmacion.requestFocusInWindow();
    }//GEN-LAST:event_txtNuevaActionPerformed

    private void txtConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacionActionPerformed
        btnAceptarActionPerformed(evt);
    }//GEN-LAST:event_txtConfirmacionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String actual = new String(txtActual.getPassword());
        String nueva = new String(txtNueva.getPassword());
        String confirmacion = new String(txtConfirmacion.getPassword());

        if (actual.equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe de Ingresar Clave Actual...");
            txtActual.requestFocusInWindow();
            return;
        }
        if (nueva.equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe ingresar Clave Nueva...");
            txtNueva.requestFocusInWindow();
            return;
        }
        if (confirmacion.equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe de Ingresar Confirmacion...");
            txtConfirmacion.requestFocusInWindow();
            return;
        }

        if (!actual.equals(clave)) {
            JOptionPane.showMessageDialog(rootPane,
                    "La clave no corresponde a la clave del Usuario ingresado");
            txtActual.setText("");
            txtActual.requestFocusInWindow();
            return;
        }
        if (!nueva.equals(confirmacion)) {
            JOptionPane.showMessageDialog(rootPane,
                    "La Clave y la confirmacion no Coinciden...");
            txtActual.setText("");
            txtConfirmacion.setText("");
            txtNueva.setText("");
            txtActual.requestFocusInWindow();
            return;
        }

        //Cambiamos la Clave
        cambioClave(usuario, nueva);
        JOptionPane.showMessageDialog(rootPane,
                "Clave Cambiada...");
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private int[] condiciones = {0, 0, 0, 0, 0};
    private void txtNuevaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaKeyReleased
        /*Si el tamaño del campo es cero se colocan todas las estrellas vacias*/
        if (txtNueva.getPassword().length == 0) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            return;
        }

        for (char c : txtNueva.getPassword()) {

            if (c > 48 && c < 57) {
                if(condiciones[0] == 0){
                    condiciones[0] = 10;
                }
                if(condiciones[0] == 10){
                    condiciones[0] = 20;
                }
            }

            if (c > 65 && c < 90) {
                if(condiciones[1] == 0){
                    condiciones[1] = 10;
                }
                if(condiciones[1] == 10){
                    condiciones[1] = 20;
                }
            }

            if (c > 97 && c < 122) {
                if(condiciones[2] == 0){
                    condiciones[2] = 10;
                }
                if(condiciones[2] == 10){
                    condiciones[2] = 20;
                }
            }

            if (txtNueva.getPassword().length > 9) {
                if(condiciones[3] == 0){
                    condiciones[3] = 10;
                }
                if(condiciones[3] == 10){
                    condiciones[3] = 20;
                }
            }

            if (c > 32 || c < 48
                    || c > 57 || c < 65
                    || c > 90 || c < 97
                    || c > 122 || c < 126) {
                if(condiciones[4] == 0){
                    condiciones[4] = 10;
                }
                if(condiciones[4] == 10){
                    condiciones[4] = 20;
                }else{
                    condiciones[4] = 0;
                }
            }
        }
        
        

        start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
        start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
        start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
        start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
        start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
    }//GEN-LAST:event_txtNuevaKeyReleased
    public void limpiar() {
        txtActual.setText("");
        txtConfirmacion.setText("");
        txtNueva.setText("");
        txtActual.requestFocusInWindow();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar1;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar2;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlFoto;
    private necesario.Panel panel1;
    private necesario.LabelIcon start1;
    private necesario.LabelIcon start2;
    private necesario.LabelIcon start3;
    private necesario.LabelIcon start4;
    private necesario.LabelIcon start5;
    private RSMaterialComponent.RSPasswordIconOne txtActual;
    private RSMaterialComponent.RSPasswordIconOne txtConfirmacion;
    private RSMaterialComponent.RSPasswordIconOne txtNueva;
    // End of variables declaration//GEN-END:variables
}
