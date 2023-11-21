package sistemas.tallerpoo.visual;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.Box;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.BoxDatos;

/**
 * Ventana de gestión para la lista de espera de admisiones en boxes del
 * sistema.
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
     * Inicializa la ventana de gestión de la lista de espera de admisiones.
     * Carga la interfaz gráfica y muestra las listas de admisiones y boxes.
     */
    public ListaEspera() {
        initComponents();
        this.setLocationRelativeTo(null);
        modeloAd = new DefaultTableModel();
        modeloBox = new DefaultTableModel();
        listar();
    }

    /**
     * Actualiza la visualización de las listas de admisiones y boxes en las
     * tablas correspondientes. Muestra las admisiones sin box asignado en una
     * tabla y los boxes en otra, actualizando la interfaz.
     */
    public void listar() {
        listaAdmision = datos.admisionesSinBoxAsignado();
        limpiarTabla();
        modeloAd = (DefaultTableModel) jtAdmisiones.getModel();
        Object[] ob = new Object[7];

        for (int i = 0; i < listaAdmision.size(); i++) {
            ob[0] = listaAdmision.get(i).getTriage().getColorModificado();
            ob[1] = listaAdmision.get(i).getMotivo();
            ob[2] = listaAdmision.get(i).getFecha() + " " + listaAdmision.get(i).getHora();
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

        for (int i = 1; i <= listaBox.cantidad(); i++) {
            ob[0] = listaBox.obtenerBox(i).getNumero();
            ob[1] = listaBox.obtenerBox(i).isOcupado();
            modeloBox.addRow(ob);
        }
        jtBoxes.setModel(modeloBox);
    }

    /**
     * Limpia las filas de las tablas de admisiones y boxes. Elimina las filas
     * existentes en los modelos de las tablas para su posterior actualización.
     */
    public void limpiarTabla() {
        for (int i = 0; i < modeloAd.getRowCount(); i++) {
            modeloAd.removeRow(i--);
        }
        for (int i = 0; i < modeloBox.getRowCount(); i++) {
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
                "Nivel triage", "Motivo", "Ingreso", "DNI", "Nombre", "Apellido", "Fecha de Nacimiento"
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

    /**
     * Maneja el evento de confirmar la asignación de un paciente a un box.
     * Obtiene la fila seleccionada en la tabla de admisiones y la fila
     * seleccionada en la tabla de boxes. Asigna al paciente seleccionado el box
     * elegido y actualiza la información en las listas y tablas. Muestra
     * mensajes de error si no se selecciona un paciente o si el box está
     * ocupado. Notifica al usuario sobre la asignación del paciente al box.
     * Actualiza la lista de admisiones y boxes.
     *
     * @param evt Evento del botón Confirmar.
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int fila1 = jtAdmisiones.getSelectedRow();
        int fila2 = jtBoxes.getSelectedRow();
        try {
            admision = listaAdmision.get(fila1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        box = listaBox.obtenerBox(fila2 + 1);
        if (box == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un box", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (box.isOcupado()) {
            JOptionPane.showMessageDialog(null, "El box está ocupado");
            return;
        }

        admision.setBox(box);
        datos.editarAdmision(admision);
        listaBox.ocuparDesocupar(box.getNumero(), true);

        listar();
        JOptionPane.showMessageDialog(null, "El paciente " + admision.getPaciente().getDni() + " fue asignado al box " + box.getNumero());
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * El método main es el punto de entrada del programa. Inicializa la ventana
     * de ListaEspera.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String args[]) {

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
