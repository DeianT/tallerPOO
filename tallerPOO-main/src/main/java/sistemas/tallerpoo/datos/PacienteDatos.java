package sistemas.tallerpoo.datos;

import com.toedter.calendar.JDateChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import sistemas.tallerpoo.clasesLogicas.Paciente;

/**
 * Declaracion de la clase PacienteDatos
 *
 * @version 28/10/2023
 */
public class PacienteDatos {

    private ArrayList<Paciente> lista = new ArrayList();
    private final String archivo = "Pacientes.csv";
    private final String separador = ",";

    /**
     * Obtiene el texto de los JTextField y JComboBox, la fecha del JDateChooser
     * y se los asigna a cada uno de los atributos correspondiente del objeto
     * Paciente
     *
     * @param dni DNI del paciente
     * @param nombre Nombre del paciente
     * @param apellido Apellido del paciente
     * @param fecha Fecha de nacimiento del paciente
     * @param domicilio Domicilio del paciente
     * @param tel Numero de telefono del paciente
     * @param celular Numero celular del paciente
     * @param estado Estado civil del paciente
     * @param correo Correo electronico del paciente
     * @param contacto Contacto del Paciente
     * @return Devuelve un objeto paciente con los valores pasados por parametro
     */
    public Paciente capturar(JTextField dni, JTextField nombre, JTextField apellido, JDateChooser fecha, JTextField domicilio, JTextField tel, JTextField celular, JComboBox estado, JTextField correo, JTextField contacto) {
        Paciente pac = new Paciente();
        int DNI = Integer.parseInt(dni.getText());
        int telF = Integer.parseInt(tel.getText());
        String estadoo = String.valueOf(estado.getSelectedItem());

        String Fecha = ((JTextField) fecha.getDateEditor().getUiComponent()).getText();
        pac.setFechaNacimiento(Fecha);
        pac.setDni(DNI);
        pac.setNombre(nombre.getText());
        pac.setApellido(apellido.getText());
        pac.setDomicilio(domicilio.getText());
        pac.setTelFijo(telF);
        pac.setTelCelular(celular.getText());
        pac.setEstadoCivil(estadoo);
        pac.setCorreoElect(correo.getText());
        pac.setContacto(contacto.getText());

        return pac;
    }

    /**
     * Constructor de la clase PacienteDatos
     */
    public PacienteDatos() {
        try {
            leerArchivo();
        } catch (IOException ex) {
        }
    }

    /**
     * Agrega un paciente a un ArrayList de Paciente y luego escribe la lista en
     * el archivo "pacientes.csv"
     *
     * @param p Objeto paciente
     * @return Devuelve true cuando el paciente se agrega con exito y devuelve
     * false si el paciente que se quiere agregar ya existe en la lista
     */
    public boolean agregarPaciente(Paciente p) {
        try {
            obtenerPaciente(p.getDni());
            return false;
        } catch (Exception e) {
            lista.add(p);
            escribirArchivo();
            return true;
        }
    }

    /**
     * Busca un paciente por su DNI
     *
     * @param id DNI del paciente
     * @return Devuelve el paciente
     * @throws IOException Devuelve una excepcion en caso de que el DNI
     * ingresado no exista en la lista
     */
    public Paciente obtenerPaciente(int id) throws IOException {
        for (Paciente p : lista) {
            if (p.getDni() == id) {
                return p;
            }
        }
        throw new IOException("El paciente con dni = " + id + " no existe");//Si no la encuentra, arroja una excepción
    }

    /**
     * Lista completa de todos los pacientes
     *
     * @return Devuelve un ArrayList de Paciente con todos los pacientes
     * registrados
     */
    public ArrayList<Paciente> obtenerPacientes() {
        return lista;
    }

    /**
     * Elimina un pacientes de la lista buscandolo por su DNI
     *
     * @param id DNI del pacientes
     * @return Devuelve true cuando se elimino y escribio el archivo con exito y
     * devuelve false si se quiere eliminar a alguien que no esta registrado o
     * que el DNI ingresado es incorrecto
     */
    public boolean eliminarPaciente(int id) {
        for (Paciente p : lista) {
            if (p.getDni() == id) {
                lista.remove(p);
                escribirArchivo();
                return true;
            }
        }
        return false;
    }

    /**
     * Edita los datos de un paciente
     *
     * @param paciente Objeto paciente
     * @return Devuelve true en caso de que se haya podido editar y escribir con
     * exito y devuelve false si no existe el paciente ingresado
     * @throws IOException
     */
    public boolean editarPaciente(Paciente paciente) throws IOException {
        try {
            Paciente p = obtenerPaciente(paciente.getDni());
            p.setNombre(paciente.getNombre());
            p.setApellido(paciente.getApellido());
            p.setDomicilio(paciente.getDomicilio());
            p.setFechaNacimiento(paciente.getFechaNacimiento());
            p.setDomicilio(paciente.getDomicilio());
            p.setTelFijo(paciente.getTelFijo());
            p.setTelCelular(paciente.getTelCelular());
            p.setEstadoCivil(paciente.getEstadoCivil());
            p.setCorreoElect(paciente.getCorreoElect());
            p.setContacto(paciente.getContacto());

            escribirArchivo();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Itera todos los elemento del ArrayList de Paciente, concatena cada
     * atributo del objeto paciente en un String separado por "," y luego lo
     * escribe en el archivo "Pacientes.csv"
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Paciente p : lista) {
                linea = p.getDni() + separador;
                linea += p.getNombre() + separador;
                linea += p.getApellido() + separador;
                linea += p.getFechaNacimiento() + separador;
                linea += p.getDomicilio() + separador;
                linea += p.getTelFijo() + separador;
                linea += p.getTelCelular() + separador;
                linea += p.getEstadoCivil() + separador;
                linea += p.getCorreoElect() + separador;
                linea += p.getContacto();

                pw.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (nuevo != null) {
                    nuevo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * Lee el archivo "Pacientes.csv" y crea por cada linea un objeto de tipo
     * Paciente, asignando cada valor de la linea a los atributos del paciente y
     * agrega el objeto a la lista
     *
     * @throws IOException En caso de que no exista el archivo
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        Paciente perso;

        try {
            br = new BufferedReader(new FileReader(archivo));

            String linea = br.readLine();

            while (linea != null) {
                String[] campos = linea.split(separador);

                perso = new Paciente();
                perso.setDni(Integer.parseInt(campos[0]));
                perso.setNombre(campos[1]);
                perso.setApellido(campos[2]);
                perso.setFechaNacimiento(campos[3]);
                perso.setDomicilio(campos[4]);
                perso.setTelFijo(Integer.parseInt(campos[5]));
                perso.setTelCelular(campos[6]);
                perso.setEstadoCivil(campos[7]);
                perso.setCorreoElect(campos[8]);
                perso.setContacto(campos[9]);

                lista.add(perso);
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
