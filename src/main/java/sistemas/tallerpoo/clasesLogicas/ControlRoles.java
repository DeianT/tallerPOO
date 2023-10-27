package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import sistemas.tallerpoo.datos.RolDatos;

/**
 *
 * @author Deian
 */
public class ControlRoles {
    private static Usuario usuarioActual = null;
    private static ArrayList<Rol> rolesUsuario = new ArrayList<>();
    
    public static boolean usuarioTieneRol(Rol rol){
        for(Rol r: rolesUsuario){
            if(rol.getNombre().toLowerCase().equals(r.getNombre().toLowerCase())){
               return true; 
            }
        }
        return false;
    }

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuarioActual) {
        ControlRoles.usuarioActual = usuarioActual;
        if(usuarioActual == null)
            ControlRoles.rolesUsuario = new ArrayList<>();
        else
            ControlRoles.rolesUsuario = new RolDatos().obtenerRolesFuncionario(usuarioActual.getDniFuncionario());
    }

    public static ArrayList<Rol> getRolesUsuario() {
        return rolesUsuario;
    }
}
