package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

/**
 * La clase `ResultadosEstudios` representa los resultados de un estudio médico
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultadosEstudios {

    private String tipoEstudios;// El tipo de estudio médico realizado.
    private Date fecha;// La fecha en que se realizó el estudio.
    private Date hora;// La hora en que se realizó el estudio.
    private String informe;  // El informe o resultados obtenidos del estudio.
}
