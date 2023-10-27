package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {
    private int dniPaciente;
    private int dniMedico;
    private String fecha;
    private String hora;
    private String diagnostico;
    private String lugar;
    private String diagnosticoClinico;
}
