/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import ClaseLogicas.Paciente;
import ClaseLogicas.Persona;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class RegistroPacienteDatos {
    private ArrayList<Paciente> lista = new ArrayList();
    private final String archivo = "Pacientes.csv";
    private final String separador = ",";
    
    public Paciente capturar(JTextField dni ,JTextField nombre , JTextField apellido , JTextField fecha , JTextField domicilio ,JTextField tel , JTextField celular, JComboBox estado,JTextField correo )
    {
        Paciente pac = new Paciente();
        int DNI = Integer.parseInt(dni.getText()); 
        int telF = Integer.parseInt(tel.getText());
        String estadoo = String.valueOf(estado.getSelectedItem());
        pac.setDni(DNI);
        pac.setNombre(nombre.getText());
        pac.setApellido(apellido.getText());
        pac.setFechaNacimiento(fecha.getText());
        pac.setDomicilio(domicilio.getText());
        pac.setTelFijo(telF);
        pac.setTelCelular(celular.getText());
        pac.setEstadoCivil(estadoo);
        pac.setCorreoElect(correo.getText());
        
        return pac;
    }
    

    
    public RegistroPacienteDatos() throws IOException {
       //leerArchivoo();
    }
    
    public void agregarPaciente(Paciente p){
//        for (Persona pe: lista) {
//            System.out.println(pe.toString());
//        }
        lista.add(p);
//        System.out.println("agrager");
//        for (Persona pe: lista) {
//            System.out.println(pe.toString());
//        }
        escribirArchivo();
    }
    
    public Paciente obtenerPaciente(int id) throws IOException{
        Paciente perso = null;
        for(Paciente p: lista){
            if (p.getDni()==id){
                perso = p;
                break;//Corta el bucle cuando encuentra la persona
            }
        }
        if (perso != null)
            return perso;
        throw new IOException("La persona con dni = " + id + " no existe");

//        if(perso != null){
//            return perso;
//        }
//        try{
//            perso.getDni();
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        return perso;
    }
    
    public ArrayList<Paciente> obtenerPersonas(){
        return lista;
    }
    
    public boolean eliminarPaciente(int id){
        for(Persona p: lista){
            if (p.getDni() == id){
                lista.remove(p);
                return true;
            }
        }
        return false;
    }
    
    public void editarPersona(Paciente persona) throws IOException{
        Persona p = obtenerPaciente(persona.getDni());
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
        System.out.println("editar");
    }
    
    public void escribirArchivo () {        
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try
        {
            nuevo = new FileWriter(archivo,true);
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
    
    public void escribirArchivoo (ArrayList<Paciente> lista) {        
        FileWriter nuevo = null;
        PrintWriter pw = null;
        try
        {
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void leerArchivo (ArrayList<Paciente> lista) throws IOException {
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
                perso.setFechaNacimiento(campos[3]);
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


