package sur.softsurena.formularios;

import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class frmSalidaProducto extends javax.swing.JDialog {

    private String Usuario;
    private int numero = 1;

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public frmSalidaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        txtSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtSalida.selectAll();
                    }
                });
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtIDProductos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        cbEstado = new javax.swing.JCheckBox();
        jlImagen = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSalida = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        txtOperacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salida de Producto del sistema");
        setMinimumSize(new java.awt.Dimension(654, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("Codigo Producto: ");

        txtIDProductos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtIDProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDProductosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descripcion: ");

        txtDescripcion.setEditable(false);
        txtDescripcion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Costo: ");

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio: ");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setText("Inactivo");
        cbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbEstadoMouseClicked(evt);
            }
        });

        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sin_imagen 64 x 64.png"))); // NOI18N
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(1, 1, 1));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Guardar 32 x 32.png"))); // NOI18N
        btnGuardar.setMnemonic('g');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("Guardar Registro Actual");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Cancela la Operacion del Registro");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Salida: ");

        txtSalida.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txtSalida.setToolTipText("");
        txtSalida.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtSalida.setValue(0.0);
        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });
        txtSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSalidaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Concepto: ");

        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConcepto.setLineWrap(true);
        txtConcepto.setRows(5);
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConceptoFocusLost(evt);
            }
        });
        txtConcepto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtConceptoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtConcepto);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setText("Operacion No.: ");

        txtOperacion.setEditable(false);
        txtOperacion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Estado: ");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Existencia: ");

        txtExistencia.setEditable(false);
        txtExistencia.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N

        btnBuscarProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarProducto.setMnemonic('p');
        btnBuscarProducto.setText("Productos");
        btnBuscarProducto.setToolTipText("Busca un Producto");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnBuscarProducto)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtSalida, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtExistencia)
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtIDProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(txtIDProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProducto))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel5)
                            .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDProductosActionPerformed
        String sql = "select descripcion, costo, precio, entrada, estado, "
                + "imagePath  from Productos where idProducto like '"
                + txtIDProductos.getText() + "'";
        ResultSet rs = getConsulta(sql);
        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado...!!!!");
                txtIDProductos.setText("");
                txtIDProductos.requestFocusInWindow();
                return;
            }
            ImageIcon imagen = new ImageIcon();
            if (rs.getString("imagepath") != null) {
                imagen = new ImageIcon(rs.getString("imagepath"));
            }

            if (imagen.getIconHeight() == -1) {
                imagen = new ImageIcon(System.getProperty("user.dir")
                        + "/images/Sin_imagen 64 x 64.png");
            }
            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                    Image.SCALE_DEFAULT));
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();
            txtExistencia.setText(rs.getString("entrada"));
            txtDescripcion.setText(rs.getString("descripcion"));
            txtCosto.setText(rs.getString("costo"));
            txtPrecio.setText(rs.getString("precio"));
            cbEstado.setSelected((rs.getInt("estado") == 1));
            if (cbEstado.isSelected()) {
                cbEstado.setText("Activo");
            } else {
                cbEstado.setText("Inactivo");
            }
            txtSalida.requestFocusInWindow();
        } catch (SQLException ex) {
            //Instalar Logger
        }
    }//GEN-LAST:event_txtIDProductosActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtIDProductos.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Id Producto esta vacio....!!!");
            txtIDProductos.requestFocusInWindow();
            return;
        }

        if (txtConcepto.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Proporcional el concepto o motivo de la salida de este producto del sistema...!!!!");
            txtConcepto.requestFocusInWindow();
            return;
        }

        double valor = Utilidades.controlDouble(txtSalida.getValue());

        if (valor == 0.0) {
            JOptionPane.showMessageDialog(this, "Inserte una cantidad");
            txtSalida.requestFocusInWindow();
            return;
        }

        if (valor <= 0) {
            JOptionPane.showMessageDialog(this, "No se permite numero negativo o cero...!!!");
            txtSalida.requestFocusInWindow();
            return;
        }

        if (!misDatos.agregarProductoSalida(Integer.parseInt(txtOperacion.getText()),
                numero, txtConcepto.getText(), txtIDProductos.getText(), valor,
                getUsuario())) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar producto");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Desea sacar mas Productos del sistema...!!!",
                "Confirmacion....", JOptionPane.YES_NO_OPTION);
        if (resp == 1) {
            numero++;
            btnCancelarActionPerformed(evt);
        } else {
            numero++;
            quitarImagen();
            limpiar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (numero != 1) {
            Map parametros = new HashMap();
            parametros.put("operacion", Integer.parseInt(txtOperacion.getText()));
            hiloImpresionFactura impresionFactura = new hiloImpresionFactura(
                    misDatos,
                    true,
                    false,
                    System.getProperty("user.dir") + "/Reportes/Salida.jasper",
                    parametros);
            impresionFactura.start();
        }
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed
        txtConcepto.requestFocusInWindow();
    }//GEN-LAST:event_txtSalidaActionPerformed

    private void txtConceptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConceptoFocusLost
        btnGuardar.requestFocusInWindow();
    }//GEN-LAST:event_txtConceptoFocusLost

    private void txtConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyReleased
        txtConcepto.setText(txtConcepto.getText().toUpperCase());
    }//GEN-LAST:event_txtConceptoKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ResultSet rs = misDatos.getConsulta("select max(e.IDENTRADA_PRODUCTO) + 1 from ENTRADAS_PRODUCTO e");
        try {
            rs.next();
            txtOperacion.setText("" + rs.getInt(1));
        } catch (SQLException ex) {
            //Instalar Logger
        }
        txtIDProductos.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        frmBusquedaProducto miBusqueda = new frmBusquedaProducto(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);
        if (miBusqueda.getRespuesta().equals("")) {
            quitarImagen();
            limpiar();
            return;
        }
        txtIDProductos.setText(miBusqueda.getRespuesta());
        txtIDProductosActionPerformed(evt);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtSalidaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaKeyReleased
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtSalidaKeyReleased

    private void cbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEstadoMouseClicked
        cbEstado.setSelected(!cbEstado.isSelected());
    }//GEN-LAST:event_cbEstadoMouseClicked
    private void limpiar() {
        txtIDProductos.setText("");
        txtDescripcion.setText("");
        txtCosto.setText("");
        txtPrecio.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("Inactivo");
        txtSalida.setValue(0.0);
        txtConcepto.setText("");
        txtExistencia.setText("");
        txtIDProductos.requestFocusInWindow();
    }

    private void quitarImagen() {
        String miFile = System.getProperty("user.dir")
                + "/images/Sin_imagen 64 x 64.png";
        ImageIcon imagen = new ImageIcon(miFile);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();
        jlImagen.setIcon(icon);
        jlImagen.validate();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlImagen;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtExistencia;
    private javax.swing.JTextField txtIDProductos;
    private javax.swing.JTextField txtOperacion;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JFormattedTextField txtSalida;
    // End of variables declaration//GEN-END:variables
}
