package sur.softsurena.formularios;

import java.awt.Image;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sur.softsurena.entidades.Categorias;
import static sur.softsurena.entidades.Categorias.agregarCategoria;
import static sur.softsurena.entidades.Categorias.borrarCategoria;
import static sur.softsurena.entidades.Categorias.existeCategoria;
import static sur.softsurena.entidades.Categorias.getCategorias;
import static sur.softsurena.entidades.Categorias.modificarCategoria;
import static sur.softsurena.entidades.Productos.existeCategoriaProductos;
import sur.softsurena.entidades.Resultados;
import sur.softsurena.metodos.Imagenes;
import sur.softsurena.utilidades.Utilidades;

public class frmCategorias extends javax.swing.JDialog {

    private static final Logger LOG = Logger.getLogger(frmCategorias.class.getName());

    private Integer idCategoria;
    private boolean nuevo = false, estado;
    private int respuestaFileChooser = JFileChooser.CANCEL_OPTION;
    private String ruta = "", nombreCategoria = "", source, dest;

    public frmCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        actualizarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new newscomponents.RSButtonGradientIcon_new();
        btnModificar = new newscomponents.RSButtonGradientIcon_new();
        btnBorrar = new newscomponents.RSButtonGradientIcon_new();
        jLabel1 = new javax.swing.JLabel();
        jlfecha = new RSMaterialComponent.RSLabelTextIcon();
        cbCategoria = new RSMaterialComponent.RSComboBox();
        btnCancelar = new newscomponents.RSButtonGradientIcon_new();
        jlEstado = new RSMaterialComponent.RSLabelTextIcon();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(339, 218));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jlImagen.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sur/softsurena/imagenes/NoImageTransp 96 x 96.png"))); // NOI18N
        jlImagen.setToolTipText("");
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jlImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlImagen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(504, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(504, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(504, 102));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 10, 3));

        btnNuevo.setText("Nuevo");
        btnNuevo.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnNuevo.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.ADD);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setText("Editar");
        btnModificar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnModificar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EDIT);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnBorrar.setText("Borrar");
        btnBorrar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnBorrar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DELETE);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre de la Categoria");

        jlfecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlfecha.setText("Fecha de creacción: -");
        jlfecha.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.DATE_RANGE);

        cbCategoria.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbCategoriaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 0, 0));
        btnCancelar.setText("Cancelar");
        btnCancelar.setColorPrimario(new java.awt.Color(255, 0, 0));
        btnCancelar.setColorPrimarioHover(new java.awt.Color(255, 102, 102));
        btnCancelar.setGradiente(newscomponents.RSButtonGradientIcon_new.Gradiente.HORIZONTAL);
        btnCancelar.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jlEstado.setForeground(new java.awt.Color(255, 0, 0));
        jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlEstado.setText("Inactivo");
        jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CANCEL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jlEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jlfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        cbCategoriaPopupMenuWillBecomeInvisible(null);
    }//GEN-LAST:event_formWindowOpened

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            return;
        }
        int rta = JOptionPane.showConfirmDialog(null,
                "Esta Seguro de Eliminar la Categoria {"
                + (((Categorias) cbCategoria.getSelectedItem()).getDescripcion())
                + "} del Sistema? \n\n Este proceso tratara "
                + "de eliminarlo si no ocurre es porque existen"
                + "\nproducto asociado a dicha categoria.",
                "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (rta == JOptionPane.NO_OPTION) {
            return;
        }

        if (existeCategoriaProductos(((Categorias) cbCategoria.getSelectedItem()).getId_categoria())) {
            JOptionPane.showMessageDialog(null, "No se permite eliminar categoria porque existe producto Asociados");
            return;
        }

        Resultados resultados = borrarCategoria(((Categorias) cbCategoria.getSelectedItem()).getId_categoria());

        String msg = resultados.getMensaje();
        int cant = resultados.getCantidad();

        LOG.log(Level.INFO, "Registros afectados {0}", cant);

        JOptionPane.showMessageDialog(null, msg);

        if (cbCategoria.getItemCount() != 0) {
            cbCategoria.setSelectedIndex(0);
        }

        actualizarCombo();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe de crear una categoria!",
                    "Proceso de verificacion de categoria.",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        nuevo = false;

        idCategoria = ((Categorias) cbCategoria.getSelectedItem()).getId_categoria();

        nombreCategoria = ((Categorias) cbCategoria.getSelectedItem()).getDescripcion();

        estado = ((Categorias) cbCategoria.getSelectedItem()).getEstado();

        frmCategoriasAdmin miCategoria = new frmCategoriasAdmin(nombreCategoria, estado, false);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);

        if (miCategoria.getAceptar()) {
            if (!nombreCategoria.equals(miCategoria.txtCategoria.getText())) {
                if (existeCategoria(miCategoria.txtCategoria.getText())) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Este nombre de Categoria Existe",
                            "Proceso de validacion",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
            }
            nombreCategoria = miCategoria.txtCategoria.getText().toUpperCase();
            if (buscarImagen()) {
                guardar();
            } else {
                int resp = JOptionPane.showConfirmDialog(
                        null,
                        "Desea solo guardar el nombre?",
                        "Confirmacion de Categoria",
                        JOptionPane.YES_NO_OPTION);

                if (resp == JOptionPane.YES_OPTION) {
                    guardar();
                }
            }
        }
        miCategoria.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Activamos el Flag de registro Nuevo
        nuevo = true;

        jlImagen.setIcon(new javax.swing.ImageIcon(
                getClass().getResource(
                        "/sur/softsurena/imagenes/NoImageTransp 96 x 96.png")));

        frmCategoriasAdmin miCategoria = new frmCategoriasAdmin("", false, true);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);

        //Pedimos el nombre de la categoria a crear.
        nombreCategoria = miCategoria.txtCategoria.getText();

        //Si nombre de la categoria esta' nula o vacia nos devolvemos. 
        if (nombreCategoria.isBlank() || nombreCategoria == null) {
            dispose();
            return;
        }

        //La convertimos a Mayuscula.
        nombreCategoria = nombreCategoria.toUpperCase();

        //Consultamos la base de datos para saber si ese nombre de categoria existe.
        if (existeCategoria(nombreCategoria)) {
            JOptionPane.showMessageDialog(
                    null,
                    "Este nombre de Categoria ya existe en el sitema",
                    "Validando categoria nueva",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        estado = miCategoria.jcbEstado.isSelected();

        //Avisamos al usuario que le toca elegir la imagen de la categoria.
        JOptionPane.showMessageDialog(
                null,
                "Siguiente paso es para elejir una imagen para la Categoria "
                + nombreCategoria
        );

        if (buscarImagen()) {
            guardar();
        } else {
            jlImagen.setIcon(null);
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void cbCategoriaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbCategoriaPopupMenuWillBecomeInvisible
        String fechaCreacion;
        try {
            fechaCreacion = ((Categorias) cbCategoria.getSelectedItem()).getFecha_creacion().toString();
        } catch (java.lang.NullPointerException e) {
            fechaCreacion = "01.01.2000";
            LOG.info("Fecha no proporcionada");
        }

        ImageIcon imagen = Utilidades.imagenDecode64(((Categorias) cbCategoria.getSelectedItem()).getImage_texto());

        Boolean estado = ((Categorias) cbCategoria.getSelectedItem()).getEstado();

        if (estado) {
            jlEstado.setForeground(new java.awt.Color(37, 45, 223));
            jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jlEstado.setText("Activo");
            jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK_BOX);
        } else {
            jlEstado.setForeground(new java.awt.Color(255, 0, 0));
            jlEstado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            jlEstado.setText("Inactivo");
            jlEstado.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.CHECK_BOX_OUTLINE_BLANK);
        }

        jlImagen.setIcon(imagen);
        jlfecha.setText("Fecha de creacción: " + fechaCreacion);
    }//GEN-LAST:event_cbCategoriaPopupMenuWillBecomeInvisible

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void guardar() {
        if (nuevo) {
            //Ejecutamos la consulta siguiente para insertar la categoria.
            String msj = agregarCategoria(
                    Categorias.
                            builder().
                            descripcion(nombreCategoria.trim()).
                            pathImage(new File(ruta)).
                            estado(estado)
                            .build()
            ).getMensaje();

            //Si recibimos un mensaje de error del metodo anterior ejecutamos lo
            //siguiente.
            if (msj.equals("Error al insertar categoria.")) {
                JOptionPane.showMessageDialog(
                        null,
                        msj,
                        "Proceso de creacion Categoria.",
                        JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            //Si el condicional anterior no se ejecutó entonces mostramos al 
            //usuario que se inserto el registro.
            JOptionPane.showMessageDialog(null,
                    msj,
                    "Proceso de creacion Categoria.",
                    JOptionPane.INFORMATION_MESSAGE);

        } else {
            //Creamos el objeto categoria que tendra' los atributos.
            Categorias categoria = Categorias.builder().
                    id_categoria(idCategoria).
                    descripcion(nombreCategoria.trim()).
                    pathImage(new File(ruta)).build();

            String msj = modificarCategoria(categoria);

            JOptionPane.showMessageDialog(null, msj);

            if (msj.equals("Error al Modificar Categoria...")) {
                return;
            }

        }

        dest = ruta;

        if (respuestaFileChooser == JFileChooser.APPROVE_OPTION) {
            Utilidades.copyFileUsingFileChannels(source, dest);
            ImageIcon imagen = new ImageIcon(ruta);
            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                    Image.SCALE_DEFAULT));
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();
        }

        respuestaFileChooser = JFileChooser.CANCEL_OPTION;
        ruta = "";

        actualizarCombo();
    }

    private void actualizarCombo() {

        cbCategoria.removeAllItems();

        cbCategoria.addItem(Categorias.builder().
                id_categoria(-1).
                descripcion("Seleccione una categoria").
                image_texto("").
                fecha_creacion(null).
                estado(false).
                build());

        getCategorias().stream().forEach(x -> {
            cbCategoria.addItem(
                    Categorias.builder().
                            id_categoria(x.getId_categoria()).
                            descripcion(x.getDescripcion()).
                            image_texto(x.getImage_texto()).
                            fecha_creacion(x.getFecha_creacion()).
                            estado(x.getEstado()).
                            build()
            );
        });
        cbCategoria.setSelectedIndex(0);
    }

    private boolean buscarImagen() {
        //Creamos un JFileChooser para buscar una imagen en el sistema.
        JFileChooser jfileChooser = new JFileChooser();

        //Preparamos el tipo de extension que se van a filtrar en el JFileChooser.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagenes",
                "jpg", "png", "PNG", "JPG");

        //Colocamos el filtro a jFileChooser.
        jfileChooser.setFileFilter(filter);

        //Abrimos la ventana para conocer la opcion elegida por el usuario.
        respuestaFileChooser = jfileChooser.showOpenDialog(this);

        //Si el usuario cancelo' devolvemos false.
        if (respuestaFileChooser == JFileChooser.CANCEL_OPTION) {
            return false;
        }

        source = jfileChooser.getSelectedFile().getAbsolutePath();
        dest = "imagesCategorias/";

        ImageIcon imagen = new ImageIcon(source);

        //Tamaño de icono
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                Image.SCALE_DEFAULT));

        imagen.getImage().flush();

        jlImagen.setIcon(icon);
        jlImagen.validate();

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private newscomponents.RSButtonGradientIcon_new btnBorrar;
    private newscomponents.RSButtonGradientIcon_new btnCancelar;
    private newscomponents.RSButtonGradientIcon_new btnModificar;
    private newscomponents.RSButtonGradientIcon_new btnNuevo;
    private RSMaterialComponent.RSComboBox cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private RSMaterialComponent.RSLabelTextIcon jlEstado;
    private javax.swing.JLabel jlImagen;
    private RSMaterialComponent.RSLabelTextIcon jlfecha;
    // End of variables declaration//GEN-END:variables
}

/**
 * btnNuevoActionPerformed:
 * 1) Colocamos el flag de nuevo a true.
 * 2) Seteamos el jlImagen a null
 */
