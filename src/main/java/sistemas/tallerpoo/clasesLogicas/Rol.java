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
/**
 * La clase `Rol` representa un rol  en el sistema que se asigna a un funcionario
 */
public class Rol {
    private String nombre;// El nombre del rol
    private int dniFuncionario; // El número de documento del funcionario al que se asigna este rol
}