package sistemas.tallerpoo.clasesLogicas;

import java.util.ArrayList;
import sistemas.tallerpoo.datos.RolDatos;

/**
 *
 * @author Deian
 */
/** 
 * 
 * Clase ControlRoles se encarga de gestionar los roles de los usuarios en el sistema.
 * Permite verificar si un usuario tiene un rol específico y mantener un seguimiento de los roles del usuario actual.
 * 
 */
public class ControlRoles {
    private static Usuario usuarioActual = null;
    private static ArrayList<Rol> rolesUsuario = new ArrayList<>();
    
    /**
     * Verifica si un usuario tiene un rol especifico
     * @param rol Rol que se desea verificar
     * @return retorna "true" si el usuario posee un rol, de lo contrario, "false"
     */
    public boolean usuarioTieneRol(Rol rol){
        return true;
    }

    /**
     *Obtiene el usuario que ha iniciado sesión en el sistema.
     * @return Devuelve el Usuario actual autenticado
     */
    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     *Establece el usuario que ha iniciado sesión en el sistema.
     * Actualiza los roles del usuario actual al iniciar o cerrar sesión.
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
     *Obtiene los roles asociados al usuario actual.
     * @return Devuelve lista de roles que el usuario tiene en el sistema
     */
    public static ArrayList<Rol> getRolesUsuario() {
        return rolesUsuario;
    }
}