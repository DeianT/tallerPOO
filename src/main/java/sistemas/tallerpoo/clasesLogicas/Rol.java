package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Los posibles roles con los que pueden acceder al sistema los funcionarios
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rol {
    private String nombre;
    private int dniFuncionario;

    /**
     * Constructor que recibe como parámetro el nombre del rol
     * Se usa para controlar si el usuario actual tiene un determinado rol
     * @param nombre
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}