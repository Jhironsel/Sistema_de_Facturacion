package sur.softsurena.formularios;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sur.softsurena.FirebirdEventos.FirebirdEventos;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.formularios.*;
import static sur.softsurena.conexion.Conexion.getCnn;
import static sur.softsurena.datos.procedure.ProcedureMetodos.setLicencia;
import static sur.softsurena.datos.select.SelectMetodos.comprobandoRol;
import static sur.softsurena.datos.select.SelectMetodos.existeIdMaquina;
import static sur.softsurena.datos.select.SelectMetodos.periodoMaquina;

public final class frmLogin extends javax.swing.JFrame {

    private static final Logger LOG = Logger.getLogger(frmLogin.class.getName());
    private String idMaquina = "";
    private boolean txtUsuarioKeyPress = true;
    private frmPrincipal principal;
    public frmLogin() {
        initComponents();

        cargarIconos();

        btnParametros.setVisible(false);//Boton parametros Invisible

        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lamina = new RSMaterialComponent.RSPanelMaterialImage();
        JLSystema = new javax.swing.JLabel();
        jlLogoSistema = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        txtUsuario = new RSMaterialComponent.RSTextFieldIconOne();
        txtClave = new RSMaterialComponent.RSPasswordIconOne();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnAceptar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnParametros = new RSMaterialComponent.RSButtonMaterialIconOne();

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

        txtUsuario.setMaximumSize(new java.awt.Dimension(216, 40));
        txtUsuario.setMinimumSize(new java.awt.Dimension(216, 40));
        txtUsuario.setPlaceholder("Ingrese usuario");
        txtUsuario.setPreferredSize(new java.awt.Dimension(216, 40));
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
        jpDatos.add(txtUsuario);

        txtClave.setMaximumSize(new java.awt.Dimension(216, 40));
        txtClave.setMinimumSize(new java.awt.Dimension(216, 40));
        txtClave.setPlaceholder("Ingrese contraseña");
        txtClave.setPreferredSize(new java.awt.Dimension(216, 40));
        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        jpDatos.add(txtClave);

        jPanel1.setMaximumSize(new java.awt.Dimension(216, 40));
        jPanel1.setMinimumSize(new java.awt.Dimension(216, 40));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

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

        jpDatos.add(jPanel1);

        btnParametros.setBackground(new java.awt.Color(0, 204, 51));
        btnParametros.setText("Opcion de conexion");
        btnParametros.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DASHBOARD);
        btnParametros.setMaximumSize(new java.awt.Dimension(216, 40));
        btnParametros.setMinimumSize(new java.awt.Dimension(216, 40));
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
            .addGroup(laminaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLSystema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laminaLayout.createSequentialGroup()
                        .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        laminaLayout.setVerticalGroup(
            laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laminaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLSystema, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(laminaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLogoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lamina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        //btnAceptarActionPerformed(null);
    }//GEN-LAST:event_formWindowOpened
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        btnCancelarActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        txtClave.requestFocusInWindow();
    }//GEN-LAST:event_txtUsuarioActionPerformed

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

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        btnAceptarActionPerformed(null);
    }//GEN-LAST:event_txtClaveActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Variables para almacenar los roles
        ArrayList<String> roles = new ArrayList<String>();

        //Validación de campos del login. 
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

        //Cargar los valores de la conexion desde el properties
        frmParametros p = new frmParametros();
        String dominio="localhost", puerto="3050";
        
        if(p.cargarParamentos("").getConIpServidor()){
            dominio = p.cargarParamentos("").getIpServidor1()+"."+
                    p.cargarParamentos("").getIpServidor2()+"."+
                    p.cargarParamentos("").getIpServidor3()+"."+
                    p.cargarParamentos("").getIpServidor4();
        }
        
        if(p.cargarParamentos("").getConServidor()){
            dominio = p.cargarParamentos("").getUriServidor();
        }
        
        if(p.cargarParamentos("").getConPuerto()){
            puerto = p.cargarParamentos("").getPuerto();
        }
        
        Conexion conexion = Conexion.getInstance(
                txtUsuario.getText(),
                new String(txtClave.getPassword()), 
                "None", 
                p.cargarParamentos("").getPathBaseDatos(), 
                dominio, 
                puerto);
        
        FirebirdEventos f = new FirebirdEventos();
        
        if(!conexion.verificar()){ 
            LOG.log(Level.SEVERE, "No tiene conexión a la base de datos.");
            txtUsuario.setText("");
            txtClave.setText("");
            txtUsuario.requestFocusInWindow();
            return;
        }
        
        if(!f.registro(
                txtUsuario.getText().trim(), 
                new String(txtClave.getPassword()), 
                dominio, 
                p.cargarParamentos("").getPathBaseDatos(), 
                Integer.parseInt(puerto))){
            LOG.log(Level.SEVERE, "No puede registrar los eventos de la base de datos.");
        }
        
        roles = comprobandoRol(txtUsuario.getText().trim());

        if(txtUsuario.getText().trim().equalsIgnoreCase("sysdba")){
            roles.add("ADMINISTRADOR");
        }
        

        if (roles == null) {
            Conexion.cerrarConexion();
            Conexion.setCnn(null);
            JOptionPane.showMessageDialog(this, "El usuario no cuenta con rol en el sistema");
            return;
        }

        JComboBox<String> comboBox = new JComboBox(roles.toArray());

        if (roles.size() > 1) {
            JOptionPane.showMessageDialog(null, comboBox, "Seleccione un rol",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        String rol = comboBox.getSelectedItem().toString();

       
        if (rol.equalsIgnoreCase("ADMINISTRADOR")) {
            rol = "RDB$ADMIN";
        }
        
        

        //Reconectarse con el rol seleccionado por el usuario. 
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

        //Blanquear la pass
        txtClave.setText("");
        
        //Si el formulario principal no está instanciado lo hacemos. 
        if (principal == null) {
            principal = new frmPrincipal();
        }

        principal.setIdUsuario(txtUsuario.getText());
        principal.setClave(new String(txtClave.getPassword()));
        principal.cerrarFormularios();
        principal.setVisible(true);
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            if (getCnn() != null) {
                Conexion.cerrarConexion();
            }
        } catch (Exception e) {

        }
        System.exit(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametrosActionPerformed
        frmParametros miParametros = new frmParametros();
        miParametros.setLocationRelativeTo(null);
        miParametros.setVisible(true);
    }//GEN-LAST:event_btnParametrosActionPerformed

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
            JOptionPane.showMessageDialog(this, "Maquina Registradas");
        }

        miRegistros.dispose();

    }

    public static void main(String args[]) {
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                System.out.println("Look And Feel: " + info.getName());
            }

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlatLightLaf.setup();
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
    private javax.swing.JLabel jlLogoSistema;
    private javax.swing.JPanel jpDatos;
    private RSMaterialComponent.RSPanelMaterialImage lamina;
    private RSMaterialComponent.RSPasswordIconOne txtClave;
    private RSMaterialComponent.RSTextFieldIconOne txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void cargarIconos() {
        Imagenes imagen = new Imagenes();
        jlLogoSistema.setIcon(imagen.getIcono("Panel de Control 128 x 128.png"));
        lamina.setImagen(imagen.getIcono("FondoLogin 626 x 386.jpg"));
    }
}
