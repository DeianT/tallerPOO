package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 * Resultados de los estudios que se realiza a los pacientes
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadosEstudios {
    private String tipoEstudios;
    private Date fecha;
    private Date hora;
    private String informe;
}