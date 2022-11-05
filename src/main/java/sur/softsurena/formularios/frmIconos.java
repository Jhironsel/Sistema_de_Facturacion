package sur.softsurena.formularios;

import RSMaterialComponent.RSButtonMaterialIconOne;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class frmIconos extends javax.swing.JFrame {

    public frmIconos() {
        //initComponents();

        //Variables necesarias
        jScrollPane1 = new javax.swing.JScrollPane();

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1.setViewportView(jPanel1);
        
        jPanel1.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        jlLetra = new rojeru_san.rslabel.RSLabelSombra();
        char letra = 'A';

        jlLetra.setText("A");
        jlLetra.setFont(new java.awt.Font("Arial", 2, 70));


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 2147483647));

        RSButtonMaterialIconOne btns2;
        for (ICONS iconos : ICONS.values()) {
            if (iconos.toString().charAt(0) == jlLetra.getText().charAt(0)) {
                btns2 = new RSButtonMaterialIconOne();
                btns2.setText(iconos.toString());
                btns2.setIcons(iconos);

                jPanel1.add(btns2);

            } else {
                letra++;

                jScrollPane1 = new javax.swing.JScrollPane();

                jPanel1 = new javax.swing.JPanel();
                jPanel1.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
                jScrollPane1.setViewportView(jPanel1);
            }   
        }


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jlLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jlLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlLetra = new rojeru_san.rslabel.RSLabelSombra();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        btns = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns5 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns6 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns7 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns8 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns9 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns10 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns11 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns12 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns13 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns14 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns15 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns16 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns17 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns18 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns19 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns20 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns21 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns22 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns23 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns24 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns25 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns26 = new RSMaterialComponent.RSButtonMaterialIconOne();
        jPanel12 = new javax.swing.JPanel();
        jlLetra5 = new rojeru_san.rslabel.RSLabelSombra();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        btns95 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns96 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns97 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns98 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns99 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns100 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns101 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns102 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns103 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns104 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns105 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns106 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns107 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns108 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns109 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns110 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns111 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns112 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns113 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns114 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns115 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns116 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns117 = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 2147483647));

        jPanel2.setLayout(new java.awt.GridLayout(0, 1));

        jlLetra.setText("A");
        jlLetra.setFont(new java.awt.Font("Arial", 2, 70)); // NOI18N

        jPanel1.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        btns.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns);

        btns5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns5);

        btns6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns6);

        btns7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns7);

        btns8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns8);

        btns9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns9);

        btns10.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns10);

        btns11.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns11);

        btns12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns12);

        btns13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns13);

        btns14.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns14);

        btns15.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns15);

        btns16.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns16);

        btns17.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns17);

        btns18.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns18);

        btns19.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns19);

        btns20.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns20);

        btns21.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns21);

        btns22.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns22);

        btns23.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns23);

        btns24.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns24);

        btns25.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns25);

        btns26.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel1.add(btns26);

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3);

        jlLetra5.setText("A");
        jlLetra5.setFont(new java.awt.Font("Arial", 2, 70)); // NOI18N

        jPanel13.setLayout(new java.awt.GridLayout(0, 3, 10, 10));

        btns95.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns95);

        btns96.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns96);

        btns97.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns97);

        btns98.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns98);

        btns99.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns99);

        btns100.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns100);

        btns101.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns101);

        btns102.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns102);

        btns103.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns103);

        btns104.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns104);

        btns105.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns105);

        btns106.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns106);

        btns107.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns107);

        btns108.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns108);

        btns109.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns109);

        btns110.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns110);

        btns111.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns111);

        btns112.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns112);

        btns113.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns113);

        btns114.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns114);

        btns115.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns115);

        btns116.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns116);

        btns117.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jPanel13.add(btns117);

        jScrollPane7.setViewportView(jPanel13);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLetra5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane7)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLetra5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.add(jPanel12);

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmIconos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmIconos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmIconos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmIconos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmIconos().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btns;
    private RSMaterialComponent.RSButtonMaterialIconOne btns10;
    private RSMaterialComponent.RSButtonMaterialIconOne btns100;
    private RSMaterialComponent.RSButtonMaterialIconOne btns101;
    private RSMaterialComponent.RSButtonMaterialIconOne btns102;
    private RSMaterialComponent.RSButtonMaterialIconOne btns103;
    private RSMaterialComponent.RSButtonMaterialIconOne btns104;
    private RSMaterialComponent.RSButtonMaterialIconOne btns105;
    private RSMaterialComponent.RSButtonMaterialIconOne btns106;
    private RSMaterialComponent.RSButtonMaterialIconOne btns107;
    private RSMaterialComponent.RSButtonMaterialIconOne btns108;
    private RSMaterialComponent.RSButtonMaterialIconOne btns109;
    private RSMaterialComponent.RSButtonMaterialIconOne btns11;
    private RSMaterialComponent.RSButtonMaterialIconOne btns110;
    private RSMaterialComponent.RSButtonMaterialIconOne btns111;
    private RSMaterialComponent.RSButtonMaterialIconOne btns112;
    private RSMaterialComponent.RSButtonMaterialIconOne btns113;
    private RSMaterialComponent.RSButtonMaterialIconOne btns114;
    private RSMaterialComponent.RSButtonMaterialIconOne btns115;
    private RSMaterialComponent.RSButtonMaterialIconOne btns116;
    private RSMaterialComponent.RSButtonMaterialIconOne btns117;
    private RSMaterialComponent.RSButtonMaterialIconOne btns12;
    private RSMaterialComponent.RSButtonMaterialIconOne btns13;
    private RSMaterialComponent.RSButtonMaterialIconOne btns14;
    private RSMaterialComponent.RSButtonMaterialIconOne btns15;
    private RSMaterialComponent.RSButtonMaterialIconOne btns16;
    private RSMaterialComponent.RSButtonMaterialIconOne btns17;
    private RSMaterialComponent.RSButtonMaterialIconOne btns18;
    private RSMaterialComponent.RSButtonMaterialIconOne btns19;
    private RSMaterialComponent.RSButtonMaterialIconOne btns20;
    private RSMaterialComponent.RSButtonMaterialIconOne btns21;
    private RSMaterialComponent.RSButtonMaterialIconOne btns22;
    private RSMaterialComponent.RSButtonMaterialIconOne btns23;
    private RSMaterialComponent.RSButtonMaterialIconOne btns24;
    private RSMaterialComponent.RSButtonMaterialIconOne btns25;
    private RSMaterialComponent.RSButtonMaterialIconOne btns26;
    private RSMaterialComponent.RSButtonMaterialIconOne btns5;
    private RSMaterialComponent.RSButtonMaterialIconOne btns6;
    private RSMaterialComponent.RSButtonMaterialIconOne btns7;
    private RSMaterialComponent.RSButtonMaterialIconOne btns8;
    private RSMaterialComponent.RSButtonMaterialIconOne btns9;
    private RSMaterialComponent.RSButtonMaterialIconOne btns95;
    private RSMaterialComponent.RSButtonMaterialIconOne btns96;
    private RSMaterialComponent.RSButtonMaterialIconOne btns97;
    private RSMaterialComponent.RSButtonMaterialIconOne btns98;
    private RSMaterialComponent.RSButtonMaterialIconOne btns99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane7;
    private rojeru_san.rslabel.RSLabelSombra jlLetra;
    private rojeru_san.rslabel.RSLabelSombra jlLetra5;
    // End of variables declaration//GEN-END:variables
}
