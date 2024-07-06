package sur.softsurena.formularios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sur.softsurena.entidades.Factura;
import sur.softsurena.hilos.hiloImpresionFactura;
import static sur.softsurena.metodos.M_Factura.getTemporales;
import sur.softsurena.utilidades.DefaultTableCellHeaderRenderer;

public final class frmBuscarTemporal extends java.awt.Dialog {

    private DefaultTableModel miTabla;
    private boolean aceptar;
    private String factura;
    private final DefaultTableCellRenderer tcr;

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public boolean isAceptar() {
        return aceptar;
    }

    public void setAceptar(boolean aceptar) {
        this.aceptar = aceptar;
    }

    public frmBuscarTemporal(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tcr = new DefaultTableCellHeaderRenderer();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new JTable(){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Las celdas no son editables.
            }
        };
        jPanel1 = new javax.swing.JPanel();
        btnAceptar = new newscomponents.RSButtonGradientIcon_new();
        btnImprimirCuenta = new newscomponents.RSButtonGradientIcon_new();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();

        setMinimumSize(new java.awt.Dimension(668, 258));
        setResizable(false);
        setTitle("Facturas en Temporales");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tblDetalle.setAutoCreateRowSorter(true);
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° Factura", "Nombre Cliente", "Fecha", "Hora", "Cajero", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tblDetalle);

        btnAceptar.setText("Aceptar");
        btnAceptar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DONE);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnImprimirCuenta.setText("Imprimir Cuenta");
        btnImprimirCuenta.setColorPrimario(new java.awt.Color(51, 255, 51));
        btnImprimirCuenta.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirCuentaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 51, 102));
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnImprimirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimirCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        llenarTabla();
    }//GEN-LAST:event_formWindowOpened

    private void btnImprimirCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirCuentaActionPerformed
        //Debe haber una factura selecciona
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "No ha seleccionado Factura",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Creamos un mapa de los valores de la factura, la cual se requiere el 
        //identificador de la factura. 
        Map parametros = new HashMap();

        parametros.put("idFactura", Integer.valueOf(
                miTabla.getValueAt(
                        tblDetalle.getSelectedRow(), 0).toString()));

        hiloImpresionFactura miFactura
                = new hiloImpresionFactura(
                        true, //Mostrar Reporte
                        false, //No se requiere copia del documento
                        "/Reportes/factura.jasper",
                        parametros,
                        frmPrincipal.jPanelImpresion,
                        frmPrincipal.jprImpresion);
        miFactura.start();
    }//GEN-LAST:event_btnImprimirCuentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setAceptar(false);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (tblDetalle.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe selecionar una Factura...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        setAceptar(true);
        setFactura(tblDetalle.getValueAt(tblDetalle.getSelectedRow(), 0).toString());
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    /**
     * Metodo utilizado para llenar las tablas de las facturas que existen en
     * temporal. Actualizado el 05 Junio 2022: nota:
     */
    private void llenarTabla() {
        String titulos[] = {"N° Factura", "Nombre Cliente", "Fecha", "Hora",
            "Cajero", "Monto"};
        miTabla = new DefaultTableModel(null, titulos);
        //Consulta a la base de datos que trae los registros
        List<Factura> temporalesList = getTemporales();
        //Objecto utlizado en la construción de la tabla.
        Object registro[] = new Object[6];

        temporalesList.stream().forEach(
                temporal -> {
                    registro[0] = temporal.getId();

                    if (temporal.getHeaderFactura().getId_persona() == 0) {
                        registro[1] = temporal.getHeaderFactura().getNombreTemporal();
                    } else {
                        registro[1] = temporal.toString();
                    }

                    registro[2] = temporal.getHeaderFactura().getFecha_ingreso();
                    registro[3] = temporal.getHeaderFactura().getUserName();

                    miTabla.addRow(registro);//Se van insertando los registros.

                }
        );
        //Se agrega el modelo a la tabla.
        tblDetalle.setModel(miTabla);
        //Para Alinear el Texto de la Table a la Derecha...
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tblDetalle.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tcr.setHorizontalAlignment(SwingConstants.RIGHT);
        tblDetalle.getColumnModel().getColumn(5).setCellRenderer(tcr);

        //Ordenando las columnas
        TableColumn miTableColumn;
        for (int i = 0; i <= 5; i++) {
            miTableColumn = tblDetalle.getColumnModel().getColumn(i);
            if (i == 0) {
                miTableColumn.setPreferredWidth(170);
            }
            if (i == 1) {
                miTableColumn.setPreferredWidth(400);
            }
            if (i == 2) {
                miTableColumn.setPreferredWidth(150);
            }
            if (i == 3) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 4) {
                miTableColumn.setPreferredWidth(130);
            }
            if (i == 5) {
                miTableColumn.setPreferredWidth(160);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAceptar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnImprimirCuenta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblDetalle;
    // End of variables declaration//GEN-END:variables
}
