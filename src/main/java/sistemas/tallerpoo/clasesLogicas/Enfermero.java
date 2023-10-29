package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Clase Enfermero que extiende a CapacitadoTriage
 */
public class Enfermero extends CapacitadoTriage {

    /**
     * Constructor por defecto establece "false" el atributo esMedico porque se
     * trata de un enfermero
     */
    public Enfermero() {
        super();
        setEsMedico(false);
    }

    /**
     * Constructor de la Clase Enfermero
     *
     * @param dni El número de documento del enfermero.
     * @param Nombre El nombre del enfermero.
     * @param Apellido El apellido del enfermero.
     * @param fechaNacimiento La fecha de nacimiento del enfermero.
     * @param domicilio La dirección del enfermero.
     * @param telFijo El número de teléfono fijo del enfermero.
     * @param telCelular El número de celular del enfermero.
     * @param estadoCivil El estado civil del enfermero.
     * @param correoElect La dirección de correo electrónico del enfermero.
     * @param trabajaEn El sector en el que trabaja el enfermero
     * @param rolesSistema Los roles del sistema asignados al enfermero.
     */
    public Enfermero(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, false);
    }
}
