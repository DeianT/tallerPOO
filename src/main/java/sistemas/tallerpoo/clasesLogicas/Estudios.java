package sistemas.tallerpoo.clasesLogicas;

import java.util.Date;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
/**
 * Clase Estudios almacena información relacionada con los estudios y la formación académica de un profesional
 */
public class Estudios {
    private String dniMedico;    // El DNI del médico
    private String especialidad;// La especialidad en la que se ha formado el médico.
    private String  universidad;// La universidad donde el médico obtuvo su título.
    private String fechaTitulo;// La fecha en la que el médico obtuvo su título.
}


