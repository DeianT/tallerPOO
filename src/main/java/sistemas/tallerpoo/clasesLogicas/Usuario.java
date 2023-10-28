package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Representa los usuarios que los funcionarios utilizan para acceder al sistema
 * Contiene el nombre de usuario, la contraseña y el dni de quien usa ese usuario
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int dniFuncionario;
    private String nombreUsuario;
    private String contraseñaUsuario;
    
    /**
     *
     * @return Devuelve el DNI del funcionario, Nombre de Usuario, Contraseña de Usuario
     */
    public String toCSV(){
        return dniFuncionario + "," + nombreUsuario + "," + contraseñaUsuario + "\n";              
    }
}