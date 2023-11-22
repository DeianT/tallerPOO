package sistemas.tallerpoo.visual;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.ControlRoles;
import sistemas.tallerpoo.clasesLogicas.NivelTriage;
import sistemas.tallerpoo.clasesLogicas.Triage;
import sistemas.tallerpoo.datos.AdmisionDatos;
import sistemas.tallerpoo.datos.TriageDatos;

/**
 * Ventana para realizar el proceso de triage. Contiene métodos para listar las
 * admisiones sin triage asignado y limpiar la tabla de datos. Se encarga de
 * mostrar la información de las admisiones para realizar el triage.
 */
public class RealizarTriage extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private ArrayList<Admision> lista;
    private AdmisionDatos datos = new AdmisionDatos();
    private Admision admision = null;
    private String[] editar = {"Editar", "Terminar"};
    private String[] colores = {"Azul", "Verde", "Amarillo", "Naranja", "Rojo"};
    private String[] op = {"ok"};

    /**
     * Inicializa la ventana, configurando la ubicación relativa y el modelo de
     * la tabla.
     */
    public RealizarTriage() {
        initComponents();
        this.setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        listar();
    }

    /**
     * Lista las admisiones sin triage. Limpia la tabla existente y agrega
     * información de admisiones sin triage al modelo de la tabla.
     */
    public void listar() {
        lista = datos.admisionesSinTriage();
        limpiarTabla();
        modelo = (DefaultTableModel) jtAdmisiones.getModel();
        Object[] ob = new Object[6];

        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getMotivo();
            ob[1] = lista.get(i).getFecha() + " " + lista.get(i).getHora();
            ob[2] = lista.get(i).getPaciente().getDni();
            ob[3] = lista.get(i).getPaciente().getNombre();
            ob[4] = lista.get(i).getPaciente().getApellido();
            ob[5] = lista.get(i).getPaciente().getFechaNacimiento();
            modelo.addRow(ob);
        }
        jtAdmisiones.setModel(modelo);

//        jtAdmisiones.setAutoCreateRowSorter(true);
//        sorter = new TableRowSorter<>(modelo);
//        jtAdmisiones.setRowSorter(sorter);
    }

    /**
     * Limpia la tabla de datos.
     */
    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i--);
        }
    }

    /**
     * Captura y actualiza los valores de triage con las selecciones realizadas
     * en los combos desplegables.
     *
     * @param triage Objeto de tipo Triage para almacenar los valores
     * seleccionados en los combos.
     */
    public void capturar(Triage triage) {
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

    /**
     * Calcula y devuelve un puntaje de gravedad basado en las selecciones de
     * triage realizadas en los combos desplegables.
     *
     * @param a Objeto de tipo Triage del cual se evalúan las selecciones de
     * gravedad.
     * @return Un entero que representa el nivel de gravedad basado en las
     * selecciones realizadas en los combos.
     */
    public int sumar(Triage a) {
        int contador = 0;
        switch (cboRespiracion.getSelectedItem().toString()) {
            case "Normal":
                break;
            case "Dificultad respiratoria moderada":
                contador += 1;
                break;
            case "Dificultad respiratoria grave":
                contador += 2;
                break;
        }

        if (cboPulso.getSelectedItem().toString() == "Anormal") {
            contador += 1;
        }

        switch (cboEstadoMental.getSelectedItem().toString()) {
            case "Normal":
                break;
            case "Confusion Leve":
                contador += 1;
                break;
            case "Confusion Grave":
                contador += 2;
                break;
        }

        if (cboConciencia.getSelectedItem().toString() == "Perdida de conciencia") {
            contador += 3;
        }

        if (cboDolorPecho.getSelectedItem().toString() == "Presente") {
            contador += 1;
        }

        if (cboLesionesGraves.getSelectedItem().toString() == "Presentes") {
            contador += 2;
        }

        if (cboEdad.getSelectedItem().toString() == "Niño o Anciano") {
            contador += 1;
        }

        switch (cboFiebre.getSelectedItem().toString()) {
            case "Sin Fiebre":
                break;
            case "Fiebre moderada":
                contador += 1;
                break;
            case "Fiebre alta":
                contador += 2;
                break;
        }

        switch (cboVomitos.getSelectedItem().toString()) {
            case "Sin vomitos":
                break;
            case "Vomitos moderados":
                contador += 1;
                break;
            case "Vomitos intesos":
                contador += 2;
                break;
        }

        switch (cboDolorAbominal.getSelectedItem().toString()) {
            case "No presente":
                break;
            case "Dolor abdominal moderado":
                contador += 1;
                break;
            case "Dolor abdominal severo":
                contador += 2;
                break;
        }

        if (cboSignosShock.getSelectedItem().toString() == "Presentes") {
            contador += 3;
        }

        if (cboLesionesLeves.getSelectedItem().toString() == "Presentes") {
            contador += 1;
        }

        switch (cboSangrado.getSelectedItem().toString()) {
            case "No presente":
                break;
            case "Sangrado moderado":
                contador += 1;
                break;
            case "Sangrado intenso":
                contador += 2;
                break;
        }
        return contador;
    }

    /**
     * Muestra un cuadro de diálogo para que el usuario seleccione un nuevo
     * color de triage.
     *
     * @return Un entero que representa la elección del nuevo color de triage: -
     * 0 para "Azul". - 1 para "Verde". - 2 para "Amarillo". - 3 para "Naranja".
     * - 4 para "Rojo".
     */
    private int colorModificado() {
        return JOptionPane.showOptionDialog(null, "Seleccione el nuevo color", "Confirmacion", 0, JOptionPane.QUESTION_MESSAGE, null, colores, "Terminar");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAdmisiones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cboLesionesGraves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        cboEdad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Adulto", "Niño o anciano" }));

        cboFiebre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin fiebre", "Fiebre moderada", "Fiebre alta" }));

        cboVomitos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Sin vomitos", "Vomitos moderados", "Vomitos intensos" }));

        jLabel1.setText("Respiracion");

        cboDolorAbominal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presente", "Dolor abdominal moderado", "Dolor abdominal severo" }));

        jLabel2.setText("Estado Mental");

        cboSignosShock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        jLabel3.setText("Pulso");

        cboLesionesLeves.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presentes", "Presentes" }));

        jLabel4.setText("Conciencia");

        cboSangrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "No presente", "Sangrado moderado", "Sangrado intenso" }));

        jLabel5.setText("Dolor de Pecho/Dificultad respiratoria");

        jLabel6.setText("Lesiones Graves");

        jLabel7.setText("Edad");

        jLabel8.setText("Fiebre");

        jLabel9.setText("Vomitos");

        jLabel10.setText("Dolor Abdominal");

        jLabel11.setText("Signos de Shock");

        jLabel12.setText("Lesiones Leves");

        jLabel13.setText("Sangrado");

        cboRespiracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Dificultad respiratoria moderada", "Dificultad respiratoria grave" }));
        cboRespiracion.setNextFocusableComponent(cboPulso);

        cboPulso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Anormal" }));

        cboEstadoMental.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Normal", "Confusion leve", "Confusion grave" }));

        cboConciencia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Conciente y alerta", "Perdida de conciencia" }));

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

        jtAdmisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Motivo", "Ingreso", "DNI", "Nombre", "Apellido", "Fecha de Nacimiento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtAdmisiones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(68, 68, 68)
                        .addComponent(btnConfirmar)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboPulso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEstadoMental, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboConciencia, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDolorPecho, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboLesionesGraves, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboEdad, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboFiebre, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboVomitos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboDolorAbominal, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSignosShock, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboLesionesLeves, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSangrado, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboRespiracion, 0, 280, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cboRespiracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(cboFiebre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(cboPulso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboVomitos)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboDolorAbominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboSignosShock)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboLesionesLeves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cboSangrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnConfirmar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Realiza la confirmación y actualización del triage de un paciente. Se
     * capturan los datos del triage, se calcula su nivel de atención según un
     * contador, se establece un nuevo color de triage y se almacenan los datos
     * correspondientes en la base de datos. Además, muestra mensajes de
     * confirmación al usuario y verifica la completitud de los campos.
     *
     * @param evt El evento del botón "Confirmar".
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        int fila = jtAdmisiones.getSelectedRow();
        try {
            admision = lista.get(fila);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Triage t = new Triage();
        int contador = 0;
        String color = "";

        this.capturar(t);

        contador = this.sumar(t);

        if (contador >= 0 && contador <= 4) {
            color = "Verde";
        } else if (contador >= 5 && contador <= 9) {
            color = "Amarillo";
        } else if (contador >= 10 && contador <= 14) {
            color = "Naranja";
        } else if (contador >= 15) {
            color = "Rojo";
        }

        if (cboRespiracion.getSelectedIndex() != 0 && cboPulso.getSelectedIndex() != 0 && cboEstadoMental.getSelectedIndex() != 0 && cboConciencia.getSelectedIndex() != 0 && cboDolorPecho.getSelectedIndex() != 0 && cboLesionesGraves.getSelectedIndex() != 0 && cboEdad.getSelectedIndex() != 0 && cboFiebre.getSelectedIndex() != 0 && cboVomitos.getSelectedIndex() != 0 && cboDolorAbominal.getSelectedIndex() != 0 && cboSignosShock.getSelectedIndex() != 0 && cboLesionesLeves.getSelectedIndex() != 0 && cboSangrado.getSelectedIndex() != 0) {
            JOptionPane.showMessageDialog(this, " El nivel de atención es de " + color.toUpperCase());
            int opcion = JOptionPane.showOptionDialog(null, "Desea editar el color?", "Confirmación", 0, JOptionPane.QUESTION_MESSAGE, null, editar, "Terminar");
            if (opcion != 0)//si no aprieta el botón Editar
            {
                t.setColor(NivelTriage.valueOf(color));
                t.setColorModificado(NivelTriage.valueOf(color));
            } else {
                TriageDatos d = new TriageDatos();

                int nuevo = -1;
                boolean cambioValido = false;

                while (nuevo == -1 || !cambioValido) {//controla que haya alguna opción seleccionada
                    nuevo = colorModificado();

                    cambioValido = nuevo == -1 || d.cambioColor(colores, color, colores[nuevo]);
                    if (!cambioValido) {
                        JOptionPane.showMessageDialog(null, "No se puede cambiar mas de dos niveles de color");
                    }
                }

                NivelTriage n = NivelTriage.valueOf(colores[nuevo]);

                String motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo del cambio ");
                while (motivo == null || motivo.isEmpty() == true) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un motivo para continuar");
                    motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo del cambio ");
                }

                t.setColor(NivelTriage.valueOf(color));
                t.setColorModificado(n);
                t.setMotivoModificacion(motivo);
            }
            JOptionPane.showMessageDialog(this, "Se ha guardado con éxito ");

            String fechaA;
            String horaA;
            Date fechita = new Date();
            Date horita = new Date();
            SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm:ss");
            fechaA = formatofecha.format(fechita);
            horaA = formatohora.format(horita);

            t.setFecha(fechaA);
            t.setHora(horaA);

            TriageDatos td = new TriageDatos();
            t.setDniEncargado(ControlRoles.getUsuarioActual().getDniFuncionario());
            td.agregarTriage(t);
            t.setId(td.cantidadTriage());

            admision.setTriage(t);
            datos.editarAdmision(admision);

            listar();
        } else {
            JOptionPane.showMessageDialog(null, "Faltan completar casillas");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    /**
     * Limpia y restablece los campos de selección de los síntomas y signos
     * vitales en la interfaz gráfica. Restaura los valores de las casillas de
     * selección a su estado por defecto.
     *
     * @param evt El evento del botón "Limpiar".
     */
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
     * El método main es el punto de entrada del programa. Inicializa la ventana
     * de RealizarTriage.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String args[]) {

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAdmisiones;
    // End of variables declaration//GEN-END:variables
}
