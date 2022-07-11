package sur.softsurena.formularios;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.datos.procedure.ProcedureMetodos.setLicencia;
import static sur.softsurena.datos.select.SelectMetodos.existeIdMaquina;
import static sur.softsurena.datos.select.SelectMetodos.periodoMaquina;

public final class frmLogin extends javax.swing.JFrame {

    private String idMaquina = "";
    private boolean txtUsuarioKeyPress = true;
    private frmPrincipal principal;

    public frmLogin() {
        
        initComponents();
        btnParametros.setVisible(false);//Boton parametros Invisible
        this.setLocationRelativeTo(null);
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icon.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnParametros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        JLSystema = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login de Sistema Comercial");
        setFocusTraversalPolicyProvider(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(1, 1, 1));
        txtUsuario.setText("Jhironsel");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });

        txtClave.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtClave.setForeground(new java.awt.Color(1, 1, 1));
        txtClave.setText("123uasd");
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnParametros.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnParametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Parametros 32 x 32.png"))); // NOI18N
        btnParametros.setMnemonic(';');
        btnParametros.setText("Opcion de Conexion");
        btnParametros.setToolTipText("Para uso de conexion a la base de Datos Remotamente");
        btnParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametrosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 1, 1));
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 1, 1));
        jLabel2.setText("Clave:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(1, 1, 1));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Panel de Control 128 x 128.png"))); // NOI18N

        JLSystema.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        JLSystema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JLSystema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtClave)
                                    .addComponent(txtUsuario)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnParametros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JLSystema, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParametros))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtClave, txtUsuario});

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            if (getCnn() != null) {
                Conexion.cerrarConexion();
            }
        } catch (Exception e) {

        }
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtClaveActionPerformed
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nombre del Usuario Vacio");
            txtUsuario.requestFocusInWindow();
            return;
        }
        if (txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Inserte una clave");
            txtClave.requestFocusInWindow();
            return;
        }//Fin de validaciones de campos
        
        /*Socket s = new Socket("www.google.com.do", 80);
        if (s.isConnected()) {
        Para verificar si estamos en Internet (Poner Codigo de Abajo 
        Aqui en dado Caso
        }*/

        try {
            if (!existeIdMaquina(idMaquina)) {
                //Ver si la maquina esta Registrada si no esta Entra
                int num = JOptionPane.showConfirmDialog(this,
                        "Este equipo no esta Autorizado! \nDesea Registrar?",
                        "No Autorizado", JOptionPane.YES_NO_OPTION);
                if (num == 0) {
                    registro();
                    return;
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            registro();
            return;
        }

        //Comprobación de los dias restante de la licencia.
        int dia = periodoMaquina();
        if (dia < 1) {
            JOptionPane.showMessageDialog(this, "Licencia expirada...");
            int resp = JOptionPane.showConfirmDialog(this,
                    "Desea registrar el producto",
                    "Auto Registros",
                    JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                registro();
            }
            return;
        }

        if (dia > 1 && dia < 10) {
            JOptionPane.showMessageDialog(this,
                    "Tiempo de version de prueba se acaba en " + dia + " dias.");
        }

        if (!Conexion.getInstance(txtUsuario.getText(),
                new String(txtClave.getPassword()), "None").isConnected()) {
            JOptionPane.showMessageDialog(rootPane, "Usuario o Clave Incorrecto 🤔");
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

        if (principal == null) {
            principal = new frmPrincipal();
        }

        principal.setPerfil(getPerfil(txtUsuario.getText()));
        principal.setIdUsuario(txtUsuario.getText());
        principal.setClave(new String(txtClave.getPassword()));
        principal.menus();
        principal.cerrarFormularios();
        principal.setVisible(true);
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_txtUsuarioActionPerformed
    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered
    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited
    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setForeground(Color.blue);
    }//GEN-LAST:event_btnCancelarMouseEntered
    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited
    private void btnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrosActionPerformed
        frmParametros miParametros = new frmParametros();
        miParametros.setLocationRelativeTo(null);
        miParametros.setVisible(true);
    }//GEN-LAST:event_btnParametrosActionPerformed
    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
            txtUsuarioKeyPress = true;
        } else if (txtUsuarioKeyPress && evt.getKeyCode() == KeyEvent.VK_UP) {
            if (btnParametros.isVisible()) {
                btnParametros.setVisible(false);
            } else {
                btnParametros.setVisible(true);
            }
            txtUsuarioKeyPress = false;
        }//Habilitar y Deshabilitar el boton del Parametros en el formulario Login
    }//GEN-LAST:event_txtUsuarioKeyPressed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sistema = System.getProperty("os.name");
        JLSystema.setText("Usted Se encuentra en OS: " + sistema);
        Process p;
        if (sistema.equals("Linux")) {
            try {
                p = Runtime.getRuntime().exec("lsblk -o UUID /dev/sda1");
            } catch (IOException ex) {
                //Instalar Logger
                return;
            }
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            try {
                stdInput.readLine();
                idMaquina = stdInput.readLine().trim();
            } catch (IOException ex) {
                //Instalar Logger
            }
        } else {
            Scanner sc;
            if (sistema.equals("Windows 7")) {
                try {
                    p = Runtime.getRuntime().exec("C:\\Windows\\System32\\wbem\\wmic csproduct get uuid");
                    sc = new Scanner(p.getInputStream());
                    p.getOutputStream().close();
                } catch (IOException ex) {
                    //Instalar Logger
                    return;
                }
            } else {
                try {
                    p = Runtime.getRuntime().exec("wmic csproduct get uuid");
                    sc = new Scanner(p.getInputStream());
                    p.getOutputStream().close();
                } catch (IOException ex) {
                    //Instalar Logger
                    return;
                }
            }
            System.out.println(sc.nextLine().trim());
            System.out.println(sc.nextLine().trim());
            idMaquina = sc.nextLine().trim();
        }
        System.out.println(idMaquina);
        //btnAceptarActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing
    private void registro() {
        //Implementar logistica para registrar producto en linea
        frmRegistros miRegistros = new frmRegistros(this, true, idMaquina);
        miRegistros.setVisible(true);

        if (miRegistros.txtIdMaquina.getText().equalsIgnoreCase("cancelado")) {
            return;
        }
        
        new String(miRegistros.txtClaveServidor.getPassword());
        
        getMDatos(miRegistros.getClave3().trim());

        setLicencia(miRegistros.getFecha(),
                miRegistros.txtIdMaquina.getText().trim(),
                new String(miRegistros.txtClave1.getPassword()).trim(),
                new String(miRegistros.txtClave2.getPassword()).trim()); //Instalar Logger
        JOptionPane.showMessageDialog(this, "Maquina Registradas");
    }
    
    public static void main(String args[]) {
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            //Instalar Logger
//        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmLogin().setVisible(true);
                new frmLogin().setLocationRelativeTo(null);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLSystema;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnParametros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
