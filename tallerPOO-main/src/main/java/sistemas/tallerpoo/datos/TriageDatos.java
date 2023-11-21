package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.NivelTriage;
import sistemas.tallerpoo.clasesLogicas.Triage;

/**
 * Declaracion de la clase TriageDatos.
 */
public class TriageDatos {

    private ArrayList<Triage> lista = new ArrayList();
    private static String archivo = "triages.csv";
    private static String separador = ";";

    /**
     * Constructor que inicializa la clase leyendo los triages desde el archivo.
     */
    public TriageDatos() {
        try {
            leerArchivo();
        } catch (IOException ex) {
        }
    }

    /**
     * Agrega un nuevo triage a la lista y lo persiste.
     *
     * @param triage El triage a ser agregado.
     */
    public void agregarTriage(Triage triage) {
        triage.setId(lista.size() + 1);
        lista.add(triage);
        escribirArchivo();
    }

    /**
     * Obtiene un triage a partir de su identificador.
     *
     * @param id El identificador del triage a obtener.
     * @return El triage correspondiente al identificador.
     * @throws IOException si no se encuentra un triage con el ID proporcionado.
     */
    public Triage obtenerTriage(int id) throws IOException {
        for (Triage t : lista) {
            if (t.getId() == id) {
                return t;
            }
        }
        throw new IOException("No existe Triage con id = " + id);
    }

    /**
     * Obtiene todos los triages existentes.
     *
     * @return ArrayList que contiene todos los triages.
     */
    public ArrayList<Triage> obtenerTriages() {
        return lista;
    }

    /**
     * Obtiene los triages que han sido modificados en comparación con su
     * versión original.
     *
     * @return ArrayList que contiene los triages modificados.
     */
    public ArrayList<Triage> obtenerTriagesModificados() {
        ArrayList<Triage> triages = new ArrayList<>();
        for (Triage t : lista) {
            if (t.getColor() != t.getColorModificado()) {
                triages.add(t);
            }
        }
        return triages;
    }

    /**
     * Obtiene la cantidad de triages almacenados.
     *
     * @return La cantidad total de triages almacenados.
     */
    public int cantidadTriage() {
        return lista.size();
    }

    /**
     * Escribe la información de los triages en un archivo.
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;

        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Triage t : lista) {
                linea = t.getId() + separador;
                linea += t.getColor() + separador;
                linea += t.getRespiracion() + separador;
                linea += t.getPulso() + separador;
                linea += t.getEstadoMental() + separador;
                linea += t.getConciencia() + separador;
                linea += t.getDificultadRespiratoria() + separador;
                linea += t.getLesionesGraves() + separador;
                linea += t.getEdad() + separador;
                linea += t.getFiebre() + separador;
                linea += t.getVomitos() + separador;
                linea += t.getDolorAbdominal() + separador;
                linea += t.getSignosDeShock() + separador;
                linea += t.getLesionesLeves() + separador;
                linea += t.getSangrado() + separador;
                linea += t.getFecha() + separador;
                linea += t.getHora() + separador;
                linea += t.getColorModificado() + separador;
                linea += t.getMotivoModificacion() + separador;
                linea += t.getDniEncargado();

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
     * Lee la información de triages desde un archivo y la almacena en la lista.
     *
     * @throws IOException si hay un error al leer el archivo.
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while (linea != null) {
                String[] campos = linea.split(separador);
                Triage t = new Triage();

                t.setId(Integer.parseInt(campos[0]));
                t.setColor(NivelTriage.valueOf(campos[1]));
                t.setRespiracion(campos[2]);
                t.setPulso(campos[3]);
                t.setEstadoMental(campos[4]);
                t.setConciencia(campos[5]);
                t.setDificultadRespiratoria(campos[6]);
                t.setLesionesGraves(campos[7]);
                t.setEdad(campos[8]);
                t.setFiebre(campos[9]);
                t.setVomitos(campos[10]);
                t.setDolorAbdominal(campos[11]);
                t.setSignosDeShock(campos[12]);
                t.setLesionesLeves(campos[13]);
                t.setSangrado(campos[14]);
                t.setFecha(campos[15]);
                t.setHora(campos[16]);
                t.setColorModificado(NivelTriage.valueOf(campos[17]));
                t.setMotivoModificacion(campos[18]);
                t.setDniEncargado(Integer.parseInt(campos[19]));

                lista.add(t);
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

    /**
     * Comprueba si el cambio de color de triage es válido.
     *
     * @param colores Array de colores permitidos.
     * @param color Color original a cambiar.
     * @param nuevoColor Nuevo color a asignar.
     * @return true si el cambio es válido, false en caso contrario.
     */
    public boolean cambioColor(String[] colores, String color, String nuevoColor) {
        int indiceColor = 0;
        int indiceNuevoColor = 0;
        int res = 0;

        for (int i = 0; i < colores.length; i++) {
            if (color.toLowerCase().equals(colores[i].toLowerCase())) {
                indiceColor = i;
            }
        }

        for (int i = 0; i < colores.length; i++) {
            if (nuevoColor.toLowerCase().equals(colores[i].toLowerCase())) {
                indiceNuevoColor = i;
            }
        }

        if (indiceColor > indiceNuevoColor) {
            res = indiceColor - indiceNuevoColor;
        } else {
            res = indiceNuevoColor - indiceColor;
        }

        if (res > 2) {
            return false;
        }
        return true;
    }
}
