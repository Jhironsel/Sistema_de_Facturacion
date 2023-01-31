package sur.softsurena.formularios;

import java.awt.Image;
import java.io.File;
import java.util.List;
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
import sur.softsurena.utilidades.Utilidades;

public class frmCategorias extends javax.swing.JDialog {

    private static final Logger LOG = Logger.getLogger(frmCategorias.class.getName());

    private Integer idCategoria;
    private boolean nuevo = false;
    private int respuestaFileChooser = JFileChooser.CANCEL_OPTION;
    private String ruta = "", nombreCategoria = "", source, dest;

    public frmCategorias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlImagen = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox();

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
        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Sin_imagen 64 x 64.png"))); // NOI18N
        jlImagen.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Seleccione Imagen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ubuntu", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jlImagen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlImagen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setMaximumSize(new java.awt.Dimension(504, 102));
        jPanel2.setMinimumSize(new java.awt.Dimension(504, 102));
        jPanel2.setPreferredSize(new java.awt.Dimension(504, 102));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3, 3, 3));

        btnNuevo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Documento nuevo 32 x 32.png"))); // NOI18N
        btnNuevo.setMnemonic('n');
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("Crear un nuevo Registro");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevo);

        btnModificar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(0, 0, 0));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Editar Documento 32 x 32.png"))); // NOI18N
        btnModificar.setMnemonic('e');
        btnModificar.setText("Editar");
        btnModificar.setToolTipText("Modificar Registro Actual");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar);

        btnBorrar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Borrar 32 x 32.png"))); // NOI18N
        btnBorrar.setMnemonic('b');
        btnBorrar.setText("Borrar");
        btnBorrar.setToolTipText("Borrar Registro Actual");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre de la Categoria");

        cbCategoria.setForeground(new java.awt.Color(0, 0, 0));
        cbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCategoriaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbCategoria, jLabel1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        //Activamos el Flag de registro Nuevo
        nuevo = true;

        limpiarJLImagen();

        //Pedimos el nombre de la categoria a crear.
        nombreCategoria = JOptionPane.showInputDialog(
                this,
                "Cual es el nombre de Categoria?",
                "Crear nombre de Categoria",
                JOptionPane.QUESTION_MESSAGE
        );

        //Si nombre de la categoria esta' nula o vacia nos devolvemos. 
        if (nombreCategoria == null || nombreCategoria.trim().isEmpty()) {
            return;
        }

        //La convertimos a Mayuscula.
        nombreCategoria = nombreCategoria.toUpperCase();

        //Consultamos la base de datos para saber si ese nombre de categoria existe.
        if (existeCategoria(nombreCategoria)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Este nombre de Categoria ya existe en el sitema");
            return;
        }

        //Avisamos al usuario que le toca elegir la imagen de la categoria.
        JOptionPane.showMessageDialog(null,
                "Siguiente paso es para elejir una imagen para la Categoria "
                + nombreCategoria);

        if (buscarImagen()) {
            guardar();
        } else {
            limpiarJLImagen();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void limpiarJLImagen() {
        //Label de la imagen Habilitado y su texto
        jlImagen.setIcon(null);
        jlImagen.setText("Click agregar imagen");
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debe de crear una categoria...!!!");
            return;
        }

        nuevo = false;
        idCategoria = ((Categorias) cbCategoria.getSelectedItem()).getId();
        nombreCategoria = ((Categorias) cbCategoria.getSelectedItem()).getDescripcion();
        ruta = ((Categorias) cbCategoria.getSelectedItem()).getPathImage().toString();

        frmDialogoCategoria miCategoria = new frmDialogoCategoria(null, true, nombreCategoria);
        miCategoria.setLocationRelativeTo(null);
        miCategoria.setVisible(true);
        if (miCategoria.isAceptar()) {
            if (!nombreCategoria.equals(miCategoria.getNombreCategoria())) {
                if (existeCategoria(miCategoria.getNombreCategoria())) {
                    JOptionPane.showMessageDialog(null, "Este nombre de Categoria Existe");
                    return;
                }
            }
            nombreCategoria = miCategoria.getNombreCategoria().toUpperCase();
            if (buscarImagen()) {
                guardar();
            } else {
                int resp = JOptionPane.showConfirmDialog(null,
                        "Desea solo guardar el nombre?",
                        "Confirmacion de Categoria",
                        JOptionPane.YES_NO_OPTION);
                if (resp == 0) {
                    guardar();
                }
            }
        }
        miCategoria.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (cbCategoria.getItemCount() == 0) {
            return;
        }
        int rta = JOptionPane.showConfirmDialog(null,
                "Esta Seguro de Eliminar la Categoria {"
                + (((Categorias) cbCategoria.getSelectedItem()).getDescripcion())
                + "} del Sistema? \n\n Este proceso tratara "
                + "de eliminarlo si no ocurre es porque existen"
                + "\nproducto asociado a dicha categoria",
                "Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (rta == 1) {
            return;
        }
        if (existeCategoriaProductos(((Categorias) cbCategoria.getSelectedItem()).getId())) {
            JOptionPane.showMessageDialog(null, "No se permite eliminar categoria porque existe producto Asociados");
            return;
        }
        String msg;
        msg = borrarCategoria(((Categorias) cbCategoria.getSelectedItem()).getId());
        JOptionPane.showMessageDialog(rootPane, msg);
        if (cbCategoria.getItemCount() != 0) {
            cbCategoria.setSelectedIndex(0);
        }
        actualizarCombo();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCategoriaItemStateChanged
        String laImagen;

        try {
            laImagen = ((Categorias) cbCategoria.getSelectedItem()).getPathImage().toString();
        } catch (Exception ex) {
            laImagen = "";
        }

        try {
            ImageIcon imagen = new ImageIcon(laImagen);
            //Tamaño de icono Comprobar...
            if (imagen.getIconHeight() == -1) {
                imagen = new ImageIcon(System.getProperty("user.dir")
                        + "/images/Sin_imagen 64 x 64.png");
            }
            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(72, 72,
                    Image.SCALE_DEFAULT));
            imagen.getImage().flush();
            jlImagen.setIcon(icon);
            jlImagen.validate();
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage(), e);
        }
    }//GEN-LAST:event_cbCategoriaItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        actualizarCombo();
    }//GEN-LAST:event_formWindowOpened

    private void guardar() {
        if (nuevo) {
            //Creamos la categoria y la encapsulamos en la clase Categoria
            Categorias categoria = Categorias.builder().
                    descripcion(nombreCategoria.trim()).
                    pathImage(new File(ruta)).build();

            //Ejecutamos la consulta siguiente para insertar la categoria.
            String msj = agregarCategoria(categoria).getMensaje();

            //Si recibimos un mensaje de error del metodo anterior ejecutamos lo
            //siguiente.
            if (msj.equals("Error al insertar categoria.")) {
                JOptionPane.showMessageDialog(null,
                        msj,
                        "Proceso de creacion Categoria.",
                        JOptionPane.ERROR_MESSAGE);
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
                    id(idCategoria).
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

        List<Categorias> categoriasList = getCategorias();

        cbCategoria.removeAllItems();

        categoriasList.stream().forEach(x -> {
            Categorias miCat = Categorias.builder().
                    id(x.getId()).
                    descripcion(x.getDescripcion()).
                    image_texto(x.getImage_texto()).build();
            cbCategoria.addItem(miCat);
        });

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
        dest = "/imagesCategorias/";

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
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlImagen;
    // End of variables declaration//GEN-END:variables
}
