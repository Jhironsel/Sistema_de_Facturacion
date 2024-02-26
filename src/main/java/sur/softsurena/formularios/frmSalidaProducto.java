package sur.softsurena.formularios;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static sur.softsurena.utilidades.Utilidades.LOG;

public class frmSalidaProducto extends javax.swing.JDialog {

    private frmBusquedaProducto miBusqueda;

    public frmSalidaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbEstado = new javax.swing.JCheckBox();
        jlImagen = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        txtOperacion = new rojeru_san.rslabel.RSLabelAnimated();
        txtCodigo = new necesario.TextField();
        txtDescripcion = new necesario.TextField();
        txtSalida = new necesario.TextField();
        txtExistencia = new necesario.TextField();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        btnBuscarProducto = new newscomponents.RSButtonGradientIcon_new();
        btnGuardar = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Salida de Producto del sistema");
        setMinimumSize(new java.awt.Dimension(654, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setText("Inactivo");
        cbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbEstadoMouseClicked(evt);
            }
        });

        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"))); // NOI18N
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtConcepto.setLineWrap(true);
        txtConcepto.setRows(5);
        txtConcepto.setToolTipText("Ingrese el concepto de la salida del producto.");
        txtConcepto.setWrapStyleWord(true);
        txtConcepto.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 255), 2, true), " Concepto de salida "));
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

        txtOperacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtOperacion.setText("No.");
        txtOperacion.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N

        txtCodigo.setPlaceholder("Codigo Producto");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDescripcion.setEditable(false);
        txtDescripcion.setPlaceholder("Descripcion");

        txtSalida.setPlaceholder("Salida");
        txtSalida.setSoloNumeros(true);
        txtSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSalidaFocusGained(evt);
            }
        });
        txtSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSalidaActionPerformed(evt);
            }
        });

        txtExistencia.setEditable(false);
        txtExistencia.setPlaceholder("Existencia");

        btnBuscarProducto.setIcon(null);
        btnBuscarProducto.setText("Productos");
        btnBuscarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.WIDGETS);
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtOperacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtExistencia, txtSalida});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelFecha1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado)))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbEstado, txtExistencia});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtConceptoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConceptoFocusLost
        btnGuardar.requestFocusInWindow();
    }//GEN-LAST:event_txtConceptoFocusLost

    private void txtConceptoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConceptoKeyReleased
        txtConcepto.setText(txtConcepto.getText().toUpperCase());
    }//GEN-LAST:event_txtConceptoKeyReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        txtOperacion.setText("" + (Datos.idMaximoRegistro() + 1));
        txtCodigo.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void cbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEstadoMouseClicked
        cbEstado.setSelected(!cbEstado.isSelected());
    }//GEN-LAST:event_cbEstadoMouseClicked

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        if (txtCodigo.getText().isBlank()) {
            btnBuscarProducto.doClick();
            return;
        }

//        Datos.getProductoById(null, txtCodigo.getText().trim())
        ResultSet rs = null;
        BufferedImage img = null;
        try {
            if (!rs.next()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Producto no encontrado.!!!",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtCodigo.setText("");
                txtCodigo.requestFocusInWindow();
                return;
            }

            Blob blob = rs.getBlob("image");
            if (blob != null) {
                byte[] data = blob.getBytes(1, (int) blob.length());
                img = ImageIO.read(new ByteArrayInputStream(data));
            }

            ImageIcon imagen;

            if (img != null) {
                imagen = new ImageIcon(img);
            } else {
                imagen = new ImageIcon(getClass().getResource(
                        "/images/NoImageTransp 96 x 96.png"));
            }

            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(
                    72, 72, Image.SCALE_DEFAULT));
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();

            txtExistencia.setText(rs.getString("cantidad"));
            txtDescripcion.setText(rs.getString("descripcion"));

            cbEstado.setSelected(rs.getBoolean("estado"));
            if (cbEstado.isSelected()) {
                cbEstado.setText("Activo");
            } else {
                cbEstado.setText("Inactivo");
            }

            txtSalida.requestFocusInWindow();

        } catch (SQLException | IOException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSalidaActionPerformed
        txtConcepto.requestFocusInWindow();
    }//GEN-LAST:event_txtSalidaActionPerformed

    private void txtSalidaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalidaFocusGained
        txtSalida.selectAll();
    }//GEN-LAST:event_txtSalidaFocusGained

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        miBusqueda = new frmBusquedaProducto(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);

        if (miBusqueda.getRespuesta() == null) {
            quitarImagen();
            limpiar();
            return;
        }
//        txtCodigo.setText(((Categoria) miBusqueda.getRespuesta()).getDescripcion());
        txtCodigoActionPerformed(evt);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtCodigo.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Codigo del Producto esta vacio....!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCodigo.requestFocusInWindow();
            return;
        }

        if (txtConcepto.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Proporcional el concepto o motivo de la salida de este producto del sistema...!!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtConcepto.requestFocusInWindow();
            return;
        }

        BigDecimal valor = new BigDecimal(txtSalida.getText().trim());

        if (valor.compareTo(BigDecimal.ZERO) == 0.0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Inserte una cantidad",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtSalida.requestFocusInWindow();
            return;
        }

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se permite numero negativo o cero...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtSalida.requestFocusInWindow();
            return;
        }

//        if (!agregarProductoEntrada(
//                new EntradaProducto(
//                        Integer.valueOf(txtOperacion.getText().trim()),
//                        ((Categoria) miBusqueda.getRespuesta()).getIdProducto(),
//                        null,
//                        0,
//                        "N/A",
//                        txtConcepto.getText().trim(),
//                        new BigDecimal(txtSalida.getText()),
//                        null,
//                        null,
//                        '-',
//                        BigDecimal.ZERO,
//                        BigDecimal.ZERO,
//                        false,
//                        BigDecimal.ZERO)
//        )) {
//            JOptionPane.showMessageDialog(this,
//                    "No se pudo registrar producto");
//            return;
//        }
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("operacion", Integer.parseInt(txtOperacion.getText()));
//        hiloImpresionFactura impresionFactura = new hiloImpresionFactura(
//                true,
//                false,
//                "Reportes/Salida.jasper",
//                parametros);
//        impresionFactura.start();
        btnCancelar.doClick();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void limpiar() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("Inactivo");
        txtSalida.setText("0.00");
        txtConcepto.setText("");
        txtExistencia.setText("");
        txtCodigo.requestFocusInWindow();
    }

    private void quitarImagen() {
        ImageIcon imagen = new ImageIcon(getClass().getResource("/images/NoImageTransp 96 x 96.png"));
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();
        jlImagen.setIcon(icon);
        jlImagen.validate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnBuscarProducto;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnGuardar;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlImagen;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private necesario.TextField txtCodigo;
    private javax.swing.JTextArea txtConcepto;
    private necesario.TextField txtDescripcion;
    private necesario.TextField txtExistencia;
    private rojeru_san.rslabel.RSLabelAnimated txtOperacion;
    private necesario.TextField txtSalida;
    // End of variables declaration//GEN-END:variables
}
