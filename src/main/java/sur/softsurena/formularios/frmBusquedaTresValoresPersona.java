package sur.softsurena.formularios;

import java.awt.Color;
import sur.softsurena.utilidades.CustomFont;

public class frmBusquedaTresValoresPersona extends javax.swing.JDialog {

    public frmBusquedaTresValoresPersona(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jPanel2.removeAll();
        jPanel2.add(txtTodo);
        txtTodo.requestFocusInWindow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jrbTodo = new javax.swing.JRadioButton();
        jrbCedula = new javax.swing.JRadioButton();
        jrbNombres = new javax.swing.JRadioButton();
        jrbApellidos = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        txtTodo = new javax.swing.JTextField();
        txtCedula = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnCancelar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(1, 1, 1));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancelar 32 x 32.png"))); // NOI18N
        btnCancelar.setMnemonic('c');
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        btnAceptar.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(1, 1, 1));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Aceptar 32 x 32.png"))); // NOI18N
        btnAceptar.setMnemonic('a');
        btnAceptar.setText("Aceptar");
        btnAceptar.setToolTipText("");
        btnAceptar.setBorder(null);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setPreferredSize(new java.awt.Dimension(123, 44));
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 2, true), "Filtros de busquedas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        buttonGroup1.add(jrbTodo);
        jrbTodo.setSelected(true);
        jrbTodo.setText("Todo");
        jrbTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbCedula);
        jrbCedula.setText("Cedula");
        jrbCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCedulaActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbNombres);
        jrbNombres.setText("Nombres");
        jrbNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNombresActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbApellidos);
        jrbApellidos.setText("Apellidos");
        jrbApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbApellidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jrbTodo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbNombres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbApellidos)
                .addGap(6, 6, 6))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jrbApellidos, jrbCedula, jrbNombres, jrbTodo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbTodo)
                    .addComponent(jrbNombres)
                    .addComponent(jrbApellidos)
                    .addComponent(jrbCedula))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new javax.swing.OverlayLayout(jPanel2));

        txtTodo.setFont(new CustomFont("FreeSans").MyFont(0, 14f));
        txtTodo.setToolTipText("");
        txtTodo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 2, true), "Todo "));
        txtTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTodoActionPerformed(evt);
            }
        });
        jPanel2.add(txtTodo);

        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 2, true), "Cedulas "));
        try {
            txtCedula.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCedula.setFont(new CustomFont("FreeSans").MyFont(0, 14f));
        txtCedula.setPreferredSize(null);
        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        jPanel2.add(txtCedula);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAceptar, btnCancelar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        btnCancelar.setForeground(Color.blue);
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        btnCancelar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseEntered
        btnAceptar.setForeground(Color.BLUE);
    }//GEN-LAST:event_btnAceptarMouseEntered

    private void btnAceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseExited
        btnAceptar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnAceptarMouseExited

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTodoActionPerformed
//      txtApellidos.requestFocusInWindow();
    }//GEN-LAST:event_txtTodoActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        txtTodo.requestFocusInWindow();
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void jrbTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodoActionPerformed
        txtTodo.setText("");
        txtTodo.requestFocusInWindow();
        
        
        jPanel2.removeAll();
        jPanel2.add(txtTodo);
        txtTodo.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(0, 0, 255), 2, true), "Todo ")
        );
        
        txtTodo.requestFocusInWindow();
    }//GEN-LAST:event_jrbTodoActionPerformed

    private void jrbNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNombresActionPerformed
        txtTodo.setText("");
        txtTodo.requestFocusInWindow();
        
        jPanel2.removeAll();
        jPanel2.add(txtTodo);
        txtTodo.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(0, 0, 255), 2, true), "Nombres ")
        );
        
        txtTodo.requestFocusInWindow();
    }//GEN-LAST:event_jrbNombresActionPerformed

    private void jrbCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCedulaActionPerformed
        txtCedula.setValue(null);
        txtCedula.requestFocusInWindow();
        
        jPanel2.removeAll();
        jPanel2.add(txtCedula);
        txtCedula.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(0, 0, 255), 2, true), "Cedulas ")
        );
        
        txtCedula.requestFocusInWindow();
    }//GEN-LAST:event_jrbCedulaActionPerformed

    private void jrbApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbApellidosActionPerformed
        txtTodo.setText("");
        txtTodo.requestFocusInWindow();
        
        
        jPanel2.removeAll();
        jPanel2.add(txtTodo);
        txtTodo.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(
                        new java.awt.Color(0, 0, 255), 2, true), "Apellidos ")
        );
        
        txtTodo.requestFocusInWindow();
    }//GEN-LAST:event_jrbApellidosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jrbApellidos;
    private javax.swing.JRadioButton jrbCedula;
    private javax.swing.JRadioButton jrbNombres;
    private javax.swing.JRadioButton jrbTodo;
    private javax.swing.JFormattedTextField txtCedula;
    private javax.swing.JTextField txtTodo;
    // End of variables declaration//GEN-END:variables
}
