package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase `Usuario` representa a un usuario del sistema de salud, con acceso a
 * funcionalidades específicas
 * Contiene el nombre de usuario, la contraseña y el dni de quien usa ese
 * usuario
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private int dniFuncionario; // Número de documento del funcionario asociado al usuario.
    private String nombreUsuario;// Nombre de usuario para iniciar sesión.
    private String contraseñaUsuario; // Contraseña de usuario para iniciar sesión.

    /**
     * Obtiene una representación en formato CSV del usuario
     *
     * @return Devuelve una cadena en formato CSV del DNI del funcionario,
     * Nombre de Usuario, Contraseña de Usuario
     */
    public String toCSV() {
        return dniFuncionario + "," + nombreUsuario + "," + contraseñaUsuario + "\n";
    }
}
