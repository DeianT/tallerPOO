package sistemas.tallerpoo.visual;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.ControlRoles;
import sistemas.tallerpoo.clasesLogicas.HistoriaClinica;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.BoxDatos;
import sistemas.tallerpoo.datos.HistoriaClinicaDatos;

/**
 *
 * @author Deian
 */
public class Atencion extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private ArrayList<Admision> listaAdmision;
    private AdmisionDatos datos = new AdmisionDatos();
    private Admision admision = null;
    

    /**
     * Creates new form Atencion
     */
    public Atencion() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        listar();
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
        jtAdmisiones = new javax.swing.JTable();
        btnAlta = new javax.swing.JButton();
        btnHistoriaClinica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jtAdmisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Box", "Nivel triage", "Motivo", "Ingreso", "DNI", "Nombre", "Apellido", "Fecha de Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAdmisiones);

        btnAlta.setText("Dar de alta");
        btnAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaActionPerformed(evt);
            }
        });

        btnHistoriaClinica.setText("Historia clínica");
        btnHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoriaClinicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(426, Short.MAX_VALUE)
                .addComponent(btnHistoriaClinica)
                .addGap(56, 56, 56)
                .addComponent(btnAlta)
                .addGap(48, 48, 48))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(462, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlta)
                    .addComponent(btnHistoriaClinica))
                .addGap(16, 16, 16))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(55, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaActionPerformed
        int fila = jtAdmisiones.getSelectedRow();
        try{
            admision = listaAdmision.get(fila);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ningún paciente seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        admision.setDadaDeAlta(true);
        datos.editarAdmision(admision);
        //reducir la cantidad de pacientes en el box
        new BoxDatos().ocuparDesocupar(admision.getBox().getNumero(), false);//esto posiblemente haya que modificar
        
        String diagnostico = JOptionPane.showInputDialog(null, "Ingrese el diagnóstico"); 
        while(diagnostico == null || diagnostico.isEmpty())     
        {
            diagnostico = JOptionPane.showInputDialog(null, "Ingrese el diagnóstico");   
        }
        
        String lugar = JOptionPane.showInputDialog(null, "Ingrese el lugar de atención"); 
        while(lugar == null || lugar.isEmpty())     
        {
            lugar = JOptionPane.showInputDialog(null, "Ingrese el lugar de atención");   
        }
        
        String diagnosticoClinico = JOptionPane.showInputDialog(null, "Ingrese el resultado de estudios"); 
        while(diagnosticoClinico == null || diagnosticoClinico.isEmpty())     
        {
            diagnosticoClinico = JOptionPane.showInputDialog(null, "Ingrese el resultado de estudios");   
        }
        
        //Se crean dos objetos de fecha para poder sacar hora y fecha actuales.
        Date fechita = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm");
        String fecha = formatofecha.format(fechita);
        String hora = formatohora.format(fechita);
        
        HistoriaClinica h = new HistoriaClinica();
        h.setDniPaciente(admision.getPaciente().getDni());
        h.setDniMedico(ControlRoles.getUsuarioActual().getDniFuncionario());
        h.setFecha(fecha);
        h.setHora(hora);
        h.setDiagnostico(diagnostico);
        h.setLugar(lugar);
        h.setDiagnosticoClinico(diagnosticoClinico);
        
        new HistoriaClinicaDatos().agregarHistoriaClinica(h);

        listar();
        JOptionPane.showMessageDialog(null, "El paciente fue dado de alta");
    }//GEN-LAST:event_btnAltaActionPerformed

    private void btnHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoriaClinicaActionPerformed
        int fila = jtAdmisiones.getSelectedRow();
        try{//controla que haya una admisión seleccionada
            admision = listaAdmision.get(fila);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ningún paciente seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        new FormularioHistoriaClinica(admision.getPaciente().getDni()).setVisible(true);
    }//GEN-LAST:event_btnHistoriaClinicaActionPerformed

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
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlta;
    private javax.swing.JButton btnHistoriaClinica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAdmisiones;
    // End of variables declaration//GEN-END:variables

    private void listar() {
        listaAdmision = datos.admisionesNoDadasDeAlta();
        limpiarTabla();
        modelo = (DefaultTableModel) jtAdmisiones.getModel();
        Object[] ob = new Object[8];
        
        for(int i = 0; i < listaAdmision.size(); i++)
        {
            ob[0] = listaAdmision.get(i).getBox().getNumero();
            ob[1] = listaAdmision.get(i).getTriage().getColorModificado();
            ob[2] = listaAdmision.get(i).getMotivo();
            ob[3] = listaAdmision.get(i).getFecha() + " " + listaAdmision.get(i).getHora();
            ob[4] = listaAdmision.get(i).getPaciente().getDni();
            ob[5] = listaAdmision.get(i).getPaciente().getNombre();
            ob[6] = listaAdmision.get(i).getPaciente().getApellido();
            ob[7] = listaAdmision.get(i).getPaciente().getFechaNacimiento();
            modelo.addRow(ob);
        }
        jtAdmisiones.setModel(modelo); 
    }

    private void limpiarTabla() {
        for(int i = 0; i < modelo.getRowCount(); i++){
            modelo.removeRow(i--);
        }
    }
}
