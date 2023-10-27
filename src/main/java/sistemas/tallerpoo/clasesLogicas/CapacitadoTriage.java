package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 
 */
@Getter
@Setter
@NoArgsConstructor
/**
 * Clase CapacitadoTriage que extiende de la clase Funcionario
 */
public class CapacitadoTriage extends Funcionario{
    private boolean esMedico;
    
    /**
     * Constructor de la clase CapacitadoTriage
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
     * @param esMedico
     */
    public CapacitadoTriage(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, boolean esMedico){
        super(dni,Nombre,Apellido,fechaNacimiento,domicilio,telFijo,telCelular,estadoCivil,correoElect,trabajaEn,rolesSistema);
        this.esMedico = esMedico;
    }
}