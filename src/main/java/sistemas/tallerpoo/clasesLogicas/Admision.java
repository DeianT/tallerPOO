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
    private int id;
    private String fecha;
    private String hora;
    private String motivo;
    private Paciente paciente;
    private Triage triage;
    private Box box;
    private boolean dadaDeAlta;
}