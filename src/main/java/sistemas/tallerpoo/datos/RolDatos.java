package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Rol;

/**
 * Declaracion de la clase RolDatos.
 */
public class RolDatos {

    private ArrayList<Rol> lista = new ArrayList<>();
    private final String archivo = "roles.csv";
    private final String separador = ";";

    /**
     * Constructor de la clase RolDatos que intenta leer el archivo de roles.
     */
    public RolDatos() {
        try {
            leerArchivo();
        } catch (Exception e) {
        }
    }

    /**
     * Agrega un rol al sistema.
     *
     * @param rol El rol a agregar.
     * @return Verdadero si se agrega con éxito, falso si el rol ya existe.
     */
    public boolean agregarRol(Rol rol) {
        if (existeRol(rol)) {
            return false;//si ya existe no lo agrega
        }
        lista.add(rol);
        escribirArchivo();
        return true;
    }

    /**
     * Verifica si un rol ya existe en la lista.
     *
     * @param rol El rol a verificar.
     * @return Verdadero si el rol ya existe, falso en caso contrario.
     */
    public boolean existeRol(Rol rol) {
        for (Rol r : lista) {
            if (r.getNombre().toLowerCase().equals(rol.getNombre().toLowerCase()) && r.getDniFuncionario() == rol.getDniFuncionario()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene los roles asociados a un determinado número de identificación
     * (dni) del funcionario.
     *
     * @param dni El número de identificación del funcionario.
     * @return Lista de roles asociados al dni del funcionario.
     */
    public ArrayList<Rol> obtenerRolesFuncionario(int dni) {
        ArrayList<Rol> roles = new ArrayList<>();
        for (Rol r : lista) {
            if (r.getDniFuncionario() == dni) {
                roles.add(r);
            }
        }
        return roles;
    }

    /**
     * Elimina un rol de la lista de roles.
     *
     * @param rol El rol a eliminar.
     * @return Verdadero si se elimina con éxito, falso si no se encuentra.
     */
    public boolean eliminarRol(Rol rol) {
        for (Rol r : lista) {
            if (r.getNombre().toLowerCase().equals(rol.getNombre().toLowerCase()) && r.getDniFuncionario() == rol.getDniFuncionario()) {
                lista.remove(r);
                escribirArchivo();
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina todos los roles asociados a un número de identificación (dni) de
     * un funcionario.
     *
     * @param dni El número de identificación del funcionario.
     * @return Verdadero si se eliminan con éxito, falso si no se encuentran.
     */
    public boolean eliminarRolesFuncionario(int dni) {
        return lista.removeAll(obtenerRolesFuncionario(dni));
    }

    /**
     * Escribe los roles en un archivo.
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Rol r : lista) {
                linea = r.getNombre() + separador;
                linea += r.getDniFuncionario();

                pw.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                nuevo.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Lee los roles de un archivo.
     *
     * @throws IOException si ocurre un error al leer el archivo.
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while (linea != null) {
                String[] campos = linea.split(separador);
                Rol r = new Rol();

                r.setNombre(campos[0]);
                r.setDniFuncionario(Integer.parseInt(campos[1]));

                lista.add(r);
                linea = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
