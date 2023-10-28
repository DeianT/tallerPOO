package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 *  Clase Box representa el espacio o sala donde se atenderá al paciente
 * Contiene la información de su número, fecha y hora de uso y un indicador 
 * si está ocupado o no
 */
public class Box {
    
    private int numero; 
    private Date fecha; 
    private Date hora; 
    private boolean ocupado; 
}