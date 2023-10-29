package sistemas.tallerpoo.clasesLogicas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * La clase `Rol` representa un rol en el sistema que se asigna a un funcionario
 */
public class Rol {

    private String nombre;// El nombre del rol
    private int dniFuncionario; // El número de documento del funcionario al que se asigna este rol

    /**
     * Constructor que recibe como parámetro el nombre del rol Se usa para
     * controlar si el usuario actual tiene un determinado rol
     *
     * @param nombre
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
