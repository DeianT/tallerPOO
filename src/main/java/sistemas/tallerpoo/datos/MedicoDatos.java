package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Rol;

/**
 *
 * @author Deian
 */
public class MedicoDatos {
    private ArrayList<Medico> lista = new ArrayList();
    private final String archivo = "medicos.csv";
    private final String separador = ";";
    
    public MedicoDatos(){
        try {
            leerArchivo();
        } catch (IOException ex) {}
    }
    
    public boolean agregarMedico(Medico medico){
        try{
            obtenerMedico(medico.getDni());
            return false;
        }
        catch(Exception e){
            lista.add(medico);
            escribirArchivo();
            return true;
        }
    }
    
    public Medico obtenerMedico(int id) throws IOException{
        for(Medico med: lista){
            if(med.getDni() == id){
                return med;
            }
        }
        throw new IOException("No existe Medico con dni = " + id);
    }
    
    public ArrayList<Medico> obtenerMedicos(){
        return lista;
    }
    
    public boolean eliminarMedico(int id){
        try{
            Medico f = obtenerMedico(id);
            lista.remove(f);
            escribirArchivo();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean editarMedico(Medico medico){
        try{
            Medico m = obtenerMedico(medico.getDni());
            m.setNombre(medico.getNombre());
            m.setApellido(medico.getApellido());
            m.setDomicilio(medico.getDomicilio());
            m.setFechaNacimiento(medico.getFechaNacimiento());
            m.setDomicilio(medico.getDomicilio());
            m.setTelFijo(medico.getTelFijo());
            m.setTelCelular(medico.getTelCelular());
            m.setEstadoCivil(medico.getEstadoCivil());
            m.setCorreoElect(medico.getCorreoElect());
            m.setNMatricula(medico.getNMatricula());
            m.setRolSistema(medico.getRolSistema());
        
            escribirArchivo();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    private void escribirArchivo(){
        FileWriter nuevo = null;
        PrintWriter pw = null;
        
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Medico m: lista){
                linea = m.getDni()+ separador;
                linea += m.getNombre() + separador;
                linea += m.getApellido() + separador;
                linea += m.getFechaNacimiento() + separador;
                linea += m.getDomicilio() + separador;
                linea += m.getTelFijo() + separador;
                linea += m.getTelCelular()+ separador;
                linea += m.getEstadoCivil() + separador;
                linea += m.getCorreoElect() + separador;
                linea += m.getNMatricula() + separador;
                if(m.getRolSistema() != null)
                    linea += m.getRolSistema().getNombre();
                else
                    linea += "null";

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

    private void leerArchivo() throws IOException {
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(archivo));
            String linea = br.readLine();
            while(linea != null){
                String[] campos = linea.split(separador);
                Medico m = new Medico();
                
                m.setDni(Integer.parseInt(campos[0]));
                m.setNombre(campos[1]);
                m.setApellido(campos[2]);
                m.setFechaNacimiento(new Date());
                m.setDomicilio(campos[4]);
                m.setTelFijo(Integer.parseInt(campos[5]));
                m.setTelCelular(campos[6]);
                m.setEstadoCivil(campos[7]);
                m.setCorreoElect(campos[8]);
                m.setNMatricula(Integer.parseInt(campos[9]));
                m.setRolSistema(new Rol(campos[10]));
                
                lista.add(m);
                linea = br.readLine();
            }
        }
        catch(Exception e){
            
        }
        finally{
            if(br != null) {
                br.close();
            }
        }
    }
}