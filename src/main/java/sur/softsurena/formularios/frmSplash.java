package sur.softsurena.formularios;

import sur.softsurena.swingWorker.Trabajo;


public class frmSplash extends javax.swing.JFrame {

    private final Trabajo miTrabajo;

    public frmSplash() {
        initComponents();
        miTrabajo = new Trabajo();
        miTrabajo.execute();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pgProceso = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setFocusable(false);
        setFocusableWindowState(false);
        setMaximumSize(new java.awt.Dimension(800, 550));
        setMinimumSize(new java.awt.Dimension(800, 550));
        setModalExclusionType(null);
        setUndecorated(true);
        setOpacity(0.5F);
        setPreferredSize(new java.awt.Dimension(800, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 550));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        pgProceso.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        pgProceso.setBorderPainted(false);
        pgProceso.setDoubleBuffered(true);
        pgProceso.setStringPainted(true);
        pgProceso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pgProcesoStateChanged(evt);
            }
        });
        getContentPane().add(pgProceso);
        pgProceso.setBounds(0, 470, 800, 50);

        jLabel1.setForeground(new java.awt.Color(238, 238, 238));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/giphy.gif"))); // NOI18N
        jLabel1.setToolTipText("Cargando el sistema");
        jLabel1.setDoubleBuffered(true);
        jLabel1.setMaximumSize(new java.awt.Dimension(800, 550));
        jLabel1.setMinimumSize(new java.awt.Dimension(800, 550));
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 550));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 550);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pgProcesoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pgProcesoStateChanged
        if (pgProceso.getValue() == 100) {
            dispose();
        }
    }//GEN-LAST:event_pgProcesoStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JProgressBar pgProceso;
    // End of variables declaration//GEN-END:variables
}
