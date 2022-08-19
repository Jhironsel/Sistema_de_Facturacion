package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmUsuarios extends javax.swing.JInternalFrame {

    public frmUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documento nuevo 32 x 32.png"))); // NOI18N
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
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar Documento 32 x 32.png"))); // NOI18N
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
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar 32 x 32.png"))); // NOI18N
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
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar2 32 x 32.png"))); // NOI18N
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
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int rta = JOptionPane.showConfirmDialog(this,
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
            //Instalar Logger
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
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Botones Para Deshabilitar:
        frmUsuariosAgregar u = new frmUsuariosAgregar(null, true);
        u.setLocationRelativeTo(this);
        u.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tblTabla.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un usuario.");
            return;
        }

//        frmUsuariosAgregar u = new frmUsuariosAgregar(null, true,
//                new Usuario(
//                        tblTabla.getValueAt(tblTabla.getSelectedRow(), 0).toString().trim(),
//                        tblTabla.getValueAt(tblTabla.getSelectedRow(), 1).toString().trim(),
//                        tblTabla.getValueAt(tblTabla.getSelectedRow(), 2).toString().trim(),
//                        null,
//                        tblTabla.getValueAt(tblTabla.getSelectedRow(), 3).toString().trim(),
//                        (Boolean) tblTabla.getValueAt(tblTabla.getSelectedRow(), 5),
//                        (Boolean) tblTabla.getValueAt(tblTabla.getSelectedRow(), 4)
//                ));
//        u.setLocationRelativeTo(this);
//        u.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla();
    }//GEN-LAST:event_formInternalFrameOpened

    private void llenarTabla() {
        tblTabla.removeAll();
        try {
            String titulos[] = {"ID Usuario", "Nombres", "Apellidos", "Perfil",
                "Delega", "Estado"};

            Object registro[] = new Object[6];

            DefaultTableModel miTabla = new DefaultTableModel(null, titulos) {
                @Override
                public Class<?> getColumnClass(int column) {
                    if (column == 5 || column == 4) {
                        return Boolean.class;
                    } else {
                        return String.class;
                    }
                }
            };
//Datos.getUsuarios()
            ResultSet rs = null ;

            while (rs.next()) {
                registro[0] = rs.getString("IDUSUARIO").trim();
                registro[1] = rs.getString("NOMBREUNO").trim();
                registro[2] = rs.getString("APELLIDOS").trim();
                registro[3] = rs.getString("ROL").trim().equalsIgnoreCase("RDB$ADMIN")
                        ? "ADMINISTRADOR" : rs.getString("ROL").trim();
                registro[4] = rs.getBoolean("AUTORIZADO");
                registro[5] = rs.getBoolean("ESTADO");

                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }
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
    private javax.swing.JTable tblTabla;
    // End of variables declaration//GEN-END:variables
}
