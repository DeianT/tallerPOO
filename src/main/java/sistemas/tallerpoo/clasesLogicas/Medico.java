package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 
 */
@Getter
@Setter
/**
 *  Clase Medico que extiende de CapacitadoTriage
 * 
 */
public class Medico extends CapacitadoTriage{
    private int nMatricula;
    private Especialidad[] especialidades;

    /**
     * Constructor por defecto de Medico
     * establece como verdadero el metodo setEsMedico porque se trata de un Medico
     */
    public Medico() {
        super();
        setEsMedico(true);
    }
    
    /**
     * Constructor de la clase Medico
     * @param dni
     * @param nombre
     * @param apellido
     * @param fechaNacimiento
     * @param domicilio
     * @param telFijo
     * @param telCelular
     * @param estadoCivil
     * @param correoElect
     * @param trabajaEn
     * @param rolesSistema
     * @param nMatricula
     */
    public Medico(int dni, String nombre, String apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, int nMatricula){
        super(dni, nombre, apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, true);
        this.nMatricula = nMatricula;
    }
}