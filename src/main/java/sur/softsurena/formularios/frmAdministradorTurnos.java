package sur.softsurena.formularios;

import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.File;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.modules.gui.base.PreviewFrame;
import org.pentaho.reporting.engine.classic.core.modules.misc.datafactory.sql.SQLReportDataFactory;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import sur.softsurena.conexion.Conexion;
import sur.softsurena.entidades.Cajeros;
import sur.softsurena.entidades.Turnos;
import static sur.softsurena.entidades.Turnos.cerrarTurno;
import static sur.softsurena.entidades.Turnos.habilitarTurno;
import static sur.softsurena.entidades.Turnos.usuarioTurnoActivo;
import sur.softsurena.entidades.Usuario;
import sur.softsurena.utilidades.Utilidades;

/**
 * @author jhironsel
 */
public class frmAdministradorTurnos extends javax.swing.JInternalFrame {

    private static final Logger LOG = Logger.getLogger(frmAdministradorTurnos.class.getName());

    private static final String PROCESO_DE_VALIDACION_DE_USUARIO = "Proceso de validación de usuario.";

    public frmAdministradorTurnos() {
        /*
            Validar si el usuario es un usuario autorizado para manejar este 
        formulario.
         */

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelAnimated1 = new rojeru_san.rslabel.RSLabelAnimated();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCajerosDisponible = new RSMaterialComponent.RSTableMetro();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblTurnosActivos = new RSMaterialComponent.RSTableMetro();
        btnActualizarCajerosDisponibles = new newscomponents.RSButtonGradientIcon_new();
        btnAbrirTurno = new newscomponents.RSButtonGradientIcon_new();
        btnActualizarTurnosActivos = new newscomponents.RSButtonGradientIcon_new();
        btnCerrarTurno = new newscomponents.RSButtonGradientIcon_new();
        rSLabelTextIcon1 = new RSMaterialComponent.RSLabelTextIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteTurnos = new RSMaterialComponent.RSTableMetro();
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

        rSLabelTextIcon1.setForeground(new java.awt.Color(0, 112, 192));
        rSLabelTextIcon1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSLabelTextIcon1.setText("Reporte de cajeros");
        rSLabelTextIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EQUALIZER);

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
        tblReporteTurnos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblReporteTurnos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblReporteTurnos);

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAbrirTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 275, Short.MAX_VALUE)
                                .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCerrarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizarTurnosActivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrarTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSLabelTextIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAbrirTurno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnActualizarCajerosDisponibles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnImprimirReporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    null,
                    "Debe seleccionar un cajero",
                    "Proceso de creacion de turno.",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        //Obtenemos el cajero seleccionado.
        String userName = ((Usuario) tblCajerosDisponible.getValueAt(
                userSelected, 0)).getUser_name();

        //Si el objeto idUsuario es igual a N/A.
        if (userName.equals("N/A")) {
            //Mostramos mensaje de error siguiente.
            JOptionPane.showMessageDialog(
                    null,
                    "Debe Seleccionar un Usuario",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.WARNING_MESSAGE
            );
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
            JOptionPane.showMessageDialog(
                    null,
                    "Turno Habilitado"
            );
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Problema para habilitar el Turno");
        }
    }//GEN-LAST:event_btnAbrirTurnoActionPerformed

    private void btnCerrarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarTurnoActionPerformed
        int rowSelected = tblTurnosActivos.getSelectedRow();

        if (rowSelected < 0) {
            JOptionPane.showInternalMessageDialog(
                    null,
                    "Debe seleccionar un turno.",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Integer idTurno = (Integer) tblTurnosActivos.getValueAt(rowSelected, 0);
        String userName = tblTurnosActivos.getValueAt(rowSelected, 1).toString();

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
        if (cerrarTurno(idTurno)) {
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

        System.out.println("Reporte: " + idTurno);

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

        Cajeros.getCajeros().stream().forEach(cajero -> {
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

        Turnos.getTurnosActivos().forEach(turno -> {
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
                    null,
                    "Debe seleccionar un reporte.",
                    PROCESO_DE_VALIDACION_DE_USUARIO,
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        Integer idTurno = (Integer) tblReporteTurnos.getValueAt(rowSelected, 0);
        
        imprimirReporte(idTurno);
    }//GEN-LAST:event_btnImprimirReporteActionPerformed
    private static final String REPORTE_CORTO_PATH 
            = "reportes/ReporteCorto.prpt";
    
    private static final String SQL_REPORTE_CORTO
            = "SELECT TURNO_USUARIO, FECHA_HORA_INICIO, FECHA_HORA_FINAL, "
            + "     ESTADO, MONTO_FACTURADO, MONTO_DEVUELTO, MONTO_EFECTIVO, "
            + "     MONTO_CREDITO "
            + "FROM SP_SELECT_TURNOS "
            + "WHERE ID = ${id};";
    
    private void imprimirReporte(Integer idTurno) {
        ClassicEngineBoot.getInstance().start();
        
        MasterReport report = null;
        
        try {
            // Using the classloader, get the URL to the reportDefinition file
            // NOTE: We will re-use the report definition from SAMPLE1
            File file = new File(REPORTE_CORTO_PATH);
            
            // Parse the report file
            final ResourceManager resourceManager = new ResourceManager();
            
            final Resource directly = resourceManager.createDirectly(file, 
                    MasterReport.class);
            
            report = (MasterReport) directly.getResource();
        } catch (ResourceException e) {
            e.printStackTrace();
        }
        
        report.getParameterValues().put("id", idTurno);        

        // Defining the queries.
        final var dataFactory = new SQLReportDataFactory(Conexion.getProvider());
        dataFactory.setQuery("default", SQL_REPORTE_CORTO);
        
        report.setDataFactory(dataFactory);

        report.setQuery("default");
        
        Rectangle bounds 
                = GraphicsEnvironment.getLocalGraphicsEnvironment().
                        getMaximumWindowBounds();
        
        // Generate the swing preview dialog
        final PreviewFrame dialog = new PreviewFrame(report);
        dialog.setBounds(bounds);
        dialog.setLocationRelativeTo(null);
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
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

    private void crearReporte(String userName) {
        //Columnas de la tabla....
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

        Turnos.getTurnosByUserName(userName).stream().forEach(turnos -> {
            rowData2[0] = turnos.getId();
            rowData2[1] = turnos.getFecha_hora_inicio();
            rowData2[2] = turnos.getFecha_hora_final();
            rowData2[3] = turnos.getMonto_facturado();
            rowData2[4] = turnos.getMonto_devuelto();
            rowData2[5] = turnos.getMonto_efectivo();
            rowData2[6] = turnos.getMonto_credito();
            modelo2.addRow(rowData2);
        });

        tblReporteTurnos.setModel(modelo2);

        Utilidades.repararColumnaTable(tblReporteTurnos);
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
    private rojeru_san.rslabel.RSLabelAnimated rSLabelAnimated1;
    private RSMaterialComponent.RSLabelTextIcon rSLabelTextIcon1;
    private RSMaterialComponent.RSTableMetro tblCajerosDisponible;
    private RSMaterialComponent.RSTableMetro tblReporteTurnos;
    private RSMaterialComponent.RSTableMetro tblTurnosActivos;
    // End of variables declaration//GEN-END:variables
}
