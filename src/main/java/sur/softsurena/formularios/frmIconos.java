package sur.softsurena.formularios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JFrame;
import rojeru_san.efectos.ValoresEnum.ICONS;

public class frmIconos extends javax.swing.JFrame {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    public frmIconos() {

//        initComponents();
        //getClass().getResource("/sur/softsurena/properties/propiedades.properties").toURI()
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 2147483647));
        setMinimumSize(new java.awt.Dimension(500, 500));
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

        jspListaComponente = new javax.swing.JScrollPane();
        jpListaComponente = new javax.swing.JPanel();
        jpComponente = new javax.swing.JPanel();
        jlLetra = new rojeru_san.rslabel.RSLabelSombra();
        jcpCajeBotones = new javax.swing.JScrollPane();
        jpCajaBotones = new javax.swing.JPanel();

        jpCajaBotones.setLayout(new java.awt.GridLayout(-1, 3, 10, 10));
        jpListaComponente.setLayout(new java.awt.GridLayout(0, 1));

        

        

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Integer cantidadIcono = 0;
                jlLetra.setText("A " + cantidadIcono);
                jlLetra.setFont(new java.awt.Font("Arial", 2, 50));
                
                String letra = "A";
                for (ICONS iconos : rojeru_san.efectos.ValoresEnum.ICONS.values()) {
                    if (iconos.name().startsWith(letra)) {
                        btns = new RSMaterialComponent.RSButtonMaterialIconOne();
                        btns.setIcons(iconos);
                        btns.setText(iconos.name());
                        btns.setMaximumSize(new java.awt.Dimension(200, 60));
                        btns.setMinimumSize(new java.awt.Dimension(200, 40));
                        btns.setPadding(10);

                        jpCajaBotones.add(btns);

                        cantidadIcono++;
                        jlLetra.setText(letra + " " + cantidadIcono);
                    } else {

                        cantidadIcono++;
                        jlLetra.setText(letra + " " + cantidadIcono);

                        btns = new RSMaterialComponent.RSButtonMaterialIconOne();
                        btns.setIcons(iconos);
                        btns.setText(iconos.name());
                        btns.setMaximumSize(new java.awt.Dimension(200, 60));
                        btns.setMinimumSize(new java.awt.Dimension(200, 40));
                        btns.setPadding(10);

                        jpCajaBotones.add(btns);

                        jcpCajeBotones.setViewportView(jpCajaBotones);

                        javax.swing.GroupLayout jpComponenteLayout = new javax.swing.GroupLayout(jpComponente);
                        jpComponente.setLayout(jpComponenteLayout);
                        jpComponenteLayout.setHorizontalGroup(
                                jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpComponenteLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jlLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jpComponenteLayout.createSequentialGroup()
                                                                .addComponent(jcpCajeBotones)
                                                                .addGap(2, 2, 2)))
                                                .addContainerGap())
                        );
                        jpComponenteLayout.setVerticalGroup(
                                jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpComponenteLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jlLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jcpCajeBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                                                .addContainerGap())
                        );

                        jpListaComponente.add(jpComponente);

                        jspListaComponente.setViewportView(jpListaComponente);

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jspListaComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jspListaComponente)
                                                .addContainerGap())
                        );

                        jpCajaBotones = new javax.swing.JPanel();

                        jpCajaBotones.setLayout(new java.awt.GridLayout(-1, 3, 10, 10));

                        jpComponente = new javax.swing.JPanel();

                        jcpCajeBotones = new javax.swing.JScrollPane();

                        jlLetra = new rojeru_san.rslabel.RSLabelSombra();
                        jlLetra.setFont(new java.awt.Font("Arial", 2, 70));

                        cantidadIcono = 0;

                        letra = "" + iconos.name().charAt(0);
                    }
                }
            }
        });

        pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jspListaComponente = new javax.swing.JScrollPane();
        jpListaComponente = new javax.swing.JPanel();
        jpComponente = new javax.swing.JPanel();
        jlLetra = new rojeru_san.rslabel.RSLabelSombra();
        jcpCajeBotones = new javax.swing.JScrollPane();
        jpCajaBotones = new javax.swing.JPanel();
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
        jpComponente1 = new javax.swing.JPanel();
        jlLetra1 = new rojeru_san.rslabel.RSLabelSombra();
        jcpCajeBotones1 = new javax.swing.JScrollPane();
        jpCajaBotones1 = new javax.swing.JPanel();
        btns1 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns27 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns28 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns29 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns30 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns31 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns32 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns33 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns34 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns35 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns36 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns37 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns38 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns39 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns40 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns41 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns42 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns43 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns44 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns45 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns46 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns47 = new RSMaterialComponent.RSButtonMaterialIconOne();
        btns48 = new RSMaterialComponent.RSButtonMaterialIconOne();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 2147483647));
        setMinimumSize(new java.awt.Dimension(500, 500));

        jspListaComponente.setDoubleBuffered(true);

        jpListaComponente.setLayout(new java.awt.GridLayout(0, 1));

        jlLetra.setText("A");
        jlLetra.setDoubleBuffered(true);
        jlLetra.setFont(new java.awt.Font("Arial", 2, 70)); // NOI18N

        jcpCajeBotones.setDoubleBuffered(true);

        jpCajaBotones.setLayout(new java.awt.GridLayout(-1, 4, 10, 10));

        btns.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.AV_TIMER);
        btns.setMaximumSize(new java.awt.Dimension(200, 60));
        btns.setMinimumSize(new java.awt.Dimension(200, 40));
        btns.setPadding(10);
        jpCajaBotones.add(btns);

        btns5.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns5);

        btns6.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns6);

        btns7.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns7);

        btns8.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns8);

        btns9.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns9);

        btns10.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns10);

        btns11.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns11);

        btns12.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns12);

        btns13.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns13);

        btns14.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns14);

        btns15.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns15);

        btns16.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns16);

        btns17.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns17);

        btns18.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns18);

        btns19.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns19);

        btns20.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns20);

        btns21.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns21);

        btns22.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns22);

        btns23.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns23);

        btns24.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns24);

        btns25.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns25);

        btns26.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones.add(btns26);

        jcpCajeBotones.setViewportView(jpCajaBotones);

        javax.swing.GroupLayout jpComponenteLayout = new javax.swing.GroupLayout(jpComponente);
        jpComponente.setLayout(jpComponenteLayout);
        jpComponenteLayout.setHorizontalGroup(
            jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComponenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLetra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpComponenteLayout.createSequentialGroup()
                        .addComponent(jcpCajeBotones)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jpComponenteLayout.setVerticalGroup(
            jpComponenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComponenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcpCajeBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpListaComponente.add(jpComponente);

        jlLetra1.setText("B");
        jlLetra1.setFont(new java.awt.Font("Arial", 2, 70)); // NOI18N

        jpCajaBotones1.setLayout(new java.awt.GridLayout(-1, 4, 10, 10));

        btns1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns1);

        btns27.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns27);

        btns28.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns28);

        btns29.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns29);

        btns30.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns30);

        btns31.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns31);

        btns32.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns32);

        btns33.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns33);

        btns34.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns34);

        btns35.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns35);

        btns36.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns36);

        btns37.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns37);

        btns38.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns38);

        btns39.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns39);

        btns40.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns40);

        btns41.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns41);

        btns42.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns42);

        btns43.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns43);

        btns44.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns44);

        btns45.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns45);

        btns46.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns46);

        btns47.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns47);

        btns48.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EXTENSION);
        jpCajaBotones1.add(btns48);

        jcpCajeBotones1.setViewportView(jpCajaBotones1);

        javax.swing.GroupLayout jpComponente1Layout = new javax.swing.GroupLayout(jpComponente1);
        jpComponente1.setLayout(jpComponente1Layout);
        jpComponente1Layout.setHorizontalGroup(
            jpComponente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComponente1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpComponente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlLetra1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpComponente1Layout.createSequentialGroup()
                        .addComponent(jcpCajeBotones1)
                        .addGap(2, 2, 2)))
                .addContainerGap())
        );
        jpComponente1Layout.setVerticalGroup(
            jpComponente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpComponente1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlLetra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcpCajeBotones1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpListaComponente.add(jpComponente1);

        jspListaComponente.setViewportView(jpListaComponente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListaComponente, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspListaComponente)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param args
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmIconos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btns;
    private RSMaterialComponent.RSButtonMaterialIconOne btns1;
    private RSMaterialComponent.RSButtonMaterialIconOne btns10;
    private RSMaterialComponent.RSButtonMaterialIconOne btns11;
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
    private RSMaterialComponent.RSButtonMaterialIconOne btns27;
    private RSMaterialComponent.RSButtonMaterialIconOne btns28;
    private RSMaterialComponent.RSButtonMaterialIconOne btns29;
    private RSMaterialComponent.RSButtonMaterialIconOne btns30;
    private RSMaterialComponent.RSButtonMaterialIconOne btns31;
    private RSMaterialComponent.RSButtonMaterialIconOne btns32;
    private RSMaterialComponent.RSButtonMaterialIconOne btns33;
    private RSMaterialComponent.RSButtonMaterialIconOne btns34;
    private RSMaterialComponent.RSButtonMaterialIconOne btns35;
    private RSMaterialComponent.RSButtonMaterialIconOne btns36;
    private RSMaterialComponent.RSButtonMaterialIconOne btns37;
    private RSMaterialComponent.RSButtonMaterialIconOne btns38;
    private RSMaterialComponent.RSButtonMaterialIconOne btns39;
    private RSMaterialComponent.RSButtonMaterialIconOne btns40;
    private RSMaterialComponent.RSButtonMaterialIconOne btns41;
    private RSMaterialComponent.RSButtonMaterialIconOne btns42;
    private RSMaterialComponent.RSButtonMaterialIconOne btns43;
    private RSMaterialComponent.RSButtonMaterialIconOne btns44;
    private RSMaterialComponent.RSButtonMaterialIconOne btns45;
    private RSMaterialComponent.RSButtonMaterialIconOne btns46;
    private RSMaterialComponent.RSButtonMaterialIconOne btns47;
    private RSMaterialComponent.RSButtonMaterialIconOne btns48;
    private RSMaterialComponent.RSButtonMaterialIconOne btns5;
    private RSMaterialComponent.RSButtonMaterialIconOne btns6;
    private RSMaterialComponent.RSButtonMaterialIconOne btns7;
    private RSMaterialComponent.RSButtonMaterialIconOne btns8;
    private RSMaterialComponent.RSButtonMaterialIconOne btns9;
    private javax.swing.JScrollPane jcpCajeBotones;
    private javax.swing.JScrollPane jcpCajeBotones1;
    private rojeru_san.rslabel.RSLabelSombra jlLetra;
    private rojeru_san.rslabel.RSLabelSombra jlLetra1;
    private javax.swing.JPanel jpCajaBotones;
    private javax.swing.JPanel jpCajaBotones1;
    private javax.swing.JPanel jpComponente;
    private javax.swing.JPanel jpComponente1;
    private javax.swing.JPanel jpListaComponente;
    private javax.swing.JScrollPane jspListaComponente;
    // End of variables declaration//GEN-END:variables
}
