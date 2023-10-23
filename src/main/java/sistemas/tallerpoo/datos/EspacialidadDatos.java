/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.datos;

import java.io.File;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Thiago
 */
public class EspacialidadDatos {
    
    public void agregarMedicosCbo(JComboBox cb , JLabel txt)
    {
        String [] datos;
        try(Scanner sc = new Scanner(new File("medicos.csv"))) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(";");
                cb.addItem(datos[0]);   
            }
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public void agregarAlLabel(JComboBox cb , JLabel txt)
    {
        String [] datos;
        try(Scanner sc = new Scanner(new File("medicos.csv"))) {
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(";");
                if(cb.getSelectedItem().toString().equals(datos[0]))
                {
                    txt.setText(datos[1]+" "+datos[2]);
                }
                  
            }
  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   
    
    
    
    
    
    
    
}
