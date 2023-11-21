package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase Medico que extiende de CapacitadoTriage
 *
 */
@Getter
@Setter
public class Medico extends CapacitadoTriage {

    private int nMatricula;// El número de matrícula del médico.
    private Especialidad[] especialidades;// Las especialidades médicas del médico.

    /**
     * Constructor por defecto de Medico Establece el atributo `esMedico` en
     * `true` ya que se trata de un médico
     */
    public Medico() {
        super();
        setEsMedico(true);
    }

    /**
     * Constructor de la clase Medico
     *
     * @param dni El número de documento del médico
     * @param nombre El nombre del médico
     * @param apellido El apellido del médico
     * @param fechaNacimiento La fecha de nacimiento del médico
     * @param domicilio La dirección del médico.
     * @param telFijo El número de teléfono fijo del médico.
     * @param telCelular El número de celular del médico.
     * @param estadoCivil El estado civil del médico.
     * @param correoElect La dirección de correo electrónico del médico.
     * @param trabajaEn El sector en el que trabaja el médico
     * @param rolesSistema Los roles asignados al médico en el sistema.
     * @param nMatricula El número de matrícula del médico.
     */
    public Medico(int dni, String nombre, String apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, int nMatricula) {
        super(dni, nombre, apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, true);
        this.nMatricula = nMatricula;
    }
}
