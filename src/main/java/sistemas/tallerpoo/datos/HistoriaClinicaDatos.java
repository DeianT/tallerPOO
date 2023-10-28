package sistemas.tallerpoo.datos;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sistemas.tallerpoo.clasesLogicas.HistoriaClinica;
import sistemas.tallerpoo.clasesLogicas.Paciente;

/**
 *
 * @author Thiago
 */
public class HistoriaClinicaDatos{
        
    HashSet<String> conjunto = new HashSet<>();
    ArrayList<HistoriaClinica> lista = new ArrayList<>();
    
    
    
    public void llenarComboBox(JComboBox cb) {
        String[] datos;
        try (Scanner sc = new Scanner(new File("historiaClinica.csv"))) {
            while (sc.hasNextLine()) {
                datos = sc.nextLine().split(",");
                HistoriaClinica h = new HistoriaClinica();
                h.setDniPaciente(Integer.parseInt(datos[0]));
                h.setFecha(datos[1]);
                h.setHora(datos[2]);
                h.setDiagnostico(datos[3]);
                h.setLugar(datos[4]);
                h.setDiagnosticoClinico(datos[5]);
                lista.add(h);
                if(conjunto.add(String.valueOf(h.getDniPaciente())))
                {
                    cb.addItem(h.getDniPaciente());
                }
            } 
        } catch (Exception e) {
            // Manejo de errores aquí
        }
    }
    
    public void llenarFechas(JComboBox cbDnis, JComboBox cbFechas)
    {
        cbFechas.removeAllItems();
        String[] datos;
        try (Scanner sc = new Scanner(new File("historiaClinica.csv"))){
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");
                HistoriaClinica h = new HistoriaClinica();
                h.setDniPaciente(Integer.parseInt(datos[0]));
                h.setDniMedico(Integer.parseInt(datos[1]));
                h.setFecha(datos[2]);
                h.setHora(datos[3]);
                h.setDiagnostico(datos[4]);
                h.setLugar(datos[5]);
                h.setDiagnosticoClinico(datos[6]);
                
                if(cbDnis.getSelectedItem().toString().equals(String.valueOf(h.getDniPaciente())))
                {
                    cbFechas.addItem(h.getFecha()+"  ---  "+h.getHora());
                }
            }
            
        } catch (Exception e) {
        }
    }
    
    public void mostrarNombre(JLabel txt, JComboBox cbDnis)
    {
        Paciente p;
        String[] datos;
        try (Scanner sc = new Scanner(new File("pacientes.csv"))){
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");               
                
                if(cbDnis.getSelectedItem().toString().equals(datos[0]))
                {
                    txt.setText(datos[1]+" "+datos[2]);
                }
                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void mostrarHistoriaClinica(JTextField lugarAtencion ,JTextField ResultadoEst,JTextField medico, JTextArea diagnostico, JComboBox cbDnis, JComboBox cbFechas)
    {
        String[] datos;
        try (Scanner sc = new Scanner(new File("historiaClinica.csv"))){
            while(sc.hasNextLine())
            {
                datos = sc.nextLine().split(",");
                
                String[] fecha = cbFechas.getSelectedItem().toString().split("---");
                
                if(cbDnis.getSelectedItem().toString().equals(datos[0]) && fecha[0].trim().equals(datos[2]))
                {
                    lugarAtencion.setText(datos[5]);
                    ResultadoEst.setText(datos[6]);
                    diagnostico.setText(datos[4]);
                    medico.setText(buscarMedico(datos[1]));
                }
                
            }
        } catch (Exception e) {
        }
    }
    
    private String buscarMedico(String dni)
    {       
        String nombre = "";
        try (Scanner sc = new Scanner(new File("medicos.csv"))){
            while(sc.hasNextLine())
            {
                String[] campos = sc.nextLine().split(";");
                
                if(dni.equals(campos[0]))
                {
                    nombre = campos[1] +" "+ campos[2];
                    return nombre;
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        } 
        return nombre;
    }

    public void agregarHistoriaClinica(HistoriaClinica h) {
        File f = new File("historiaClinica.csv");
        try (FileWriter fw = new FileWriter(f,true))
        {
            String linea = h.getDniPaciente() + ",";
            linea += h.getDniMedico()+ ",";
            linea += h.getFecha()+ ",";
            linea += h.getHora()+ ",";
            linea += h.getDiagnostico()+ ",";
            linea += h.getLugar()+ ",";
            linea += h.getDiagnosticoClinico()+ ",";
            fw.write(linea + "\n"); 
             
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<HistoriaClinica> obtenerHistoriaClinica()
    {
         String[] datos;
        try (Scanner sc = new Scanner(new File("historiaClinica.csv"))) 
        {
            while (sc.hasNextLine()) 
            {
                datos = sc.nextLine().split(",");
                HistoriaClinica h = new HistoriaClinica();
                h.setDniPaciente(Integer.parseInt(datos[0]));
                h.setDniMedico(Integer.parseInt(datos[1]));
                h.setFecha(datos[2]);
                h.setHora(datos[3]);
                h.setDiagnostico(datos[4]);
                h.setLugar(datos[5]);
                h.setDiagnosticoClinico(datos[6]);
                lista.add(h);
            }
        }catch(Exception e) {}
        return lista;
    }
}
