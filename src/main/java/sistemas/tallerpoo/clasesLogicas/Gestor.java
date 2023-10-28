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
 * Clase Gestor que extiende de Funcionario
 */
public class Gestor extends Funcionario{

    /**
     * Constructor de la clase Gestor
     * @param dni El número de documento del gestor.
     * @param Nombre El nombre del gestor.
     * @param Apellido El apellido del gestor.
     * @param fechaNacimiento La fecha de nacimiento del gestor.
     * @param domicilio La dirección del gestor.
     * @param telFijo El número de teléfono fijo del gestor.
     * @param telCelular El número de celular del gestor.
     * @param estadoCivil El estado civil del gestor.
     * @param correoElect La dirección de correo electrónico del gestor.
     * @param trabajaEn El sector en el que trabaja el gestor.
     * @param rolesSistema Los roles asignados al gestor en el sistema.
     */
    public Gestor(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema){
        super(dni,Nombre,Apellido,fechaNacimiento,domicilio,telFijo,telCelular,estadoCivil,correoElect,trabajaEn,rolesSistema);
    }
}