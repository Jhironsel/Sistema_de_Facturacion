package sur.softsurena.formularios;

import java.awt.Image;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import static sur.softsurena.datos.insert.InsertMetodos.agregarProductoEntrada;
import sur.softsurena.entidades.EntradaProducto;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.utilidades.Utilidades;

public class frmEntradaProducto extends javax.swing.JDialog {

    private String usuario;
    private int numero = 1;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public frmEntradaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        txtEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtEntrada.selectAll();
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
        txtEntrada = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtOperacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtExistencia = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de producto del sistema");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("Codigo Producto: ");

        txtIDProductos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtIDProductos.setToolTipText("Inserte el codigo producto y presione enter");
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
        txtDescripcion.setToolTipText("Descripcion del producto, Nombre que es impreso");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Costo: ");

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtCosto.setToolTipText("Costo del producto que esta registrado");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio: ");

        txtPrecio.setEditable(false);
        txtPrecio.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtPrecio.setToolTipText("Precio registrado del producto");

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setText("Inactivo");
        cbEstado.setToolTipText("Estado del producto en el inventario");
        cbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbEstadoMouseClicked(evt);
            }
        });

        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sin_imagen 64 x 64.png"))); // NOI18N
        jlImagen.setToolTipText("Imagen del producto");
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
        jLabel5.setText("Entrada: ");

        txtEntrada.setForeground(new java.awt.Color(0, 153, 0));
        txtEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtEntrada.setToolTipText("Inserte la cantidad del producto para poder sumarlo al inventario");
        txtEntrada.setFont(new java.awt.Font("Ubuntu Mono", 1, 24)); // NOI18N
        txtEntrada.setValue(0.0);
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });
        txtEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEntradaKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel6.setText("Factura: ");

        txtFactura.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtFactura.setToolTipText("Inserte el numero de la factura que resparde el o los arcticulos");
        txtFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFacturaActionPerformed(evt);
            }
        });
        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFacturaKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setText("Operacion No.: ");

        txtOperacion.setEditable(false);
        txtOperacion.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtOperacion.setToolTipText("Numero de Operacion de entrada de producto");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Estado: ");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Existencia: ");

        txtExistencia.setEditable(false);
        txtExistencia.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtExistencia.setToolTipText("Cantidad existe en el inventario");

        btnBuscarProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Buscar3 32 x 32.png"))); // NOI18N
        btnBuscarProducto.setMnemonic('p');
        btnBuscarProducto.setText("Productos");
        btnBuscarProducto.setToolTipText("Busca un Producto Por su descripcion o por otras caracteristicas");
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion)
                            .addComponent(txtFactura)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 0, 0)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtOperacion)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtIDProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarProducto)))
                        .addGap(0, 0, 0)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(txtOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnBuscarProducto)
                            .addComponent(jLabel1)
                            .addComponent(txtIDProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel2)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel3)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(cbEstado)
                            .addComponent(jLabel9)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel6)
                            .addComponent(txtFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCancelar, btnGuardar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDProductosActionPerformed
        String sql = "select descripcion, costo, precio, entrada, estado, imagePath  "
                + "from tabla_Productos "
                + "where idProducto like '" + txtIDProductos.getText() + "'";
        ResultSet rs = getConsulta(sql);
        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado...!!!!");
                txtIDProductos.setText("");
                txtIDProductos.requestFocusInWindow();
                return;
            }
            ImageIcon imagen = new ImageIcon(rs.getString("imagepath"));

            if (imagen.getIconHeight() == -1) {
                imagen = new ImageIcon(System.getProperty("user.dir") + 
                        "/images/Sin_imagen 64 x 64.png");
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
            
            txtFactura.requestFocusInWindow();
            if (!txtFactura.isEditable()) {
                txtEntrada.requestFocusInWindow();
            }
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

        if (txtFactura.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Debe Proporcional la factura asociada a esta entrada de "
                    + "producto...!!!!");
            txtFactura.requestFocusInWindow();
            return;
        }

        double valor = Utilidades.controlDouble(txtEntrada.getValue());

        if (valor <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permite numero negativo o cero...!!!");
            return;
        }
        
        EntradaProducto e = new EntradaProducto(
                null, 
                null, 
                Integer.parseInt(txtOperacion.getText()), 
                WIDTH, 
                HIDE_ON_CLOSE,
                BigDecimal.ZERO, 
                fechaVecimiento, 
                rootPaneCheckingEnabled, 
                usuario, 
                usuario);
                numero, txtFactura.getText(), txtIDProductos.getText(), valor,
                getUsuario()
        if (!agregarProductoEntrada(e)) {
            JOptionPane.showMessageDialog(this, "No se pudo registrar producto");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Desea agregar mas Productos con la Factura '{ "
                + txtFactura.getText() + " }' al sistema...!!!",
                "Confirmacion....", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.NO_OPTION) {
            numero++;
            btnCancelarActionPerformed(evt);
        } else {
            numero++;
            txtFactura.setEditable(false);
            quitarImagen();
            limpiar();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        if (numero != 1) {
            Map parametros = new HashMap();
            parametros.put("operacion", Integer.parseInt(txtOperacion.getText()));
            hiloImpresionFactura miHilo = new hiloImpresionFactura(
                    true, //Mostrar Reporte
                    false, //Con Copia
                    System.getProperty("user.dir") + "/Reportes/entrada.jasper",
                    parametros);
            miHilo.start();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        btnGuardar.requestFocusInWindow();
    }//GEN-LAST:event_txtEntradaActionPerformed
    private void txtFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFacturaActionPerformed
        txtEntrada.requestFocusInWindow();
    }//GEN-LAST:event_txtFacturaActionPerformed
    private void txtFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyReleased
        txtFactura.setText(txtFactura.getText().toUpperCase());
    }//GEN-LAST:event_txtFacturaKeyReleased
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ResultSet rs = getConsulta("select max(e.IDENTRADA_PRODUCTO) + 1 "
                + "from TABLA_ENTRADAS_PRUDUCTOS e");
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

    private void txtEntradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEntradaKeyTyped
        char caracter = evt.getKeyChar();
        // Verificar si la tecla pulsada no es un digito
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtEntradaKeyTyped

    private void cbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEstadoMouseClicked
        cbEstado.setSelected(!cbEstado.isSelected());
    }//GEN-LAST:event_cbEstadoMouseClicked
    private void limpiar() {
        txtIDProductos.setText("");
        txtEntrada.setValue(0.0);
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCosto.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("Inactivo");
        txtExistencia.setText("");
        txtIDProductos.requestFocusInWindow();
    }

    private void quitarImagen() {
        ImageIcon imagen = new ImageIcon(System.getProperty("user.dir")
                + "/images/Sin_imagen 64 x 64.png");
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
    private javax.swing.JLabel jlImagen;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtEntrada;
    private javax.swing.JTextField txtExistencia;
    public javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtIDProductos;
    private javax.swing.JTextField txtOperacion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
