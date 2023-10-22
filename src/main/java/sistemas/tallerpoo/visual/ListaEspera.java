package sistemas.tallerpoo.visual;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.BoxDatos;

/**
 *
 * @author Thiago
 */
public class ListaEspera extends javax.swing.JFrame {
    private DefaultTableModel modeloAd;
    private DefaultTableModel modeloBox;
    private ArrayList<Admision> listaAdmision;
    private AdmisionDatos datos = new AdmisionDatos();
    private Admision admision = null;
    private BoxDatos listaBox = new BoxDatos();
    private Box box = null;

    /**
     * Creates new form Triage
     */
    public ListaEspera() {
        initComponents();
        this.setLocationRelativeTo(null);
        modeloAd = new DefaultTableModel();
        modeloBox = new DefaultTableModel();
        listar();
    }
    
    public void listar()
    {   
        listaAdmision = datos.admisionesSinBoxAsignado();
        limpiarTabla();
        modeloAd = (DefaultTableModel) jtAdmisiones.getModel();
        Object[] ob = new Object[7];
        
        for(int i = 0; i < listaAdmision.size(); i++)
        {
            ob[0] = listaAdmision.get(i).getTriage().getColorModificado();
            ob[1] = listaAdmision.get(i).getMotivo();
            ob[2] = listaAdmision.get(i).getHora();
            ob[3] = listaAdmision.get(i).getPaciente().getDni();
            ob[4] = listaAdmision.get(i).getPaciente().getNombre();
            ob[5] = listaAdmision.get(i).getPaciente().getApellido();
            ob[6] = listaAdmision.get(i).getPaciente().getFechaNacimiento();
            modeloAd.addRow(ob);
        }
        jtAdmisiones.setModel(modeloAd); 
        
//        jtAdmisiones.setAutoCreateRowSorter(true);
//        sorter = new TableRowSorter<>(modelo);
//        jtAdmisiones.setRowSorter(sorter);
        
        modeloBox = (DefaultTableModel) jtBoxes.getModel();
        ob = new Object[2];
        
        for(int i = 1; i <= listaBox.cantidad(); i++)
        {
            ob[0] = listaBox.obtenerBox(i).getNumero();
            ob[1] = listaBox.obtenerBox(i).isOcupado();
            modeloBox.addRow(ob);
        }
        jtBoxes.setModel(modeloBox);
    }
    
    public void limpiarTabla()
    {
        for(int i = 0; i < modeloAd.getRowCount(); i++)
        {
            modeloAd.removeRow(i--);
        }
        for(int i = 0; i < modeloBox.getRowCount(); i++){
            modeloBox.removeRow(i--);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConfirmar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAdmisiones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtBoxes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jtAdmisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nivel triage", "Motivo", "Hora ingreso", "DNI", "Nombre", "Apellido", "Fecha de Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAdmisiones);

        jtBoxes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° box", "Ocupado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtBoxes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnConfirmar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(btnConfirmar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int fila1 = jtAdmisiones.getSelectedRow();
        int fila2 = jtBoxes.getSelectedRow();
        try{
            admision = listaAdmision.get(fila1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        box = listaBox.obtenerBox(fila2 + 1);
        if(box == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un box", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        admision.setBox(box);
        datos.editarAdmision(admision);
        listaBox.ocuparDesocupar(box.getNumero(), true);
        
        listar();
        JOptionPane.showMessageDialog(null, "El paciente " + admision.getPaciente().getDni() + " fue asignado al box " + box.getNumero());
    }//GEN-LAST:event_btnConfirmarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEspera.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEspera().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtAdmisiones;
    private javax.swing.JTable jtBoxes;
    // End of variables declaration//GEN-END:variables
}