package sistemas.tallerpoo.visual;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;
import sistemas.tallerpoo.datos.FuncionarioDatos;

/**
 *
 * @author Thiago
 */
public class RegistroFuncionario extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Funcionario> lista;
    TableRowSorter <DefaultTableModel> sorter;
    FuncionarioDatos datos = new FuncionarioDatos();
   
    public RegistroFuncionario() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        lista = datos.obtenerFuncionarios();
        listar();
        avisoDNI.setVisible(false);
        avisoNOMBRE.setVisible(false);
        avisoAPELLIDO.setVisible(false);
        avisoDOMICILIO.setVisible(false);
        avisoTELEFONO.setVisible(false);
        avisoCELULAR.setVisible(false);
        avisoESTADOCIVIL.setVisible(false);
        avisoSECTORTRABAJO.setVisible(false);
    }

    public void listar()
    {   
        lista = datos.obtenerFuncionarios();
        limpiarTabla();
        modelo = (DefaultTableModel) jtFuncionarios.getModel();
        Object[] ob = new Object[10];
        
        for(int i = 0; i < lista.size(); i++)
        {
            ob[0]=lista.get(i).getDni();
            ob[1]=lista.get(i).getNombre();
            ob[2]=lista.get(i).getApellido();
            ob[3]=lista.get(i).getFechaNacimiento();
            ob[4]=lista.get(i).getDomicilio();
            ob[5]=lista.get(i).getTelFijo();
            ob[6]=lista.get(i).getTelCelular();
            ob[7]=lista.get(i).getEstadoCivil();
            ob[8]=lista.get(i).getCorreoElect();
            ob[9]=lista.get(i).getTrabajaEn().getNombre();
            modelo.addRow(ob);
        }
        jtFuncionarios.setModel(modelo); 
        
        jtFuncionarios.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtFuncionarios.setRowSorter(sorter);
    }

    public void limpiarTabla()
    {
        for(int i = 0; i < modelo.getRowCount(); i++)
        {
            modelo.removeRow(i);
            i -= 1;
        }
    }
    
    public void mostrarTodo(Funcionario p)
    {
        String dni = Integer.toString(p.getDni());
        String telefono = Integer.toString(p.getTelFijo());
        txtDni.setText(dni);
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = dateFormat.parse(p.getFechaNacimiento());
            txtFechaNacimiento.setDate(fecha);
        } catch (ParseException ex) {}
        
        txtDomicilio.setText(p.getDomicilio());
        txtTelefono.setText(telefono);
        txtCelular.setText(p.getTelCelular());
        cbEstadoCivil.setSelectedItem(p.getEstadoCivil());
        txtCorreo.setText(p.getCorreoElect());
        txtSectorTrabajo.setText(p.getTrabajaEn().getNombre());
    }
    
    public void limpiarTexto()
    {
       txtDni.setText("");
       txtNombre.setText("");
       txtApellido.setText("");
       txtFechaNacimiento.setCalendar(null);
       txtDomicilio .setText("");
       txtTelefono.setText("");
       txtCelular.setText("");
       cbEstadoCivil.setSelectedIndex(0);
       txtCorreo.setText("");   
       txtSectorTrabajo.setText("");
       lblMensaje.setText("");
    }
    
    Funcionario captar()
    {
        Funcionario m = new Funcionario();
        int dni = Integer.parseInt(txtDni.getText());
        int telefono = Integer.parseInt(txtTelefono.getText());
        SectorTrabajo sec = new SectorTrabajo();
        sec.setNombre(txtSectorTrabajo.getText());
        String estado = String.valueOf(cbEstadoCivil.getSelectedItem());
        m.setDni(dni);
        m.setNombre(txtNombre.getText());
        m.setApellido(txtApellido.getText());
        String Fecha = ((JTextField)txtFechaNacimiento.getDateEditor().getUiComponent()).getText();
        m.setFechaNacimiento(Fecha);
        m.setDomicilio(txtDomicilio.getText());
        m.setTelFijo(telefono);
        m.setTelCelular(txtCelular.getText());
        m.setEstadoCivil(estado);
        m.setCorreoElect(txtCorreo.getText());
        m.setTrabajaEn(sec);
        
        return m;
    }
    
    private boolean validarCorreoElectronico(String correoElectronico){
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
        jtFuncionarios = new javax.swing.JTable();
        txtBuscarDni = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnConfirmarEdicion = new javax.swing.JButton();
        txtSectorTrabajo = new javax.swing.JTextField();
        txtFechaNacimiento = new com.toedter.calendar.JDateChooser();
        lblMensaje = new javax.swing.JLabel();
        avisoSECTORTRABAJO = new javax.swing.JLabel();
        avisoESTADOCIVIL = new javax.swing.JLabel();
        avisoCELULAR = new javax.swing.JLabel();
        avisoTELEFONO = new javax.swing.JLabel();
        avisoDOMICILIO = new javax.swing.JLabel();
        avisoAPELLIDO = new javax.swing.JLabel();
        avisoNOMBRE = new javax.swing.JLabel();
        avisoDNI = new javax.swing.JLabel();

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

        jLabel10.setText("Sector de Trabajo");

        txtDni.setNextFocusableComponent(txtNombre);

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

        jtFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Fecha de Nacimiento", "Domicilio", "Telefono", "Celular", "EstadoCivil", "Correo", "Sector Trabajo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtFuncionarios);

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

        jLabel11.setText("Buscar Funcionario");

        btnConfirmarEdicion.setText("Confirmar Edicion");
        btnConfirmarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEdicionActionPerformed(evt);
            }
        });

        txtFechaNacimiento.setDateFormatString("dd/MM/yyyy");

        avisoSECTORTRABAJO.setForeground(new java.awt.Color(255, 0, 51));
        avisoSECTORTRABAJO.setText("Campo Obligatorio(*)");

        avisoESTADOCIVIL.setForeground(new java.awt.Color(255, 51, 0));
        avisoESTADOCIVIL.setText("Campo Obligatorio(*)");

        avisoCELULAR.setForeground(new java.awt.Color(255, 51, 0));
        avisoCELULAR.setText("Si no posee, ingrese 0.");

        avisoTELEFONO.setForeground(new java.awt.Color(255, 51, 0));
        avisoTELEFONO.setText("Si no posee, ingrese 0.");

        avisoDOMICILIO.setForeground(new java.awt.Color(255, 0, 0));
        avisoDOMICILIO.setText("Campo Obligatorio(*)");

        avisoAPELLIDO.setForeground(new java.awt.Color(255, 0, 0));
        avisoAPELLIDO.setText("Campo Obligatorio(*)");

        avisoNOMBRE.setForeground(new java.awt.Color(255, 0, 0));
        avisoNOMBRE.setText("Campo Obligatorio(*)");

        avisoDNI.setForeground(new java.awt.Color(255, 51, 0));
        avisoDNI.setText("Campo Obligatorio(*)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(192, 192, 192))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoESTADOCIVIL))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoSECTORTRABAJO))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoDOMICILIO))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoTELEFONO))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoDNI))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoCELULAR))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoAPELLIDO))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(avisoNOMBRE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSectorTrabajo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmarEdicion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(lblMensaje)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSectorTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avisoSECTORTRABAJO)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmarEdicion)
                    .addComponent(btnEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        avisoDNI.setVisible(false);
        avisoNOMBRE.setVisible(false);
        avisoAPELLIDO.setVisible(false);
        avisoDOMICILIO.setVisible(false);
        avisoTELEFONO.setVisible(false);
        avisoCELULAR.setVisible(false);
        avisoESTADOCIVIL.setVisible(false);
        avisoSECTORTRABAJO.setVisible(false);
        if(txtDni.getText().trim().isEmpty()||txtNombre.getText().trim().isEmpty()||
                txtApellido.getText().trim().isEmpty()||txtNombre.getText().trim().isEmpty()||
                txtTelefono.getText().trim().isEmpty()||txtCelular.getText().trim().isEmpty()||
                txtDomicilio.getText().trim().isEmpty()||txtSectorTrabajo.getText().trim().isEmpty()||
                cbEstadoCivil.getSelectedIndex() == 0)
        {
            JOptionPane.showMessageDialog(null, "Hay campos incompletos, por favor complételos", "Error", JOptionPane.WARNING_MESSAGE);
            if(txtDni.getText().trim().isEmpty()){
                avisoDNI.setVisible(true);
            }
            if(txtNombre.getText().trim().isEmpty()){
                avisoNOMBRE.setVisible(true);
            }
            if(txtApellido.getText().trim().isEmpty()){
                avisoAPELLIDO.setVisible(true);
            }
            if(txtDomicilio.getText().trim().isEmpty()){
                avisoDOMICILIO.setVisible(true);
            }
            if(txtTelefono.getText().trim().isEmpty()){
                avisoTELEFONO.setVisible(true);
            }
            if(txtCelular.getText().trim().isEmpty()){
                avisoCELULAR.setVisible(true);
            }
            if(cbEstadoCivil.getSelectedIndex() == 0){
                avisoESTADOCIVIL.setVisible(true);
            }
            if(txtSectorTrabajo.getText().trim().isEmpty()){
                avisoSECTORTRABAJO.setVisible(true);
            }
            return;
        }
        
        
        
        if ((Integer.parseInt(txtDni.getText()) <= 0)){
            JOptionPane.showMessageDialog(null,"Ingrese un DNI válido", "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!validarCorreoElectronico(txtCorreo.getText())){
            JOptionPane.showMessageDialog(null, "Correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (datos.agregarFuncionario(captar())){
            JOptionPane.showMessageDialog(null, "Se registró con exito");
            avisoDNI.setVisible(false);
            avisoNOMBRE.setVisible(false);
            avisoAPELLIDO.setVisible(false);
            avisoDOMICILIO.setVisible(false);
            avisoTELEFONO.setVisible(false);
            avisoCELULAR.setVisible(false);
            avisoESTADOCIVIL.setVisible(false);
            avisoSECTORTRABAJO.setVisible(false);
            listar();
            this.limpiarTexto();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ya existe paciente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listar();  
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Funcionario pac;
        int fila = jtFuncionarios.getSelectedRow();
        pac = lista.get(fila);
        this.mostrarTodo(pac);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtFuncionarios.getSelectedRow();
        String s = jtFuncionarios.getModel().getValueAt(fila, 0).toString();
        datos.eliminarFuncionario(Integer.parseInt(s));
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarDniKeyReleased
        filtrar();
    }//GEN-LAST:event_txtBuscarDniKeyReleased

    private void btnConfirmarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEdicionActionPerformed
        Funcionario p = new Funcionario();
        p=datos.capturar(txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtDomicilio, txtDni, txtCelular, cbEstadoCivil, txtCorreo, txtSectorTrabajo);
        if(datos.editarFuncionario(p))
        {
            JOptionPane.showMessageDialog(null, "Se editó con exito");
            limpiarTexto();
            listar();
        }
    }//GEN-LAST:event_btnConfirmarEdicionActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
        if (validarCorreoElectronico(txtCorreo.getText())) {
            lblMensaje.setText("Correcto");
            lblMensaje.setForeground(Color.GREEN); 
        }else{
            lblMensaje.setText("Incorrecto");
            lblMensaje.setForeground(Color.RED);      
        }
    }//GEN-LAST:event_txtCorreoKeyReleased
                                   
    private void filtrar()
    {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(txtBuscarDni.getText()));
        } catch (Exception e) {
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoAPELLIDO;
    private javax.swing.JLabel avisoCELULAR;
    private javax.swing.JLabel avisoDNI;
    private javax.swing.JLabel avisoDOMICILIO;
    private javax.swing.JLabel avisoESTADOCIVIL;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtFuncionarios;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarDni;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private com.toedter.calendar.JDateChooser txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSectorTrabajo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}