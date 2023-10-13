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
import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class RegistroPacienteDatos {
    
    
    public Paciente capturar(JTextField dni ,JTextField nombre , JTextField apellido , JTextField fecha , JTextField domicilio ,JTextField tel , JTextField celular, JComboBox estado,JTextField correo ,JTextField contacto )
    {
        Paciente pac = new Paciente();
        int DNI = Integer.parseInt(dni.getText()); 
        int telF = Integer.parseInt(tel.getText());
        String estadoo = String.valueOf(estado.getSelectedIndex());
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
    
    public Paciente registrarPaciente(JTextField dni ,JTextField nombre , JTextField apellido , JTextField fecha , JTextField domicilio ,JTextField tel , JTextField celular, JComboBox estado,JTextField correo ,JTextField contacto)
    {
        
        File f = new File("./Pacientes.csv");
        Paciente pac = this.capturar(dni, nombre, apellido, fecha, domicilio, tel, celular, estado, correo, contacto);
        try(FileWriter fw = new FileWriter(f,true))
        {
            fw.write(pac.toCSV());
            
            JOptionPane.showMessageDialog(null,"se registro con exito");
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"no se pudo registrar");
        }
        return pac;
    }
    
    
    public void limpiar(JTextField dni ,JTextField nombre , JTextField apellido , JTextField fecha , JTextField domicilio ,JTextField tel , JTextField celular, JComboBox estado,JTextField correo ,JTextField contacto)
    {
        dni.setText("");
        nombre.setText("");
        apellido.setText("");
        fecha.setText("");
        domicilio.setText("");
        tel.setText("");
        celular.setText("");
        estado.setSelectedIndex(0);
        correo.setText("");
    }
    
    
    
    public void leerArchivo (ArrayList<Paciente> lista) throws IOException {
        BufferedReader br = null;
        Paciente perso; 
      
        try {         
            br = new BufferedReader(new FileReader("./Pacientes.csv"));
            
            String linea = br.readLine();
            
            while (linea != null) {
                String [] campos = linea.split(",");
                
                perso = new Paciente(); //crea una persona por cada linea del .csv
                
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
    
    
    
    
    
}


