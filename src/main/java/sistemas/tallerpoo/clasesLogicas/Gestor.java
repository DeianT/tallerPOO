package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
/**
 * Clase Gestor que extiende de Funcionario
 */
public class Gestor extends Funcionario{

    /**
     * Constructor de Gestor
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
    public Gestor(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema){
        super(dni,Nombre,Apellido,fechaNacimiento,domicilio,telFijo,telCelular,estadoCivil,correoElect,trabajaEn,rolesSistema);
    }
}