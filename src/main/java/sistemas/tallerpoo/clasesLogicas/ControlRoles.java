package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import sistemas.tallerpoo.datos.RolDatos;

/**
 *
 * @author Deian
 */
/** 
 * 
 * Clase ControlRoles 
 * 
 */
public class ControlRoles {
    private static Usuario usuarioActual = null;
    private static ArrayList<Rol> rolesUsuario = new ArrayList<>();
    
    /**
     *
     * @param rol
     * @return retorna verdadero si el usuario posee un rol
     */
    public static boolean usuarioTieneRol(Rol rol){
        for(Rol r: rolesUsuario){
            if(rol.getNombre().toLowerCase().equals(r.getNombre().toLowerCase())){
               return true; 
            }
        }
        return false;
    }

    /**
     *
     * @return Devuelve el Usuario que ingresó
     */
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     *
     * @param usuarioActual
     */
    public static void setUsuarioActual(Usuario usuarioActual) {
        ControlRoles.usuarioActual = usuarioActual;
        if(usuarioActual == null)
            ControlRoles.rolesUsuario = new ArrayList<>();
        else
            ControlRoles.rolesUsuario = new RolDatos().obtenerRolesFuncionario(usuarioActual.getDniFuncionario());
    }

    /**
     *
     * @return Devuelve el Rol del usuario
     */
    public static ArrayList<Rol> getRolesUsuario() {
        return rolesUsuario;
    }
}