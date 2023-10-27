package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author famil
 */

@Getter
@Setter
/**
 * Clase Enfermero que extiende a CapacitadoTriage
 */
public class Enfermero extends CapacitadoTriage{

    /**
     * Constructor por defecto
     * establece falsa el metodo setEsMedico porque es Enfermero
     */
    public Enfermero() {
        super();
        setEsMedico(false);
    }

    /**
     * Constructor de la Clase Enfermero
     * @param dni
     * @param Nombre
     * @param Apellido
     * @param fechaNacimiento
     * @param domicilio
     * @param telFijo
     * @param telCelular
     * @param estadoCivil
     * @param correoElect
     * @param trabajaEn
     * @param rolesSistema
     */
    public Enfermero(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema){
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, false);
    }
}