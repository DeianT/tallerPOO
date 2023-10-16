/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistemas.tallerpoo.visual;

import static java.awt.image.ImageObserver.HEIGHT;
import java.util.Date;
import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.clasesLogicas.ListaBox;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Persona;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.datos.AdmisionDatos;

/**
 *
 * @author Deian
 */
public class RegistroAdmision extends javax.swing.JFrame {
    private static Paciente paciente;
    private static Triage triage;
    
    public RegistroAdmision() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        realizarTriageBoton = new javax.swing.JButton();
        RegistrarPacienteBoton = new javax.swing.JButton();
        motivoCampo = new javax.swing.JTextField();
        motivoEtiqueta = new javax.swing.JLabel();
        guardarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        realizarTriageBoton.setText("Realizar Triage");
        realizarTriageBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                realizarTriageBotonActionPerformed(evt);
            }
        });

        RegistrarPacienteBoton.setText("Cargar Datos Paciente");
        RegistrarPacienteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarPacienteBotonActionPerformed(evt);
            }
        });

        motivoCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motivoCampoActionPerformed(evt);
            }
        });

        motivoEtiqueta.setText("Motivo");

        guardarBoton.setText("Guardar");
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(motivoEtiqueta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(motivoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(RegistrarPacienteBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(guardarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(realizarTriageBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(motivoCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(motivoEtiqueta))
                .addGap(38, 38, 38)
                .addComponent(RegistrarPacienteBoton)
                .addGap(45, 45, 45)
                .addComponent(realizarTriageBoton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(guardarBoton)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void realizarTriageBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_realizarTriageBotonActionPerformed
        RegistroTriage r = new RegistroTriage();
        r.setVisible(true);
//        Triage t = r.getTriage();
//        System.out.println("triage");
    }//GEN-LAST:event_realizarTriageBotonActionPerformed

    private void motivoCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motivoCampoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motivoCampoActionPerformed

    private void RegistrarPacienteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarPacienteBotonActionPerformed
        //abrir registro paciente
    }//GEN-LAST:event_RegistrarPacienteBotonActionPerformed

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        try{
            
            Admision a = new Admision();
            a.setFecha(new Date());
            a.setHora(new Date());
            a.setMotivo(motivoCampo.getText());
            paciente = new Paciente(123, "asfd", "gasa", new Date(), "", 1561, "645816", "faf", "sdgg", new Persona());
            a.setPaciente(paciente);
            a.setTriage(triage);
            a.setBox(new Box());
            new AdmisionDatos().agregarAdmision(a);
            JOptionPane.showMessageDialog(null, "se ingreso con exito");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", HEIGHT);
        }
    }//GEN-LAST:event_guardarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAdmision.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAdmision().setVisible(true);
            }
        });
    }

    public static void setPaciente(Paciente paciente) {
        RegistroAdmision.paciente = paciente;
    }

    public static void setTriage(Triage triage) {
        RegistroAdmision.triage = triage;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RegistrarPacienteBoton;
    private javax.swing.JButton guardarBoton;
    private javax.swing.JTextField motivoCampo;
    private javax.swing.JLabel motivoEtiqueta;
    private javax.swing.JButton realizarTriageBoton;
    // End of variables declaration//GEN-END:variables
}