package sistemas.tallerpoo.clasesLogicas;

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
/**
 * La clase `Persona` representa a un individuo en el sistema y almacena información básica sobre esa persona
 * 
 */
public class Persona {
    private int dni;// El número de documento de la persona.
    private String nombre;// El nombre de la persona.
    private String apellido; // El apellido de la persona.
    private String fechaNacimiento;// La fecha de nacimiento de la persona.
    private String domicilio;// La dirección de la persona.
    private int telFijo;// El número de teléfono fijo de la persona.
    private String telCelular; // El número de celular de la persona.
    private String estadoCivil; // El estado civil de la persona.
    private String correoElect;// La dirección de correo electrónico de la persona.
}