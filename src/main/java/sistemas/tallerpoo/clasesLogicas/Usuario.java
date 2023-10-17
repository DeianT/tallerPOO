package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private int dniFuncionario;
    private String nombreUsuario;
    private String contraseñaUsuario;
    
    public String toCSV(){
        return dniFuncionario + "," + nombreUsuario + "," + contraseñaUsuario + "\n";              
    }
}