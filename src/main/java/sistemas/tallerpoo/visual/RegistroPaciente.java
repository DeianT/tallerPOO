package sistemas.tallerpoo.visual;

import java.awt.Color;
import sistemas.tallerpoo.datos.PacienteDatos;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.datos.AdmisionDatos;
import javax.swing.JLabel;
import javax.swing.JTextField;
import sistemas.tallerpoo.clasesLogicas.ControlRoles;
import sistemas.tallerpoo.clasesLogicas.Rol;

/**
 * Interfaz de usuario que gestiona el registro de pacientes. Muestra, agrega,
 * edita y elimina información de los pacientes en la tabla.
 */
public class RegistroPaciente extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Paciente> lista;
    TableRowSorter<DefaultTableModel> sorter;
    PacienteDatos datos = new PacienteDatos();

    /**
     * Constructor de la clase que inicializa la interfaz y establece la
     * localización, el modelo de la tabla, y los avisos.
     */
    public RegistroPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        lista = datos.obtenerPacientes();
        listar();
        ocultarAvisos();
    }

    /**
     * Método para listar y mostrar los datos de los pacientes en la tabla.
     */
    public void listar() {
        lista = datos.obtenerPacientes();
        limpiarTabla();
        modelo = (DefaultTableModel) jtPacientes.getModel();
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
            ob[9] = lista.get(i).getContacto();
            modelo.addRow(ob);
        }
        jtPacientes.setModel(modelo);

        jtPacientes.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtPacientes.setRowSorter(sorter);
    }

    /**
     * Método para limpiar los datos de la tabla de pacientes.
     */
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    /**
     * Muestra los datos del paciente recibido en los campos de la interfaz.
     *
     * @param p El objeto Paciente del cual se obtienen los datos a mostrar.
     */
    public void mostrarTodo(Paciente p) {
        String dni = Integer.toString(p.getDni());
        String telefono = Integer.toString(p.getTelFijo());
        txtDni.setText(dni);
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date pruebita = dateFormat.parse(p.getFechaNacimiento());
            txtFechaNacimiento.setDate(pruebita);
        } catch (ParseException ex) {
        }

        txtDomicilio.setText(p.getDomicilio());
        txtTelefono.setText(telefono);
        txtCelular.setText(p.getTelCelular());
        cbEstadoCivil.setSelectedItem(p.getEstadoCivil());
        txtCorreo.setText(p.getCorreoElect());
        txtContacto.setText(p.getContacto());
    }

    /**
     * Limpia los campos de entrada de datos del paciente en la interfaz.
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
        txtContacto.setText("");
        lblMensaje.setText("");
    }

    /**
     * Valida un correo electrónico con un patrón específico.
     *
     * @param correoElectronico El correo electrónico a validar.
     * @return true si el correo es válido, de lo contrario, false.
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
        jtPacientes = new javax.swing.JTable();
        txtBuscarDni = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnConfirmarEdicion = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        btnAdmision = new javax.swing.JButton();
        avisoDNI = new javax.swing.JLabel();
        avisoNOMBRE = new javax.swing.JLabel();
        avisoAPELLIDO = new javax.swing.JLabel();
        avisoCONTACTO = new javax.swing.JLabel();
        avisoDOMICILIO1 = new javax.swing.JLabel();
        avisoTELEFONO = new javax.swing.JLabel();
        avisoESTADOCIVIL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Fecha de Nacimiento");

        jLabel5.setText("Domicilio");

        jLabel6.setText("Telefono");

        jLabel7.setText("Celular");

        jLabel8.setText("Estado Civil");

        jLabel9.setText("Correo");

        jLabel10.setText("Contacto");

        txtDni.setNextFocusableComponent(txtNombre);
        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDniFocusGained(evt);
            }
        });
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a" }));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
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

        jtPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Fecha de Nacimiento", "Domicilio", "Telefono", "Celular", "EstadoCivil", "Correo", "Contacto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtPacientes);

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

        jLabel11.setText("Buscar Paciente");

        btnConfirmarEdicion.setText("Confirmar Edicion");
        btnConfirmarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEdicionActionPerformed(evt);
            }
        });

        txtFechaNacimiento.setToolTipText("");
        txtFechaNacimiento.setDateFormatString("dd/MM/yyyy");
        txtFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaNacimientoFocusGained(evt);
            }
        });

        btnAdmision.setText("Registrar admisión");
        btnAdmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdmisionActionPerformed(evt);
            }
        });

        avisoDNI.setForeground(new java.awt.Color(255, 0, 51));
        avisoDNI.setText("Campo Obligatorio(*)");

        avisoNOMBRE.setForeground(new java.awt.Color(255, 0, 51));
        avisoNOMBRE.setText("Campo Obligatorio(*)");

        avisoAPELLIDO.setForeground(new java.awt.Color(255, 0, 51));
        avisoAPELLIDO.setText("Campo Obligatorio(*)");

        avisoCONTACTO.setForeground(new java.awt.Color(255, 0, 51));
        avisoCONTACTO.setText("Campo Obligatorio(*)");

        avisoDOMICILIO1.setForeground(new java.awt.Color(255, 0, 51));
        avisoDOMICILIO1.setText("Campo Obligatorio(*)");

        avisoTELEFONO.setForeground(new java.awt.Color(255, 0, 51));
        avisoTELEFONO.setText("Si no posee, ingrese 0");

        avisoESTADOCIVIL.setForeground(new java.awt.Color(255, 0, 51));
        avisoESTADOCIVIL.setText("Campo Obligatorio(*)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfirmarEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(avisoDNI))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(avisoAPELLIDO)))
                                                .addGap(6, 6, 6))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(9, 9, 9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(avisoESTADOCIVIL)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                                    .addComponent(avisoDOMICILIO1))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                    .addComponent(avisoTELEFONO))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(avisoCONTACTO))))
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(avisoNOMBRE)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContacto)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(194, 194, 194)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE))
                                    .addComponent(txtDni)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtCelular)
                                    .addComponent(cbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtDomicilio)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 751, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAdmision)
                        .addGap(88, 88, 88))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarTodo)
                    .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoDNI))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoNOMBRE))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoAPELLIDO))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoDOMICILIO1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoTELEFONO))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoESTADOCIVIL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensaje)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoCONTACTO)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnConfirmarEdicion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAdmision, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza el registro de un nuevo paciente. Verifica si el usuario tiene
     * los roles adecuados para ejecutar la acción. Comprueba la integridad de
     * los campos y muestra advertencias en caso de campos incompletos. Crea una
     * nueva admisión, valida la información del paciente y, si no existe,
     * registra al paciente. Agrega una admisión asociada al nuevo paciente,
     * incluyendo el motivo, fecha y hora actuales, box de atención y nivel de
     * triaje. Actualiza la interfaz tras el registro exitoso.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!ControlRoles.usuarioTieneRol(new Rol("Medico", 0)) && !ControlRoles.usuarioTieneRol(new Rol("Admision de Pacientes", 0))) {
            JOptionPane.showMessageDialog(null, "Usted no tiene acceso a esta función");
            return;
        }
        
        if(!controlCampos())
            return;

        Admision a = new Admision();
        Paciente p = datos.capturar(txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtDomicilio, txtTelefono, txtCelular, cbEstadoCivil, txtCorreo, txtContacto);
        if (datos.agregarPaciente(p)) {
            String motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo");
            while (motivo == null || motivo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un motivo");
                motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo");
            }
            String fechaA;
            String horaA;
            //Se crean dos objetos de fecha para poder sacar hora y fecha actuales.
            Date fechita = new Date();
            Date horita = new Date();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            fechaA = formatofecha.format(fechita);
            horaA = formatohora.format(horita);
            a.setFecha(fechaA);
            a.setHora(horaA);
            a.setMotivo(motivo);
            a.setBox(new Box());
            a.setTriage(new Triage());
            a.setPaciente(p);
            new AdmisionDatos().agregarAdmision(a);
            JOptionPane.showMessageDialog(null, "Se registró con exito");

            ocultarAvisos();
            listar();
            this.limpiarTexto();
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe paciente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * Muestra la lista de pacientes.
     */
    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listar();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    /**
     * Realiza la acción de edición de un paciente si el usuario tiene roles de
     * "Medico" o "Admisión de Pacientes".
     *
     * @param evt El evento desencadenante de la acción.
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (!ControlRoles.usuarioTieneRol(new Rol("Medico", 0)) && !ControlRoles.usuarioTieneRol(new Rol("Admision de Pacientes", 0))) {
            JOptionPane.showMessageDialog(null, "Usted no tiene acceso a esta función");
            return;
        }

        ocultarAvisos();
        Paciente pac;
        int fila = jtPacientes.getSelectedRow();
        pac = lista.get(fila);
        this.mostrarTodo(pac);
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Realiza la acción de eliminación de un paciente si el usuario tiene roles
     * de "Medico" o "Admision de Pacientes".
     *
     * @param evt El evento desencadenante de la acción.
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (!ControlRoles.usuarioTieneRol(new Rol("Medico", 0)) && !ControlRoles.usuarioTieneRol(new Rol("Admision de Pacientes", 0))) {
            JOptionPane.showMessageDialog(null, "Usted no tiene acceso a esta función");
            return;
        }

        int fila = jtPacientes.getSelectedRow();
        String s = jtPacientes.getModel().getValueAt(fila, 0).toString();
        
        int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar al paciente con dni " + s + "?", "Confirmación", 0, JOptionPane.QUESTION_MESSAGE, null, new String[] {"SI", "NO"}, "SI");
        if(opcion == 0){
            datos.eliminarPaciente(Integer.parseInt(s));
            ocultarAvisos();
        }
        
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * Método que se activa cuando se libera una tecla en el campo de búsqueda
     * de DNI, desencadenando el filtrado.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtBuscarDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarDniKeyReleased
        // TODO add your handling code here:
        filtrar(txtBuscarDni);
    }//GEN-LAST:event_txtBuscarDniKeyReleased

    /**
     * Confirma la edición de un paciente si el usuario tiene roles de "Medico"
     * o "Admision de Pacientes".
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void btnConfirmarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEdicionActionPerformed
        if (!ControlRoles.usuarioTieneRol(new Rol("Medico", 0)) && !ControlRoles.usuarioTieneRol(new Rol("Admision de Pacientes", 0))) {
            JOptionPane.showMessageDialog(null, "Usted no tiene acceso a esta función");
            return;
        }
        
        if(!controlCampos())
            return;

        Paciente p = new Paciente();
        p = datos.capturar(txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtDomicilio, txtDni, txtCelular, cbEstadoCivil, txtCorreo, txtContacto);

        if (datos.editarPaciente(p)) {
            JOptionPane.showMessageDialog(null, "Se editó con exito");
            limpiarTexto();
            listar();
            ocultarAvisos();
        }
        else{
            JOptionPane.showMessageDialog(null, "No existe paciente con ese DNI");
        }
    }//GEN-LAST:event_btnConfirmarEdicionActionPerformed

    /**
     * Método activado cuando se realiza una acción en el campo de correo
     * electrónico.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed

    }//GEN-LAST:event_txtCorreoActionPerformed

    /**
     * Método que se activa cuando se libera una tecla en el campo de correo
     * electrónico para validar la entrada.
     *
     * @param evt Evento desencadenante de la acción.
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

    /**
     * Método activado cuando se realiza una acción en el campo de texto del
     * DNI.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed

    }//GEN-LAST:event_txtDniActionPerformed

    /**
     * Método activado cuando se libera una tecla en el campo de texto del DNI.
     * Realiza un filtrado con el valor del campo de texto.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased

        filtrar(txtDni);
    }//GEN-LAST:event_txtDniKeyReleased

    /**
     * Método activado cuando el campo de texto del DNI recibe el foco.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtDniFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusGained

    }//GEN-LAST:event_txtDniFocusGained

    /**
     * Método activado cuando el campo de texto de la fecha de nacimiento recibe
     * el foco.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void txtFechaNacimientoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacimientoFocusGained

    }//GEN-LAST:event_txtFechaNacimientoFocusGained

    /**
     * Método activado al presionar el botón de Admisión. Realiza la admisión de
     * un paciente, solicitando un motivo y almacenando la información de
     * admisión.
     *
     * @param evt Evento desencadenante de la acción.
     */
    private void btnAdmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdmisionActionPerformed
        if (!ControlRoles.usuarioTieneRol(new Rol("Medico", 0)) && !ControlRoles.usuarioTieneRol(new Rol("Admision de Pacientes", 0))) {
            JOptionPane.showMessageDialog(null, "Usted no tiene acceso a esta función");
            return;
        }

        int fila = jtPacientes.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Paciente p = lista.get(fila);

        String motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo");
        while (motivo == null || motivo.isEmpty()) {
            motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo");
        }

        Date date = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
        String fecha = formatofecha.format(date);
        String hora = formatohora.format(date);

        Admision a = new Admision();
        a.setFecha(fecha);
        a.setHora(hora);
        a.setMotivo(motivo);
        a.setBox(new Box());
        a.setTriage(new Triage());
        a.setPaciente(p);
        new AdmisionDatos().agregarAdmision(a);

        JOptionPane.showMessageDialog(null, "Se registró con exito");
        listar();
        this.limpiarTexto();
        ocultarAvisos();
    }//GEN-LAST:event_btnAdmisionActionPerformed

    /**
     * Método utilizado para filtrar la tabla de pacientes.
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
     * Controla que todos los campos obligatorios estén completos y que cumplan
     * con el formato requerido
     * @return true si los campos están completos y cumplen con el formato, false
     * en caso contrario
     */
    private boolean controlCampos(){
        if (txtDni.getText().trim().isEmpty() || txtNombre.getText().trim().isEmpty()
                || txtApellido.getText().trim().isEmpty() || txtContacto.getText().trim().isEmpty()
                || txtNombre.getText().trim().isEmpty() || txtTelefono.getText().trim().isEmpty()
                || cbEstadoCivil.getSelectedIndex() == 0) {
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
                avisoDOMICILIO1.setVisible(true);
            }
            if (txtContacto.getText().trim().isEmpty()) {
                avisoCONTACTO.setVisible(true);
            }
            if (txtTelefono.getText().trim().isEmpty()) {
                avisoTELEFONO.setVisible(true);
            }
            if (cbEstadoCivil.getSelectedIndex() == 0) {
                avisoESTADOCIVIL.setVisible(true);
            }
            return false;
        }

        if (!txtDni.getText().matches("\\d+") || (Integer.parseInt(txtDni.getText()) <= 0)) {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!txtTelefono.getText().matches("\\d+") || (Integer.parseInt(txtTelefono.getText()) < 0)) {
            JOptionPane.showMessageDialog(null, "El teléfono no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!txtCorreo.getText().trim().isEmpty() && !validarCorreoElectronico(txtCorreo.getText())) {
            JOptionPane.showMessageDialog(null, "Correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * Oculta los avisos de campos obligatorios
     */
    private void ocultarAvisos(){
        avisoDNI.setVisible(false);
        avisoNOMBRE.setVisible(false);
        avisoAPELLIDO.setVisible(false);
        avisoDOMICILIO1.setVisible(false);
        avisoCONTACTO.setVisible(false);
        avisoTELEFONO.setVisible(false);
        avisoESTADOCIVIL.setVisible(false);
    }

    /**
     * El método main es el punto de entrada del programa. Inicializa la ventana
     * de RegistroPaciente.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoAPELLIDO;
    private javax.swing.JLabel avisoCONTACTO;
    private javax.swing.JLabel avisoDNI;
    private javax.swing.JLabel avisoDOMICILIO1;
    private javax.swing.JLabel avisoESTADOCIVIL;
    private javax.swing.JLabel avisoNOMBRE;
    private javax.swing.JLabel avisoTELEFONO;
    private javax.swing.JButton btnAdmision;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtPacientes;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarDni;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
