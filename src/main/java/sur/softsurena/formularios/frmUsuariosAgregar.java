package sur.softsurena.formularios;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Role;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.metodos.M_Etiqueta.getEtiquetasUsuario;
import static sur.softsurena.metodos.M_Role.comprobandoRolesDisponibles;
import static sur.softsurena.metodos.M_Role.getRoles;
import static sur.softsurena.metodos.M_Usuario.agregarUsuario;
import static sur.softsurena.metodos.M_Usuario.existeUsuarioByUserName;
import static sur.softsurena.metodos.M_Usuario.modificarUsuario;
import sur.softsurena.utilidades.PalabrasReservadasFirebird;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;
import static sur.softsurena.utilidades.Utilidades.showTooltip;

public class frmUsuariosAgregar extends javax.swing.JDialog {

    private boolean nuevo;//Si el suario es nuevo o no

    /*Este constructor es utilizado para agregar nuevos usuarios*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        nuevo = true;
    }

    /*Este constructor es utilizado para cuando se vá a modificar un usuario,
    en el se inicianlizan todos los campos de formulario*/
    public frmUsuariosAgregar(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();

        //Cargar los atributos basico
        txtUserName.setText(usuario.getUser_name());
        txtUserName.setEditable(false);

        txtPNombre.setText(usuario.getPnombre());
        txtSNombre.setText(usuario.getSnombre());
        txtApellidos.setText(usuario.getApellidos());

        cbEstado.setSelected(usuario.getEstado());
        cbEstadoActionPerformed(null);

        cbAdministrador.setSelected(usuario.getAdministrador());
        cbAdministradorActionPerformed(null);

        txtDescripcion.setText(usuario.getDescripcion());

        nuevo = false;

        String titulos[] = {"Propiedad", "Valor"};

        Object registro[] = new Object[titulos.length];

        DefaultTableModel dtmEtiquetas = new DefaultTableModel(null, titulos);

        tblEtiquetas.removeAll();

        getEtiquetasUsuario(usuario.getUser_name()).stream().forEach(
                etiqueta -> {
                    registro[0] = etiqueta.getPropiedad();
                    registro[1] = etiqueta.getValor();

                    dtmEtiquetas.addRow(registro);
                }
        );

        tblEtiquetas.setModel(dtmEtiquetas);

        repararColumnaTable(tblEtiquetas);

        tblEtiquetas.setBackgoundHover(new java.awt.Color(102, 102, 255));

        String titulos2[] = {"Roles", "Descripción"};

        Object registro2[] = new Object[titulos2.length];

        DefaultTableModel dtmRoles = new DefaultTableModel(null, titulos2);

        tblRoles.removeAll();

        //TODO Analizar si este flat booleana es correcta.
        comprobandoRolesDisponibles(usuario.getUser_name(), true).stream()
                .forEach(
                        rol -> {
                            registro2[0] = rol.getRoleName();
                            registro2[1] = rol.getDescripcion();

                            dtmRoles.addRow(registro2);
                        }
                );

        tblRoles.setModel(dtmRoles);

        repararColumnaTable(tblRoles);

        tblRoles.setBackgoundHover(new java.awt.Color(102, 102, 255));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtUserName = new rojeru_san.rsfield.RSTextFullRound();
        txtPNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtSNombre = new rojeru_san.rsfield.RSTextFullRound();
        txtApellidos = new rojeru_san.rsfield.RSTextFullRound();
        txtClave1 = new rojeru_san.rsfield.RSPassViewRound();
        txtClave2 = new rojeru_san.rsfield.RSPassViewRound();
        jPanel7 = new javax.swing.JPanel();
        cbAdministrador = new RSMaterialComponent.RSCheckBoxMaterial();
        cbEstado = new RSMaterialComponent.RSCheckBoxMaterial();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jPanel8 = new javax.swing.JPanel();
        btnAgregarRol = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarRol = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRoles = new rojerusan.RSTableMetro();
        jPanel4 = new javax.swing.JPanel();
        btnAgregarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrarTag = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEtiquetas = new rojerusan.RSTableMetro();
        jPanel6 = new javax.swing.JPanel();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar nuevo usuario");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Datos "));

        jPanel5.setLayout(new java.awt.GridLayout(7, 1, 5, 5));

        txtUserName.setToolTipText("Identificador del usuario en el sistema.\n\nNOTA: No colocar nombres de roles en este campo. ");
        txtUserName.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtUserName.setName("txtUserName"); // NOI18N
        txtUserName.setPlaceholder("ID Usuario");
        txtUserName.setSoloLetras(true);
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jPanel5.add(txtUserName);

        txtPNombre.setToolTipText("Nombres del usuario");
        txtPNombre.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtPNombre.setName("txtPNombre"); // NOI18N
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
        txtSNombre.setName("txtSNombre"); // NOI18N
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
        txtApellidos.setName("txtApellidos"); // NOI18N
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
        txtClave1.setName("txtClave1"); // NOI18N
        txtClave1.setPlaceholder("Ingrese clave");
        txtClave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave1ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave1);

        txtClave2.setToolTipText("Confirme la clave del usuario ");
        txtClave2.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        txtClave2.setName("txtClave2"); // NOI18N
        txtClave2.setPlaceholder("Confirmación");
        txtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave2ActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave2);

        jPanel7.setLayout(new java.awt.BorderLayout());

        cbAdministrador.setText("No Administrador");
        cbAdministrador.setName("cbAdministrador"); // NOI18N
        cbAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAdministradorActionPerformed(evt);
            }
        });
        jPanel7.add(cbAdministrador, java.awt.BorderLayout.PAGE_END);

        cbEstado.setText("Inactivo");
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });
        jPanel7.add(cbEstado, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setPreferredSize(new java.awt.Dimension(486, 0));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(" Descripción "));
        jPanel3.setPreferredSize(new java.awt.Dimension(266, 0));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setName("txtDescripcion"); // NOI18N
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Roles"));
        jPanel8.setPreferredSize(new java.awt.Dimension(480, 0));

        btnAgregarRol.setText("Agregar");
        btnAgregarRol.setToolTipText("Es necesario un rol de usuario.");
        btnAgregarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarRol.setName("btnAgregarRol"); // NOI18N
        btnAgregarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarRolActionPerformed(evt);
            }
        });

        btnBorrarRol.setText("Borrar");
        btnBorrarRol.setToolTipText("Elimina el rol de usuario seleccionado en la tabla.");
        btnBorrarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarRol.setName("btnBorrarRol"); // NOI18N
        btnBorrarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarRolActionPerformed(evt);
            }
        });

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rol de usuario", "Descripcion"
            }
        ));
        tblRoles.setToolTipText("Roles que el usuario tiene registrado.");
        tblRoles.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblRoles.setName("tblRoles"); // NOI18N
        tblRoles.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 0));
        tblRoles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRoles.setShowGrid(true);
        tblRoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblRoles);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnAgregarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBorrarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(" Etiquetas "));
        jPanel4.setPreferredSize(new java.awt.Dimension(480, 0));

        btnAgregarTag.setText("Agregar");
        btnAgregarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregarTag.setName("btnAgregarTag"); // NOI18N
        btnAgregarTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTagActionPerformed(evt);
            }
        });

        btnBorrarTag.setText("Borrar");
        btnBorrarTag.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarTag.setName("btnBorrarTag"); // NOI18N
        btnBorrarTag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarTagActionPerformed(evt);
            }
        });

        jScrollPane2.setMaximumSize(new java.awt.Dimension(32767, 0));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(27, 0));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(458, 0));

        tblEtiquetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Valor"
            }
        ));
        tblEtiquetas.setToolTipText("Las etiquetas son atributos que pueden usar los usuario del sistema.");
        tblEtiquetas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblEtiquetas.setName("tblEtiquetas"); // NOI18N
        tblEtiquetas.setPreferredScrollableViewportSize(new java.awt.Dimension(450, 0));
        tblEtiquetas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblEtiquetas.setShowGrid(true);
        tblEtiquetas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblEtiquetas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarTag, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(43, 77, Short.MAX_VALUE)
                        .addComponent(btnAgregarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrarTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel8});

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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        txtPNombre.requestFocusInWindow();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void txtPNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPNombreActionPerformed
        txtSNombre.requestFocusInWindow();
    }//GEN-LAST:event_txtPNombreActionPerformed

    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        txtClave1.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed

    private void txtClave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave1ActionPerformed
        txtClave2.requestFocusInWindow();
    }//GEN-LAST:event_txtClave1ActionPerformed

    private void txtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave2ActionPerformed
        txtDescripcion.requestFocusInWindow();
    }//GEN-LAST:event_txtClave2ActionPerformed

    private void txtSNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSNombreActionPerformed
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtSNombreActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*
            Validando la informacion que el usuario trata de ingresar o 
        actualizar a la base de datos.
         */
        if (txtUserName.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar un ID.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtUserName.requestFocusInWindow();
            return;
        }

        if (txtPNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar nombres.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtPNombre.requestFocusInWindow();
            return;
        }

        if (txtApellidos.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Digitar un apellidos.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
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
            if (clave1.isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe Ingresar clave.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtClave1.requestFocusInWindow();
                return;
            }

            if (clave2.isBlank()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe Ingresar confirmacion.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtClave2.requestFocusInWindow();
                return;
            }
        }

        if (!clave1.equals(clave2)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Claves no coinciden.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClave2.setText("");
            txtClave1.setText("");
            txtClave1.requestFocusInWindow();
            return;
        }

        if (tblRoles.getRowCount() <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe agregar un rol para el usuario",
                    "",
                    JOptionPane.WARNING_MESSAGE
            );
            btnAgregarRol.requestFocusInWindow();
            showTooltip(btnAgregarRol);
            return;
        }

        /*
            Preparando el mensaje que verá el usuario para aceptar la información 
        que se ingresará a la base de datos.
         */
        List<Role> rolesList = new ArrayList<>();

        for (int i = 0; i < tblRoles.getRowCount(); i++) {
            rolesList.add(Role.builder().
                    roleName(tblRoles.getValueAt(i, 0).toString()).
                    build());
        }

        String etiquetas = "";
        for (int i = 0; i < tblEtiquetas.getRowCount(); i++) {
            etiquetas = etiquetas + tblEtiquetas.getValueAt(i, 0).toString() + " = "
                    + "'" + tblEtiquetas.getValueAt(i, 1).toString() + "'"
                    + ((i == tblEtiquetas.getRowCount() - 1) ? "" : ", ");
        }

        etiquetas = "TAGS(" + etiquetas + ")";

        String mensaje = "<html>"
                + "<h1>Se va a agregar el Usuario: </h1><h2>" + txtUserName.getText() + "</h2></br>"
                + "<h1>Con Nombre y Apellido: </h1><h2>" + txtPNombre.getText() + " " + txtApellidos.getText() + "</h2></br>"
                + "<h1>Delegar: </h1><h2>" + (cbAdministrador.isSelected() ? "Activado" : "NO Activado") + "</h2></br>"
                + "<h1>Estado del Usuario: </h1><h2>" + (cbEstado.isSelected() ? "Activo" : "No Activo") + "</h2></br>"
                + "<h2>Desea continuar? </h2>"
                + "</html>";

        int resp = JOptionPane.showConfirmDialog(
                this,
                mensaje,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        if (existeUsuarioByUserName(txtUserName.getText()) & nuevo) {
            int r = JOptionPane.showConfirmDialog(
                    this,
                    "Usuario ya existe. \n\nDesea recuperar el usuario?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (r == JOptionPane.YES_OPTION) {
                //TODO Crear el proceso de recuperacion del usuario en esta parte.
            }

            txtClave1.setText("");
            txtClave2.setText("");
            txtClave1.requestFocusInWindow();
            return;
        }

        Usuario usuario = Usuario.builder().
                user_name(txtUserName.getText()).
                pnombre(txtPNombre.getText()).
                snombre(txtSNombre.getText()).
                apellidos(txtApellidos.getText()).
                descripcion(txtDescripcion.getText()).
                clave(clave1).
                tags(etiquetas).
                estado(cbEstado.isSelected()).
                administrador(cbAdministrador.isSelected()).
                roles(rolesList).
                build();

        Resultado resultado = (nuevo ? agregarUsuario(usuario) : modificarUsuario(usuario));

        JOptionPane.showMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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

    private void btnAgregarTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTagActionPerformed
        frmEtiquetas e = new frmEtiquetas(null, true);
        e.setLocationRelativeTo(e);
        e.setVisible(true);

        if (!e.aceptar) {
            return;
        }

        boolean palabra = PalabrasReservadasFirebird.
                palabrasReservadasFirebird().
                contains(e.txtPropiedad.getText());

        if (palabra) {
            JOptionPane.showMessageDialog(
                    this,
                    "Esta propiedad no puede ser usada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        for (int i = 0; i < tblEtiquetas.getRowCount(); i++) {
            if (e.txtPropiedad.getText().equalsIgnoreCase(
                    tblEtiquetas.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Esta propiedad ya se encuentra registrada.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        Object registro[] = new Object[2];
        DefaultTableModel miTabla = (DefaultTableModel) tblEtiquetas.getModel();

        registro[0] = e.txtPropiedad.getText();
        registro[1] = e.txtValor.getText();

        miTabla.addRow(registro);

        tblEtiquetas.setModel(miTabla);

        Utilidades.repararColumnaTable(tblEtiquetas);
    }//GEN-LAST:event_btnAgregarTagActionPerformed

    private void btnBorrarTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarTagActionPerformed
        DefaultTableModel miTabla = (DefaultTableModel) tblEtiquetas.getModel();

        miTabla.removeRow(tblEtiquetas.getSelectedRow());

        tblEtiquetas.setModel(miTabla);
    }//GEN-LAST:event_btnBorrarTagActionPerformed

    private void btnAgregarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarRolActionPerformed
        Role rol = (Role) JOptionPane.showInputDialog(this,
                "Seleccione un rol para el usuario",
                "",
                JOptionPane.PLAIN_MESSAGE,
                null,
                getRoles().stream().toArray(Role[]::new),
                null
        );

        for (int i = 0; i < tblRoles.getRowCount(); i++) {
            if (rol.toString().equalsIgnoreCase(
                    tblRoles.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(
                        this,
                        "Este role ya se encuentra en la lista.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
        }

        int resp = JOptionPane.showConfirmDialog(
                this,
                "Desea permitir administracion de rol al usuario?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        String cabeceras[] = {"Rol de usuario", "Con Admin", "Descripcion"};
        Object registro[] = new Object[cabeceras.length];

        DefaultTableModel miTabla = (DefaultTableModel) tblRoles.getModel();
        miTabla.setColumnIdentifiers(cabeceras);

        registro[0] = rol;
        registro[1] = (resp == JOptionPane.YES_OPTION);
        registro[2] = rol.getDescripcion();

        miTabla.addRow(registro);

        tblRoles.setModel(miTabla);

        repararColumnaTable(tblRoles);
        columnasCheckBox(tblRoles, new int[]{1});
    }//GEN-LAST:event_btnAgregarRolActionPerformed

    private void btnBorrarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarRolActionPerformed
        DefaultTableModel miTabla = (DefaultTableModel) tblRoles.getModel();

        miTabla.removeRow(tblRoles.getSelectedRow());

        tblRoles.setModel(miTabla);
    }//GEN-LAST:event_btnBorrarRolActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAgregarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarTag;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSCheckBoxMaterial cbAdministrador;
    private RSMaterialComponent.RSCheckBoxMaterial cbEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSTableMetro tblEtiquetas;
    private rojerusan.RSTableMetro tblRoles;
    private rojeru_san.rsfield.RSTextFullRound txtApellidos;
    private rojeru_san.rsfield.RSPassViewRound txtClave1;
    private rojeru_san.rsfield.RSPassViewRound txtClave2;
    private javax.swing.JTextArea txtDescripcion;
    private rojeru_san.rsfield.RSTextFullRound txtPNombre;
    private rojeru_san.rsfield.RSTextFullRound txtSNombre;
    private rojeru_san.rsfield.RSTextFullRound txtUserName;
    // End of variables declaration//GEN-END:variables
}
