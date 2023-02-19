package sur.softsurena.formularios;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Cajeros;
import sur.softsurena.entidades.Turnos;
import static sur.softsurena.entidades.Turnos.cerrarTurno;
import static sur.softsurena.entidades.Turnos.habilitarTurno;
import static sur.softsurena.entidades.Turnos.usuarioTurnoActivo;
import sur.softsurena.entidades.Usuarios;
import sur.softsurena.hilos.hiloImpresionFactura;

/**
 *
 * @author jhironsel
 */
public class frmAdministradorTurnos extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmAdministradorTurnos.class.getName());
    
    private static final String PROCESO_DE_VALIDACION_DE_USUARIO = "Proceso de validación de usuario.";
    public frmAdministradorTurnos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jtbCajerosDisponible = new RSMaterialComponent.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbTurnosActivos = new RSMaterialComponent.RSTableMetro();
        rSLabelAnimated1 = new rojeru_san.rslabel.RSLabelAnimated();
        btnCerrarTurno = new newscomponents.RSButtonGradientIcon_new();
        btnAbrirTurno = new newscomponents.RSButtonGradientIcon_new();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbReporteTurnos = new RSMaterialComponent.RSTableMetro();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        btnActualizarCajerosDisponibles = new newscomponents.RSButtonGradientIcon_new();
        btnActualizarTurnosActivos = new newscomponents.RSButtonGradientIcon_new();
        btnImprimirReporte = new newscomponents.RSButtonGradientIcon_new();

        setClosable(true);
        setForeground(new java.awt.Color(102, 102, 255));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modulo de Administración de turnos");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jtbCajerosDisponible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Cajeros Disponibles"
            }
        ));
        jtbCajerosDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCajerosDisponibleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jtbCajerosDisponible);

        jtbTurnosActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Turnos activos"
            }
        ));
        jScrollPane4.setViewportView(jtbTurnosActivos);

        rSLabelAnimated1.setText("Administración de turnos");
        rSLabelAnimated1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        btnCerrarTurno.setText("Cerrar Turno");
        btnCerrarTurno.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarTurnoActionPerformed(evt);
            }
        });

        btnAbrirTurno.setText("Abrir Turno");
        btnAbrirTurno.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.OPEN_IN_NEW);
        btnAbrirTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirTurnoActionPerformed(evt);
            }
        });

        jtbReporteTurnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "# ID", "Cajero", "Fecha Hora Inicio", "Estado", "Creador Turno", "Monto facturado", "Monto Devuelto", "Monto Efectivo", "Monto Credito"
            }
        ));
        jtbReporteTurnos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbReporteTurnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtbReporteTurnos);

        rSLabelTextIcon1.setForeground(new java.awt.Color(0, 112, 192));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Reporte de cajeros");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EQUALIZER);

        btnActualizarCajerosDisponibles.setToolTipText("Actualizar Lista");
        btnActualizarCajerosDisponibles.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizarCajerosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCajerosDisponiblesActionPerformed(evt);
            }
        });

        btnActualizarTurnosActivos.setToolTipText("Actualizar Lista");
        btnActualizarTurnosActivos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizarTurnosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTurnosActivosActionPerformed(evt);
            }
        });

        btnImprimirReporte.setText("Imprimir reporte");
        btnImprimirReporte.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAbrirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAbrirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCerrarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirTurnoActionPerformed
        String userName = ((Usuarios) jtbCajerosDisponible.getValueAt(jtbCajerosDisponible.getSelectedRow(), 0)).getUser_name();

        //Si el objeto idUsuario es igual a N/A, retornar y mandar mensaje de error.
        if (userName.equals("N/A")) {
            JOptionPane.showMessageDialog(null,
                    "Debe Seleccionar un Usuario",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        //Verificamos si el usuario tiene turno abierto
        if (usuarioTurnoActivo(userName)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Usuario con Turno Abierto...",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        //Si el usuario no tiene turno abierto, procedemos habilitar turno.
        if (habilitarTurno(userName)) {
            JOptionPane.showMessageDialog(null, "Turno Habilitado");
        } else {
            JOptionPane.showMessageDialog(null, "Problema para habilitar el Turno");
        }
    }//GEN-LAST:event_btnAbrirTurnoActionPerformed

    private void btnCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTurnoActionPerformed
        String userName = ((Usuarios) jtbCajerosDisponible.getValueAt(jtbCajerosDisponible.getSelectedRow(), 0)).getUser_name();

        if (!usuarioTurnoActivo(userName)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Usuario sin Turno Abierto...",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

//        setIdTurno(idTurnoActivo(userName));

        if (cerrarTurno(userName)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Turno Cerrado",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Problema para cerrar Turno",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.ERROR_MESSAGE
            );
        }

        imprimirReporte(((Cajeros) jtbTurnosActivos.getValueAt(jtbTurnosActivos.getSelectedRow(), 0)).getUser_name());
    }//GEN-LAST:event_btnCerrarTurnoActionPerformed

    private void btnActualizarCajerosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCajerosDisponiblesActionPerformed
        String[] columnas = {"Cajeros Disponibles"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        Object[] rowData = new Object[columnas.length];
        
        Cajeros.getCajerosDisponible().stream().forEach(cajero -> {
            rowData[0] = cajero;
            modelo.addRow(rowData);
        });
        
        jtbCajerosDisponible.setModel(modelo);
    }//GEN-LAST:event_btnActualizarCajerosDisponiblesActionPerformed

    private void btnActualizarTurnosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTurnosActivosActionPerformed
        String[] columnas2 = {"ID Turno", "Nombre Usuario", "Fecha de inicio"};
        DefaultTableModel modelo2 = new DefaultTableModel(null, columnas2);
        Object[] rowData2 = new Object[columnas2.length];
        
        Turnos.getTurnosActivos().forEach(turno ->{
            rowData2[0] = turno.getId();
            rowData2[1] = turno.getTurno_usuario();
            rowData2[2] = turno.getFecha_hora_inicio();
            
            modelo2.addRow(rowData2);
        });
        
        jtbTurnosActivos.setModel(modelo2);
    }//GEN-LAST:event_btnActualizarTurnosActivosActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //1)Necesitamos los cajeros disponibles del sistema.
        btnActualizarCajerosDisponiblesActionPerformed(null);
        
        //2)Necesitamos los cajeros activos.
        btnActualizarTurnosActivosActionPerformed(null);
        
        if(jtbCajerosDisponible.getRowCount() > 0){
            jtbCajerosDisponible.setRowSelectionInterval(0, 0);
        }
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void jtbCajerosDisponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCajerosDisponibleMouseClicked
        if(jtbCajerosDisponible.getRowCount() <= 0){
            return;
        }
        
        String userName = ((Usuarios) jtbCajerosDisponible.getValueAt(jtbCajerosDisponible.getSelectedRow(), 0)).getUser_name();
        
        String[] columnas2 = {"ID Turno", "Fecha de inicio","Fecha final", 
        "Monto Facturado", "Monto Devuelto", "Monto efectivo "};
        DefaultTableModel modelo2 = new DefaultTableModel(null, columnas2);
        Object[] rowData2 = new Object[columnas2.length];
        
        Turnos.getTurnosByUserName(userName).stream().forEach(turnos ->{
            rowData2[0] = turnos.getId();
            rowData2[1] = turnos.getFecha_hora_inicio();
            rowData2[2] = turnos.getFecha_hora_final();
            rowData2[3] = turnos.getMonto_facturado();
            rowData2[4] = turnos.getMonto_devuelto();
            rowData2[5] = turnos.getMonto_efectivo();
            rowData2[6] = turnos.getMonto_credito();
            modelo2.addRow(rowData2);
        });
        jtbReporteTurnos.setModel(modelo2);
    }//GEN-LAST:event_jtbCajerosDisponibleMouseClicked

    private void btnImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirReporteActionPerformed
        
    }//GEN-LAST:event_btnImprimirReporteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAbrirTurno;
    private newscomponents.RSButtonGradientIcon_new btnActualizarCajerosDisponibles;
    private newscomponents.RSButtonGradientIcon_new btnActualizarTurnosActivos;
    private newscomponents.RSButtonGradientIcon_new btnCerrarTurno;
    private newscomponents.RSButtonGradientIcon_new btnImprimirReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private RSMaterialComponent.RSTableMetro jtbCajerosDisponible;
    private RSMaterialComponent.RSTableMetro jtbReporteTurnos;
    private RSMaterialComponent.RSTableMetro jtbTurnosActivos;
    private rojeru_san.rslabel.RSLabelAnimated rSLabelAnimated1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    // End of variables declaration//GEN-END:variables

    private void imprimirReporte(String user_name) {
        Map parametros = new HashMap();
//        parametros.put("idTurno", getIdTurno());
//        parametros.put("idUsuario", nombreUsuario);

        hiloImpresionFactura miHilo = new hiloImpresionFactura(
                true,//Mostrar Reporte
                false,//Con Copia
                "/Reportes/reporteCuadre.jasper",
                parametros,
                frmPrincipal.jPanelImpresion,
                frmPrincipal.jprImpresion);

        miHilo.start();
    }
}
