package sistemas.tallerpoo.visual;

import javax.swing.JOptionPane;
import sistemas.tallerpoo.datos.UsuariosDatos;

/**
 * Clase que representa un formulario para registrar usuarios en el sistema.
 * Proporciona una interfaz gráfica para la creación y gestión de usuarios.
 *
 * Puede ser utilizado para la creación de usuarios, asignación de roles, y
 * otras operaciones relacionadas con la administración de usuarios en el
 * sistema.
 *
 * Este formulario se encarga de la presentación visual y la interacción con el
 * usuario. No se muestran operaciones o lógica específica de manipulación de
 * datos en este fragmento.
 *
 * Puede ser utilizado como plantilla base para el registro de usuarios en el
 * sistema.
 *
 */
public class RegistroUsuario extends javax.swing.JFrame {

    /**
     * Constructor que inicializa los componentes del formulario para el
     * Registro de Usuario.
     */
    public RegistroUsuario() {
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

        btnRegistrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        txtRepContra = new javax.swing.JPasswordField();
        txtDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuario");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Repetir contraseña");

        jLabel4.setText("DNI funcionario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                            .addComponent(txtContraseña)
                            .addComponent(txtRepContra)
                            .addComponent(txtDni)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRepContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al hacer clic en el botón "Registrar". Realiza la
     * validación de campos y registra un nuevo usuario si los campos requeridos
     * no están vacíos.
     *
     * @param evt Evento de acción que desencadena esta función al hacer clic en
     * el botón de registro.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if ("".equals(txtUsuario.getText()) || "".equals(txtContraseña.getText()) || "".equals(txtDni.getText())) {
            JOptionPane.showMessageDialog(null, "Hay campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (!txtDni.getText().matches("\\d+") || Integer.parseInt(txtDni.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        UsuariosDatos user = new UsuariosDatos();
        if (user.Registrar(Integer.parseInt(txtDni.getText()), txtUsuario, txtContraseña, txtRepContra)) {
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    /**
     * El método main es el punto de entrada del programa. Inicializa la ventana
     * de RegistroUsuario.
     *
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtDni;
    private javax.swing.JPasswordField txtRepContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
