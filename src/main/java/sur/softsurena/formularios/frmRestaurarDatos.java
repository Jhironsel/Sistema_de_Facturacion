package sur.softsurena.formularios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static sur.softsurena.metodos.M_BaseDeDatos.pathBaseDeDatos;
import static sur.softsurena.utilidades.Utilidades.LOG;

public final class frmRestaurarDatos extends javax.swing.JInternalFrame implements Runnable {

    private Thread hilo;
    private boolean procesar = false;
    private Connection cnn = null;

    public frmRestaurarDatos() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBaseActual = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBaseFuente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnProceder = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClave = new javax.swing.JPasswordField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Restauración de Base de Datos...");
        setDoubleBuffered(true);
        setFocusCycleRoot(false);
        setFocusable(false);
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);
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

        txtBaseActual.setEditable(false);
        txtBaseActual.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Base de Datos Actual:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Base de Datos Fuente:");

        txtBaseFuente.setEditable(false);
        txtBaseFuente.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscar.setMnemonic('p');
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("Busca un Producto Por su descripcion o por otras caracteristicas");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnProceder.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnProceder.setMnemonic('p');
        btnProceder.setText("Proceder");
        btnProceder.setToolTipText("Busca un Producto Por su descripcion o por otras caracteristicas");
        btnProceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcederActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setMnemonic('p');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Busca un Producto Por su descripcion o por otras caracteristicas");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuario:");

        txtUsuario.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Contraseña:");

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        txtResultado.setEditable(false);
        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Ubuntu Mono", 0, 12)); // NOI18N
        txtResultado.setRows(5);
        txtResultado.setDoubleBuffered(true);
        jScrollPane2.setViewportView(txtResultado);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnProceder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(0, 0, 0)
                                .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addComponent(btnBuscar))
                            .addComponent(txtBaseActual)
                            .addComponent(txtBaseFuente, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(txtBaseActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtBaseFuente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProceder)
                    .addComponent(btnCancelar))
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JFileChooser miFile = new JFileChooser(System.getProperty("user.dir") + 
                "/Data");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Base de Datos",
                "fdb", "FDB");
        miFile.setFileFilter(filter);
        int respuesta = miFile.showOpenDialog(this);
        if (respuesta == JFileChooser.CANCEL_OPTION) {
            return;
        }
        if (txtBaseActual.getText().equals(miFile.getSelectedFile().getAbsolutePath())) {

            JOptionPane.showInternalMessageDialog(
                    this,
                    "No se debe seleccionar la misma base de datos",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtBaseFuente.setText("");
            return;
        }
        txtBaseFuente.setText(miFile.getSelectedFile().getAbsolutePath());
        txtUsuario.requestFocusInWindow();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnProcederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcederActionPerformed
        if (txtBaseFuente.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Selecione una base de datos",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            btnBuscar.requestFocusInWindow();
            return;
        }
        if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Ingrese el usuario: ",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtUsuario.requestFocusInWindow();
            return;
        }
        if (txtClave.getPassword().length == 0) {
            JOptionPane.showInternalMessageDialog(
                    this, 
                    "Ingrese la clave: ",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtClave.requestFocusInWindow();
            return;
        }

        try {
            Properties props = new Properties();
            props.setProperty("user", txtUsuario.getText());
            props.setProperty("password", new String(txtClave.getPassword()));
            cnn = DriverManager.getConnection("jdbc:firebirdsql://localhost/" + txtBaseActual.getText(), props);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        iniciarHilo();
    }//GEN-LAST:event_btnProcederActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            if (cnn != null) {
                cnn.close();
            }
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnProceder.requestFocusInWindow();
    }//GEN-LAST:event_txtClaveActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        txtBaseActual.setText(pathBaseDeDatos());
        btnBuscar.requestFocusInWindow();
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnProceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBaseActual;
    private javax.swing.JTextField txtBaseFuente;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextArea txtResultado;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        if (procesar) {
            
//            getConsulta(
//                    "SELECT RPAD(COALESCE(p.S_INFORMACION, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO1, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO2, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO3, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO4, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO5, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO6, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO7, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO8, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO9, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO10, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO11, ''), 30)"
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO12, ''), 30) "
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO13, ''), 30) "
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO14, ''), 30) "
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO15, ''), 30) "
//                    + "||'\t'||"
//                    + "RPAD(COALESCE(p.S_CAPO16, ''), 30) "
//                    + "FROM SYSTEM_BACKUP_DATOS ('" + txtBaseFuente.getText()
//                    + "', '" + txtUsuario.getText() + "', '"
//                    + String.valueOf(txtClave.getPassword()) + "') p;")
            
            ResultSet rs = null;
            try {
                while (rs.next()) {
                    txtResultado.append(rs.getString(1).concat("\n"));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        LOG.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                    txtResultado.setCaretPosition(txtResultado.getDocument().getLength());
                }

            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, ex.getMessage(), ex);
            }
            procesar = false;
        }
    }

    public void iniciarHilo() {
        procesar = true;
        hilo = new Thread(this);
        hilo.start();
    }
}
