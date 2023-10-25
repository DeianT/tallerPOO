/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.Especialidad;
import sistemas.tallerpoo.clasesLogicas.Estudios;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 *
 * @author Thiago
 */
public class EspacialidadDatos {
    ArrayList<Especialidad> lista = new ArrayList();
    ArrayList<Estudios>  estudios = new ArrayList<>();
    
    public EspacialidadDatos()
    {
       leer();
    }

    
    public void llenarCombo(JComboBox cb , ArrayList<Medico> lista)
    {
        String [] datos;
        Medico m;
        try(Scanner sc = new Scanner(new File("medicos.csv"))) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(";");
                cb.addItem(datos[0]);
                
                m = new Medico();
                m.setDni(Integer.parseInt(datos[0]));
                m.setNombre(datos[1]);
                m.setApellido(datos[2]);
                m.setFechaNacimiento(new Date());
                m.setDomicilio(datos[4]);
                m.setTelFijo(Integer.parseInt(datos[5]));
                m.setTelCelular(datos[6]);
                m.setEstadoCivil(datos[7]);
                m.setCorreoElect(datos[8]);
                m.setTrabajaEn(new SectorTrabajo(datos[9]));
                m.setNMatricula(Integer.parseInt(datos[10]));
                m.setRolesSistema(new ArrayList<>());
                lista.add(m);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void mostrarNombre(JComboBox cb , JLabel txt, ArrayList<Medico> lista )
    {
        Medico m;
        for(int i =0 ; i<lista.size();i++)
        {
            m = lista.get(i);
            String dni = Integer.toString(m.getDni());
            if(dni.equals(cb.getSelectedItem().toString()))
            {              
                txt.setText(m.getNombre()+" "+m.getApellido());
            }
        } 
    }
   
    public void agregarEspecilidades(JComboBox cb, JList esp, String uni, String fecha)
    {

        File f = new File("./estudios.csv");
        try (FileWriter fw = new FileWriter(f,true))
         {
             fw.write(cb.getSelectedItem().toString()+","+esp.getSelectedValue().toString()+","+uni+","+fecha+"\n"); 
             
         } catch (Exception e) {
             System.out.println(e.getMessage());
        }
    }
    
    
 
    public Vector<String> mostrarEspecilidades(JComboBox cb, JList esp)
    {
        String[] datos;  
        Vector<String> lista = new Vector<>();
        try(Scanner sc = new Scanner(new File("./estudios.csv"))) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");
                if(cb.getSelectedItem().toString().equals(datos[0]))
                {
                      lista.add(datos[1]);  
                }

            }
            
            esp.setListData(lista);
            
        } catch (Exception e) {
        }
       return lista;
    }
    
    
    private void leer()
    {
        String[] datos;
        Estudios est;
        try (Scanner sc  = new Scanner(new File("estudios.csv"))){
            while(sc.hasNextLine())
            {
                datos=sc.nextLine().split(",");
                est = new Estudios(datos[0],datos[1],datos[2],datos[3]);
                estudios.add(est);
            }
            
        } catch (Exception e) {
        }
    }
    
    private void escribir()
    {
        try (FileWriter fw = new FileWriter(new File("estudios.csv"))){
            String linea;
            for(Estudios e: estudios)
            {
                linea = e.getDniMedico() + ",";
                linea+= e.getEspecialidad() + ",";
                linea+= e.getUniversidad() + ",";
                linea+= e.getFechaTitulo();
                fw.write(linea);
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Estudios obtenerEstudio(String id) throws IOException{
        for(Estudios est: estudios){
            if(est.getDniMedico().equals(id)){
                return est;
            }
        }
        throw new IOException("No existe Medico con dni = " + id);
    }
    
    public void eliminar(String dni) throws IOException
    {
        try {
            Estudios e = obtenerEstudio(dni);
            estudios.remove(e);
            escribir();
            
     
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    
    
    
    
    
    
   
   
    
 }
    
        

