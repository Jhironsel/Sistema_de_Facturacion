package sur.softsurena.formularios;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sur.softsurena.FirebirdEventos.FirebirdEventos;
import sur.softsurena.conexion.Conexion;
import static sur.softsurena.entidades.BaseDeDatos.existeIdMaquina;
import static sur.softsurena.entidades.BaseDeDatos.periodoMaquina;
import static sur.softsurena.entidades.BaseDeDatos.setLicencia;
import static sur.softsurena.entidades.Usuarios.comprobandoRol;
import sur.softsurena.metodos.Imagenes;

public final class frmLogin extends javax.swing.JFrame {

    private String idMaquina = "";
    private boolean txtUsuarioKeyPress = true;

    public frmLogin() {
        initComponents();

        cargarIconos();

        btnParametros.setVisible(false);//Boton parametros Invisible

        this.setLocationRelativeTo(null);
    }

    public frmLogin(String user, String clave) {
        initComponents();
        txtUsuario.setText(user);
        txtClave.setText(clave);
        btnAceptar.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lamina = new RSMaterialComponent.RSPanelMaterialImage();
        JLSystema = new javax.swing.JLabel();
        jlLogoSistema = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelIcon1 = new necesario.LabelIcon();
        txtUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        labelIcon2 = new necesario.LabelIcon();
        txtClave = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnParametros = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de Sistema Comercial");
        setFocusTraversalPolicyProvider(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JLSystema.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        JLSystema.setForeground(new java.awt.Color(255, 255, 255));
        JLSystema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jlLogoSistema.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlLogoSistema.setForeground(new java.awt.Color(1, 1, 1));
        jlLogoSistema.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogoSistema.setMaximumSize(new java.awt.Dimension(128, 128));
        jlLogoSistema.setMinimumSize(new java.awt.Dimension(128, 128));
        jlLogoSistema.setPreferredSize(new java.awt.Dimension(128, 128));

        jpDatos.setBackground(new java.awt.Color(255, 153, 255));
        jpDatos.setOpaque(false);
        jpDatos.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        labelIcon1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelIcon1.setOpaque(true);

        txtUsuario.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(51, 51, 255));
        txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtUsuario.setName("txtUsuario"); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsuario)))
        );

        jpDatos.add(jPanel2);

        labelIcon2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        labelIcon2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        labelIcon2.setOpaque(true);

        txtClave.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        txtClave.setForeground(new java.awt.Color(51, 51, 255));
        txtClave.setName("txtClave"); // NOI18N
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labelIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtClave, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelIcon2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
            .addComponent(txtClave)
        );

        jpDatos.add(jPanel3);

        jPanel1.setMaximumSize(new java.awt.Dimension(216, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 40));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        btnCancelar.setBackground(new java.awt.Color(204, 0, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);

        btnAceptar.setText("Aceptar");
        btnAceptar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnAceptar.setMaximumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setMinimumSize(new java.awt.Dimension(216, 40));
        btnAceptar.setName("btnAceptar"); // NOI18N
        btnAceptar.setPreferredSize(new java.awt.Dimension(216, 40));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar);

        jpDatos.add(jPanel1);

        btnParametros.setBackground(new java.awt.Color(0, 204, 51));
        btnParametros.setText("Opcion de conexion");
        btnParametros.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);
        btnParametros.setMaximumSize(new java.awt.Dimension(216, 40));
        btnParametros.setMinimumSize(new java.awt.Dimension(216, 40));
        btnParametros.setName("btnParametros"); // NOI18N
        btnParametros.setPreferredSize(new java.awt.Dimension(216, 40));
        btnParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametrosActionPerformed(evt);
            }
        });
        jpDatos.add(btnParametros);

        javax.swing.GroupLayout laminaLayout = new javax.swing.GroupLayout(lamina);
        lamina.setLayout(laminaLayout);
        laminaLayout.setHorizontalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laminaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLSystema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlLogoSistema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        laminaLayout.setVerticalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLSystema, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lamina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sistema = System.getProperty("os.name");
        JLSystema.setText("Usted se encuentra en el SO: " + sistema);

        Process p;

        if (sistema.equals("Linux")) {
            try {
                /*Buscando nuevas alternativas sin root*/
 /*ls /dev/disk/by-uuid/ : Podemos ontener el valor del primer resultado.*/
 /*lsblk -o name,uuid: Otro que podemos filtrar por el disco duro.*/

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
                    /*Aun funciona 25 de julio 2022*/
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
    }//GEN-LAST:event_formWindowOpened
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

        //Validación de campos del login. 
        if (txtUsuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre del Usuario Vacio");
            txtUsuario.requestFocusInWindow();
            return;
        }

        if (txtClave.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Inserte una clave");
            txtClave.requestFocusInWindow();
            return;
        }//Fin de validaciones de campos

        //Cargar los valores de la conexion desde el properties
        frmParametros p = new frmParametros();
        String dominio = "localhost", puerto = "3050";

        if (p.cargarParamentos("").getConIpServidor()) {
            dominio = p.cargarParamentos("").getIpServidor1() + "."
                    + p.cargarParamentos("").getIpServidor2() + "."
                    + p.cargarParamentos("").getIpServidor3() + "."
                    + p.cargarParamentos("").getIpServidor4();
        }

        if (p.cargarParamentos("").getConServidor()) {
            dominio = p.cargarParamentos("").getUriServidor();
        }

        if (p.cargarParamentos("").getConPuerto()) {
            puerto = p.cargarParamentos("").getPuerto();
        }

        Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()),
                "None",
                p.cargarParamentos("").getPathBaseDatos(),
                dominio,
                puerto);

        if (!Conexion.verificar()) {
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }

        //Variables para almacenar los roles
        ArrayList<String> roles = comprobandoRol(txtUsuario.getText().trim());

        if (roles == null) {
            JOptionPane.showMessageDialog(null, "El usuario no cuenta con rol en el sistema");
            return;
        }

        JComboBox<String> comboBox = new JComboBox(roles.toArray());
        comboBox.setName("jcbRoles");

        if (roles.size() > 1) {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    comboBox,
                    "Seleccione un rol",
                    JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.NO_OPTION) {
                return;
            }
        }

        String rol = comboBox.getSelectedItem().toString();

        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }

        Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()),
                rol,
                p.cargarParamentos("").getPathBaseDatos(),
                dominio,
                puerto);

        if (!Conexion.verificar()) {
            return;
        }

        FirebirdEventos f = new FirebirdEventos();

        if (!f.registro(txtUsuario.getText(), new String(txtClave.getPassword()),
                dominio, p.cargarParamentos("").getPathBaseDatos(), Integer.parseInt(puerto))) {
            JOptionPane.showMessageDialog(null,
                    "Error a registrar los eventos...",
                    "Validación de procesos", JOptionPane.ERROR_MESSAGE);
            return;
        }
        txtClave.setText("");

        //Reconectarse con el rol seleccionado por el usuario. 
        if (!existeIdMaquina(idMaquina)) {
            //Ver si la maquina esta Registrada si no esta Entra
            int num = JOptionPane.showConfirmDialog(null,
                    "Este equipo no esta Autorizado! \nDesea Registrar?",
                    "No Autorizado", JOptionPane.YES_NO_OPTION);
            if (num == 0) {
                registro();
                return;
            } else {
                return;
            }
        }

        //Comprobación de los dias restante de la licencia.
        int dia = periodoMaquina();
        if (dia < 1) {
            JOptionPane.showMessageDialog(null, "Licencia expirada...");
            int resp = JOptionPane.showConfirmDialog(null,
                    "Desea registrar el producto",
                    "Auto Registros",
                    JOptionPane.YES_NO_OPTION);
            if (resp == 0) {
                registro();
            }
            return;
        }

        if (dia > 1 && dia < 10) {
            JOptionPane.showMessageDialog(null,
                    "Tiempo de version de prueba se acaba en " + dia + " dias.");
        }

        //Blanquear la pass
        txtClave.setText("");

        frmPrincipal principal = new frmPrincipal();
        principal.setVisible(true);
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);

        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrosActionPerformed
        frmParametros miParametros = new frmParametros();
        miParametros.setLocationRelativeTo(null);
        miParametros.setVisible(true);
    }//GEN-LAST:event_btnParametrosActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_CONTROL) {
            txtUsuarioKeyPress = true;
        } else if (txtUsuarioKeyPress && evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (btnParametros.isVisible()) {
                btnParametros.setVisible(false);
            } else {
                btnParametros.setVisible(true);
            }
            txtUsuarioKeyPress = false;
        }//Habilitar y Deshabilitar el boton del Parametros en el formulario Login
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtClaveActionPerformed

    private void registro() {
        //Implementar logistica para registrar producto en linea
        frmRegistros miRegistros = new frmRegistros(this, true, idMaquina);
        miRegistros.setVisible(true);

        if (miRegistros.txtIdMaquina.getText().equalsIgnoreCase("cancelado")) {
            return;
        }

        String claveServidor = new String(miRegistros.txtClaveServidor.getPassword());

        Conexion.getInstance("None", "SYSDBA", claveServidor, "", "", "");

        if (setLicencia(new Date(miRegistros.dchFecha.getDate().getTime()),
                miRegistros.txtIdMaquina.getText().trim(),
                new String(miRegistros.txtClave1.getPassword()).trim(),
                new String(miRegistros.txtClave2.getPassword()).trim())) {
            JOptionPane.showMessageDialog(null, "Maquina Registradas");
        }

        miRegistros.dispose();

    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                frmLogin frmLogin = new frmLogin();
                frmLogin.setVisible(true);
                frmLogin.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLSystema;
    private RSMaterialComponent.RSButtonMaterialIconOne btnAceptar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnParametros;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jlLogoSistema;
    private javax.swing.JPanel jpDatos;
    private necesario.LabelIcon labelIcon1;
    private necesario.LabelIcon labelIcon2;
    private RSMaterialComponent.RSPanelMaterialImage lamina;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void cargarIconos() {
        Imagenes imagen = new Imagenes();
        jlLogoSistema.setIcon(imagen.getIcono("Panel de Control 128 x 128.png"));
        lamina.setImagen(imagen.getIcono("FondoLogin 626 x 386.jpg"));
    }
}
