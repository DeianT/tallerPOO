/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas.tallerpoo.datos;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import sistemas.tallerpoo.clasesLogicas.HistoriaClinica;
import sistemas.tallerpoo.clasesLogicas.Medico;
import sistemas.tallerpoo.clasesLogicas.Paciente;
import sistemas.tallerpoo.clasesLogicas.Triage;

/**
 *
 * @author Thiago
 */
public class GestorDatos {

 
      
      
      public void triagesPorFechas(String f1, String f2, JLabel Azul, JLabel Verde, JLabel Naranja,JLabel Amarillo,JLabel Rojo )
      {

          int rojo=0,naranja=0,amarillo=0,verde=0,azul=0;
          
          
            String[] desde = f1.split("/");
            String[] hasta = f2.split("/");
            int[] Desde = this.pasarArrayAInt(desde);
            int[] Hasta = this.pasarArrayAInt(hasta);
          
          for(Triage t: new TriageDatos().obtenerTriages())
          {
              
                String[] fechaH = t.getFecha().split("/");
                int[] fechaHist = this.pasarArrayAInt(fechaH);
                
                
                if(fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2] )
                {
                    if(fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1] )
                    {
                        if(fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0])
                        {
                            switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }   
                        }else if(fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0])
                        {
                            switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }
                        }
                    }else if(fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1])
                    {
                            switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }
                        
                    }
                }else if(fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2])
                {           
                    if(Desde[2] < Hasta[2] && fechaHist[2] == Desde[2])
                    {
                        if(fechaHist[1] == Desde[1])
                        {
                            
                            if(fechaHist[0] == Desde[0])
                            {
                              switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }   
                            }else if(fechaHist[0] > Desde[0])
                            {
                               switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            } 
                            }                           
                        }else if(fechaHist[1] > Desde[1])
                        {
                            switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }
                        }
                        
                    }else
                    {
                      switch(t.getColor().toString())
                            {
                                case "Rojo": 
                                    rojo++; 
                                    break;
                                case "Naranja":
                                    naranja++;
                                    break;
                                case "Amarillo":
                                    amarillo++;
                                    break;
                                case "Verde":
                                    verde++;
                                    break;
                                case "Azul": 
                                    azul++;
                                    break;
                            }    
                    }                        
                }
  
          }
          Rojo.setText(Integer.toString(rojo));
          Naranja.setText(Integer.toString(naranja));
          Amarillo.setText(Integer.toString(amarillo));
          Verde.setText(Integer.toString(verde));
          Azul.setText(Integer.toString(azul));
      }
      
      
      
      
    
    public void llenarCombo(JComboBox cb)
    {
        for(Medico p: new MedicoDatos().obtenerMedicos()){
            cb.addItem(String.valueOf(p.getDni()));
        }
    }
    
    
    public void mostrarNombresMedicos(JLabel txt , JComboBox cb)
    {
        for(Medico m: new MedicoDatos().obtenerMedicos())
        {
            if(cb.getSelectedItem().toString().equals(Integer.toString(m.getDni())))
            {
                txt.setText(m.getNombre().toUpperCase()+" "+m.getApellido().toUpperCase());
            }
        }
    }
    
    public void atencionPorFechas(String f1, String f2, JComboBox med, JLabel cantidad)
    {
        String[] desde = f1.split("/");
        String[] hasta = f2.split("/");
        int[] Desde = this.pasarArrayAInt(desde);
        int[] Hasta = this.pasarArrayAInt(hasta);
        
        int contador = 0;
        for(HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica())
        {
            
        
            String[] fechaH = h.getFecha().split("/");
            int[] fechaHist = this.pasarArrayAInt(fechaH);
            
            String dniMedico = Integer.toString(h.getDniMedico());



            if(med.getSelectedItem().toString().equals(dniMedico))
            {
                if(fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2] )
                {
                    if(fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1] )
                    {
                        if(fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0])
                        {
                            contador++;
                        }else if(fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0])
                        {
                            contador++;
                        }
                    }else if(fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1])
                    {
                            contador++;
                        
                    }
                }else if(fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2])
                {           
                    if(Desde[2] < Hasta[2] && fechaHist[2] == Desde[2])
                    {
                        if(fechaHist[1] == Desde[1])
                        {
                            
                            if(fechaHist[0] == Desde[0])
                            {
                              contador++;   
                            }else if(fechaHist[0] > Desde[0])
                            {
                               contador++; 
                            }                           
                        }else if(fechaHist[1] > Desde[1])
                        {
                            contador++;
                        }
                        
                    }else
                    {
                      contador++;    
                    }                        
                }
            }
        }
        String resultado = Integer.toString(contador);
        cantidad.setText(resultado);
    }
    
    
    private int[] pasarArrayAInt(String[] array)
    {
        int[] arr = new int[array.length];
        for(int i=0;i<array.length;i++)
        {
            arr[i]= Integer.parseInt(array[i]);
        }
        return arr;
    }
    
    
    public String atencionPorFechasYEdades(int edadDesde, int edadHasta,String f1, String f2)
    {
        String resultado="";
        int contador = 0;
        String[] dnis = dnisHistoriaClinica(); 
        String[] fechasNac = new String[dnis.length];

        for(Paciente p : new PacienteDatos().obtenerPacientes())
        {
            String dni = Integer.toString(p.getDni());
            for(int i = 0 ; i<dnis.length;i++)
           {
             if(dni.equals(dnis[i]))
             {
                 fechasNac[i]=p.getFechaNacimiento();
                 System.out.println(p.getFechaNacimiento());
             }
           }          
        }
        
        int i =0;
      for(HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica())
      {  
        
            
            int edad= this.obtenerEdad(fechasNac[i]);
            i++;
            System.out.println(edad+">="+edadDesde +"    "+ edad+"<="+edadHasta);
            System.out.println(edad >= edadDesde && edad<= edadHasta);
            if(edad >= edadDesde && edad<= edadHasta )
            {
                
                
                String[] desde = f1.split("/");
                String[] hasta = f2.split("/");
                int[] Desde = this.pasarArrayAInt(desde);
                int[] Hasta = this.pasarArrayAInt(hasta);
        
                
                
            
        
              String[] fechaH = h.getFecha().split("/");
              int[] fechaHist = this.pasarArrayAInt(fechaH);

           
                if(fechaHist[2] == Desde[2] && fechaHist[2] == Hasta[2] )
                {
                    if(fechaHist[1] == Desde[1] && fechaHist[1] == Hasta[1] )
                    {
                        if(fechaHist[0] == Desde[0] && fechaHist[0] == Hasta[0])
                        {
                            contador++;
                        }else if(fechaHist[0] >= Desde[0] && fechaHist[0] <= Hasta[0])
                        {
                            contador++;
                        }
                    }else if(fechaHist[1] >= Desde[1] && fechaHist[1] <= Hasta[1])
                    {
                            contador++;
                        
                    }
                }else if(fechaHist[2] >= Desde[2] && fechaHist[2] <= Hasta[2])
                {           
                    if(Desde[2] < Hasta[2] && fechaHist[2] == Desde[2])
                    {
                        if(fechaHist[1] == Desde[1])
                        {
                            
                            if(fechaHist[0] == Desde[0])
                            {
                              contador++;   
                            }else if(fechaHist[0] > Desde[0])
                            {
                               contador++; 
                            }                           
                        }else if(fechaHist[1] > Desde[1])
                        {
                            contador++;
                        }
                        
                    }else
                    {
                      contador++;    
                    }                        
                }
                resultado = Integer.toString(contador);
            
              }   
            }            
        return resultado;
     }   
       
    private String[] dnisHistoriaClinica()
    {
        ArrayList<String> dnis = new ArrayList<>();
       
        for(HistoriaClinica h : new HistoriaClinicaDatos().obtenerHistoriaClinica())
        {
            dnis.add( Integer.toString(h.getDniPaciente()));
        }
         String[] dni = new String[dnis.size()];
        
         for(int i = 0 ; i<dnis.size();i++)
         {
             dni[i] = dnis.get(i);
         }
        
        
        return dni;
    }
    
    private int obtenerEdad(String fechaNaci)
    {
       DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
       LocalDate fechaNac = LocalDate.parse(fechaNaci, fmt);
       LocalDate ahora = LocalDate.now();
       
       Period periodo = Period.between(fechaNac, ahora);
       int edad =periodo.getYears();
       
       return edad;     
    }
    
  

    
    
    
    
    
    
    
    
    
    
    
    
    
}
