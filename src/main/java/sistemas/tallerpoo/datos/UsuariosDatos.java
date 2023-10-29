package sistemas.tallerpoo.datos;

import sistemas.tallerpoo.clasesLogicas.Usuario;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import sistemas.tallerpoo.clasesLogicas.ControlRoles;

/**
 * Declaracion de la clase UsuarioDatos
 *
 * @version 28/10/2023
 */
public class UsuariosDatos {

    private final String archivo = "usuarios.csv";

    /**
     * Crea un usuario y contraseña a un funcionario, a la vez que comprueba si
     * existe o no este funcionario, si existe una cuenta registrada para ese
     * funcionario y si ese nombre de usuario ya existe
     *
     * @param dniFuncionario DNI del funcionario
     * @param u Nombre para la cuenta
     * @param c Contraseña para la cuenta
     * @param cr Contraseña ingresada nuevamente
     * @return devuelve true si la cuenta fue registrada con exito y retorna
     * false en caso de que no existe el funcionario , en caso de de que ya
     * tenga una cuenta y en caso de que ya exita un nombre de usuario igual al
     * ingresado
     */
    public boolean Registrar(int dniFuncionario, JTextField u, JPasswordField c, JPasswordField cr) {
        try {//comprueba que exista un funcionario registrado con ese dni
            new FuncionarioDatos().obtenerFuncionario(dniFuncionario);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;//si no existe, no lo registra y devuelve false
        }

        if (!controlarExistenciaRegistro(dniFuncionario)) {
            return false; //si el funcionario ya tiene un usuario no lo registra y devuelve false
        }
        String nombre = u.getText();
        String contra = String.valueOf(c.getPassword());
        String repContra = String.valueOf(cr.getPassword());
        boolean bandera = false;

        if (controlarExistenciaRegistro(nombre)) {
            if (contra.equals(repContra)) {
                File f = new File(archivo);
                Usuario user = new Usuario(dniFuncionario, nombre, contra);
                bandera = true;
                try (FileWriter fw = new FileWriter(f, true)) {
                    fw.write(user.toCSV());
                    JOptionPane.showMessageDialog(null, "se ha registrado con exito");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            } else {
                JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
            }
        }
        return bandera;
    }

    /**
     * Comprueba si ya existe un nombre de usuario pasado por parametro
     *
     * @param user Nombre de usuario
     * @return Devuelve true en caso de que no exista ese nombre de usuario y
     * devuelve false en caso de que este ya exista
     */
    public boolean controlarExistenciaRegistro(String user) {
        boolean bandera = true;
        Usuario usuario;
        String[] datos;
        try (Scanner sc = new Scanner(new File(archivo))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                usuario = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2]);
                if (user.equals(usuario.getNombreUsuario())) {
                    JOptionPane.showMessageDialog(null, "el usuario ingresado ya existe");
                    bandera = false;
                    break;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bandera;
    }

    /**
     * Comprueba si un funcionario ya tiene un usuario asociada
     *
     * @param dni DNI del funcionario
     * @return Devuelve true si el funcionario no cuenta con una usuario
     * asociada y devuelve false si ya cuenta con un usuario
     */
    public boolean controlarExistenciaRegistro(int dni) {
        boolean bandera = true;
        Usuario usuario;
        String[] datos;
        try (Scanner sc = new Scanner(new File(archivo))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                usuario = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2]);
                if (usuario.getDniFuncionario() == dni) {
                    JOptionPane.showMessageDialog(null, "El funcionario con dni " + dni + " ya tiene un usuario");
                    return false;
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bandera;
    }

    /**
     * Comprueba si el usuario y contraseñas ingresadas en el Login existen
     *
     * @param u Nombre de usuario
     * @param c Contraseña
     * @return Devuelve true si el usuario y contraseña ingreasa existen y
     * devuelve false en caso de que el usuario o la contraseña ingresado sean
     * incorrectas o no existan
     */
    public boolean controlInicioSesion(JTextField u, JPasswordField c) {
        Usuario user;
        String[] datos;
        boolean bandera = false;
        try (Scanner sc = new Scanner(new File(archivo))) {
            String nombre = u.getText();
            String contra = String.valueOf(c.getPassword());
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                user = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2]);
                if (user.getNombreUsuario().equals(nombre) && user.getContraseñaUsuario().equals(contra)) {
                    ControlRoles.setUsuarioActual(user);
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "usuario o contraseña incorrectas");
        return bandera;
    }
}
