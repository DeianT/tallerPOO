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
 * Clase Admision representa el registro de admisión de un paciente contiene
 * la información relevante cuando ingresa el paciente a atenderse
 * 
 */
public class Admision {
    /**
     * @param id Identificacion de la adminisión
     * @param fecha Fecha de la admisión.
     * @param hora Hora  de la admisión.
     * @param motivo Motivo  de la admisión.
     * @param paciente Paciente al que se le realizó la admisión.
     * @param triage Nivel de triage asignado al paciente.
     * @param box Box asignado al paciente.
     * @param dadaDeAlta Indicador si el paciente ha sido de alta o no.
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