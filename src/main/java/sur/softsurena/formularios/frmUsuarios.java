package sur.softsurena.formularios;

import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Role;
import static sur.softsurena.metodos.M_Permiso.agregarPermisoAdminRole;
import static sur.softsurena.metodos.M_Permiso.getPermisosAsignados;
import static sur.softsurena.metodos.M_Permiso.getPermisosDisponibles;
import static sur.softsurena.metodos.M_Permiso.quitarPermisoAdminRole;
import static sur.softsurena.metodos.M_Role.asignarRol;
import static sur.softsurena.metodos.M_Role.asignarRolUsuario;
import static sur.softsurena.metodos.M_Role.comprobandoRolesDisponibles;
import static sur.softsurena.metodos.M_Role.createRole;
import static sur.softsurena.metodos.M_Role.dropRole;
import static sur.softsurena.metodos.M_Role.getRoles;
import static sur.softsurena.metodos.M_Role.modificarRol;
import static sur.softsurena.metodos.M_Role.quitarRolUsuario;
import static sur.softsurena.metodos.M_Usuario.borrarUsuario;
import static sur.softsurena.metodos.M_Usuario.getNombresUsuarios;
import static sur.softsurena.metodos.M_Usuario.getUsuario;
import static sur.softsurena.metodos.M_Usuario.getUsuarios;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmUsuarios extends javax.swing.JInternalFrame {

    public static frmUsuarios getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmUsuarios INSTANCE = new frmUsuarios();
    }

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
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPermisosDisponibles = new RSMaterialComponent.RSTableMetro();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblPermisosAsignados = new RSMaterialComponent.RSTableMetro();
        btnBorrarPermiso = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAsignarPermiso = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnQuitarAgregarPermisoAdmin = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jpDefRoles = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblListadoUsuarios = new RSMaterialComponent.RSTableMetro();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblRolesUsuario = new RSMaterialComponent.RSTableMetro();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblRolesDisponibles = new RSMaterialComponent.RSTableMetro();
        btnAsignarRol = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnQuitarRolUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnQuitarPermisoAdministrativoUsuario = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtDescripcion1 = new javax.swing.JTextPane();

        setBorder(javax.swing.BorderFactory.createMatteBorder(25, 10, 10, 10, new java.awt.Color(37, 45, 223)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), "Botones de acción"));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setName("btnNuevo"); // NOI18N
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
        btnModificar.setName("btnModificar"); // NOI18N
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
        btnBorrar.setName("btnPorrar"); // NOI18N
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
        btnBuscar.setName("btnBuscar"); // NOI18N
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

        jScrollPane4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

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
        tblUsuarios.setToolTipText("Aqui se muestran la lista de usuarios y los atributos mas importante.");
        tblUsuarios.setName("tblUsuarios"); // NOI18N
        jScrollPane4.setViewportView(tblUsuarios);

        javax.swing.GroupLayout jpMantUsuariosLayout = new javax.swing.GroupLayout(jpMantUsuarios);
        jpMantUsuarios.setLayout(jpMantUsuariosLayout);
        jpMantUsuariosLayout.setHorizontalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jpMantUsuariosLayout.setVerticalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>Usuarios</b><center></html>", null, jpMantUsuarios, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 45, 223), 2));

        tblRoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblRoles.setToolTipText("Aqui se muestran los roles del sistema.");
        tblRoles.setName("tblRoles"); // NOI18N
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRoles);

        jScrollPane7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblPermisosDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Permisos disponibles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPermisosDisponibles.setToolTipText("Los permisos disponibles para el seleccionado");
        tblPermisosDisponibles.setName("tblPermisosDisponibles"); // NOI18N
        tblPermisosDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermisosDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblPermisosDisponibles);

        jScrollPane8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblPermisosAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Permisos asignados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPermisosAsignados.setToolTipText("Aqui se muentran los permisos asignado del role seleccionado con su atributo de administracion marcado o no.");
        tblPermisosAsignados.setName("tblPermisosAsignados"); // NOI18N
        tblPermisosAsignados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermisosAsignadosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblPermisosAsignados);

        btnBorrarPermiso.setText("Borrar Permiso");
        btnBorrarPermiso.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrarPermiso.setName("btnBorrarPermiso"); // NOI18N
        btnBorrarPermiso.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBorrarPermiso.setRound(40);
        btnBorrarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPermisoActionPerformed(evt);
            }
        });

        btnAsignarPermiso.setText("Asignar permiso");
        btnAsignarPermiso.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAsignarPermiso.setName("btnAsignarPermiso"); // NOI18N
        btnAsignarPermiso.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAsignarPermiso.setRound(40);
        btnAsignarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarPermisoActionPerformed(evt);
            }
        });

        btnQuitarAgregarPermisoAdmin.setIcons(null);
        btnQuitarAgregarPermisoAdmin.setMaximumSize(new java.awt.Dimension(100, 0));
        btnQuitarAgregarPermisoAdmin.setMinimumSize(new java.awt.Dimension(80, 0));
        btnQuitarAgregarPermisoAdmin.setName("btnQuitarAgregarPermisoAdmin"); // NOI18N
        btnQuitarAgregarPermisoAdmin.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarAgregarPermisoAdmin.setRound(40);
        btnQuitarAgregarPermisoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarAgregarPermisoAdminActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Descripcion del permiso "));
        txtDescripcion.setContentType("text/html"); // NOI18N
        txtDescripcion.setToolTipText("Aqui se muestran las descripcion del rol seleccionado.");
        txtDescripcion.setName("txtDescripcion"); // NOI18N
        jScrollPane11.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jpMantRolesLayout = new javax.swing.GroupLayout(jpMantRoles);
        jpMantRoles.setLayout(jpMantRolesLayout);
        jpMantRolesLayout.setHorizontalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantRolesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane11)
                    .addGroup(jpMantRolesLayout.createSequentialGroup()
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                            .addComponent(btnBorrarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpMantRolesLayout.createSequentialGroup()
                                .addComponent(btnQuitarAgregarPermisoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158)))
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantRolesLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(btnAsignarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpMantRolesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)))))
                .addGap(6, 6, 6))
        );
        jpMantRolesLayout.setVerticalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantRolesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addGroup(jpMantRolesLayout.createSequentialGroup()
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAsignarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBorrarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnQuitarAgregarPermisoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11)))
                .addGap(6, 6, 6))
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>Roles</b><center></html>", null, jpMantRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        jScrollPane3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblListadoUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Listado de Usuarios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListadoUsuarios.setToolTipText("");
        tblListadoUsuarios.setName("tblListadoUsuarios"); // NOI18N
        tblListadoUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoUsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListadoUsuarios);

        jScrollPane5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblRolesUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rol del usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRolesUsuario.setToolTipText("");
        tblRolesUsuario.setName("tblRolesUsuario"); // NOI18N
        tblRolesUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesUsuarioMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblRolesUsuario);

        jScrollPane6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblRolesDisponibles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rol disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRolesDisponibles.setToolTipText("");
        tblRolesDisponibles.setName("tblRolesDisponibles"); // NOI18N
        tblRolesDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblRolesDisponibles);

        btnAsignarRol.setText("Asignar rol");
        btnAsignarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAsignarRol.setName("btnAsignarRol"); // NOI18N
        btnAsignarRol.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAsignarRol.setRound(40);
        btnAsignarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarRolActionPerformed(evt);
            }
        });

        btnQuitarRolUsuario.setText("Quitar rol");
        btnQuitarRolUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnQuitarRolUsuario.setName("btnQuitarRolUsuario"); // NOI18N
        btnQuitarRolUsuario.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarRolUsuario.setRound(40);
        btnQuitarRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarRolUsuarioActionPerformed(evt);
            }
        });

        btnQuitarPermisoAdministrativoUsuario.setContentAreaFilled(true);
        btnQuitarPermisoAdministrativoUsuario.setDoubleBuffered(true);
        btnQuitarPermisoAdministrativoUsuario.setEffectButton(RSMaterialComponent.RSButtonMaterialIconOne.EFFECTBUTTON.RAISED);
        btnQuitarPermisoAdministrativoUsuario.setEffectFocus(true);
        btnQuitarPermisoAdministrativoUsuario.setIcons(null);
        btnQuitarPermisoAdministrativoUsuario.setMaximumSize(new java.awt.Dimension(100, 0));
        btnQuitarPermisoAdministrativoUsuario.setMinimumSize(new java.awt.Dimension(80, 0));
        btnQuitarPermisoAdministrativoUsuario.setName("btnQuitarPermisoAdministrativoUsuario"); // NOI18N
        btnQuitarPermisoAdministrativoUsuario.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarPermisoAdministrativoUsuario.setRound(40);
        btnQuitarPermisoAdministrativoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPermisoAdministrativoUsuarioActionPerformed(evt);
            }
        });

        txtDescripcion1.setEditable(false);
        txtDescripcion1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Descripcion del rol "));
        txtDescripcion1.setContentType("text/html"); // NOI18N
        jScrollPane12.setViewportView(txtDescripcion1);

        javax.swing.GroupLayout jpDefRolesLayout = new javax.swing.GroupLayout(jpDefRoles);
        jpDefRoles.setLayout(jpDefRolesLayout);
        jpDefRolesLayout.setHorizontalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDefRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDefRolesLayout.createSequentialGroup()
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addGroup(jpDefRolesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnQuitarPermisoAdministrativoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                            .addGroup(jpDefRolesLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnAsignarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpDefRolesLayout.setVerticalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDefRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addGroup(jpDefRolesLayout.createSequentialGroup()
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnQuitarRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitarPermisoAdministrativoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignarRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTablaUsuarios();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios
                || jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

            frmUsuariosAgregar u = new frmUsuariosAgregar(null, true);
            u.setLocationRelativeTo(null);
            u.setVisible(true);

        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {

            String rol = JOptionPane.showInternalInputDialog(
                    this,
                    "Cual es el nombre del rol?: ",
                    "",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (Objects.isNull(rol)) {
                return;
            }

            createRole(rol);
            llenarTblRoles();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            if (tblRoles.getSelectedRow() == -1) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe seleccionar un registros.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            String rolActual = tblRoles.getValueAt(
                    tblRoles.getSelectedRow(), 0).toString();

            String rolNuevo = JOptionPane.showInternalInputDialog(
                    this,
                    "Cual es el nombre del nuevo rol?:",
                    "",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (Objects.isNull(rolNuevo) || rolNuevo.isBlank()) {
                return;
            }

            modificarRol(rolActual, rolNuevo);
            llenarTblRoles();
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            if (tblUsuarios.getSelectedRow() == -1) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debes seleccionar un usuario.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }
            String userName = tblUsuarios.getValueAt(
                    tblUsuarios.getSelectedRow(), 0).
                    toString().strip();

            frmUsuariosAgregar user = new frmUsuariosAgregar(
                    null,
                    true,
                    getUsuario(userName)
            );

            user.setLocationRelativeTo(null);
            user.setVisible(true);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {
            //TODO Trabajo
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            //Validar que exista un rol seleccionado
            if (tblRoles.getSelectedRow() == -1) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Debe seleccionar un rol de la lista.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //Pedir la confirmacion del usuario para proceder.
            int rta = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Esta seguro de eliminar role?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (rta == JOptionPane.NO_OPTION) {
                return;
            }

            String role = tblRoles.getValueAt(
                    tblRoles.getSelectedRow(), 0).toString();

            dropRole(role);

            llenarTblRoles();
            tblRolesMouseClicked(null);
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            String usuario = tblUsuarios.getValueAt(
                    tblUsuarios.getSelectedRow(), 0).toString();

            if (usuario.equalsIgnoreCase("sysdba")) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Usuario sysdba no está permitido eliminar.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            int rta = JOptionPane.showInternalConfirmDialog(
                    this,
                    "Esta seguro de eliminar Usuario?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (rta == JOptionPane.NO_OPTION) {
                return;
            }

            frmConfirmacion c = new frmConfirmacion(null, true);
            c.setLocationRelativeTo(this);
            c.setVisible(true);

            if (!c.aceptar) {
                JOptionPane.showInternalMessageDialog(
                        this,
                        "Ingrese corretamente el codigo.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Resultado resultado = borrarUsuario(usuario.strip());

            JOptionPane.showInternalMessageDialog(
                    this,
                    resultado,
                    "",
                    resultado.getIcono()
            );

        } else {
            //TODO Trabajo

        }


    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String usuario = JOptionPane.showInternalInputDialog(
                this,
                "Escriba criterio de busqueda:",
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        if (Objects.isNull(usuario) || usuario.isBlank()) {
            return;
        }

        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            //            if (!existeUsuarioByUserName(usuario)) {
//                JOptionPane.showInternalMessageDialog(this, "El Usuario No Existe");
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

    private void jtpPrivilegiosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpPrivilegiosStateChanged
        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            llenarTablaUsuarios();
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            llenarTblRoles();
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {
            llenarTblListadoUsuarios();
        }
    }//GEN-LAST:event_jtpPrivilegiosStateChanged

    private void btnAsignarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarRolActionPerformed
        if (tblListadoUsuarios.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un usuario de la lista.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (tblRolesDisponibles.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un rol de la lista",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String usuario = tblListadoUsuarios.getValueAt(
                tblListadoUsuarios.getSelectedRow(), 0).toString();

        String rol = tblRolesDisponibles.getValueAt(
                tblRolesDisponibles.getSelectedRow(), 0).toString();

        int repuesta = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea permitir administracion de este rol?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        boolean admin = repuesta == JOptionPane.YES_OPTION;

        asignarRolUsuario(rol, usuario, admin);

        tblListadoUsuariosMouseClicked(null);
    }//GEN-LAST:event_btnAsignarRolActionPerformed

    private void btnBorrarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPermisoActionPerformed
        if (validarSeleccionRolProcedimiento()) {
            return;
        }
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea eliminar permiso al usuario?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        String rol = tblRoles.getValueAt(
                tblRoles.getSelectedRow(), 0).toString();

        String procedimiento = tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(), 0).toString();

        asignarRol(procedimiento, rol, Boolean.FALSE, Boolean.FALSE);

        tblRolesMouseClicked(null);

    }//GEN-LAST:event_btnBorrarPermisoActionPerformed

    private void btnAsignarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarPermisoActionPerformed
        if (tblRoles.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un rol de la lista",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (tblPermisosDisponibles.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar permiso de la lista",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String rol = tblRoles.getValueAt(
                tblRoles.getSelectedRow(), 0).toString();

        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }

        String procedimiento = tblPermisosDisponibles.getValueAt(
                tblPermisosDisponibles.getSelectedRow(), 0).toString();

        int repuesta = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea agregar rol administrador?",
                "",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (repuesta == JOptionPane.CANCEL_OPTION) {
            return;
        }

        boolean admin = repuesta == JOptionPane.YES_OPTION;

        asignarRol(procedimiento, rol, admin, Boolean.TRUE);

        tblRolesMouseClicked(null);
    }//GEN-LAST:event_btnAsignarPermisoActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        if (tblRoles.getSelectedRow() == -1) {
            return;
        }

        String rol = tblRoles.getValueAt(
                tblRoles.getSelectedRow(), 0).toString();

        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }

        llenarTblPermisosAsignados(rol);

        llenarTblPermisosDisponibles(rol);
    }//GEN-LAST:event_tblRolesMouseClicked

    private void tblListadoUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoUsuariosMouseClicked
        String usuario = tblListadoUsuarios.getValueAt(
                tblListadoUsuarios.getSelectedRow(),
                0
        ).toString();
        llenarTblRolesDisponibles(usuario);
    }//GEN-LAST:event_tblListadoUsuariosMouseClicked

    private void btnQuitarAgregarPermisoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarAgregarPermisoAdminActionPerformed
        if (validarSeleccionRolProcedimiento()) {
            return;
        }

        boolean accesoAdmin = (boolean) tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(), 1);

        String mensaje = "Desea quitar permiso de administracion al rol?";

        if (!accesoAdmin) {
            mensaje = "Desea agregar permiso de administracion al rol?";
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                mensaje,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        //Obtenemos el Rol a modificar.
        String rol = tblRoles.getValueAt(
                tblRoles.getSelectedRow(), 0).toString();
        //Obtenemos el permisos a establecer al rol.
        String procedimiento = tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(),
                0
        ).toString();

        //Si es al rol de adminstrador cambiamos el nombre de la variable. 
        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }
        //TODO Porque accesoAdmin debe negarse.
        asignarRol(procedimiento, rol, Boolean.TRUE, !accesoAdmin);

        tblRolesMouseClicked(null);

    }//GEN-LAST:event_btnQuitarAgregarPermisoAdminActionPerformed

    private void btnQuitarPermisoAdministrativoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPermisoAdministrativoUsuarioActionPerformed
        if (validarSeleccionUsuarioRol()) {
            return;
        }

        boolean accesoAdmin = (boolean) tblRolesUsuario.getValueAt(
                tblRolesUsuario.getSelectedRow(), 1);

        String mensaje = "Desea quitar permiso de administracion al usuario?";

        if (!accesoAdmin) {
            mensaje = "Desea agregar permiso de administracion al usuario?";
        }

        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                mensaje,
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        String rol = tblRolesUsuario.getValueAt(
                tblRolesUsuario.getSelectedRow(), 0).toString();
        String usuario = tblListadoUsuarios.getValueAt(
                tblListadoUsuarios.getSelectedRow(), 0).toString();

        if (accesoAdmin) {
            quitarPermisoAdminRole(rol, usuario);
        } else {
            agregarPermisoAdminRole(rol, usuario);
        }
        tblListadoUsuariosMouseClicked(null);
    }//GEN-LAST:event_btnQuitarPermisoAdministrativoUsuarioActionPerformed

    private void tblPermisosAsignadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisosAsignadosMouseClicked
        boolean conAdmin = (boolean) tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(), 1);
        if (conAdmin) {
            btnQuitarAgregarPermisoAdmin.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
            btnQuitarAgregarPermisoAdmin.setText("Quitar permiso administrativo");
        } else {
            btnQuitarAgregarPermisoAdmin.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
            btnQuitarAgregarPermisoAdmin.setText("Agregar permiso administrativo");
        }
        txtDescripcion.setText("<html></html>");
        txtDescripcion.setText(((Role) tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(), 0)).
                getDescripcion()
        );

    }//GEN-LAST:event_tblPermisosAsignadosMouseClicked

    private void tblRolesUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesUsuarioMouseClicked
        boolean conAdmin = (boolean) tblRolesUsuario.getValueAt(
                tblRolesUsuario.getSelectedRow(), 1);
        if (conAdmin) {
            btnQuitarPermisoAdministrativoUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
            btnQuitarPermisoAdministrativoUsuario.setText("Quitar permiso administrativo");
        } else {
            btnQuitarPermisoAdministrativoUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
            btnQuitarPermisoAdministrativoUsuario.setText("Agregar permiso administrativo");
        }
        txtDescripcion1.setText("<html></html>");
        txtDescripcion1.setText(((Role) tblRolesUsuario.getValueAt(
                tblRolesUsuario.getSelectedRow(), 0)).
                getDescripcion()
        );
    }//GEN-LAST:event_tblRolesUsuarioMouseClicked

    private void btnQuitarRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarRolUsuarioActionPerformed
        if (validarSeleccionUsuarioRol()) {
            return;
        }
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea quitar el rol al usuario?",
                "",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resp == JOptionPane.NO_OPTION) {
            return;
        }

        String usuario = tblListadoUsuarios.getValueAt(
                tblListadoUsuarios.getSelectedRow(), 0).toString();
        String rol = tblRolesUsuario.getValueAt(
                tblRolesUsuario.getSelectedRow(), 0).toString();

        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }

        quitarRolUsuario(rol, usuario);

        tblListadoUsuariosMouseClicked(null);
    }//GEN-LAST:event_btnQuitarRolUsuarioActionPerformed

    private void tblRolesDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesDisponiblesMouseClicked
        txtDescripcion1.setText("<html></html>");
        txtDescripcion1.setText(((Role) tblRolesDisponibles.getValueAt(
                tblRolesDisponibles.getSelectedRow(), 0)).
                getDescripcion()
        );
    }//GEN-LAST:event_tblRolesDisponiblesMouseClicked

    private void tblPermisosDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisosDisponiblesMouseClicked
        txtDescripcion.setText("<html></html>");
        txtDescripcion.setText(((Role) tblPermisosDisponibles.getValueAt(
                tblPermisosDisponibles.getSelectedRow(), 0)).
                getDescripcion()
        );
    }//GEN-LAST:event_tblPermisosDisponiblesMouseClicked

    /**
     * Metodo que entraga el listado de los usuarios del sistema.
     *
     */
    public static JTable llenarTablaUsuarios() {
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

        getUsuarios().stream().forEach(
                usuario -> {
                    registro[0] = usuario;
                    registro[1] = usuario.getPnombre();
                    registro[2] = usuario.getSnombre();
                    registro[3] = usuario.getApellidos();
                    registro[4] = usuario.getAdministrador();
                    registro[5] = usuario.getEstado();
                    miTabla.addRow(registro);
                }
        );

        tblUsuarios.setModel(miTabla);

        repararColumnaTable(tblUsuarios);
        columnasCheckBox(tblUsuarios, new int[]{4, 5});

        return tblUsuarios;
    }

    /**
     *
     */
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

        getRoles().stream().forEach(
                rol -> {
                    registro[0] = rol.getRoleName().strip().equalsIgnoreCase("RDB$ADMIN")
                    ? "ADMINISTRADOR" : rol.getRoleName().strip();
                    miTabla.addRow(registro);
                }
        );

        DefaultTableCellRenderer tcr = new DefaultTableCellHeaderRenderer() {

        };
        tcr.setHorizontalAlignment(SwingConstants.LEFT);

        tblRoles.getColumnModel().getColumn(0).setCellRenderer(tcr);

        tblRoles.setModel(miTabla);
        repararColumnaTable(tblRoles);
    }

    /**
     *
     * @param rolee
     */
    private void llenarTblPermisosAsignados(String rolee) {
        tblPermisosAsignados.removeAll();
        String[] titulos = {"Permisos asignados", "Con Administración"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getPermisosAsignados(rolee).stream().forEach(
                rol -> {
                    registro[0] = rol;
                    registro[1] = (rol.getOpcionPermiso() != 0);
                    miTabla.addRow(registro);
                }
        );

        tblPermisosAsignados.setModel(miTabla);

        int[] indices = {1};
        columnasCheckBox(tblPermisosAsignados, indices);

        repararColumnaTable(tblPermisosAsignados);
    }

    /**
     *
     * @param rolee
     */
    private void llenarTblPermisosDisponibles(String rolee) {
        tblPermisosDisponibles.removeAll();
        String[] titulos = {"Permisos Disponibles"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getPermisosDisponibles(rolee).stream().forEach(
                rol -> {
                    registro[0] = rol;
                    miTabla.addRow(registro);
                }
        );

        tblPermisosDisponibles.setModel(miTabla);

        repararColumnaTable(tblPermisosDisponibles);
    }

    /**
     *
     */
    private void llenarTblListadoUsuarios() {
        tblListadoUsuarios.removeAll();
        String[] titulos = {"Listado de Usuarios"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getNombresUsuarios().stream().forEach(
                usuario -> {
                    registro[0] = usuario.getUser_name().strip();
                    miTabla.addRow(registro);
                }
        );

        tblListadoUsuarios.setModel(miTabla);

        repararColumnaTable(tblListadoUsuarios);
    }

    /**
     * Metodo descontinuado, en su lugar llenarTblRolesDisponibles.
     *
     * @param userName
     */
//    private void llenarTblRolesUsuarios(String userName) {
//        tblRolesUsuario.removeAll();
//        String[] titulos = {"Roles del usuarios", "Con administración"};
//        Object[] registro = new Object[titulos.length];
//        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//
//        comprobandoRol(userName).stream().forEach(
//                rol -> {
//                    registro[0] = rol;
//                    registro[1] = rol.getOpcionPermiso() != 0;
//                    miTabla.addRow(registro);
//                }
//        );
//
//        tblRolesUsuario.setModel(miTabla);
//
//        int[] indices = {1};
//        columnasCheckBox(tblRolesUsuario, indices);
//
//        repararColumnaTable(tblRolesUsuario);
//    }
    /**
     *
     * @param userName
     */
    private void llenarTblRolesDisponibles(String userName) {
        tblRolesDisponibles.removeAll();
        String[] titulos = {"Roles del usuarios"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        comprobandoRolesDisponibles(userName, false).stream().forEach(
                rol -> {
                    registro[0] = rol;
                    miTabla.addRow(registro);
                }
        );

        tblRolesDisponibles.setModel(miTabla);

        repararColumnaTable(tblRolesDisponibles);

        //----------------------------------------------------------------------
        tblRolesUsuario.removeAll();
        String[] titulos2 = {"Roles del usuarios", "Con administración"};
        Object[] registro2 = new Object[titulos2.length];
        DefaultTableModel miTabla2 = new DefaultTableModel(null, titulos2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        comprobandoRolesDisponibles(userName, true).stream().forEach(
                rol -> {
                    registro2[0] = rol;
                    registro2[1] = rol.getOpcionPermiso() != 0;

                    miTabla2.addRow(registro2);
                }
        );

        tblRolesUsuario.setModel(miTabla2);

        int[] indices = {1};
        columnasCheckBox(tblRolesUsuario, indices);

        repararColumnaTable(tblRolesUsuario);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAsignarPermiso;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAsignarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarPermiso;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnQuitarAgregarPermisoAdmin;
    private RSMaterialComponent.RSButtonMaterialIconOne btnQuitarPermisoAdministrativoUsuario;
    private RSMaterialComponent.RSButtonMaterialIconOne btnQuitarRolUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel jpDefRoles;
    private javax.swing.JPanel jpMantRoles;
    private javax.swing.JPanel jpMantUsuarios;
    private javax.swing.JTabbedPane jtpPrivilegios;
    private RSMaterialComponent.RSTableMetro tblListadoUsuarios;
    private RSMaterialComponent.RSTableMetro tblPermisosAsignados;
    private RSMaterialComponent.RSTableMetro tblPermisosDisponibles;
    private RSMaterialComponent.RSTableMetro tblRoles;
    private RSMaterialComponent.RSTableMetro tblRolesDisponibles;
    private RSMaterialComponent.RSTableMetro tblRolesUsuario;
    private static RSMaterialComponent.RSTableMetro tblUsuarios;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtDescripcion1;
    // End of variables declaration//GEN-END:variables

    /**
     * Metodo que valida que un rol y un permiso por asignar esten seleccionado.
     *
     * @return Devuelve true si uno rol o un permiso no estan seleccionado, caso
     * contrario devuelve false.
     */
    private boolean validarSeleccionRolProcedimiento() {
        //Validar que tenga un rol seleccionado.
        if (tblRoles.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un rol.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Validamos que el procedimiento esta seleccionado.
        if (tblPermisosAsignados.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un permiso para el rol.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }

    private boolean validarSeleccionUsuarioRol() {
        //Validar que tenga un rol seleccionado.
        if (tblListadoUsuarios.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un usuario de la lista.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Validamos que el procedimiento esta seleccionado.
        if (tblRolesUsuario.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un rol asignado al usuario.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }
}
//private static rojerusan.RSTableMetro1 tblClientes;
