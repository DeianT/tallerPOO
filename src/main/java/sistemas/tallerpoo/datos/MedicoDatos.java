package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 * Declaracion de la clase MedicoDatos
 *
 * @version 28/10/2023
 */
public class MedicoDatos {

    private ArrayList<Medico> lista = new ArrayList();
    private final String archivo = "medicos.csv";
    private final String separador = ";";

    /**
     * Contructor de la clase MedicoDatos
     */
    public MedicoDatos() {
        try {
            leerArchivo();
        } catch (IOException ex) {
        }
    }

    /**
     * Agrega un paciente a un ArrayList de Medico y luego escribe la lista en
     * el archivo "medicos.csv"
     *
     * @param medico Objeto Medico
     * @return Devuelve true cuando el medico se agrega con exito y devuelve
     * false si el medico que se quiere agregar ya existe en la lista
     */
    public boolean agregarMedico(Medico medico) {
        try {
            obtenerMedico(medico.getDni());
            return false;
        } catch (Exception e) {
            lista.add(medico);
            escribirArchivo();
            new FuncionarioDatos().agregarFuncionario(medico);
            return true;
        }
    }

    /**
     * Busca un medico por su DNI
     *
     * @param id DNI del medico
     * @return Devuelve el medico
     * @throws IOException Devuelve una excepcion en caso de que el DNI
     * ingresado no exista en la lista
     */
    public Medico obtenerMedico(int id) throws IOException {
        for (Medico med : lista) {
            if (med.getDni() == id) {
                return med;
            }
        }
        throw new IOException("No existe Medico con dni = " + id);
    }

    /**
     * Lista completa de todos los medicos
     *
     * @return Devuelve un ArrayList de Medico con todos los medicos registrados
     */
    public ArrayList<Medico> obtenerMedicos() {
        return lista;
    }

    /**
     * Elimina un medico de la lista buscandolo por su DNI
     *
     * @param dni DNI del medico
     * @return Devuelve true cuando se elimino y escribio el archivo con exito y
     * devuelve false si se quiere eliminar a alguien que no esta registrado o
     * que el DNI ingresado es incorrecto
     */
    public boolean eliminarMedico(int dni) {
        try {
            Medico f = obtenerMedico(dni);
            lista.remove(f);
            escribirArchivo();
            new FuncionarioDatos().eliminarFuncionario(dni);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Edita los datos de un medico
     *
     * @param medico Objeto Medico
     * @return Devuelve true en caso de que se haya podido editar y escribir con
     * exito y devuelve false si no existe el medico ingresado
     */
    public boolean editarMedico(Medico medico) {
        try {
            Medico m = obtenerMedico(medico.getDni());
            m.setNombre(medico.getNombre());
            m.setApellido(medico.getApellido());
            m.setFechaNacimiento(medico.getFechaNacimiento());
            m.setDomicilio(medico.getDomicilio());
            m.setTelFijo(medico.getTelFijo());
            m.setTelCelular(medico.getTelCelular());
            m.setEstadoCivil(medico.getEstadoCivil());
            m.setCorreoElect(medico.getCorreoElect());
            m.setTrabajaEn(medico.getTrabajaEn());
            m.setRolesSistema(medico.getRolesSistema());
            m.setNMatricula(medico.getNMatricula());

            escribirArchivo();
            new FuncionarioDatos().editarFuncionario(medico);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Edita los datos de un funcionario medico
     *
     * @param funcionario Objeto Funcionario
     * @return Devuelve true en caso de que se haya podido editar y escribir con
     * exito y devuelve false si no existe el funcionario ingresado
     */
    public boolean editarMedico(Funcionario funcionario) {
        try {
            Medico m = obtenerMedico(funcionario.getDni());
            m.setNombre(funcionario.getNombre());
            m.setApellido(funcionario.getApellido());
            m.setFechaNacimiento(funcionario.getFechaNacimiento());
            m.setDomicilio(funcionario.getDomicilio());
            m.setTelFijo(funcionario.getTelFijo());
            m.setTelCelular(funcionario.getTelCelular());
            m.setEstadoCivil(funcionario.getEstadoCivil());
            m.setCorreoElect(funcionario.getCorreoElect());
            m.setTrabajaEn(funcionario.getTrabajaEn());
            m.setRolesSistema(funcionario.getRolesSistema());

            escribirArchivo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Itera todos los elemento del ArrayList de Medico, concatena cada atributo
     * del objeto Medico en un String separado por "," y luego lo escribe en el
     * archivo "medicos.csv"
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;

        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Medico m : lista) {
                linea = m.getDni() + separador;
                linea += m.getNombre() + separador;
                linea += m.getApellido() + separador;
                linea += m.getFechaNacimiento() + separador;
                linea += m.getDomicilio() + separador;
                linea += m.getTelFijo() + separador;
                linea += m.getTelCelular() + separador;
                linea += m.getEstadoCivil() + separador;
                linea += m.getCorreoElect() + separador;
                if (m.getTrabajaEn() != null) {
                    linea += m.getTrabajaEn().getNombre() + separador;
                } else {
                    linea += "null" + separador;
                }
                linea += m.getNMatricula();

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
     * Lee el archivo "medicos.csv" y crea por cada linea un objeto de tipo
     * Medico, asignando cada valor de la linea a los atributos del medico y
     * agrega el objeto a la lista
     *
     * @throws IOException En caso de que no exista el archivo
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while (linea != null) {
                String[] campos = linea.split(separador);
                Medico m = new Medico();

                m.setDni(Integer.parseInt(campos[0]));
                m.setNombre(campos[1]);
                m.setApellido(campos[2]);
                m.setFechaNacimiento(campos[3]);
                m.setDomicilio(campos[4]);
                m.setTelFijo(Integer.parseInt(campos[5]));
                m.setTelCelular(campos[6]);
                m.setEstadoCivil(campos[7]);
                m.setCorreoElect(campos[8]);
                m.setTrabajaEn(new SectorTrabajo(campos[9]));
                m.setNMatricula(Integer.parseInt(campos[10]));
                m.setRolesSistema(new ArrayList<>());

                lista.add(m);
                linea = br.readLine();
            }
        } catch (Exception e) {

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
