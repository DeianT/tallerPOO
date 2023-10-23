package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
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
    
    public boolean eliminarFuncionario(int dni){
        try{
            Funcionario f = obtenerFuncionario(dni);
            lista.remove(f);
            escribirArchivo();
            new MedicoDatos().eliminarMedico(dni);
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
            new MedicoDatos().editarMedico(funcionario);
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
                if (f.getTrabajaEn() != null)
                    linea += f.getTrabajaEn().getNombre();
                else
                    linea += null;
                //guardar rolesSistema, no acá sino en RolDatos cuando se actualizan los roles/usuarios de alguien

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
//                   f.setFechaNacimiento(new Date(campos[3]));
                f.setFechaNacimiento(new Date());
                f.setDomicilio(campos[4]);
                f.setTelFijo(Integer.parseInt(campos[5]));
                f.setTelCelular(campos[6]);
                f.setEstadoCivil(campos[7]);
                f.setCorreoElect(campos[8]);
                f.setTrabajaEn(new SectorTrabajo(campos[9]));
                f.setRolesSistema(new ArrayList<>());
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
    
    public Funcionario capturar(JTextField dni, JTextField nombre, JTextField apellido, JTextField fecha, JTextField domicilio, JTextField tel, JTextField celular, JComboBox estado, JTextField correo, JTextField sector)
    {
        Funcionario pac = new Funcionario();
        int DNI = Integer.parseInt(dni.getText()); 
        int telF = Integer.parseInt(tel.getText());
        SectorTrabajo sec = new SectorTrabajo();
        sec.setNombre(sector.getText());
        String estadoo = String.valueOf(estado.getSelectedItem());
        pac.setDni(DNI);
        pac.setNombre(nombre.getText());
        pac.setApellido(apellido.getText());
        //pac.setFechaNacimiento(fecha.getText().toString());
        pac.setFechaNacimiento(new Date());
        pac.setDomicilio(domicilio.getText());
        pac.setTelFijo(telF);
        pac.setTelCelular(celular.getText());
        pac.setEstadoCivil(estadoo);
        pac.setCorreoElect(correo.getText());
        pac.setTrabajaEn(sec);
        
        return pac;
    }
    
    
}