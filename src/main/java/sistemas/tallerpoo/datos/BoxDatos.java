package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import sistemas.tallerpoo.clasesLogicas.Box;

/**
 * Declaracion de la clase BoxDatos.
 */
public class BoxDatos {

    private static final int CANTIDAD = 10;
    private static final Box[] boxes = new Box[CANTIDAD];
    private static boolean primeraInstancia = true;
    private final String archivo = "boxes.csv";
    private final String separador = ";";

    /**
     * Constructor de la clase BoxDatos. Lee la información de los boxes desde
     * un archivo. Se inicializa con una instancia para cada box, y luego
     * intenta cargar la información desde el archivo.
     */
    public BoxDatos() {
        if (primeraInstancia) {
            primeraInstancia = false;
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = new Box(i + 1, null, null, false);
            }
            try {
                leerArchivo();
            } catch (IOException ex) {
            }
        }
    }

    /**
     * Método para marcar un box como ocupado o desocupado.
     *
     * @param numeroBox El número del box que se va a modificar.
     * @param ocupado Indica si el box está ocupado (true) o desocupado (false).
     */
    public void ocuparDesocupar(int numeroBox, boolean ocupado) {
        if (obtenerBox(numeroBox) == null) {
            return;
        }
        boxes[numeroBox - 1].setOcupado(ocupado);
        escribirArchivo();
    }

    /**
     * Obtiene un box a partir de su número.
     *
     * @param numero El número del box que se desea obtener.
     * @return La instancia del Box correspondiente al número indicado. En caso
     * de que el número esté fuera de rango, retorna null.
     */
    public Box obtenerBox(int numero) {
        try {
            return boxes[numero - 1];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * Obtiene la cantidad de boxes disponibles.
     *
     * @return La cantidad total de boxes disponibles.
     */
    public int cantidad() {
        return CANTIDAD;
    }

    /**
     * Escribe los datos de los boxes en un archivo. Recorre la lista de boxes y
     * escribe sus propiedades en el archivo especificado.
     */
    private void escribirArchivo() {
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for (Box b : boxes) {
                linea = b.getNumero() + separador + b.isOcupado();

                pw.println(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                nuevo.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee los datos del archivo para cargar la información de los boxes. Lee
     * los datos del archivo y asigna los valores correspondientes a los objetos
     * Box.
     *
     * @throws IOException si ocurre un error durante la lectura del archivo.
     */
    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            for (int i = 0; i < CANTIDAD; i++) {
                String[] campos = linea.split(separador);
                Box b = boxes[i];

                b.setNumero(i + 1);
                b.setFecha(null);
                b.setHora(null);
                b.setOcupado(Boolean.parseBoolean(campos[1]));

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
