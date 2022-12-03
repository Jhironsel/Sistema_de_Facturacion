package sur.softsurena.formularios;

import javax.swing.JOptionPane;
import static sur.softsurena.datos.procedure.ProcedureMetodos.agregarModificarUsuario;
import sur.softsurena.entidades.Usuarios;
import static sur.softsurena.datos.select.SelectMetodos.existeUsuarioByUserName;

public class frmUsuariosAgregar extends javax.swing.JDialog {

    private boolean nuevo;//Si el suario es nuevo o no
    private String revokeRol;

    /*Este constructor es utilizado para agregar nuevos usuarios*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        nuevo = true;
    }

    /*Este constructor es utilizado para cuando se vá a modificar un usuario,
    en el se inicianlizan todos los campos de formulario*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal, Usuarios u) {
        super(parent, modal);
        initComponents();

        txtIDUsuario.setText(u.getUser_name());
        txtPNombre.setText(u.getPNombre());
        txtSNombre.setText(u.getSNombre());
        txtApellidos.setText(u.getApellidos());


        cbEstado.setSelected(u.getEstado());
        cbEstadoActionPerformed(null);
        
        cbAdministrador.setSelected(u.getAdministrador());
        cbAdministradorActionPerformed(null);

        txtDescripcion.setText(u.getDescripcion());

        revokeRol = u.getRol();
        nuevo = false;

        txtIDUsuario.setEditable(false);
        
        //Cargar las Tags
        
        
        
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
        rSPanelForma1 = new rojeru_san.rspanel.RSPanelForma();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(1000, 1000));
        cbEstado = new javax.swing.JCheckBox();
        cbAdministrador = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rSTableMetro1 = new rojerusan.RSTableMetro();
        btnAgregarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel6 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nuevo usuario");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Datos "));

        jPanel5.setLayout(new java.awt.GridLayout(7, 1, 5, 5));

        txtIDUsuario.setToolTipText("Identificador del usuario en el sistema");
        txtIDUsuario.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
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
        txtClave1.setPlaceholder("Ingrese clave");
        txtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave1ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave1);

        txtClave2.setToolTipText("Confirme la clave del usuario ");
        txtClave2.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave2.setPlaceholder("Confirmación");
        txtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave2ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave2);

        org.jdesktop.swingx.HorizontalLayout horizontalLayout1 = new org.jdesktop.swingx.HorizontalLayout();
        horizontalLayout1.setGap(10);
        rSPanelForma1.setLayout(horizontalLayout1);
        rSPanelForma1.add(filler2);

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setMnemonic('T');
        cbEstado.setText("Inactivo");
        cbEstado.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        rSPanelForma1.add(cbEstado);

        cbAdministrador.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbAdministrador.setMnemonic('D');
        cbAdministrador.setText("No Administrador");
        cbAdministrador.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdministradorActionPerformed(evt);
            }
        });
        rSPanelForma1.add(cbAdministrador);

        jPanel5.add(rSPanelForma1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Descripción "));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Etiquetas "));

        rSTableMetro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Clave", "Valor"
            }
        ));
        rSTableMetro1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        rSTableMetro1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rSTableMetro1.setShowGrid(false);
        rSTableMetro1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(rSTableMetro1);

        btnAgregarTag.setText("Agregar");
        btnAgregarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarTag.setName("btnAgregarTag"); // NOI18N

        btnBorrarTag.setText("Borrar");
        btnBorrarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTag.setName("btnBorrarTag"); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAgregarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAceptar.setText("Aceptar");
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAdministradorActionPerformed
        if (cbAdministrador.isSelected()) {
            cbAdministrador.setText("Administrador");
        } else {
            cbAdministrador.setText("No Administrador");
        }
    }//GEN-LAST:event_cbAdministradorActionPerformed

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
        txtSNombre.requestFocus();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtClave1.requestFocus();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave1ActionPerformed
        txtClave2.requestFocus();
    }//GEN-LAST:event_txtClave1ActionPerformed

    private void txtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave2ActionPerformed
        txtDescripcion.requestFocus();
    }//GEN-LAST:event_txtClave2ActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocus();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*
            Validando la informacion que el usuario trata de ingresar o 
        actualizara la base de datos.
        */
        if (txtIDUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Digitar un ID.");
            txtIDUsuario.requestFocusInWindow();
            return;
        }

        if (txtPNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Digitar nombres.");
            txtPNombre.requestFocusInWindow();
            return;
        }
        
        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Digitar un apellidos.");
            txtApellidos.requestFocusInWindow();
            return;
        }

        /*
            Se extraen las contraseñas de los campos para verificar sean iguales y 
        sean segura tambien.
        */
        String clave1 = new String(txtClave1.getPassword()),
                clave2 = new String(txtClave2.getPassword());

        if (nuevo) {//Si es nuevo se realizan las verificaciones de las claves..
            if (clave1.equals("")) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debe Ingresar clave.");
                txtClave1.requestFocusInWindow();
                return;
            }

            if (clave2.equals("")) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debe Ingresar confirmacion.");
                txtClave2.requestFocusInWindow();
                return;
            }

            if (!clave1.equals(clave2)) {
                JOptionPane.showMessageDialog(
                        null,
                        "Claves no coinciden.");
                txtClave2.setText("");
                txtClave1.setText("");
                txtClave1.requestFocusInWindow();
                return;
            }
        }

        /*
            Preparando el mensaje que verá el usuario para aceptar la información 
        que se ingresará a la base de datos.
        */
        String mensaje = "<html><big>"
                + "<b>Se va a agregar el Usuario: </b>" + txtIDUsuario.getText() + "<br>"
                + "<b>Con Nombre y Apellido: </b>" + txtPNombre.getText() + " " + txtApellidos.getText() + "<br>"
                + "<b>Delegar: </b>" + (cbAdministrador.isSelected() ? "Activado" : "NO Activado") + "<br>"
                + "<b>Estado del Usuario: </b>" + (cbEstado.isSelected() ? "Activo" : "No Activo") + "<br>"
                + "<b>Desea continuar? </b>"
                + "</big></html>";

        int resp = JOptionPane.showConfirmDialog(
                null,
                mensaje, 
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (existeUsuarioByUserName(txtIDUsuario.getText()) && nuevo) {
            int r = JOptionPane.showConfirmDialog(
                    null,
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

        //Creamos el Objeto Usuario y los agregamos a Datos
        Usuarios miUsuario = Usuarios.builder().
                user_name(txtIDUsuario.getText()).
                pNombre(txtPNombre.getText()).
                sNombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                descripcion(txtDescripcion.getText()).
                clave(clave1).
                estado(cbEstado.isSelected()).
                administrador(cbAdministrador.isSelected()).
                build();

        cbAdministrador.isSelected();
        //Vaceamos las claves tomadas de los campos y vaceamos los campos tambien.
        //Cuestiones de seguridad...
        clave1 = null;
        clave2 = null;

        if (revokeRol != null) {
            if (revokeRol.equalsIgnoreCase("ADMINISTRADOR")) {
                revokeRol = "RDB$ADMIN";
            }
        }


        JOptionPane.showMessageDialog(
                null, 
                (agregarModificarUsuario(miUsuario, nuevo ? Usuarios.INSERT : Usuarios.UPDATE)));
        
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.JCheckBox cbAdministrador;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.rspanel.RSPanelForma rSPanelForma1;
    private rojerusan.RSTableMetro rSTableMetro1;
    private rojeru_san.rsfield.RSTextFullRound txtApellidos;
    private rojeru_san.rsfield.RSPassViewRound txtClave1;
    private rojeru_san.rsfield.RSPassViewRound txtClave2;
    private javax.swing.JTextArea txtDescripcion;
    private rojeru_san.rsfield.RSTextFullRound txtIDUsuario;
    private rojeru_san.rsfield.RSTextFullRound txtPNombre;
    private rojeru_san.rsfield.RSTextFullRound txtSNombre;
    // End of variables declaration//GEN-END:variables
}
