package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static sur.softsurena.datos.select.SelectMetodos.existeUsuario;
import static sur.softsurena.datos.select.SelectMetodos.getRoles;
import sur.softsurena.entidades.Usuario;

public class frmUsuariosAgregar extends javax.swing.JDialog {

    private boolean nuevo;//Si el suario es nuevo o no
    private String revokeRol;
    
    /*Este constructor es utilizado para agregar nuevos usuarios*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarCombo();
        nuevo = true;
    }

    /*Este constructor es utilizado para cuando se vá a modificar un usuario,
    en el se inicianlizan todos los campos de formulario*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal, Usuario u) {
        super(parent, modal);
        initComponents();
        
        txtIDUsuario.setText(u.getUser_name());
        txtPNombre.setText(u.getPNombre());
        txtApellidos.setText(u.getApellidos());
        
        cbAutoriza.setSelected(u.getAdministrador());
        cbAutorizaActionPerformed(null);
        
        cbEstado.setSelected(u.getEstado());
        cbEstadoActionPerformed(null);
        
        revokeRol = u.getRol();
        llenarCombo();
        nuevo = false;

        for (int i = 1; i < cmbRol.getItemCount(); i++) {
            if (cmbRol.getItemAt(i).equalsIgnoreCase(u.getRol())) {
                cmbRol.setSelectedIndex(i);
                break;
            }
        }
        
        txtIDUsuario.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtIDUsuario = new rojeru_san.rsfield.RSTextFullRound();
        txtPNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtSNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtApellidos = new rojeru_san.rsfield.RSTextFullRound();
        txtClave1 = new rojeru_san.rsfield.RSPassViewRound();
        txtClave2 = new rojeru_san.rsfield.RSPassViewRound();
        cmbRol = new javax.swing.JComboBox<>();
        btnAdministradorPerfil = new javax.swing.JButton();
        cbAutoriza = new javax.swing.JCheckBox();
        cbEstado = new javax.swing.JCheckBox();
        btnAceptar = new rojeru_san.RSButtonRiple();
        btnCancelar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nuevo usuario");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jPanel5.setLayout(new java.awt.GridLayout(7, 1, 5, 5));

        txtIDUsuario.setToolTipText("Identificador del usuario en el sistema");
        txtIDUsuario.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtIDUsuario.setPhColor(new java.awt.Color(255, 255, 255));
        txtIDUsuario.setPlaceholder("ID Usuario");
        txtIDUsuario.setSoloLetras(true);
        txtIDUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUsuarioActionPerformed(evt);
            }
        });
        jPanel5.add(txtIDUsuario);

        txtPNombre.setToolTipText("Nombres del usuario");
        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtPNombre.setPhColor(new java.awt.Color(255, 255, 255));
        txtPNombre.setPlaceholder("Primer Nombre");
        txtPNombre.setSoloLetras(true);
        txtPNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPNombreActionPerformed(evt);
            }
        });
        jPanel5.add(txtPNombre);

        txtSNombre.setToolTipText("Nombres del usuario");
        txtSNombre.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtSNombre.setPhColor(new java.awt.Color(255, 255, 255));
        txtSNombre.setPlaceholder("Segundo Nombre");
        txtSNombre.setSoloLetras(true);
        txtSNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSNombreActionPerformed(evt);
            }
        });
        jPanel5.add(txtSNombre);

        txtApellidos.setToolTipText("Apellidos del usuario");
        txtApellidos.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtApellidos.setPhColor(new java.awt.Color(255, 255, 255));
        txtApellidos.setPlaceholder("Apellidos");
        txtApellidos.setSoloLetras(true);
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel5.add(txtApellidos);

        txtClave1.setToolTipText("Clave del suario para el sistema");
        txtClave1.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave1.setPhColor(new java.awt.Color(255, 255, 255));
        txtClave1.setPlaceholder("Ingrese clave");
        txtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave1ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave1);

        txtClave2.setToolTipText("Confirme la clave del usuario ");
        txtClave2.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave2.setPhColor(new java.awt.Color(255, 255, 255));
        txtClave2.setPlaceholder("Confirmación");
        txtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave2ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave2);

        cmbRol.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        cmbRol.setForeground(new java.awt.Color(255, 255, 255));
        cmbRol.setMaximumRowCount(4);
        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Rol", "Administrador", "Cajero" }));
        cmbRol.setToolTipText("Seleccionar un rol para el usuario");
        cmbRol.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeMono", 0, 19), new java.awt.Color(51, 102, 255))); // NOI18N
        jPanel5.add(cmbRol);

        btnAdministradorPerfil.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAdministradorPerfil.setMnemonic('R');
        btnAdministradorPerfil.setText("Roles");
        btnAdministradorPerfil.setToolTipText("Permisos que se le ortorgan a los roles");
        btnAdministradorPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorPerfilActionPerformed(evt);
            }
        });

        cbAutoriza.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbAutoriza.setMnemonic('D');
        cbAutoriza.setText("No Delegar");
        cbAutoriza.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbAutoriza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutorizaActionPerformed(evt);
            }
        });

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setMnemonic('T');
        cbEstado.setText("Inactivo");
        cbEstado.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnAdministradorPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbAutoriza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstado))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdministradorPerfil)
                    .addComponent(cbEstado)
                    .addComponent(cbAutoriza))
                .addContainerGap())
        );

        btnAceptar.setMnemonic('A');
        btnAceptar.setText("Aceptar");
        btnAceptar.setColorHover(new java.awt.Color(19, 218, 0));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setMnemonic('C');
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorHover(new java.awt.Color(255, 9, 0));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdministradorPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorPerfilActionPerformed
        frmPerfiles miPerfil = new frmPerfiles(null, true);
//        miPerfil.setRol(cmbRol.getSelectedItem().toString().trim());
        miPerfil.setLocationRelativeTo(this);
        miPerfil.setVisible(true);
    }//GEN-LAST:event_btnAdministradorPerfilActionPerformed

    private void cbAutorizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutorizaActionPerformed
        if (cbAutoriza.isSelected()) {
            cbAutoriza.setText("Delegar");
        } else {
            cbAutoriza.setText("No Delegar");
        }
    }//GEN-LAST:event_cbAutorizaActionPerformed

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void txtIDUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUsuarioActionPerformed
        txtPNombre.requestFocus();
    }//GEN-LAST:event_txtIDUsuarioActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtClave1.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave1ActionPerformed
        txtClave2.requestFocus();
    }//GEN-LAST:event_txtClave1ActionPerformed

    private void txtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave2ActionPerformed
        cmbRol.requestFocus();
        cmbRol.showPopup();
    }//GEN-LAST:event_txtClave2ActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*Validando la informacion que el usuario trata de ingresar a la base de
        datos.*/
        if (txtIDUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe Digitar un ID.");
            txtIDUsuario.requestFocusInWindow();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe Digitar nombres.");
            txtPNombre.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane,
                    "Debe Digitar un apellidos.");
            txtApellidos.requestFocusInWindow();
            return;
        }
        
        /*Se extraen las contraseñas de los campos para verificar sean iguales y 
        sean segura tambien.*/
        String clave1 = new String(txtClave1.getPassword()),
                clave2 = new String(txtClave2.getPassword());

        if (nuevo) {//Si es nuevo se realizan las verificaciones de las claves..
            if (clave1.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Debe Ingresar clave.");
                txtClave1.requestFocusInWindow();
                return;
            }

            if (clave2.equals("")) {
                JOptionPane.showMessageDialog(rootPane,
                        "Debe Ingresar confirmacion.");
                txtClave2.requestFocusInWindow();
                return;
            }

            if (!clave1.equals(clave2)) {
                JOptionPane.showMessageDialog(rootPane,
                        "Claves no coinciden.");
                txtClave2.setText("");
                txtClave1.setText("");
                txtClave1.requestFocusInWindow();
                return;
            }
        }

        if (cmbRol.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Debe de elegir un rol para el usuario!!!");
            cmbRol.showPopup();
            return;
        }
        
        /*Preparando el mensaje que verá el usuario para aceptar la información 
        que se ingresará a la base de datos.*/
        
        String mensaje = "<html><big>"
                + "<b>Se va a agregar el Usuario: </b>" + txtIDUsuario.getText() + "<br>"
                + "<b>Con Nombre y Apellido: </b>" + txtPNombre.getText()+ " " + txtApellidos.getText()+ "<br>"
                + "<b>Con el Perfil de: </b>" + cmbRol.getSelectedItem().toString() + "<br>"
                + "<b>Delegar: </b>" + (cbAutoriza.isSelected() ? "Activado" : "NO Activado") + "<br>"
                + "<b>Estado del Usuario: </b>" + (cbEstado.isSelected() ? "Activo" : "No Activo") + "<br>"
                + "<b>Desea continuar? </b>"
                + "</big></html>";

        int resp = JOptionPane.showConfirmDialog(this,
                mensaje, "Confirmacion de Usuario", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (existeUsuario(txtIDUsuario.getText()) && nuevo) {
            int r = JOptionPane.showConfirmDialog(this,
                    "Usuario ya existe. \n\nDesea recuperar el usuario?",
                    "Proceso de verificación",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (r == JOptionPane.YES_OPTION) {
                
            }

            txtClave1.setText("");
            txtClave2.setText("");
            txtClave1.requestFocusInWindow();
            return;
        }

        String role = cmbRol.getSelectedItem().toString().trim();

        if (role.equalsIgnoreCase("ADMINISTRADOR")) {
            role = "RDB$ADMIN";
        }

        //Creamos el Objeto Usuario y los agregamos a Datos
        Usuario miUsuario = Usuario.builder().
                user_name(txtIDUsuario.getText()).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                clave(clave1).
                estado(cbEstado.isSelected()).
                build();
                
                cbAutoriza.isSelected();
        //Vaceamos las claves tomadas de los campos y vaceamos los campos tambien.
        //Cuestiones de seguridad...
        clave1 = null;
        clave2 = null;
        
        if (revokeRol != null) {
            if (revokeRol.equalsIgnoreCase("ADMINISTRADOR")) {
                revokeRol = "RDB$ADMIN";
            }
        }

//        String msj = (nuevo ? agregarUsuario(miUsuario)
//                : modificarUsuario(miUsuario, revokeRol));
//
//        JOptionPane.showMessageDialog(this, msj);
        
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void llenarCombo() {
        ResultSet rs = getRoles();
        cmbRol.removeAllItems();
        cmbRol.addItem("Seleccionar un rol");
        try {
            while (rs.next()) {
                cmbRol.addItem(rs.getString(1).trim());
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnAceptar;
    private javax.swing.JButton btnAdministradorPerfil;
    private rojeru_san.RSButtonRiple btnCancelar;
    private javax.swing.JCheckBox cbAutoriza;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private rojeru_san.rsfield.RSTextFullRound txtApellidos;
    private rojeru_san.rsfield.RSPassViewRound txtClave1;
    private rojeru_san.rsfield.RSPassViewRound txtClave2;
    private rojeru_san.rsfield.RSTextFullRound txtIDUsuario;
    private rojeru_san.rsfield.RSTextFullRound txtPNombre;
    private rojeru_san.rsfield.RSTextFullRound txtSNombre;
    // End of variables declaration//GEN-END:variables
}
