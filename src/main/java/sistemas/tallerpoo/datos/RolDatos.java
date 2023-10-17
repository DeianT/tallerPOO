package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Rol;

/**
 *
 * @author Deian
 */
public class RolDatos {
    private ArrayList<Rol> lista = new ArrayList<>();
    private final String archivo = "roles.csv";
    private final String separador = ";";

    public RolDatos() {
        try{
            leerArchivo();
        }catch(Exception e){}
    }
    
    private void escribirArchivo(){
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Rol r: lista){
                linea = r.getNombre() + separador;
                linea += r.getDniFuncionario();
                
                pw.println(linea);
            }
        } 
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try {
                nuevo.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void leerArchivo() throws IOException{
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while(linea != null){
                String[] campos = linea.split(separador);
                Rol r = new Rol();
                
                r.setNombre(campos[0]);
                r.setDniFuncionario(Integer.parseInt(campos[1]));
                
                lista.add(r);
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