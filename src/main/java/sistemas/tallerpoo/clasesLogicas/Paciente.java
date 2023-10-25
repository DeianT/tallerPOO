package sistemas.tallerpoo.clasesLogicas;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Persona {
    private String contacto;

    public Paciente(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, String contacto) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.contacto = contacto;
    }
}