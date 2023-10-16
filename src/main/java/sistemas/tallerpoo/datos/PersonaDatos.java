package sistemas.tallerpoo.datos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import sistemas.tallerpoo.clasesLogicas.Persona;

/**
 *
 * @author Deian
 */
public class PersonaDatos {
    private ArrayList<Persona> lista = new ArrayList();
    private final String archivo = "personas.csv";
    private final String separador = ";";

    public PersonaDatos(){
        try {
            leerArchivo();
        } catch (IOException ex) {}
    }
    
    public boolean agregarPersona(Persona p){
        try{
            obtenerPersona(p.getDni());
            return false;
        }
        catch(Exception e){
            lista.add(p);
            escribirArchivo();
            return true;
        }
    }
    
    public Persona obtenerPersona(int id) throws IOException{
        for(Persona p: lista){
            if (p.getDni() == id){
                return p;//Retorna la persona si la encuentra
            }
        }
        throw new IOException("La persona con dni = " + id + " no existe");//Si no la encuentra, arroja una excepción
    }
    
    public ArrayList<Persona> obtenerPersonas(){
        return lista;
    }
    
    public boolean eliminarPersona(int id){
        for(Persona p: lista){
            if (p.getDni() == id){
                lista.remove(p);
                escribirArchivo();
                return true;
            }
        }
        return false;
    }
    
    public void editarPersona(Persona persona) throws IOException{
        Persona p = obtenerPersona(persona.getDni());
        p.setNombre(persona.getNombre());
        p.setApellido(persona.getApellido());
        p.setDomicilio(persona.getDomicilio());
        p.setFechaNacimiento(persona.getFechaNacimiento());
        p.setDomicilio(persona.getDomicilio());
        p.setTelFijo(persona.getTelFijo());
        p.setTelCelular(persona.getTelCelular());
        p.setEstadoCivil(persona.getEstadoCivil());
        p.setCorreoElect(persona.getCorreoElect());
        
        escribirArchivo();
    }
    
    private void escribirArchivo () {        
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try
        {
            nuevo = new FileWriter(archivo);
            pw = new PrintWriter(nuevo);
            String linea;
            for(Persona p: lista){
                linea = p.getDni()+ separador;
                linea += p.getNombre() + separador;
                linea += p.getApellido() + separador;
                linea += p.getFechaNacimiento() + separador;
                linea += p.getDomicilio() + separador;
                linea += p.getTelFijo() + separador;
                linea += p.getTelCelular()+ separador;
                linea += p.getEstadoCivil() + separador;
                linea += p.getCorreoElect();

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
    private void leerArchivo () throws IOException {
        BufferedReader br = null;
        Persona perso; 
      
        try {         
            br = new BufferedReader(new FileReader(archivo));
            
            String linea = br.readLine();
            
            while (linea != null) {
                String [] campos = linea.split(separador);
                
                perso = new Persona(); //crea una persona por cada linea del .csv
                
                //Asigna cada valor de la linea a los atributos de la persona
                perso.setDni(Integer.parseInt(campos[0]));
                perso.setNombre(campos[1]);
                perso.setApellido(campos[2]);
//                perso.setFechaNacimiento(new Date(campos[3]));
                perso.setDomicilio(campos[4]);
                perso.setTelFijo(Integer.parseInt(campos[5]));
                perso.setTelCelular(campos[6]);
                perso.setEstadoCivil(campos[7]);
                perso.setCorreoElect(campos[8]);
                
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
        for (Persona p: lista) {
            System.out.println(p.toString());
        }
    }
}