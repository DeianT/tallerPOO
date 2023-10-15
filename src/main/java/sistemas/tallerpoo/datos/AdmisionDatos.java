package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Admision;
import sistemas.tallerpoo.clasesLogicas.ListaBox;

/**
 *
 * @author Deian
 */
public class AdmisionDatos {
    private ArrayList<Admision> lista = new ArrayList<>();
    private final String archivo = "admisiones.csv";
    private final String separador = ";";
    
    public AdmisionDatos(){
        try{
            leerArchivo();
        }catch(IOException ex){}
    }
    
    public void agregarAdmision(Admision admision){
        lista.add(admision);
        escribirArchivo();
    }
    
    public ArrayList<Admision> obtenerAdmisiones(){
        return lista;
    }
    
    private void escribirArchivo(){
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Admision a: lista){
                linea = a.getFecha() + separador;
                linea += a.getHora() + separador;
                linea += a.getMotivo() + separador;
                linea += a.getPaciente().getDni() + separador;
                linea += a.getTriage().getId() + separador;
                linea += a.getBox().getNumero();
                
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
                Admision ad = new Admision();
                
//                ad.setFecha(fecha);
//                ad.setHora(fecha);
                ad.setMotivo(campos[2]);
//                ad.setPaciente(new PacienteDatos().obtenerPaciente(Integer.parseInt(campos[3])));
//                ad.setTriage(new TriageDatos().obtenerTriage(Integer.parseInt(campos[4])));
                ad.setBox(new ListaBox().obtenerBox(Integer.parseInt(campos[5])));
                
                lista.add(ad);
                linea = br.readLine();
            }
            
        }
        catch(Exception e){
            
        }
        finally{
            if(br != null){
                br.close();
            }
        }
    }
}