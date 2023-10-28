package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 * Declaracion de la clase FuncionarioDatos
 *
 * @author Deian
 */
public class FuncionarioDatos {

    private ArrayList<Funcionario> lista = new ArrayList();
    private final String archivo = "funcionarios.csv";
    private final String separador = ";";

    /**
     * Constrcutor de la clase FuncionarioDatos
     */
    public FuncionarioDatos() {
        try {
            leerArchivo();
        } catch (IOException ex) {
        }
    }

    /**
     * Agrega un paciente a un ArrayList de Funcionario y luego escribe la lista
     * en el archivo "funcionarios.csv"
     *
     * @param funcionario Objeto Funcionario
     * @return Devuelve true cuando el funcionario se agrega con exito y
     * devuelve false si el funcionario que se quiere agregar ya existe en la
     * lista
     */
    public boolean agregarFuncionario(Funcionario funcionario) {
        try {
            obtenerFuncionario(funcionario.getDni());
            return false;
        } catch (Exception e) {
            lista.add(funcionario);
            escribirArchivo();
            return true;
        }
    }

    /**
     * Busca un funcionario por su DNI
     *
     * @param id DNI del funcionario
     * @return Devuelve el funcionario
     * @throws IOException Devuelve una excepcion en caso de que el DNI
     * ingresado no exista en la lista
     */
    public Funcionario obtenerFuncionario(int id) throws IOException {
        for (Funcionario fun : lista) {
            if (fun.getDni() == id) {
                return fun;
            }
        }
        throw new IOException("No existe funcionario con dni = " + id);
    }

    /**
     * Lista completa de todos los funcionarios
     *
     * @return Devuelve un ArrayList de Funcionario con todos los funcionarios
     * registrados
     */
    public ArrayList<Funcionario> obtenerFuncionarios() {
        return lista;
    }

    /**
     * Elimina un funcionario de la lista buscandolo por su DNI
     *
     * @param dni DNI del funcionario
     * @return Devuelve true cuando se elimino y escribio el archivo con exito y
     * devuelve false si se quiere eliminar a alguien que no esta registrado o
     * que el DNI ingresado es incorrecto
     */
    public boolean eliminarFuncionario(int dni) {
        try {
            Funcionario f = obtenerFuncionario(dni);
            lista.remove(f);
            escribirArchivo();
            new MedicoDatos().eliminarMedico(dni);
            new RolDatos().eliminarRolesFuncionario(dni);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Edita los datos de un funcionario
     *
     * @param funcionario Objeto funcionario
     * @return Devuelve true en caso de que se haya podido editar y escribir con
     * exito y devuelve false si no existe el medico ingresado
     */
    public boolean editarFuncionario(Funcionario funcionario) {
        try {
            Funcionario f = obtenerFuncionario(funcionario.getDni());
            f.setNombre(funcionario.getNombre());
            f.setApellido(funcionario.getApellido());
            f.setDomicilio(funcionario.getDomicilio());
            f.setFechaNacimiento(funcionario.getFechaNacimiento());
            f.setDomicilio(funcionario.getDomicilio());
            f.setTelFijo(funcionario.getTelFijo());
            f.setTelCelular(funcionario.getTelCelular());
            f.setEstadoCivil(funcionario.getEstadoCivil());
            f.setCorreoElect(funcionario.getCorreoElect());
            f.setTrabajaEn(funcionario.getTrabajaEn());
            f.setRolesSistema(funcionario.getRolesSistema());

            escribirArchivo();
            new MedicoDatos().editarMedico(funcionario);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Itera todos los elemento del ArrayList de Funcionario, concatena cada
     * atributo del objeto Funcionario en un String separado por "," y luego lo
     * escribe en el archivo "funcionarios.csv"
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;

        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Funcionario f : lista) {
                linea = f.getDni() + separador;
                linea += f.getNombre() + separador;
                linea += f.getApellido() + separador;
                linea += f.getFechaNacimiento() + separador;
                linea += f.getDomicilio() + separador;
                linea += f.getTelFijo() + separador;
                linea += f.getTelCelular() + separador;
                linea += f.getEstadoCivil() + separador;
                linea += f.getCorreoElect() + separador;
                if (f.getTrabajaEn() != null) {
                    linea += f.getTrabajaEn().getNombre();
                } else {
                    linea += null;
                }

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
     * Lee el archivo "funcionarios.csv" y crea por cada linea un objeto de tipo
     * Funcionario, asignando cada valor de la linea a los atributos del
     * funcionario y agrega el objeto a la lista
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
                Funcionario f = new Funcionario();

                f.setDni(Integer.parseInt(campos[0]));
                f.setNombre(campos[1]);
                f.setApellido(campos[2]);
                f.setFechaNacimiento(campos[3]);
                f.setDomicilio(campos[4]);
                f.setTelFijo(Integer.parseInt(campos[5]));
                f.setTelCelular(campos[6]);
                f.setEstadoCivil(campos[7]);
                f.setCorreoElect(campos[8]);
                f.setTrabajaEn(new SectorTrabajo(campos[9]));
                f.setRolesSistema(new ArrayList<>());

                lista.add(f);
                linea = br.readLine();
            }
        } catch (Exception e) {

        } finally {
            if (br != null) {
                br.close();
            }
        }
    }

    /**
     * Obtiene el texto de los JTextField y JComboBox, la fecha del JDateChooser
     * y se los asigna a cada uno de los atributos correspondiente del objeto
     * Funcionario
     *
     * @param dni DNI del funcionario
     * @param nombre Nombre del funcionario
     * @param apellido Apellido del funcionario
     * @param fecha Fecha de nacimiento del funcionario
     * @param domicilio Domicilio del funcionario
     * @param tel Numero de telefono del funcionario
     * @param celular Numero celular del funcionario
     * @param estado Estado civil del funcionario
     * @param correo Correo electronico del funcionario
     * @param sector Sector de trabajo del funcionario
     * @return Devuelve un objeto Funcionario con los valores pasados por
     * parametro
     */
    public Funcionario capturar(JTextField dni, JTextField nombre, JTextField apellido, JDateChooser fecha, JTextField domicilio, JTextField tel, JTextField celular, JComboBox estado, JTextField correo, JTextField sector) {
        Funcionario pac = new Funcionario();
        int DNI = Integer.parseInt(dni.getText());
        int telF = Integer.parseInt(tel.getText());
        SectorTrabajo sec = new SectorTrabajo();
        sec.setNombre(sector.getText());
        String estadoo = String.valueOf(estado.getSelectedItem());
        pac.setDni(DNI);
        pac.setNombre(nombre.getText());
        pac.setApellido(apellido.getText());
        String Fecha = ((JTextField) fecha.getDateEditor().getUiComponent()).getText();
        pac.setFechaNacimiento(Fecha);
        pac.setDomicilio(domicilio.getText());
        pac.setTelFijo(telF);
        pac.setTelCelular(celular.getText());
        pac.setEstadoCivil(estadoo);
        pac.setCorreoElect(correo.getText());
        pac.setTrabajaEn(sec);

        return pac;
    }
}