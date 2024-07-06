package sur.softsurena.formularios;

import java.util.Objects;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import sur.softsurena.entidades.Almacen;
import sur.softsurena.entidades.Privilegio;
import static sur.softsurena.metodos.M_Almacen.agregarAlmacen;
import static sur.softsurena.metodos.M_Almacen.getAlmacenesList;
import static sur.softsurena.metodos.M_Privilegio.privilegio;
import sur.softsurena.utilidades.Resultado;
import static sur.softsurena.utilidades.Utilidades.LOG;
import static sur.softsurena.utilidades.Utilidades.columnasCheckBox;
import static sur.softsurena.utilidades.Utilidades.repararColumnaTable;

public class frmAlmacenes extends javax.swing.JInternalFrame {

    private static boolean v_nuevo;
    private static String criterioBusqueda;

    public static frmAlmacenes getInstance() {
        if (!privilegio(
                Privilegio
                        .builder()
                        .privilegio(
                                Privilegio.PRIVILEGIO_SELECT
                        )
                        .nombre_relacion("V_ALMACENES")
                        .nombre_campo("^")
                        .build()
        )) {

            final String mensaje = "No cuenta con permisos para ver la información de"
                    + " este módulo.";

            JOptionPane.showInternalMessageDialog(
                    null,
                    mensaje,
                    "",
                    JOptionPane.WARNING_MESSAGE
            );

            throw new ExceptionInInitializerError(mensaje);
        }
        return NewSingletonHolder.INSTANCE;
    }

    private static class NewSingletonHolder {

        private static final frmAlmacenes INSTANCE = new frmAlmacenes();
    }

    private frmAlmacenes() {
        initComponents();
        jtpPrincipal.remove(RSPGMantenimiento);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBotones = new javax.swing.JPanel();
        jpBotones2 = new javax.swing.JPanel();
        btnNuevo = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnModificar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBorrar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnBuscar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnGuardar = new RSMaterialComponent.RSButtonMaterialIconOne();
        btnCancelar = new RSMaterialComponent.RSButtonMaterialIconOne();
        jtpPrincipal = new javax.swing.JTabbedPane();
        jpAlmacenesTbl = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlmacenes = new RSMaterialComponent.RSTableMetro();
        RSPGMantenimiento = new rojeru_san.rspanel.RSPanelGradiente();
        rSPanelShadow1 = new rojeru_san.rspanel.RSPanelShadow();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalleUbicacion = new javax.swing.JTextArea();
        rsEstado = new RSMaterialComponent.RSSwitch();
        txtNombreAlmacen = new rojeru_san.rsfield.RSTextFullRound();
        rSPanelShadow2 = new rojeru_san.rspanel.RSPanelShadow();
        rSCheckBox1 = new rojerusan.RSCheckBox();
        rSCheckBox3 = new rojerusan.RSCheckBox();
        rSLabelAnimated1 = new rojeru_san.rslabel.RSLabelAnimated();
        labelIcon1 = new necesario.LabelIcon();

        setBorder(javax.swing.BorderFactory.createMatteBorder(25, 10, 10, 10, new java.awt.Color(37, 45, 223)));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Almacenes");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
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

        jpBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Botones de Acción ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DejaVu Sans", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jpBotones.setMaximumSize(new java.awt.Dimension(787, 81));
        jpBotones.setMinimumSize(new java.awt.Dimension(787, 81));
        jpBotones.setName("jpBotones"); // NOI18N
        jpBotones.setPreferredSize(new java.awt.Dimension(800, 80));

        jpBotones2.setName("jpBotones2"); // NOI18N
        jpBotones2.setLayout(new java.awt.GridLayout(1, 0, 4, 0));

        btnNuevo.setText("Nuevo");
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.setName("btnNuevo"); // NOI18N
        btnNuevo.setRound(40);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jpBotones2.add(btnNuevo);

        btnModificar.setText("Modificar");
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.MODE_EDIT);
        btnModificar.setName("btnModificar"); // NOI18N
        btnModificar.setRound(40);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.setName("btnBorrar"); // NOI18N
        btnBorrar.setRound(40);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBorrar);

        btnBuscar.setText("Buscar");
        btnBuscar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.FIND_IN_PAGE);
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.setRound(40);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnBuscar);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.SAVE);
        btnGuardar.setName("btnGuardar"); // NOI18N
        btnGuardar.setRound(40);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnGuardar);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.setName("btnCancelar"); // NOI18N
        btnCancelar.setRound(40);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jpBotones2.add(btnCancelar);

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBotones2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpBotones2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        jtpPrincipal.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        jpAlmacenesTbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));

        tblAlmacenes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        tblAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre Almacen", "Ubicacion", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlmacenes);

        javax.swing.GroupLayout jpAlmacenesTblLayout = new javax.swing.GroupLayout(jpAlmacenesTbl);
        jpAlmacenesTbl.setLayout(jpAlmacenesTblLayout);
        jpAlmacenesTblLayout.setHorizontalGroup(
            jpAlmacenesTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpAlmacenesTblLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpAlmacenesTblLayout.setVerticalGroup(
            jpAlmacenesTblLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAlmacenesTblLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtpPrincipal.addTab("Lista de Almacen", jpAlmacenesTbl);

        RSPGMantenimiento.setColorPrimario(new java.awt.Color(153, 153, 255));
        RSPGMantenimiento.setGradiente(rojeru_san.rspanel.RSPanelGradiente.Gradiente.HORIZONTAL);

        rSPanelShadow1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(java.awt.Color.blue, 2, true), " Almacen ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeMono", 0, 19), new java.awt.Color(37, 45, 223))); // NOI18N

        txtDetalleUbicacion.setColumns(20);
        txtDetalleUbicacion.setLineWrap(true);
        txtDetalleUbicacion.setRows(5);
        txtDetalleUbicacion.setToolTipText("Descripcion breve de la ubica");
        txtDetalleUbicacion.setWrapStyleWord(true);
        txtDetalleUbicacion.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 255), 1, true), " Detalle de la ubicacion ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeMono", 0, 19), new java.awt.Color(0, 0, 255))); // NOI18N
        jScrollPane2.setViewportView(txtDetalleUbicacion);

        rsEstado.setToolTipText("Estado del almacen");

        txtNombreAlmacen.setToolTipText("Nombre del local o ubicacion donde se depositan los articulos.");
        txtNombreAlmacen.setPhColor(new java.awt.Color(0, 0, 204));
        txtNombreAlmacen.setPlaceholder("Ingrese nombre del almacen");

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                        .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rsEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rsEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
        );

        rSPanelShadow2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true), " Estados del Almacen. ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("FreeMono", 0, 19), new java.awt.Color(37, 45, 223))); // NOI18N
        rSPanelShadow2.setOpaque(false);

        rSCheckBox1.setText("Se permite hacer facturas ");
        rSCheckBox1.setDoubleBuffered(true);

        rSCheckBox3.setText("Se permite cantidades negativas");
        rSCheckBox3.setDoubleBuffered(true);

        javax.swing.GroupLayout rSPanelShadow2Layout = new javax.swing.GroupLayout(rSPanelShadow2);
        rSPanelShadow2.setLayout(rSPanelShadow2Layout);
        rSPanelShadow2Layout.setHorizontalGroup(
            rSPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rSPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
                .addContainerGap())
        );
        rSPanelShadow2Layout.setVerticalGroup(
            rSPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow2Layout.createSequentialGroup()
                .addComponent(rSCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 141, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RSPGMantenimientoLayout = new javax.swing.GroupLayout(RSPGMantenimiento);
        RSPGMantenimiento.setLayout(RSPGMantenimientoLayout);
        RSPGMantenimientoLayout.setHorizontalGroup(
            RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RSPGMantenimientoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSPanelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RSPGMantenimientoLayout.setVerticalGroup(
            RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RSPGMantenimientoLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(RSPGMantenimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelShadow2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jtpPrincipal.addTab("Mantenimiento", RSPGMantenimiento);

        rSLabelAnimated1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(37, 45, 223), 2, true));
        rSLabelAnimated1.setText("Mantenimiento de Almacenes");
        rSLabelAnimated1.setDoubleBuffered(true);
        rSLabelAnimated1.setFont(new java.awt.Font("FreeMono", 3, 36)); // NOI18N

        labelIcon1.setToolTipText("Click para actualizar la lista del almacen.");
        labelIcon1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.UPDATE);
        labelIcon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIcon1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
                    .addComponent(jtpPrincipal, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSLabelAnimated1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(labelIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(jtpPrincipal)
                .addGap(0, 0, 0)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        v_nuevo = true;
        cambioBoton(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        //Se valida que exista un campo seleccionado
        if (validarRegistro()) {
            return;
        }

        //Se hace false para indicar que es una modificacion de registro.
        v_nuevo = false;

        //Se agrega el panel de manteniento y se muestra.
        cambioBoton(true);
//
//        //Se obtiene el id del cliente para ser modificado.
//        Integer idCliente
//        = ((Personas) tblClientes.getValueAt(
//            tblClientes.getSelectedRow(), 0)).getId_persona();
//
//    //Al mostrarse el modulo de mantenimiento se deberia mostrar la
//    //informacion del cliente.
//    mostrarRegistro(idCliente);
//
//    //Se modifica el ancho de cada columna en todas las tablas siguiente.
//    repararColumnaTable(tblCorreos);
//    repararColumnaTable(tblDireccion);
//    repararColumnaTable(tblTelefonos);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        //TODO Crear proceso para borrar almacen.
//        //Validamos que está correcto en la tabla.
//        //Si el metodo devuelve true devolvemos el proceso.
//        if (validarRegistro()) {
//            return;
//        }
//
//        //Mostramos un mensaje de advertencia si el usuario desea continuar con
//        //la eliminación del registro.
//        int rta = JOptionPane.showConfirmDialog(this,
//            "¿Esta Seguro de Eliminar Registro del Cliente?",
//            "",
//            JOptionPane.YES_NO_OPTION,
//            JOptionPane.QUESTION_MESSAGE);
//
//        //Si el usuario responde a que no a las opciones entonces devolvemos el
//        //proceso.
//        if (rta == JOptionPane.NO_OPTION) {
//            return;
//        }
//
//        //Para eliminar un registro de un cliente obtenemos el ID y su estado
//        int idCliente = ((Clientes) tblClientes.getValueAt(
//            tblClientes.getSelectedRow(), 0)).getId_persona();
//
//    //Mandamos a borrar el cliente y obtenemos el resultado de la operacion
//    //y almacenamos en una variable.
//    TODO recibir aqui el objecto resultados.
//    String mensaje = borrarCliente(idCliente);
//
//    //Posibles icono a utilizar en el JOpcionPane
//    int icono = mensaje.equals(Clientes.CLIENTE_BORRADO_CORRECTAMENTE)
//    ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.WARNING_MESSAGE;
//
//    JOptionPane.showInternalMessageDialog(
//        this,
//        mensaje,
//        "",
//        icono);
//
//        repararColumnaTable(tblClientes);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //Hilo creado para ganar focus en la ventana de JopcionPane en buscar
        //cedula
        //        v_hilo = new Thread(this);
        //        v_hilo.start();
        //        v_hilo.interrupt();

        //        txtCedula1.setValue("");
        String resp = JOptionPane.showInternalInputDialog(
                this,
                "Ingrese su criterio de busqueda.\n[Nombre]",
                "",
                JOptionPane.QUESTION_MESSAGE
        );

        criterioBusqueda = resp;

        if (Objects.isNull(resp) || resp.isBlank()) {
            return;
        }

        llenarTabla(-1, criterioBusqueda);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombreAlmacen.getText().isBlank()) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe digitar el nombre del almacen...",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            txtNombreAlmacen.requestFocusInWindow();
            return;
        }//Validacion 1

        if (txtDetalleUbicacion.getText().isBlank()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Es importante agregar un detalle de la ubicacion del almacen.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                txtDetalleUbicacion.requestFocusInWindow();
                return;
            }
        }//Validacion 2

        if (!rsEstado.isActivado()) {
            int resp = JOptionPane.showInternalConfirmDialog(
                    this,
                    """
                    Se esta creando un almacen de estado inactivo.
                    Desea continuar?
                    """,
                    "",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );

            if (resp == JOptionPane.NO_OPTION) {
                txtDetalleUbicacion.requestFocusInWindow();
                return;
            }
        }

        Resultado resultado = Resultado
                    .builder()
                    .id(-1)
                    .mensaje("Este proceso esta en desarrollo. ")
                    .icono(JOptionPane.ERROR_MESSAGE)
                    .estado(Boolean.FALSE)
                    .build();

        if (v_nuevo) {
            resultado = agregarAlmacen(Almacen.
                    builder().
                    nombre(txtNombreAlmacen.getText()).
                    ubicacion(txtDetalleUbicacion.getText()).
                    estado(rsEstado.isActivado()).
                    build()
            );
        } else {
            //TODO Crear proceso para modificar almacen.
        }
        
        if(!resultado.getEstado()){
            LOG.severe("Este PROCESO no esta terminado.");
        }

        JOptionPane.showInternalMessageDialog(
                this,
                resultado,
                "",
                resultado.getIcono()
        );

        llenarTabla(-1, "");
        btnCancelarActionPerformed(evt);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Botones Para habilitar:
        cambioBoton(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        llenarTabla(-1, "");
    }//GEN-LAST:event_formInternalFrameOpened

    private void labelIcon1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIcon1MouseClicked
        llenarTabla(-1, "");
    }//GEN-LAST:event_labelIcon1MouseClicked

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        btnNuevo.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_I_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnModificar.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_U_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );

        btnBorrar.setEnabled(
                privilegio(
                        Privilegio
                                .builder()
                                .privilegio(Privilegio.PRIVILEGIO_EXECUTE)
                                .nombre_relacion("SP_D_ALMACEN")
                                .nombre_campo("^")
                                .build()
                )
        );
    }//GEN-LAST:event_formInternalFrameActivated


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.rspanel.RSPanelGradiente RSPGMantenimiento;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBorrar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnBuscar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnCancelar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnGuardar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnModificar;
    private RSMaterialComponent.RSButtonMaterialIconOne btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpAlmacenesTbl;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpBotones2;
    private javax.swing.JTabbedPane jtpPrincipal;
    private necesario.LabelIcon labelIcon1;
    private rojerusan.RSCheckBox rSCheckBox1;
    private rojerusan.RSCheckBox rSCheckBox3;
    private rojeru_san.rslabel.RSLabelAnimated rSLabelAnimated1;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow2;
    private RSMaterialComponent.RSSwitch rsEstado;
    private static RSMaterialComponent.RSTableMetro tblAlmacenes;
    private javax.swing.JTextArea txtDetalleUbicacion;
    private rojeru_san.rsfield.RSTextFullRound txtNombreAlmacen;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param activo
     */
    private void cambioBoton(boolean activo) {
        /*
            Aqui pasan los JScrollPane se alternan con el valor de activo,
        true selecciona el mantenimiento y false selecciona los registros de 
        clientes.
         */
        if (activo) {
            jtpPrincipal.addTab("Mantenimiento", RSPGMantenimiento);
            jtpPrincipal.setSelectedComponent(RSPGMantenimiento);
        } else {
            jtpPrincipal.setSelectedComponent(jpAlmacenesTbl);
            jtpPrincipal.remove(RSPGMantenimiento);
        }

        /*
            Si el valor de activo es true, quiere decir que se va a insertar o 
        modificar un registro. Por ende, los botones nuevo, modificar, borrar y 
        buscar se deshabilitan.
        
            En caso contrario si el valor de activo es falso, los botones nuevo,
        modificar, borrar y buscar se habilitan.
         */
        btnNuevo.setEnabled(!activo);
        btnModificar.setEnabled(!activo);
        btnBorrar.setEnabled(!activo);
        btnBuscar.setEnabled(!activo);

        //Botones de guardar y cancelar
        btnGuardar.setEnabled(activo);
        btnCancelar.setEnabled(activo);

        rsEstado.setActivado(activo);
        txtNombreAlmacen.setText("");
        txtDetalleUbicacion.setText("");

    }

    /**
     *
     * @return
     */
    private boolean validarRegistro() {
        //Si la tabla de registro de los cliente está vacia devolvemos true
        //para que el proceso no continue.
        if (tblAlmacenes.getRowCount() <= 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe contar con registros de almacen, agregue nuevo almacen.",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }

        //Si no existe un registro seleccionado devolvemos true para que el 
        //proceso no continue
        if (tblAlmacenes.getSelectedRow() < 0) {
            JOptionPane.showInternalMessageDialog(
                    this,
                    "Debe de seleccionar un cliente",
                    "",
                    JOptionPane.ERROR_MESSAGE
            );
            return true;
        }
        return false;
    }

    /**
     *
     * @param id
     * @param criterioBusqueda
     * @return
     */
    public synchronized static JTable llenarTabla(int id, String criterioBusqueda) {

        final String titulos[] = {"Nombre", "Ubicacion", "Estado"};

        if (criterioBusqueda.equalsIgnoreCase("evento")) {
            //criterioBusqueda = frmClientes.criterioBusqueda;
        }

        DefaultTableModel dtm = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            Class[] types = new Class[]{
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };

        Object registro[] = new Object[titulos.length];
        getAlmacenesList(id, criterioBusqueda).stream().forEach(
                almacen -> {
                    registro[0] = almacen;
                    registro[1] = almacen.getUbicacion();
                    registro[2] = almacen.getEstado();
                    dtm.addRow(registro);
                }
        );

        tblAlmacenes.removeAll();

        tblAlmacenes.setModel(dtm);

        int[] indices = {2};

        columnasCheckBox(tblAlmacenes, indices);

        repararColumnaTable(tblAlmacenes);

        tblAlmacenes.setBackgoundHover(new java.awt.Color(102, 102, 255));

        return tblAlmacenes;
    }
}
