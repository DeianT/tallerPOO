package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medico extends CapacitadoTriage{
    private int nMatricula;
    private Especialidad[] especialidades;

    public Medico() {
        super();
        setEsMedico(true);
    }
    
    public Medico(int dni, String nombre, String apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema, int nMatricula){
        super(dni, nombre, apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema, true);
        this.nMatricula = nMatricula;
    }
}