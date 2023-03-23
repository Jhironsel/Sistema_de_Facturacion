package sur.softsurena.formularios;

public class frmCategoriasAdmin extends javax.swing.JFrame {
    private static Boolean aceptar;

    public Boolean getAceptar() {
        return aceptar;
    }

    public void setAceptar(Boolean aceptar) {
        this.aceptar = aceptar;
    }
    
    public frmCategoriasAdmin(String categoria, Boolean estado, boolean nuevo) {
        initComponents();
        txtCategoria.setText(categoria);
        jcbEstado.setSelected(estado);
        jcbEstadoActionPerformed(null);
        if(nuevo){
            jlTitulo.setText("Agregar categoria");
            setTitle("Agregando categoria");
        }else{
            jlTitulo.setText("Modificar categoria");
            setTitle("Modificando categoria");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JCheckBox();
        txtCategoria = new javax.swing.JTextField();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        btnGrabar = new newscomponents.RSButtonGradientIcon_new();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jlTitulo.setFont(new java.awt.Font("FreeMono", 1, 24)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Modificar Categoria");

        jLabel2.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        jLabel2.setText("Nombre Categoria: ");

        jcbEstado.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        jcbEstado.setText("Inactivo");
        jcbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEstadoActionPerformed(evt);
            }
        });

        txtCategoria.setFont(new java.awt.Font("FreeMono", 0, 18)); // NOI18N
        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cacnelar");
        btnCancelar.setColorPrimario(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 51, 51));
        btnCancelar.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGrabar.setText("Continuar");
        btnGrabar.setFont(new java.awt.Font("FreeMono", 1, 18)); // NOI18N
        btnGrabar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnGrabar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ARROW_FORWARD);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoria)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEstado)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstado))
                .addGap(6, 6, 6)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEstadoActionPerformed
        if(jcbEstado.isSelected()){
            jcbEstado.setText("Activo");
        }else{
            jcbEstado.setText("Inactivo");
        }
    }//GEN-LAST:event_jcbEstadoActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        btnGrabarActionPerformed(evt);
    }//GEN-LAST:event_txtCategoriaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
        setAceptar(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        dispose();
        setAceptar(true);
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        setAceptar(false);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnGrabar;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JCheckBox jcbEstado;
    private javax.swing.JLabel jlTitulo;
    public javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
