package sur.softsurena.formularios;

import java.awt.Image;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Producto;
import static sur.softsurena.metodos.M_Producto.getProductos;
import sur.softsurena.utilidades.FiltroBusqueda;
import static sur.softsurena.utilidades.Utilidades.imagenDecode64;

public class frmEntradaProducto extends javax.swing.JDialog {

    private frmBusquedaProducto miBusqueda;
    private Boolean impuesto = false;
    private DefaultTableModel miTabla;
    private Object registro[];

    public frmEntradaProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        String titulos[] = {"Codigo Art.", "Descripcion", "Cantidad", "Costo", "Precio",
            "Impuesto", "%Impuesto"};
        registro = new Object[titulos.length];
        miTabla = new DefaultTableModel(null, titulos) {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 5) {
                    return Boolean.class;
                } else {
                    return String.class;
                }
            }
        };
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbEstado = new javax.swing.JCheckBox();
        jlImagen = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCosto = new necesario.TextField();
        txtImpuesto = new necesario.TextField();
        txtEntrada = new necesario.TextField();
        txtPrecio = new necesario.TextField();
        txtCodigoProducto = new necesario.TextField();
        txtNumeroFactura = new necesario.TextField();
        txtDescripcionProducto = new necesario.TextField();
        txtNumero = new rojeru_san.rslabel.RSLabelAnimated();
        rSLabelFecha1 = new rojeru_san.rsdate.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.rsdate.RSLabelHora();
        btnFinalizar = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        btnAgregar = new newscomponents.RSButtonGradientIcon_new();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbArticulos = new RSMaterialComponent.RSTableMetro();
        btnBuscarProducto = new newscomponents.RSButtonGradientIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entrada de producto del sistema");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        cbEstado.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        cbEstado.setText("Inactivo");
        cbEstado.setToolTipText("Estado del producto en el inventario");
        cbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstadoItemStateChanged(evt);
            }
        });
        cbEstado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbEstadoMouseClicked(evt);
            }
        });

        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"))); // NOI18N
        jlImagen.setToolTipText("Imagen del producto");
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Operacion No.: ");

        txtCosto.setPlaceholder("Costo");
        txtCosto.setSoloNumeros(true);
        txtCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCostoFocusGained(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        txtImpuesto.setEditable(false);
        txtImpuesto.setPlaceholder("Impuesto");
        txtImpuesto.setSoloNumeros(true);
        txtImpuesto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtImpuestoFocusGained(evt);
            }
        });
        txtImpuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestoActionPerformed(evt);
            }
        });

        txtEntrada.setPlaceholder("Entrada");
        txtEntrada.setSoloNumeros(true);
        txtEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEntradaFocusGained(evt);
            }
        });
        txtEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntradaActionPerformed(evt);
            }
        });

        txtPrecio.setPlaceholder("Precio");
        txtPrecio.setSoloNumeros(true);
        txtPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioFocusGained(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        txtCodigoProducto.setPlaceholder("Codigo Producto...");
        txtCodigoProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoProductoFocusGained(evt);
            }
        });
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });

        txtNumeroFactura.setMayusculas(true);
        txtNumeroFactura.setPlaceholder("Ingrese Numero / Codigo de factura");
        txtNumeroFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumeroFacturaFocusGained(evt);
            }
        });
        txtNumeroFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroFacturaActionPerformed(evt);
            }
        });
        txtNumeroFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumeroFacturaKeyReleased(evt);
            }
        });

        txtDescripcionProducto.setEditable(false);
        txtDescripcionProducto.setPlaceholder("Descripcion del producto");
        txtDescripcionProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescripcionProductoFocusGained(evt);
            }
        });

        txtNumero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtNumero.setText("No.");
        txtNumero.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N

        btnFinalizar.setText("Finalizar");
        btnFinalizar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnFinalizar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(237, 16, 37));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(234, 70, 75));
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnAgregar.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnAgregar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnAgregar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tbArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tbArticulos);

        btnBuscarProducto.setText("Productos");
        btnBuscarProducto.setColorPrimario(new java.awt.Color(0, 255, 73));
        btnBuscarProducto.setColorPrimarioHover(new java.awt.Color(63, 186, 68));
        btnBuscarProducto.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBuscarProducto.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SEARCH);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNumeroFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCosto, txtImpuesto, txtPrecio});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnFinalizar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstado)))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImpuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbEstado, txtEntrada});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
//        txtNumero.setText("" + (idMaximoRegistro() + 1));
        txtNumeroFactura.requestFocusInWindow();
    }//GEN-LAST:event_formWindowOpened

    private void cbEstadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbEstadoMouseClicked
        cbEstado.setSelected(!cbEstado.isSelected());
    }//GEN-LAST:event_cbEstadoMouseClicked

    private void cbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstadoItemStateChanged
        if (cbEstado.isSelected()) {
            cbEstado.setText("Activo");
        } else {
            cbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_cbEstadoItemStateChanged

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        btnAgregar.requestFocusInWindow();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntradaActionPerformed
        txtCosto.requestFocusInWindow();
    }//GEN-LAST:event_txtEntradaActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        if (txtCodigoProducto.getText().isBlank()) {
            btnBuscarProducto.doClick();
            return;
        }

        List<Producto> productos = getProductos(
                FiltroBusqueda
                        .builder()
                        .criterioBusqueda(
                                txtCodigoProducto.getText().strip()
                        )
                        .build()
        );

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Producto no encontrado...!!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCodigoProducto.setText("");
            txtCodigoProducto.requestFocusInWindow();
            return;
        }

        productos.stream().forEach(producto -> {
            
            jlImagen.setIcon(imagenDecode64(producto.getImagenProducto(), 72, 72));
            //imagen.getImage().flush();
            
            txtDescripcionProducto.setText(producto.getDescripcion());
            cbEstado.setSelected(producto.getEstado());
        });

        jlImagen.validate();
        txtEntrada.requestFocusInWindow();
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtNumeroFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroFacturaActionPerformed
        txtCodigoProducto.requestFocusInWindow();
    }//GEN-LAST:event_txtNumeroFacturaActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        txtPrecio.requestFocusInWindow();
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtNumeroFacturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroFacturaKeyReleased
        //txtNumeroFactura.setText(txtNumeroFactura.getText().toUpperCase());
    }//GEN-LAST:event_txtNumeroFacturaKeyReleased

    private void txtImpuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestoActionPerformed
        btnAgregar.requestFocusInWindow();
    }//GEN-LAST:event_txtImpuestoActionPerformed

    private void txtCostoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostoFocusGained
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCostoFocusGained

    private void txtEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEntradaFocusGained
        txtEntrada.selectAll();
    }//GEN-LAST:event_txtEntradaFocusGained

    private void txtPrecioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioFocusGained
        txtPrecio.selectAll();
    }//GEN-LAST:event_txtPrecioFocusGained

    private void txtImpuestoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtImpuestoFocusGained
        txtImpuesto.selectAll();
    }//GEN-LAST:event_txtImpuestoFocusGained

    private void txtCodigoProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoProductoFocusGained
        txtCosto.selectAll();
    }//GEN-LAST:event_txtCodigoProductoFocusGained

    private void txtNumeroFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumeroFacturaFocusGained
        txtNumeroFactura.selectAll();
    }//GEN-LAST:event_txtNumeroFacturaFocusGained

    private void txtDescripcionProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescripcionProductoFocusGained
        txtDescripcionProducto.selectAll();
    }//GEN-LAST:event_txtDescripcionProductoFocusGained

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtNumeroFactura.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe Proporcional la factura asociada a este registros de productos",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNumeroFactura.requestFocusInWindow();
            return;
        }

        if (txtCodigoProducto.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Id Producto esta vacio....!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCodigoProducto.requestFocusInWindow();
            return;
        }

        if (miBusqueda == null) {
            //TODO determinar cual es el icono de este dialog.
            JOptionPane.showMessageDialog(
                    this,
                    "Vuelva a buscar el articulo.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (txtEntrada.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe de ingrar valores en entrada.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtEntrada.requestFocusInWindow();
            return;
        }

        BigDecimal entrada = new BigDecimal(txtEntrada.getText().trim());

        if (entrada.compareTo(new BigDecimal(0)) <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "No se permite numero negativo o cero...!!!",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (txtCosto.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar el costo del producto.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtCosto.requestFocusInWindow();
            return;
        }

        if (Double.parseDouble(txtCosto.getText()) <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe de ingresar costo del Art. mayor que cero(0).",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (txtPrecio.getText().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe ingresar el precio del producto.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtPrecio.requestFocusInWindow();
            return;
        }

        if (Double.parseDouble(txtPrecio.getText()) <= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe de ingresar precio del Art. mayor que cero(0).",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (Double.valueOf(txtCosto.getText())
                >= Double.valueOf(txtPrecio.getText())) {

            JOptionPane.showMessageDialog(
                    this,
                    "El costo no puede ser mayor al precio.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );

            txtCosto.setText("");
            txtPrecio.setText("");
            txtCosto.requestFocusInWindow();

            return;
        }

        if (!impuesto) {
            int resp = JOptionPane.showConfirmDialog(
                    this,
                    "Este articulo tiene impuesto?",
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (resp == JOptionPane.YES_OPTION) {
                txtImpuesto.setEditable(true);
                txtImpuesto.setText("0.00");
                txtImpuesto.requestFocusInWindow();
                txtImpuesto.setSelectionStart(0);
                txtImpuesto.setSelectionEnd(txtImpuesto.getText().length());
                impuesto = true;
                return;
            } else {
                impuesto = false;
                txtImpuesto.setText("0.00");
            }
        }

        if (impuesto) {
            if (txtImpuesto.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe de ingresar un valor en impuesto.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtImpuesto.requestFocusInWindow();
                return;
            }
            BigDecimal c = new BigDecimal(txtImpuesto.getText());

            if (c.compareTo(BigDecimal.ZERO) <= 0) {
                JOptionPane.showMessageDialog(
                        this,
                        "Debe de ingresar una cantidad mayor a cero.",
                        "",
                        JOptionPane.ERROR_MESSAGE
                );
                txtImpuesto.setText("");
                txtImpuesto.requestFocusInWindow();
                return;
            }
        }

        Producto p = Producto.builder().id(-1).descripcion("").build();
        registro[0] = miBusqueda.getRespuesta();//p
        registro[1] = txtDescripcionProducto.getText();
        registro[2] = entrada;
        registro[3] = txtCosto.getText();
        registro[4] = txtPrecio.getText();
        registro[5] = impuesto;
        registro[6] = txtImpuesto.getText();

        miTabla.addRow(registro);
        tbArticulos.setModel(miTabla);

        txtNumeroFactura.setEditable(false);
        quitarImagen();
        limpiar();
        txtCodigoProducto.requestFocusInWindow();

        impuesto = false;
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        for (int i = 0; i < tbArticulos.getRowCount(); i++) {
//            if (!agregarProductoEntrada(
//                new EntradaProducto(
//                    Integer.valueOf(txtNumero.getText()),
//                    ((Categoria) tbArticulos.getValueAt(i, 0)).getIdProducto(),
//                    null,
//                    (i + 1),
//                    txtNumeroFactura.getText(),
//                    "N/A",
//                    new BigDecimal(tbArticulos.getValueAt(i, 2).toString()),
//                    null,
//                    null,
//                    '+',
//                    new BigDecimal(tbArticulos.getValueAt(i, 3).toString()),
//                    new BigDecimal(tbArticulos.getValueAt(i, 4).toString()),
//                    Boolean.valueOf(tbArticulos.getValueAt(i, 5).toString()),
//                    new BigDecimal(tbArticulos.getValueAt(i, 6).toString())
//                )
//            )) {
//                JOptionPane.showMessageDialog(this, "No se pudo registrar producto");
//                return;
//            }
        }

        //        Map<String, Object> parametros = new HashMap<>();
        //        parametros.put("operacion", Integer.parseInt(txtNumero.getText()));
        //        hiloImpresionFactura miHilo = new hiloImpresionFactura(
        //                true, //Mostrar Reporte
        //                false, //Con Copia
        //                "Reportes/entrada.jasper",
        //                parametros);
        //        miHilo.start();
        btnCancelar.doClick();

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        quitarImagen();
        limpiar();
        miBusqueda = new frmBusquedaProducto(null, true);
        miBusqueda.setLocationRelativeTo(null);
        miBusqueda.setVisible(true);
        if (miBusqueda.getRespuesta() != null) {
            txtCodigoProducto.setText(miBusqueda.getRespuesta());
            txtCodigoProductoActionPerformed(evt);
        }

    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void limpiar() {
        txtCodigoProducto.setText("");
        txtEntrada.setText("");
        txtDescripcionProducto.setText("");
        txtPrecio.setText("");
        txtCosto.setText("");
        cbEstado.setSelected(false);
        cbEstado.setText("Inactivo");
        txtImpuesto.setText("");
        txtImpuesto.setEditable(false);
    }

    private void quitarImagen() {
        ImageIcon imagen = new ImageIcon("sur/softsurena/imagenes/NoImageTransp 96 x 96.png");
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));
        imagen.getImage().flush();
        jlImagen.setIcon(icon);
        jlImagen.validate();

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAgregar;
    private newscomponents.RSButtonGradientIcon_new btnBuscarProducto;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnFinalizar;
    private javax.swing.JCheckBox cbEstado;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlImagen;
    private rojeru_san.rsdate.RSLabelFecha rSLabelFecha1;
    private rojeru_san.rsdate.RSLabelHora rSLabelHora1;
    private RSMaterialComponent.RSTableMetro tbArticulos;
    private necesario.TextField txtCodigoProducto;
    private necesario.TextField txtCosto;
    private necesario.TextField txtDescripcionProducto;
    private necesario.TextField txtEntrada;
    private necesario.TextField txtImpuesto;
    private rojeru_san.rslabel.RSLabelAnimated txtNumero;
    private necesario.TextField txtNumeroFactura;
    private necesario.TextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
