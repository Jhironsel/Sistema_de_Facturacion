package sur.softsurena.formularios;

import RSMaterialComponent.RSTableMetro;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import static sur.softsurena.entidades.Roles.getRoles;
import sur.softsurena.entidades.Usuarios;
import static sur.softsurena.entidades.Usuarios.borrarUsuario;
import static sur.softsurena.entidades.Usuarios.getUsuario;
import static sur.softsurena.entidades.Usuarios.getUsuarios;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmUsuarios extends javax.swing.JInternalFrame {

    public String[] procedimientos = {
        "SP_DELETE_USUARIO",
        "SP_INSERT_USUARIO",
        "SP_UPDATE_USUARIO"
    };

    public String[] vista = {
        "GET_ROLES"
    };

    private static final Logger LOG = Logger.getLogger(frmUsuarios.class.getName());

    public frmUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jtpPrivilegios = new javax.swing.JTabbedPane();
        jpMantUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblUsuarios = new RSMaterialComponent.RSTableMetro();
        jpMantRoles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRoles = new RSMaterialComponent.RSTableMetro();
        jpDefRoles = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mantenimiento de Usuarios, Roles y Permisos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setPreferredSize(new java.awt.Dimension(100, 40));
        btnNuevo.setRound(40);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setText("Editar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnModificar.setRound(40);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBorrar.setRound(40);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBuscar.setRound(40);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jtpPrivilegios.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jtpPrivilegios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jtpPrivilegiosStateChanged(evt);
            }
        });
        jtpPrivilegios.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jtpPrivilegiosComponentShown(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tblUsuarios);

        javax.swing.GroupLayout jpMantUsuariosLayout = new javax.swing.GroupLayout(jpMantUsuarios);
        jpMantUsuarios.setLayout(jpMantUsuariosLayout);
        jpMantUsuariosLayout.setHorizontalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 865, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpMantUsuariosLayout.setVerticalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>Usuarios</b><center></html>", null, jpMantUsuarios, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Listado de Roles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRoles.setToolTipText("");
        tblRoles.setName("tblRoles"); // NOI18N
        jScrollPane2.setViewportView(tblRoles);

        javax.swing.GroupLayout jpMantRolesLayout = new javax.swing.GroupLayout(jpMantRoles);
        jpMantRoles.setLayout(jpMantRolesLayout);
        jpMantRolesLayout.setHorizontalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantRolesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMantRolesLayout.setVerticalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantRolesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>Roles</b><center></html>", null, jpMantRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        javax.swing.GroupLayout jpDefRolesLayout = new javax.swing.GroupLayout(jpDefRoles);
        jpDefRoles.setLayout(jpDefRolesLayout);
        jpDefRolesLayout.setHorizontalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        jpDefRolesLayout.setVerticalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        jtpPrivilegios.addTab("<html><center><b>Asignación<br>Roles</b><center></html>", null, jpDefRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPrivilegios)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtpPrivilegios)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            frmUsuariosAgregar u = new frmUsuariosAgregar(null, true);
            u.setLocationRelativeTo(null);
            u.setVisible(true);
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            String rol = JOptionPane.showInternalInputDialog(
                    null, 
                    "Ingrese nombre del rol", 
                    "Agregando rol al sistema", 
                    JOptionPane.PLAIN_MESSAGE
            );
            
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {
            
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {

        } else if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            if (tblUsuarios.getSelectedRow() == -1) {
                JOptionPane.showInternalMessageDialog(
                        null,
                        "Debes seleccionar un usuario.");
                return;
            }
            String userName = tblUsuarios.getValueAt(
                    tblUsuarios.getSelectedRow(), 0).
                    toString().trim();

            frmUsuariosAgregar user = new frmUsuariosAgregar(
                    null,
                    true,
                    getUsuario(userName)
            );

            user.setLocationRelativeTo(this);
            user.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {
            System.out.println("Este es Definicion de roles");
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            System.out.println("Este es Mantenimiento de roles");
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            int rta = JOptionPane.showConfirmDialog(
                    this,
                    "Esta seguro de eliminar Usuario?",
                    "Confirmacion!!!",
                    JOptionPane.YES_NO_OPTION);

            if (rta == JOptionPane.NO_OPTION) {
                return;
            }

            frmConfirmacion c = new frmConfirmacion(null, true);
            c.setLocationRelativeTo(this);
            c.setVisible(true);

            if (!c.aceptar) {
                JOptionPane.showMessageDialog(
                        null,
                        "Ingrese corretamente el codigo.",
                        "Proceso de validacion.",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String msg, userName;

            userName = tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0).toString().trim();

            msg = borrarUsuario(userName);

            JOptionPane.showMessageDialog(
                    null,
                    msg
            );
        } else {
            System.out.println("Ninguno.");
        }


    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String usuario = JOptionPane.showInputDialog(
                "Escriba criterio de busqueda:");

        if (usuario == null || usuario.isBlank()) {
            return;
        }

        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            //            if (!existeUsuarioByUserName(usuario)) {
//                JOptionPane.showMessageDialog(rootPane, "El Usuario No Existe");
//                return;
//            }
            //Detalle de Factura
            for (int i = 0; i < tblUsuarios.getRowCount(); i++) {
                if (tblUsuarios.getValueAt(i, 0).toString().strip().equalsIgnoreCase(usuario.strip())) {
                    tblUsuarios.setRowSelectionInterval(i, i);
                    break;
                }
                if (tblUsuarios.getValueAt(i, 1).toString().strip().equalsIgnoreCase(usuario.strip())) {
                    tblUsuarios.setRowSelectionInterval(i, i);
                    break;
                }
                if (tblUsuarios.getValueAt(i, 2).toString().strip().equalsIgnoreCase(usuario.strip())) {
                    tblUsuarios.setRowSelectionInterval(i, i);
                    break;
                }
                if (tblUsuarios.getValueAt(i, 3).toString().strip().equalsIgnoreCase(usuario.strip())) {
                    tblUsuarios.setRowSelectionInterval(i, i);
                    break;
                }
            }
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            for (int i = 0; i < tblRoles.getRowCount(); i++) {
                if (tblRoles.getValueAt(i, 0).toString().strip().equalsIgnoreCase(usuario.strip())) {
                    tblRoles.setRowSelectionInterval(i, i);
                    break;
                }
            }
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jtpPrivilegiosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jtpPrivilegiosComponentShown


    }//GEN-LAST:event_jtpPrivilegiosComponentShown

    private void jtpPrivilegiosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpPrivilegiosStateChanged
        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            llenarTabla();
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            llenarTblRoles();
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        }
    }//GEN-LAST:event_jtpPrivilegiosStateChanged

    public static void llenarTabla() {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                tblUsuarios.removeAll();
        String titulos[] = {"Nombre usuario", "Primer Nombre",
            "Segundo Nombre", "Apellidos", "Administrador", "Estado"};

        Object registro[] = new Object[titulos.length];

        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 5 || column == 4) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getUsuarios().stream().forEach(usuario -> {
            registro[0] = usuario;
            registro[1] = usuario.getPnombre();
            registro[2] = usuario.getSnombre();
            registro[3] = usuario.getApellidos();
            registro[4] = usuario.getAdministrador();
            registro[5] = usuario.getEstado();
            miTabla.addRow(registro);
        });

        tblUsuarios.setModel(miTabla);
        
        int[] indices = {4,5};
        columnasCheckBox(tblUsuarios, indices);
        
        repararColumnaTable(tblUsuarios);
        
        
        
    }

    private void llenarTblRoles() {
        tblRoles.removeAll();
        String[] titulos = {"Listado de roles"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getRoles().stream().forEach(rol -> {
            registro[0] = rol.getRoleName().strip().equalsIgnoreCase("RDB$ADMIN")
                    ? "ADMINISTRADOR" : rol.getRoleName().strip();
            miTabla.addRow(registro);
        });

        DefaultTableCellRenderer tcr = new DefaultTableCellHeaderRenderer() {

        };
        tcr.setHorizontalAlignment(SwingConstants.LEFT);

        tblRoles.getColumnModel().getColumn(0).setCellRenderer(tcr);

        tblRoles.setModel(miTabla);
        repararColumnaTable(tblRoles);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpDefRoles;
    private javax.swing.JPanel jpMantRoles;
    private javax.swing.JPanel jpMantUsuarios;
    private javax.swing.JTabbedPane jtpPrivilegios;
    private RSMaterialComponent.RSTableMetro tblRoles;
    private static RSMaterialComponent.RSTableMetro tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
//private static rojerusan.RSTableMetro1 tblClientes;