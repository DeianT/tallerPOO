package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
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
        admision.setId(lista.size() + 1);
        lista.add(admision);
        escribirArchivo();
    }
    
    public ArrayList<Admision> obtenerAdmisiones(){
        return lista;
    }
    
    public ArrayList<Admision> admisionesSinTriage(){
        ArrayList<Admision> p = new ArrayList<>();
        for(Admision a: lista){
            if(a.getTriage() == null){
                p.add(a);
            }
        }
        return p;
    }
    
    public ArrayList<Admision> admisionesNoAtendidas(){
        ArrayList<Admision> p = new ArrayList<>();
        for(Admision a: lista){
            if(a.getTriage() != null && a.getBox() == null){
                p.add(a);
            }
        }
        return p;
    }
    
    public boolean editarAdmision(Admision admision){
        if(admision.getId() <= 0 || admision.getId() > lista.size())
            return false;
        Admision a = lista.get(admision.getId() - 1);
        a.setTriage(admision.getTriage());
        a.setBox(admision.getBox());
        escribirArchivo();
        return true;
    }
    
    private void escribirArchivo(){
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Admision a: lista){
                linea = a.getId() + separador;
                linea += a.getFecha() + separador;
                linea += a.getHora() + separador;
                linea += a.getMotivo() + separador;
                linea += a.getPaciente().getDni() + separador;
                if(a.getTriage() != null)
                    linea += a.getTriage().getId() + separador;
                else
                    linea += 0 + separador;
                if(a.getBox() != null)
                    linea += a.getBox().getNumero();
                else
                    linea += 0;
                
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
                
                ad.setId(Integer.parseInt(campos[0]));
//                ad.setFecha(fecha);
//                ad.setHora(fecha);
                ad.setFecha(new Date());
                ad.setHora(new Date());
                ad.setMotivo(campos[3]);
                ad.setPaciente(new PacienteDatos().obtenerPaciente(Integer.parseInt(campos[4])));
                try{
                    ad.setTriage(new TriageDatos().obtenerTriage(Integer.parseInt(campos[5])));
                }
                catch(IOException e){
                    ad.setTriage(null);
                }
                ad.setBox(new ListaBox().obtenerBox(Integer.parseInt(campos[6])));
                
                lista.add(ad);
                linea = br.readLine();
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(br != null){
                br.close();
            }
        }
    }
}