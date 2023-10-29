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
/**
 * Clase HistoriaClinica representa un registro médico que contiene información
 * sobre la historia clínica de un paciente
 *
 * Clase HistoriaClinica contiene los datos de cada atención de un paciente
 */
public class HistoriaClinica {

    private int dniPaciente; // El DNI del paciente
    private int dniMedico; // El DNI del médico que atendió al paciente.
    private String fecha; // La fecha de la consulta.
    private String hora;// La hora de la consulta.
    private String diagnostico;// El diagnóstico realizado.
    private String lugar;  // El lugar donde se realizó la consulta.
    private String diagnosticoClinico;  // El diagnóstico clínico detallado.
}
