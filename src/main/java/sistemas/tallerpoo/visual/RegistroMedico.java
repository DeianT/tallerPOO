package sistemas.tallerpoo.visual;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;
import sistemas.tallerpoo.datos.MedicoDatos;

/**
 * La clase RegistroMedico es una interfaz de usuario que muestra y maneja los
 * datos de los médicos. Se encarga de listar, limpiar la tabla y filtrar la
 * información de los médicos. Extiende la funcionalidad de la clase
 * javax.swing.JFrame.
 */
public class RegistroMedico extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Medico> lista;
    TableRowSorter<DefaultTableModel> sorter;
    MedicoDatos datos = new MedicoDatos();

    /**
     * Constructor de la clase RegistroMedico. Inicializa la interfaz y
     * establece la posición inicial de la ventana en el centro de la pantalla.
     * Inicializa el modelo de la tabla, obtiene la lista de médicos y muestra
     * los datos en la tabla. Configura los mensajes de aviso como ocultos al
     * iniciar la ventana.
     */
    public RegistroMedico() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        lista = datos.obtenerMedicos();
        listar();
        avisoDNI.setVisible(false);
        avisoNOMBRE.setVisible(false);
        avisoAPELLIDO.setVisible(false);
        avisoDOMICILIO.setVisible(false);
        avisoTELEFONO.setVisible(false);
        avisoCELULAR.setVisible(false);
        avisoESTADOCIVIL.setVisible(false);
        avisoSECTORTRABAJO.setVisible(false);
        avisoMATRICULA.setVisible(false);
    }

    /**
     * Lista los datos de los médicos en la tabla. Obtiene la lista de médicos,
     * los agrega al modelo de la tabla y visualiza los datos. Configura la
     * tabla para permitir ordenamiento y filtrado.
     */
    public void listar() {
        lista = datos.obtenerMedicos();
        limpiarTabla();
        modelo = (DefaultTableModel) jtMedicos.getModel();
        Object[] ob = new Object[10];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getDni();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getApellido();
            ob[3] = lista.get(i).getFechaNacimiento();
            ob[4] = lista.get(i).getDomicilio();
            ob[5] = lista.get(i).getTelFijo();
            ob[6] = lista.get(i).getTelCelular();
            ob[7] = lista.get(i).getEstadoCivil();
            ob[8] = lista.get(i).getCorreoElect();
            ob[9] = lista.get(i).getNMatricula();
            modelo.addRow(ob);
        }
        jtMedicos.setModel(modelo);

        jtMedicos.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtMedicos.setRowSorter(sorter);
    }

    /**
     * Limpia la tabla de datos. Remueve todas las filas de la tabla,
     * eliminándolas de la vista.
     */
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    /**
     * Muestra los datos de un médico en los campos correspondientes de la
     * interfaz.
     *
     * @param m Objeto de tipo Medico con los datos a visualizar.
     */
    public void mostrarTodo(Medico m) {
        String dni = Integer.toString(m.getDni());
        String telefono = Integer.toString(m.getTelFijo());
        String matricula = Integer.toString(m.getNMatricula());
        txtDni.setText(dni);
        txtNombre.setText(m.getNombre());
        txtApellido.setText(m.getApellido());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date pruebita = dateFormat.parse(m.getFechaNacimiento());
            txtFechaNacimiento.setDate(pruebita);
        } catch (ParseException ex) {
        }

        txtDomicilio.setText(m.getDomicilio());
        txtTelefono.setText(telefono);
        txtCelular.setText(m.getTelCelular());
        cbEstadoCivil.setSelectedItem(m.getEstadoCivil());
        txtCorreo.setText(m.getCorreoElect());
        txtSectorTrabajo.setText(m.getTrabajaEn().getNombre());
        txtMatricula.setText(matricula);
    }

    /**
     * Limpia los campos de texto en la interfaz, restableciéndolos a sus
     * valores predeterminados.
     */
    public void limpiarTexto() {
        txtDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNacimiento.setCalendar(null);
        txtDomicilio.setText("");
        txtTelefono.setText("");
        txtCelular.setText("");
        cbEstadoCivil.setSelectedIndex(0);
        txtCorreo.setText("");
        txtSectorTrabajo.setText("");
        txtMatricula.setText("");
        lblMensaje.setText("");
    }

    /**
     * Captura los datos ingresados en los campos de la interfaz y los devuelve
     * en un objeto de tipo Medico.
     *
     * @return Objeto Medico con la información capturada de la interfaz.
     */
    Medico captar() {
        Medico m = new Medico();
        int dni = Integer.parseInt(txtDni.getText());
        int telefono = Integer.parseInt(txtTelefono.getText());
        String estado = String.valueOf(cbEstadoCivil.getSelectedItem());
        SectorTrabajo sec = new SectorTrabajo();
        sec.setNombre(txtSectorTrabajo.getText());
        m.setDni(dni);
        m.setNombre(txtNombre.getText());
        m.setApellido(txtApellido.getText());
        String Fecha = ((JTextField) txtFechaNacimiento.getDateEditor().getUiComponent()).getText();
        m.setFechaNacimiento(Fecha);
        m.setDomicilio(txtDomicilio.getText());
        m.setTelFijo(telefono);
        m.setTelCelular(txtCelular.getText());
        m.setEstadoCivil(estado);
        m.setCorreoElect(txtCorreo.getText());
        m.setTrabajaEn(sec);
        m.setNMatricula(Integer.parseInt(txtMatricula.getText()));

        return m;
    }

    /**
     * Verifica si la cadena pasada como argumento es un correo electrónico
     * válido.
     *
     * @param correoElectronico Cadena que se verificará si es un correo
     * electrónico válido.
     * @return true si es un correo electrónico válido; de lo contrario, false.
     */
    private boolean validarCorreoElectronico(String correoElectronico) {
        Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mat = pat.matcher(correoElectronico);
        return mat.find();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMedicos = new javax.swing.JTable();
        txtBuscarDni = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnConfirmarEdicion = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtSectorTrabajo = new javax.swing.JTextField();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        avisoDNI = new javax.swing.JLabel();
        avisoNOMBRE = new javax.swing.JLabel();
        avisoAPELLIDO = new javax.swing.JLabel();
        avisoDOMICILIO = new javax.swing.JLabel();
        avisoTELEFONO = new javax.swing.JLabel();
        avisoESTADOCIVIL = new javax.swing.JLabel();
        avisoCELULAR = new javax.swing.JLabel();
        avisoSECTORTRABAJO = new javax.swing.JLabel();
        avisoMATRICULA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(200, 100));

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Fecha de Nacimiento");

        jLabel5.setText("Domicilio");

        jLabel6.setText("Telefono");

        jLabel7.setText("Celular");

        jLabel8.setText("Estado Civil");

        jLabel9.setText("Correo");

        jLabel10.setText("Matricula");

        txtDni.setNextFocusableComponent(txtNombre);
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a" }));

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCorreoKeyReleased(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jtMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Fecha de Nacimiento", "Domicilio", "Telefono", "Celular", "EstadoCivil", "Correo", "Matricula"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtMedicos);

        txtBuscarDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarDniKeyReleased(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnMostrarTodo.setText("Mostrar Todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar Medico");

        btnConfirmarEdicion.setText("Confirmar Edicion");
        btnConfirmarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEdicionActionPerformed(evt);
            }
        });

        jLabel13.setText("Sector de Trabajo");

        txtFechaNacimiento.setDateFormatString("dd/MM/yyyy");

        avisoDNI.setForeground(new java.awt.Color(255, 51, 0));
        avisoDNI.setText("Campo Obligatorio(*)");

        avisoNOMBRE.setForeground(new java.awt.Color(255, 0, 0));
        avisoNOMBRE.setText("Campo Obligatorio(*)");

        avisoAPELLIDO.setForeground(new java.awt.Color(255, 0, 0));
        avisoAPELLIDO.setText("Campo Obligatorio(*)");

        avisoDOMICILIO.setForeground(new java.awt.Color(255, 0, 0));
        avisoDOMICILIO.setText("Campo Obligatorio(*)");

        avisoTELEFONO.setForeground(new java.awt.Color(255, 51, 0));
        avisoTELEFONO.setText("Si no posee, ingrese 0.");

        avisoESTADOCIVIL.setForeground(new java.awt.Color(255, 51, 0));
        avisoESTADOCIVIL.setText("Campo Obligatorio(*)");

        avisoCELULAR.setForeground(new java.awt.Color(255, 51, 0));
        avisoCELULAR.setText("Campo Obligatorio(*)");

        avisoSECTORTRABAJO.setForeground(new java.awt.Color(255, 0, 51));
        avisoSECTORTRABAJO.setText("Campo Obligatorio(*)");

        avisoMATRICULA.setForeground(new java.awt.Color(255, 0, 51));
        avisoMATRICULA.setText("Campo Obligatorio(*)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(383, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avisoESTADOCIVIL)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(avisoTELEFONO)
                                        .addComponent(avisoCELULAR)
                                        .addComponent(avisoDOMICILIO)
                                        .addComponent(avisoAPELLIDO)
                                        .addComponent(avisoNOMBRE))
                                    .addComponent(avisoDNI))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDni)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtDomicilio)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtCelular)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(cbEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avisoSECTORTRABAJO)
                                    .addComponent(avisoMATRICULA))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                    .addComponent(txtMatricula)
                                    .addComponent(txtSectorTrabajo))))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmarEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarTodo)
                    .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoDNI))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoNOMBRE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoAPELLIDO))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoDOMICILIO))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoTELEFONO))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoCELULAR))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoESTADOCIVIL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(lblMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSectorTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoSECTORTRABAJO))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoMATRICULA)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnConfirmarEdicion))
                .addGap(25, 25, 25))
        );

        jLabel12.getAccessibleContext().setAccessibleName("lblMensaje");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza la acción de registrar un nuevo médico a partir de la información
     * ingresada en la interfaz. Comprueba que los campos requeridos estén
     * completos, verifica la validez de la información, y muestra mensajes de
     * error si es necesario.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        avisoDNI.setVisible(false);
        avisoNOMBRE.setVisible(false);
        avisoAPELLIDO.setVisible(false);
        avisoDOMICILIO.setVisible(false);
        avisoTELEFONO.setVisible(false);
        avisoCELULAR.setVisible(false);
        avisoESTADOCIVIL.setVisible(false);
        avisoSECTORTRABAJO.setVisible(false);
        avisoMATRICULA.setVisible(false);
        if (txtDni.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()
                || txtApellido.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()
                || txtTelefono.getText().trim().isEmpty() || txtCelular.getText().trim().isEmpty()
                || txtDomicilio.getText().trim().isEmpty() || txtSectorTrabajo.getText().trim().isEmpty()
                || cbEstadoCivil.getSelectedIndex() == 0 || txtMatricula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Hay campos incompletos, por favor complételos", "Error", JOptionPane.WARNING_MESSAGE);
            if (txtDni.getText().trim().isEmpty()) {
                avisoDNI.setVisible(true);
            }
            if (txtNombre.getText().trim().isEmpty()) {
                avisoNOMBRE.setVisible(true);
            }
            if (txtApellido.getText().trim().isEmpty()) {
                avisoAPELLIDO.setVisible(true);
            }
            if (txtDomicilio.getText().trim().isEmpty()) {
                avisoDOMICILIO.setVisible(true);
            }
            if (txtTelefono.getText().trim().isEmpty()) {
                avisoTELEFONO.setVisible(true);
            }
            if (txtCelular.getText().trim().isEmpty()) {
                avisoCELULAR.setVisible(true);
            }
            if (cbEstadoCivil.getSelectedIndex() == 0) {
                avisoESTADOCIVIL.setVisible(true);
            }
            if (txtSectorTrabajo.getText().trim().isEmpty()) {
                avisoSECTORTRABAJO.setVisible(true);
            }
            if (txtMatricula.getText().trim().isEmpty()) {
                avisoMATRICULA.setVisible(true);
            }
            return;
        }

        if (!txtDni.getText().matches("\\d+") || Integer.parseInt(txtDni.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validarCorreoElectronico(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(null, "Correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (datos.agregarMedico(captar())) {
            JOptionPane.showMessageDialog(null, "Se registró con exito");
            avisoDNI.setVisible(false);
            avisoNOMBRE.setVisible(false);
            avisoAPELLIDO.setVisible(false);
            avisoDOMICILIO.setVisible(false);
            avisoTELEFONO.setVisible(false);
            avisoCELULAR.setVisible(false);
            avisoESTADOCIVIL.setVisible(false);
            avisoSECTORTRABAJO.setVisible(false);
            avisoMATRICULA.setVisible(false);
            listar();
            this.limpiarTexto();
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe médico con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Acción que muestra la lista completa de médicos en la interfaz.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listar();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    /**
     * Acción que permite la edición de un médico seleccionado en la interfaz.
     * Obtiene los detalles del médico seleccionado para su edición.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Medico med;
        int fila = jtMedicos.getSelectedRow();
        med = lista.get(fila);
        this.mostrarTodo(med);
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Acción que elimina un médico seleccionado en la interfaz.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtMedicos.getSelectedRow();
        String s = jtMedicos.getModel().getValueAt(fila, 0).toString();
        datos.eliminarMedico(Integer.parseInt(s));
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Actualiza la lista de médicos según el valor ingresado en el campo de
     * búsqueda.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void txtBuscarDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarDniKeyReleased
        filtrar(txtBuscarDni);
    }//GEN-LAST:event_txtBuscarDniKeyReleased

    /**
     * Confirma la edición del médico mostrado en la interfaz.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */
    private void btnConfirmarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEdicionActionPerformed
        Medico m = new Medico();
        m = this.captar();
        if (datos.editarMedico(m)) {
            JOptionPane.showMessageDialog(null, "Se editó con exito");
            limpiarTexto();
            listar();
        }
    }//GEN-LAST:event_btnConfirmarEdicionActionPerformed

    /**
     * Verifica si el correo electrónico ingresado es válido y muestra un
     * mensaje visual según el resultado.
     *
     * @param evt Objeto que contiene la información del evento desencadenante.
     */

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (validarCorreoElectronico(txtCorreo.getText())) {
            lblMensaje.setText("Correcto");
            lblMensaje.setForeground(Color.GREEN);
        } else {
            lblMensaje.setText("Incorrecto");
            lblMensaje.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        filtrar(txtDni);
    }//GEN-LAST:event_txtDniKeyReleased

    /**
     * Realiza el filtrado de la tabla de médicos basado en el valor del campo
     * de búsqueda por DNI.
     * 
     * @param a Campo de texto que se utiliza para realizar el filtrado.
     */
    private void filtrar(JTextField a) {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(a.getText(), 0));
        } catch (Exception e) {
        }
    }

    /**
     * El método main es el punto de entrada del programa. Inicializa la ventana
     * de RegistroMedico.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoAPELLIDO;
    private javax.swing.JLabel avisoCELULAR;
    private javax.swing.JLabel avisoDNI;
    private javax.swing.JLabel avisoDOMICILIO;
    private javax.swing.JLabel avisoESTADOCIVIL;
    private javax.swing.JLabel avisoMATRICULA;
    private javax.swing.JLabel avisoNOMBRE;
    private javax.swing.JLabel avisoSECTORTRABAJO;
    private javax.swing.JLabel avisoTELEFONO;
    private javax.swing.JButton btnConfirmarEdicion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMedicos;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarDni;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSectorTrabajo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
