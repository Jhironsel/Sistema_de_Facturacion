package sur.softsurena.formularios;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmParametros extends javax.swing.JFrame {

    private final Properties propiedades;
    private File f = null;

    public frmParametros() {
        initComponents();
        propiedades = new Properties();
        
        try {
            f = new File(getClass().getResource(
                    "/sur/softsurena/properties/propiedades.properties").toURI());
            propiedades.load(new FileReader(f));
            
        } catch (URISyntaxException ex) {
            Logger.getLogger(frmParametros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            //Instalar Logger
        } catch (IOException ex) {
            //Instalar Logger
        }
        
        cargarParamentos("todo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtValor2 = new javax.swing.JTextField();
        txtValor3 = new javax.swing.JTextField();
        txtValor4 = new javax.swing.JTextField();
        txtValor1 = new javax.swing.JTextField();
        txtPuerto = new javax.swing.JTextField();
        txthost = new javax.swing.JTextField();
        chBPuerto = new javax.swing.JCheckBox();
        rbtnProtocoloIPV4 = new javax.swing.JRadioButton();
        rbtnNombreServidor = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Parametros del Sistema");
        setAlwaysOnTop(true);
        setSize(new java.awt.Dimension(439, 210));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setLayout(new java.awt.GridLayout(1, 4, 20, 0));

        txtValor2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtValor2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor2.setEnabled(false);
        txtValor2.setMinimumSize(new java.awt.Dimension(100, 25));
        txtValor2.setPreferredSize(new java.awt.Dimension(100, 25));
        txtValor2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor2KeyTyped(evt);
            }
        });
        jPanel2.add(txtValor2);

        txtValor3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtValor3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor3.setEnabled(false);
        txtValor3.setMinimumSize(new java.awt.Dimension(100, 25));
        txtValor3.setPreferredSize(new java.awt.Dimension(100, 25));
        txtValor3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor3KeyTyped(evt);
            }
        });
        jPanel2.add(txtValor3);

        txtValor4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtValor4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor4.setEnabled(false);
        txtValor4.setMinimumSize(new java.awt.Dimension(100, 25));
        txtValor4.setPreferredSize(new java.awt.Dimension(100, 25));
        txtValor4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor4KeyTyped(evt);
            }
        });
        jPanel2.add(txtValor4);

        txtValor1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtValor1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor1.setEnabled(false);
        txtValor1.setMinimumSize(new java.awt.Dimension(100, 25));
        txtValor1.setPreferredSize(new java.awt.Dimension(100, 25));
        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValor1KeyTyped(evt);
            }
        });
        jPanel2.add(txtValor1);

        txtPuerto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPuerto.setToolTipText("");
        txtPuerto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPuertoKeyReleased(evt);
            }
        });

        txthost.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txthost.setEnabled(false);

        chBPuerto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        chBPuerto.setText("Puerto: ");
        chBPuerto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chBPuertoMouseClicked(evt);
            }
        });
        chBPuerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chBPuertoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnProtocoloIPV4);
        rbtnProtocoloIPV4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtnProtocoloIPV4.setText("Protocolo IPV4");
        rbtnProtocoloIPV4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnProtocoloIPV4MouseClicked(evt);
            }
        });
        rbtnProtocoloIPV4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnProtocoloIPV4ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtnNombreServidor);
        rbtnNombreServidor.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        rbtnNombreServidor.setText("URI Servidor");
        rbtnNombreServidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtnNombreServidorMouseClicked(evt);
            }
        });
        rbtnNombreServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnNombreServidorActionPerformed(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(216, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 40));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 5, 5));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthost)
                    .addComponent(rbtnNombreServidor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rbtnProtocoloIPV4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtPuerto)
                    .addComponent(chBPuerto, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbtnNombreServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(chBPuerto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rbtnProtocoloIPV4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtPuerto, txthost});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbtnNombreServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnNombreServidorActionPerformed
        valoresEstados(false);
        txtValor1.setText("");
        txtValor2.setText("");
        txtValor3.setText("");
        txtValor4.setText("");
    }//GEN-LAST:event_rbtnNombreServidorActionPerformed

    private void rbtnProtocoloIPV4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnProtocoloIPV4ActionPerformed
        valoresEstados(true);
        txthost.setText("");
    }//GEN-LAST:event_rbtnProtocoloIPV4ActionPerformed
    private void txtValor4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor4KeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtValor4.transferFocus();
        }
    }//GEN-LAST:event_txtValor4KeyTyped
    private void txtValor3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor3KeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!", "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtValor3.transferFocus();
        }
    }//GEN-LAST:event_txtValor3KeyTyped
    private void txtValor2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor2KeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtValor2.transferFocus();
        }
    }//GEN-LAST:event_txtValor2KeyTyped
    private void txtValor1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor1KeyTyped
        int k = (int) evt.getKeyChar();
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 241 || k == 209) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
            JOptionPane.showMessageDialog(null, "No puede ingresar letras!!!",
                    "Ventana Error Datos", JOptionPane.ERROR_MESSAGE);
        }
        if (k == 10) {
            txtValor1.transferFocus();
        }
    }//GEN-LAST:event_txtValor1KeyTyped
    private void txtPuertoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPuertoKeyReleased
        char caracter = evt.getKeyChar();
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtPuertoKeyReleased

    private void rbtnNombreServidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnNombreServidorMouseClicked
        cargarParamentos("nombre");
    }//GEN-LAST:event_rbtnNombreServidorMouseClicked

    private void rbtnProtocoloIPV4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtnProtocoloIPV4MouseClicked
        cargarParamentos("ipv4");
    }//GEN-LAST:event_rbtnProtocoloIPV4MouseClicked

    private void chBPuertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chBPuertoMouseClicked
//        cargarParamentos("puerto");
    }//GEN-LAST:event_chBPuertoMouseClicked

    private void chBPuertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chBPuertoActionPerformed
        cargarParamentos("puerto");
    }//GEN-LAST:event_chBPuertoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (rbtnProtocoloIPV4.isSelected()) {
            int valor;
            try {
                valor = Integer.parseInt(txtValor1.getText());
            } catch (NumberFormatException e) {
                valor = -1;
            }

            if (valor < 0 || valor > 255) {
                JOptionPane.showMessageDialog(rootPane, "Valor incorrecto en el Ambito 1");
                txtValor1.setText("");
                txtValor1.requestFocusInWindow();
                return;
            }

            try {
                valor = Integer.parseInt(txtValor2.getText());
            } catch (NumberFormatException e) {
                valor = -1;
            }
            if (valor < 0 || valor > 255) {
                JOptionPane.showMessageDialog(rootPane, "Valor incorrecto en el Ambito 2");
                txtValor2.setText("");
                txtValor2.requestFocusInWindow();
                return;
            }

            try {
                valor = Integer.parseInt(txtValor3.getText());
            } catch (NumberFormatException e) {
                valor = -1;
            }
            if (valor < 0 || valor > 255) {
                JOptionPane.showMessageDialog(rootPane, "Valor incorrecto en el Ambito 3");
                txtValor3.setText("");
                txtValor3.requestFocusInWindow();
                return;
            }

            try {
                valor = Integer.parseInt(txtValor4.getText());
            } catch (NumberFormatException e) {
                valor = -1;
            }
            if (valor < 0 || valor > 255) {
                JOptionPane.showMessageDialog(rootPane, "Valor incorrecto en el Ambito 4");
                txtValor4.setText("");
                txtValor4.requestFocusInWindow();
                return;
            }
        }

        if (rbtnNombreServidor.isSelected()) {
            if (txthost.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nombre del servidor vacio");
                txthost.requestFocusInWindow();
                return;
            }
        }

        if (chBPuerto.isSelected()) {
            int valor;
            try {
                valor = Integer.parseInt(txtPuerto.getText());
            } catch (NumberFormatException e) {
                valor = -1;
            }
            if (valor < 0 || valor > 65535) {
                JOptionPane.showMessageDialog(rootPane, "Este Puerto no es valido");
                txtPuerto.setText("");
                txtPuerto.requestFocusInWindow();
                return;
            }
        }

        escribirParametros();
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void valoresEstados(boolean estado) {
        txtValor1.setEnabled(estado);
        txtValor2.setEnabled(estado);
        txtValor3.setEnabled(estado);
        txtValor4.setEnabled(estado);
        txthost.setEnabled(!estado);
        if(estado){
            txtValor1.requestFocusInWindow();
        }else{
            txthost.requestFocusInWindow();
        }
    }

    private void cargarParamentos(String zona) {
        if (zona.equals("todo") || zona.equals("puerto")) {
            if (Boolean.valueOf(propiedades.getProperty("Con_Puerto", "false"))) {
                if (zona.equals("todo")) {
                    txtPuerto.setText(propiedades.getProperty("Puerto_del_Servidor", ""));
                    chBPuerto.doClick();
                }

                if (zona.equals("puerto")) {
                    if (chBPuerto.isSelected()) {
                        txtPuerto.setEnabled(true);
                        if(Boolean.valueOf(propiedades.getProperty("Con_Puerto", "false"))){
                            txtPuerto.setText(propiedades.getProperty("Puerto_del_Servidor", ""));
                        }
                        txtPuerto.requestFocusInWindow();
                    } else {
                        txtPuerto.setEnabled(false);
                        txtPuerto.setText("");
                    }
                }
            } else {
                if (chBPuerto.isSelected()) {
                    txtPuerto.setEnabled(true);
                    txtPuerto.requestFocusInWindow();
                } else {
                    txtPuerto.setEnabled(false);
                    txtPuerto.setText("");
                }
            }
        }

        if (zona.equals("todo") || zona.equals("ipv4")) {
            if (Boolean.valueOf(propiedades.getProperty("ProtocoloActivo", "false"))) {
                txtValor1.setText(propiedades.getProperty("Ip_Servidor1", ""));
                txtValor2.setText(propiedades.getProperty("Ip_Servidor2", ""));
                txtValor3.setText(propiedades.getProperty("Ip_Servidor3", ""));
                txtValor4.setText(propiedades.getProperty("Ip_Servidor4", ""));
                rbtnProtocoloIPV4.doClick();
            }
        }

        if (zona.equals("todo") || zona.equals("nombre")) {
            if (Boolean.valueOf(propiedades.getProperty("NombreActivo", "false"))) {
                txthost.setText(propiedades.getProperty("Nombre_del_Servidor", ""));
                rbtnNombreServidor.doClick();
            }
        }
    }

    private void escribirParametros() {
        propiedades.setProperty("Ip_Servidor1", txtValor1.getText());
        propiedades.setProperty("Ip_Servidor2", txtValor2.getText());
        propiedades.setProperty("Ip_Servidor3", txtValor3.getText());
        propiedades.setProperty("Ip_Servidor4", txtValor4.getText());
        propiedades.setProperty("ProtocoloActivo", "" + rbtnProtocoloIPV4.isSelected());
        propiedades.setProperty("NombreActivo", "" + rbtnNombreServidor.isSelected());
        propiedades.setProperty("Nombre_del_Servidor", txthost.getText());
        propiedades.setProperty("Puerto_del_Servidor", txtPuerto.getText());
        propiedades.setProperty("Con_Puerto", "" + chBPuerto.isSelected());

        try {
            
            
            propiedades.store(
                    new FileWriter(f),
                    "Parametros del Servidor");
        } catch (IOException ex) {
            Logger.getLogger(frmParametros.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chBPuerto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rbtnNombreServidor;
    private javax.swing.JRadioButton rbtnProtocoloIPV4;
    private javax.swing.JTextField txtPuerto;
    private javax.swing.JTextField txtValor1;
    private javax.swing.JTextField txtValor2;
    private javax.swing.JTextField txtValor3;
    private javax.swing.JTextField txtValor4;
    private javax.swing.JTextField txthost;
    // End of variables declaration//GEN-END:variables
}
