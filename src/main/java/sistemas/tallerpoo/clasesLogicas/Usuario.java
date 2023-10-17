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
    private String nombreUusuario;
    private String contraseñaUsuario;
    private Rol rol;//capaz que estos dos tendrian que ser int(idRol y funcionarioDni)
    private Funcionario funcionario;
    
    public String toCSV(){
        return this.nombreUusuario+","+this.contraseñaUsuario+","+this.rol.getNombre()+"\n";              
    }
}