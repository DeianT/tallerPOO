package sistemas.tallerpoo.datos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sistemas.tallerpoo.clasesLogicas.Estudios;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 * Declaracion de la clase EspacialidadDatos.
 */
public class EspacialidadDatos {

    ArrayList<Estudios> estudios = new ArrayList<>();

    /**
     * Constructor de la clase. Lee los datos del archivo al inicializar la
     * clase.
     */
    public EspacialidadDatos() {
        leer();
    }

    /**
     * Llena un JComboBox con los médicos y sus detalles. Lee los datos de los
     * médicos desde un archivo CSV, agrega sus nombres al JComboBox y almacena
     * los detalles de cada médico en una lista.
     *
     * @param cb El JComboBox donde se cargarán los nombres de los médicos.
     * @param lista La lista donde se almacenan los detalles de los médicos.
     */
    public void llenarCombo(JComboBox cb, ArrayList<Medico> lista) {
        String[] datos;
        Medico m;
        try (Scanner sc = new Scanner(new File("medicos.csv"))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(";");
                cb.addItem(datos[0]);

                m = new Medico();
                m.setDni(Integer.parseInt(datos[0]));
                m.setNombre(datos[1]);
                m.setApellido(datos[2]);
                m.setFechaNacimiento(datos[3]);
                m.setDomicilio(datos[4]);
                m.setTelFijo(Integer.parseInt(datos[5]));
                m.setTelCelular(datos[6]);
                m.setEstadoCivil(datos[7]);
                m.setCorreoElect(datos[8]);
                m.setTrabajaEn(new SectorTrabajo(datos[9]));
                m.setNMatricula(Integer.parseInt(datos[10]));
                m.setRolesSistema(new ArrayList<>());
                lista.add(m);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    /**
     * Muestra el nombre completo del médico correspondiente al DNI seleccionado
     * en un JComboBox.
     *
     * @param cb El JComboBox que contiene los DNIs de los médicos.
     * @param txt El JLabel donde se mostrará el nombre completo del médico.
     * @param lista La lista de médicos donde se buscará el DNI seleccionado.
     */
    public void mostrarNombre(JComboBox cb, JLabel txt, ArrayList<Medico> lista) {
        Medico m;
        for (int i = 0; i < lista.size(); i++) {
            m = lista.get(i);
            String dni = Integer.toString(m.getDni());
            if (dni.equals(cb.getSelectedItem().toString())) {
                txt.setText(m.getNombre().toUpperCase() + " " + m.getApellido().toUpperCase());
            }
        }
    }

    /**
     * Agrega una especialidad a la lista de estudios médicos y escribe los
     * detalles en un archivo CSV.
     *
     * @param cb El JComboBox que contiene las especialidades disponibles.
     * @param esp El JTextField que contiene detalles adicionales sobre la
     * especialidad.
     * @param uni La universidad donde se obtuvo la especialidad.
     * @param fecha La fecha de obtención de la especialidad.
     */
    public void agregarEspecilidades(JComboBox cb, JTextField esp, String uni, String fecha) {
        Estudios es;

        File f = new File("./estudios.csv");
        try (FileWriter fw = new FileWriter(f, true)) {
            es = new Estudios(cb.getSelectedItem().toString(), esp.getText(), uni, fecha);
            estudios.add(es);
            escribir();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Elimina una especialidad de la lista de estudios médicos y actualiza el
     * archivo CSV correspondiente.
     *
     * @param cb El JComboBox que contiene los DNIs de los médicos.
     * @param espe El JList que muestra las especialidades del médico
     * seleccionado.
     */
    public void eliminarEspecialidad(JComboBox cb, JList espe) {
        for (int i = 0; i < estudios.size(); i++) {
            Estudios e = estudios.get(i);
            if (e.getDniMedico().equals(cb.getSelectedItem().toString())) {
                if (e.getEspecialidad().equals(espe.getSelectedValue().toString())) {
                    estudios.remove(e);
                    escribir();
                }
            }
        }
    }
    
    /**
     *  Elimina todas las especialidades asociadas a un médico
     * @param dni el dni del médico cuyas especialidades se desea eliminar
     */
    public void eliminarEspecialidadesMedico(int dni){
        ArrayList<Estudios> lista = new ArrayList<>();
        for(Estudios e: estudios){
            if(e.getDniMedico().equals(Integer.toString(dni))){
                lista.add(e);
            }
        }
        estudios.removeAll(lista);
        escribir();
    }

    /**
     * Muestra los detalles de una especialidad seleccionada del médico en el
     * JComboBox y JList.
     *
     * @param cb El JComboBox que contiene los DNIs de los médicos.
     * @param espe El JList que muestra las especialidades del médico
     * seleccionado.
     */
    public void mostrarDatos(JComboBox cb, JList espe) {
        for (int i = 0; i < estudios.size(); i++) {
            Estudios e = estudios.get(i);
            if (e.getDniMedico().equals(cb.getSelectedItem().toString())) {
                if (e.getEspecialidad().equals(espe.getSelectedValue().toString())) {
                    JOptionPane.showMessageDialog(null, "Recibido en: " + e.getUniversidad() + "\n" + "en la fecha: " + e.getFechaTitulo());
                }
            }
        }
    }

    /**
     * Muestra las especialidades del médico seleccionado en un JComboBox y
     * actualiza un JList con las mismas.
     *
     * @param cb El JComboBox que contiene los DNIs de los médicos.
     * @param esp El JList que mostrará las especialidades del médico
     * seleccionado.
     * @return Un vector que contiene las especialidades del médico
     * seleccionado.
     */
    public Vector<String> mostrarEspecilidades(JComboBox cb, JList esp) {
        String[] datos;
        Vector<String> lista = new Vector<>();
        try (Scanner sc = new Scanner(new File("./estudios.csv"))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                if (cb.getSelectedItem().toString().equals(datos[0])) {
                    lista.add(datos[1]);
                }

            }

            esp.setListData(lista);

        } catch (Exception e) {
        }
        return lista;
    }

    /**
     * Lee los datos de los estudios médicos desde el archivo "estudios.csv" y
     * los carga en la lista.
     */
    private void leer() {
        String[] datos;
        Estudios est;
        try (Scanner sc = new Scanner(new File("estudios.csv"))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                est = new Estudios(datos[0], datos[1], datos[2], datos[3]);
                estudios.add(est);
            }

        } catch (Exception e) {
        }
    }

    /**
     * Escribe los datos de los estudios médicos de la lista al archivo
     * "estudios.csv".
     */
    private void escribir() {
        try (FileWriter fw = new FileWriter(new File("estudios.csv"))) {
            String linea;
            for (Estudios e : estudios) {
                linea = e.getDniMedico() + ",";
                linea += e.getEspecialidad() + ",";
                linea += e.getUniversidad() + ",";
                linea += e.getFechaTitulo() + "\n";
                fw.write(linea);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Obtiene el estudio médico según el ID del médico proporcionado.
     *
     * @param id El ID del médico.
     * @return Un objeto de Estudios que coincide con el ID del médico.
     * @throws IOException Si no se encuentra un estudio médico para el ID
     * proporcionado.
     */
    public Estudios obtenerEstudio(String id) throws IOException {
        for (Estudios est : estudios) {
            if (est.getDniMedico().equals(id)) {
                return est;
            }
        }
        throw new IOException("No existe Medico con dni = " + id);
    }

    /**
     * Elimina el estudio médico para un ID de médico específico del archivo
     * "estudios.csv".
     *
     * @param dni El ID del médico.
     * @throws IOException Si no se encuentra un estudio médico para el ID
     * proporcionado.
     */
    public void eliminar(String dni) throws IOException {
        try {
            Estudios e = obtenerEstudio(dni);
            estudios.remove(e);
            escribir();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
