package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Clase Funcionario que extiende de la clase Persona Representa a cada
 * trabajador
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Funcionario extends Persona {

    private SectorTrabajo trabajaEn; // El sector en el que trabaja
    private ArrayList<Rol> rolesSistema;

    /**
     * Constructor de la Clase Funcionario
     *
     * @param dni El número de documento del funcionario.
     * @param Nombre El nombre del funcionario.
     * @param Apellido El apellido del funcionario.
     * @param fechaNacimiento La fecha de nacimiento del funcionario.
     * @param domicilio La dirección del funcionario.
     * @param telFijo El número de teléfono fijo del funcionario.
     * @param telCelular El número de celular del funcionario.
     * @param estadoCivil El estado civil del funcionario.
     * @param correoElect La dirección de correo electrónico del funcionario.
     * @param trabajaEn El sector en el que trabaja el funcionario.
     * @param rolesSistema Los roles asignados al funcionario en el sistema.
     */
    public Funcionario(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.trabajaEn = trabajaEn;
        this.rolesSistema = rolesSistema;
    }
}
