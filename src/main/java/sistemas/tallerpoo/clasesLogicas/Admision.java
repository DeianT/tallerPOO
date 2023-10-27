package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 *
 * @author 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * Clase Admision
 * 
 */
public class Admision {
    /**
     * @param id
     * @param fecha
     * @param hora
     * @param motivo
     * @param paciente
     * @param triage
     * @param triage
     * @param box
     * @param dadaDeAlta
     * 
     */
    private int id;
    private String fecha;
    private String hora;
    private String motivo;
    private Paciente paciente;
    private Triage triage;
    private Box box;
    private boolean dadaDeAlta;
}