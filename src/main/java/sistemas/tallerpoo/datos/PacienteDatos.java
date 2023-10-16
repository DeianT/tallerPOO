package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import sistemas.tallerpoo.clasesLogicas.Paciente;

/**
 *
 * @author Thiago
 */
public class PacienteDatos {
    private ArrayList<Paciente> lista = new ArrayList();
    private final String archivo = "Pacientes.csv";
    private final String separador = ",";
    
    public Paciente capturar(JTextField dni, JTextField nombre, JTextField apellido, JTextField fecha, JTextField domicilio, JTextField tel, JTextField celular, JComboBox estado, JTextField correo)
    {
        Paciente pac = new Paciente();
        int DNI = Integer.parseInt(dni.getText()); 
        int telF = Integer.parseInt(tel.getText());
        String estadoo = String.valueOf(estado.getSelectedItem());
        pac.setDni(DNI);
        pac.setNombre(nombre.getText());
        pac.setApellido(apellido.getText());
//        pac.setFechaNacimiento(fecha.getText());
        pac.setFechaNacimiento(new Date());
        pac.setDomicilio(domicilio.getText());
        pac.setTelFijo(telF);
        pac.setTelCelular(celular.getText());
        pac.setEstadoCivil(estadoo);
        pac.setCorreoElect(correo.getText());
        
        return pac;
    }
    
    public PacienteDatos(){
        try {
            leerArchivo();
        } catch (IOException ex) {}
    }
    
    public boolean agregarPaciente(Paciente p){
        try{
            obtenerPaciente(p.getDni());
            return false;
        }
        catch(Exception e){
            lista.add(p);
            escribirArchivo();
            return false;
        }
    }
    
    public Paciente obtenerPaciente(int id) throws IOException{
        for(Paciente p: lista){
            if (p.getDni() == id){
                return p;//Retorna la persona si la encuentra
            }
        }
        throw new IOException("El paciente con dni = " + id + " no existe");//Si no la encuentra, arroja una excepción
    }
    
    public ArrayList<Paciente> obtenerPacientes(){
        return lista;
    }
    
    public boolean eliminarPaciente(int id){
        for(Paciente p: lista){
            if (p.getDni() == id){
                lista.remove(p);
                escribirArchivo();
                return true;
            }
        }
        return false;
    }
    
    public void editarPaciente(Paciente paciente) throws IOException{
        Paciente p = obtenerPaciente(paciente.getDni());
        p.setNombre(paciente.getNombre());
        p.setApellido(paciente.getApellido());
        p.setDomicilio(paciente.getDomicilio());
        p.setFechaNacimiento(paciente.getFechaNacimiento());
        p.setDomicilio(paciente.getDomicilio());
        p.setTelFijo(paciente.getTelFijo());
        p.setTelCelular(paciente.getTelCelular());
        p.setEstadoCivil(paciente.getEstadoCivil());
        p.setCorreoElect(paciente.getCorreoElect());
        p.setContacto(paciente.getContacto());
        
        escribirArchivo();
        System.out.println("editar");
    }
    
    private void escribirArchivo () {        
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try{
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Paciente p: lista){
                linea = p.getDni()+ separador;
                linea += p.getNombre() + separador;
                linea += p.getApellido() + separador;
                linea += p.getFechaNacimiento() + separador;
                linea += p.getDomicilio() + separador;
                linea += p.getTelFijo() + separador;
                linea += p.getTelCelular()+ separador;
                linea += p.getEstadoCivil() + separador;
                linea += p.getCorreoElect() + separador;
                //contacto

                pw.println(linea);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (nuevo != null)
              nuevo.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }   
    }
    
    public void leerArchivo () throws IOException {
        BufferedReader br = null;
        Paciente perso; 
      
        try {         
            br = new BufferedReader(new FileReader(archivo));
            
            String linea = br.readLine();
            
            while (linea != null) {
                String [] campos = linea.split(separador);
                
                perso = new Paciente(); //crea una persona por cada linea del .csv
                
                //Asigna cada valor de la linea a los atributos de la persona
                perso.setDni(Integer.parseInt(campos[0]));
                perso.setNombre(campos[1]);
                perso.setApellido(campos[2]);
//                perso.setFechaNacimiento(campos[3]);
                perso.setFechaNacimiento(new Date());
                perso.setDomicilio(campos[4]);
                perso.setTelFijo(Integer.parseInt(campos[5]));
                perso.setTelCelular(campos[6]);
                perso.setEstadoCivil(campos[7]);
                perso.setCorreoElect(campos[8]);
                //contacto
                
                lista.add(perso); //Agrega la persona creada a la lista
                linea = br.readLine();
            }            
        } catch (Exception e) {
         
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
    
    public void imprimirArchivo(){//Imprime el contenido de la lista, se usa para testeo
    System.out.println("cant" + this.lista.size());
        for (Paciente p: lista) {
            System.out.println(p.toString());
        }
    }
}