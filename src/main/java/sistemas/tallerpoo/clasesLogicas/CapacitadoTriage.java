package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CapacitadoTriage extends Funcionario{
    private boolean esMedico;
    
    public CapacitadoTriage(int dni, String Nombre, String Apellido, Date fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, boolean esMedico){
        super(dni,Nombre,Apellido,fechaNacimiento,domicilio,telFijo,telCelular,estadoCivil,correoElect,trabajaEn,rolesSistema);
        this.esMedico = esMedico;
    }
}