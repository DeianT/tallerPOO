package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
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
 * Clase CapacitadoTriage es una subclase de la clase Funcionario
 * Representa a una persona capacitada para llevar a cabo el triage.
 */ 
public class CapacitadoTriage extends Funcionario{
    private boolean esMedico;
    
    /**
     * Constructor de la clase CapacitadoTriage
     * @param dni DNI 
     * @param Nombre Nombre
     * @param Apellido Apellido
     * @param fechaNacimiento Fecha de Nacimiento
     * @param domicilio Domicilio
     * @param telFijo Telefono Fijo
     * @param telCelular Telefono Celular
     * @param estadoCivil Estado Civil
     * @param correoElect Correo Electronico
     * @param trabajaEn Sector de Trabajo
     * @param rolesSistema Rol en el sistema
     * @param esMedico Indicador si es medico o no
     */
    public CapacitadoTriage(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, boolean esMedico){
        super(dni,Nombre,Apellido,fechaNacimiento,domicilio,telFijo,telCelular,estadoCivil,correoElect,trabajaEn,rolesSistema);
        this.esMedico = esMedico;
    }
}