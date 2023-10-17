package sistemas.tallerpoo.datos;

import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Enfermero;

/**
 *
 * @author Deian
 */
public class EnfermeroDatos {
    private ArrayList<Enfermero> lista = new ArrayList<>();
    private final String archivo = "enfermeros.csv";
    private final String separador = ";";
    
    public EnfermeroDatos(){
        try{
            leerArchivo();
        }catch(Exception e){}
    }
    
    private void escribirArchivo(){
        //capaz que puedo usar datosfuncionarios
    }
    
    private void leerArchivo(){
        
    }
}
