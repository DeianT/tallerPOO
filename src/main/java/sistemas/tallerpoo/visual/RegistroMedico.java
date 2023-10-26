/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemas.tallerpoo.visual;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.datos.MedicoDatos;

/**
 *
 * @author Thiago
 */
public class RegistroMedico extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Medico> lista;
    TableRowSorter <DefaultTableModel> sorter;
    MedicoDatos datos = new MedicoDatos();
   
    public RegistroMedico() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        lista = datos.obtenerMedicos();
        listar();
        lblAviso.setVisible(false);
    }

    public void listar()
    {
        lista = datos.obtenerMedicos();
        limpiarTabla();
        modelo = (DefaultTableModel) jtMedicos.getModel();
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
            ob[9]=lista.get(i).getNMatricula();
            modelo.addRow(ob);
        }
        jtMedicos.setModel(modelo);
        
        jtMedicos.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtMedicos.setRowSorter(sorter);
    }
    
    public void listarr(ArrayList<Medico> lista)
    {
        modelo = (DefaultTableModel) jtMedicos.getModel();
        Object[] ob = new Object[9];
        
        for(int i =0; i<lista.size();i++)
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
            ob[9]=lista.get(i).getNMatricula();
            modelo.addRow(ob);
        }
        jtMedicos.setModel(modelo);
        
        jtMedicos.setAutoCreateRowSorter(true);
        sorter = new TableRowSorter<>(modelo);
        jtMedicos.setRowSorter(sorter);
    }
    
    public void limpiarTabla()
    {
        for(int i =0 ; i<modelo.getRowCount();i++)
        {
            modelo.removeRow(i);
            i-=1;
        }
    }
    
    public void mostrarTodo(Medico m)
    {
        String dni = Integer.toString(m.getDni());
        String telefono = Integer.toString(m.getTelFijo());
        String matricula = Integer.toString(m.getNMatricula());
        txtDni.setText(dni);
        txtNombre.setText(m.getNombre());
        txtApellido.setText(m.getApellido());
        txtFechaNacimiento.setText(m.getFechaNacimiento().toString());
        txtDomicilio.setText(m.getDomicilio());
        txtTelefono.setText(telefono);
        txtCelular.setText(m.getTelCelular());
        cbEstadoCivil.setSelectedItem(m.getEstadoCivil());
        txtCorreo.setText(m.getCorreoElect());
        txtMatricula.setText(matricula);
    }
    
    public void limpiarTexto()
    {
       txtDni.setText("");
       txtNombre.setText("");
       txtApellido.setText("");
       txtFechaNacimiento.setText("");
       txtDomicilio .setText("");
       txtTelefono.setText("");
       txtCelular.setText("");
       cbEstadoCivil.setSelectedIndex(0);
       txtCorreo.setText("");  
       txtMatricula.setText("");
    }
    
    Medico captar()
    {
        Medico m = new Medico();
        int dni = Integer.parseInt(txtDni.getText());
        int telefono = Integer.parseInt(txtTelefono.getText());
        String estado = String.valueOf(cbEstadoCivil.getSelectedItem());
        m.setDni(dni);
        m.setNombre(txtNombre.getText());
        m.setApellido(txtApellido.getText());
//        m.setFechaNacimiento(txtFechaNacimiento.getText());
        m.setFechaNacimiento(new Date());
        m.setDomicilio(txtDomicilio.getText());
        m.setTelFijo(telefono);
        m.setTelCelular(txtCelular.getText());
        m.setEstadoCivil(estado);
        m.setCorreoElect(txtCorreo.getText());
        m.setNMatricula(Integer.parseInt(txtMatricula.getText()));
        //rolsistema
        
        return m;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDni = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblDomicilio = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblMatricula = new javax.swing.JLabel();
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
        txtFechaNacimiento = new javax.swing.JTextField();
        btnMostrarTodo = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnConfirmarEdicion = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblDni.setText("DNI *");

        lblNombre.setText("Nombre *");

        lblApellido.setText("Apellido *");

        lblFechaNacimiento.setText("Fecha de Nacimiento *");

        lblDomicilio.setText("Domicilio *");

        lblTelefono.setText("Telefono");

        lblCelular.setText("Celular *");

        lblEstadoCivil.setText("Estado Civil");

        lblCorreo.setText("Correo *");

        lblMatricula.setText("Matricula *");

        txtDni.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDniFocusLost(evt);
            }
        });

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });

        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });

        txtDomicilio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDomicilioFocusLost(evt);
            }
        });
        txtDomicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDomicilioActionPerformed(evt);
            }
        });

        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });

        txtCelular.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCelularFocusLost(evt);
            }
        });

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Soltero/a", "Casado/a", "Viudo/a", "Divorciado/a" }));

        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
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
        ));
        jScrollPane1.setViewportView(jtMedicos);

        txtBuscarDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarDniActionPerformed(evt);
            }
        });
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

        txtFechaNacimiento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaNacimientoFocusLost(evt);
            }
        });

        btnMostrarTodo.setText("Mostrar Todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        jLabel11.setText("Buscar Medico");

        txtMatricula.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMatriculaFocusLost(evt);
            }
        });

        btnConfirmarEdicion.setText("Confrimar Edicion");
        btnConfirmarEdicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarEdicionActionPerformed(evt);
            }
        });

        lblAviso.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(255, 0, 0));
        lblAviso.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAviso.setText("Campos Obligatorios (*)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDni)
                    .addComponent(lblNombre)
                    .addComponent(lblApellido)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblDomicilio)
                    .addComponent(lblTelefono)
                    .addComponent(lblCelular)
                    .addComponent(lblEstadoCivil)
                    .addComponent(lblCorreo)
                    .addComponent(lblMatricula))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDni)
                    .addComponent(txtNombre)
                    .addComponent(txtApellido)
                    .addComponent(txtDomicilio)
                    .addComponent(txtTelefono)
                    .addComponent(txtCelular)
                    .addComponent(cbEstadoCivil, 0, 140, Short.MAX_VALUE)
                    .addComponent(txtCorreo)
                    .addComponent(txtFechaNacimiento)
                    .addComponent(txtMatricula)
                    .addComponent(lblAviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConfirmarEdicion)))
                .addContainerGap(846, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMostrarTodo)
                            .addComponent(txtBuscarDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAviso)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDni)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFechaNacimiento)
                            .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDomicilio)
                            .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCelular)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEstadoCivil)
                            .addComponent(cbEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMatricula)
                            .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEditar)
                    .addComponent(btnConfirmarEdicion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDomicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDomicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDomicilioActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if( txtDni.getText().trim().isEmpty()){ 
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtNombre.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtApellido.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtFechaNacimiento.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtDomicilio.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtCelular.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else if(txtCorreo.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
    }else if(txtMatricula.getText().trim().isEmpty()){
         JOptionPane.showMessageDialog(null, "Completar los campos obligatorios", "Error", JOptionPane.WARNING_MESSAGE);
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
         if(datos.agregarMedico(captar())){
            JOptionPane.showMessageDialog(null, "se registro con exito");
            listar();
            this.limpiarTexto();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ya existe médico con ese DNI", "Error", JOptionPane.ERROR_MESSAGE);
        }}
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        listar();
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       
        
        Medico med;
        int fila = jtMedicos.getSelectedRow();
        med = lista.get(fila);
        this.mostrarTodo(med);
        
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtMedicos.getSelectedRow();
        String s = jtMedicos.getModel().getValueAt(fila, 0).toString();
        datos.eliminarMedico(Integer.parseInt(s));
        listar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtBuscarDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarDniKeyReleased
        // TODO add your handling code here:
        filtrar();
    }//GEN-LAST:event_txtBuscarDniKeyReleased

    private void txtBuscarDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarDniActionPerformed

    private void btnConfirmarEdicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarEdicionActionPerformed
        // TODO add your handling code here:
        Medico m = new Medico();
        m = this.captar();
        if(datos.editarMedico(m))
        {
          JOptionPane.showMessageDialog(null, "se edito con exito");
          limpiarTexto();
          listar();
        }
    }//GEN-LAST:event_btnConfirmarEdicionActionPerformed

    private void txtDniFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDniFocusLost
         if(txtDni.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtDniFocusLost

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
          if(txtNombre.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
         if(txtApellido.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtFechaNacimientoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaNacimientoFocusLost
         if(txtFechaNacimiento.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtFechaNacimientoFocusLost

    private void txtDomicilioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDomicilioFocusLost
         if(txtDomicilio.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtDomicilioFocusLost

    private void txtCelularFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCelularFocusLost
          if(txtCelular.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtCelularFocusLost

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
          if(txtCorreo.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtCorreoFocusLost

    private void txtMatriculaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMatriculaFocusLost
         if(txtMatricula.getText().trim().isEmpty()){
         lblAviso.setVisible(true);
     }else{
         lblAviso.setVisible(false);
     }
    }//GEN-LAST:event_txtMatriculaFocusLost

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
            java.util.logging.Logger.getLogger(RegistroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMedico().setVisible(true);
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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtMedicos;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDni;
    private javax.swing.JLabel lblDomicilio;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBuscarDni;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}