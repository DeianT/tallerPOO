package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * La clase AdministradorDelSistema es una subclase de la clase Funcionario y
 * representa a un administrador dentro del sistema.
 */
@Getter
@Setter
@NoArgsConstructor
public class AdministradorDelSistema extends Funcionario {

    /**
     * Constructor de AministradorDelSistema
     *
     * @param dni Dni del administrador.
     * @param Nombre Nombre del administrador.
     * @param Apellido Apellido del administrador.
     * @param fechaNacimiento Fecha de Nacimiento del administrador.
     * @param domicilio Domicilio del administrador.
     * @param telFijo Telefono Fijo del administrador.
     * @param telCelular Telefono Celular del administrador.
     * @param estadoCivil Estado Civil del administrador.
     * @param correoElect Correo Electronico del administrador.
     * @param trabajaEn Sector de Trabajo del administrador.
     * @param rolesSistema Rol dentro del Sistema del administrador.
     */
    public AdministradorDelSistema(int dni, String Nombre, String Apellido, String fechaNacimiento, String domicilio, int telFijo, String telCelular, String estadoCivil, String correoElect, SectorTrabajo trabajaEn, ArrayList<Rol> rolesSistema) {
        super(dni, Nombre, Apellido, fechaNacimiento, domicilio, telFijo, telCelular, estadoCivil, correoElect, trabajaEn, rolesSistema);
    }
}
