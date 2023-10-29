package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Admision;

/**
 * Declaracion de la clase AdmisionDatos.
 */
public class AdmisionDatos {

    private ArrayList<Admision> lista = new ArrayList<>();
    private final String archivo = "admisiones.csv";
    private final String separador = ";";

    /**
     * Constructor de la clase. Lee las admisiones almacenadas en el archivo al
     * inicializar el objeto.
     */
    public AdmisionDatos() {
        try {
            leerArchivo();
        } catch (IOException ex) {
        }
    }

    /**
     * Agrega una nueva admisión a la lista y la guarda en el archivo. Asigna un
     * ID a la admisión y la almacena en la lista de admisiones.
     *
     * @param admision La admisión que se agregará.
     */
    public void agregarAdmision(Admision admision) {
        admision.setId(lista.size() + 1);
        lista.add(admision);
        escribirArchivo();
    }

    /**
     * Obtiene todas las admisiones almacenadas en la lista.
     *
     * @return Lista de todas las admisiones almacenadas.
     */
    public ArrayList<Admision> obtenerAdmisiones() {
        return lista;
    }

    /**
     * Obtiene las admisiones que aún no tienen un triaje asignado.
     *
     * @return Lista de las admisiones sin triaje.
     */
    public ArrayList<Admision> admisionesSinTriage() {
        ArrayList<Admision> p = new ArrayList<>();
        for (Admision a : lista) {
            if (a.getTriage() == null) {
                p.add(a);
            }
        }
        return p;
    }

    /**
     * Obtiene las admisiones que no tienen un box asignado después de pasar por
     * triaje.
     *
     * @return Lista de admisiones sin box asignado.
     */
    public ArrayList<Admision> admisionesSinBoxAsignado() {
        ArrayList<Admision> p = new ArrayList<>();
        for (Admision a : lista) {
            if (a.getTriage() != null && a.getBox() == null) {
                p.add(a);
            }
        }
        return p;
    }

    /**
     * Obtiene las admisiones que no han sido dadas de alta y ya tienen
     * asignados triaje y box.
     *
     * @return Lista de admisiones pendientes de dar de alta.
     */
    public ArrayList<Admision> admisionesNoDadasDeAlta() {
        ArrayList<Admision> p = new ArrayList<>();
        for (Admision a : lista) {
            if (a.getTriage() != null && a.getBox() != null && !a.isDadaDeAlta()) {
                p.add(a);
            }
        }
        return p;
    }

    /**
     * Edita una admisión existente en la lista, actualizando información como
     * triaje, box y estado de alta.
     *
     * @param admision La admisión con la información actualizada.
     * @return Retorna true si la edición se completó con éxito, de lo
     * contrario, false.
     */
    public boolean editarAdmision(Admision admision) {
        if (admision.getId() <= 0 || admision.getId() > lista.size()) {
            return false;
        }
        Admision a = lista.get(admision.getId() - 1);
        a.setTriage(admision.getTriage());
        a.setBox(admision.getBox());
        a.setDadaDeAlta(admision.isDadaDeAlta());
        escribirArchivo();
        return true;
    }

    /**
     * Escribe los datos de las admisiones a un archivo CSV, guardando la
     * información en disco. Utiliza un formato específico para almacenar cada
     * admisión y sus atributos. La información se extrae de la lista de
     * admisiones y se escribe en un archivo CSV.
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Admision a : lista) {
                linea = a.getId() + separador;
                linea += a.getFecha() + separador;
                linea += a.getHora() + separador;
                linea += a.getMotivo() + separador;
                linea += a.getPaciente().getDni() + separador;
                if (a.getTriage() != null) {
                    linea += a.getTriage().getId() + separador;
                } else {
                    linea += 0 + separador;
                }
                if (a.getBox() != null) {
                    linea += a.getBox().getNumero() + separador;
                } else {
                    linea += 0 + separador;
                }
                linea += a.isDadaDeAlta();

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
     * Lee un archivo CSV que contiene datos de admisiones y carga esta
     * información en la lista de admisiones. La información de cada línea del
     * archivo se asigna a los atributos de un objeto de tipo Admision. Los
     * datos del archivo se interpretan y se asignan a las propiedades
     * correspondientes del objeto Admision. Cada admisión se agrega a la lista
     * de admisiones para su posterior manipulación.
     *
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while (linea != null) {
                String[] campos = linea.split(separador);
                Admision ad = new Admision();

                ad.setId(Integer.parseInt(campos[0]));
                ad.setFecha(campos[1]);
                ad.setHora(campos[2]);
                ad.setMotivo(campos[3]);
                ad.setPaciente(new PacienteDatos().obtenerPaciente(Integer.parseInt(campos[4])));
                try {
                    ad.setTriage(new TriageDatos().obtenerTriage(Integer.parseInt(campos[5])));
                } catch (IOException e) {
                    ad.setTriage(null);
                }
                ad.setBox(new BoxDatos().obtenerBox(Integer.parseInt(campos[6])));
                ad.setDadaDeAlta(Boolean.parseBoolean(campos[7]));

                lista.add(ad);
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
