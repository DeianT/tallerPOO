package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * La clase Triage representa la evaluación de triage realizada a un paciente en una situación de emergencia.
 */
public class Triage {
    private int id; // Identificador único del triage.
    private NivelTriage color;// El nivel de triage asignado al paciente.
    private String respiracion; // Estado de la respiración del paciente.
    private String pulso;// Frecuencia del pulso del paciente.
    private String estadoMental;// Estado mental del paciente.
    private String conciencia; // Nivel de conciencia del paciente.
    private String dificultadRespiratoria; // Indicación de dificultad respiratoria
    private String lesionesGraves;// Información sobre lesiones graves.
    private String edad;// Edad del paciente.
    private String fiebre;// Indicación de fiebre.
    private String vomitos;// Presencia de vómitos.
    private String dolorAbdominal;// Indicación de dolor abdominal.
    private String signosDeShock; // Signos de shock en el paciente.
    private String lesionesLeves; // Información sobre lesiones leves.
    private String sangrado;  // Presencia de sangrado en el paciente.
    private String fecha;// Fecha en que se realizó el triage.
    private String hora;// Hora en que se realizó el triage.
    private NivelTriage colorModificado;// Nivel de triage modificado
    private String motivoModificacion;// Motivo de la modificación del triage.
    private int dniEncargado; // Número de documento del encargado del triage.
}