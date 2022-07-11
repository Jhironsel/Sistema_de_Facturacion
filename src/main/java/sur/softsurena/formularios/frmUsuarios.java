package sur.softsurena.formularios;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class frmUsuarios extends javax.swing.JInternalFrame {

    private int usuAct = 0;
    private boolean nuevo = false;

    public frmUsuarios() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnPrimero = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnAdministradorPerfil = new javax.swing.JButton();
        cbAutoriza = new javax.swing.JCheckBox();
        cbEstado = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIDUsuario = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbPerfil = new javax.swing.JComboBox();
        txtClave = new javax.swing.JPasswordField();
        txtConfirmacion = new javax.swing.JPasswordField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTabla = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) { 
                return false; //Las celdas no son editables. 
            }
        };

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Usuarios");
        setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Botones"));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnPrimero.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnPrimero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Anterior 32 x 32.png"))); // NOI18N
        btnPrimero.setMnemonic('p');
        btnPrimero.setText("Primero");
        btnPrimero.setToolTipText("Va al Primer Registro");
        btnPrimero.setMaximumSize(null);
        btnPrimero.setMinimumSize(null);
        btnPrimero.setPreferredSize(null);
        btnPrimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeroActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrimero);

        btnAnterior.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAnterior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flecha Izquierda 32 x 32.png"))); // NOI18N
        btnAnterior.setMnemonic('a');
        btnAnterior.setText("Anterior");
        btnAnterior.setToolTipText("Va al Anterior Registro");
        btnAnterior.setMaximumSize(null);
        btnAnterior.setMinimumSize(null);
        btnAnterior.setPreferredSize(null);
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        jPanel3.add(btnAnterior);

        btnSiguiente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnSiguiente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Flecha Derecha 32 x 32.png"))); // NOI18N
        btnSiguiente.setMnemonic('s');
        btnSiguiente.setText("Siguiente");
        btnSiguiente.setToolTipText("Va al Siguiente Registro");
        btnSiguiente.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnSiguiente.setMaximumSize(null);
        btnSiguiente.setMinimumSize(null);
        btnSiguiente.setPreferredSize(null);
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        jPanel3.add(btnSiguiente);

        btnUltimo.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnUltimo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Siguiente 32 x 32.png"))); // NOI18N
        btnUltimo.setMnemonic('u');
        btnUltimo.setText("Ultimo");
        btnUltimo.setToolTipText("Va al Ultimo Registro");
        btnUltimo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnUltimo.setMaximumSize(null);
        btnUltimo.setMinimumSize(null);
        btnUltimo.setPreferredSize(null);
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        jPanel3.add(btnUltimo);

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

        btnGuardar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.setEnabled(false);
        btnGuardar.setMaximumSize(null);
        btnGuardar.setMinimumSize(null);
        btnGuardar.setPreferredSize(null);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.setEnabled(false);
        btnCancelar.setMaximumSize(null);
        btnCancelar.setMinimumSize(null);
        btnCancelar.setPreferredSize(null);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar);

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setText("* Campos Obligatorios");
        jLabel7.setToolTipText("");

        btnAdministradorPerfil.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAdministradorPerfil.setMnemonic('n');
        btnAdministradorPerfil.setText("Administador de perfiles");
        btnAdministradorPerfil.setToolTipText("Crear un nuevo Registro");
        btnAdministradorPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorPerfilActionPerformed(evt);
            }
        });

        cbAutoriza.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbAutoriza.setText("Autorizar (Ejemplo.: Venta a Credito, Gastos)");
        cbAutoriza.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbAutoriza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAutorizaItemStateChanged(evt);
            }
        });
        cbAutoriza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAutorizaActionPerformed(evt);
            }
        });

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setText("Activo");
        cbEstado.setToolTipText("permite autorizar algunas acciones que requieren un alto nivel...");
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });
        cbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEstadoActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.GridLayout(4, 3, 5, 0));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("*ID Usuario :");
        jPanel5.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("*Nombres :");
        jPanel5.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("*Apellidos:");
        jPanel5.add(jLabel3);

        txtIDUsuario.setEditable(false);
        txtIDUsuario.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtIDUsuario.setToolTipText("");
        txtIDUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDUsuarioActionPerformed(evt);
            }
        });
        jPanel5.add(txtIDUsuario);

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        jPanel5.add(txtNombres);

        txtApellidos.setEditable(false);
        txtApellidos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidosActionPerformed(evt);
            }
        });
        jPanel5.add(txtApellidos);

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setText("*Perfil Usuario:");
        jPanel5.add(jLabel6);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setText("*Clave:");
        jLabel4.setToolTipText("");
        jPanel5.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setText("*Confirmacion:");
        jPanel5.add(jLabel5);

        cmbPerfil.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cmbPerfil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPerfilItemStateChanged(evt);
            }
        });
        cmbPerfil.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbPerfilPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        cmbPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbPerfilMouseClicked(evt);
            }
        });
        jPanel5.add(cmbPerfil);

        txtClave.setEditable(false);
        txtClave.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jPanel5.add(txtClave);

        txtConfirmacion.setEditable(false);
        txtConfirmacion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmacionActionPerformed(evt);
            }
        });
        jPanel5.add(txtConfirmacion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAdministradorPerfil)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbEstado)
                                .addGap(18, 18, 18)
                                .addComponent(cbAutoriza))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnAdministradorPerfil)
                    .addComponent(cbEstado)
                    .addComponent(cbAutoriza))
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(0, 0, 0))
        );

        jScrollPane2.setViewportView(jPanel1);

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
        tblTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMouseClicked(evt);
            }
        });
        tblTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblTablaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblTablaKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tblTabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        if (!tblTabla.isEnabled()) {
            return;
        }
        usuAct = misDatos.numeroUsuarios() - 1;
        mostrarRegistro();
    }//GEN-LAST:event_btnUltimoActionPerformed
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (txtIDUsuario.getText().equals("Jhironsel")) {
            JOptionPane.showMessageDialog(this,
                    "Este usuario es del sistema no puede ser eliminado");
            return;
        }
        int rta = JOptionPane.showConfirmDialog(this,
                "Esta seguro de eliminar Usuario",
                "Confirmacion!!!",
                JOptionPane.YES_NO_OPTION);
        if (rta != 0) {
            return;
        }
        String msg;
        try {
            msg = misDatos.borrarUsuario(txtIDUsuario.getText());
        } catch (Exception ex) {
            msg = "Usuario no fue eliminado porque existen registros en el sistema";
            

        }
        JOptionPane.showMessageDialog(rootPane, msg);
        usuAct = 0;
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnBorrarActionPerformed
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String usuario = JOptionPane.showInputDialog("Ingrese el Codigo de Usuario");
        if (usuario.equals("")) {
            return;
        }
        if (!misDatos.existeUsuario(usuario)) {
            JOptionPane.showMessageDialog(rootPane, "El Usuario No Existe");
            return;
        }
        //Detalle de Factura
        int num = tblTabla.getRowCount();
        for (int i = 0; i < num; i++) {
            if (Utilidades.objectToString(tblTabla.getValueAt(i, 0)).equalsIgnoreCase(usuario)) {
                usuAct = i;
                break;
            }
            if (Utilidades.objectToString(tblTabla.getValueAt(i, 1)).equalsIgnoreCase(usuario)) {
                usuAct = i;
                break;
            }
            if (Utilidades.objectToString(tblTabla.getValueAt(i, 2)).equalsIgnoreCase(usuario)) {
                usuAct = i;
                break;
            }
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnBuscarActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        btnPrimero.setEnabled(true);
        btnAnterior.setEnabled(true);
        btnSiguiente.setEnabled(true);
        btnUltimo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnBorrar.setEnabled(true);
        btnNuevo.setEnabled(true);
        tblTabla.setEnabled(true);
        
        //Botones Para Deshabitar
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        //Caja de Texto Deshabitar
        txtNombres.setEditable(false);
        txtApellidos.setEditable(false);
        txtIDUsuario.setEditable(false);
        txtClave.setEditable(false);
        txtConfirmacion.setEditable(false);

        mostrarRegistro();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        int resp = JOptionPane.showConfirmDialog(this,
                "Antes de crear un Usuario deberia tener un perfil Listo "
                + "\nDesea crear un Perfil?",
                "Creando Usuario!!!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (resp == 0) {
            btnAdministradorPerfilActionPerformed(evt);
            return;
        }

        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);
        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        //Caja de Texto Habilitado
        txtIDUsuario.setEditable(true);
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtClave.setEditable(true);
        txtConfirmacion.setEditable(true);
        

        //txt llenar en Blanco
        txtIDUsuario.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtClave.setText("");
        txtConfirmacion.setText("");
        cbAutoriza.setSelected(false);
        cbEstado.setSelected(false);
        cmbPerfil.setSelectedIndex(0);
        //Activamos el Flag de registro Nuevo        
        nuevo = true;
        txtIDUsuario.requestFocusInWindow();
    }//GEN-LAST:event_btnNuevoActionPerformed
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //Validaciones
        String clave = new String(txtClave.getPassword()),
                Confirmacion = new String(txtConfirmacion.getPassword());
        if (txtIDUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un ID");
            txtIDUsuario.requestFocusInWindow();
            return;
        }
        if (txtNombres.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Nombre");
            txtNombres.requestFocusInWindow();
            return;
        }
        if (txtApellidos.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Digitar un Apellido");
            txtApellidos.requestFocusInWindow();
            return;
        }

        if (clave.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Ingresar Clave...");
            txtClave.requestFocusInWindow();
            return;
        }
        if (Confirmacion.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe Ingresar Confirmacion");
            txtConfirmacion.requestFocusInWindow();
            return;
        }
        if (!clave.equals(Confirmacion)) {
            JOptionPane.showMessageDialog(rootPane, "Claves NO Coinciden...");
            txtConfirmacion.setText("");
            txtClave.setText("");
            txtClave.requestFocusInWindow();
            return;
        }
        String autorizar = "n", estado = "0";

        if (cbAutoriza.isSelected()) {
            autorizar = "s";
        }

        if (cbEstado.isSelected()) {
            estado = "1";
        }

        String accion = "editar";
        if (nuevo) {
            accion = "crear";
        }
        int resp = JOptionPane.showConfirmDialog(this,
                "<html><b><big>Se va a " + accion + " el Usuario: </big></b><big>" 
                        + txtIDUsuario.getText() + "</big></html>"
                + "\n<html><b><big>Con Nombre y Apellido: </big></b><big>" 
                        + txtNombres.getText() + " " + txtApellidos.getText() + "</big></html>"
                + "\n<html><b><big>Con el Perfil de: </big></b><big>" 
                        + ((Opcion) cmbPerfil.getSelectedItem()).getDescripcion() + "</big></html>"
                + "\n<html><b><big>Privilegio de autorizacion estan: </big></b><big>" 
                        + (autorizar.equals("s") ? "Activado" : "NO Activado") + "</big></html>"
                + "\n<html><b><big>Estado del Usuario: </big></b><big>" 
                        + (estado.equals("1") ? "Activo" : "No Activo") + "</big></html>"
                + "\n<html><b><big>Desea continuar? </big></b></html>",
                "Confirmacion de Usuario",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resp == 1) {
            return;
        }
        // Si es nuevo validamos que el usuario no exista
        if (nuevo) {
            if (misDatos.existeUsuario(txtIDUsuario.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Usario Ya existe...");
                txtClave.setText("");
                txtConfirmacion.setText("");
                txtClave.requestFocusInWindow();
                return;
            }
        }

        //Creamos el Objeto Usuario y los agregamos a Datos
        Usuario miUsuario = new Usuario(
                txtIDUsuario.getText(),
                txtNombres.getText(),
                txtApellidos.getText(),
                clave,
                Integer.parseInt(((Opcion) cmbPerfil.getSelectedItem()).getValor()),
                estado, autorizar);
        
        String msg;
        if (nuevo) {
            msg = misDatos.agregarUsuario(miUsuario);
        } else {
            msg = misDatos.modificarUsuario(miUsuario);
        }
        JOptionPane.showMessageDialog(rootPane, msg);
        //Actualizamos los cambios en la Tabla
        llenarTabla();
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtIDUsuario.getText().equals("Jhironsel")) {
            JOptionPane.showMessageDialog(this,
                    "Este usuario es del sistema no puede ser editado");
            return;
        }
        //Botones Para Deshabilitar:
        btnPrimero.setEnabled(false);
        btnAnterior.setEnabled(false);
        btnSiguiente.setEnabled(false);
        btnUltimo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnBorrar.setEnabled(false);
        btnNuevo.setEnabled(false);
        tblTabla.setEnabled(false);
        //Botones Para Habilitar
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        //Caja de Texto Habilitado
        txtNombres.setEditable(true);
        txtApellidos.setEditable(true);
        txtClave.setEditable(true);
        txtConfirmacion.setEditable(true);
        
        //Desactivamos el Flag de registro Nuevo        
        nuevo = false;

        txtNombres.requestFocusInWindow();
    }//GEN-LAST:event_btnModificarActionPerformed
    private void txtIDUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDUsuarioActionPerformed
        txtNombres.requestFocusInWindow();
    }//GEN-LAST:event_txtIDUsuarioActionPerformed
    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if (!tblTabla.isEnabled()) {
            return;
        }
        usuAct--;
        if (usuAct == -1) {
            usuAct = misDatos.numeroUsuarios() - 1;
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnAnteriorActionPerformed
    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        txtConfirmacion.requestFocusInWindow();
    }//GEN-LAST:event_txtClaveActionPerformed
    private void txtConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmacionActionPerformed
        btnGuardarActionPerformed(evt);
    }//GEN-LAST:event_txtConfirmacionActionPerformed
    private void btnPrimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeroActionPerformed
        if (!tblTabla.isEnabled()) {
            return;
        }
        usuAct = 0;
        mostrarRegistro();
    }//GEN-LAST:event_btnPrimeroActionPerformed
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        if (!tblTabla.isEnabled()) {
            return;
        }
        usuAct++;
        if (usuAct == misDatos.numeroUsuarios()) {
            usuAct = 0;
        }
        mostrarRegistro();
    }//GEN-LAST:event_btnSiguienteActionPerformed
    private void tblTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMouseClicked
        if (!tblTabla.isEnabled()) {
            return;
        }
        usuAct = tblTabla.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaMouseClicked
    private void tblTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyPressed
        usuAct = tblTabla.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaKeyPressed
    private void tblTablaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblTablaKeyReleased
        usuAct = tblTabla.getSelectedRow();
        mostrarRegistro();
    }//GEN-LAST:event_tblTablaKeyReleased
    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtNombresActionPerformed
    private void txtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidosActionPerformed
        cmbPerfil.requestFocusInWindow();
    }//GEN-LAST:event_txtApellidosActionPerformed
    private void cmbPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbPerfilMouseClicked
        if (!txtNombres.isEditable()) {
            return;
        }
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_cmbPerfilMouseClicked
    private void cmbPerfilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPerfilItemStateChanged
        if (!txtNombres.isEditable()) {
            return;
        }
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_cmbPerfilItemStateChanged
    private void btnAdministradorPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorPerfilActionPerformed
        frmPerfiles miPerfil = new frmPerfiles(null, true);
        miPerfil.setMisDatos(misDatos);
        miPerfil.setPosItem(cmbPerfil.getSelectedIndex());
        miPerfil.setLocationRelativeTo(null);
        miPerfil.setVisible(true);
        llenarCombo();
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_btnAdministradorPerfilActionPerformed
    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        llenarCombo();
        llenarTabla();
        mostrarRegistro();
    }//GEN-LAST:event_formInternalFrameActivated
    private void cmbPerfilPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbPerfilPopupMenuWillBecomeInvisible
        if (!txtNombres.isEditable()) {
            for (int i = 0; i < cmbPerfil.getItemCount(); i++) {
                if (Utilidades.objectToString(
                        tblTabla.getValueAt(
                                tblTabla.getSelectedRow(), 3)).equals(
                                        ((Opcion) cmbPerfil.getItemAt(i)).getDescripcion())) {
                    cmbPerfil.setSelectedIndex(i);
                    break;
                }
            }
        }
    }//GEN-LAST:event_cmbPerfilPopupMenuWillBecomeInvisible

    private void cbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEstadoActionPerformed
        if(!txtNombres.isEditable()){
            cbEstado.setSelected(!cbEstado.isSelected());
            return;
        }
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoActionPerformed

    private void cbAutorizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAutorizaActionPerformed
        if(!txtNombres.isEditable()){
            cbAutoriza.setSelected(!cbAutoriza.isSelected());
            return;
        }
        if (cbAutoriza.isSelected()) {
            cbAutoriza.setText("Autorizar (Ejemplo.: Venta a Credito, Gastos)");
        } else {
            cbAutoriza.setText("No Autorizar (Ejemplo.: Venta a Credito, Gastos)");
        }
    }//GEN-LAST:event_cbAutorizaActionPerformed

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoItemStateChanged

    private void cbAutorizaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAutorizaItemStateChanged
        if (cbAutoriza.isSelected()) {
            cbAutoriza.setText("Autorizar (Ejemplo.: Venta a Credito, Gastos)");
        } else {
            cbAutoriza.setText("No Autorizar (Ejemplo.: Venta a Credito, Gastos)");
        }
    }//GEN-LAST:event_cbAutorizaItemStateChanged
    private void llenarCombo() {
        cmbPerfil.removeAllItems();
        Opcion opc;
        ResultSet rs = getConsulta("select idPerfil, descripcion from Tabla_T_Perfil order by 1");
        try {
            while (rs.next()) {
                opc = new Opcion(rs.getString("IdPerfil"), rs.getString("descripcion"));
                cmbPerfil.addItem(opc);
            }
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }

    private void mostrarRegistro() {
        txtIDUsuario.setText(Utilidades.objectToString(tblTabla.getValueAt(
                usuAct, 0)));
        txtNombres.setText(Utilidades.objectToString(tblTabla.getValueAt(
                usuAct, 1)));
        txtApellidos.setText(Utilidades.objectToString(tblTabla.getValueAt(
                usuAct, 2)));

        int num = 0;

        while (true) {
            if (cmbPerfil.getItemAt(num).toString().equals(
                    tblTabla.getValueAt(usuAct, 3).toString())) {
                break;
            }
            num++;
        }
        ResultSet rs = misDatos.getConsulta(
                "select estado, clave, Autorizar from USUARIO where idUsuario like '"
                + txtIDUsuario.getText()
                + "' and borrado like 'n' order by 1");
        try {
            rs.next();
            
            cbAutoriza.setSelected(dime(rs.getString("Autorizar")));
            cbEstado.setSelected(dime(rs.getInt("estado")));
            txtClave.setText(rs.getString("clave"));
            txtConfirmacion.setText(rs.getString("clave"));
            
        } catch (SQLException ex) {
            //Instalar Logger
        }

        cmbPerfil.setSelectedIndex(num);
        tblTabla.setRowSelectionInterval(usuAct, usuAct);
    }

    private boolean dime(int num) {
        return num == 1;
    }
    
    private boolean dime(String dato){
        return "s".equals(dato);
    }

    private void llenarTabla() {
        try {
            String titulos[] = {"ID Usuario", "Nombres", "Apellidos", "Perfil"};
            Object registro[] = new Object[5];
            DefaultTableModel miTabla = new DefaultTableModel(null, titulos);
            ResultSet rs = misDatos.getUsuarios();
            while (rs.next()) {
                if (rs.getString("borrado").equals("s")) {
                    continue;
                }
                registro[0] = rs.getString("idUsuario");
                registro[1] = rs.getString("nombres");
                registro[2] = rs.getString("apellidos");
                registro[3] = rs.getString("perfilDescripcion");
                miTabla.addRow(registro);
            }
            tblTabla.setModel(miTabla);
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministradorPerfil;
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    protected javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPrimero;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JCheckBox cbAutoriza;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JComboBox cmbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblTabla;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtConfirmacion;
    private javax.swing.JTextField txtIDUsuario;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
