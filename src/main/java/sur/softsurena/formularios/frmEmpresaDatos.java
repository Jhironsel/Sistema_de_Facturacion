package sur.softsurena.formularios;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmEmpresaDatos extends javax.swing.JInternalFrame {
    
    public frmEmpresaDatos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtPorCiento = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTipoEmpresa = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtRNC = new javax.swing.JTextField();
        txtTelefonoEmpresa = new javax.swing.JTextField();
        txtNombreEmpresa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAceptar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();

        setClosable(true);
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

        txtPorCiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPorCiento.setForeground(new java.awt.Color(1, 1, 1));

        txtDireccion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(1, 1, 1));

        txtTipoEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTipoEmpresa.setForeground(new java.awt.Color(1, 1, 1));

        txtCorreo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(1, 1, 1));

        txtRNC.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRNC.setForeground(new java.awt.Color(1, 1, 1));

        txtTelefonoEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtTelefonoEmpresa.setForeground(new java.awt.Color(1, 1, 1));

        txtNombreEmpresa.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombreEmpresa.setForeground(new java.awt.Color(1, 1, 1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Nombre de la Empresa: ");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Telefonos: ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(1, 1, 1));
        jLabel6.setText("Correo Eletronico: ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(1, 1, 1));
        jLabel5.setText("%Ganancina Productos: ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(1, 1, 1));
        jLabel4.setText("Direccion: ");
        jLabel4.setToolTipText("");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setText("RNC : ");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(1, 1, 1));
        jLabel7.setText("Tipo de Empresa: ");

        btnAceptar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptar1.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar1.setMnemonic('a');
        btnAceptar1.setText("Aceptar");
        btnAceptar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptar1MouseExited(evt);
            }
        });
        btnAceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar1.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar1.setMnemonic('c');
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar1)
                        .addGap(95, 95, 95)
                        .addComponent(btnAceptar1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTipoEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRNC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPorCiento, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtNombreEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(txtTelefonoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel6)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtRNC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTipoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtPorCiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar1)
                    .addComponent(btnAceptar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        cargarConfiguracion();
    }//GEN-LAST:event_formInternalFrameOpened

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnAceptar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar1MouseEntered
        btnAceptar1.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptar1MouseEntered

    private void btnAceptar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptar1MouseExited
        btnAceptar1.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptar1MouseExited

    private void btnAceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptar1ActionPerformed
        grabarConfiguracion(txtNombreEmpresa.getText(),
                txtTelefonoEmpresa.getText(),txtCorreo.getText(),
                txtRNC.getText(), txtDireccion.getText(), txtTipoEmpresa.getText(),
                txtPorCiento.getText());
        dispose();
    }//GEN-LAST:event_btnAceptar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombreEmpresa;
    private javax.swing.JTextField txtPorCiento;
    private javax.swing.JTextField txtRNC;
    private javax.swing.JTextField txtTelefonoEmpresa;
    private javax.swing.JTextField txtTipoEmpresa;
    // End of variables declaration//GEN-END:variables
    
    private void cargarConfiguracion() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            if(System.getProperty("os.name").equals("Linux")){
                archivo = new File("/home/"+System.getProperty("user.name")+"/Empresa.ini");
            }else{
                archivo = new File("c:\\Empresa.ini");
            }
            
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.startsWith("Nombre =")) {
                    txtNombreEmpresa.setText(new String(linea.substring(8)));
                }
                if (linea.startsWith("Telefono =")) {
                    txtTelefonoEmpresa.setText(new String(linea.substring(10)));
                }
                if (linea.startsWith("Correo =")) {
                    txtCorreo.setText(new String(linea.substring(8)));
                }
                if (linea.startsWith("RNC =")) {
                    txtRNC.setText(new String(linea.substring(5)));
                }
                if (linea.startsWith("Direccion =")) {
                    txtDireccion.setText(new String(linea.substring(11)));
                }
                if (linea.startsWith("TipoEmpresa =")) {
                    txtTipoEmpresa.setText(new String(linea.substring(13)));
                }
                if (linea.startsWith("PorCiento =")) {
                    txtPorCiento.setText(new String(linea.substring(11)));
                }
                
            }

        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "<Definir error.>", ex);
        } finally {
            try {
                if (fr != null) 
                {
                    fr.close();
                }
            } catch (Exception e2) {
                
            }
        }
    }
    private void grabarConfiguracion(String nombre,
            String Telefono, String Correo, String RNC,
            String Direccion, String TipoEmpresa,
            String PorCiento) {
        
        //TODO Tratar de usar el TRY WITH RESOURCES
//        try (FileWriter fw ; PrintWriter pw = null;){
//            if(System.getProperty("os.name").equals("Linux")){
//                fw = new FileWriter("/home/"+System.getProperty("user.name")+"/Empresa.ini");
//            }else{
//                fw = new FileWriter("c:\\Empresa.ini");
//            }
//            
//            pw = new PrintWriter(fw);
//
//            pw.println("[General]");
//            pw.println("Nombre =" + nombre);
//            pw.println("Telefono =" + Telefono);
//            pw.println("Correo =" + Correo);
//            pw.println("RNC =" + RNC);
//            pw.println("Direccion =" + Direccion);
//            pw.println("TipoEmpresa =" + TipoEmpresa);
//            pw.println("PorCiento =" + PorCiento);
//        } catch (Exception e1) {
//            LOG.log(Level.SEVERE, e1.getMessage(), e1);
//        } finally {
//            try {
//                if (fw != null) {
//                    fw.close();
//                }
//            } catch (Exception e2) {
//                LOG.log(Level.SEVERE, e2.getMessage(), e2);
//            }
//        }
    }
}
