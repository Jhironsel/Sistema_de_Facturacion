package sur.softsurena.formularios;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSComboBox;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.Usuario;
import static sur.softsurena.metodos.M_Almacen.getAlmacenesList;
import static sur.softsurena.metodos.M_Cajero.getCajeros;
import static sur.softsurena.metodos.M_Turno.cerrarTurno;
import static sur.softsurena.metodos.M_Turno.getTurnosActivos;
import static sur.softsurena.metodos.M_Turno.getTurnosByUserName;
import static sur.softsurena.metodos.M_Turno.habilitarTurno;
import static sur.softsurena.metodos.M_Turno.usuarioTurnoActivo;
import sur.softsurena.utilidades.Resultado;
import sur.softsurena.utilidades.Utilidades;

/**
 * @author jhironsel
 */
public class frmAdministradorTurnos extends javax.swing.JInternalFrame {

    public static frmAdministradorTurnos getInstance() {
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmAdministradorTurnos INSTANCE = new frmAdministradorTurnos();
    }

    private frmAdministradorTurnos() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelAnimated1 = new rojeru_san.rslabel.RSLabelAnimated();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCajerosDisponible = new RSMaterialComponent.RSTableMetro();
        btnActualizarCajerosDisponibles = new newscomponents.RSButtonGradientIcon_new();
        btnAbrirTurno = new newscomponents.RSButtonGradientIcon_new();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        rSPanelGradiente1 = new rojeru_san.rspanel.RSPanelGradiente();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTurnosActivos = new RSMaterialComponent.RSTableMetro();
        btnActualizarTurnosActivos = new newscomponents.RSButtonGradientIcon_new();
        btnCerrarTurno = new newscomponents.RSButtonGradientIcon_new();
        rSPanelGradiente2 = new rojeru_san.rspanel.RSPanelGradiente();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteTurnos = new RSMaterialComponent.RSTableMetro();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
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

        rSLabelAnimated1.setText("Administración de turnos");
        rSLabelAnimated1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Cajeros Disponibles"));

        tblCajerosDisponible.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCajerosDisponible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCajerosDisponibleMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCajerosDisponible);

        btnActualizarCajerosDisponibles.setToolTipText("Actualizar Lista");
        btnActualizarCajerosDisponibles.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizarCajerosDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarCajerosDisponiblesActionPerformed(evt);
            }
        });

        btnAbrirTurno.setText("Abrir Turno");
        btnAbrirTurno.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.OPEN_IN_NEW);
        btnAbrirTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirTurnoActionPerformed(evt);
            }
        });

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Turnos Activos"));

        tblTurnosActivos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTurnosActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurnosActivosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblTurnosActivos);

        btnActualizarTurnosActivos.setToolTipText("Actualizar Lista");
        btnActualizarTurnosActivos.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.REFRESH);
        btnActualizarTurnosActivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarTurnosActivosActionPerformed(evt);
            }
        });

        btnCerrarTurno.setText("Cerrar Turno");
        btnCerrarTurno.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CLOSE);
        btnCerrarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarTurnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente1Layout = new javax.swing.GroupLayout(rSPanelGradiente1);
        rSPanelGradiente1.setLayout(rSPanelGradiente1Layout);
        rSPanelGradiente1Layout.setHorizontalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCerrarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        rSPanelGradiente1Layout.setVerticalGroup(
            rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rSPanelGradiente1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCerrarTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Turnos", rSPanelGradiente1);

        tblReporteTurnos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tblReporteTurnos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblReporteTurnos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblReporteTurnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblReporteTurnos);

        rSLabelTextIcon1.setForeground(new java.awt.Color(0, 112, 192));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Reporte de cajeros");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EQUALIZER);

        btnImprimirReporte.setText("Imprimir reporte");
        btnImprimirReporte.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.PRINT);
        btnImprimirReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rSPanelGradiente2Layout = new javax.swing.GroupLayout(rSPanelGradiente2);
        rSPanelGradiente2.setLayout(rSPanelGradiente2Layout);
        rSPanelGradiente2Layout.setHorizontalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelGradiente2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        rSPanelGradiente2Layout.setVerticalGroup(
            rSPanelGradiente2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelGradiente2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Reportes", rSPanelGradiente2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAbrirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAbrirTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirTurnoActionPerformed
        //Obtenemos el cliente seleccionado
        int userSelected = tblCajerosDisponible.getSelectedRow();

        //Validamos que se haya seleccionado un cajero.
        if (userSelected < 0) {
            //En dado caso mostramos el siguiente mensaje.
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un cajero",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Obtenemos el cajero seleccionado.
        String userName = ((Usuario) tblCajerosDisponible.getValueAt(
                userSelected, 0)).getUser_name();

        //Si el objeto idUsuario es igual a N/A.
        if (userName.equals("N/A")) {
            //Mostramos mensaje de error siguiente.
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe Seleccionar un Usuario",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        //Verificamos si el usuario tiene turno abierto
        if (usuarioTurnoActivo(userName)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Usuario cuenta con turno abierto.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        RSComboBox comboAlmacenes = new RSComboBox();

        comboAlmacenes.removeAllItems();

        comboAlmacenes.addItem(
                Almacen
                        .builder()
                        .nombre("Seleccione un almacen.")
                        .id(-1)
                        .build()
        );

        getAlmacenesList(-1, "").stream().forEach(almacen -> {
            comboAlmacenes.addItem(almacen);
        });

        JOptionPane.showInternalMessageDialog(
                this,
                comboAlmacenes,
                "De que almacen se va a facturar?",
                JOptionPane.QUESTION_MESSAGE
        );

        int id_almacen = ((Almacen) comboAlmacenes.getSelectedItem()).getId();

        if (id_almacen == -1) {
            return;
        }

        Resultado resultado = habilitarTurno(id_almacen, userName);

        //Si el usuario no tiene turno abierto, procedemos habilitar turno.
        JOptionPane.showInternalMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

    }//GEN-LAST:event_btnAbrirTurnoActionPerformed

    private void btnCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTurnoActionPerformed
        int rowSelected = tblTurnosActivos.getSelectedRow();

        if (rowSelected < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un turno.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Integer idTurno = (Integer) tblTurnosActivos.getValueAt(rowSelected, 0);
        String userName = tblTurnosActivos.getValueAt(rowSelected, 1).toString();

        if (!usuarioTurnoActivo(userName)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Usuario sin Turno Abierto...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

//        setIdTurno(idTurnoActivo(userName));
        if (cerrarTurno(idTurno)) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Turno Cerrado",
                    "",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Problema para cerrar Turno",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        imprimirReporte(idTurno);
    }//GEN-LAST:event_btnCerrarTurnoActionPerformed

    private void btnActualizarCajerosDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarCajerosDisponiblesActionPerformed
        String[] columnas = {"-"};
        DefaultTableModel modelo = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] rowData = new Object[columnas.length];

        getCajeros().stream().forEach(cajero -> {
            rowData[0] = cajero;
            modelo.addRow(rowData);
        });

        tblCajerosDisponible.setModel(modelo);
    }//GEN-LAST:event_btnActualizarCajerosDisponiblesActionPerformed

    private void btnActualizarTurnosActivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarTurnosActivosActionPerformed
        String[] columnas2 = {"ID Turno", "Nombre Usuario", "Fecha de inicio"};
        DefaultTableModel modelo2 = new DefaultTableModel(null, columnas2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Object[] rowData2 = new Object[columnas2.length];

        getTurnosActivos().forEach(turno -> {
            rowData2[0] = turno.getId();
            rowData2[1] = turno.getTurno_usuario();
            rowData2[2] = turno.getFecha_hora_inicio();

            modelo2.addRow(rowData2);
        });

        tblTurnosActivos.setModel(modelo2);
    }//GEN-LAST:event_btnActualizarTurnosActivosActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        //1)Necesitamos los cajeros disponibles del sistema.
        btnActualizarCajerosDisponiblesActionPerformed(null);

        //2)Necesitamos los cajeros activos.
        btnActualizarTurnosActivosActionPerformed(null);

        if (tblCajerosDisponible.getRowCount() > 0) {
            tblCajerosDisponible.setRowSelectionInterval(0, 0);
        }

    }//GEN-LAST:event_formInternalFrameOpened

    private void tblCajerosDisponibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCajerosDisponibleMouseClicked

        if (tblCajerosDisponible.getRowCount() <= 0) {
            return;
        }
        int cajeroSelectRow = tblCajerosDisponible.getSelectedRow();

        String userName = ((Usuario) tblCajerosDisponible.getValueAt(cajeroSelectRow, 0)).getUser_name();

        crearReporte(userName);
    }//GEN-LAST:event_tblCajerosDisponibleMouseClicked

    private void btnImprimirReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirReporteActionPerformed
        int rowSelected = tblReporteTurnos.getSelectedRow();

        if (rowSelected < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe seleccionar un reporte.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Integer idTurno = (Integer) tblReporteTurnos.getValueAt(rowSelected, 0);

        imprimirReporte(idTurno);
    }//GEN-LAST:event_btnImprimirReporteActionPerformed

    private void imprimirReporte(Integer idTurno) {

    }

    private void tblTurnosActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurnosActivosMouseClicked
        if (tblTurnosActivos.getRowCount() <= 0) {
            return;
        }
        int cajeroSelectRow = tblTurnosActivos.getSelectedRow();

        crearReporte(tblTurnosActivos.getValueAt(cajeroSelectRow, 1).toString());
    }//GEN-LAST:event_tblTurnosActivosMouseClicked

//    private void imprimirReporte(Integer idTurno) {
//        Map parametros = new HashMap();
//        parametros.put("idTurno", idTurno);
//
//        hiloImpresionFactura miHilo = new hiloImpresionFactura(
//                true,//Mostrar Reporte
//                false,//Con Copia
//                "reportes/reporteCuadre.jasper",
//                parametros,
//                frmPrincipal.jPanelImpresion,
//                frmPrincipal.jprImpresion);
//
//        miHilo.start();
//    }
    public static JTable crearReporte(String userName) {
        String[] columnas2 = {"ID Turno", "Fecha de inicio", "Fecha final",
            "Monto Facturado", "Monto Devuelto", "Monto efectivo",
            "Monto acredito"};

        DefaultTableModel modelo2 = new DefaultTableModel(null, columnas2) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        var rowData2 = new Object[columnas2.length];

        getTurnosByUserName(userName).stream().forEach(
                turnos -> {
                    rowData2[0] = turnos.getId();
                    rowData2[1] = turnos.getFecha_hora_inicio();
                    rowData2[2] = turnos.getFecha_hora_final();
                    rowData2[3] = turnos.getMonto_facturado();
                    rowData2[4] = turnos.getMonto_devuelto();
                    rowData2[5] = turnos.getMonto_efectivo();
                    rowData2[6] = turnos.getMonto_credito();
                    
                    modelo2.addRow(rowData2);
                }
        );

        tblReporteTurnos.setModel(modelo2);

        Utilidades.repararColumnaTable(tblReporteTurnos);

        return tblReporteTurnos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnAbrirTurno;
    private newscomponents.RSButtonGradientIcon_new btnActualizarCajerosDisponibles;
    private newscomponents.RSButtonGradientIcon_new btnActualizarTurnosActivos;
    private newscomponents.RSButtonGradientIcon_new btnCerrarTurno;
    private newscomponents.RSButtonGradientIcon_new btnImprimirReporte;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private rojeru_san.rslabel.RSLabelAnimated rSLabelAnimated1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente1;
    private rojeru_san.rspanel.RSPanelGradiente rSPanelGradiente2;
    private RSMaterialComponent.RSTableMetro tblCajerosDisponible;
    private static RSMaterialComponent.RSTableMetro tblReporteTurnos;
    private RSMaterialComponent.RSTableMetro tblTurnosActivos;
    // End of variables declaration//GEN-END:variables
}
