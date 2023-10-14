package ClaseLogicas;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Deian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    private int dni;
    private String Nombre;
    private String Apellido;
    private String fechaNacimiento;
    private String domicilio;
    private int telFijo;
    private String telCelular;
    private String estadoCivil;
    private String correoElect;
    
    
    public String toCSV()
    {
       return this.getDni()+","+this.getNombre()+","+this.getApellido()+","+this.getFechaNacimiento()+","+this.getDomicilio()+","+this.getTelFijo()+","+this.getTelCelular()+","+this.getEstadoCivil()+","+this.getCorreoElect()+","+"\n";
    }
}
