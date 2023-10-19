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
public class Admision {
    private Date fecha;
    private Date hora;
    private String motivo;
    private Paciente paciente;
    private Triage triage;
    private Box box;
}