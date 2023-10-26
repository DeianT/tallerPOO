package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Funcionario;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Rol;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

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
            new FuncionarioDatos().agregarFuncionario(medico);
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
    
    public boolean eliminarMedico(int dni){
        try{
            Medico f = obtenerMedico(dni);
            lista.remove(f);
            escribirArchivo();
            new FuncionarioDatos().eliminarFuncionario(dni);
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
            m.setFechaNacimiento(medico.getFechaNacimiento());
            m.setDomicilio(medico.getDomicilio());
            m.setTelFijo(medico.getTelFijo());
            m.setTelCelular(medico.getTelCelular());
            m.setEstadoCivil(medico.getEstadoCivil());
            m.setCorreoElect(medico.getCorreoElect());
            m.setTrabajaEn(medico.getTrabajaEn());
            m.setRolesSistema(medico.getRolesSistema());
            m.setNMatricula(medico.getNMatricula());
        
            escribirArchivo();
            new FuncionarioDatos().editarFuncionario(medico);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean editarMedico(Funcionario funcionario){
        try{
            Medico m = obtenerMedico(funcionario.getDni());
            m.setNombre(funcionario.getNombre());
            m.setApellido(funcionario.getApellido());
            m.setFechaNacimiento(funcionario.getFechaNacimiento());
            m.setDomicilio(funcionario.getDomicilio());
            m.setTelFijo(funcionario.getTelFijo());
            m.setTelCelular(funcionario.getTelCelular());
            m.setEstadoCivil(funcionario.getEstadoCivil());
            m.setCorreoElect(funcionario.getCorreoElect());
            m.setTrabajaEn(funcionario.getTrabajaEn());
            m.setRolesSistema(funcionario.getRolesSistema());
        
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
                if(m.getTrabajaEn()!= null)
                    linea += m.getTrabajaEn().getNombre() + separador;
                else
                    linea += "null"  + separador;
                linea += m.getNMatricula();

                pw.println(linea);
                
//                new RolDatos().escribirArchivo()
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
                m.setFechaNacimiento(campos[3]);
                m.setDomicilio(campos[4]);
                m.setTelFijo(Integer.parseInt(campos[5]));
                m.setTelCelular(campos[6]);
                m.setEstadoCivil(campos[7]);
                m.setCorreoElect(campos[8]);
                m.setTrabajaEn(new SectorTrabajo(campos[9]));
                m.setNMatricula(Integer.parseInt(campos[10]));
                m.setRolesSistema(new ArrayList<>());
//                m.setRolesSistema(new RolDatos().obtenerRolesFuncionario(m.getDni()));
                
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