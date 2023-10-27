package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Deian
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    private String nombre;
    private int dniFuncionario;

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}