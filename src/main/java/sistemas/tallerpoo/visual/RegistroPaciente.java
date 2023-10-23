package sistemas.tallerpoo.visual;

import java.awt.Color;
import sistemas.tallerpoo.datos.PacienteDatos;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

/**
 *
 * @author Thiago
 */
public class RegistroPaciente extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Paciente> lista;
    TableRowSorter <DefaultTableModel> sorter;
    PacienteDatos datos = new PacienteDatos();
   
    public RegistroPaciente() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        lista = datos.obtenerPacientes();
        listar();
    }

    public void listar()
    {   
        lista = datos.obtenerPacientes();
        limpiarTabla();
        modelo = (DefaultTableModel) jtPacientes.getModel();
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
            ob[9]=lista.get(i).getContacto();
            modelo.addRow(ob);
        }
        jtPacientes.setModel(modelo); 
        
        jtPacientes.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtPacientes.setRowSorter(sorter);
    }
  
    public void limpiarTabla()
    {
        for(int i = 0; i < modelo.getRowCount(); i++)
        {
            modelo.removeRow(i);
            i -= 1;
        }
    }
    
    public void mostrarTodo(Paciente p)
    {
        String dni = Integer.toString(p.getDni());
        String telefono = Integer.toString(p.getTelFijo());
        txtDni.setText(dni);
        txtNombre.setText(p.getNombre());
        txtApellido.setText(p.getApellido());
        //txtFechaNacimiento.setText(p.getFechaNacimiento().toString());
        txtDomicilio.setText(p.getDomicilio());
        txtTelefono.setText(telefono);
        txtCelular.setText(p.getTelCelular());
        cbEstadoCivil.setSelectedItem(p.getEstadoCivil());
        txtCorreo.setText(p.getCorreoElect());
        txtContacto.setText(p.getContacto());
    }
    
    public void limpiarTexto()
    {
       txtDni.setText("");
       txtNombre.setText("");
       txtApellido.setText("");
       //txtFechaNacimiento.setText("");
       txtDomicilio .setText("");
       txtTelefono.setText("");
       txtCelular.setText("");
       cbEstadoCivil.setSelectedIndex(0);
       txtCorreo.setText("");   
       txtContacto.setText("");
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
        jtPacientes = new javax.swing.JTable();
        txtBuscarDni = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtFechaNacimiento = new javax.swing.JTextField();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        btnConfirmarEdicion = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtContacto = new javax.swing.JTextField();
        lblMensaje = new javax.swing.JLabel();

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
        ));
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

        btnConfirmarEdicion.setText("Confrimar Edicion");
        btnConfirmarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEdicionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConfirmarEdicion)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
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
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDni)
                                    .addComponent(txtNombre)
                                    .addComponent(txtApellido)
                                    .addComponent(txtDomicilio)
                                    .addComponent(txtTelefono)
                                    .addComponent(txtCelular)
                                    .addComponent(cbEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFechaNacimiento)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtContacto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 2, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
                        .addContainerGap())))
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
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEditar)
                            .addComponent(btnConfirmarEdicion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (!validarCorreoElectronico(txtCorreo.getText())){
              JOptionPane.showMessageDialog(null, "Correo electrónico incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
              return;
        }
        Admision a = new Admision();
        Paciente p = datos.capturar(txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtDomicilio, txtTelefono, txtCelular, cbEstadoCivil, txtCorreo, txtContacto);
        if (datos.agregarPaciente(p)){
            String motivo= JOptionPane.showInputDialog(null, "Ingrese el motivo"); 
            while(motivo==null || motivo.isEmpty())     
            {
             JOptionPane.showMessageDialog(null, "Por favor ingrese un motivo");   
             motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo");   
            }  
            a.setFecha(new Date());
            a.setHora(new Date());
            a.setMotivo(motivo);
            a.setBox(new Box());
            a.setTriage(new Triage());
            a.setPaciente(p);
            new AdmisionDatos().agregarAdmision(a);
            JOptionPane.showMessageDialog(null, "se registro con exito");
            listar();
            this.limpiarTexto();
            RegistroAdmision.setPaciente(p);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ya existe paciente con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listar();  
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Paciente pac;
        int fila = jtPacientes.getSelectedRow();
        pac = lista.get(fila);
        this.mostrarTodo(pac);
        RegistroAdmision.setPaciente(pac);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtPacientes.getSelectedRow();
        String s = jtPacientes.getModel().getValueAt(fila, 0).toString();
        datos.eliminarPaciente(Integer.parseInt(s));
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarDniKeyReleased
        // TODO add your handling code here:
        filtrar(txtBuscarDni);
    }//GEN-LAST:event_txtBuscarDniKeyReleased

    private void btnConfirmarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEdicionActionPerformed
        Paciente p = new Paciente();
        p=datos.capturar(txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtDomicilio, txtDni, txtCelular, cbEstadoCivil, txtCorreo, txtContacto);

        try {
            if(datos.editarPaciente(p))
            {
              JOptionPane.showMessageDialog(null, "se edito con exito");
              limpiarTexto();
              listar();
              RegistroAdmision.setPaciente(p);
            }     
        } catch (IOException ex) {
            Logger.getLogger(RegistroPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarEdicionActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
     
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void txtCorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyReleased
     
        if (validarCorreoElectronico(txtCorreo.getText())) {
             lblMensaje.setText("Correcto");
             lblMensaje.setForeground(Color.GREEN); 
        }else{
              lblMensaje.setText("Incorrecto");
              lblMensaje.setForeground(Color.RED);
                    
        }
  
      
    }//GEN-LAST:event_txtCorreoKeyReleased

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        // TODO add your handling code here:
        filtrar(txtDni);
    }//GEN-LAST:event_txtDniKeyReleased
 
    private void filtrar(JTextField a)
    {
        try {
            sorter.setRowFilter(RowFilter.regexFilter(a.getText()));
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
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}