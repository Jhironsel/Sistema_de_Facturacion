package sur.softsurena.formularios;

import java.awt.Color;
import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Factura;
import sur.softsurena.entidades.HeaderFactura;
import static sur.softsurena.metodos.M_Factura.agregarFacturaNombre;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;

public class frmPonerTemporal extends java.awt.Dialog {

    private String nombreCliente, userName;
    private Integer idFactura, idCliente, idTurno;
    private DefaultTableModel miTabla;
    private Factura facturas;
    private final DefaultTableCellRenderer tcr;

    public frmPonerTemporal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtTotalValor = new RSMaterialComponent.RSTextFieldIconOne();
        txtCliente = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btnGrabar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetalle = new rojeru_san.complementos.TableMetro();

        setBackground(new java.awt.Color(60, 63, 65));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de la Factura"));

        txtTotalValor.setPlaceholder("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(361, Short.MAX_VALUE)
                .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(txtTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        txtCliente.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        txtCliente.setPlaceholder("Ingrese nombre del cliente");

        btnGrabar.setText("Aceptar");
        btnGrabar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK);
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(214, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);

        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblDetalle);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tblDetalle.setModel(miTabla);
        tblDetalle.setRowSelectionInterval(miTabla.getRowCount() - 1, miTabla.getRowCount() - 1);
        repararRegistro2();
        totales();
        txtCliente.setText(nombreCliente);
    }//GEN-LAST:event_formWindowOpened

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        HeaderFactura hf = HeaderFactura.builder().
                id_persona(idCliente).
                idTurno(idTurno).
                estadoFactura('t').
                userName(userName)//.
                //nombreTemp(nombreCliente)
                .build();
                
        Factura f = Factura.builder().id(idFactura).headerFactura(hf).build();
        
        if (agregarFacturaNombre(f).getId() < 1) {
            JOptionPane.showMessageDialog(
                    this, 
                    "Esta compra no se ha registrado...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        } else {
            for (int i = 0; i < facturas.getDetalleFactura().size(); i++) {
                
//                if (agregarDetalleFactura(f) == -1) {
//                    borrarFactura(idFactura);
//                    JOptionPane.showMessageDialog(
//                            this, 
//                            "Esta compra no se ha registrado...",
//                            "",
//                            JOptionPane.ERROR_MESSAGE
//                    );
//                    return;
//                }
            }
        }
        setVisible(false);
    }//GEN-LAST:event_btnGrabarActionPerformed

    //--------------------------------------------------------------------------
    public void repararRegistro2() {
        TableColumn miTableColumn;
        int[] columWidth = {80, 200, 15};
        
        for (int i = 0; i < columWidth.length; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            miTableColumn.setPreferredWidth(columWidth[i]);
        }
        
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tcr.setFont(new java.awt.Font("Tahoma", 50, 80));
        tcr.setBackground(Color.yellow);
        tblDetalle.getColumnModel().getColumn(2).setCellRenderer(tcr);
    }

    //--------------------------------------------------------------------------
    private void totales() {
        int num = tblDetalle.getRowCount();
        BigDecimal sumVal = BigDecimal.ZERO;
        
        for (int i = 0; i < num; i++) {
            sumVal = sumVal.add(new BigDecimal(tblDetalle.getValueAt(i, 2).toString()));
        }
        
        txtTotalValor.setText("RD$" + sumVal);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGrabar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.TableMetro tblDetalle;
    private RSMaterialComponent.RSTextFieldMaterialIcon txtCliente;
    private RSMaterialComponent.RSTextFieldIconOne txtTotalValor;
    // End of variables declaration//GEN-END:variables
}
