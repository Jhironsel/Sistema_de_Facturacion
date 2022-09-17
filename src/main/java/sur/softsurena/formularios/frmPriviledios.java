package sur.softsurena.formularios;

import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static sur.softsurena.datos.select.SelectMetodos.getUsuarios;
import sur.softsurena.entidades.Usuarios;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmPriviledios extends javax.swing.JInternalFrame {

    private DefaultTableModel miTabla;
    private static final Logger LOG = Logger.getLogger(frmPriviledios.class.getName());

    public frmPriviledios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtpPrivilegios = new javax.swing.JTabbedPane();
        jpMantUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }

            @Override
            public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);
                TableModel model = getModel();
                tip = ((Usuarios) model.getValueAt(rowIndex, 0)).getDescripcion();
                return tip;
            }
        };
        ;
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jpMantRoles = new javax.swing.JPanel();
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

        jtpPrivilegios.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tblTabla.setAutoCreateRowSorter(true);
        tblTabla.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        tblTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Usuario", "Nombre", "Apellidos", "Perfil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTabla.setDoubleBuffered(true);
        tblTabla.setEditingRow(10);
        tblTabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(tblTabla);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.setMaximumSize(null);
        btnNuevo.setMinimumSize(null);
        btnNuevo.setPreferredSize(null);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel4.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnModificar.setMnemonic('e');
        btnModificar.setText("Editar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.setMaximumSize(null);
        btnModificar.setMinimumSize(null);
        btnModificar.setPreferredSize(null);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        btnBorrar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.setMaximumSize(null);
        btnBorrar.setMinimumSize(null);
        btnBorrar.setPreferredSize(null);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar);

        btnBuscar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnBuscar.setMnemonic('r');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Buscar el Registro");
        btnBuscar.setMaximumSize(null);
        btnBuscar.setMinimumSize(null);
        btnBuscar.setPreferredSize(null);
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

        javax.swing.GroupLayout jpMantUsuariosLayout = new javax.swing.GroupLayout(jpMantUsuarios);
        jpMantUsuarios.setLayout(jpMantUsuariosLayout);
        jpMantUsuariosLayout.setHorizontalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        jpMantUsuariosLayout.setVerticalGroup(
            jpMantUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMantUsuariosLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>de<br>Usuarios</b><center></html>", null, jpMantUsuarios, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        javax.swing.GroupLayout jpMantRolesLayout = new javax.swing.GroupLayout(jpMantRoles);
        jpMantRoles.setLayout(jpMantRolesLayout);
        jpMantRolesLayout.setHorizontalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jpMantRolesLayout.setVerticalGroup(
            jpMantRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>de<br>Roles</b><center></html>", null, jpMantRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        javax.swing.GroupLayout jpDefRolesLayout = new javax.swing.GroupLayout(jpDefRoles);
        jpDefRoles.setLayout(jpDefRolesLayout);
        jpDefRolesLayout.setHorizontalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        jpDefRolesLayout.setVerticalGroup(
            jpDefRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jtpPrivilegios.addTab("<html><center><b>Mantenimiento<br>de<br>Roles</b><center></html>", null, jpDefRoles, "Permite definir los roles del sistema que agrupan a un conjuto de usuarios.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPrivilegios)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtpPrivilegios)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Botones Para Deshabilitar:
        frmUsuariosAgregar u = new frmUsuariosAgregar(null, true);
        u.setLocationRelativeTo(this);
        u.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tblTabla.getSelectedRow() == -1) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debes seleccionar un usuario.");
            return;
        }
        
        Usuarios u = Usuarios.builder().
                user_name(tblTabla.getValueAt(tblTabla.getSelectedRow(), 0).toString().trim()).
                pNombre(tblTabla.getValueAt(tblTabla.getSelectedRow(), 1).toString().trim()).
                sNombre(tblTabla.getValueAt(tblTabla.getSelectedRow(), 2).toString().trim()).
                apellidos(tblTabla.getValueAt(tblTabla.getSelectedRow(), 3).toString().trim()).
                administrador(((Boolean) tblTabla.getValueAt(tblTabla.getSelectedRow(), 4))).
                estado((((Boolean) tblTabla.getValueAt(tblTabla.getSelectedRow(), 5)))).
                descripcion(((Usuarios) tblTabla.getValueAt(tblTabla.getSelectedRow(), 0)).getDescripcion()).
                build();
        
        frmUsuariosAgregar user = new frmUsuariosAgregar(null, true, u);
        user.setLocationRelativeTo(this);
        user.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int rta = JOptionPane.showConfirmDialog(
                this,
                "Esta seguro de eliminar Usuario",
                "Confirmacion!!!",
                JOptionPane.YES_NO_OPTION);

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        frmConfirmacion c = new frmConfirmacion(null, true);
        c.setLocationRelativeTo(this);
        c.setVisible(true);

        if (c.aceptar == null) {
            return;
        }

        if (!c.aceptar) {
            JOptionPane.showMessageDialog(this, "Ingrese corretamente el codigo.");
            return;
        }

        String msg, rol;

        rol = tblTabla.getValueAt(tblTabla.getSelectedRow(), 3).toString().trim();

        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }

        try {
            //            msg = borrarUsuario(tblTabla.getValueAt(tblTabla.getSelectedRow(), 0).
            //                    toString().trim(), rol);
        } catch (Exception ex) {
            msg = "Usuario no fue eliminado porque existen \n"
                    + "registros en el sistema";
            LOG.log(Level.SEVERE, "Error al borrar usuarios del sistema.", ex);
        }

        //        JOptionPane.showMessageDialog(rootPane, msg);
        //Actualizamos los cambios en la Tabla
        llenarTabla();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String usuario = JOptionPane.showInputDialog(
                "Ingrese el Codigo de Usuario");

        if (usuario == null || usuario.equals("")) {
            return;
        }

        //        if (!existeUsuario(usuario)) {
        //            JOptionPane.showMessageDialog(rootPane, "El Usuario No Existe");
        //            return;
        //        }
        //Detalle de Factura
        int num = tblTabla.getRowCount();
        for (int i = 0; i < num; i++) {
            if (tblTabla.getValueAt(i, 0).toString().equalsIgnoreCase(usuario)) {
                tblTabla.setRowSelectionInterval(i, i);
                break;
            }
            if (tblTabla.getValueAt(i, 1).toString().equalsIgnoreCase(usuario)) {
                tblTabla.setRowSelectionInterval(i, i);
                break;
            }
            if (tblTabla.getValueAt(i, 2).toString().equalsIgnoreCase(usuario)) {
                tblTabla.setRowSelectionInterval(i, i);
                break;
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void llenarTabla() {
        tblTabla.removeAll();
        try {
            String titulos[] = {"Nombre usuario", "Primer Nombre",
                "Segundo Nombre", "Apellidos", "Administrador", "Estado"};

            Object registro[] = new Object[titulos.length];

            miTabla = new DefaultTableModel(null,
                    titulos) {
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 5 || column == 4) {
                        return Boolean.class;
                    } else {
                        return String.class;
                    }
                }

            };

            ResultSet rs = getUsuarios();

            while (rs.next()) {
                Usuarios u = Usuarios.builder().
                        user_name(rs.getString("USER_NAME")).
                        descripcion(rs.getString("DESCRIPCION"))
                        .build();
                registro[0] = u;
                registro[1] = rs.getString("PNOMBRE");
                registro[2] = rs.getString("SNOMBRE");
                registro[3] = rs.getString("APELLIDOS");
                registro[4] = rs.getBoolean("ADMINISTRADOR");
                registro[5] = rs.getBoolean("ESTADO");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Error al construir la tabla de usuarios", ex);
        }

        repararColumnaTable(tblTabla);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jpDefRoles;
    private javax.swing.JPanel jpMantRoles;
    private javax.swing.JPanel jpMantUsuarios;
    private javax.swing.JTabbedPane jtpPrivilegios;
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
