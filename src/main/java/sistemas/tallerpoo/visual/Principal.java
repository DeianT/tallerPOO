package sistemas.tallerpoo.visual;
import sistemas.tallerpoo.clasesLogicas.ControlRoles;

/**
 *
 * @author Thiago
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jmCerrarSesion = new javax.swing.JMenuItem();
        jmRegistrar = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmRegistroFuncionario = new javax.swing.JMenuItem();
        jmRoles = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmRegistroAdmision = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jmListaEspera = new javax.swing.JMenuItem();
        jmVerBoxes = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        mHistoriaClinica = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(720, 600));

        jMenu5.setText("Usuario");

        jmCerrarSesion.setText("Cerrar Sesion");
        jmCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCerrarSesionActionPerformed(evt);
            }
        });
        jMenu5.add(jmCerrarSesion);

        jmRegistrar.setText("Registrar");
        jmRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistrarActionPerformed(evt);
            }
        });
        jMenu5.add(jmRegistrar);

        jmSalir.setText("Salir");
        jmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSalirActionPerformed(evt);
            }
        });
        jMenu5.add(jmSalir);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Pacientes");

        jMenuItem1.setText("Registro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Medicos");

        jMenuItem2.setText("Registro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Especialidades");

        jMenuItem3.setText("Especialidades");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Triage");

        jMenuItem4.setText("Realizar Triage");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu6.setText("Funcionarios");

        jmRegistroFuncionario.setText("Registro");
        jmRegistroFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistroFuncionarioActionPerformed(evt);
            }
        });
        jMenu6.add(jmRegistroFuncionario);

        jmRoles.setText("Roles");
        jmRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRolesActionPerformed(evt);
            }
        });
        jMenu6.add(jmRoles);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Admision");

        jmRegistroAdmision.setText("Registro");
        jmRegistroAdmision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmRegistroAdmisionActionPerformed(evt);
            }
        });
        jMenu7.add(jmRegistroAdmision);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("Atención");

        jmListaEspera.setText("Lista espera");
        jmListaEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListaEsperaActionPerformed(evt);
            }
        });
        jMenu8.add(jmListaEspera);

        jmVerBoxes.setText("Ver boxes");
        jmVerBoxes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmVerBoxesActionPerformed(evt);
            }
        });
        jMenu8.add(jmVerBoxes);

        jMenuBar1.add(jMenu8);

        jMenu9.setText("Historia Clinica");

        mHistoriaClinica.setText("Ver Historias Clinicas");
        mHistoriaClinica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHistoriaClinicaActionPerformed(evt);
            }
        });
        jMenu9.add(mHistoriaClinica);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RegistroPaciente pac = new RegistroPaciente();
        pac.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RegistroMedico m = new RegistroMedico();
        m.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        EspecialidadesMedico esp = new EspecialidadesMedico();
        esp.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        RealizarTriage t = new RealizarTriage();
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCerrarSesionActionPerformed
        ControlRoles.setUsuarioActual(null);
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jmCerrarSesionActionPerformed

    private void jmRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistrarActionPerformed
        RegistroUsuario reg = new RegistroUsuario();
        reg.setVisible(true);
    }//GEN-LAST:event_jmRegistrarActionPerformed

    private void jmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jmSalirActionPerformed

    private void jmRegistroFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistroFuncionarioActionPerformed
        RegistroFuncionario fun = new RegistroFuncionario();
        fun.setVisible(true);
    }//GEN-LAST:event_jmRegistroFuncionarioActionPerformed

    private void jmRegistroAdmisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRegistroAdmisionActionPerformed
        RegistroAdmision adm = new RegistroAdmision();
        adm.setVisible(true);
    }//GEN-LAST:event_jmRegistroAdmisionActionPerformed

    private void jmListaEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListaEsperaActionPerformed
        new ListaEspera().setVisible(true);
    }//GEN-LAST:event_jmListaEsperaActionPerformed

    private void jmVerBoxesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmVerBoxesActionPerformed
        new Atencion().setVisible(true);
    }//GEN-LAST:event_jmVerBoxesActionPerformed

    private void mHistoriaClinicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHistoriaClinicaActionPerformed
        // TODO add your handling code here:
        new FormularioHistoriaClinica().setVisible(true);
    }//GEN-LAST:event_mHistoriaClinicaActionPerformed

    private void jmRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmRolesActionPerformed
        new RolesFuncionario().setVisible(true);
    }//GEN-LAST:event_jmRolesActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jmCerrarSesion;
    private javax.swing.JMenuItem jmListaEspera;
    private javax.swing.JMenuItem jmRegistrar;
    private javax.swing.JMenuItem jmRegistroAdmision;
    private javax.swing.JMenuItem jmRegistroFuncionario;
    private javax.swing.JMenuItem jmRoles;
    private javax.swing.JMenuItem jmSalir;
    private javax.swing.JMenuItem jmVerBoxes;
    private javax.swing.JMenuItem mHistoriaClinica;
    // End of variables declaration//GEN-END:variables
}
