package ClaseLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente extends Persona {
    private Persona contacto;
    
    public String toCSV()
    {
       return this.getDni()+","+this.getNombre()+","+this.getApellido()+","+this.getFechaNacimiento()+","+this.getDomicilio()+","+this.getTelFijo()+","+this.getTelCelular()+","+this.getEstadoCivil()+","+this.getCorreoElect()+","+this.getContacto()+"\n";
    }
}
