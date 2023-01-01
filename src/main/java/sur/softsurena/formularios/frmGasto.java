package sur.softsurena.formularios;

import java.awt.Color;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import sur.softsurena.entidades.Gastos;
import static sur.softsurena.entidades.Gastos.agregarGastosPorTurno;
import sur.softsurena.hilos.hiloImpresionFactura;
import sur.softsurena.utilidades.Utilidades;

public class frmGasto extends java.awt.Dialog {

    private int idTurno;
    private String usuario;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public frmGasto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        txtMonto.setValue(0.0);
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        txtMonto.setSelectionStart(3);
                        txtMonto.setSelectionEnd(txtMonto.getText().length());
                    }
                });
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JFormattedTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        txtDescripcion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Generar Gasto");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("Concepto del Gasto:");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel3.setText("Monto del Gasto:");

        txtMonto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getCurrencyInstance())));
        txtMonto.setAction(btnAceptar.getAction());
        txtMonto.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        txtMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoKeyTyped(evt);
            }
        });

        btnAceptar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAceptarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAceptarMouseEntered(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorLayout = new javax.swing.GroupLayout(contenedor);
        contenedor.setLayout(contenedorLayout);
        contenedorLayout.setHorizontalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contenedorLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, 0)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMonto))
                .addGap(0, 0, 0))
        );

        contenedorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        contenedorLayout.setVerticalGroup(
            contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        contenedorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtDescripcion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un Concepto");
            txtDescripcion.requestFocusInWindow();
            return;
        }
        if (txtMonto.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Monto Vacio debe proporsionarlo");
            txtMonto.setValue(0.0);
            txtMonto.requestFocusInWindow();
            return;
        }

        BigDecimal monto = new BigDecimal(txtMonto.getValue().toString());

        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            JOptionPane.showMessageDialog(this, "Monto debe ser mayor a 0");
            txtMonto.setValue(0.0);
            txtMonto.requestFocusInWindow();
            return;
        }

        String descripcion = "";
        if (txtDescripcion.getText().length() >= 70) {
            descripcion = txtDescripcion.getText().substring(0, 69);
        } else {
            descripcion = txtDescripcion.getText();
        }
        
        Gastos g = Gastos.builder().
                id_turno(getIdTurno()).
                descripcion(descripcion).
                monto(monto).build();

        if (agregarGastosPorTurno(g)) {
            JOptionPane.showMessageDialog(this, "Gasto registrado....!!!");
        } else {
            JOptionPane.showMessageDialog(this, "No se puede registrar el Gasto");
        }

        //Constancia de Gasto a imprimir
        Map parametros = new HashMap();
        parametros.put("idTurno", getIdTurno());
        parametros.put("idCajero", getUsuario());
        hiloImpresionFactura miHilo = new hiloImpresionFactura(
                true, //Mostrar Reporte
                false, //Con Copia
                System.getProperty("user.dir") + "/Reportes/gasto.jasper",
                parametros);
        miHilo.start();
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setForeground(Color.blue);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        txtMonto.requestFocusInWindow();
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        btnAceptarActionPerformed(evt);
    }//GEN-LAST:event_txtMontoActionPerformed

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        txtDescripcion.setText(txtDescripcion.getText().toUpperCase());
    }//GEN-LAST:event_txtDescripcionKeyReleased

    private void txtMontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoKeyTyped
        char caracter = evt.getKeyChar();
        if (caracter == '.') {
            return;
        }
        if (caracter < '0' || (caracter > '9')) {
            evt.consume();  // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtMontoKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel contenedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JFormattedTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
