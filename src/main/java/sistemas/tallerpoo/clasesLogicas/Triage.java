package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

/**
 * Contiene los datos de cada triage realizado, así como quién lo realizó
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Triage {
    private int id;
    private NivelTriage color;
    private String respiracion;
    private String pulso;
    private String estadoMental;
    private String conciencia;
    private String dificultadRespiratoria;
    private String lesionesGraves;
    private String edad;
    private String fiebre;
    private String vomitos;
    private String dolorAbdominal;
    private String signosDeShock;
    private String lesionesLeves;
    private String sangrado;
    private String fecha;
    private String hora;
    private NivelTriage colorModificado;
    private String motivoModificacion;
    private int dniEncargado;
}