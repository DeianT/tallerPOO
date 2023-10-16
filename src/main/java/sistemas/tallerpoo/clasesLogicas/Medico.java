package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medico extends CapacitadoTriage{
    private int nMatricula;

    public Medico() {
        super();
        setEsMedico(true);
    }

    public Medico(int dni, String Nombre, String Apellido, Date fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, int nMatricula){
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, true);
        this.nMatricula = nMatricula;
    }
}