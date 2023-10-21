/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import sistemas.tallerpoo.clasesLogicas.Especialidad;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.SectorTrabajo;

/**
 *
 * @author Thiago
 */
public class EspacialidadDatos {
    ArrayList<Especialidad> lista = new ArrayList();
    
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
   
    public void agregarEspecilidades(JComboBox cb, JList esp)
    {

        File f = new File("./especialidades.csv");
        try (FileWriter fw = new FileWriter(f,true))
                {
                    if(comprobarExistencia(f,cb))
                    {
                        fw.append("-"+esp.getSelectedValue().toString());
                    }else
                    {
                       fw.write("\n"+cb.getSelectedItem().toString()+","+esp.getSelectedValue().toString()); 
                    }
  
  
        } catch (Exception e) {
        }
    }
    
    
    private boolean comprobarExistencia(File f, JComboBox cb)
    {
        boolean bandera = false;
        String[] datos;
        try(Scanner sc = new Scanner(f)) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");
                if(datos[0].equals(cb.getSelectedItem().toString()))
                {
                    bandera= true;
                }
            }
        } catch (Exception e) {
        }
        return bandera;
    }
    
    
    
    public Vector<String> mostrarEspecilidades(JComboBox cb, JList esp)
    {
        String[] datos;
        String[] especilidades;
        Vector<String> lista = new Vector<>();
        try(Scanner sc = new Scanner(new File("./especialidades.csv"))) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");
                if(cb.getSelectedItem().toString().equals(datos[0]))
                {
                  especilidades = datos[1].split("-");  
                  for(int i = 0 ; i<especilidades.length;i++)
                  {
                      lista.add(especilidades[i]);
                  }
                }

            }
            esp.setListData(lista);
            
        } catch (Exception e) {
        }
       return lista;
    }
    
    public void leer()
    {
        String[] datos;
        String[] especialidades;
        Especialidad esp;
        try (Scanner sc = new Scanner(new File("./especialidades.csv")))
        {
         while(sc.hasNextLine())
         {
             datos = sc.nextLine().split(",");
             especialidades = datos[1].split("-");
             esp = new Especialidad(datos[0], especialidades);
             lista.add(esp);
         }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void escribir()
    {
        String linea="";
        String[] esp=null;
        try (FileWriter fw = new FileWriter(new File("./especialidades.csv"))){
            for(Especialidad e : lista)
            {
                linea+= e.getDni()+",";
                esp = convertirArray(e.getDni().trim());
                for(int i =0 ; i< esp.length;i++)
                {
                    linea+=esp[i]+"-";
                }
                fw.write(linea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    private String[] convertirArray(String dni)
    {
        
        String[] datos;
        String[] especialidades=null;
        try (Scanner sc = new Scanner(new File("./especialidades.csv")))
        {
         while(sc.hasNextLine())
         {
             datos = sc.nextLine().split(",");
             if(dni.equals(datos[0]))
             {
               especialidades = datos[1].split("-");
             }
   
         }
    
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return especialidades;
        
    }
    
    
    public void agregar(Especialidad e)
    {
        lista.add(e);
        escribir();
    }
    
    
   
    
 }
    
        

