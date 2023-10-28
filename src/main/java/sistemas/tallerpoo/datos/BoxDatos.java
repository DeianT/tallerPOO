package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import sistemas.tallerpoo.clasesLogicas.Box;

/**
 *
 * @author Deian
 */
public class BoxDatos {
    private static final int CANTIDAD = 10;
    private static final Box[] boxes = new Box[CANTIDAD];
    private static boolean primeraInstancia = true;
    private final String archivo = "boxes.csv";
    private final String separador = ";";

    public BoxDatos() {
        if(primeraInstancia){
            primeraInstancia = false;
            for (int i = 0; i < boxes.length; i++) {
                boxes[i] = new Box(i + 1, null, null, false);
            }
            try {
                leerArchivo();
            } catch (IOException ex) {}
        }
    }
    
    public void ocuparDesocupar(int numeroBox, boolean ocupado){
        if(obtenerBox(numeroBox) == null)
            return;
        boxes[numeroBox - 1].setOcupado(ocupado);
        escribirArchivo();
    }
    
    public Box obtenerBox(int numero) {
        try{
            return boxes[numero - 1];
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }
    
    public int cantidad(){
        return CANTIDAD;
    }
    
    private void escribirArchivo(){
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Box b: boxes){
                linea = b.getNumero() + separador + b.isOcupado();
                
                pw.println(linea);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                nuevo.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    
    private void leerArchivo() throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            for(int i = 0; i < CANTIDAD; i++){
                String[] campos = linea.split(separador);
                Box b = boxes[i];
                
                b.setNumero(i + 1);
                b.setFecha(null);
                b.setHora(null);
                b.setOcupado(Boolean.parseBoolean(campos[1]));
                
                linea = br.readLine();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(br != null) {
                br.close();
            }
        }
    }
}