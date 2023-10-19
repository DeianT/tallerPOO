package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 *
 * @author Deian
 */
public class FuncionarioDatos {
    private ArrayList<Funcionario> lista = new ArrayList();
    private final String archivo = "funcionarios.csv";
    private final String separador = ";";
    
    public FuncionarioDatos(){
        try {
            leerArchivo();
        } catch (IOException ex) {}
    }
    
    public boolean agregarFuncionario(Funcionario funcionario){
        try{
            obtenerFuncionario(funcionario.getDni());
            return false;
        }
        catch(Exception e){
            lista.add(funcionario);
            escribirArchivo();
            return true;
        }
    }
    
    public Funcionario obtenerFuncionario(int id) throws IOException{
        for(Funcionario fun: lista){
            if(fun.getDni() == id){
                return fun;
            }
        }
        throw new IOException("No existe funcionario con dni = " + id);
    }
    
    public ArrayList<Funcionario> obtenerFuncionarios(){
        return lista;
    }
    
    public boolean eliminarFuncionario(int id){
        try{
            Funcionario f = obtenerFuncionario(id);
            lista.remove(f);
            escribirArchivo();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public boolean editarFuncionario(Funcionario funcionario){
        try{
            Funcionario f = obtenerFuncionario(funcionario.getDni());
            f.setNombre(funcionario.getNombre());
            f.setApellido(funcionario.getApellido());
            f.setDomicilio(funcionario.getDomicilio());
            f.setFechaNacimiento(funcionario.getFechaNacimiento());
            f.setDomicilio(funcionario.getDomicilio());
            f.setTelFijo(funcionario.getTelFijo());
            f.setTelCelular(funcionario.getTelCelular());
            f.setEstadoCivil(funcionario.getEstadoCivil());
            f.setCorreoElect(funcionario.getCorreoElect());
            f.setTrabajaEn(funcionario.getTrabajaEn());
            f.setRolesSistema(funcionario.getRolesSistema());
        
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
            for(Funcionario f: lista){
                linea = f.getDni()+ separador;
                linea += f.getNombre() + separador;
                linea += f.getApellido() + separador;
                linea += f.getFechaNacimiento() + separador;
                linea += f.getDomicilio() + separador;
                linea += f.getTelFijo() + separador;
                linea += f.getTelCelular()+ separador;
                linea += f.getEstadoCivil() + separador;
                linea += f.getCorreoElect() + separador;
                linea += f.getTrabajaEn().getNombre();
                //guardar rolesSistema

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
                Funcionario f = new Funcionario();
                
                f.setDni(Integer.parseInt(campos[0]));
                f.setNombre(campos[1]);
                f.setApellido(campos[2]);
//                   perso.setFechaNacimiento(new Date(campos[3]));
                f.setDomicilio(campos[4]);
                f.setTelFijo(Integer.parseInt(campos[5]));
                f.setTelCelular(campos[6]);
                f.setEstadoCivil(campos[7]);
                f.setCorreoElect(campos[8]);
                f.setTrabajaEn(new SectorTrabajo(campos[9]));
                //obtener los roles del funcionario y asignarlos
                
                lista.add(f);
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