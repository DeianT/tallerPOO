package sistemas.tallerpoo.visual;

import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.NivelTriage;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.datos.TriageDatos;

/**
 *
 * @author Thiago
 */
public class RealizarTriage extends javax.swing.JFrame {

    /**
     * Creates new form Triage
     */
    public RealizarTriage() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void capturar(Triage triage){
        triage.setRespiracion(cboRespiracion.getSelectedItem().toString());
        triage.setPulso(cboPulso.getSelectedItem().toString());
        triage.setEstadoMental(cboEstadoMental.getSelectedItem().toString());
        triage.setConciencia(cboConciencia.getSelectedItem().toString());
        triage.setDificultadRespiratoria(cboDolorPecho.getSelectedItem().toString());
        triage.setLesionesGraves(cboLesionesGraves.getSelectedItem().toString());
        triage.setEdad(cboEdad.getSelectedItem().toString());
        triage.setFiebre(cboFiebre.getSelectedItem().toString());
        triage.setVomitos(cboVomitos.getSelectedItem().toString());
        triage.setDolorAbdominal(cboDolorAbominal.getSelectedItem().toString());
        triage.setSignosDeShock(cboSignosShock.getSelectedItem().toString());
        triage.setLesionesLeves(cboLesionesLeves.getSelectedItem().toString());
        triage.setSangrado(cboSangrado.getSelectedItem().toString());
    }
    
    public int sumar (Triage a ){
        int contador = 0;
        switch (cboRespiracion.getSelectedItem().toString()){
            case "Normal":
                break;
            case "Dificultad respiratoria moderada":
                contador+=1;
                break;
            case "Dificultad respiratoria grave":
                contador+=2;
                break;      
        }
        
        if(cboPulso.getSelectedItem().toString() == "Anormal"){
            contador+=1;
        }
        
        switch (cboEstadoMental.getSelectedItem().toString()){
            case "Normal":
                break;
            case "Confusion Leve":
                contador+=1;
                break;
            case "Confusion Grave":
                contador+=2;
                break;      
        }
        
        if(cboConciencia.getSelectedItem().toString() == "Perdida de conciencia"){
            contador+=3;
        }
        
        if(cboDolorPecho.getSelectedItem().toString() == "Presente"){
            contador+=1;
        }
        
        if(cboLesionesGraves.getSelectedItem().toString() == "Presentes"){
            contador+=2;
        }
        
        if(cboEdad.getSelectedItem().toString() == "Niño o Anciano"){
            contador+=1;
        }
        
        switch (cboFiebre.getSelectedItem().toString()){
            case "Sin Fiebre":
                break;
            case "Fiebre moderada":
                contador+=1;
                break;
            case "Fiebre alta":
                contador+=2;
                break;      
        }
        
        switch (cboVomitos.getSelectedItem().toString()){
            case "Sin vomitos":
                break;
            case "Vomitos moderados":
                contador+=1;
                break;
            case "Vomitos intesos":
                contador+=2;
                break;      
        }
        
        switch (cboDolorAbominal.getSelectedItem().toString()){
            case "No presente":
                break;
            case "Dolor abdominal moderado":
                contador+=1;
                break;
            case "Dolor abdominal severo":
                contador+=2;
                break;      
        }
        
        if(cboSignosShock.getSelectedItem().toString() == "Presentes"){
            contador+=3;
        }
        
        if(cboLesionesLeves.getSelectedItem().toString() == "Presentes"){
            contador+=1;
        }
        
        switch (cboSangrado.getSelectedItem().toString()){
            case "No presente":
                break;
            case "Sangrado moderado":
                contador+=1;
                break;
            case "Sangrado intenso":
                contador+=2;
                break;      
        }
        return contador;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cboLesionesGraves = new javax.swing.JComboBox<>();
        cboEdad = new javax.swing.JComboBox<>();
        cboFiebre = new javax.swing.JComboBox<>();
        cboVomitos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboDolorAbominal = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboSignosShock = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboLesionesLeves = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboSangrado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cboRespiracion = new javax.swing.JComboBox<>();
        cboPulso = new javax.swing.JComboBox<>();
        cboEstadoMental = new javax.swing.JComboBox<>();
        cboConciencia = new javax.swing.JComboBox<>();
        cboDolorPecho = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboLesionesGraves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        cboEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Adulto", "Niño o anciano" }));
        cboEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEdadActionPerformed(evt);
            }
        });

        cboFiebre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin fiebre", "Fiebre moderada", "Fiebre alta" }));

        cboVomitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin vomitos", "Vomitos moderados", "Vomitos intensos" }));
        cboVomitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVomitosActionPerformed(evt);
            }
        });

        jLabel1.setText("Respiracion");

        cboDolorAbominal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presente", "Dolor abdominal moderado", "Dolor abdominal severo" }));

        jLabel2.setText("Estado Mental");

        cboSignosShock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        jLabel3.setText("Pulso");

        cboLesionesLeves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        jLabel4.setText("Conciencia");

        cboSangrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presente", "Sangrado moderado", "Sangrado intenso" }));
        cboSangrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSangradoActionPerformed(evt);
            }
        });

        jLabel5.setText("Dolor de Pecho/Dif resp");

        jLabel6.setText("Lesiones Graves");

        jLabel7.setText("Edad");

        jLabel8.setText("Fiebre");

        jLabel9.setText("Vomitos");

        jLabel10.setText("Dolor Abdominal");

        jLabel11.setText("Signos de Shock");

        jLabel12.setText("Lesiones Leves");

        jLabel13.setText("Sangrado");

        cboRespiracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Dificultad respiratoria moderada", "Dificultad respiratoria grave" }));

        cboPulso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Anormal" }));

        cboEstadoMental.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Confusion leve", "Confusion grave" }));

        cboConciencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Conciente y alerta", "Perdida de conciencia" }));
        cboConciencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboConcienciaActionPerformed(evt);
            }
        });

        cboDolorPecho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presente", "Presente" }));

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(172, 172, 172)
                        .addComponent(cboSangrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(138, 138, 138)
                        .addComponent(cboLesionesLeves, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(133, 133, 133)
                        .addComponent(cboSignosShock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(134, 134, 134)
                        .addComponent(cboDolorAbominal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(181, 181, 181)
                        .addComponent(cboVomitos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(191, 191, 191)
                        .addComponent(cboFiebre, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(197, 197, 197)
                        .addComponent(cboEdad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(132, 132, 132)
                        .addComponent(cboLesionesGraves, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(148, 148, 148)
                        .addComponent(cboEstadoMental, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(194, 194, 194)
                        .addComponent(cboPulso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(159, 159, 159)
                        .addComponent(cboRespiracion, 0, 236, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDolorPecho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboConciencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(119, 119, 119))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboRespiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboPulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstadoMental, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboConciencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboDolorPecho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboLesionesGraves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboFiebre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cboVomitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cboDolorAbominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboSignosShock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cboLesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboSangrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnConfirmar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboEdadActionPerformed

    private void cboVomitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVomitosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboVomitosActionPerformed

    private void cboSangradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSangradoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSangradoActionPerformed

    private void cboConcienciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboConcienciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboConcienciaActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        Triage t = new Triage();
        int contador = 0;
        String color = "";

        this.capturar(t);

        contador = this.sumar(t);

        if(contador >= 0 && contador <= 4 ){
            color = "Verde";
        }
        else if (contador >= 5 && contador <= 9  ){
            color = "Amarillo";
        }
        else if (contador >=10 && contador <= 14){
            color = "Naranja";
        }
        else if (contador >= 15){
            color = "Rojo";
        }
        
        
        if(cboRespiracion.getSelectedIndex()!=0 && cboPulso.getSelectedIndex()!=0 && cboEstadoMental.getSelectedIndex()!=0 && cboConciencia.getSelectedIndex()!=0 && cboDolorPecho.getSelectedIndex()!=0 && cboLesionesGraves.getSelectedIndex()!=0 && cboEdad.getSelectedIndex()!=0 && cboFiebre.getSelectedIndex()!=0 && cboVomitos.getSelectedIndex()!=0 && cboDolorAbominal.getSelectedIndex()!=0 && cboSignosShock.getSelectedIndex()!=0 && cboLesionesLeves.getSelectedIndex()!=0 && cboSangrado.getSelectedIndex()!=0 )
        {
          t.setColor(NivelTriage.valueOf(color));
          t.setColorModificado(NivelTriage.valueOf(color));

        JOptionPane.showMessageDialog(this, "se ah guardado con exito " + "\n El nivel de atencion es de " + color.toUpperCase());
        new TriageDatos().agregarTriage(t);
        
        RegistroAdmision.setTriage(t);  
        }else
        {
            JOptionPane.showMessageDialog(null, "Faltan completar casillas");
        }
 
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        cboRespiracion.setSelectedIndex(0);
        cboPulso.setSelectedIndex(0);
        cboEstadoMental.setSelectedIndex(0);
        cboConciencia.setSelectedIndex(0);
        cboDolorPecho.setSelectedIndex(0);
        cboLesionesGraves.setSelectedIndex(0);
        cboEdad.setSelectedIndex(0);
        cboFiebre.setSelectedIndex(0);
        cboVomitos.setSelectedIndex(0);
        cboDolorAbominal.setSelectedIndex(0);
        cboSignosShock.setSelectedIndex(0);
        cboLesionesLeves.setSelectedIndex(0);
        cboSangrado.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(RealizarTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarTriage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cboConciencia;
    private javax.swing.JComboBox<String> cboDolorAbominal;
    private javax.swing.JComboBox<String> cboDolorPecho;
    private javax.swing.JComboBox<String> cboEdad;
    private javax.swing.JComboBox<String> cboEstadoMental;
    private javax.swing.JComboBox<String> cboFiebre;
    private javax.swing.JComboBox<String> cboLesionesGraves;
    private javax.swing.JComboBox<String> cboLesionesLeves;
    private javax.swing.JComboBox<String> cboPulso;
    private javax.swing.JComboBox<String> cboRespiracion;
    private javax.swing.JComboBox<String> cboSangrado;
    private javax.swing.JComboBox<String> cboSignosShock;
    private javax.swing.JComboBox<String> cboVomitos;
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
    // End of variables declaration//GEN-END:variables
}
