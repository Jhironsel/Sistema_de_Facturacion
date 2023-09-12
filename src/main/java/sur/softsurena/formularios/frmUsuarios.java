package sur.softsurena.formularios;

import java.util.Objects;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.DefaultTableCellHeaderRenderer;
import sur.softsurena.entidades.Roles;
import static sur.softsurena.entidades.Roles.comprobandoRol;
import static sur.softsurena.entidades.Roles.comprobandoRolesDisponibles;
import static sur.softsurena.entidades.Roles.getPermisosRoles;
import static sur.softsurena.entidades.Roles.getRoles;
import static sur.softsurena.entidades.Roles.getRolesDisponibles;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.entidades.Usuario.borrarUsuario;
import static sur.softsurena.entidades.Usuario.getNombresUsuarios;
import static sur.softsurena.entidades.Usuario.getUsuarios;
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
        jScrollPane7 = new javax.swing.JScrollPane();
        tblPermisosDisponibles = new RSMaterialComponent.RSTableMetro();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblPermisosAsignados = new RSMaterialComponent.RSTableMetro();
        btnBorrarPermiso = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAsignarPermiso = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnQuitarPermisoAdministrativo = new RSMaterialComponent.RSButtonMaterialIconOne();
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
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
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
        tblRoles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRoles);

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
        tblPermisosDisponibles.setToolTipText("");
        tblPermisosDisponibles.setName("tblRoles"); // NOI18N
        tblPermisosDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermisosDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblPermisosDisponibles);

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
        tblPermisosAsignados.setToolTipText("");
        tblPermisosAsignados.setName("tblRoles"); // NOI18N
        tblPermisosAsignados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermisosAsignadosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblPermisosAsignados);

        btnBorrarPermiso.setText("Borrar Permiso");
        btnBorrarPermiso.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnBorrarPermiso.setPreferredSize(new java.awt.Dimension(100, 40));
        btnBorrarPermiso.setRound(40);
        btnBorrarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPermisoActionPerformed(evt);
            }
        });

        btnAsignarPermiso.setText("Asignar permiso");
        btnAsignarPermiso.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAsignarPermiso.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAsignarPermiso.setRound(40);
        btnAsignarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarPermisoActionPerformed(evt);
            }
        });

        btnQuitarPermisoAdministrativo.setIcons(null);
        btnQuitarPermisoAdministrativo.setMaximumSize(new java.awt.Dimension(200, 0));
        btnQuitarPermisoAdministrativo.setMinimumSize(new java.awt.Dimension(80, 0));
        btnQuitarPermisoAdministrativo.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarPermisoAdministrativo.setRound(40);
        btnQuitarPermisoAdministrativo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPermisoAdministrativoActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setBorder(javax.swing.BorderFactory.createTitledBorder(" Descripcion del permiso "));
        txtDescripcion.setContentType("text/html"); // NOI18N
        jScrollPane11.setViewportView(txtDescripcion);

        javax.swing.GroupLayout jpMantRolesLayout = new javax.swing.GroupLayout(jpMantRoles);
        jpMantRoles.setLayout(jpMantRolesLayout);
        jpMantRolesLayout.setHorizontalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMantRolesLayout.createSequentialGroup()
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpMantRolesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnQuitarPermisoAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBorrarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMantRolesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantRolesLayout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(btnAsignarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane11))
                .addContainerGap())
        );
        jpMantRolesLayout.setVerticalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMantRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMantRolesLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jpMantRolesLayout.createSequentialGroup()
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBorrarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnQuitarPermisoAdministrativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAsignarPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>Roles</b><center></html>", null, jpMantRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

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
        tblListadoUsuarios.setName("tblRoles"); // NOI18N
        tblListadoUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoUsuariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblListadoUsuarios);

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
        tblRolesUsuario.setName("tblRoles"); // NOI18N
        tblRolesUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesUsuarioMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblRolesUsuario);

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
        tblRolesDisponibles.setName("tblRoles"); // NOI18N
        tblRolesDisponibles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRolesDisponiblesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblRolesDisponibles);

        btnAsignarRol.setText("Asignar rol");
        btnAsignarRol.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAsignarRol.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAsignarRol.setRound(40);
        btnAsignarRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarRolActionPerformed(evt);
            }
        });

        btnQuitarRolUsuario.setText("Quitar rol");
        btnQuitarRolUsuario.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnQuitarRolUsuario.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarRolUsuario.setRound(40);
        btnQuitarRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarRolUsuarioActionPerformed(evt);
            }
        });

        btnQuitarPermisoAdministrativoUsuario.setIcons(null);
        btnQuitarPermisoAdministrativoUsuario.setMaximumSize(new java.awt.Dimension(200, 0));
        btnQuitarPermisoAdministrativoUsuario.setMinimumSize(new java.awt.Dimension(100, 0));
        btnQuitarPermisoAdministrativoUsuario.setPreferredSize(new java.awt.Dimension(100, 40));
        btnQuitarPermisoAdministrativoUsuario.setRound(40);
        btnQuitarPermisoAdministrativoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarPermisoAdministrativoUsuarioActionPerformed(evt);
            }
        });

        txtDescripcion1.setEditable(false);
        txtDescripcion1.setBorder(javax.swing.BorderFactory.createTitledBorder(" Descripcion del rol "));
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
                            .addGroup(jpDefRolesLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addComponent(btnQuitarPermisoAdministrativoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnQuitarRolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jpDefRolesLayout.createSequentialGroup()
                                .addGap(0, 160, Short.MAX_VALUE)
                                .addComponent(btnAsignarRol, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jpDefRolesLayout.setVerticalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDefRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jpDefRolesLayout.createSequentialGroup()
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                    this,
                    "Ingrese nombre del rol.",
                    "Agregando rol al sistema",
                    JOptionPane.PLAIN_MESSAGE
            );
            if (Objects.isNull(rol)) {
                return;
            }
            Roles.createRole(rol);
            llenarTblRoles();
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {

        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            if (tblRoles.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debe seleccionar un registros.",
                        "Comprobacion de proceso.",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String rolActual = tblRoles.getValueAt(
                    tblRoles.getSelectedRow(), 0).toString();

            String rolNuevo = JOptionPane.showInternalInputDialog(
                    this,
                    "Ingrese nombre del nuevo rol:",
                    "Cambio de nombre de roles.",
                    JOptionPane.QUESTION_MESSAGE
            );

            Roles.modificarRol(rolActual, rolNuevo);
            llenarTblRoles();
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
                    Usuario.getUsuario(userName)
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

    private void jtpPrivilegiosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jtpPrivilegiosStateChanged
        if (jtpPrivilegios.getSelectedComponent() == jpMantUsuarios) {
            llenarTabla();
        } else if (jtpPrivilegios.getSelectedComponent() == jpMantRoles) {
            llenarTblRoles();
        } else if (jtpPrivilegios.getSelectedComponent() == jpDefRoles) {
            llenarTblListadoUsuarios();
        }
    }//GEN-LAST:event_jtpPrivilegiosStateChanged

    private void btnAsignarRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarRolActionPerformed
        if(tblListadoUsuarios.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un usuario de la lista.",
                    "Validacion de procedimiento.",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if(tblRolesDisponibles.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un rol de la lista",
                    "Validacion de procedimiento.",
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
                "Proceso de validacion de asignacion!",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        boolean admin = repuesta == JOptionPane.YES_OPTION;
        
        Roles.asignarRolUsuario(rol, usuario, admin);
        
        tblListadoUsuariosMouseClicked(null);
    }//GEN-LAST:event_btnAsignarRolActionPerformed

    private void btnBorrarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPermisoActionPerformed
        if (validarSeleccionRolProcedimiento()) {
            return;
        }
        int resp = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea eliminar permiso al usuario?",
                "Proceso de validación de usuario.",
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
        
        Roles.borrarPermisoAdminProcedimiento(procedimiento, rol);
        tblRolesMouseClicked(null);
        
    }//GEN-LAST:event_btnBorrarPermisoActionPerformed

    private void btnAsignarPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarPermisoActionPerformed

        if (tblRoles.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un rol de la lista",
                    "Validacion de procedimiento.",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        if (tblPermisosDisponibles.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar permiso de la lista",
                    "Validacion de procedimiento.",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        String rol = tblRoles.getValueAt(
                tblRoles.getSelectedRow(), 0).toString();
        
        String permiso = tblPermisosDisponibles.getValueAt(
                tblPermisosDisponibles.getSelectedRow(), 0).toString();

        int repuesta = JOptionPane.showInternalConfirmDialog(
                this,
                "Desea agregar rol administrador?",
                "Creación de rol.",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        boolean admin = repuesta == JOptionPane.YES_OPTION;

        Roles.asignarRol(permiso, rol, admin);

        tblRolesMouseClicked(null);
    }//GEN-LAST:event_btnAsignarPermisoActionPerformed

    private void tblRolesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesMouseClicked
        String rol = tblRoles.getValueAt(tblRoles.getSelectedRow(), 0).toString();
        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }
        llenarTblPermisos(rol);
        llenarTblPermisosDisponibles(rol);
    }//GEN-LAST:event_tblRolesMouseClicked

    private void tblListadoUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoUsuariosMouseClicked
        String usuario = tblListadoUsuarios.getValueAt(tblListadoUsuarios.getSelectedRow(), 0).toString();
        llenarTblRolesUsuarios(usuario);
        llenarTblRolesDisponibles(usuario);
    }//GEN-LAST:event_tblListadoUsuariosMouseClicked

    private void btnQuitarPermisoAdministrativoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarPermisoAdministrativoActionPerformed
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
                "Proceso de validación de usuario.",
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

        if (accesoAdmin) {
            Roles.quitarPermisoAdminProcedimiento(procedimiento, rol);
        } else {
            Roles.agregarPermisoAdminProcedimiento(procedimiento, rol);
        }
        tblRolesMouseClicked(null);

    }//GEN-LAST:event_btnQuitarPermisoAdministrativoActionPerformed

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
                "Proceso de validación de usuario.",
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
            Roles.quitarPermisoAdminProcedimiento(rol, usuario);
        } else {
            Roles.agregarPermisoAdminProcedimiento(rol, usuario);
        }
        tblRolesMouseClicked(null);
    }//GEN-LAST:event_btnQuitarPermisoAdministrativoUsuarioActionPerformed

    private void tblPermisosAsignadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisosAsignadosMouseClicked
        boolean conAdmin = (boolean) tblPermisosAsignados.getValueAt(
                tblPermisosAsignados.getSelectedRow(), 1);
        if (conAdmin) {
            btnQuitarPermisoAdministrativo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
            btnQuitarPermisoAdministrativo.setText("Quitar permiso administrativo");
        } else {
            btnQuitarPermisoAdministrativo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
            btnQuitarPermisoAdministrativo.setText("Agregar permiso administrativo");
        }
        
        txtDescripcion.setText(((Roles)
                tblPermisosAsignados.getValueAt(
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
        
        txtDescripcion1.setText(((Roles)
                tblRolesUsuario.getValueAt(
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
                "Proceso de validación de usuario.",
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
        
        if(rol.equalsIgnoreCase("ADMINISTRADOR")){
            rol="RDB$ADMIN";
        }
        
        Roles.quitarRolUsuario( rol, usuario);
        
        tblListadoUsuariosMouseClicked(null);
    }//GEN-LAST:event_btnQuitarRolUsuarioActionPerformed

    private void tblRolesDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRolesDisponiblesMouseClicked
        txtDescripcion1.setText(((Roles)
                tblRolesDisponibles.getValueAt(
                        tblRolesDisponibles.getSelectedRow(), 0)).
                getDescripcion()
        );
    }//GEN-LAST:event_tblRolesDisponiblesMouseClicked

    private void tblPermisosDisponiblesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermisosDisponiblesMouseClicked
        txtDescripcion.setText(((Roles)
                tblPermisosAsignados.getValueAt(
                        tblPermisosAsignados.getSelectedRow(), 0)).
                getDescripcion()
        );
    }//GEN-LAST:event_tblPermisosDisponiblesMouseClicked

    /**
     *
     */
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

        int[] indices = {4, 5};
        columnasCheckBox(tblUsuarios, indices);

        repararColumnaTable(tblUsuarios);

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

    /**
     *
     * @param rolee
     */
    private void llenarTblPermisos(String rolee) {
        tblPermisosAsignados.removeAll();
        String[] titulos = {"Permisos asignados", "Con Administración"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        getPermisosRoles(rolee).stream().forEach(rol -> {
            registro[0] = rol;
            registro[1] = (rol.getOpcionPermiso() != 0);
            miTabla.addRow(registro);
        });

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

        getRolesDisponibles(rolee).stream().forEach(rol -> {
            registro[0] = rol.getNombreProcedimiento().strip();
            miTabla.addRow(registro);
        });

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

        getNombresUsuarios().stream().forEach(usuario -> {
            registro[0] = usuario.getUser_name().strip();
            miTabla.addRow(registro);
        });

        tblListadoUsuarios.setModel(miTabla);

        repararColumnaTable(tblListadoUsuarios);
    }

    /**
     *
     * @param userName
     */
    private void llenarTblRolesUsuarios(String userName) {
        tblRolesUsuario.removeAll();
        String[] titulos = {"Roles del usuarios", "Con administración"};
        Object[] registro = new Object[titulos.length];
        DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        comprobandoRol(userName).stream().forEach(rol -> {
            registro[0] = rol;
            registro[1] = rol.getOpcionPermiso() != 0;
            miTabla.addRow(registro);
        });

        tblRolesUsuario.setModel(miTabla);

        int[] indices = {1};
        columnasCheckBox(tblRolesUsuario, indices);

        repararColumnaTable(tblRolesUsuario);
    }

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

        comprobandoRolesDisponibles(userName).stream().forEach(rol -> {
            registro[0] = rol;
            miTabla.addRow(registro);
        });

        tblRolesDisponibles.setModel(miTabla);

        repararColumnaTable(tblRolesDisponibles);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAsignarPermiso;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAsignarRol;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrarPermiso;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private RSMaterialComponent.RSButtonMaterialIconOne btnQuitarPermisoAdministrativo;
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
     *
     * @return
     */
    private boolean validarSeleccionRolProcedimiento() {
        //Validar que tenga un rol seleccionado.
        if (tblRoles.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un rol.",
                    "Validación de rol",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Validamos que el procedimiento esta seleccionado.
        if (tblPermisosAsignados.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un permiso para el rol.",
                    "Validación de rol",
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
                    "Validación de usuario",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        //Validamos que el procedimiento esta seleccionado.
        if (tblRolesUsuario.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe selecionar un rol asignado al usuario.",
                    "Validación de rol",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }
}
//private static rojerusan.RSTableMetro1 tblClientes;
