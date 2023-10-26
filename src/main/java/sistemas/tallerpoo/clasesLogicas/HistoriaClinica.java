package sistemas.tallerpoo.clasesLogicas;

import lombok.Getter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoriaClinica {
    
    private String dniPaciente;
    private String dniMedico;
    private String fecha;
    private String hora;
    private String diagnostico;
    private String lugar;
    private String diagnosticoClinico;   

  
    
    
    
    
    

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDiagnosticoClinico() {
        return diagnosticoClinico;
    }

    public void setDiagnosticoClinico(String diagnosticoClinico) {
        this.diagnosticoClinico = diagnosticoClinico;
    }
    
    
    

  

    
    
}
