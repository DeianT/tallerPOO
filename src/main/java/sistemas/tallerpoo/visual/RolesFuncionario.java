package sistemas.tallerpoo.visual;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.Rol;
import sistemas.tallerpoo.datos.FuncionarioDatos;
import sistemas.tallerpoo.datos.RolDatos;

/**
 *
 * @author Thiago
 */
public class RolesFuncionario extends javax.swing.JFrame {
    FuncionarioDatos fDatos = new FuncionarioDatos();
    RolDatos rolDatos = new RolDatos();
    String[] confirmar = {"SI", "NO"};
   
    public RolesFuncionario() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarCombo();
        mostrarNombre(cbDnis, txtNombreApellido, fDatos.obtenerFuncionarios());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlTodosLosRoles = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlRolesFuncionario = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        cbDnis = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtNombreApellido = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jlTodosLosRoles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Administrador de Sistema", "Medico", "Recursos Humanos", "Admision de Pacientes", "Compras", "Auditoria", "Gestion", "Registros Medicos", "Informatica" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlTodosLosRoles);

        jScrollPane2.setViewportView(jlRolesFuncionario);

        btnAgregar.setText("Asignar rol");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        cbDnis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDnisActionPerformed(evt);
            }
        });

        txtNombreApellido.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("Nombre del funcionario");

        btnEliminar.setText("Eliminar rol");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(71, 71, 71)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbDnis, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(113, 113, 113))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2)
                        .addGap(81, 81, 81)
                        .addComponent(txtNombreApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(cbDnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(73, 73, 73)
                        .addComponent(btnEliminar)
                        .addGap(60, 60, 60))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int dni = Integer.parseInt((String) cbDnis.getSelectedItem());
        Rol rol = new Rol(jlTodosLosRoles.getSelectedValue(), dni);
        
        if(rol.getNombre() == null){//controla que haya un rol seleccionado
            JOptionPane.showMessageDialog(null, "Ningún rol seleccionado");
            return;
        }
        if(rolDatos.existeRol(rol)){
            JOptionPane.showMessageDialog(null, "El funcionario ya tiene ese rol asignado");
            return;
        }

        int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea agregar el rol " + jlTodosLosRoles.getSelectedValue().toUpperCase() + " al funcionario con dni " + cbDnis.getSelectedItem().toString() + "?", "confirmacion", 0, JOptionPane.QUESTION_MESSAGE, null, confirmar, "SI");
        
        if(opcion == 0)
        {
            rolDatos.agregarRol(rol);
            listarRoles();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbDnisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDnisActionPerformed
        jlRolesFuncionario.removeAll();
        mostrarNombre(cbDnis, txtNombreApellido, fDatos.obtenerFuncionarios());
        listarRoles();
    }//GEN-LAST:event_cbDnisActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int dni = Integer.parseInt((String) cbDnis.getSelectedItem());
        Rol rol = new Rol(jlRolesFuncionario.getSelectedValue(), dni);
        if(rol.getNombre() == null){
            JOptionPane.showMessageDialog(null, "Ningún rol seleccionado");
            return;
        }
        
        int opcion = JOptionPane.showOptionDialog(null, "¿Está seguro que desea eliminar el rol " + jlTodosLosRoles.getSelectedValue().toUpperCase() + " al funcionario con dni " + cbDnis.getSelectedItem().toString() + "?", "confirmacion", 0, JOptionPane.QUESTION_MESSAGE, null, confirmar, "SI");
        
        if(opcion == 0)
        {
            rolDatos.eliminarRol(rol);
            listarRoles();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(RolesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RolesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RolesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RolesFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RolesFuncionario().setVisible(true);
            }
        });
    }
    
    private void mostrarNombre(JComboBox cb, JLabel txt, ArrayList<Funcionario> lista)
    {
        Funcionario m = lista.get(cb.getSelectedIndex());
        txt.setText(m.getNombre() + " " + m.getApellido());
    }
    
    private void llenarCombo(){
        for(Funcionario f: fDatos.obtenerFuncionarios()){
            cbDnis.addItem(Integer.toString(f.getDni()));
        }
    }
    
    private void listarRoles(){
        int dni = Integer.parseInt((String) cbDnis.getSelectedItem());
        ArrayList<Rol> roles = rolDatos.obtenerRolesFuncionario(dni);
        String[] arr = new String[roles.size()];
        
        for(int i = 0; i < roles.size(); i++){
            arr[i] = roles.get(i).getNombre();
        }
        jlRolesFuncionario.setListData(arr);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> cbDnis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jlRolesFuncionario;
    private javax.swing.JList<String> jlTodosLosRoles;
    private javax.swing.JLabel txtNombreApellido;
    // End of variables declaration//GEN-END:variables
}