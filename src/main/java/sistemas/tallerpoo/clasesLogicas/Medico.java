package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Medico extends Persona{
    private int nMatricula;
    private Rol rolSistema;

    public Medico(int dni, String Nombre, String Apellido, Date fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, int nMatricula, Rol rolSistema){
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect);
        this.nMatricula = nMatricula;
        this.rolSistema = rolSistema;
    }
}