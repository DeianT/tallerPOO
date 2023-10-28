package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clase Estudios
 * Contiene información relacionada a las especialidades de los médicos
 */
public class Estudios {
    private String dniMedico;
    private String especialidad;
    private String universidad;
    private String fechaTitulo;
}