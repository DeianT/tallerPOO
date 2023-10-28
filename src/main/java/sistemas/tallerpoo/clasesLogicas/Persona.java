package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase que representa a una persona y contiene información relevante
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String domicilio;
    private int telFijo;
    private String telCelular;
    private String estadoCivil;
    private String correoElect;
}