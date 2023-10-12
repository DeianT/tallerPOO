package sistemas.tallerpoo.clasesLogicas;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estudios {
    private String universidad;
    private String fechaTitulo;
    private Medico medico;
    private Especialidad especialidad;
    public Estudios(String universidad, String fechaTitulo, Medico medico, Especialidad especialidad){
        this.universidad = universidad;
        this.fechaTitulo = fechaTitulo;
        this.medico = medico;
        this.especialidad = especialidad;
    }   
}