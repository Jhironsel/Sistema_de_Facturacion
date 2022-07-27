package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sur.softsurena.entidades.Opcion;

public class frmPerfiles extends javax.swing.JDialog {

    private boolean crear = false;
    private String descripcion;
    private int posItem = 0, idAcesso;
    private frmPrincipal miPrincipal;
    private Opcion opc;

    public frmPrincipal getMiPrincipal() {
        return miPrincipal;
    }

    public void setMiPrincipal(frmPrincipal miPrincipal) {
        this.miPrincipal = miPrincipal;
    }

    public int getPosItem() {
        return posItem;
    }

    public void setPosItem(int posItem) {
        this.posItem = posItem;
    }

    public frmPerfiles(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        cbArchivos = new javax.swing.JCheckBox();
        cbArchivosClientes = new javax.swing.JCheckBox();
        cbArchivosProductos = new javax.swing.JCheckBox();
        cbArchivosUsuarios = new javax.swing.JCheckBox();
        cbArchivosCambioUsuario = new javax.swing.JCheckBox();
        cbArchivosCambioClave = new javax.swing.JCheckBox();
        cbArchivosSalir = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        cbMovimientos = new javax.swing.JCheckBox();
        cbMovimientosNuevaFactura = new javax.swing.JCheckBox();
        cbMovimientosReporteFactura = new javax.swing.JCheckBox();
        cbMovimientosInventario = new javax.swing.JCheckBox();
        cbMovimientosCerrarTurno = new javax.swing.JCheckBox();
        cbMovimientosAbrirTurno = new javax.swing.JCheckBox();
        cbMovimientosDeuda = new javax.swing.JCheckBox();
        btnCrear = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lMensaje = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lNombrePerfil = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear de Perfil de Usuario...");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Perfiles:");

        cmbPerfil.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cmbPerfil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbPerfilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Archivos"));

        cbArchivos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivos.setText("Activar modulos");
        cbArchivos.setDoubleBuffered(true);
        cbArchivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbArchivosMouseClicked(evt);
            }
        });

        cbArchivosClientes.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosClientes.setText("Clientes");
        cbArchivosClientes.setDoubleBuffered(true);

        cbArchivosProductos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosProductos.setText("Productos");
        cbArchivosProductos.setDoubleBuffered(true);

        cbArchivosUsuarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosUsuarios.setText("Usuarios");
        cbArchivosUsuarios.setDoubleBuffered(true);

        cbArchivosCambioUsuario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosCambioUsuario.setText("Cambio de Usuario");
        cbArchivosCambioUsuario.setDoubleBuffered(true);

        cbArchivosCambioClave.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosCambioClave.setText("Cambio de Clave");
        cbArchivosCambioClave.setDoubleBuffered(true);

        cbArchivosSalir.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbArchivosSalir.setText("Salir");
        cbArchivosSalir.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbArchivosProductos)
                            .addComponent(cbArchivosClientes)
                            .addComponent(cbArchivosUsuarios)
                            .addComponent(cbArchivosSalir)
                            .addComponent(cbArchivosCambioClave)
                            .addComponent(cbArchivosCambioUsuario)))
                    .addComponent(cbArchivos))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cbArchivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosCambioClave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosCambioUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbArchivosSalir)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimientos"));

        cbMovimientos.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientos.setText("Activar modulos");
        cbMovimientos.setDoubleBuffered(true);
        cbMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMovimientosMouseClicked(evt);
            }
        });

        cbMovimientosNuevaFactura.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosNuevaFactura.setText("Nueva Factura");
        cbMovimientosNuevaFactura.setDoubleBuffered(true);

        cbMovimientosReporteFactura.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosReporteFactura.setText("Reporte de Facturas");
        cbMovimientosReporteFactura.setDoubleBuffered(true);

        cbMovimientosInventario.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosInventario.setText("Inventario");
        cbMovimientosInventario.setDoubleBuffered(true);

        cbMovimientosCerrarTurno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosCerrarTurno.setText("Cerrar turno");
        cbMovimientosCerrarTurno.setDoubleBuffered(true);

        cbMovimientosAbrirTurno.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosAbrirTurno.setText("Abrir turno");
        cbMovimientosAbrirTurno.setDoubleBuffered(true);

        cbMovimientosDeuda.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbMovimientosDeuda.setText("Deudas");
        cbMovimientosDeuda.setDoubleBuffered(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMovimientosReporteFactura)
                            .addComponent(cbMovimientosNuevaFactura)
                            .addComponent(cbMovimientosInventario)
                            .addComponent(cbMovimientosAbrirTurno)
                            .addComponent(cbMovimientosCerrarTurno)
                            .addComponent(cbMovimientosDeuda)))
                    .addComponent(cbMovimientos))
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbMovimientos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMovimientosNuevaFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMovimientosReporteFactura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMovimientosInventario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMovimientosAbrirTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMovimientosCerrarTurno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbMovimientosDeuda)
                .addContainerGap())
        );

        btnCrear.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Agregar 32 x 32.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar Documento 32 x 32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lMensaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lNombrePerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lNombrePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(cmbPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCrear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBorrar)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(cmbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel1, jPanel3});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cmbPerfilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbPerfilPopupMenuWillBecomeInvisible
        llenarCheck();
    }//GEN-LAST:event_cmbPerfilPopupMenuWillBecomeInvisible
    private void cbArchivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbArchivosMouseClicked
        if (!cbArchivos.isEnabled()) {
            return;
        }
        if (cbArchivos.isSelected()) {
            cbArchivos.setText("Inactivar modulos");
            cbArchivos.repaint();
            habilitarCheck(2);
            habilitarCheck(6);
        } else {
            cbArchivos.setText("Activar modulos");
            cbArchivos.repaint();
            deshabilitarCheck(2);
            deseleccionarCheck(2);
        }
    }//GEN-LAST:event_cbArchivosMouseClicked
    private void cbMovimientosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMovimientosMouseClicked
        if (!cbMovimientos.isEnabled()) {
            return;
        }
        if (cbMovimientos.isSelected()) {
            cbMovimientos.setText("Inactivar modulos");
            habilitarCheck(4);
        } else {
            cbMovimientos.setText("Activar modulos");
            deshabilitarCheck(4);
            deseleccionarCheck(4);
        }
    }//GEN-LAST:event_cbMovimientosMouseClicked
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        crear = true;
        descripcion = JOptionPane.showInputDialog(this, "Inserte el nombre del perfil: ");
        if (descripcion == null) {
            return;
        }
        if (descripcion.trim().isEmpty()) {
            return;
        }
        if (descripcion.equals("Administrador")) {
            JOptionPane.showMessageDialog(this, "Nombre de Perfil invalido");
            return;
        }

        JOptionPane.showMessageDialog(this, "Definir los permisos para el perfil: ( " + descripcion + " )");
        deseleccionarCheck(5);
        deshabilitarCheck(5);
        habilitarCheck(1);
        habilitarCheck(3);

        lMensaje.setText("Creando el Perfil: ");
        lNombrePerfil.setText("     " + descripcion);

        btnCrear.setEnabled(false);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
        cmbPerfil.setEnabled(false);

        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnCrearActionPerformed
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (((Opcion) cmbPerfil.getSelectedItem()).getDescripcion().equals("Administrador")) {
            JOptionPane.showMessageDialog(null, "Perfil no puede ser eliminado");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Deseas eliminar Perfil llamado: "
                + ((Opcion) cmbPerfil.getSelectedItem()).getDescripcion()
                + " \nDesea continuar?\n\nRECUERDE QUE SI EXISTE UN USUARIO CON ESTE PERFIL DEBE ELIMINAR EL USUARIO PRIMERO",
                "Eliminar perfil", JOptionPane.YES_NO_OPTION);
        if (resp == 1) {
            return;
        } else {
            JOptionPane.showMessageDialog(this, borrarPerfil(((Opcion) cmbPerfil.getSelectedItem()).getValor()));
        }
        this.setVisible(false);
    }//GEN-LAST:event_btnBorrarActionPerformed
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (cmbPerfil.getSelectedItem().toString().equals("Administrador")) {
            JOptionPane.showMessageDialog(null, "Perfil no puede ser editado");
            return;
        }
        frmDialogoCategoria miDialogo = new frmDialogoCategoria(null, true,
                descripcion, "Desea cambiar nombre del Perfil?", "Nombre Perfil:");
        miDialogo.setLocationRelativeTo(null);
        miDialogo.setVisible(true);
        
        if(miDialogo.getNombreCategoria() == null){
            return;
        }

        descripcion = miDialogo.getNombreCategoria();

        crear = false;
        idAcesso = Integer.parseInt(((Opcion) cmbPerfil.getSelectedItem()).getValor());
        descripcion = ((Opcion) cmbPerfil.getSelectedItem()).getDescripcion();

        btnCrear.setEnabled(false);
        btnEditar.setEnabled(false);
        btnBorrar.setEnabled(false);
        cmbPerfil.setEnabled(false);

        btnGuardar.setEnabled(true);

        lMensaje.setText("Editando el Perfil: ");
        lNombrePerfil.setText("     " + descripcion);

        habilitarCheck(1);
        habilitarCheck(3);
        if (cbArchivos.isSelected()) {
            habilitarCheck(2);
        }
        if (cbMovimientos.isSelected()) {
            habilitarCheck(4);
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Perfil miPerfil = new Perfil(
                dime(cbArchivos.isSelected()),
                dime(cbArchivosClientes.isSelected()),
                dime(cbArchivosProductos.isSelected()),
                dime(cbArchivosUsuarios.isSelected()),
                dime(cbArchivosCambioClave.isSelected()),
                dime(cbArchivosCambioUsuario.isSelected()),
                dime(cbArchivosSalir.isSelected()),
                dime(cbMovimientos.isSelected()),
                dime(cbMovimientosNuevaFactura.isSelected()),
                dime(cbMovimientosReporteFactura.isSelected()),
                dime(cbMovimientosInventario.isSelected()),
                dime(cbMovimientosAbrirTurno.isSelected()),
                dime(cbMovimientosCerrarTurno.isSelected()),
                dime(cbMovimientosDeuda.isSelected()));

        if (crear) {
            agregarPerfil(descripcion);
            int idPerfil = getNumPerfil();

            ResultSet rs = getConsulta(
                    "SELECT COALESCE(MAX(r.IDACCESO) + 1, 1) "
                  + "FROM Tabla_ACCESO2 r");

            try {
                rs.next();
                idAcesso = rs.getInt(1);
            } catch (SQLException ex) {
                //Instalar Logger
            }

            String msj = agregarOrModificarAcesso(idAcesso, idPerfil, miPerfil);

            JOptionPane.showMessageDialog(this, msj);

            if (msj.equals("Error al Insertar Acesso...")) {
                borrarT_Perfil(idPerfil);
            }
            crear = false;
        } else {
            ResultSet rs = getConsulta(
                    "SELECT r.IDACCESO FROM Tabla_ACCESO2 r WHERE r.IDPERFIL = " + idAcesso);
            Integer num = 1;
            try {
                rs.next();
                num = rs.getInt(1);
            } catch (SQLException ex) {
                //Instalar Logger
            }

            JOptionPane.showMessageDialog(this,
                    agregarOrModificarAcesso(num, idAcesso, miPerfil) + "\n"
                    + modificarT_Perfil(idAcesso, descripcion));
        }

        llenarCombo();
        llenarCheck();

        btnCrear.setEnabled(true);
        btnEditar.setEnabled(true);
        btnBorrar.setEnabled(true);
        cmbPerfil.setEnabled(true);

        btnGuardar.setEnabled(false);

        lMensaje.setText("");
        lNombrePerfil.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cmbPerfil.setSelectedIndex(0);
        deshabilitarCheck(5);

        btnCrear.setEnabled(true);
        btnEditar.setEnabled(true);
        btnBorrar.setEnabled(true);
        cmbPerfil.setEnabled(true);

        btnGuardar.setEnabled(false);

        lMensaje.setText("");
        lNombrePerfil.setText("");

        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarCombo();
        cmbPerfil.setSelectedIndex(getPosItem());
        llenarCheck();
    }//GEN-LAST:event_formWindowOpened
    

    private void llenarCombo() {
        cmbPerfil.removeAllItems();
        ResultSet rs = getConsulta("SELECT r.IDPERFIL, r.DESCRIPCION "
                + "FROM Tabla_T_PERFIL r "
                + "order by 1");
        try {
            while (rs.next()) {
                opc = new Opcion(rs.getString("IdPerfil"), rs.getString("descripcion"));
                cmbPerfil.addItem(opc);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private void llenarCheck() {
        ResultSet rsCheck = getConsulta("select * from Tabla_ACCESO2 where idPerfil = "
                + ((Opcion) cmbPerfil.getSelectedItem()).getValor() + "");
        try {
            rsCheck.next();
            cbArchivos.setSelected(permiso(rsCheck.getString("ARCHIVOS")));
            cbArchivosClientes.setSelected(permiso(rsCheck.getString("ARCHIVOSCLIENTES")));
            cbArchivosProductos.setSelected(permiso(rsCheck.getString("ARCHIVOSPRODUCTOS")));
            cbArchivosUsuarios.setSelected(permiso(rsCheck.getString("ARCHIVOSUSUARIOS")));
            cbArchivosCambioClave.setSelected(permiso(rsCheck.getString("ARCHIVOSCAMBIOCLAVE")));
            cbArchivosCambioUsuario.setSelected(permiso(rsCheck.getString("ARCHIVOSCAMBIOUSUARIO")));
            cbArchivosSalir.setSelected(permiso(rsCheck.getString("ARCHIVOSSALIR")));

            cbMovimientos.setSelected(permiso(rsCheck.getString("MOVIMIENTOS")));
            cbMovimientosNuevaFactura.setSelected(permiso(rsCheck.getString("MOVIMIENTOSNUEVAFACTURA")));
            cbMovimientosReporteFactura.setSelected(permiso(rsCheck.getString("MOVIMIENTOSREPORTEFACTURA")));
            cbMovimientosInventario.setSelected(permiso(rsCheck.getString("MOVIMIENTOSINVENTARIO")));
            cbMovimientosAbrirTurno.setSelected(permiso(rsCheck.getString("MOVIMIENTOSABRILTURNO")));
            cbMovimientosCerrarTurno.setSelected(permiso(rsCheck.getString("MOVIMIENTOSCERRARTURNO")));
            cbMovimientosDeuda.setSelected(permiso(rsCheck.getString("MOVIMIENTOSDEUDA")));
        } catch (SQLException ex) {
            //Instalar Logger
        }
        deshabilitarCheck(5);
    }

    private void habilitarCheck(int campo) {
        if (campo == 1 || campo == 5) {
            cbArchivos.setEnabled(true);
        }
        if (campo == 2 || campo == 5) {
            cbArchivosClientes.setEnabled(true);
            cbArchivosProductos.setEnabled(true);
            cbArchivosUsuarios.setEnabled(true);
            cbArchivosCambioClave.setEnabled(true);
            cbArchivosCambioUsuario.setEnabled(true);
            cbArchivosSalir.setEnabled(true);
        }
        if (campo == 3 || campo == 5) {
            cbMovimientos.setEnabled(true);
        }
        if (campo == 4 || campo == 5) {
            cbMovimientosNuevaFactura.setEnabled(true);
            cbMovimientosReporteFactura.setEnabled(true);
            cbMovimientosInventario.setEnabled(true);
            cbMovimientosAbrirTurno.setEnabled(true);
            cbMovimientosCerrarTurno.setEnabled(true);
            cbMovimientosDeuda.setEnabled(true);
        }
    }

    private void deshabilitarCheck(int campo) {
        if (campo == 1 || campo == 5) {
            cbArchivos.setEnabled(false);
        }
        if (campo == 2 || campo == 5) {
            cbArchivosClientes.setEnabled(false);
            cbArchivosProductos.setEnabled(false);
            cbArchivosUsuarios.setEnabled(false);
            cbArchivosCambioClave.setEnabled(false);
            cbArchivosCambioUsuario.setEnabled(false);
            cbArchivosSalir.setEnabled(false);
        }
        if (campo == 3 || campo == 5) {
            cbMovimientos.setEnabled(false);
        }
        if (campo == 4 || campo == 5) {
            cbMovimientosNuevaFactura.setEnabled(false);
            cbMovimientosReporteFactura.setEnabled(false);
            cbMovimientosInventario.setEnabled(false);
            cbMovimientosAbrirTurno.setEnabled(false);
            cbMovimientosCerrarTurno.setEnabled(false);
            cbMovimientosDeuda.setEnabled(false);
        }
    }

    private void deseleccionarCheck(int campo) {
        if (campo == 1 || campo == 5) {
            cbArchivos.setSelected(false);
        }
        if (campo == 2 || campo == 5) {
            cbArchivosClientes.setSelected(false);
            cbArchivosProductos.setSelected(false);
            cbArchivosUsuarios.setSelected(false);
            cbArchivosCambioClave.setSelected(false);
            cbArchivosCambioUsuario.setSelected(false);
            cbArchivosSalir.setSelected(false);
        }
        if (campo == 3 || campo == 5) {
            cbMovimientos.setSelected(false);
        }
        if (campo == 4 || campo == 5) {
            cbMovimientosNuevaFactura.setSelected(false);
            cbMovimientosReporteFactura.setSelected(false);
            cbMovimientosInventario.setSelected(false);
            cbMovimientosAbrirTurno.setSelected(false);
            cbMovimientosCerrarTurno.setSelected(false);
            cbMovimientosDeuda.setSelected(false);
        }
    }

    private boolean permiso(String valor) {
        return "s".equals(valor);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbArchivos;
    private javax.swing.JCheckBox cbArchivosCambioClave;
    private javax.swing.JCheckBox cbArchivosCambioUsuario;
    private javax.swing.JCheckBox cbArchivosClientes;
    private javax.swing.JCheckBox cbArchivosProductos;
    private javax.swing.JCheckBox cbArchivosSalir;
    private javax.swing.JCheckBox cbArchivosUsuarios;
    private javax.swing.JCheckBox cbMovimientos;
    private javax.swing.JCheckBox cbMovimientosAbrirTurno;
    private javax.swing.JCheckBox cbMovimientosCerrarTurno;
    private javax.swing.JCheckBox cbMovimientosDeuda;
    private javax.swing.JCheckBox cbMovimientosInventario;
    private javax.swing.JCheckBox cbMovimientosNuevaFactura;
    private javax.swing.JCheckBox cbMovimientosReporteFactura;
    private javax.swing.JComboBox cmbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lMensaje;
    private javax.swing.JLabel lNombrePerfil;
    // End of variables declaration//GEN-END:variables
}
