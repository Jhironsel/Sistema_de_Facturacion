package sur.softsurena.formularios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import sur.softsurena.metodos.Imagenes;
import static sur.softsurena.metodos.M_Usuario.cambioClave;
import static sur.softsurena.metodos.M_Usuario.getUsuarioActual;

public class frmCambioClave extends javax.swing.JDialog {

    public frmCambioClave(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Imagenes icon = new Imagenes("Panel de Control 128 x 128.png");
        jlFoto.setIcon(icon.getIcono());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlFoto = new javax.swing.JLabel();
        txtNueva = new RSMaterialComponent.RSPasswordIconOne();
        txtConfirmacion = new RSMaterialComponent.RSPasswordIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        start1 = new necesario.LabelIcon();
        start2 = new necesario.LabelIcon();
        start3 = new necesario.LabelIcon();
        start4 = new necesario.LabelIcon();
        start5 = new necesario.LabelIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cambio de Clave");
        setUndecorated(true);
        setResizable(false);

        jlFoto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlFoto.setDoubleBuffered(true);

        txtNueva.setDoubleBuffered(true);
        txtNueva.setPlaceholder("Ingrese nueva contraseña");
        txtNueva.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNuevaCaretUpdate(evt);
            }
        });
        txtNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevaActionPerformed(evt);
            }
        });

        txtConfirmacion.setColorIcon(new java.awt.Color(102, 255, 0));
        txtConfirmacion.setDoubleBuffered(true);
        txtConfirmacion.setPlaceholder("Confirme clave anterior");
        txtConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacionActionPerformed(evt);
            }
        });
        txtConfirmacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConfirmacionKeyReleased(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setDoubleBuffered(true);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setThemeTooltip(necesario.Global.THEMETOOLTIP.LIGHT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.setDoubleBuffered(true);
        btnAceptar.setEnabled(false);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        jLabel6.setText("especial");
        jLabel6.setDoubleBuffered(true);

        jLabel5.setText("5) Debe contener caracter");
        jLabel5.setDoubleBuffered(true);

        jLabel4.setText("4) Debe contener minimo 10");
        jLabel4.setDoubleBuffered(true);

        jLabel3.setText("3) Debe contener numeros");
        jLabel3.setDoubleBuffered(true);

        jLabel2.setText("2) Debe contener mayusculas");
        jLabel2.setDoubleBuffered(true);

        jLabel1.setText("1) Debe contener minusculas");
        jLabel1.setDoubleBuffered(true);

        jPanel3.setLayout(new java.awt.GridLayout(1, 5, 10, 0));

        start1.setDoubleBuffered(true);
        start1.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        jPanel3.add(start1);

        start2.setDoubleBuffered(true);
        start2.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        jPanel3.add(start2);

        start3.setDoubleBuffered(true);
        start3.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        jPanel3.add(start3);

        start4.setDoubleBuffered(true);
        start4.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        jPanel3.add(start4);

        start5.setDoubleBuffered(true);
        start5.setFont(new java.awt.Font("FreeSans", 0, 12)); // NOI18N
        start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        jPanel3.add(start5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                            .addComponent(txtNueva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevaActionPerformed
        txtConfirmacion.requestFocusInWindow();
    }//GEN-LAST:event_txtNuevaActionPerformed

    private void txtConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacionActionPerformed
        btnAceptar.doClick();
    }//GEN-LAST:event_txtConfirmacionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nueva = new String(txtNueva.getPassword());
        String confirmacion = new String(txtConfirmacion.getPassword());
        
        if (nueva.isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar Clave Nueva...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNueva.requestFocusInWindow();
            return;
        }
        
        if (confirmacion.isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe de Ingresar Confirmacion...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtConfirmacion.requestFocusInWindow();
            return;
        }

        if (!nueva.equals(confirmacion)) {
            JOptionPane.showMessageDialog(
                    this,
                    "La Clave y la confirmacion no Coinciden...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtConfirmacion.setText("");
            txtNueva.setText("");
            return;
        }

        //Cambiamos la Clave
        //r es la variable resultado que espera la operacion sea realizada. 
        boolean resultado = cambioClave(getUsuarioActual().getUser_name().strip(), 
                nueva
        );
        
        JOptionPane.showMessageDialog(
                this,
                (resultado ? "Clave Cambiada..." : "Error al cambiar la clave."),
                "",
                (resultado ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE)
        );
        
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed


    private void txtNuevaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNuevaCaretUpdate
        /*Si el tamaño del campo es cero se colocan todas las estrellas vacias*/
        if (txtNueva.getPassword().length <= 1) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        }

        if (txtNueva.getPassword().length > 2 && txtNueva.getPassword().length < 4) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_HALF);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        }

        if (txtNueva.getPassword().length > 4 && txtNueva.getPassword().length < 6) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_HALF);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        }

        if (txtNueva.getPassword().length > 6 && txtNueva.getPassword().length < 8) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
        }

        if (txtNueva.getPassword().length == 8) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_HALF);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);

        }

        for (char c : txtNueva.getPassword()) {//Digitos 1-9
            if (c > 48 && c < 57 && txtNueva.getPassword().length > 8) {
                start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
                start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            }
        }

        for (char c : txtNueva.getPassword()) {//Mayusculas
            if (c > 65 && c < 90 && txtNueva.getPassword().length > 8) {
                start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_HALF);
                start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            }
        }

        for (char c : txtNueva.getPassword()) {//Minusculas
            if (c > 97 && c < 122 && txtNueva.getPassword().length > 8) {
                start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
                start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR_BORDER);
            }
        }

        String regex = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(String.valueOf(txtNueva.getPassword()));

        if (matcher.find()) {
            start1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start3.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start4.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
            start5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.STAR);
        }

        update(this.getGraphics());
    }//GEN-LAST:event_txtNuevaCaretUpdate

    private void txtConfirmacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmacionKeyReleased
        if(txtConfirmacion.getPassword().length == txtNueva.getPassword().length){
            btnAceptar.setEnabled(true);
        }else{
            btnAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_txtConfirmacionKeyReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlFoto;
    private necesario.LabelIcon start1;
    private necesario.LabelIcon start2;
    private necesario.LabelIcon start3;
    private necesario.LabelIcon start4;
    private necesario.LabelIcon start5;
    private RSMaterialComponent.RSPasswordIconOne txtConfirmacion;
    private RSMaterialComponent.RSPasswordIconOne txtNueva;
    // End of variables declaration//GEN-END:variables
}
