package sistemas.tallerpoo.clasesLogicas;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 
 */
@Getter
@Setter
@NoArgsConstructor
/**
 * Clase Paciente que extiende de Persona
 */
public class Paciente extends Persona {
    private String contacto; // Información de contacto de emergencia del paciente.


    /**
     * Constructor de la clase Paciente
     * @param dni El número de documento del paciente.
     * @param Nombre El nombre del paciente.
     * @param Apellido El apellido del paciente. 
     * @param fechaNacimiento La fecha de nacimiento del paciente.
     * @param domicilio La dirección del paciente.
     * @param telFijo El número de teléfono fijo del paciente.
     * @param telCelular El número de celular del paciente.
     * @param estadoCivil  El estado civil del paciente.
     * @param correoElect La dirección de correo electrónico del paciente.
     * @param contacto La información de contacto de emergencia del paciente.
     */
    public Paciente(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, String contacto) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.contacto = contacto;
    }
}